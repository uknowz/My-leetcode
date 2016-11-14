/**
 * 
 */
package googleJam;

/**
 * @author mingfang.z
 *
 * 2016-11-2
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CodejamonCipher{
	static long[] f;
	static int CASE_LIMIT;
	static int V,S;
	static HashMap<String, Integer> map;
	private static String rearrange(String x)
	{
		char[] cs = x.toCharArray();
		Arrays.sort(cs);
		return new String(cs);
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		CASE_LIMIT = scanner.nextInt();
		for (int CASE=1; CASE<=CASE_LIMIT; CASE++)
		{
			System.out.print("Case #"+CASE+":");
			
			V = scanner.nextInt();
			S = scanner.nextInt();
			
			map = new HashMap<>();
			
			for (int i=0; i<V; i++)
			{
				String voca = scanner.next();
				addVoca(voca);
			}
			
			for (int i=0; i<S; i++)
			{
				String sent = scanner.next();
				long result = getPossible(sent);
				System.out.print(" "+result);
			}
			System.out.println();
		}
	}

	private static long func(String sent, int i) {
		if (i==sent.length())
			return 1;
		if (f[i]!=-1)
			return f[i];
		
		long result = 0;
		for (int j=i+1; j<=sent.length(); j++)
		{
			if (func(sent, j)==0)
				continue;
			
			result += getVoca(sent.substring(i, j)) * func(sent, j);
			result = result % 1000000007;
		}
		
		f[i] = result;
		return f[i];
	}
	
	private static long getPossible(String sent) {
		f = new long[sent.length()];
		Arrays.fill(f, -1);
		return func(sent, 0);
	}

	private static long getVoca(String voca)
	{
		Integer result = map.get(rearrange(voca));
		if (result==null)
			return 0;
		return result;
	}
	
	private static void addVoca(String voca) 
	{
		String trans = rearrange(voca);
		if (map.containsKey(trans))
		{
			map.put(trans, map.get(trans)+1);
		}
		else {
			map.put(trans, 1);
		}
	}
}

