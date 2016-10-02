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
	public static void main(String[] args){
		Zero ex = new Zero();
		int[] a = {3,2,1};
		System.out.println(ex.maxChunk(a));
	
	

	}
    
}
