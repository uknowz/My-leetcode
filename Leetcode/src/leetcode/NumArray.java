package leetcode;

//leetcode1���Ż�,����дmain������ֻҪд���캯���ͷ������У��������Լ����ƣ�ֻҪͨ�����Ĳ�����������
//yeah��Accepted������runtime99ms�����ǺܺõĽ�
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