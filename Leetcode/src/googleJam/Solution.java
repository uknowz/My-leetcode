package googleJam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		String filename = "A-small-attempt1.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("A-lyt.txt")));		
		Scanner in = new Scanner(System.in);
		new Solution().method(in);
		in.close();
    }
	public void method(Scanner in){
		//Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] N = new int[T];
		int[] Ts = new int[T];
		int[] Tf = new int[T];
		
		int[] result = new int[T];
		
		for(int i=0;i<T;i++){
			N[i] = in.nextInt();
			Ts[i] = in.nextInt();
			Tf[i] = in.nextInt();
			
			int[] S = new int[N[i]-1];
			int[] F = new int[N[i]-1];
			int[] D = new int[N[i]-1];
			
			for(int j=0;j<N[i]-1;j++){
				S[j] = in.nextInt();
				F[j] = in.nextInt();
				D[j] = in.nextInt();
			}
			
			result[i] = calculate(N[i], Ts[i], Tf[i], S, F, D, N[i]-2);
		}
		
		for(int i=0;i<T;i++){
			System.out.println("Case #" + (i+1) +": " + (result[i]>=0?result[i]:"IMPOSSIBLE"));
		}
	}
	public static int calculate(int N, int Ts, int Tf, int[] S, int[] F, int[] D, int i){
		if(i<0){
			return (Tf/Ts)>0?1:0;
		}
		
		//no sightseeing
		int x1 = Tf - S[i] - D[i];
		int n1 = -1;
		if(x1>=0){
			x1 = x1  / F[i];
			n1 = calculate(N, Ts, x1*F[i]+S[i], S, F, D, i-1);
		}
		
		//go sightseeing
		int x2 = Tf - S[i] - D[i] - Ts;
		int n2 = -1;
		if(x2>=0 && i<N-2){
			x2 = x2  / F[i];
			n2 = calculate(N, Ts, x2*F[i]+S[i], S, F, D, i-1);
			if(n2!=-1){
				n2++;
			}
		}
		
		return Math.max(n1, n2);
	}
}