package algorithm;
import java.util.*;
//对于几乎排好序的数组，且需要调整的位置不大于k，用改编后的堆排
//time O(n*logk)
public class ScaleSort {
	
	public int[] sortElement(int[] A,int n,int k){
		int[] heap = new int[k];
		for(int i=0;i<k;i++){
			heap[i] = A[i];
		}
		buildHeap(heap,k);
		for(int i=0;i<n-k;i++){
			A[i] = heap[0];//对A数组遍历，将小根堆最小值拿出
			heap[0] = A[i+k];//滑动窗口，将下一个元素放入根节点，保持k大小
			minHeapify(heap,0,k);
		}
		//进行普通堆排，首尾元素交换，推出最值
		for(int i=n-k;i<n;i++){
			A[i] = heap[0];
			swap(heap,0,k-1);
			k--;
			minHeapify(heap,0,k);
		}
		return A;
	}
    
    public void minHeapify(int[] data,int i,int heapsize){
		//int n = data.length;
		int position = i;//假设i最大
		int left = i*2+1;
		int right = i*2+2;
		if(left<heapsize && data[i]>data[left]){
			position = left;		
		}
		if(right<heapsize && data[position]>data[right])
			position = right;
		if(position!=i){
			swap(data,i,position);
			minHeapify(data, position,heapsize);
		}
	}
  
    private void swap(int[] data, int i, int j) {  
        // TODO Auto-generated method stub  
        int tmp=data[i];  
        data[i]=data[j];  
        data[j]=tmp;  
    }
    public void buildHeap(int[] data,int heapsize){
		//int n = data.length;
		for(int i=heapsize/2-1;i>=0;i--){//从最后一个父节点开始大堆化
			minHeapify(data, i,heapsize);
		}
	}
	public static void main(String[] args){
		ScaleSort ex = new ScaleSort();
		int[] a = {2,1,4,3,6,5,8,7,10,9};
		int k = 2;
		System.out.println(Arrays.toString(ex.sortElement(a, 10, k)));
	}
}