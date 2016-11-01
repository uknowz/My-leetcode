package algorithm;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

//设计算法，判断一个数组是否有重复元素（没有空间限制，用哈希表，否则用非递归堆排序）
public class CountRepeat {

	/**
	 * @param args
	 */
	// time o(n) space o(n)
	boolean repeat(int[] a){
		Map<Integer, Integer> table = new Hashtable<>();
		for(int i=0;i<a.length;i++){
			if(!table.containsKey(a[i]))
				table.put(a[i], 1);
			else
				return true;
		}
		return false;
	}
	// time o(n) space o(n)
	boolean repeat2(int[] a){
		Set<Integer> set = new HashSet<>();
		for(int temp:a){
			set.add(temp);
		}
		if(set.size()!=a.length)
			return true;
		else
			return false;
	}
	//time o(nlog) space o(1)
	boolean repeat3(int[] a){
		new HeapSort2(a);//使用堆排序
		for(int i=1;i<a.length;i++){
			if(a[i-1]==a[i])
				return true;
			
		}
		return false;
		
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a = {1,3,4,2,7,5,6,7};
		System.out.println(new CountRepeat().repeat(a));
		System.out.println(new CountRepeat().repeat2(a));
		System.out.println(new CountRepeat().repeat3(a));

	}

}
