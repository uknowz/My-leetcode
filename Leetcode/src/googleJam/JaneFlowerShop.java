package googleJam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;
//此题不仅求解方程，对结果的精确度要求高，大数运算，因为small数据只是一次和二次方程，易求，可以先算出来
//java的输出数据格式要规定，format,数据输出精度只能大不能减，double>float
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
				System.out.println(String.format("Case #%d: %.12f", t,irr(c,m)));//格式化输出，保留double数据小数点后12位
			}
		}
	}
	//计算参数r的方程函数值
	public BigDecimal compute(long[] c,int m,double r){
		BigDecimal r1 = new BigDecimal(1+r);
		BigDecimal res = new BigDecimal(c[0]).multiply(r1.pow(m)).negate();//初值,用的是bigdecimal的pow不是math的pow
		for(int i=1;i<=m;i++){
			res = res.add(new BigDecimal(c[i]).multiply(r1.pow(m-i)));
		}
		return res;
	}
	
	//二分查找r在区间(-1,1)中，先用非递归,返回r。这里要将方程转换为单调函数，才能判断value>0时取r区间的哪一部分
	public double irr(long[] c,int m){
		double low = -1;
		double high = 1;	
		while(high - low>=0.000000000001){//这只是控制了小数点后12位的精度，但如果high，low并不相等，到达小数点后13位且方程值仍不为0的话，就会跳出循环
			double middle = (low+high)/2;//>>1只有int型有
			BigDecimal value = compute(c,m,middle);
			if(value.compareTo(new BigDecimal(0.0))==0) return middle;//Double.valueOf(double d)是double的包装类，将基本类型转换为类的对象
			else if(value.compareTo(new BigDecimal(0.0))>0){
				low = middle + 0.000000000001;//因为在区间里，函数值value是逆序的
			}else if(value.compareTo(new BigDecimal(0.0))<0){
				high = middle - 0.000000000001;
			}			
		}
		return low;//所以为了在控制的精度内返回r值，就当做当high和low相差小于1e-12时，当做两者相等，查找结束，
	}
	
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		String filename = "C-small-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("C-small-practice-out.txt")));		
		Scanner in = new Scanner(System.in);
		new JaneFlowerShop(in);
		in.close();

	}

}
//别人的代码
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
		// TODO 自动生成的方法存根
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

