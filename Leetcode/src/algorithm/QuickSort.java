package algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {

	/**
	 * @param args
	 */
	int[] data;
	int size;
	QuickSort(int[] a){
		data = a;
		size = a.length;
		quicksort(data,0,size-1);
	}
	void swap(int[] data,int i,int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	/*
	 * @param start,end为分区的头尾指针，当分区长度为1时，递归结束
	 * @param left,right为一次分区的头尾指针，
	 */
	void quicksort(int[] data,int start,int end){
		if(start >= end)
			return;//长度为1就不用再分区了
		int left = start;
		int right = end -1;
		int mid = data[end];//最后一个为基准
		//循环进行一次分区，比基准小的放在前面，大的放在前面
		while(left<right){
			while(left<right && data[left]<mid)
				left++;
			while(left<right && data[right]>=mid)
				right--;
			swap(data,left,right);//交换两个比mid逆序的
		}
		if(data[left]>=mid)//相等也要交换，所以快排不稳定，发生在基准交换时
			swap(data,left,end);
		else
			left++;//当中轴的元素小于基准时只有一种情况，就是基准为最大值（可能有相等的），所以最后一个最大值无需排序
		quicksort(data,start,left-1);//一次分区后，中轴位置确定（基准），即为left or right
		quicksort(data, left+1, end);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a ={106,167,277,74,146,58,160,201,144,99,146,234,305,337,375,88,64,366,36,227,220,87,163,245,95,128,350,319,129,15,80,326,266,46,216,286,342,150,200,237,299,103,68,126,121,119,149,9,362,210,269,185,262,323,350,27,170,21,110,159,128,328,290,28,253,122,193,176,39,330,260,312,342,27,95,52,163,138,376,358};
		new QuickSort(a);
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);

	}

}