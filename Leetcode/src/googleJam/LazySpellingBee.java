package googleJam;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
//修改
public class LazySpellingBee {
	ArrayList<Character> list = new ArrayList<>();//存放每一位A答案的字符可能的三种情况
	long[] count;//存放每一位的可能字符情况
	
	public LazySpellingBee(Scanner in) {
		while(in.hasNext()){
			int T = in.nextInt();
			@SuppressWarnings("unused")
			String dele = in.nextLine();
			for(int i=1;i<=T;i++){
				StringBuilder str = new StringBuilder(in.nextLine());//每一行读取字符串改成stringbuilder
				long out = spell(str);
				System.out.println("Case #"+i+": "+out);
			}						
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO 自动生成的方法存根
		
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
			for(int i=0;i<n;i++){//对每位str循环取值
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
					list.clear();//清空每一次放进链表里的元素
				}
			}
			for(int k=0;k<n;k++){//如果解small case 就不用 % mod 模数
				result = result * count[k] % mod;//由于输出数据过大，需要用模数来表示输出，选择的%M，必须是足够大的素数
			}
			return result;
		}
	}

}
