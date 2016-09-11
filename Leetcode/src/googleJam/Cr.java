package googleJam;

import java.util.Scanner;

class Cr {
	public static int ans;
   public static void main(String[] args) {
   	Scanner in = new Scanner(System.in);
	    int testNum = in.nextInt();
	    for (int t = 0; t < testNum; t++) {
		    int M = in.nextInt();
		    int N = in.nextInt();
		    int[] K = new int[N];
		    int[] L = new int[N];
		    int[][] A = new int[N][20];
		    int[][] C = new int[N][20];
		    for (int i = 0; i < N; i++) {
		    	K[i] = in.nextInt();
		    	L[i] = in.nextInt();
		    	for (int j = 1; j <= K[i]; j++) {
		    		A[i][j] = in.nextInt();
		    	}
		    	for (int j = 1; j <= K[i] - 1; j++) {
		    		C[i][j] = in.nextInt();
		    	}
		    }
		    ans = 0;
	    	dfs(0, 0, M, N, K, L, A, C);
	    	System.out.println("Case #" + (t+1) + ": " + ans);
	    }
   }
   
   public static void dfs(int k, int w, int s, int N, int[] K, int[] L, int[][] A, int[][] C) {
       if (k == N) {
           ans = Math.max(ans, w);
           return;
       }
       dfs(k + 1, w + A[k][L[k]], s, N, K, L, A, C);
       int cost = 0;
       for (int i = L[k]; i < K[k]; ++ i) {
           cost += C[k][i];
           if (cost <= s) {
               dfs(k + 1, w + A[k][i + 1], s - cost, N, K, L, A, C);
           }
       }
   }
}