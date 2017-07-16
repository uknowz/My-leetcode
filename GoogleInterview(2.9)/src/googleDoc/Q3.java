package googleDoc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * ��һ���ַ�����Ƶ����ߵ��ַ���˵�����Ӷ�
 */
public class Q3 {
	public static void main(String[] args){
		new Q3().arrayMethod("sdisdisjafjni");
		System.out.println((int)'a');
	}
	/*
	 * time O(N) space O(N)
	 * ʹ��hashmap����¼�ַ�����Ƶ�ʣ�������map entry scanһ�������ֵ
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
		//����hashmap��entry��getkey��getvalue
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
		int[] array=new int[26];//��¼�ַ����ֵĴ���
		
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
