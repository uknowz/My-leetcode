package hihocoder;

import java.util.Scanner;

public class Aiix {

	/**
	 * @param args
	 */
	int x,m,k,c;
	Aiix(Scanner in){
		int T = in.nextInt();
		String dele = in.nextLine();
		String[] output = new String[T];
		for(int i=0; i<T; i++){
			int x = in.nextInt();
			long m = in.nextLong();
			int k = in.nextInt();
			int c=in.nextInt();
			output[i] = "Case #" + (i+1) + ":" + "\n" + method(x,m,k,c);
			
		}
		for(int j=0; j<T; j++){
			System.out.println(output[j]);
		}
	
	}
	
	
	public String method(int x,long m,int k,int c){
		int f = 0;
		int count = 1;
		for(long i=0; i<m;i++){
			f = f + x * count;
			count = count*10;
		}
		if(f % k == c){
			return "Yes";
		}else{
			return "No";
		}
		
		
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		Aiix ex = new Aiix(in);
	}

}
