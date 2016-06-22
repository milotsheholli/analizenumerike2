import javax.swing.*;
public class UshtrimeVektor
{
   public void krijoVektor()
      {
        int c = new Integer(JOptionPane.showInputDialog("Sa elemente?")).intValue();    
        double[] vektori=new double[c];
      }

   public double[] mbushElementet(double[] vektori)
      {
      for(int i=0;i<vektori.length;i++)
         {
         vektori[i]=new Integer(JOptionPane.showInputDialog("Jep numrin e elementeve")).intValue();  
         }
      
      return vektori;
      }
      
   public double[] mbledhjaZbritja(String t, double[] a,double[] b)
      {
      double[] c=new double[a.length];
      if(a.length==b.length)
         {
         for(int i=0;i<=a.length;i++)
            {
            if (t.equals("mbledh"))
            { c[i]=a[i]+b[i]; }
            else { c[i]=a[i]-b[i]; } 
            }
         
         } 
     return c; 
      }
      
      public double l2Norma(double[] vektori)
         {
            double ans=0;
         for(int i=0;i<vektori.length;i++)
            {
               ans=ans+Math.pow(vektori[i],2);
            }
        ans=Math.sqrt(ans);
        return ans; }
        
        
       public double linfNorma(double[] vektori)
         {
            double max=Math.abs(vektori[0]);
            int i =0;
            while(i!= vektori.length)
            {
            if(Math.abs(max)>Math.abs(vektori[i]) )
            {}
            else { vektori[i] = max; } 
            }
         return max;
         } 


      public double FrobeniusNorma(double[][] matrica)
         {
         double ans=0;
         for(int i=0;i<matrica[0].length;i++)
            {
            for(int j=0;j<matrica.length;j++)
            { ans=ans+Math.pow(matrica[i][j],2);
             ans=Math.sqrt(ans);  }
            }
         return ans;
         }

}      
