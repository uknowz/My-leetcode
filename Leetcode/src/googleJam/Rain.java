package googleJam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
//这道题循环遍历不是有网格来决定，而是由优先队列里的队首元素决定，每一个节点都可以先当做边界，不找低地，找最短边界储水
/*
 * @author Mingfang.z 在别人基础上自己修改的代码
 * 思路：先将边界装入优先队列中（高度越小越优先），并标记为已访问。看队首元素四周未访问过的点，
 * 1、如果该点不比队首低，则将它加入队列，标记为已访问，即它变成了新的边界。
 * 2、该点比队首低，意味着该点可以储水，更新res值，同时将它加入队列中，但是它的高度为原队首元素的高度，即以它为边界的点不能超过这个高度，
 * 同时将该点标记为已访问。
 */
public class Rain {

	/**
	 * @param args
	 * 
	 */
	public Rain(Scanner in){
		
		PriorityQueue<Grid> queue = new PriorityQueue<>(11,new Comparator<Grid>() {
			public int compare(Grid grid1, Grid grid2){
				return grid1.h - grid2.h;
			}				
		});//接口实现具体方法大括号后面要加分号
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			int r = in.nextInt();
			int c = in.nextInt();
			int[][] h = new int[r][c];
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					h[i][j] = in.nextInt();//输入的原网格
					if(i==0||i==r-1||j==0||j==c-1){
						queue.add(new Grid(i, j, h[i][j]));//加入外围四条边,队列初始化
					}
				}
			}
			boolean[][] visited = new boolean[r][c];
			int wCount = 0;//记录储水值
			while(!queue.isEmpty()){
				Grid grid = queue.poll();//调用poll或peek之前，必须先判断队列或栈不为空
				visited[grid.i][grid.j] = true;
				wCount += waterCount(h, visited, grid.i+1, grid.j, grid.h, queue);
				wCount += waterCount(h, visited, grid.i-1, grid.j, grid.h, queue);
				wCount += waterCount(h, visited, grid.i, grid.j-1, grid.h, queue);
				wCount += waterCount(h, visited, grid.i, grid.j+1, grid.h, queue);
			}
			System.out.println("Case #"+t+": "+wCount);								
		}
	}
		/*对每一个优先队列里的最小边界节点计算周围储水值
		 * @param
		 * curH是队首最小边界
		 * h[i][j]是四周遍历的节点
		 */
	public int waterCount(int[][] h, boolean[][] vis, int i, int j, int curH, PriorityQueue<Grid> queue ){
		if(i<0||i>=h.length||j<0||j>=h[0].length||vis[i][j]) return 0;
		else{
			vis[i][j] = true;//判断该节点是否被访问
			//curH = queue.poll().h;
			queue.add(new Grid(i, j, Math.max(curH, h[i][j])));
			return Math.max(0, curH-h[i][j]);//保持储水量非负性
			}
		}
	class Grid{//每一个网格的参数需要储存i，j，h
		int i, j, h;
		public Grid(int i, int j, int h){
			this.i = i;//参数赋值给全局变量，实例变量是对象调用的需要this关键词
			this.j = j;
			this.h = h;
			
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		String filename = "B-small-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("B-small-practice-out.txt")));		
		Scanner in = new Scanner(System.in);
		new Rain(in);
		in.close();
		System.exit(0);
	}	
}

//别人的代码
class Rain2 {
	/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("2/B-large.in"));
        int T = Integer.valueOf(br.readLine());
        BufferedWriter bw = new BufferedWriter(new FileWriter("2/large-result.txt"));
        int caseNum = 1;
        for (int i = 0; i < T; i++) {
        	String[] size = br.readLine().split(" ");
        	int r = Integer.valueOf(size[0]);
        	int c = Integer.valueOf(size[1]);
        	int[][] input = new int[r][c];
        	for (int j = 0; j < r; j++) {
        		String[] line = br.readLine().split(" ");
        		for (int k = 0; k < c; k++) {
        			input[j][k] = Integer.valueOf(line[k]);
        		}
        	}
        	bw.write("Case #" + caseNum++ + ": " + trapRainWater(input) + "\n");
        }
        br.close();
        bw.close();
    }*/
    
    public static int trapRainWater(int[][] H) {
        // write your code here
        if(H.length == 0 || H[0].length == 0)   return 0;
        int m = H.length, n = H[0].length;

        int trap = 0;//记录储水值，初始为0
        boolean[][] vis = new boolean[m][n];//记录节点是否被访问
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(10, new Comparator<Cell>() {//建立优先队列，并实现排序comparator接口，缺省情况下是按照从小到大的顺序
            @Override
            public int compare(Cell c1, Cell c2) {//实现接口中的compare方法
                return c1.h - c2.h;
            }
        });//new 匿名类时需要实现类中对象的具体方法，小括号后面接大括号

        // 先把最外围的4条边加入，可以有重复，因为有vis做先验判断
        for(int i=0; i<m; i++) {
            minHeap.add(new Cell(i, 0, H[i][0]));
            minHeap.add(new Cell(i, n-1, H[i][n-1]));
        }
        for(int j=0; j<n; j++) {
            minHeap.add(new Cell(0, j, H[0][j]));
            minHeap.add(new Cell(m-1, j, H[m-1][j]));
        }

        while(!minHeap.isEmpty()) {
            Cell c = minHeap.poll();
            vis[c.i][c.j] = true;

            //trap += calcDiff(minHeap, H, vis, c.i + 1, c.j, c.h);
            trap = trap + calcDiff(minHeap, H, vis, c.i+1, c.j, c.h);
            trap += calcDiff(minHeap, H, vis, c.i - 1, c.j, c.h);
            trap += calcDiff(minHeap, H, vis, c.i, c.j + 1, c.h);
            trap += calcDiff(minHeap, H, vis, c.i, c.j - 1, c.h);
        }

        return trap;
    }
    //边界是minheap队首元素，curh是边界，h[i][j]是其四周未访问节点，若比curh边界小，则可以储水，若大，则作为新的边界add进minheap中
    private static int calcDiff(PriorityQueue<Cell> minHeap, int[][] H, boolean[][] vis, int i, int j, int curH) {
        int m = H.length, n = H[0].length;
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j])  return 0;

        vis[i][j] = true;
        minHeap.add(new Cell(i, j, Math.max(curH, H[i][j])));
        return Math.max(0, curH - H[i][j]);//返回储水值=边界-四周低的节点
    }

    static class Cell {
        int i;
        int j;
        int h;

        public Cell(int i, int j, int h) {
            this.i = i;
            this.j = j;
            this.h = h;
        }
    }
}

