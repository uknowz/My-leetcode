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
		// TODO �Զ����ɵĹ��캯�����
	}
	 static void addList(String inName1, float inPrice1, int inNumber1){
		Fruit a = new Fruit(inName1,  inPrice1,  inNumber1);
		fru.add(a);
	}
	
	public static void main(String args[]) {
		//Ҫ�Ӹ�try��catch����������쳣���������������ʽ����ȷ
		if(args.length>2){
			for(int i=0; i<args.length;i+=3){
				addList(args[i+0], Float.parseFloat(args[i+1]), Integer.parseInt(args[i+2]));
			}
		}else
			System.out.println("�����������");
		
		//������ô�������ݽṹ����ʾ��
		for (Iterator<Object> ite = fru.iterator(); ite.hasNext(); ) {
            Fruit output = (Fruit) ite.next();
            System.out.println("ˮ�����ƣ�" + output.name + ";" + "ˮ���۸�" + output.price + ";" + "����������" + output.number);
       }
	}
}
	
