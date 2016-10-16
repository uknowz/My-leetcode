package algorithm;

import java.util.Arrays;

public class HeapSort2 {
//这一版三个函数比较清晰
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

	//大堆化
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
			int temp = data[i];
			data[i] = data[position];
			data[position] = temp;
			maxHeapify(data, position);
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
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			heapSize--;//每次排序需要将数组长度减一
			System.out.println(Arrays.toString(data));
			maxHeapify(data, 0);//后面交换后微调大堆化即可
			
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a = {49,38,65,97,76,13,27,49,78,3};
		new HeapSort2(a);

	}

}
