import javax.swing.*;
public class Enkriptimi { 
   private static int[] kodi = new int[27]; 
   public static void main(String[] args) {
   System.out.println(ekriptimi("detyra"));
   translate();
   }
   
   public static String ekriptimi(String s) {
   String f = "";
    kodi[0] = 34;
    for ( int i = 1;  i != kodi.length;  i = i+1 )
        { kodi[i] = kodi[i-1]+2; }
        
    for ( int j = 0;  j != s.length();  j = j+1)
        { char c = s.charAt(j);
          if ( c == ' ' )
               { f = f+" "+ kodi[0]; }
          else if ( c >= 'a'  &&  c <= 'z' )
               { int index = (c - 'a') + 1;
                 f = f+" "+ kodi[index];
               }
        }
   return f;
   }
   
   
   public static void translate() {
    String answer = "";
    boolean processing = true;
    while ( processing )
          {  String input = JOptionPane.showInputDialog("Shtyp numrin, (ose asgje per te dal): ");
             if ( input.equals("") )
                  { processing = false; }
             else { char c = decode(kodi, new Integer(input).intValue());
                    answer = answer + c;
                  }
          }
    System.out.println(answer);
   }
   
   
  private static char decode(int[] code, int i)
  { char c = '*';
    boolean found = false;
    int index = 0;
    while ( !found  &&  index != code.length )
          { if ( code[index] == i )
                 { found = true;
                   if ( index == 0 )
                        { c = ' '; }
                   else { c = (char)(index + 'a' - 1); }
                 }
            else { index = index + 1; }
          }
    return c;
  }
}