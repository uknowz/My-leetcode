package algorithm;

import java.util.Arrays;

public class RadixSort {

	/**
	 * @param args
	 */
	private static void radixSort(int[] array,int d)
	{
	    int n=1;//代表位数对应的数：1,10,100...
	    
	    int length=array.length;
	    int[][] bucket=new int[10][length+1];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
	    int[] order=new int[10];//用于保存每个桶里有多少个数字
	    while(n<=d) //d为未排序数组中max数
	    {
	    	int k= 0;
	        for(int num:array) //将数组array里的每个数字放在相应的桶里
	        {
	            int digit=(num/n)%10;
	            order[digit]++;
	            bucket[digit][order[digit]]=num;
	            
	        }
	        for(int i=0;i<10;i++)//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
	        {
	            if(order[i]!=0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
	            {
	                for(int j=1;j<=order[i];j++)
	                {
	                    array[k]=bucket[i][j];
	                    k++;//当循环内的计数变量不满足某一数组索引要求的时候，可以考虑新建一个变量，不一定只用循环变量
	                    //bucket[i][j] = 0;//为什么这一行可以不用复位？因为计数数组order复位了，而从二维数组中倒数据是由order数组决定的
	                }
	            }
	            order[i]=0;//将桶里计数器置0，用于下一次位排序
	        }
	        n*=10;
	        //将k置0，用于下一轮保存位排序结果
	    }
	    
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] A=new int[]{73,22, 93, 43, 55, 14, 28, 65, 39, 81,100};
	    radixSort(A, 100);
	    System.out.println(Arrays.toString(A));

	}

}
