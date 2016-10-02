
public class EqualsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		        String str1, str2;
		        str1 = "Free the bound periodicals.";
		       // str2 = str1;
		        str2 = "Free the bound periodicals.";
		       

		        System.out.println("String1: " + str1);
		        System.out.println("String2: " + str2);
		        System.out.println("Same object? " + (str1 == str2));
		        System.out.println("Same value? " + str1.equals(str2));

		        str2 = new String();//如果新建一个String对象，参数仍是String值，相当于建立一个参数副本对象
		        //str2 = new String(str1)，直接给String型变量赋值，值相同时是同一个对象
		        str2 = "Free the bound periodicals.";//java中创建相同字符串时，返回的是原来的String对象，两个字符串str1和str2是同一个对象

		        System.out.println("String1: " + str1);
		        System.out.println("String2: " + str2);
		        System.out.println("Same object? " + (str1 == str2));
		        System.out.println("Same value? " + str1.equals(str2));
		        
		    }
		


	

}
