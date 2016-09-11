package leetcode;

//leetcode1的优化,不用写main函数，只要写构造函数和方法就行，输入它自己控制，只要通过他的测试用例就行
//yeah！Accepted！但是runtime99ms，不是很好的解
public class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
	public int sumRange(int i,int j ){
		if(i>j){
			System.out.println("Please input a correct number!");
			System.exit(1);
		}
		int sums = 0;
		for(int k=i; k<=j; k++){
			sums += nums[k];
		}
		return sums;
	}	
}
// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);