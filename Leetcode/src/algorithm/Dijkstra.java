package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijkstra {

	/**
	 * @param args,eȨֵ��v��㣬u�յ�
	 */
	static int[][] edge;
	static List<Integer> list;//�Ŷ���
	int size;
	static List<Integer> s = new ArrayList<>();
	static List<Integer> q = new ArrayList<>();

	Dijkstra(int n){
		//size = n;
		edge = new int[n+1][n+1];
		list = new ArrayList<>(n);
	}
	public void insertEdge(int v,int u,int e){
		edge[v][u] = e;
		if(!list.contains(v))
			list.add(v);
		if(!list.contains(u))
			list.add(u);
	}
	//�ҵ����������ʹ�ö����ȶ������Ż�O(mlogn)
	public int close(int[][] edge,int pre,int n,List<Integer> s){
		int min = Integer.MAX_VALUE;
		int v  = pre;
		for(int j=1;j<n+1;j++){
			if(edge[pre][j]<min && !s.contains(j)){
				min = edge[pre][j];
				v = j;
				
			}
		}
		s.add(v);
		return v;
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int n = 6 ;
		Dijkstra ex = new Dijkstra(n);
		for(int i=0;i<n+1;i++){
			for(int j=0;j<n+1;j++){
				edge[i][j] = Integer.MAX_VALUE;
			}
		}	
		s.add(1);
		for(int i=2;i<7;i++){
			q.add(i);
		}		
		ex.insertEdge(1, 2, 1);
		ex.insertEdge(1, 3, 12);
		ex.insertEdge(2, 3, 9);
		ex.insertEdge(2, 4, 3);
		ex.insertEdge(3, 5, 5);
		ex.insertEdge(4, 3, 4);
		ex.insertEdge(4, 5, 13);
		ex.insertEdge(4, 6, 15);
		ex.insertEdge(5, 6, 4);
		int pre = 1;
		int[] dis = new int[n+1];
		dis[1] = 0;
		for(int i=2;i<n+1;i++){
			dis[i] = edge[1][i];
		}
		for(int k=1;k<=n-1;k++){
			int v = ex.close(edge, pre, n, s);
			dis[v] = Math.min(dis[pre]+edge[pre][v], dis[v]);
			pre = v;
		}
		for(int i=1;i<n+1;i++){
			System.out.print(dis[i]+" ");
		}

	}
	

}
