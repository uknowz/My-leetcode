package googleJam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class SherlockandWatsonGymSecrets {

	/**
	 * @param args
	 */
	SherlockandWatsonGymSecrets(Scanner in){
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			int A = in.nextInt();
			int B = in.nextInt();
			long N = in.nextLong();
			long K = in.nextLong();
			System.out.println("Case #"+t+": " + pairsNumber(A, B, N, K));
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		String filename = "B-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("B-large-practice-out.txt")));		
		Scanner in = new Scanner(System.in);
		new SherlockandWatsonGymSecrets(in);
		in.close();

	}
	public long pairsNumber(long a,long b,long n,long k){
		long pairs = 0;
		long mod = 1000000007l;
		long x = 0;
		long y = 0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				x = pow(i, a, k);
				y = pow(j, b, k);
				if((x+y)%k==0 && i!=j){//(a+b) mod c=(a mod c+ b mod c) mod c
					pairs++;
					pairs = pairs % mod;//每一次结果都取模
				}
			}
		}
		return pairs;
		
	}
	public long pow(long a,long b,long c){//快速幂模运算(a^b)mod c
		long ans = 1;
		while(b>0){
			a = a % c;
			if((b&1)!=0) ans = (ans*a)%c;
			a = (a*a)%c;
			b>>=1;
		}
		return ans % c;//return ans也可
	}

}
