package practise;

import java.util.HashMap;

public class ComicBooks {
	public ComicBooks() {
    }

    public static void main(String[] arguments) {
        // set up HashMap������ϣͼӳ�䣬����ʵ����Map��ӿ�
        HashMap<String, Float> quality = new HashMap<String, Float>();
        float price1 = 3.00F;//���ݽṹӳ�䶼ֻ�ܴ洢���󣬻�����������Ҫ��װ�ɶ���
        quality.put("mint", price1);//put(String��Object)��������ӵ��ֵ��У������ַ�����Ϊ��ֵ
        float price2 = 2.00F;
        quality.put("near mint", price2);
        float price3 = 1.50F;
        quality.put("very fine", price3);
        float price4 = 1.00F;
        quality.put("fine", price4);
        float price5 = 0.50F;
        quality.put("good", price5);
        float price6 = 0.25F;
        quality.put("poor", price6);
        float price7 = 5.00F;
        quality.put("pristine mint", price7);
        float price8 = 0.10F;
        quality.put("coverless", price8);
        
        
        
        
        // set up collection
        Comic[] comix = new Comic[5];
        comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine",
            5000.00F);//comix�����д����Ԫ�ؾ���Comic��Ķ���
        comix[0].setPrice( (Float) quality.get(comix[0].condition) );//ӳ����Զ�����������ת��Ϊ���󣬽�����ת��Ϊ�������ͣ���float-Float
        comix[1] = new Comic("Incredible Hulk", "181", "near mint",
            240.00F);
        comix[1].setPrice( (Float) quality.get(comix[1].condition) );
        comix[2] = new Comic("Cerebus", "1A", "good", 144.00F);
        comix[2].setPrice( (Float) quality.get(comix[2].condition) );
        comix[3] = new Comic("��Ů����","no.2","pristine mint",1000.00F);
        comix[3].setPrice(quality.get(comix[3].condition));
        comix[4] = new Comic("��ִ��","145��", "coverless", 20000.00F);
        comix[4].setPrice(quality.get(comix[4].condition));
        
        for (int i = 0; i < comix.length; i++) {
            System.out.println("Title: " + comix[i].title);
            System.out.println("Issue: " + comix[i].issueNumber);
            System.out.println("Condition: " + comix[i].condition);
            System.out.println("Price: $" + comix[i].getPrice() + "\n");
           
        }
        
    }
}

class Comic {
    String title;
    String issueNumber;
    String condition;
   private float basePrice;
    private float price;

    Comic(String inTitle, String inIssueNumber, String inCondition,
        float inBasePrice) {
    
        title = inTitle;
        issueNumber = inIssueNumber;
        condition = inCondition;
        basePrice = inBasePrice;
    }
    float getBasePrice(){
    	return basePrice;
    }
    float getPrice(){
    	return price;
    }

    void setPrice(float factor) {
        price = basePrice * factor;
    }

}
