import java.io.*;
import java.util.*;

public class ObjectReader {
	
    public static void main(String[] arguments) {
        try {
            FileInputStream fi = new FileInputStream(
                "message.obj");
            ObjectInputStream oi = new ObjectInputStream(fi);//创建对象输入流oi对象不需要重新调用构造函数，完全按照读取的fi对象的变量参数来构建的
            Message mess2 = (Message) oi.readObject();//方法返回一个object对象，可以将该对象强制转换为所需要的类
            //mess2对象不需要重设属性和初值，会自动生成read序列对象的属性变量
            
           // Class key = mess2.getClass();
            System.out.println(mess2.a);
            System.out.println("Message:");
            System.out.println("From: " + mess2.from);
            System.out.println("To: " + mess2.to);
            System.out.println("Date: " + mess2.when + "\n");
            for (int i = 0; i < mess2.lineCount; i++)//linecount用来跟踪消息的行数，
                System.out.println(mess2.text[i]);
            oi.close();
            System.out.println("the class name of mess2 is "+mess2.getClass().getName());
            //long a = System.currentTimeMillis();
           // System.out.println(a);
        } catch (Exception e) {
            System.out.println("Error -- " + e.toString());
        }
        
    }
    
}
