/**
 * 
 */
package algorithm;

import java.util.Arrays;

/**
 * @author mingfang.z
 *
 * 2016-10-26
 */
public class ThreeColor {
	//����һ��ʹ�øı��Ķ����� time O(n) space O(1),ԭ�ؽ�������
	public int[] sortThreeColor(int[] A, int n) {
        // write code here
        int start = 0;
        int end = n-1;
        int current = 0;
        while(current<=end){//�Ⱥ���ȷ��endԪ���ܱ�������
            if(A[current]==0){
                swap(A,current,start);
                current++;
                start++;
            }
             
            else if(A[current]==1){
                current++;
            }
            else{
                swap(A,current,end--);
                //continue;
            }
        }
        return A;
    }
    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //ʹ�ü������� time O(n) space O(m)
    public int[] sortThreeColor2(int[] A, int n) {
        // write code here
        int min = A[0];
        int max = A[0];
        //find range K
        for(int i=0;i<n;i++){
            min = Math.min(min,A[i]);
            max = Math.max(max,A[i]);
        }
        int[] c = new int[max-min+1];
        int[] b = new int[n];
        for(int i=0;i<n;i++){
            c[A[i]-min]++;
        }
        //�Ż��󣬼�����b����
        int z = 0;
       	for(int i=0;i<c.length;i++){
            while(c[i]>0){
            	A[z++] = i+min;
                c[i]--;
        	}
        }
        
        return A;
    }
    public static void main(String args[]){
    	int[] a = {1,0,1};
    	int n = 3;
    	ThreeColor ex = new ThreeColor();
    	System.out.println(Arrays.toString(ex.sortThreeColor(a, n)));
    }
}
