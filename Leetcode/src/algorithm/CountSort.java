package algorithm;

import java.util.Arrays;

public class CountSort {

	/**
	 * @param args
	 */
	public void countsort(int[] a,int[] b,int k){	
		assert (k<0) :"断言问题";//断言
		int[] c = new int[k+1];
		int n = a.length;
		for(int i=0;i<n;i++){
			c[a[i]]++;
		}
		for(int j=1;j<k+1;j++){
			c[j] = c[j] + c[j-1]; 
		}
		for(int i=0;i<n;i++){
			b[c[a[i]]-1] = a[i];
			c[a[i]]--;
		}
	}
	public int[] countingSort(int[] A, int n) {
        // write code here
        int min = A[0];
        int max = A[0];
        //find range K
        for(int i=0;i<n;i++){
            min = Math.min(min,A[i]);
            max = Math.max(max,A[i]);
        }
        //c数组为计数数组，用来保存A[i]元素出现个数
        int[] c = new int[max-min+1];
        int[] b = new int[n];
        for(int i=0;i<n;i++){
            c[A[i]-min]++; 
        }
        for(int j=1;j<c.length;j++){
            c[j] = c[j-1] + c[j];
        }
        for(int i=n-1;i>=0;i--){
            b[c[A[i]-min]-1] = A[i];
            c[A[i]-min]--;
        }
        return b;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		CountSort ex = new CountSort();
		int[] a = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
		//int[] b = new int[a.length];
		//int k = 100;
		//ex.countsort(a, b, k);
		//System.out.println(Arrays.toString(b));
		int[] b = ex.countingSort(a, 14);
		System.out.println(Arrays.toString(b));
	}

}