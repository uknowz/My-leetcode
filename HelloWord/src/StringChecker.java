
public class StringChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		  String str = "Would you like an apple pie withqthat?";
	        System.out.println("The string is: " + str);
	        System.out.println("Length of this string: "
	            + str.length());
	        System.out.println("The character at position 6: "
	            + str.charAt(6));
	        //除了length方法外，其他计算字符位置的方法都是从0开始0,1,2,,
	        System.out.println("The substring from 26 to 32: "
	            + str.substring(26, 32));
	        //substring(beginIndex,endIndex)开始处索引包括，结束处索引不包括
	        System.out.println("The index of the character a: "
	            + str.indexOf('a'));
	        //indexOf()方法是返回指定字符或字符串第一次出现的位置，给的是int型整数，要用ASCLL码转换为字符，但index这是个数字
	        System.out.println("The index of the character 1: "
		            + str.indexOf(97,16));
	        System.out.println("The index of the beginning of the "
	            + "substring \"apple\": " + str.indexOf("apple"));
	        System.out.println("The string in upper case: "
	            + str.toUpperCase());//将字符串全部转换为大写字母
	        int a = 12333;
	        System.out.format("%,d%n",a);
	        
	  

	}

}
