package leetcode;

import java.util.HashMap;
//未排序数组中累加和为给定值的最长子数组
public class LongestZero {

	/**
	 * @param args
	 */
	public  int maxLength(int[] arr, int k) {//参数k为给定累加和，
		if (arr == null || arr.length == 0) {
		return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		//map.put(0, -1); // important  ？要不要加上
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
		
		// TODO 自动生成的方法存根
		int[] array = {1,1,1,-1,-1,1,-1,-1,1};
		System.out.println(new LongestZero().maxLength(array, 0));

	}

}
