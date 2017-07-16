package googleDoc;

import java.util.Arrays;

public class Q4 {

	public void dfs(char[][] grid,int i,int j){
		if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!='0')
			return;
		grid[i][j]='*';
		dfs(grid,i+1,j);
		dfs(grid,i-1,j);
		dfs(grid,i,j+1);
		dfs(grid,i,j-1);
	}
	public static void main(String[] args){
		char[][] grid={{'1','0','1','0'},{'1','0','1','1'},{'1','0','0','1'},{'1','1','0','0'}};
		new Q4().dfs(grid,0,1);
		for(int i=0;i<grid.length;i++){
			System.out.println(Arrays.toString(grid[i]));
		}
		
	}
}
