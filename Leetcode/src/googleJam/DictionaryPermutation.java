package googleJam;

import java.util.Arrays;
//全排列算法字典序法，排列为1~N的整数
public class DictionaryPermutation {

	/**
	 * @param args
	 */
	int[] array;
	public boolean hasnextP(){
		int n = array.length;
		int swapIndex1 = n-2;
		while(swapIndex1>=0 && array[swapIndex1]>=array[swapIndex1+1])
			swapIndex1--;
		if(swapIndex1 ==-1) 
			return false;
		else{
			int swapIndex2;
			for(swapIndex2 = n-1;swapIndex2>swapIndex1;swapIndex2--){
				if(array[swapIndex1]<=array[swapIndex2]){
					
					break;
				}
			}
			//swap
			int temp = array[swapIndex1];
			array[swapIndex1] = array[swapIndex2];
			array[swapIndex2] = temp;
			reverse(array,swapIndex1+1,n-1);
			return true;
		}
		
	}
	public void reverse(int[] array,int left,int right){
		for(int i=left,j=right;i<j;i++,j--){
			//swap
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] test = {1,2,3,4,5,6};
		DictionaryPermutation ex = new DictionaryPermutation();
		ex.array = test;
		Arrays.sort(ex.array);
		System.out.println(Arrays.toString(ex.array));
		int count = 0;
		while(ex.hasnextP()){
			System.out.println(Arrays.toString(ex.array));
			count++;
		}
		System.out.println(count);

	}

}
