
public class EqualsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		        String str1, str2;
		        str1 = "Free the bound periodicals.";
		       // str2 = str1;
		        str2 = "Free the bound periodicals.";
		       

		        System.out.println("String1: " + str1);
		        System.out.println("String2: " + str2);
		        System.out.println("Same object? " + (str1 == str2));
		        System.out.println("Same value? " + str1.equals(str2));

		        str2 = new String();//����½�һ��String���󣬲�������Stringֵ���൱�ڽ���һ��������������
		        //str2 = new String(str1)��ֱ�Ӹ�String�ͱ�����ֵ��ֵ��ͬʱ��ͬһ������
		        str2 = "Free the bound periodicals.";//java�д�����ͬ�ַ���ʱ�����ص���ԭ����String���������ַ���str1��str2��ͬһ������

		        System.out.println("String1: " + str1);
		        System.out.println("String2: " + str2);
		        System.out.println("Same object? " + (str1 == str2));
		        System.out.println("Same value? " + str1.equals(str2));
		        
		    }
		


	

}
