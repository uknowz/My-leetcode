package mycode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
//����Ĵ�һ�������е���һ��������ɾ����
//Ҫ��random�������ֲ�Ҫ0��ô���Լ�1�����������������������û��Ҫ�󣬿��پ��������˼
public class Google1 {
	static int N = 10;
	int number = 0;
	public Google1(int inumber){
		this.number = inumber;
	}	
	public Google1() {
	}//Ҫ���ع��캯����
	//random1�Ǹ���һ��int���飬����Ĵ�����pop��һ��������random����������������±�
	public void random1(){		
		ArrayList<Integer> list = new ArrayList<Integer>(N);//��������˳��ȣ�ֱ�������鷽��Ķ�
		for(int i=0; i<N; i++){
			list.add(i);
			System.out.print(list.get(i)+ " ");
		}
		//int s = list.size();����size�ı�󣬵���s����ֵû�䣬����������
		Random random = new Random();
		int j = random.nextInt(N);
		System.out.println(  "\n" + "the random index is:" + list.get(j));
		list.remove(list.get(j));
		System.out.println("After removing the specified index number:" );
		for(Iterator<Integer> ite = list.iterator(); ite.hasNext();){
			int array = (Integer)ite.next();
			System.out.print(array +" ");//һ��Ҫ��ס��print��ӡ�ַ�����ʱ�򣬱���+�ַ����ո���˫���ţ����õ�����
			
		}
		/*Ҳ���������ַ�ʽ������ֻ�����Ҫǣ����������Ԫ�ص����㣬���±����
		for(int k=0; k<list.size(); k++){
			System.out.print(list.get(k) + " ");
		}
		*/		
	}
	//random2����������ͬ�෨���������(��ʵ��������һϵ���й����α�������)
	public int random2(){		
		int out = number * 2;
		number = out;
		return out;
	}	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//int [] a = {1,2,3,4,5,6};
		Google1 a = new Google1();
		a.random1();		
		System.out.println("\n�ֽ���----");		
		System.out.println("Please input a number to create the random sequence:");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		Google1 b = new Google1(input);
		for(int i=0; i<5; i++){
			System.out.print(b.random2() + " ");
		}
		scanner.close();
	}
}
