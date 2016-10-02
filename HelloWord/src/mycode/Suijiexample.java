package mycode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
//随机在1~36中生成7个数并放入同一个数组中h
public class Suijiexample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Random random=new Random();
		//int [] r=new int[7];
		ArrayList<Integer> list = new ArrayList<>(7);
		
		System.out.print("你好");
		for (int i = 0; i <list.size(); i++) {
			
			int temp=random.nextInt(37);//产生0~36随机数，不包括指定value
			//不产生随机数0
			System.out.print("你好");
			if(temp==0 || list.contains(temp)){
				i--;
				continue;//与break不同，它的作用是中断本次循环，开始下一次循环，所以在它后面的循环语句就不会执行
			}
		    //下面这个循环的作用是检查数组中r[i]有没有和产生的随机数重复，若重复则不赋值给r[]下一个元素
			/*
			for(int j=0; j<=i; j++){
				if(r[j]==temp)
					continue;	
			}
			*/
			System.out.print("你好");
			list.add(temp);
			
		}
		
		for(Iterator ite = list.iterator(); ite.hasNext();){
			int j = (Integer)ite.next();
			System.out.print(j);
		}


	}

}
