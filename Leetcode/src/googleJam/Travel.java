package googleJam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//Arrays.fill(Object[] ob,Object value)�ɸ�һά���������ֵͬ����ά��һ��ѭ��
public class Travel {

	/**
	 * @param args
	 */
	Map<Integer, Roads> path = new HashMap<>();//�洢ĳʱ�̵�·����Ϣ
	ArrayList<Integer> list = new ArrayList<>();//�洢����
	PriorityQueue<Roads> queue = new PriorityQueue<>(11,new Comparator<Roads>() {
		public int compare(Roads d1,Roads d2){
			return d1.cost-d2.cost;//�����С����
		}				
	});//�ӿ�ʵ�־��巽�������ź���Ҫ�ӷֺ�
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
			//Roads[][] edge = new Roads[N][N];//�����ͼ���ڽӾ���
					
			for(int i=0;i<M;i++){//�Ȳ���x��y֮���Ƿ��ж���·������Ҫɾ��M��Ч����
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
	//dijkstra�����·��,sʱ�̵�·����Ϣ
	void minHours(ArrayList<Integer> list,Roads[][] rout,PriorityQueue<Integer> queue,int N,int s){
		int[][] dis = new int[N][24];
		
		
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

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
