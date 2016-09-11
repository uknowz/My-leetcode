package leetcode;

public class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        else{
            int[] ways = new int[n+1];
            for(int i=0;i<n+1;i++){
                if(i==0) ways[i] = 0;//³õÊ¼»¯
                if(i==1) ways[i] = 1;
                else ways[i] = ways[i-2] + ways[i-1]; 
            }
            return ways[n];
        }
    }
    public static void main(String[] args){
    	Solution ex = new Solution();
    	System.out.println(ex.climbStairs(2));
    }
}