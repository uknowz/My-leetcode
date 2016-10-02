package practise;

public class Chapter32 {

	/**
	 * @param args
	 */
	int height,weight,depth;//实例变量，构造函数给对象赋初值就是用实例变量或数组
	 public Chapter32(int a, int b, int c) {
		 
		// TODO 自动生成的构造函数存根
		 height = a;
		 weight = b;
		 depth = c;
		
	}
		
	

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Chapter32 zmf = new Chapter32(160,92,3);
		/*zmf.weight = 92;
		zmf.depth=3;
		zmf.height = 160;
		*/
		System.out.println("height:" + zmf.height);
		System.out.println("weight:" + zmf.weight);
		System.out.println("depth:" + zmf.depth);
		
		
		

	}

}
