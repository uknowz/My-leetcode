
public class RangeLister {

	/**
	 * @param args
	 */
	int[] makeRange(int lower, int upper) {
        int[] range = new int[(upper-lower) + 1];

        for (int i = 0; i <range.length; i++) {
            range[i] = lower++;
        }
        return range;//返回数组不用加[]
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 int[] range;
	        RangeLister lister = new RangeLister();

	        range = lister.makeRange(4, 13);//给定义的数组赋值就不用指定长度
	        System.out.print("The array: [ ");
	        for (int i = 0; i < range.length; i++) {
	            System.out.print(range[i] + " ");
	        }//显示数组各元素的值
	        System.out.println("]");
	       // float a = 2.3f/2;

	}

}
