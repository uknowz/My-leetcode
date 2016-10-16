package algorithm;
//�ַ�������Ĵ������������
import java.util.Arrays;

public class Multiply {

	/**
	 * @param args��string��󳤶�65536��long��18λ��Զ������string��ʾ����
	 * nλ������mλ����������ý��Ϊn+mλ
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
		//temp�������ɷָ�ı���������������������������λ���;���
		int[][] temp = new int[m][n+m];
		//����ָ������������������,�Ӻ���ǰ����
		//2�������ѭ����һλ�˶�λ�໥����
		for(int in1 = m-1;in1>=0;in1--){
			carry = 0;
			mul = 0;
			sum = 0;
			k = 0;
			//1�����ѭ������С��ģ�������
			for(int in2 = n-1;in2>=0;in2--,k++){
				mul = (bb[in1]-'0')*(aa[in2]-'0');//��������˽��
				sum = mul + carry;//������һλ��λ�󣬸�λ�Ľ��
				carry = sum / 10;//��λ�Ľ�λ
				//������������������������ʾ�����˺þ��ҵ��Ĺ�ϵʽ��������һ��k��ʾ�˶�λ���ŵ�λ�ñ䶯
				temp[m-1-in1][n+in1-k] = sum % 10;//��λ�ĸ�λ����һλ��һλ�����λ
			}
			if(carry>0)//��ÿһ�����н�λ,��������Ӧ�ò���
				temp[m-1-in1][n+in1-k] = carry;		
		}
		return temp;		
	}
	//3�������ǽ���ͬ������ϲ�Ϊԭ����
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
	//���ַ�����ת��Ϊ��������
	public int translate(char c){
		return c-'0';
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new Multiply("999999999999999999", "999999999999999999");
	}

}
