package googleJam;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import leetcode.Lis;
//这道题应用于多进程共享资源
public class WatsonandIntervals {

	/**
	 * @param args
	 */
	public WatsonandIntervals(Scanner in) {
		// TODO 自动生成的构造函数存根
		 int T = in.nextInt();
	        for (int t = 1; t <= T; t++) {
	            int n = in.nextInt();
	            Pair p[] = new Pair[n];
	            p[0] = new Pair(in.nextInt(), in.nextInt());
	            long a = in.nextLong();
	            long b = in.nextLong();
	            long c1 = in.nextLong();
	            long c2 = in.nextLong();
	            int m = in.nextInt();	            
	            for (int i = 1; i < n; i++) {
	                //p[i] = new Pair(in.nextInt(), in.nextInt());
	                p[i] = new Pair((a * p[i - 1].x + b * p[i - 1].y + c1) % m, (a * p[i - 1].y + b
	                                * p[i - 1].x + c2)
	                                % m);
	            }//产生n个区间
	            for (int i = 0; i < n; i++) {
	                int x = p[i].x;
	                int y = p[i].y;
	                p[i].x = Math.min(x, y);
	                p[i].y = Math.max(x, y);
	            }
	            Arrays.sort(p);
	            int preEnd[] = new int[n];
	            for (int i = 0; i < n; i++) {
	                preEnd[i] = p[i].y;
	                if (i > 0)
	                    preEnd[i] = Math.max(preEnd[i - 1], p[i].y);
	            }
	            //if (n <= 5)
	              //  System.out.println(Arrays.deepToString(p));
	            int rem = 0;
	            int best = 0;
	            Stack<Pair> s = new Stack<Pair>();
	            for (int i = n - 1; i >= 0; i--) {
	                int L = p[i].x;
	                if (i > 0)
	                    L = Math.max(L, preEnd[i - 1] + 1);
	                Pair now = new Pair(p[i].x, p[i].y);
	                int my = Math.max(0, p[i].y - L + 1);
	                while (!s.isEmpty()) {
	                    Pair q = s.peek();
	                    if (q.x > p[i].y) {
	                        break;
	                    } else {
	                        s.pop();
	                        if (p[i].y >= q.y) {
	                            int area = Math.max(0, q.y - Math.max(L + 1, q.x) + 1);
	                            my -= area;
	                            L = Math.max(L, q.y);
	                            continue;
	                        } else {
	                            int area = Math.max(0, p[i].y - Math.max(L + 1, q.x) + 1);
	                            my -= area;
	                            now.y = q.y;
	                            break;
	                        }
	                    }
	                }
	                s.push(now);
	                //System.out.println("now " + my);
	                if (my > best) {
	                    best = my;
	                    rem = i;
	                }
	            }
	            int ans = -1;
	            int l = -1, r = -1;
	            for (int i = 0; i < n; i++) {
	                if (i == rem)
	                    continue;
	                if (p[i].x > r) {
	                    ans += r - l + 1;
	                    l = p[i].x;
	                    r = p[i].y;
	                } else {
	                    r = Math.max(r, p[i].y);
	                }
	            }
	            ans += r - l + 1;
	            //if (n <= 5)
	              //  System.out.println(rem + " " + ans);
	            System.out.println("Case #" + t + ": "+ ans);           
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
	static class Pair implements Comparable<Pair> {
        int x, y;
        Pair(long x, long y) {
            this.x = (int) x;
            this.y = (int) y;
        }
        public int compareTo(Pair o) {
            if (x != o.x)
                return Integer.compare(x, o.x);
            return Integer.compare(y, o.y);
        }
        public String toString() {
            return x + " " + y;
        }
    }	
}
//用list<list<integer>>当做一维区间结构的笨代码，o(n^2),small ac，写一个interval的类好一点
class otherSolution{
	public otherSolution(Scanner in){
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
			List<List<Integer>> list = new ArrayList<>(generate(L1, R1, N, A, B, C1, C2, M)) ;//传引用不会copy对象，还是只有一个对象
			for(int i=0;i<N;i++){
				List<List<Integer>> listn = new ArrayList<>(list);
				listn.remove(i);//return the element remove from the list
				List<List<Integer>> lismer = new ArrayList<>(merge(listn));
				min = Math.min(minArea(lismer), min);
			}
			System.out.println("Case #"+t+": " + min);
		}
	}
	
	//将一个listArea中的区间合并，加入到另一个listMerge中，这个合并区间的方法可以复用 O(N)
	public List<List<Integer>> merge(List<List<Integer>> listArea){//wrong place,listMerge变，listArea也变？
		if(listArea.size()==0)
			return listArea;
		List<List<Integer>> listMerge = new ArrayList<>();//存储总的合并后的区间，，，new二层list方法不对？
		
		Comparator<List<Integer>> compare = new Comparator<List<Integer>>() {
			public int compare(List<Integer> list1,List<Integer> list2){
				if(list1.get(0)==list2.get(0)){
					return list1.get(1) - list2.get(1);
				}
				return list1.get(0) - list2.get(0);
			}
		};
		Collections.sort(listArea,compare);//容器排序
		List<Integer> init = new ArrayList<>(listArea.get(0));//引用变量的传递，是引用地址的传递，不是值传递，传递后的变量仍然会指向同一片对象内存
		
		listMerge.add(init);//Initialization
		for(int i=1;i<listArea.size();i++){//这一块没想到，怎么得合并的结果集，排序想到了。
			if(listArea.get(i).get(0)<=listMerge.get(listMerge.size()-1).get(1)){
				int end = Math.max(listArea.get(i).get(1),listMerge.get(listMerge.size()-1).get(1));
				listMerge.get(listMerge.size()-1).remove(1);
				listMerge.get(listMerge.size()-1).add(end);
			}else{
				
				listMerge.add(new ArrayList<>(listArea.get(i)));//每次添加都new一个新的内存，而不是直接传地址
			}
		}
		return listMerge;
	}
	
	public long minArea(List<List<Integer>> list){//去掉一个区间，循环n次没写
		if(list.size()==0) return 0;
		long result=0;
		for(List<Integer> ls:list){
			result += ls.get(1)-ls.get(0)+1;//long+int=long，向上兼容，int不能转换为long
		}
		return result;
	}
	//T = o(n),根据输入参数，产生n个区间
	public List<List<Integer>> generate(int x1,int y1,int n,int a,int b,int c1,int c2,int m){
		int[] x = new int[n];
		int[] y = new int[n];
		
		List<List<Integer>> list1 = new ArrayList<>();		
		BigDecimal A = new BigDecimal(a);
		BigDecimal B = new BigDecimal(b);
		BigDecimal C1 = new BigDecimal(c1);
		BigDecimal C2 = new BigDecimal(c2);
		BigDecimal M = new BigDecimal(m);	
		for(int i=0;i<n;i++){	
			List<Integer> list2 = new ArrayList<>();
			if(i==0){
				x[0] = x1;
				y[0] = y1;
				list2.add(x1);
				list2.add(y1);
				list1.add(list2);
			}
			else{
				x[i] = (A.multiply(new BigDecimal(x[i-1])).add((B.multiply(new BigDecimal(y[i-1])))).add(C1).remainder(M)).intValue();
				y[i] = (A.multiply(new BigDecimal(y[i-1])).add((B.multiply(new BigDecimal(x[i-1])))).add(C2).remainder(M)).intValue();
				int l = Math.min(x[i], y[i]);
				int r = Math.max(x[i], y[i]);
				list2.add(l);
				list2.add(r);
				list1.add(list2);
			}	
		}
		return list1;
	}
}
//改掉list<list<>>结构，等于othersolution2
class OtherSolution3{
	public OtherSolution3(Scanner in) {
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
