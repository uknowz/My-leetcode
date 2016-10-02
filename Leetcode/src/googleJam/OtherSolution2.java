package googleJam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
//google code jam合并区间的代码
class OtherSolution2{
	public OtherSolution2(Scanner in) {
		// TODO 自动生成的构造函数存根
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			int N = in.nextInt();
			int L1 = in.nextInt();
			int R1 = in.nextInt();
			int A = in.nextInt();		
			int B = in.nextInt();
			int C1 = in.nextInt();
			int C2 = in.nextInt();
			int M = in.nextInt();
			long min = Long.MAX_VALUE;
			ArrayList<Intervals> array = new ArrayList<>(generate(N, L1, R1, A, B, C1, C2, M));
			for(int i=0;i<N;i++){
				ArrayList<Intervals> li = new ArrayList<>(array);
				li.remove(i);
				min = Math.min(min, area(merge(li)));
			}
			System.out.println("Case #"+t+": " + min);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		String filename = "C-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("C-large-practice-out.txt")));
		Scanner in = new Scanner(System.in);
		new WatsonandIntervals(in);
		in.close();
	}
	ArrayList<Intervals> generate(int n,int l1,int r1,int a,int b,int c1,int c2,int m){
		int[] x = new int[n];
		int[] y = new int[n];
		x[0] = l1;
		y[0] = r1;
		ArrayList<Intervals> list = new ArrayList<>(n);
		list.add(new Intervals(x[0], y[0]));
		BigDecimal A = new BigDecimal(a);
		BigDecimal B = new BigDecimal(b);
		BigDecimal C1 = new BigDecimal(c1);
		BigDecimal C2 = new BigDecimal(c2);
		BigDecimal M = new BigDecimal(m);
		for(int i=1;i<n;i++){
			x[i] = (A.multiply(new BigDecimal(x[i-1])).add((B.multiply(new BigDecimal(y[i-1])))).add(C1).remainder(M)).intValue();
			y[i] = (A.multiply(new BigDecimal(y[i-1])).add((B.multiply(new BigDecimal(x[i-1])))).add(C2).remainder(M)).intValue();
			list.add(new Intervals(x[i], y[i]));
		}
		return list;
	}
	
	ArrayList<Intervals> merge(ArrayList<Intervals> list){
		if(list.size()==0) return list;
		ArrayList<Intervals> listm = new ArrayList<>(list.size());
		Comparator<Intervals> com = new Comparator<Intervals>() {
			public int compare(Intervals i1,Intervals i2){
				if(i1.l==i2.l)
					return i1.r - i2.r;
				return i1.l - i2.l;
			}
		};
		Collections.sort(list,com);
		listm.add(new Intervals(list.get(0).l, list.get(0).r));
		for(int i=1;i<list.size();i++){
			if(list.get(i).l<listm.get(listm.size()-1).r){
				int end = Math.max(list.get(i).r, listm.get(listm.size()-1).r);
				listm.get(listm.size()-1).r = end;
			}else{
				listm.add(new Intervals(list.get(i).l, list.get(i).r));
			}
		}
		return listm;
	}
	int area(ArrayList<Intervals> list){
		int ar = 0;
		for(int i=0;i<list.size();i++){
			ar += list.get(i).r-list.get(i).l+1;
		}
		return ar;
	}
	class Intervals{
		int l;
		int r;
		Intervals(int x,int y){
			l = Math.min(x, y);
			r = Math.max(x, y);
		}
	}
}