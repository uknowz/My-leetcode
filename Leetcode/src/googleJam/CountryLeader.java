package googleJam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CountryLeader {
	
	ArrayList<Character> list = new ArrayList<>();
	
	public CountryLeader(Scanner in) {
		
			int T = in.nextInt();
			for(int t=1;t<=T;t++){
				int result=0;
				int index=0;//每次循环都要重新赋初值，那么就应该放在循环的开头
				int n = in.nextInt();
				String[] names = new String[n];
				@SuppressWarnings("unused")
				String dele = in.nextLine();
				for(int i=0;i<n;i++){
					
					names[i] = in.nextLine();//人名放在数组里
					if(differLetter(names[i])>result){
						index = i;
						result = differLetter(names[index]);
					}else if(differLetter(names[i])==result){
						if(names[i].compareTo(names[index])<0){
							index = i;
							result = differLetter(names[index]);
						}
						/*
						for(int j=0;j<Math.min(names[i].length(),names[index].length());j++){
							if(names[index].charAt(j)<names[i].charAt(j)){
								break;
							}else if(names[index].charAt(j)==names[i].charAt(j)) continue;
							else{
								index = i;
								result = differLetter(names[index]);
							}
								
						}*/
						
					}
				}
				System.out.println("Case #"+t+": "+names[index]);
			}
		
		
	}
	public static void main(String[] args) throws Exception{
		// TODO 自动生成的方法存根
		
		String filename = "A-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("A-large-practice-out.txt")));
		Scanner in = new Scanner(System.in);
		new CountryLeader(in);
		in.close();

	}
	public int differLetter(String str){
		int count = 0;
		for(int i=0;i<str.length();i++){
			if(!list.contains(str.charAt(i)) && (str.charAt(i)!=' ')){
				list.add(str.charAt(i));//使用了26个额外的空间复杂度，但是常数级空间算O(1)还是O(N)
				count++;
			}
		}
		list.clear();
		return count;
	}

}
