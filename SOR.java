// Milot Sheholli
public class SOR {
	
	static int N = 10; static double TOL = 0.001; ; static int n = 3; static double w = 1.25;
	static double a[][] = new double[n][n]; static double b[]  = new double [n];
	static double x0[] = new double[n]; static double x[] = new double[n]; 	
	static int k = 1;
   
	public static double shuma1(int A){
		double shuma = 0;
		for(int j = 0;j<A;j++){
			for(int i = 0;i<A;i++){
				if(j!=i){
					shuma += a[i][j]*x[j];
				}
			}
		}
		return shuma;
	}

	public static double shuma2(int A){
		double shuma = 0;
		for(int i = A;i<n;i++){
			for(int j = A;j<n;j++){
				if(j!=i){
					shuma += a[i][j]*x0[j];
				}
			}
		}
		return shuma;
	}
	   public static double norma(double[] y, double[] x)
	    {
	        double max = 0;
	        for(int i=0;i<y.length;i++)
	        {   if(Math.abs(y[i] - x[i]) > max)
	            {
	                max = Math.abs(y[i] - x[i]);
	            }
	        }
	        return max;
	    }
       
  public static void main(String[] args) {
	double [] x0 = {1,1,1};
	double [][] a = {{2, 1, 0}, {7, 4, -1}, {2, -3, 4}};
   double [] b = {24,30,-24};
		while (k<=N){
			for(int i=0;i<n;i++){
				x[i] = (1-w)*x0[i]+ (w*(-shuma1(i) - shuma2(i)+b[i]))/a[i][i];
			}

			if(Math.abs(norma(x,x0))<TOL){
				for(int p = 0;p<n; p++){
					System.out.println("x[" + p + "] = " + x[p] );
				}
				System.exit(0);
			}
			
			k++;
			for(int i = 0;i<n;i++){
				x0[i] = x[i];
			}
		}
		System.out.println("Procedura perfundoi pa sukses");
	}

}

