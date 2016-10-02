package practise;

import java.util.StringTokenizer;

public class Chapter3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String a = "MM/DD/YYYY";
		StringTokenizer str1 = new StringTokenizer(a,"/");
		System.out.println("生日格式转换为三个字符串：");
		if (str1.hasMoreTokens()){
		System.out.println(str1.nextToken());
		System.out.println(str1.nextToken());
		System.out.println( str1.nextToken());
		}
		
		

	}

}
