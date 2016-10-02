package googleJam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
//�򵥵�dp�������θ��������Žṹ���ص������⣬ÿһ�α�����Ҫ����������θ�����������ĩβԪ�ر�������
public class SafeSquares {

	/**
	 * @param args
	 */
	SafeSquares(Scanner in){
		int T = in.nextInt();
		for(int t =1;t<=T;t++){
			int R = in.nextInt();
			int C = in.nextInt();
			int K = in.nextInt();
			int[][] grid = new int[R][C];
			for(int i=0;i<K;i++){
				int r = in.nextInt();
				int c = in.nextInt();
				grid[r][c] = 1;
			}
			long[][] dp = new long[R][C];
			long count = 0;
			for(int i=0;i<R;i++){
				for(int j=0;j<C;j++){
					if(i==0 || j==0){
						if(grid[i][j]==0)
							dp[i][j] = 1;
						else
							dp[i][j] = 0;
					}else{
						if(grid[i][j]==0)
							dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
					}
					count +=dp[i][j];	
				}
			}
			System.out.println("Case #"+t+": "+count);
			
			
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO �Զ����ɵķ������
		String filename = "B-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("B-large-practice-out.txt")));
		Scanner in = new Scanner(System.in);
		new SafeSquares(in);
		in.close();

	}

}
