package algorithm;
//字符串输入的大整数相乘问题
import java.util.Arrays;

public class Multiply {

	/**
	 * @param args，string最大长度65536，long型18位，远可以用string表示大数
	 * n位整数和m位整数相乘所得结果为n+m位
	 */
	Multiply(String a,String b){
		int[] result = merge(multiply(a, b));
		System.out.println(Arrays.toString(result));
	}
	public int[][] multiply(String a,String b){
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		int n = a.length();
		int m = b.length();
		int carry=0;
		int mul;
		int sum;
		int k=0;
		//temp的行数由分割的被乘数决定，列数由两个乘数的位数和决定
		int[][] temp = new int[m][n+m];
		//两个指针用来两个乘数遍历,从后向前遍历
		//2、在这层循环上一位乘多位相互独立
		for(int in1 = m-1;in1>=0;in1--){
			carry = 0;
			mul = 0;
			sum = 0;
			k = 0;
			//1、这层循环上是小规模问题求解
			for(int in2 = n-1;in2>=0;in2--,k++){
				mul = (bb[in1]-'0')*(aa[in2]-'0');//两个数相乘结果
				sum = mul + carry;//加上上一位进位后，该位的结果
				carry = sum / 10;//该位的进位
				//行数和列数用两乘数索引表示，算了好久找到的关系式，列中用一个k表示乘多位数放的位置变动
				temp[m-1-in1][n+in1-k] = sum % 10;//该位的个位数，一位乘一位最多两位
			}
			if(carry>0)//对每一行仍有进位,所以列数应该不变
				temp[m-1-in1][n+in1-k] = carry;		
		}
		return temp;		
	}
	//3、这里是将相同子问题合并为原问题
	public int[] merge(int[][] temp){
		int n = temp.length;
		int m = temp[0].length;
		int[] result = new int[m];
		int carry = 0;
		int sum = 0;
		
		for(int j=m-1;j>=0;j--){
			int tem = 0;
			for(int i=0;i<n;i++){
				tem += temp[i][j];
			}
			sum = tem + carry;
			carry = sum/10;
			result[j] = sum%10;
		}
		
		return result;
	}
	//将字符数字转换为整形数字
	public int translate(char c){
		return c-'0';
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new Multiply("999999999999999999", "999999999999999999");
	}

}