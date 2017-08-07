package algorithm;

import java.util.Arrays;

public class HeapSort2 {
//这一版三个函数比较清晰，两个版本，递归空间复杂度O(logn)，非递归O(1)
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

	//大堆化递归版
	public void maxHeapify(int[] data,int i){
		//int n = data.length;
		int position = i;//假设i最大
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
	//非递归版
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
		for(int i=heapSize/2-1;i>=0;i--){//从最后一个父节点开始大堆化
			maxHeapify(data, i);
		}
	}
	public void heapsort(int[] data){
		//int n = data.length;
		buildHeap(data);//只需要建一次最大堆
		System.out.println("开始排序");
		for(int i=heapSize-1;i>0;i--){			
			swap(data,0,i);
			heapSize--;//每次排序需要将数组长度减一
			//System.out.println(Arrays.toString(data));
			maxHeapify(data, 0);//后面交换后微调大堆化即可
			
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a = {54,35,48,36,27,12,44,44,8,14,26,17,28};
		new HeapSort2(a);
		System.out.println(Arrays.toString(a));

	}

}