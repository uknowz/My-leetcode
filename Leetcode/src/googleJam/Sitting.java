package googleJam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
//
public class Sitting {

	/**
	 * @param args
	 * 别人的代码，把所有0位置，放在左斜线上，得到最大人数。
	 */
	Sitting(Scanner sc){
		int T = sc.nextInt();
		int n,m;
		int result;
		for(int i = 1;i<=T;i++){
			n = sc.nextInt();
			m = sc.nextInt();
			if(n<=2 && m<=2){
				result = n*m;
				System.out.println("Case #"+i+": "+result);
				continue;
			}
			if(n<=2 || m<=2){//有行或列小于等于2的情况
				int l = Math.max(n, m);
				//int l2 = m+n-l;
				int l2 = Math.min(m, n);
				result = l2*(l-l/3);//result = l2*(l/3*2+l%3)
				System.out.println("Case #"+i+": "+result);
				continue;
			}
			result = 0;
			for(int k = 1; k<=n; k++)
			for(int j = 1; j<=m; j++)
			{
				//if((k+j-1)%3!=0) result++;//why?
				if((k+j-1)%3==0) result++;
			}
			 System.out.println("Case #"+i+": "+ (n*m-result));
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO 自动生成的方法存根
		String filename = "B-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("B-large-practice-out.txt")));		
		Scanner in = new Scanner(System.in);
		new Sitting(in);
		in.close();

	}

}
/*wrong code
 * 方法是遍历每行每列，用两个数组来记录一行一列中每三个是否
 */
class sitting2{
	sitting2(Scanner in){
		int T = in.nextInt();
		for(int t =1;t<=T;t++){
			int r = in.nextInt();
			int c = in.nextInt();
			int out = maxNum(r, c);
			System.out.println("Case #"+t+": "+out);
		}
	}
	int maxNum(int r,int c){
		int max = 0;
		int[][] grid = new int[r][c];
		grid[0][0] = 1;
		int[][] grid2 = new int[r][c];
		grid2[0][0]=0;
		
		int[] h = new int[c];//height
		h[0] = 1;
		int[] l = new int[r];//long
		l[0] = 1;
		int[] h2 = new int[c];
		h2[0] = 0;
		int[] l2 = new int[r];
		l2[0] = 0;
		max = Math.max(countNum(grid,h, l,0), countNum(grid2,h2, l2,1));
		return max;
		
	}
	int countNum(int[][] grid,int[] h,int[] l,int count){
		//int count = 0;//计算空位置数
		int c = h.length;
		int r = l.length;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(i==0 && j!=0){					
						if(l[0]<2){
							grid[i][j]=1;
							l[0]++;
							h[j]++;
						}else{
							grid[i][j]=0;
							l[0]=0;
							h[j]=0;
							count++;
						}					
				}
				if(j==0 && i!=0){					
						if(h[0]<2){
							grid[i][j]=1;
							h[0]++;
							l[i]++;
						}else{
							grid[i][j]=0;
							h[0]=0;
							l[i]=0;
							count++;
						}
				}
				 if(i!=0 && j!=0){
					if(l[i]>=2 || h[j]>=2){
						grid[i][j]=0;
						l[i]=0;h[j]=0;
						count++;
					}else{
						grid[i][j]=1;
						l[i]++;h[j]++;
					}
				}
			}
		}
		return r*c-count;
		
	}
}
