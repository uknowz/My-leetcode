package hihocoder;
//这个类专门用来测试小程序
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Zero{
	 
	public int maxChunk(int[] a){
		int fp= a.length;
		int n = a.length;
		int imax = 0;
		for(int i=1;i<n;i++){
			if(a[i]>a[imax])
				imax = i;
			else
				fp -= 1;
		}
		return fp;
	}
	public void reverse(String s){
		int n = s.length();
		int left = 0;
		int right = n-1;
		while(left<right){
			char temp = s.charAt(left);
//			s.charAt(left) = s.charAt(right);
//			s.charAt(right) = temp;此行说明string变量本身是无法改变的，charAt函数并不能提供变量
			
		}
	}
	public static void main(String[] args){
		Zero ex = new Zero();
		int[] a = {3,2,1};
		System.out.println(ex.maxChunk(a));
		String s = "nihao";
		s.toUpperCase();
		
		System.out.println(123+"s"==null?"":"s");
	

	}
    
}
