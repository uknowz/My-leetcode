package practise;

import java.util.StringTokenizer;

public class Chapter3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String a = "MM/DD/YYYY";
		StringTokenizer str1 = new StringTokenizer(a,"/");
		System.out.println("���ո�ʽת��Ϊ�����ַ�����");
		if (str1.hasMoreTokens()){
		System.out.println(str1.nextToken());
		System.out.println(str1.nextToken());
		System.out.println( str1.nextToken());
		}
		
		

	}

}
