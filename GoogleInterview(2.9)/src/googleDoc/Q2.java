package googleDoc;

import java.util.Arrays;

/*
 * You are given a int[N] array num, count how many triplets (x, y, z) that
 * num[x] + num[y] + num[z] < K
 * assuming x < y < z
 * ¿ÉÒÔsort
 */

public class Q2 {
	public static void main(String[] args) {
		int[] nums = { 5, 3, 6, 1, 8, 10 };
		int K = 13;
		System.out.println(new Q2().count(nums, nums.length, K));

	}

	public int count(int[] nums, int N, int K) {
		Arrays.sort(nums);
		int count = 0;
		for (int x = 0; x < N - 2; x++) {
			int y = x + 1;
			int z = N - 1;
			while (y < z) {
				if (nums[x] + nums[y] + nums[z] < K) {
					count = count + z - y;
					y++;
				} else {
					z--;
				}
			}
		}
		return count;

	}

}
