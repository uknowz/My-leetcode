import java.io.*;
import java.util.*;

public class ObjectReader {
	
    public static void main(String[] arguments) {
        try {
            FileInputStream fi = new FileInputStream(
                "message.obj");
            ObjectInputStream oi = new ObjectInputStream(fi);//��������������oi������Ҫ���µ��ù��캯������ȫ���ն�ȡ��fi����ı���������������
            Message mess2 = (Message) oi.readObject();//��������һ��object���󣬿��Խ��ö���ǿ��ת��Ϊ����Ҫ����
            //mess2������Ҫ�������Ժͳ�ֵ�����Զ�����read���ж�������Ա���
            
           // Class key = mess2.getClass();
            System.out.println(mess2.a);
            System.out.println("Message:");
            System.out.println("From: " + mess2.from);
            System.out.println("To: " + mess2.to);
            System.out.println("Date: " + mess2.when + "\n");
            for (int i = 0; i < mess2.lineCount; i++)//linecount����������Ϣ��������
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
