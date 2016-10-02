package internetshop;



import java.util.*;

public class Storefront {
    private LinkedList<Item> catalog = new LinkedList<Item>();

    public void addItem(String id, String name, String price,
        String quant, boolean nodiscount) {

        Item it = new Item(id, name, price, quant, nodiscount);
        catalog.add(new Item(id, name, price, quant, nodiscount));
    }//创建多个对象，添加到list里面去，每次调用这个方法，it对象都是重新创建的，一离开这个快语句，就不复存在，所以没有重复创建同名对象

    public Item getItem(int i) {
        return (Item)catalog.get(i);//返回值类型是类名，表示用参数得到Item的一个对象，并返回这个对象，包括它的所有信息
    }

    public int getSize() {
        return catalog.size();
    }

    @SuppressWarnings("unchecked")//java中的异常处理，对sort做类型安全检查
	public void sort() {
        Collections.sort(catalog);//对catalog链表储存的对象排序，调用compareTo方法，需要Comparable接口，所以Item类要使用接口
    }
}
