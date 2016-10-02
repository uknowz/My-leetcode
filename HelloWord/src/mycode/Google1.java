package mycode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
//随机的从一个数组中弹出一个数，并删除它
//要用random函数，又不要0那么可以加1，反正是随机产生，对数字没有要求，考官就是这个意思
public class Google1 {
	static int N = 10;
	int number = 0;
	public Google1(int inumber){
		this.number = inumber;
	}	
	public Google1() {
	}//要重载构造函数，
	//random1是给定一个int数组，随机的从里面pop出一个数，用random函数产生随机数组下标
	public void random1(){		
		ArrayList<Integer> list = new ArrayList<Integer>(N);//如果定义了长度，直接用数组方便的多
		for(int i=0; i<N; i++){
			list.add(i);
			System.out.print(list.get(i)+ " ");
		}
		//int s = list.size();后面size改变后，但是s变量值没变，不能这样做
		Random random = new Random();
		int j = random.nextInt(N);
		System.out.println(  "\n" + "the random index is:" + list.get(j));
		list.remove(list.get(j));
		System.out.println("After removing the specified index number:" );
		for(Iterator<Integer> ite = list.iterator(); ite.hasNext();){
			int array = (Integer)ite.next();
			System.out.print(array +" ");//一定要记住，print打印字符串的时候，变量+字符串空格用双引号，不用单引号
			
		}
		/*也可以用这种方式遍历，只是如果要牵扯到链表中元素的运算，用下标访问
		for(int k=0; k<list.size(); k++){
			System.out.print(list.get(k) + " ");
		}
		*/		
	}
	//random2方法用线性同余法产生随机数(其实产生的是一系列有规则的伪随机序列)
	public int random2(){		
		int out = number * 2;
		number = out;
		return out;
	}	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//int [] a = {1,2,3,4,5,6};
		Google1 a = new Google1();
		a.random1();		
		System.out.println("\n分界线----");		
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
