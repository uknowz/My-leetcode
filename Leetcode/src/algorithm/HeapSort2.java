package algorithm;

import java.util.Arrays;

public class HeapSort2 {
//��һ�����������Ƚ�����
	/**
	 * @param args
	 */
	int[] a ;
	int heapSize ;
	HeapSort2(int[] a){
		this.a = a;
		heapSize = this.a.length;
		heapsort(this.a);
	}

	//��ѻ�
	public void maxHeapify(int[] data,int i){
		//int n = data.length;
		int position = i;//����i���
		int left = i*2+1;
		int right = i*2+2;
		if(left<heapSize && data[i]<data[left]){
			position = left;		
		}
		if(right<heapSize && data[position]<data[right])
			position = right;
		if(position!=i){
			int temp = data[i];
			data[i] = data[position];
			data[position] = temp;
			maxHeapify(data, position);
		}
	}
	public void buildHeap(int[] data){
		//int n = data.length;
		for(int i=heapSize/2-1;i>=0;i--){//�����һ�����ڵ㿪ʼ��ѻ�
			maxHeapify(data, i);
		}
	}
	public void heapsort(int[] data){
		//int n = data.length;
		buildHeap(data);//ֻ��Ҫ��һ������
		System.out.println("��ʼ����");
		for(int i=heapSize-1;i>0;i--){			
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			heapSize--;//ÿ��������Ҫ�����鳤�ȼ�һ
			System.out.println(Arrays.toString(data));
			maxHeapify(data, 0);//���潻����΢����ѻ�����
			
		}
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a = {49,38,65,97,76,13,27,49,78,3};
		new HeapSort2(a);

	}

}
