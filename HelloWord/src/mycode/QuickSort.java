package mycode;

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
		if(data[left]>mid)
			swap(data,left,end);
		else
			left++;
		quicksort(data,start,left-1);//一次分区后，中轴位置确定（基准），即为left or right
		quicksort(data, left+1, end);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a ={49,38,65,97,76,13,27,49,78,302};
		new QuickSort(a);
		System.out.println(Arrays.toString(a));

	}

}
