package leetcode;

public class ExcelSheetColumnNumber {

	/**
	 * @param args
	 */
	    public int titleToNumber(String s) {
	        int number = 0;//做总和的变量要从0开始
	        int count = 1;//做乘数的变量要从1开始
	        for(int i=s.length()-1;i>=0;i--){//笨呐，length()是一个方法，有括号的，怎么可能忘了括号呢，没括号的是变量
	            number = number + ((s.charAt(i)-'A'+1)*count);
	            count = count * 26;//或者count = Math.pow(26,i);
	            
	        }
	        return number;
	    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
