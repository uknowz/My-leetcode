package leetcode;

import java.util.Scanner;

public class Leetcode1 {

	/**
	 * @param args
	 */
	int[] nums;
	int sums = 0;
	public Leetcode1(int[] nums){
		//for(int i=0; i<nums.length; i++){
		this.nums = nums;
		
	}
	
	public int sumRange(int i,int j ){
		if(i>j){
			System.out.println("Please input a correct number!");
			System.exit(1);
		}
		for(int k=i; k<=j; k++){
			sums += nums[k];
		}
		return sums;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("Please input i and j");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		int j = scanner.nextInt();
		scanner.close();
		int[] inums = {-2,0,3,-5,2,-1};
		Leetcode1 example = new Leetcode1(inums);
		example.sums = example.sumRange(i, j);
		System.out.println("The sum of the elements between indices i and j:");
		System.out.println(example.sums);

	}

}
