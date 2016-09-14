package googleJam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
//���������α���ö�٣�ǰ�����ƺͺ������ƣ�����ɸѡ�����򣬿���ɾ������Ч���ݣ����ǲ���ɾ������û����queue
//large�Ļ���ͬ��ö�٣�c��12,8����С��Ӱ�죬ÿ�δ�12����ѡ��8���ƣ�����ÿ8���Ƶ�resA powerֵ��ȡ���ûд��,small case Ӧ�����ñ�������ⷨ��
public class ClashRoyale {

	/**
	 * @param args
	 */
	//ÿһ�ַ������������coins��С�����ţ���coins��ͬʱ��power�Ӵ�С�ţ�����ͬʱ�����Ⱥ�û���õ���
	PriorityQueue<Item> queue = new PriorityQueue<>(11,new Comparator<Item>() {
		public int compare(Item item1, Item item2){
			if(item1.coins<item2.coins) 
				return -1;
			else if(item1.coins>item2.coins)
				return 1;
			else{
				if(item1.power>item2.power)
					return -1;
				else if(item1.power<item2.power)
					return 1;
				else return 0;
			}
		}				
	});//�ӿ�ʵ�־��巽�������ź���Ҫ�ӷֺ�
	
	List<Item> group1 = new ArrayList<>();
	List<Item> group2 = new ArrayList<>();//ǰ�������Ƶ�ÿ�����
	List<Cards> list = new ArrayList<Cards>(8);//cards
	ClashRoyale(Scanner in){
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			int M = in.nextInt();
			int N = in.nextInt();
			long resA = 0;//�������power,ÿ�������power10^10,�����ܵ������8*10^10,Ϊlong��
			//int resC = 0;//��������coins
			
			for(int i=0;i<N;i++){
				int k = in.nextInt();
				int l = in.nextInt();
				int[] a = new int[k];
				int[] c = new int[k-1];
				for(int j=0;j<k;j++){
					a[j] = in.nextInt();
				}
				for(int z=0;z<k-1;z++){
					c[z] = in.nextInt();
				}
				list.add(new Cards(k, l, a, c));
			}
			//ǰ�����Ƶ���٣�����coins��power
			int coinsi = 0;int coinsj = 0;int coinsm = 0;int coinsn = 0;
			for(int i=list.get(0).l;i<=list.get(0).k;i++){//��level����ѭ��
				if(i==list.get(0).l) coinsi = 0;
				else coinsi += list.get(0).c[i-2];
				/*
				for(int ii=0;ii<i-1;ii++){
					coinsi += list.get(0).c[ii];
				}*/
				for(int j=list.get(1).l;j<=list.get(1).k;j++){
					if(j==list.get(1).l) coinsj = 0;
					else coinsj += list.get(1).c[j-2];
					
					for(int m=list.get(2).l;m<=list.get(2).k;m++){
						if(m==list.get(2).l) coinsm = 0;
						else coinsm += list.get(2).c[m-2];
						
						for(int n=list.get(3).l;n<=list.get(3).k;n++){
							if(n==list.get(3).l) coinsn = 0;
							else coinsn += list.get(3).c[n-2];
							
							if(coinsi+coinsj+coinsm+coinsn<=M)
								//queue.add(new Item(coinsi+coinsj+coinsm+coinsn, list.get(3).a[n-1]+list.get(2).a[m-1]+
								//	list.get(1).a[j-1]+list.get(0).a[i-1]));
								group1.add(new Item(coinsi+coinsj+coinsm+coinsn, list.get(3).a[n-1]+list.get(2).a[m-1]+
										list.get(1).a[j-1]+list.get(0).a[i-1]));
						}
					}
				}
			}
			//�������Ƽ���
			int coinsi2 = 0;int coinsj2 = 0;int coinsm2 = 0;int coinsn2 = 0;
			for(int i2=list.get(4).l;i2<=list.get(4).k;i2++){
				if(i2==list.get(4).l) coinsi2 = 0;
				else coinsi2 += list.get(4).c[i2-2];
				
				for(int j2=list.get(5).l;j2<=list.get(5).k;j2++){
					if(j2==list.get(5).l) coinsj2 = 0;
					else coinsj2 += list.get(5).c[j2-2];
					
					for(int m2=list.get(6).l;m2<=list.get(6).k;m2++){
						if(m2==list.get(6).l) coinsm2 = 0;
						else coinsm2 += list.get(6).c[m2-2];
						
						for(int n2=list.get(7).l;n2<=list.get(7).k;n2++){
							if(n2==list.get(7).l) coinsn2 = 0;
							else coinsn2 += list.get(7).c[n2-2];
							
							if(coinsi2+coinsj2+coinsm2+coinsn2<=M)
							//queue2.add(new Item(coinsi2+coinsj2+coinsm2+coinsn2, list.get(7).a[n2-1]+list.get(6).a[m2-1]+
							//			list.get(5).a[j2-1]+list.get(4).a[i2-1]));
							group2.add(new Item(coinsi2+coinsj2+coinsm2+coinsn2, list.get(7).a[n2-1]+list.get(6).a[m2-1]+
									list.get(5).a[j2-1]+list.get(4).a[i2-1]));
						}
					}
				}
			}
			//����resA�����power������ö�٣��Ȳ������ˣ�
			for(int z =0;z<group1.size(); z++){
				for(int y=0;y<group2.size(); y++){
					Item it1 = group1.get(z);
					Item it2 = group2.get(y);
					if(it1.coins+it2.coins<=M){
						resA = Math.max(resA, it1.power+it2.power);
					}
				}			
			}		
			System.out.println("Case #"+t+": " + resA);
			group1.clear();
			group2.clear();
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		String filename = "D-small-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("D-small-practice-out.txt")));		
		Scanner in = new Scanner(System.in);
		new ClashRoyale(in);
		in.close();
	}
	// i-th cards param
	class Cards{
		int k,l;
		int[] a = new int[k];// each level power
		int[] c = new int[k-l];//upgrading each level coins
		Cards(int k,int l,int[] a,int[] c){
			this.k = k;
			this.l = l;
			this.a = a;
			this.c = c;
		}
		
	}
	class Item{
		int coins;
		int power;
		Item(int coins,int power){
			this.coins = coins;
			this.power = power;
		}
	}
}