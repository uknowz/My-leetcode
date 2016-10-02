package practise;

public class Chapter2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		float investment = 14000;
		System.out.println("初始投资：" + investment);
		investment += investment *  0.4F;
		investment -=  1500;
		investment += investment * 0.12F;
		System.out.println("三年后投资值：" + investment);

	}

}
