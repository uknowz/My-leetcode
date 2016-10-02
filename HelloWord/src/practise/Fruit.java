package practise;

import java.util.ArrayList;
import java.util.Iterator;

public class Fruit {
	String name;
	float price;
	int number;
	static ArrayList<Object> fru = new ArrayList<>();
	 Fruit(String inName, float inPrice, int inNumber) {
		name = inName;
		price = inPrice;
		number = inNumber;
		// TODO 自动生成的构造函数存根
	}
	 static void addList(String inName1, float inPrice1, int inNumber1){
		Fruit a = new Fruit(inName1,  inPrice1,  inNumber1);
		fru.add(a);
	}
	
	public static void main(String args[]) {
		//要加个try和catch语句来捕获异常，比如输入参数格式不正确
		if(args.length>2){
			for(int i=0; i<args.length;i+=3){
				addList(args[i+0], Float.parseFloat(args[i+1]), Integer.parseInt(args[i+2]));
			}
		}else
			System.out.println("输入参数错误！");
		
		//不懂怎么遍历数据结构并显示！
		for (Iterator<Object> ite = fru.iterator(); ite.hasNext(); ) {
            Fruit output = (Fruit) ite.next();
            System.out.println("水果名称：" + output.name + ";" + "水果价格：" + output.price + ";" + "购买数量：" + output.number);
       }
	}
}
	
