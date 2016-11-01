package algorithm;

import java.util.Arrays;

public class HeapSort2 {
//��һ�����������Ƚ������������汾���ݹ�ռ临�Ӷ�O(logn)���ǵݹ�O(1)
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
	private  void swap(int[] data, int i, int j) {  
        // TODO Auto-generated method stub  
        int tmp=data[i];  
        data[i]=data[j];  
        data[j]=tmp;  
    } 

	//��ѻ��ݹ��
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
			swap(data,i,position);
			maxHeapify(data, position);
		}
	}
	//�ǵݹ��
	public void maxHeapify2(int[] data,int index){
		for(int i =index;i<heapSize;){
			int position = i;
			int left = i*2+1;
			int right = i*2+2;
			if(left<heapSize && data[left]>data[position])
				position = left;
			if(right<heapSize && data[right]>data[position])
				position = right;
			if(i==position)
				break;
			else{
				swap(data,i,position);
				i = position;
			}
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
			swap(data,0,i);
			heapSize--;//ÿ��������Ҫ�����鳤�ȼ�һ
			//System.out.println(Arrays.toString(data));
			maxHeapify(data, 0);//���潻����΢����ѻ�����
			
		}
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a = {54,35,48,36,27,12,44,44,8,14,26,17,28};
		new HeapSort2(a);
		System.out.println(Arrays.toString(a));

	}

}
