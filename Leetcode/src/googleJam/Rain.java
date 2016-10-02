package googleJam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
//�����ѭ���������������������������������ȶ�����Ķ���Ԫ�ؾ�����ÿһ���ڵ㶼�����ȵ����߽磬���ҵ͵أ�����̱߽索ˮ
/*
 * @author Mingfang.z �ڱ��˻������Լ��޸ĵĴ���
 * ˼·���Ƚ��߽�װ�����ȶ����У��߶�ԽСԽ���ȣ��������Ϊ�ѷ��ʡ�������Ԫ������δ���ʹ��ĵ㣬
 * 1������õ㲻�ȶ��׵ͣ�����������У����Ϊ�ѷ��ʣ�����������µı߽硣
 * 2���õ�ȶ��׵ͣ���ζ�Ÿõ���Դ�ˮ������resֵ��ͬʱ������������У��������ĸ߶�Ϊԭ����Ԫ�صĸ߶ȣ�������Ϊ�߽�ĵ㲻�ܳ�������߶ȣ�
 * ͬʱ���õ���Ϊ�ѷ��ʡ�
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
		});//�ӿ�ʵ�־��巽�������ź���Ҫ�ӷֺ�
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			int r = in.nextInt();
			int c = in.nextInt();
			int[][] h = new int[r][c];
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					h[i][j] = in.nextInt();//�����ԭ����
					if(i==0||i==r-1||j==0||j==c-1){
						queue.add(new Grid(i, j, h[i][j]));//������Χ������,���г�ʼ��
					}
				}
			}
			boolean[][] visited = new boolean[r][c];
			int wCount = 0;//��¼��ˮֵ
			while(!queue.isEmpty()){
				Grid grid = queue.poll();//����poll��peek֮ǰ���������ж϶��л�ջ��Ϊ��
				visited[grid.i][grid.j] = true;
				wCount += waterCount(h, visited, grid.i+1, grid.j, grid.h, queue);
				wCount += waterCount(h, visited, grid.i-1, grid.j, grid.h, queue);
				wCount += waterCount(h, visited, grid.i, grid.j-1, grid.h, queue);
				wCount += waterCount(h, visited, grid.i, grid.j+1, grid.h, queue);
			}
			System.out.println("Case #"+t+": "+wCount);								
		}
	}
		/*��ÿһ�����ȶ��������С�߽�ڵ������Χ��ˮֵ
		 * @param
		 * curH�Ƕ�����С�߽�
		 * h[i][j]�����ܱ����Ľڵ�
		 */
	public int waterCount(int[][] h, boolean[][] vis, int i, int j, int curH, PriorityQueue<Grid> queue ){
		if(i<0||i>=h.length||j<0||j>=h[0].length||vis[i][j]) return 0;
		else{
			vis[i][j] = true;//�жϸýڵ��Ƿ񱻷���
			//curH = queue.poll().h;
			queue.add(new Grid(i, j, Math.max(curH, h[i][j])));
			return Math.max(0, curH-h[i][j]);//���ִ�ˮ���Ǹ���
			}
		}
	class Grid{//ÿһ������Ĳ�����Ҫ����i��j��h
		int i, j, h;
		public Grid(int i, int j, int h){
			this.i = i;//������ֵ��ȫ�ֱ�����ʵ�������Ƕ�����õ���Ҫthis�ؼ���
			this.j = j;
			this.h = h;
			
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		String filename = "B-small-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("B-small-practice-out.txt")));		
		Scanner in = new Scanner(System.in);
		new Rain(in);
		in.close();
		System.exit(0);
	}	
}

//���˵Ĵ���
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

        int trap = 0;//��¼��ˮֵ����ʼΪ0
        boolean[][] vis = new boolean[m][n];//��¼�ڵ��Ƿ񱻷���
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(10, new Comparator<Cell>() {//�������ȶ��У���ʵ������comparator�ӿڣ�ȱʡ������ǰ��մ�С�����˳��
            @Override
            public int compare(Cell c1, Cell c2) {//ʵ�ֽӿ��е�compare����
                return c1.h - c2.h;
            }
        });//new ������ʱ��Ҫʵ�����ж���ľ��巽����С���ź���Ӵ�����

        // �Ȱ�����Χ��4���߼��룬�������ظ�����Ϊ��vis�������ж�
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
    //�߽���minheap����Ԫ�أ�curh�Ǳ߽磬h[i][j]��������δ���ʽڵ㣬����curh�߽�С������Դ�ˮ����������Ϊ�µı߽�add��minheap��
    private static int calcDiff(PriorityQueue<Cell> minHeap, int[][] H, boolean[][] vis, int i, int j, int curH) {
        int m = H.length, n = H[0].length;
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j])  return 0;

        vis[i][j] = true;
        minHeap.add(new Cell(i, j, Math.max(curH, H[i][j])));
        return Math.max(0, curH - H[i][j]);//���ش�ˮֵ=�߽�-���ܵ͵Ľڵ�
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

