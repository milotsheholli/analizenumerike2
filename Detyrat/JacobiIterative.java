public class JacobiIterative {

   static double[][] a = { { 10, -1, 2, 0 }, 
                    { -1, 11, -1, 3 }, 
                    { 2, -1, 10, -1 }, 
                    { 0, 3, -1, 8 } };
   static int n = a.length;
	static double[] x0 = new double[n];
	static double[] b = { 6, 25, -11, 15 };
	static int N = 8;
   static double[] x = new double[n];
	static double TOL = 0.001;

	public static void Jakobi(double[][] A, double[] B, double[] x0, double TOL, int N) {
		int k = 1;
		while (k <= N) {
			for (int i = 0; i < n; i++) {
				x[i] = (B[i] - shuma(i)) / A[i][i];
				if (Linfinit(x, x0) < TOL) {
					
					System.exit(0);
				}
            
            x0[i] = x[i];
				System.out.print(x[i] + "  ");
				if ((i + 1) % n == 0) {
					System.out.println();
				}
			}

		}
		k++;
	}

	public static double Linfinit(double[] A, double[] B) {
		double res = Math.abs(A[0] - B[0]);
		for (int i = 0; i < n; i++) {
			if (Math.abs(A[i] - B[i]) > Math.abs(res)) {
				res = Math.abs(A[i] - B[i]);
			}
		}
		return res;

	}

   public static double shuma(int A) {
   double shuma = 0; 
   for (int j = 0; j < n; j++) {
					if (j != A) {
						shuma += a[A][j] * x0[j];

					}
				}
   return shuma;   
   }
      
	public static void main(String[] args) {
		Jakobi(a, b, x0, TOL, N);
	}

}
