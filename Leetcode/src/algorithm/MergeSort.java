package algorithm;

import java.util.Arrays;
//�д���
public class MergeSort {

	/**
	 * @param args
	 */

	public MergeSort(int[] arry) {
		// TODO �Զ����ɵĹ��캯�����
	
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
		int k = start1;//�ڵݹ麯�����������⣬�ǹ���ʱ�Ĳ�����startΪ�ݹ����start1
		//������������ȡ����С�ķ���ϲ�����  
		while(start1<=end1 && start2<=end2){
			result[k++] = arry[start1]<arry[start2]?arry[start1++]:arry[start2++];
		}
		//ʣ�ಿ�����η���ϲ�����  
		while(start1<=end1){
			result[k++] = arry[start1++];
		}
		while(start2<=end2){
			result[k++] = arry[start2++];
		}
		//���ϲ������е����ݸ��ƻ�ԭ���� 
		for(k = start;k<=end;k++){
			arry[k] = result[k];
		}
			
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a ={49,38,65,97,76,13,27,49,78,32};
		new MergeSort(a);
		System.out.println(Arrays.toString(a));

	}

}
