package googleJam;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
//这道题应用于多进程共享资源
public class WatsonandIntervals {

	/**
	 * @param args
	 */
	public WatsonandIntervals(Scanner in) {
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
			
		}
	}
	public List<Interval>
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		String filename = "C-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("C-large-practice-out.txt")));
		Scanner in = new Scanner(System.in);
		new WatsonandIntervals(in);
		in.close();
	}
	

}
//用list<list<integer>>当做一维区间结构的笨代码，o(n^2),small ac
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
