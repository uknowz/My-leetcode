package hihocoder;

import java.util.Scanner;

//΢����Ե�һ�� font size,AC,��ʱ��c++�ࡣ����󻯺�������s��ĸ�Ǹ����ģ���Ļƥ�����⣬word���ı�����
public class FontSize {

	/**
	 * @param args
	 */
	FontSize(Scanner in){
		int TASK = in.nextInt();
		@SuppressWarnings("unused")
		String delet = in.nextLine();//������һ����
			for(int i=0;i<TASK;i++){//���ѭ��,����testcase
				String args = in.nextLine();
				int[] iargs = argsCase(args);
				int[] a = new int[iargs[0]];
				for(int j=0;j<iargs[0];j++){
					a[j] = in.nextInt();
				}
				@SuppressWarnings("unused")
				String delet2 = in.nextLine();
				int output = maxfontSize(iargs[0], iargs[1], iargs[2], iargs[3], a);
				System.out.println(output);	//���Բ��������±����������ʱ��һ������������ʱ����
			}
		in.close();
		
	}
	//��������һ��testcase�Ĳ���
	public int[] argsCase(String args){
		String[] fargs = args.split(" ");
		int[] args2 = new int[4];
		for(int i=0;i<4;i++){
			args2[i] = Integer.parseInt(fargs[i]);
		}
		return args2;
	}
	//��д�˼��㷽����������󻯺���ֵ���⣬s�з�Χ
	public int maxfontSize(int N,int P,int W,int H,int a[]){
		int Smax = W>H?H:W;//sҪ����ֵ��
		boolean b = true;
		if(1<=N && N<=1000 && 1<=W && W<=1000 && 1<=H && H<=1000 && 1<=P && P<=1000000 ){
			 while(b){//���ѭ���Ǽ�СSmax���ﵽĿ�꺯����ÿѭ��һ�Σ�������һ��
				 int character = W/Smax;
				 int lines = H/Smax;
				 int A = 0;
				 for(int i=0;i<a.length;i++){
					 A+=(a[i]/character)+(a[i]%character==0?0:1);//�������ۼӼ��㣬A��Ϊ�ۼ����壬�������������Ϊ����һ�в������������ȡ��
				 }
				 if(A<=P*lines){//ѭ���߽磬while do�����жϣ���ִ�У����Դ����ٽ������while��do��Ͳ����������do while�෴
					 b = false;//��ʵ���Բ��ã���Ϊreturn��������ֵҲ������ĺ���
					 return Smax;
				 }else{
					 Smax--;
				 }
			 }
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner in = new Scanner(System.in);
		@SuppressWarnings("unused")
		FontSize  fonts = new FontSize(in);
	}
}

