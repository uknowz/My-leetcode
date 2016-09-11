package leetcode;
import java.util.Arrays;
//求一维数组中的最长递增子序列长度，LIS=最长递增子序列，复杂度O(N^2)代码，dp算法。可以改进为O(N*logN)
public class Lis {
	/**
	 * @param args
	 */
	public int lis(int[] l){
		int n = l.length;
		int[] h = new int[n];
		int res = h[0] = 1 ;
		//dp赋初值，h作为记录每一个i递增子序列的最长值
		for(int i=1;i<n;i++){
			h[i] = 1;//每一个i最小序列长度为1
			for(int j=i-1;j>=0;j--){//这里可以不用枚举，改用二分减少复杂度
				
				if(l[i]>l[j])
					h[i] =Math.max(h[i], h[j]+1);				
			}
			res = Math.max(h[i],res);//	取一维数组中的最大值
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Lis ex = new Lis();
		int[] a = {3,2};
		System.out.println(ex.lis(a));
		boolean[] b = new boolean[2];//定义对象boolean数组默认赋初值false
		System.out.println(Arrays.toString(b));

	}

}
//时间复杂度O(N*logN)二分法的代码
class Lis2{
	public static int[] lis2(int[] arr){
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		ends[0] = arr[0];
		dp[0] = 1;
		int right = 0;
		int l=0;int r = 0;int m = 0;
		for(int i=1;i<arr.length;i++){
			l=0;
			r=right;
			while(l<=r){
				m=(l+r)/2;
				if(arr[i]>ends[m]){
					l = m+1;
				}else{
					r = m-1;
				}
			}
			right = Math.max(right,l);
			ends[l] = arr[i];
			dp[i] = l+1;
		}
		return dp;
	}
}
