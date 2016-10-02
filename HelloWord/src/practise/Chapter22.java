package practise;

public class Chapter22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		float a = 15, b = 6;
		float c = (a * 10 / b / 10 ), d =  (a  % b );//强制转换int型是舍弃小数,float型运算有精度丢失
		System.out.println("商\t余数");
		System.out.println(c + "\t" + d );
		

	}

}
