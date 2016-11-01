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
		if(data[left]>=mid)//���ҲҪ���������Կ��Ų��ȶ��������ڻ�׼����ʱ
			swap(data,left,end);
		else
			left++;//�������Ԫ��С�ڻ�׼ʱֻ��һ����������ǻ�׼Ϊ���ֵ����������ȵģ����������һ�����ֵ��������
		quicksort(data,start,left-1);//һ�η���������λ��ȷ������׼������Ϊleft or right
		quicksort(data, left+1, end);
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a ={106,167,277,74,146,58,160,201,144,99,146,234,305,337,375,88,64,366,36,227,220,87,163,245,95,128,350,319,129,15,80,326,266,46,216,286,342,150,200,237,299,103,68,126,121,119,149,9,362,210,269,185,262,323,350,27,170,21,110,159,128,328,290,28,253,122,193,176,39,330,260,312,342,27,95,52,163,138,376,358};
		new QuickSort(a);
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);

	}

}
