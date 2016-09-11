package hihocoder;
import java.util.Scanner;
//hiho�ھ�ʮ������  Miller_Rabin�������� ������С����Ͷ���̽�ⶨ��http://blog.csdn.net/fisher_jiang/article/details/986654��http://blog.csdn.net/pi9nc/article/details/27209455

public class Main2 {

	/**
	 * @param args
	 * @param nΪ���������
	 * fermat�������ԺͶ���̽�ⶨ��a^u mod n = 1��n-1,u=(n-1)/2,�������2���ӣ�u=d*2^(r-i)
	 */
	public boolean isPrime(long n){//����ж������ķ�������û�㶮�����¿�һ��
		//Scanner input = new Scanner(System.in);�治֪����һ��д�˸�������Ĳ������ⲿ���õ�ʱ��ֵ�ģ�
		 //n = input.nextInt();�ѹ�ÿ�ε�һ�����ֶ���֪���������д������ʱ���scanner��һ����
		 if(n<=2){
			 if(n==2){
				 return true;
			 }
			 return false;
		 }else if(n % 2==0){//nΪ��Ϊ2��ż��
			 return false;
		 }else{
			 long u = n-1;
			 while(u % 2==0){
				 u = u/2;//��ȡָ�����ӣ�u=d*2^i����dΪ������д��
			 }
			 //ѭ����Σ���߲����ʣ����ѭ��д�Ĳ���
			 for(int i=1;i<=1000;i++){//iΪѭ������
				 //Random rand = new Random();
				 //long a = (long) (rand.nextDouble()*(n-2)+2);//���ѡȡ2~n-1����,nextint(n)���ѡ��0~n-1��������n
				 long a = (long)(Math.random()*(n-2)+2);//ԭ���nextdoubleһ����Դ��������ǵ������ģ�ֻ����һ�����࣬һ���Ƿ���
				 long x = (long) (Math.pow(a, u)%n);//����̽�ⶨ��,���������ÿ��������㣬pow�ĸ��Ӷ�̫�ߣ�����������Ƕ�����λ����
				 /*
				  * if(x!=1){
				  * 	return false;
				  * }else{	
				  */
					 while(u<n){
						long y=((long) Math.pow(x, 2))%n;//û������
						if(y==1 && x!=1 && x!=n-1)
							return false;
						x = y;
						u = u*2;
					 }
				 if(x!=1){//fermat
					 return false;
				 }
			 }
			return true;//���ѭ����Σ���Ȼx��yΪ1orn-1����Ϊtrue
		 }
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Main2 ma2 = new Main2();
		System.out.println("����������");
		Scanner sca = new Scanner(System.in);
		/*
		int n = sca.nextInt();
		System.out.println(ma2.isPrime(n));
		*/
		
		int t = sca.nextInt();//��һ������ȷ���������鳤��,��Ŀ������ĳ���10~50֮�䣬������int��
		if(10<=t && t<=50){//������ֵ��Χ
			long[] a = new long[t];//�̶����������飬��������arraylist�����鶼���ˣ���Ŀ��ÿһ�����뷶Χ��10^18������int������
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
		System.exit(0);//�������jdk1.6��debug����ERROR: JDWP Unable to get JNI 1.2 environment, jvm->GetEnv() return code = -2JDWP exit error AGENT_ERROR_NO_JNI_ENV(183):  [../../../src/share/back/util.c:838]
		
	}

}
