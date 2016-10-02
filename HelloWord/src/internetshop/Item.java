package internetshop;

@SuppressWarnings("rawtypes")
public class Item implements Comparable {//��������ʹ�ýӿڣ���Ҫ��implements
    private String id;
    private String name;
    private double retail;
    private int quantity;
    private double price;
    private boolean noDiscount;
		
	

   public Item(String idIn, String nameIn, String retailIn, String quanIn,boolean noDiscountIn) {
        id = idIn;
        name = nameIn;
        retail = Double.parseDouble(retailIn);
        quantity = Integer.parseInt(quanIn);
        noDiscount = noDiscountIn;
        if(noDiscount == true)
        	price = retail;
        else{
        if (quantity > 400)
            price = retail * .5D;
        else if (quantity > 200)
            price = retail * .6D;
        else
            price = retail * .7D;
        price = Math.floor( price * 100 + .5 ) / 100;//�������뱣����λС��
        }
    }

    public int compareTo(Object obj) {
        Item temp = (Item) obj;//���ȽϵĶ���objǿ��ת��ΪItem�Ķ��󣬺͵�ǰ���ø÷�����Item����Ƚ�
        if (this.price < temp.price)
            return 1;
        else if (this.price > temp.price)
            return -1;
        return 0; 
    }//������������������еĶ�������ģ���ǰ����ȶԱȶ���󣬷���-1���ŵ�ǰ��

    public String getId() {//��Щget�����Ǹ�˽�б�����������Ҳ���Ե��õĴ�ȡ����������������
    	//����һ����ĳ���Ϳ���ͨ����ȡ��������ȡ˽�б�����ֵ��������get�ӱ�������д
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRetail() {
        return retail;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
    	
        return price;
    }
    
   // public boolean getNoDiscount() {
	//	return noDiscount;
	//}
}

