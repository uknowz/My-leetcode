package algorithm;

import java.util.Arrays;
//有错误
public class MergeSort {

	/**
	 * @param args
	 */

	public MergeSort(int[] arry) {
		// TODO 自动生成的构造函数存根
	
		int[] result = new int[arry.length];
		mergesort(arry, result, 0, arry.length-1);
		
	}
	public void mergesort(int[] arry,int[] result,int start,int end){
		if(start>=end)
			return;
		int mid = (start + end)>>1;
		//int len = end - start; int mid = len/2 + start;
		int start1 = start;
		int end1 = mid;
		int start2 = mid+1;
		int end2 = end;
		mergesort(arry, result, start1, end1);
		mergesort(arry, result, start2, end2);
		int k = start1;//在递归函数后面解决问题，是归来时的操作，start为递归变量start1
		//从两个数组中取出最小的放入合并数组  
		while(start1<=end1 && start2<=end2){
			result[k++] = arry[start1]<arry[start2]?arry[start1++]:arry[start2++];
		}
		//剩余部分依次放入合并数组  
		while(start1<=end1){
			result[k++] = arry[start1++];
		}
		while(start2<=end2){
			result[k++] = arry[start2++];
		}
		//将合并数组中的内容复制回原数组 
		for(k = start;k<=end;k++){
			arry[k] = result[k];
		}
			
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a ={49,38,65,97,76,13,27,49,78,32};
		new MergeSort(a);
		System.out.println(Arrays.toString(a));

	}

}