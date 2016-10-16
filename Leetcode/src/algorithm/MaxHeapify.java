    package algorithm; 
    //这个算法是堆排序中建最大堆方法，不是完整堆排序代码
     
    /** 
     * MAX-HEAPIFY,《算法导论》第六章  
     * 算法导论原文： 
     * MAX-HEAPIFY is an important subroutine for manipulating max-heaps. Its inputs are an 
     * array A and an index i into the array. When MAX-HEAPIFY is called, it is assumed that the 
     * binary trees rooted at LEFT(i) and RIGHT(i) are max-heaps, but that A[i] may be smaller than 
     * its children, thus violating the max-heap property. The function of MAX-HEAPIFY is to let 
     * the value at A[i] "float down" in the max-heap so that the subtree rooted at index i becomes a 
     * max-heap. 
     * 伪代码： 
     * MAX-HEAPIFY(A, i)  
     * 1 l ← LEFT(i)  
     * 2 r ← RIGHT(i)  
     * 3 if l ≤ heap-size[A] and A[l] > A[i]  
     * 4 then largest ← l  
     * 5 else largest ← i  
     * 6 if r ≤ heap-size[A] and A[r] > A[largest]  
     * 7 then largest ← r  
     * 8 if largest ≠ i  
     * 9 then exchange A[i] ↔ A[largest] 10 MAX-HEAPIFY(A, largest) 
     * @author lihzh(苦逼coder) 
     * 本文地址：http://mushiqianmeng.blog.51cto.com/3970029/736717
     */ 
    public class MaxHeapify { 
     
        private static int[] input = new int[] { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 }; 
        private static int heapSize = input.length; 
     
        public static void main(String[] args) { 
            maxHeapify(input, 2);//此处，2对于二叉树中的索引值，对应数组中的4 
            //打印数组 
            printArray(); 
        } 
         
        /** 
         * MaxHeap，调整算法，前提是假设所有的子二叉树已经是max-heap。 
         * 复杂度： 
         * 因为：T (n) ≤ T(2n/3) + Θ(1) 
         * 所以有：  * T (n) = O(lgn) 
         * @param array 
         * @param index 
         */ 
        private static void maxHeapify(int[] array, int i) { //将index改成数组中的索引值
            int l = i * 2+1; 
            int r = l + 1; 
            int largest = i;
            if(l>=heapSize || r>=heapSize) return;//递归出口
            else{
            	//如果左叶子节点索引小于堆大小，比较当前值和左叶子节点的值，取值大的索引值 
            	if ( array[l] > array[i]) { 
                    largest = l; 
                } else { 
                    largest = i; 
                } 
                //如果右叶子节点索引小于堆大小，比较右叶子节点和之前比较得出的较大值，取大的索引值 
                if ( array[r] > array[largest]) { 
                    largest = r; 
                } 
                //交换位置，并继续递归调用该方法调整位置。 
                if (largest != i) { 
                    int temp = array[i]; 
                    array[i] = array[largest]; 
                    array[largest] = temp; 
                    maxHeapify(array,largest); 
                } 
            }            
        } 
         
        private static void printArray() { 
            for (int i : input) { 
                System.out.print(i + " "); 
            } 
        } 
     
    } 