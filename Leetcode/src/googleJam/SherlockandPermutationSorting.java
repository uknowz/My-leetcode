package googleJam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SherlockandPermutationSorting {

	/**
	 * @param args
	 */
	int[] array;
	public SherlockandPermutationSorting(Scanner in) {
		// TODO 自动生成的构造函数存根
		int T = in.nextInt();
		for(int t =1;t<=T;t++){
			int N = in.nextInt();
			int M = in.nextInt();
			int result = 0;
			array = new int[N];
			for(int i=0;i<N;i++){
				array[i] = i+1;
			}
			result = (result + maxChunk(array)^2 %M)%M;
			while(DictionaryPermutation()){
				result = (result + maxChunk(array)^2 %M)%M;
			}
			System.out.println("Case #"+t+": "+result);	
		}
	}
	public boolean DictionaryPermutation(){
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
	public int maxChunk(int[] a){
		int fp= a.length;
		int n = a.length;
		int imax = 0;
		for(int i=1;i<n;i++){
			if(a[i]>a[imax])
				imax = i;
			else
				fp -= 1;
		}
		return fp;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		//String filename = "D-small-practice.in";
		//System.setIn(new FileInputStream(filename));	
		//System.setOut(new PrintStream(new FileOutputStream("D-small-practice-out.txt")));
		Scanner in = new Scanner(System.in);
		new SherlockandPermutationSorting(in);
		in.close();

	}

}
