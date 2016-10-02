package googleJam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
//�����Ŀ����Ҫ�����ҵ����ƥ�����ź�С���ŵ���ѧ��ϵ��1+2+3+������+n���Ȳ�����
public class SherlockandParentheses {

	/**
	 * @param args
	 */
	SherlockandParentheses(Scanner in){
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			int l = in.nextInt();
			int r = in.nextInt();
			System.out.println("Case #"+t+": " + balance(l, r));
		}
	}
	public long balance(int l,int r){
		long balsub = Math.min(l, r);
		long result = balsub*(balsub+1)>>1;//��large case��ʱ�򣬲�Ҫֻ����������������ȣ���Ҫ���Ǽ����Ľ������
		return result; //int����ת��long�������������ܳ���int
		
	}
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		String filename = "A-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("A-large-practice-out.txt")));		
		Scanner in = new Scanner(System.in);
		new SherlockandParentheses(in);
		in.close();

	}

}
