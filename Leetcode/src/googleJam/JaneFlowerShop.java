package googleJam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;
//���ⲻ����ⷽ�̣��Խ���ľ�ȷ��Ҫ��ߣ��������㣬��Ϊsmall����ֻ��һ�κͶ��η��̣����󣬿����������
//java��������ݸ�ʽҪ�涨��format,�����������ֻ�ܴ��ܼ���double>float
public class JaneFlowerShop {

	JaneFlowerShop(Scanner in){
		while(in.hasNext()){
			int T = in.nextInt();
			for(int t = 1;t<=T;t++){
				int m = in.nextInt();
				long[] c = new long[m+1];
				for(int i=0;i<=m;i++){
					c[i] = in.nextLong();
				}
				System.out.println(String.format("Case #%d: %.12f", t,irr(c,m)));//��ʽ�����������double����С�����12λ
			}
		}
	}
	//�������r�ķ��̺���ֵ
	public BigDecimal compute(long[] c,int m,double r){
		BigDecimal r1 = new BigDecimal(1+r);
		BigDecimal res = new BigDecimal(c[0]).multiply(r1.pow(m)).negate();//��ֵ,�õ���bigdecimal��pow����math��pow
		for(int i=1;i<=m;i++){
			res = res.add(new BigDecimal(c[i]).multiply(r1.pow(m-i)));
		}
		return res;
	}
	
	//���ֲ���r������(-1,1)�У����÷ǵݹ�,����r������Ҫ������ת��Ϊ���������������ж�value>0ʱȡr�������һ����
	public double irr(long[] c,int m){
		double low = -1;
		double high = 1;	
		while(high - low>=0.000000000001){//��ֻ�ǿ�����С�����12λ�ľ��ȣ������high��low������ȣ�����С�����13λ�ҷ���ֵ�Բ�Ϊ0�Ļ����ͻ�����ѭ��
			double middle = (low+high)/2;//>>1ֻ��int����
			BigDecimal value = compute(c,m,middle);
			if(value.compareTo(new BigDecimal(0.0))==0) return middle;//Double.valueOf(double d)��double�İ�װ�࣬����������ת��Ϊ��Ķ���
			else if(value.compareTo(new BigDecimal(0.0))>0){
				low = middle + 0.000000000001;//��Ϊ�����������ֵvalue�������
			}else if(value.compareTo(new BigDecimal(0.0))<0){
				high = middle - 0.000000000001;
			}			
		}
		return low;//����Ϊ���ڿ��Ƶľ����ڷ���rֵ���͵�����high��low���С��1e-12ʱ������������ȣ����ҽ�����
	}
	
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		String filename = "C-small-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("C-small-practice-out.txt")));		
		Scanner in = new Scanner(System.in);
		new JaneFlowerShop(in);
		in.close();

	}

}
//���˵Ĵ���
class JaneFlowerShop2 {

	/**
	 * @param args
	 */
	JaneFlowerShop2(Scanner scan){
		int testNum = scan.nextInt();
        int[] cost = new int[testNum];
        int[][] profit = new int[testNum][];
        for (int i = 0; i < testNum; i++) {
            int months = scan.nextInt();
            profit[i] = new int[months];
            cost[i] = scan.nextInt();
            for (int j = 0; j < months; j++) {
                profit[i][j] = scan.nextInt();
            }
        }
		for (int i = 0; i < testNum; i++) {
            double irr = recurrent(cost[i], profit[i], -1, 1);
            System.out.println(String.format("Case #%d: %.12f", i+1, irr));
        }
	}
	/*
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		String filename = "C-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("C-large-practice-out2.txt")));		
		Scanner in = new Scanner(System.in);
		new JaneFlowerShop2(in);
		in.close();
	}*/
	private static double recurrent(int cost, int[] profit, double leftR, double rightR) {
		/*
        if (rightR - leftR < 0.000000000001) {
            return leftR;
        }*/
		while(rightR-leftR>=0.000000000001){	
        double mid = (leftR + rightR) / 2;
        BigDecimal midResult = compute(cost, profit, mid);
        int compare = midResult.compareTo(new BigDecimal(0.0));
        if (compare == 0) {
            return mid;
        } else if (compare == 1) {
            return recurrent(cost, profit, mid+0.000000000001, rightR);
        } else {
            return recurrent(cost, profit, leftR, mid-0.000000000001);
        }
		}
		return leftR;
    }

    private static BigDecimal compute(int cost, int[] profit, double r) {
        int months = profit.length;

        BigDecimal mul = new BigDecimal(1+r);
        BigDecimal result = mul.pow(months).multiply(new BigDecimal(cost)).negate();
        for (int i = months - 1; i >= 0; i--) {
            result = result.add(mul.pow(months - i - 1).multiply(new BigDecimal(profit[i])));
        }

        return result;
    }

}

