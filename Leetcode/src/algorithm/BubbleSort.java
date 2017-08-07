package algorithm;

import java.util.Arrays;

public class BubbleSort {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		int[] data = {49,38,65,97,76,13,27,49,78,3};
		int n = data.length;
		while(n>1){
			for(int i=0;i<n-1;i++){
				int j= i+1;
				int temp = data[i];
				if(temp>data[j]){
					data[i] = data[j];
					data[j] = temp;
				}				
			}
			n--;
		}
		System.out.println(Arrays.toString(data));
	}

}
