package hihocoder;
import java.util.Scanner;
//hiho第九十二周题  Miller_Rabin素数测试 ，费马小定理和二次探测定理：http://blog.csdn.net/fisher_jiang/article/details/986654，http://blog.csdn.net/pi9nc/article/details/27209455

public class Main2 {

	/**
	 * @param args
	 * @param n为输入检验数
	 * fermat素数测试和二次探测定理，a^u mod n = 1或n-1,u=(n-1)/2,不断提出2因子，u=d*2^(r-i)
	 */
	public boolean isPrime(long n){//这个判断质数的方法还是没搞懂，重新看一看
		//Scanner input = new Scanner(System.in);真不知道这一行写了干嘛，方法的参数是外部调用的时候赋值的，
		 //n = input.nextInt();难怪每次第一行数字都不知道用来干嘛，写方法的时候就scanner了一个数
		 if(n<=2){
			 if(n==2){
				 return true;
			 }
			 return false;
		 }else if(n % 2==0){//n为不为2的偶数
			 return false;
		 }else{
			 long u = n-1;
			 while(u % 2==0){
				 u = u/2;//提取指数因子，u=d*2^i其中d为基数，写成
			 }
			 //循环多次，提高测试率，这个循环写的不对
			 for(int i=1;i<=1000;i++){//i为循环次数
				 //Random rand = new Random();
				 //long a = (long) (rand.nextDouble()*(n-2)+2);//随机选取2~n-1的数,nextint(n)随机选择0~n-1，不包括n
				 long a = (long)(Math.random()*(n-2)+2);//原理和nextdouble一样，源码里面就是调用它的，只不过一个是类，一个是方法
				 long x = (long) (Math.pow(a, u)%n);//二次探测定理,求幂运算用快速幂运算，pow的复杂度太高，计算机求幂是二进制位运算
				 /*
				  * if(x!=1){
				  * 	return false;
				  * }else{	
				  */
					 while(u<n){
						long y=((long) Math.pow(x, 2))%n;//没看懂？
						if(y==1 && x!=1 && x!=n-1)
							return false;
						x = y;
						u = u*2;
					 }
				 if(x!=1){//fermat
					 return false;
				 }
			 }
			return true;//如果循环多次，仍然x或y为1orn-1，则为true
		 }
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Main2 ma2 = new Main2();
		System.out.println("请输入数字");
		Scanner sca = new Scanner(System.in);
		/*
		int n = sca.nextInt();
		System.out.println(ma2.isPrime(n));
		*/
		
		int t = sca.nextInt();//第一行用来确定输入数组长度,题目中数组的长度10~50之间，可以用int型
		if(10<=t && t<=50){//输入数值范围
			long[] a = new long[t];//固定长度用数组，别老想着arraylist把数组都忘了，题目中每一行输入范围在10^18，所以int超出了
			boolean[] b = new boolean[t];
			for(int i=0;i<a.length;i++){
				a[i] = sca.nextLong();
				if(2<=a[i] && a[i]<=1000000000000000000l)
					b[i] = ma2.isPrime(a[i]);
			}
			for(int k=0;k<b.length;k++){
				if(b[k]==true){
					System.out.println("Yes");
				}else if(b[k]==false){
					System.out.println("No");
				}
			}
			
		}
		sca.close();
		System.exit(0);//用来解决jdk1.6的debug问题ERROR: JDWP Unable to get JNI 1.2 environment, jvm->GetEnv() return code = -2JDWP exit error AGENT_ERROR_NO_JNI_ENV(183):  [../../../src/share/back/util.c:838]
		
	}

}
