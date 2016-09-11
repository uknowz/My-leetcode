package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<List<String>>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char[][] grid = new char[n][n];
                list.add(solve(n,grid,i,j));//有多少个二维数组组合，list.add进来,wrong,需要筛选
            }
        }
        return list;
    }
    public List<String> solve(int n,char[][] grid,int i,int j){
        List<String> list = new ArrayList<>();
        
            for(int x=i;x<grid.length;x++){
               for(int y=j;y<grid[0].length;y++){
                   if(grid[x][y]!='.'){
                        grid[x][y] = 'Q';//wrong
                        dfs(x,y,grid);
                    }
               } 
            }
        
        for(int z=0;z<n;z++){
            list.add(String.valueOf(grid[z]));//char[]变string不用Arrays.toString
        }
        return list;
    }
    void dfs(int i,int j,char[][] grid){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='.')
            return;
        grid[i][j] = '.';
        dfs(i,j++,grid);
        dfs(i,j--,grid);
        dfs(i++,j,grid);
        dfs(i--,j,grid);
        dfs(i++,j++,grid);
        dfs(i--,j--,grid);
        dfs(i--,j++,grid);
        dfs(i++,j--,grid);
        
    }
    public static void main(String[] args){
    	NQueens ex = new NQueens();
    	List<List<String>> list = new ArrayList<>();
    	list = ex.solveNQueens(4);
    	for(int i=0;i<list.size();i++){
    		System.out.print(list.get(i).toString());
    	}
    }
}
//要看别人的代码
 class Solution3 {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    
    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }
        
        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }
    
    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}