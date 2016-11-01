/**
 * 
 */
package googleJam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author mingfang.z
 * 别人的代码 time o(n*m) round d problem b sitting
 *
 * 2016-10-17
 */
public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String argv[]) throws FileNotFoundException{
		String filename = "B-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("B-large-practice-out.txt")));		
		Scanner sc = new Scanner(System.in);
		//new Main(sc);
		

		//Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int m,n;
		int result ;
		for(int i = 1;i<=t;i++){
			n = sc.nextInt();
			m = sc.nextInt();
			if(n<=2 && m<=2){
				result = n*m;
				System.out.println("Case #"+i+": "+result);
				continue;
			}
			if(n<=2 || m<=2){//有行或列小于等于2的情况
				int l = Math.max(n, m);
				//int l2 = m+n-l;
				int l2 = Math.min(m, n);
				result = l2*(l-l/3);//result = l2*(l/3*2+l%3)
				System.out.println("Case #"+i+": "+result);
				continue;
			}
			result = 0;
			for(int k = 1; k<=n; k++)
			for(int j = 1; j<=m; j++)
			{
				//if((k+j-1)%3!=0) result++;//why?
				if((k+j-1)%3==0) result++;
			}
			 System.out.println("Case #"+i+": "+ (n*m-result));
		}
		sc.close();
	}

}
