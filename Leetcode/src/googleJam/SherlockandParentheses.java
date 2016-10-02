package googleJam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
//这道题目最主要的是找到最大匹配括号和小括号的数学关系，1+2+3+···+n，等差数列
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
		long result = balsub*(balsub+1)>>1;//当large case的时候，不要只想着输入的整数长度，还要考虑计算后的结果长度
		return result; //int可以转换long，但计算结果可能超过int
		
	}
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		String filename = "A-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("A-large-practice-out.txt")));		
		Scanner in = new Scanner(System.in);
		new SherlockandParentheses(in);
		in.close();

	}

}
