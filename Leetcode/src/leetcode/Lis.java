package leetcode;
import java.util.Arrays;
//��һά�����е�����������г��ȣ�LIS=����������У����Ӷ�O(N^2)���룬dp�㷨�����ԸĽ�ΪO(N*logN)
public class Lis {
	/**
	 * @param args
	 */
	public int lis(int[] l){
		int n = l.length;
		int[] h = new int[n];
		int res = h[0] = 1 ;
		//dp����ֵ��h��Ϊ��¼ÿһ��i���������е��ֵ
		for(int i=1;i<n;i++){
			h[i] = 1;//ÿһ��i��С���г���Ϊ1
			for(int j=i-1;j>=0;j--){//������Բ���ö�٣����ö��ּ��ٸ��Ӷ�
				
				if(l[i]>l[j])
					h[i] =Math.max(h[i], h[j]+1);				
			}
			res = Math.max(h[i],res);//	ȡһά�����е����ֵ
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Lis ex = new Lis();
		int[] a = {3,2};
		System.out.println(ex.lis(a));
		boolean[] b = new boolean[2];//�������boolean����Ĭ�ϸ���ֵfalse
		System.out.println(Arrays.toString(b));

	}

}
//ʱ�临�Ӷ�O(N*logN)���ַ��Ĵ���
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
