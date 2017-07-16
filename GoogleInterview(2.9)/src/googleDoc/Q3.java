package googleDoc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * 找一个字符串中频率最高的字符，说明复杂度
 */
public class Q3 {
	public static void main(String[] args){
		new Q3().arrayMethod("sdisdisjafjni");
		System.out.println((int)'a');
	}
	/*
	 * time O(N) space O(N)
	 * 使用hashmap来记录字符出现频率，再利用map entry scan一遍找最大值
	 */
	public void hashMethod(){
		String str = "sdisdisjafjni";
		char ch=' ';
		int n=str.length();
		Map<Character, Integer> map=new HashMap<>(26);
		for(int i=0;i<n;i++){
			if(!map.containsKey(str.charAt(i))){
				map.put(str.charAt(i), 1);
			}else{
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}
		}
		//借用hashmap的entry来getkey和getvalue
		Set entryset=map.entrySet();
		int count=0;
		for(Iterator iterator=entryset.iterator();iterator.hasNext();){
			Entry entry=(Entry) iterator.next();
			count=Math.max(count, (int)entry.getValue());
		}
		for(Iterator iterator=entryset.iterator();iterator.hasNext();){
			Entry entry=(Entry) iterator.next();
			
			if(entry.getValue().equals(count)){
				ch=(char) entry.getKey();
				System.out.println(ch);
			}
		}
	}
	
	public void arrayMethod(String str){
		char[] strArray=str.toCharArray();
		int[] array=new int[26];//记录字符出现的次数
		
		for(int i=0;i<strArray.length;i++){
			array[strArray[i]-'a']++;
		}
		int count=array[0];
		for(int j=1;j<array.length;j++){
			count=Math.max(count, array[j]);
		}
		for(int i=0;i<array.length;i++){
			if(array[i]==count){
				System.out.println((char)(i+'a'));
			}
		}
		
	}
}
