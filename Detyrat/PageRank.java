import javax.swing.*;
public class PageRank{
   
   static int rezultati = 0;
	static int Pikat = new Integer(JOptionPane.showInputDialog("Sa pika: ")).intValue();
	static int[][] vektori = new int[Pikat][Pikat];
	static double [][] vektoriFinal = new double[Pikat][Pikat];
   
   public static void main(String[] args){	
		int np = new Integer(JOptionPane.showInputDialog("Numri i lidhjeve mes pikave: ")).intValue();
		for(int i = 0;i<np;i ++){
			int p1 = new Integer(JOptionPane.showInputDialog("Lidhni piken:")).intValue();
			int p2 = new Integer(JOptionPane.showInputDialog("Me piken numer: ")).intValue();
			vektori[p1][p2]++;		
		}
		for(int i = 0;i<Pikat;i++){
			for(int j = 0;j<Pikat;j++){
         
         for(int c = 0;c<Pikat;c++){
			rezultati = rezultati + vektori[i][c]; }
         
				if(rezultati == 0){
					rezultati = 1;
				}
				vektoriFinal[i][j] = vektori[i][j]*(90.0/rezultati) + 2;
				System.out.print(vektoriFinal[i][j] + "      ");
				if(j == Pikat-1){
					System.out.println(); }   }
			}	
  }
}
