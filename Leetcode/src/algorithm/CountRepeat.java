package algorithm;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

//����㷨���ж�һ�������Ƿ����ظ�Ԫ�أ�û�пռ����ƣ��ù�ϣ�������÷ǵݹ������
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
		new HeapSort2(a);//ʹ�ö�����
		for(int i=1;i<a.length;i++){
			if(a[i-1]==a[i])
				return true;
			
		}
		return false;
		
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a = {1,3,4,2,7,5,6,7};
		System.out.println(new CountRepeat().repeat(a));
		System.out.println(new CountRepeat().repeat2(a));
		System.out.println(new CountRepeat().repeat3(a));

	}

}
