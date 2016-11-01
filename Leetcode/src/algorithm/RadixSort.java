package algorithm;

import java.util.Arrays;

public class RadixSort {

	/**
	 * @param args
	 */
	private static void radixSort(int[] array,int d)
	{
	    int n=1;//����λ����Ӧ������1,10,100...
	    
	    int length=array.length;
	    int[][] bucket=new int[10][length+1];//����Ͱ���ڱ���ÿ�������Ľ������һλ����������ͬ�����ַ���ͬһ��Ͱ��
	    int[] order=new int[10];//���ڱ���ÿ��Ͱ���ж��ٸ�����
	    while(n<=d) //dΪδ����������max��
	    {
	    	int k= 0;
	        for(int num:array) //������array���ÿ�����ַ�����Ӧ��Ͱ��
	        {
	            int digit=(num/n)%10;
	            order[digit]++;
	            bucket[digit][order[digit]]=num;
	            
	        }
	        for(int i=0;i<10;i++)//��ǰһ��ѭ�����ɵ�Ͱ������ݸ��ǵ�ԭ���������ڱ�����һλ��������
	        {
	            if(order[i]!=0)//���Ͱ�������ݣ����ϵ��±������Ͱ�������ݱ��浽ԭ������
	            {
	                for(int j=1;j<=order[i];j++)
	                {
	                    array[k]=bucket[i][j];
	                    k++;//��ѭ���ڵļ�������������ĳһ��������Ҫ���ʱ�򣬿��Կ����½�һ����������һ��ֻ��ѭ������
	                    //bucket[i][j] = 0;//Ϊʲô��һ�п��Բ��ø�λ����Ϊ��������order��λ�ˣ����Ӷ�ά�����е���������order���������
	                }
	            }
	            order[i]=0;//��Ͱ���������0��������һ��λ����
	        }
	        n*=10;
	        //��k��0��������һ�ֱ���λ������
	    }
	    
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] A=new int[]{73,22, 93, 43, 55, 14, 28, 65, 39, 81,100};
	    radixSort(A, 100);
	    System.out.println(Arrays.toString(A));

	}

}
