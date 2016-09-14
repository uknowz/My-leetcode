package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
	       if(s.length()==1) return 1;
	       Map<Character,Integer> map = new HashMap<>();
	       int sum = 0;
	       int i = 0;//head index
	       for(int j=0;j<s.length();j++){
	           if(!map.containsKey(s.charAt(j))){
	               map.put(s.charAt(j),j);
	               sum = Math.max(sum,j-i+1);
	           }
	           else{
	        	 //用头指针表示子串起点，头指针以前子串相当于map.clear(),不需要用map多次记录不重复子串，用两个指针i，j来表示
	               i = Math.max(map.get(s.charAt(j))+1,i);
	               sum = Math.max(sum,j-i+1);
	               map.put(s.charAt(j),j);
	               
	           }
	       }
	       return sum;
	}
    public static void main(String[] args){
    	System.out.println(new LongestSubstring().lengthOfLongestSubstring("asdfg"));
    }
}