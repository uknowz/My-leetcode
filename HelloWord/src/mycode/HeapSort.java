package mycode;

import java.util.Arrays;  

public class HeapSort {  
    int[] a={49,38,65,97,76,13,27,49,78,3};  
    public  HeapSort(){  
       heapSort(a);  
    }
    public static void main(String[] args){
    	new HeapSort();
    }
  
    public  void heapSort(int[] a){  
        System.out.println("��ʼ����");  
        int arrayLength=a.length;  
        //ѭ������  
        for(int i=0;i<arrayLength-1;i++){  
            //����  
            buildMaxHeap(a,arrayLength-1-i);  
            //�����Ѷ������һ��Ԫ��  
            swap(a,0,arrayLength-1-i);  
            System.out.println(Arrays.toString(a));  
        }  
    }  
  
   
  
    private  void swap(int[] data, int i, int j) {  
        // TODO Auto-generated method stub  
        int tmp=data[i];  
        data[i]=data[j];  
        data[j]=tmp;  
    }  
  
    //��data�����0��lastIndex���󶥶�  
    private void buildMaxHeap(int[] data, int lastIndex) {  
        // TODO Auto-generated method stub  
        //��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ  
  
        for(int i=(lastIndex-1)/2;i>=0;i--){//��������  
            //k���������жϵĽڵ�  
            int k=i;  
            //�����ǰk�ڵ���ӽڵ����  
            while(k*2+1<=lastIndex){//��ѻ�  
                //k�ڵ�����ӽڵ������  
                int biggerIndex=2*k+1;  
                //���biggerIndexС��lastIndex����biggerIndex+1�����k�ڵ�����ӽڵ����  
                if(biggerIndex<lastIndex){  
                    //�������ӽڵ��ֵ�ϴ�  
                    if(data[biggerIndex]<data[biggerIndex+1]){  
                        //biggerIndex���Ǽ�¼�ϴ��ӽڵ������  
                        biggerIndex++;  
                    }  
                }  
  
                //���k�ڵ��ֵС����ϴ���ӽڵ��ֵ  
               if(data[k]<data[biggerIndex]){  
                    //��������  
                    swap(data,k,biggerIndex);  
                    //��biggerIndex����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵ�����������ӽڵ��ֵ,���´�ѻ�  
                    k=biggerIndex;  
                }else{  
                    break;  
                }  
            }  
        }  
    }  
} 
