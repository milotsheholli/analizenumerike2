public class GaussSeidelIterative {
   static int N = 5; static double TOL = 0.001; ; static int n = 4; 
	static double[][] a = {{ 10, -1, 2, 0 }, 
                         { -1, 11, -1, 3 },
                         { 2, -1, 10, -1 }, 
                         { 0, 3, -1, 8 }} ;
   static double[] b = { 6, 25, -11, 15 };
	static double x0[] = new double[n]; static double x[] = new double[n]; 	
	static int k = 1;
   
	public static void gausse(double[][] A, double[] B, int N, double TOL, double[] X) {
		while (k <= N) {
			for (int i = 0; i < A.length; i++) {
				x[i] = (B[i] - shuma1(A.length) - shuma2(A.length) ) / A[i][i];
				x0[i] = x[i];
				System.out.print(x[i] + "    ");

				if ((i+1)%A.length == 0) {
					System.out.println();
				}

			}
			k++;

		}

	}

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
   

	public static void main(String[] args) {
		
		gausse(a, b, N, TOL, x0);
	}

}
