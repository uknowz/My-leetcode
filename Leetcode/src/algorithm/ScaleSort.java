package algorithm;
import java.util.*;
//���ڼ����ź�������飬����Ҫ������λ�ò�����k���øı��Ķ���
//time O(n*logk)
public class ScaleSort {
	
	public int[] sortElement(int[] A,int n,int k){
		int[] heap = new int[k];
		for(int i=0;i<k;i++){
			heap[i] = A[i];
		}
		buildHeap(heap,k);
		for(int i=0;i<n-k;i++){
			A[i] = heap[0];//��A�����������С������Сֵ�ó�
			heap[0] = A[i+k];//�������ڣ�����һ��Ԫ�ط�����ڵ㣬����k��С
			minHeapify(heap,0,k);
		}
		//������ͨ���ţ���βԪ�ؽ������Ƴ���ֵ
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
		int position = i;//����i���
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
		for(int i=heapsize/2-1;i>=0;i--){//�����һ�����ڵ㿪ʼ��ѻ�
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