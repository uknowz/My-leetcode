package googleJam;

import googleJam.MonsterPath2.Grid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class MonsterPath{
	
	static double max = 0;
    public static void main(String[] args) throws Exception {

       // FileInputStream fis = new FileInputStream("A-large-practice.in");
        //System.setIn(fis);
        //PrintStream ps = new PrintStream(new FileOutputStream("A-large.out"));
        //System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int R = in.nextInt(), C = in.nextInt(), Rs = in.nextInt(), Cs = in.nextInt(), S = in.nextInt();
            double P = in.nextDouble(), Q = in.nextDouble();
            char[][] grid = new char[R][C];
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++)
                    grid[r][c] = in.next().charAt(0);
            }
            int[][] visited = new int[R][C];
            max = 0;
            //top
            dfs(grid, R, C, visited, Rs - 1, Cs, 0, S, 0d, P, Q);
            //bottom
            dfs(grid, R, C, visited, Rs + 1, Cs, 0, S, 0d, P, Q);
            //left
            dfs(grid, R, C, visited, Rs, Cs - 1, 0, S, 0d, P, Q);
            //right
            dfs(grid, R, C, visited, Rs, Cs + 1, 0, S, 0d, P, Q);
            out.format("Case #%d: %.7f\n", i, max);
        }
    }

    static void dfs(char[][] grid, int R, int C, int[][] visited, int r, int c
            , int step, int S, double expected, double P, double Q) {
        if (step == S) {
            if (expected > max) max = expected;
            return;
        }
        if (r >= R || c >= C || r < 0 || c < 0) return;
        double baseP = (grid[r][c] == 'A') ? P : Q;
        expected += Math.pow(1 - baseP, visited[r][c]) * baseP;
        visited[r][c]++;
        //top
        dfs(grid, R, C, visited, r - 1, c, step + 1, S, expected, P, Q);
        //bottom
        dfs(grid, R, C, visited, r + 1, c, step + 1, S, expected, P, Q);
        //left
        dfs(grid, R, C, visited, r, c - 1, step + 1, S, expected, P, Q);
        //right
        dfs(grid, R, C, visited, r, c + 1, step + 1, S, expected, P, Q);
        visited[r][c]--;
    }
}
//第一次写错的代码
class MonsterPath3 {

	/**
	 * @param args
	 */
	
	int imax;
	int jmax;
	MonsterPath3(Scanner in){
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			double out = 0;
			int R = in.nextInt();
			int C = in.nextInt();
			int Rs = in.nextInt();
			int Cs = in.nextInt();
			int S = in.nextInt();
			double P = in.nextDouble();
			double Q = in.nextDouble();
			String dele = in.nextLine();
			Grid[][] grid = new Grid[R][C];
			imax = Rs;
			jmax = Cs;
			for(int i=0;i<R;i++){
				String line = in.nextLine();
				String[] l = line.split(" ");
				for(int j=0;j<l.length;j++){
					grid[i][j] = new Grid(l[j].equals("A")?P:Q);//初始化
				}
			}
			for(int s=0;s<S;s++){
				out += dfs(grid,imax,jmax);
			}
			if(imax==Rs && jmax==Cs) out = 0;
			System.out.println(String.format("Case #%d: %.7f",t,out));
			
		}
	}
	
	//选取四周概率最大，每走一步，改变一次路径上的p值
	public double dfs(Grid[][] grid,int i,int j){//路径不同，不是best path
		double result = 0;
		double p = 0;
		if(i<0||i>=grid.length||j<0||j>=grid[0].length) return result;
		//以下if决策语句是顺序结构，初始值会对路径选择造成影响，wrong
		if(i+1<grid.length){
			p = grid[i+1][j].probability;
			imax = i+1;
			jmax = j;
		}
		if(i-1>0 && p<grid[i-1][j].probability){
			p = grid[i-1][j].probability;
			imax = i-1;
			jmax = j;
		}
		if(j+1<grid[0].length && p<grid[i][j+1].probability){
			p = grid[i][j+1].probability;
			imax = i;
			jmax = j+1;
		}
		if(j-1>0 && p<grid[i][j-1].probability){
			p = grid[i][j-1].probability;
			imax = i;
			jmax = j-1;
		}
		result = grid[imax][jmax].probability;
		grid[imax][jmax].probability = (1-grid[imax][jmax].probability)*grid[imax][jmax].probability;
		return result;
	}
	class Grid{	
		double probability;
		
		Grid(double p){
			//attractor = att;
			probability = p;//每个网格捉住怪物的概率，初始化为P,Q
			
		}
	}
	

}