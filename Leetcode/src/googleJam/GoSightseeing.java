package googleJam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class GoSightseeing {
	long[][] city;
	
	public static void main(String[] args) throws FileNotFoundException {
		String filename = "A-small-attempt1.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("A-lyt.txt")));		
		Scanner in = new Scanner(System.in);
		new GoSightseeing(in);
		in.close();
	

}
	public GoSightseeing(Scanner in){
		int T = in.nextInt();
		for(int t=0;t<T;t++){
			int N =in.nextInt();
			long Ts=in.nextLong();
			long Tf=in.nextLong();
			long[][] city = new long[N-1][3];
			for(int k=0;k<N-1;k++){
				for(int y=0;y<3;y++){
					city[k][y]=in.nextLong();
				}
			}
			sightseeing(N, Ts, Tf, city);
		}
	}
	public void sightseeing(int N, Long Ts, Long Tf, long[][] city) {
		Long[] s = new Long[N -1];
		Long[] f = new Long[N -1];
		Long[] d = new Long[N -1];
		
		for (int i = 0; i < N -1; i++) {
			s[i] = city[i][0];
			s[i] = city[i][1];
			s[i] = city[i][2];
		}
		solution(N, Ts, Tf, s, f, d);
	}
	public static void solution(int N, Long ts, Long tf, Long[] s, Long[] f, Long[] d) {
		
		
		Node pre = null;
		for (int i = (N - 2); i >= 0; i--) {
			if (i == N -2) {
				Node n = new Node();
				n.m.put((tf - d[N -2]),0l);
				n.m.put((tf - d[N -2] - ts),1l);
				pre = n;
			} else {
				 Iterator iter = pre.m.keySet().iterator();
				 Node x = new Node();
				 
				 while(iter.hasNext()) {
			            Long j = (Long)iter.next();
			            Long num = pre.m.get(j);
			            j -= d[i];
			            if (j > s[i]) {
			            	if ((j - s[i]) % f[i] != 0) {
				            	j -= ((j - s[i]) % f[i]);
				            }
				            x.m.put(j, num);
				            
				            x.m.put(j - ts, num + 1);
			            }
			            
				 }
				pre = x;
			}
		    
		}
		
		Long max = -1l;
		Iterator iter = pre.m.keySet().iterator();
		while(iter.hasNext()) {
			Long j = (Long)iter.next();
			Long num = pre.m.get(j);
			
			if (num > max && j >= s[0]) {
				max = num;
			}
		}
		System.out.println(max);
	}
static class Node {
	Map<Long, Long> m = new HashMap <Long, Long>();
}
}
