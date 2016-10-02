package mycode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Google2 {

//写完程序自己单元测试一遍，可以提高程序正确率
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Google2 test = new Google2();
		/*命令行参数
		if(args.length<0){
			System.out.println("error");
			System.exit(1);
		}else{
			int x1 = Integer.parseInt(args[0]);
			test.method(x1);
		}
		*/
		Scanner sca = new Scanner(System.in);
		System.out.println("Please input a number!");
		if(sca.hasNext()){
			int temp = sca.nextInt();
			test.method(temp);
		}else{
			System.out.println("The wrong number");
			System.exit(1);
		}
		sca.close();
	}
	public void method (int x){
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Character> b = new ArrayList<>();
		
		int r = x;
		int m;
		if(x % 26 !=0){
			//下面这个循环是除k取余法，记住（以26为例）
			for(;;){//还可以改改，看用r！=0这个条件可不可以，一直add的是m余数
				m = r % 26;
				r = r / 26;
				if(r>26){//这一部分是一直除以26，并将余数存入list a里面
					a.add(m);
				}
				if(r<26 && r!=0){//这一部分是当除到最后余数的时候，r不是商了，也要把r放进list a
					a.add(m);
					a.add(r);
					break;
				}if(r==0){//一开始除以26就没有商的，即小于26的数，这时商为0，把第一次取模的值放入即可
					a.add(m);
					break;
				}
			}
			//用来验证method方法写的正不正确，除k取余法正确
			for(Iterator<Integer> ite = a.iterator(); ite.hasNext();){
				int array = ite.next();
				System.out.print(array +" ");//一定要记住，print打印字符串的时候，变量+字符串空格用双引号，不用单引号
				
			}
			
			for(int i=0;i<a.size();i++){
				int num = a.get(i)-1;
				char chr = (char)('A'+num);//用来将求得的26进制转换为字符串，每一位对应一个字符
				b.add(chr); 
			}
			System.out.println("\n" + "result is:");//换行符要加双引号
			for(int j=b.size()-1; j>=0; j--){
				System.out.print(b.get(j));//为什么会indexoutofbound，因为你j从最大开始算，但是list的索引还是size-1
			}
			
		}else{//考虑边界值问题，能除尽26的话，不会
			for(;r>=26;){
				m = r % 26;
				r = r / 26;
				a.add(m);
			}
			a.add(r);//最后一个数添加进去
			for(Iterator<Integer> ite = a.iterator(); ite.hasNext();){
				int array = ite.next();
				System.out.print(array +" ");//一定要记住，print打印字符串的时候，变量+字符串空格用双引号，不用单引号
				
			}
			b.add('z');
			for(int i=1;i<a.size();i++){
				if(a.get(i)==1){
					b.add('z');
					continue;
				}else if(a.get(i)>1){
					int num3 = a.get(i)-2;
					char chr2 = (char) ('A' + num3);
					
					
				}
				
			}
		}
	}

}
