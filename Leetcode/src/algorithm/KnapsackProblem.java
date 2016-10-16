package algorithm;
//0-1背包问题。时间和空间复杂度都是O(n*W)
public class KnapsackProblem {

	/**
	 * @param args
	 */
	public int dp_maxvalue(int[] v,int[] w,int n,int W){
		int[][] c = new int[n+1][W+1];
		for(int i=0;i<n+1;i++){
			for(int j=0;j<W+1;j++){
				if(i==0||j==0)
					c[i][j] = 0;//初始临界条件
				else{
					if(w[i-1]<=j){//wi<=w,j为背包负重（背包重量）
						c[i][j] = Math.max(v[i-1]+c[i-1][j-w[i-1]], c[i-1][j]);
					}else{
						c[i][j] = c[i-1][j];
					}					
				}				
			}
		}
		return c[n][W];
	}
	public static void main(String[] args) {
		//input:items value v={v1,v2,v3...vn};items weight w={w1,w2,w3...wn};
		//items number n; weight limit W
		int[] v = {60,100,120};
		int[] w = {10,20,30};
		int n = 3;
		int W = 50;
		KnapsackProblem ex = new KnapsackProblem();
		System.out.println(ex.dp_maxvalue(v, w, n, W));

	}

}
