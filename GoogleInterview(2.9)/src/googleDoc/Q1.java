package googleDoc;

import test.Test;

/*
 * Write a function that takes in a string and returns the
 * length of the longest string prefix in which all characters are arranged 
 * in alphabetical order.  
 * Use the language with which you are the most familiar.
 */
public class Q1 {
	public static void main(String[] args){
		String str = "inht";
		System.out.println(str.substring(0, 1));//endindex不包含在内，所以索引i+1求前缀时
		System.out.println(new Q1().alpnaprefix("knotty"));
		//定义函数的时候可以直接调用另一个函数，但是在执行函数的时候，必须指明静态调用还是实例调用
	}
	
	public int alpnaprefix(String str){
		int longest = 1;
		if(str.length()==0){
			return 0;
		}else{
			for(int i=0;i<str.length()-1;){
				if(str.charAt(i)<=str.charAt(i+1)){
					longest++;
					i++;
				}else
					break;
			}
			return longest;
		}
		
		
	}

}
