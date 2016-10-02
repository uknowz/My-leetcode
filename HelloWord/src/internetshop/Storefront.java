package internetshop;



import java.util.*;

public class Storefront {
    private LinkedList<Item> catalog = new LinkedList<Item>();

    public void addItem(String id, String name, String price,
        String quant, boolean nodiscount) {

        Item it = new Item(id, name, price, quant, nodiscount);
        catalog.add(new Item(id, name, price, quant, nodiscount));
    }//�������������ӵ�list����ȥ��ÿ�ε������������it���������´����ģ�һ�뿪�������䣬�Ͳ������ڣ�����û���ظ�����ͬ������

    public Item getItem(int i) {
        return (Item)catalog.get(i);//����ֵ��������������ʾ�ò����õ�Item��һ�����󣬲�����������󣬰�������������Ϣ
    }

    public int getSize() {
        return catalog.size();
    }

    @SuppressWarnings("unchecked")//java�е��쳣������sort�����Ͱ�ȫ���
	public void sort() {
        Collections.sort(catalog);//��catalog������Ķ������򣬵���compareTo��������ҪComparable�ӿڣ�����Item��Ҫʹ�ýӿ�
    }
}
