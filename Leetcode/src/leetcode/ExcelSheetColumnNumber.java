package leetcode;

public class ExcelSheetColumnNumber {

	/**
	 * @param args
	 */
	    public int titleToNumber(String s) {
	        int number = 0;//���ܺ͵ı���Ҫ��0��ʼ
	        int count = 1;//�������ı���Ҫ��1��ʼ
	        for(int i=s.length()-1;i>=0;i--){//���ţ�length()��һ�������������ŵģ���ô�������������أ�û���ŵ��Ǳ���
	            number = number + ((s.charAt(i)-'A'+1)*count);
	            count = count * 26;//����count = Math.pow(26,i);
	            
	        }
	        return number;
	    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
