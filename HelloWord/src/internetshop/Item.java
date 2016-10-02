package internetshop;

@SuppressWarnings("rawtypes")
public class Item implements Comparable {//在类里面使用接口，需要用implements
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
        price = Math.floor( price * 100 + .5 ) / 100;//四舍五入保留两位小数
        }
    }

    public int compareTo(Object obj) {
        Item temp = (Item) obj;//被比较的对象obj强制转换为Item的对象，和当前调用该方法的Item对象比较
        if (this.price < temp.price)
            return 1;
        else if (this.price > temp.price)
            return -1;
        return 0; 
    }//这个方法是用来给类中的对象排序的，当前对象比对比对象大，返回-1，排到前面

    public String getId() {//这些get方法是给私有变量其他程序也可以调用的存取器方法，这样其他
    	//不在一个类的程序就可以通过存取器方法获取私有变量的值，名称是get加变量名大写
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

