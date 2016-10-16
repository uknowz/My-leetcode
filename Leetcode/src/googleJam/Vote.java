package googleJam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Vote {

	/**
	 * @param args
	 */
	public Vote(Scanner in) {
		// TODO 自动生成的构造函数存根
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			double n = in.nextDouble();
			double m = in.nextDouble();
			double out = possiblity(n, m);
			System.out.println(String.format("Case #%d: %.8f", t,out));
		}
	}
	double possiblity(double n,double m){
		if(n<=m)
			return 0;
		else{
			return (n-m)/(n+m);
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO 自动生成的方法存根
		String filename = "A-large.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("A-large.txt")));		
		Scanner in = new Scanner(System.in);
		new Vote(in);
		in.close();

	}

}
