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
	 * @param start,endΪ������ͷβָ�룬����������Ϊ1ʱ���ݹ����
	 * @param left,rightΪһ�η�����ͷβָ�룬
	 */
	void quicksort(int[] data,int start,int end){
		if(start >= end)
			return;//����Ϊ1�Ͳ����ٷ�����
		int left = start;
		int right = end -1;
		int mid = data[end];//���һ��Ϊ��׼
		//ѭ������һ�η������Ȼ�׼С�ķ���ǰ�棬��ķ���ǰ��
		while(left<right){
			while(left<right && data[left]<mid)
				left++;
			while(left<right && data[right]>=mid)
				right--;
			swap(data,left,right);//����������mid�����
		}
		if(data[left]>mid)
			swap(data,left,end);
		else
			left++;
		quicksort(data,start,left-1);//һ�η���������λ��ȷ������׼������Ϊleft or right
		quicksort(data, left+1, end);
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a ={49,38,65,97,76,13,27,49,78,302};
		new QuickSort(a);
		System.out.println(Arrays.toString(a));

	}

}
