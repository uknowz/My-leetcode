package leetcode;

import java.util.HashMap;
//δ�����������ۼӺ�Ϊ����ֵ���������
public class LongestZero {

	/**
	 * @param args
	 */
	public  int maxLength(int[] arr, int k) {//����kΪ�����ۼӺͣ�
		if (arr == null || arr.length == 0) {
		return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		//map.put(0, -1); // important  ��Ҫ��Ҫ����
		int len = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
		sum += arr[i];
		if (map.containsKey(sum - k)) {
		len = Math.max(i - map.get(sum - k), len);
		}
		if (!map.containsKey(sum)) {
		map.put(sum, i);
		}
		}
		return len;
		}

	public static void main(String[] args) {
		
		// TODO �Զ����ɵķ������
		int[] array = {1,1,1,-1,-1,1,-1,-1,1};
		System.out.println(new LongestZero().maxLength(array, 0));

	}

}
