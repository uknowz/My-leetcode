package googleJam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//Arrays.fill(Object[] ob,Object value)可给一维数组填充相同值，二维加一个循环
public class Travel {

	/**
	 * @param args
	 */
	Map<Integer, Roads> path = new HashMap<>();//存储某时刻的路径信息
	ArrayList<Integer> list = new ArrayList<>();//存储顶点
	PriorityQueue<Roads> queue = new PriorityQueue<>(11,new Comparator<Roads>() {
		public int compare(Roads d1,Roads d2){
			return d1.cost-d2.cost;//排序从小到大
		}				
	});//接口实现具体方法大括号后面要加分号
	Travel(Scanner in){
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			int N = in.nextInt();//cities
			int M = in.nextInt();//roads
			int K = in.nextInt();//questions
			int[][] dis = new int[N][24];//min distance from 1 to N	at each hour		
			for(int i=1;i<=N;i++){
				list.add(i);
			}
			//Roads[][] edge = new Roads[N][N];//储存地图的邻接矩阵
					
			for(int i=0;i<M;i++){//先不管x，y之间是否有多条路径，需要删除M无效数据
				int x = in.nextInt();
				int y = in.nextInt();
				int[] cost = new int[24];
				for(int j=0;j<24;j++){
					path.put(j, new Roads(x, y, in.nextInt()));
				}				
			}
			path.clear();
		}
	}
	//dijkstra求最短路径,s时刻的路径信息
	void minHours(ArrayList<Integer> list,Roads[][] rout,PriorityQueue<Integer> queue,int N,int s){
		int[][] dis = new int[N][24];
		
		
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	
	class Roads{
		int x;
		int y;
		int cost;
		
		Roads(int x,int y,int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
			
		}	
	}

}
