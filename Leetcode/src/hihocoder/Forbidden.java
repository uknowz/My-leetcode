package hihocoder;
import java.util.Scanner;
//微软笔试第二题 403 forbidden，第四版运行成功,改变存放rules结构，不把allow和deny分开，按rules顺序匹配(字符串匹配处理,未加前缀树)，时间复杂度粗略估计为o(n^2)
//算是暴力求解把，没有用到任何算法，只是一一遍历字符串
public class Forbidden {
	private static class IPtoInt {//定义为内部静态类，只能该类使用，内部非静态类不是定义静态成员
	    // 重写了方法，将ip地址转换为二进制。这个方法不错，比原方法简单
	    public static String ipToint(String strIP) {
	        String[] ip = new String[4];
	        String zero = "00000000";//用来补位的
	        String[] ipstr = strIP.split("\\.");
	        //整形转换为字符串二进制，tobinarystring这个函数本身，就不会补八位
	        ip[0] = Integer.toBinaryString(Integer.parseInt(ipstr[0]));
	        ip[1] = Integer.toBinaryString(Integer.parseInt(ipstr[1]));
	        ip[2] = Integer.toBinaryString(Integer.parseInt(ipstr[2]));
	        ip[3] = Integer.toBinaryString(Integer.parseInt(ipstr[3]));
	        for(int i=0;i<4;i++){
	        	if(ip[i].length()<8){
	        		ip[i] =zero.substring(0,8-ip[i].length()) + ip[i];//如果每一段ip不足八位，那么用字符串加法高位补0,不用循环，一次性补0，因为ip.length()一直会变  
	        	}
	        }
	        return ip[0]+ip[1]+ip[2]+ip[3];
	    }
	 } 

	Forbidden(Scanner in){
		int N = in.nextInt();
		int M = in.nextInt();
		@SuppressWarnings("unused")
		String delete = in.nextLine();//读取到末尾，需要换行时，要多读一个string.nextline()
		if(1<=N && M<=100000){
			String[] rules = new String[N];//读取rules数组
			for(int i=0;i<N;i++){
				rules[i] = in.nextLine();
			}
			String[] request = new String[M];//读取request数组
			for(int j=0;j<M;j++){
				request[j] = in.nextLine();
			}
			/*
			 * @param output[]为输出结果
			 * 这个两层循环遍历每一个request是否匹配rules
			 */
			String[] output = new String[M];
			for(int j=0;j<M;j++){
				for(int i =0;i<N;i++){
					output[j]=matchRules(request[j], rules[i]);
					if(output[j].equals("noMatch")){
						if(i==N-1) output[j] = "YES";//可以最后一次再赋值，不用每次赋值yes
						continue;
					}else{
						break;
					}
						
				}
				System.out.println(output[j]);
			}		
		}
		in.close();
	}
	
	/*
	 * @param n为rules个数，此方法用来封装rules
	 * @param s为每一行读取的rules string
	 */
	public String matchRules(String request,String rules){
		
		String[] ruleSplit = rules.split(" ");//把rules前面的标记和ip分割
		if(ruleSplit[0].equals("allow")){
			if(request.equals(ruleSplit[1])){
				return "YES";
			}else if(ruleSplit[1].contains("/")){
				String requBina = IPtoInt.ipToint(request);
				String[] ruleSplit2 = ruleSplit[1].split("/");//rule后面有/的分割
				int mask = Integer.parseInt(ruleSplit2[1]);
				String ruleBina = IPtoInt.ipToint(ruleSplit2[0]);
				if(requBina.substring(0,mask).equals(ruleBina.substring(0,mask))){
					return "YES";
				}
			}
		}else if(ruleSplit[0].equals("deny")){
			if(request.equals(ruleSplit[1])){
				return "NO";
			}else if(ruleSplit[1].contains("/")){
				String requBina = IPtoInt.ipToint(request);
				String[] ruleSplit2 = ruleSplit[1].split("/");//rule后面有/的分割
				int mask = Integer.parseInt(ruleSplit2[1]);
				String ruleBina = IPtoInt.ipToint(ruleSplit2[0]);
				if(requBina.substring(0,mask).equals(ruleBina.substring(0,mask))){
					return "NO";
				}
			}
		}
		return "noMatch";//如果没有匹配这条rules，则返回特定字符串，用以继续匹配下一条rules，这也是顺序匹配的关键词。
		//因为题目的匹配规则是：对request一条一条匹配rules，如果顺序匹配中任意一条rule，即返回信息，停止下面rules的匹配，所以，这意味着，我的匹配方法，不应该写成rules集合匹配，返回结果数组
		//应该是单条rule匹配，返回单个匹配结果，利用单个结果去判断整体匹配结果。
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		@SuppressWarnings("unused")
		Forbidden forbidden = new Forbidden(in);
		

	}
	
}

 

