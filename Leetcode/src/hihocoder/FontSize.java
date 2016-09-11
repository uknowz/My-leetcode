package hihocoder;

import java.util.Scanner;

//微软笔试第一题 font size,AC,用时比c++多。用最大化函数做，s字母是个方的，屏幕匹配问题，word等文本处理
public class FontSize {

	/**
	 * @param args
	 */
	FontSize(Scanner in){
		int TASK = in.nextInt();
		@SuppressWarnings("unused")
		String delet = in.nextLine();//废弃的一次流
			for(int i=0;i<TASK;i++){//输出循环,几个testcase
				String args = in.nextLine();
				int[] iargs = argsCase(args);
				int[] a = new int[iargs[0]];
				for(int j=0;j<iargs[0];j++){
					a[j] = in.nextInt();
				}
				@SuppressWarnings("unused")
				String delet2 = in.nextLine();
				int output = maxfontSize(iargs[0], iargs[1], iargs[2], iargs[3], a);
				System.out.println(output);	//可以不用再重新遍历，运算的时候一起输出结果，用时减少
			}
		in.close();
		
	}
	//用来储存一个testcase的参数
	public int[] argsCase(String args){
		String[] fargs = args.split(" ");
		int[] args2 = new int[4];
		for(int i=0;i<4;i++){
			args2[i] = Integer.parseInt(fargs[i]);
		}
		return args2;
	}
	//重写了计算方法，考虑最大化函数值问题，s有范围
	public int maxfontSize(int N,int P,int W,int H,int a[]){
		int Smax = W>H?H:W;//s要赋初值的
		boolean b = true;
		if(1<=N && N<=1000 && 1<=W && W<=1000 && 1<=H && H<=1000 && 1<=P && P<=1000000 ){
			 while(b){//这个循环是减小Smax来达到目标函数，每循环一次，即计算一次
				 int character = W/Smax;
				 int lines = H/Smax;
				 int A = 0;
				 for(int i=0;i<a.length;i++){
					 A+=(a[i]/character)+(a[i]%character==0?0:1);//总行数累加计算，A作为累加载体，后面的求余是因为存在一行不满字情况，上取整
				 }
				 if(A<=P*lines){//循环边界，while do是先判断，在执行，所以存在临界点满足while但do后就不满足情况，do while相反
					 b = false;//其实可以不用，因为return不仅返回值也会结束改函数
					 return Smax;
				 }else{
					 Smax--;
				 }
			 }
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		@SuppressWarnings("unused")
		FontSize  fonts = new FontSize(in);
	}
}

