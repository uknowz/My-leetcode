package hihocoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
//hiho第九十一周题  代码超出了时间运行限制，需要优化，timeout 200000ms
public class Main {
	public attributions[] data;//even类型的数组声明，和int[] a;一样
	//用来存储abc数据的能不能用arraylist呢，动态数组，更加灵活？
	private int n, m, k;//变量的访问是可以使用限定符的

	

	//设置类的构造函数，为什么这个方法要放在构造函数里面
	public Main(Scanner in) {
		/*
		 * @n,m,k分别是输入的三个参数
		 */
		this.n = in.nextInt();//nextint()方法当前行用空格作为分界符，换行符也作为分界符，但是不会自动读取到下一行
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
		data = new attributions[N];//为什么
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
			M = Math.max(M, val.get(v));//取两个中最大的int型整数
		}
		System.out.println(M);
	}
	//助手类，用来存放a b c 因子的
	public class attributions implements Comparable<Object> {//如果要使用compare的功能，必须实现comparable的接口
		public int a, b, c;

		public attributions(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		//这个比较排序，可以用arrays.sort()来做吗，优化时间复杂度
		public int compareTo(Object other) {//必须继承comparable<object>的抽象方法，所以不能直接用attributions other做参数
			attributions e = (attributions) other;
			return Integer.compare(this.c * e.b, this.b * e.c);
		}
	}

	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);//输入格式严格，数字之间要有空格
		System.out.println("Please input numbers:");
		Main agent = new Main(in);
	}

}
