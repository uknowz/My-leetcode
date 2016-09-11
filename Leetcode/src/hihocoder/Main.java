package hihocoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
//hiho�ھ�ʮһ����  ���볬����ʱ���������ƣ���Ҫ�Ż���timeout 200000ms
public class Main {
	public attributions[] data;//even���͵�������������int[] a;һ��
	//�����洢abc���ݵ��ܲ�����arraylist�أ���̬���飬������
	private int n, m, k;//�����ķ����ǿ���ʹ���޶�����

	

	//������Ĺ��캯����Ϊʲô�������Ҫ���ڹ��캯������
	public Main(Scanner in) {
		/*
		 * @n,m,k�ֱ����������������
		 */
		this.n = in.nextInt();//nextint()������ǰ���ÿո���Ϊ�ֽ�������з�Ҳ��Ϊ�ֽ�������ǲ����Զ���ȡ����һ��
		this.m = in.nextInt();
		this.k = in.nextInt();
		ArrayList<Integer> numSep = new ArrayList<Integer>();
		numSep.add(0, 1);
		for (int i = 1; i < k; i++) {
			int now = numSep.get(i - 1) * 2;
			if (2 * now - 1 >= k) {
				numSep.add(i, k - now + 1);
				break;
			}
			numSep.add(i, now);
		}
		
		int N = this.n * numSep.size();//?
		data = new attributions[N];//Ϊʲô
		for (int i = 0; i < this.n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			for (int j = 0; j < numSep.size(); j++) {
				int times = numSep.get(j);
				//
				this.data[i + this.n * j] = new attributions(times * a - times * (times - 1) * b * c / 2, times * b, times * c);
			}
		}
		Arrays.sort(data);
		HashMap<Integer, Integer> val = new HashMap<>();

		val.put(0, 0);
		for (int i = 1; i <= N; i++) {
			HashMap<Integer, Integer> valTemp = new HashMap<>();
			valTemp.putAll(val);
			for (int v : valTemp.keySet()) {
				int a = data[i - 1].a;
				int b = data[i - 1].b;
				int c = data[i - 1].c;
				if (v + c < m) {
					int sourse = valTemp.get(v) + (a - v * b);
					if (val.get(v + c) == null) {
						val.put(v + c, sourse);
					} else {
						val.put(v + c, Math.max(sourse, val.get(v + c)));
					}
				}
			}
		}
		int M = 0;
		for (int v : val.keySet()) {
			M = Math.max(M, val.get(v));//ȡ����������int������
		}
		System.out.println(M);
	}
	//�����࣬�������a b c ���ӵ�
	public class attributions implements Comparable<Object> {//���Ҫʹ��compare�Ĺ��ܣ�����ʵ��comparable�Ľӿ�
		public int a, b, c;

		public attributions(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		//����Ƚ����򣬿�����arrays.sort()�������Ż�ʱ�临�Ӷ�
		public int compareTo(Object other) {//����̳�comparable<object>�ĳ��󷽷������Բ���ֱ����attributions other������
			attributions e = (attributions) other;
			return Integer.compare(this.c * e.b, this.b * e.c);
		}
	}

	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);//�����ʽ�ϸ�����֮��Ҫ�пո�
		System.out.println("Please input numbers:");
		Main agent = new Main(in);
	}

}
