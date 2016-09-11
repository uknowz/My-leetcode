package googleJam;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
//�޸�
public class LazySpellingBee {
	ArrayList<Character> list = new ArrayList<>();//���ÿһλA�𰸵��ַ����ܵ��������
	long[] count;//���ÿһλ�Ŀ����ַ����
	
	public LazySpellingBee(Scanner in) {
		while(in.hasNext()){
			int T = in.nextInt();
			@SuppressWarnings("unused")
			String dele = in.nextLine();
			for(int i=1;i<=T;i++){
				StringBuilder str = new StringBuilder(in.nextLine());//ÿһ�ж�ȡ�ַ����ĳ�stringbuilder
				long out = spell(str);
				System.out.println("Case #"+i+": "+out);
			}						
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO �Զ����ɵķ������
		
		String filename = "A-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("A-large-practice-out.txt")));
		
		Scanner in = new Scanner(System.in);
		new LazySpellingBee(in);
		in.close();
	}
	public  long spell(StringBuilder str){
		long result = 1;
		long mod = 1000000007l;
		if(str.length()==1) return 1;		
		else{
			int n = str.length();
			count = new long[n];
			for(int i=0;i<n;i++){//��ÿλstrѭ��ȡֵ
				if(i==0){
					if(str.charAt(i)!=str.charAt(i+1)) count[i] = 2;
					else count[i] = 1;
				}else if(i==n-1){
					if(str.charAt(i)!=str.charAt(i-1)) count[i] = 2;
					else count[i] = 1;
				}else{
					for(int j=-1; j<2;j++){
						if(!list.contains(str.charAt(i+j))){
							list.add(str.charAt(i+j));
							count[i]++;
						}
					}
					list.clear();//���ÿһ�ηŽ��������Ԫ��
				}
			}
			for(int k=0;k<n;k++){//�����small case �Ͳ��� % mod ģ��
				result = result * count[k] % mod;//����������ݹ�����Ҫ��ģ������ʾ�����ѡ���%M���������㹻�������
			}
			return result;
		}
	}

}
