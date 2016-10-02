package googleJam;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MonsterPath2{
	double max;
	MonsterPath2(Scanner in){
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			max = 0;
			int R = in.nextInt();
			int C = in.nextInt();
			int Rs = in.nextInt();
			int Cs = in.nextInt();
			int S = in.nextInt();
			double P = in.nextDouble();
			double Q = in.nextDouble();
			Grid[][] gridP = new Grid[R][C];//只用网格储存概率值就行
			for(int i=0;i<R;i++){
				for(int j=0;j<C;j++){
					gridP[i][j] = new Grid(in.next().charAt(0),in.next().charAt(0)=='A'?P:Q);//直接将单个string字符改成char
				}
			}
			Grid[][] g1 = new Grid[R][C];
			Grid[][] g2 = new Grid[R][C];
			Grid[][] g3 = new Grid[R][C];
			Grid[][] g4 = new Grid[R][C];
			for(int i=0;i<R;i++){
				System.arraycopy(gridP[i], 0, g1[i], 0, R);
			}
			for(int i=0;i<R;i++){
				System.arraycopy(gridP[i], 0, g2[i], 0, R);
			}
			for(int i=0;i<R;i++){
				System.arraycopy(gridP[i], 0, g3[i], 0, R);
			}
			for(int i=0;i<R;i++){
				System.arraycopy(gridP[i], 0, g4[i], 0, R);
			}
			dfs(g1,Rs-1,Cs,0,S,P,Q);
			dfs(g1,Rs+1,Cs,0,S,P,Q);
			dfs(g1,Rs,Cs-1,0,S,P,Q);
			dfs(g1,Rs,Cs+1,0,S,P,Q);
			System.out.println(String.format("Case #%d: %.7f",t,max));
		}
	}
	public static void main(String[] args) throws FileNotFoundException{
		//String filename = "A-large-practice.in";
		//System.setIn(new FileInputStream(filename));	
		//System.setOut(new PrintStream(new FileOutputStream("A-large-practice-out2.txt")));
		Scanner in = new Scanner(System.in);
		new MonsterPath2(in);
		in.close();
	}
	void dfs(Grid[][] gridP,int i,int j,int step,int S,double P,double Q){
		double count = 0;
		if(i<0||i>=gridP.length||j<0||j>=gridP[0].length) 
			return;
		if(step==S){
			max = Math.max(max, count);//在递归最远处将计算概率值记录
			return;
		}
		double basep = gridP[i][j].a=='A'?P:Q;
		count += gridP[i][j].p;
		gridP[i][j].p = (1-gridP[i][j].p)*basep;
		dfs(gridP, i-1, j, step+1, S, P, Q);
		dfs(gridP, i+1, j, step+1, S, P, Q);
		dfs(gridP, i, j-1, step+1, S, P, Q);
		dfs(gridP, i, j+1, step+1, S, P, Q);
		
	}
	
	class Grid{
		char a;
		double p;
		Grid(char a,double p){
			this.a = a;
			this.p = p;
		}
	}
}

