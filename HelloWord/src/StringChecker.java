
public class StringChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		  String str = "Would you like an apple pie withqthat?";
	        System.out.println("The string is: " + str);
	        System.out.println("Length of this string: "
	            + str.length());
	        System.out.println("The character at position 6: "
	            + str.charAt(6));
	        //����length�����⣬���������ַ�λ�õķ������Ǵ�0��ʼ0,1,2,,
	        System.out.println("The substring from 26 to 32: "
	            + str.substring(26, 32));
	        //substring(beginIndex,endIndex)��ʼ����������������������������
	        System.out.println("The index of the character a: "
	            + str.indexOf('a'));
	        //indexOf()�����Ƿ���ָ���ַ����ַ�����һ�γ��ֵ�λ�ã�������int��������Ҫ��ASCLL��ת��Ϊ�ַ�����index���Ǹ�����
	        System.out.println("The index of the character 1: "
		            + str.indexOf(97,16));
	        System.out.println("The index of the beginning of the "
	            + "substring \"apple\": " + str.indexOf("apple"));
	        System.out.println("The string in upper case: "
	            + str.toUpperCase());//���ַ���ȫ��ת��Ϊ��д��ĸ
	        int a = 12333;
	        System.out.format("%,d%n",a);
	        
	  

	}

}
