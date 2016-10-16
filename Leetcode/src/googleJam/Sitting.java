package googleJam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Sitting {

	/**
	 * @param args
	 */
	Sitting(Scanner in){
		int T = in.nextInt();
		for(int t =1;t<=T;t++){
			int r = in.nextInt();
			int c = in.nextInt();
			int out = maxNum(r, c);
			System.out.println("Case #"+t+": "+out);
		}
	}
	int maxNum(int r,int c){
		int count = 0;//计算空位置数
		int[][] grid = new int[r][c];
		grid[0][0] = 1;
		int[] h = new int[c];//height
		h[0] = 1;
		int[] l = new int[r];//long
		l[0] = 1;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(i==0){
					if(j!=0){
						if(l[i]<2){
							grid[i][j]=1;
							l[i]++;
							h[j]++;
						}else{
							grid[i][j]=0;
							l[i]=0;
							h[j]=0;
							count++;
						}
					}
				}
				if(j==0){
					if(i!=0){
						if(h[j]<2){
							grid[i][j]=1;
							h[j]++;
							l[i]++;
						}else{
							grid[i][j]=0;
							h[j]=0;
							l[i]=0;
							count++;
						}
					}
				}
				 if(i!=0 && j!=0){
					if(l[i]>=2||h[j]>=2){
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
	public static void main(String[] args) throws FileNotFoundException {
		// TODO 自动生成的方法存根
		String filename = "B-small-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("B-small-practice-out.txt")));		
		Scanner in = new Scanner(System.in);
		new Sitting(in);
		in.close();

	}

}
