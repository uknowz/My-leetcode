import java.io.*;
import java.util.*;

public class ObjectWriter {
    public static void main(String[] arguments) {
        
        String author = "΢����ƸС��";
        String recipient = "֣�����������ʵ��ѧ";
        String[] letter = { "֣����С�㣬����������ı���",
            "�������ǳ�ֿ������������΢����ͥ",
            "���幤�����ˣ���������֪ͨ����ע������ʼ�" };
        Date now = new Date();
        Message mess = new Message(author,recipient,now,letter);
       // mess.writeMessage(author, recipient, now, letter);
        try {
            FileOutputStream fo = new FileOutputStream(
                "Message.obj");//�����ֽ���,�ⲻ��һ���ı��ļ����룬�����ַ�����ͼƬ����Ƶ����Ƶ�����ֽ���
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(mess);//writeObject�����Ķ����������ǿ����л��ģ�mess����messageҪ�нӽӿ�Serializable
           // PrintWriter print = new PrintWriter(fo);
            //print.println(mess);
            
            oo.close();
           // print.close();
            System.out.println("Object created successfully.");
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}

class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4291114882785950205L;
	//����ӿ����������л����ܡ�δʵ�ִ˽ӿڵ��ཫ�޷�ʹ���κ�״̬���л������л���
	//�����л�������������ͱ����ǿ����л��ġ����л��ӿ�û�з������ֶΣ������ڱ�ʶ�����л������塣
    int lineCount;
    String from, to;
    Date when;
    String[] text;
   transient int  a;//��̬�������������Բ������л�����
   
   
    public  Message(String inFrom,String inTo,Date inWhen,String[] inText) {
    	//this.a = a;
    	from = inFrom;
    	to = inTo;
    	when = inWhen;
    	text = new String[inText.length];
    	for(int i=0;i<inText.length;i++){
    		text[i] = inText[i];
    	}
    	lineCount = inText.length;
    
    }
    
    	
		
	}

    /*
    void writeMessage(String inFrom,
        String inTo,
        Date inWhen,
        String[] inText) {

        text = new String[inText.length];
        for (int i = 0; i < inText.length; i++)
            text[i] = inText[i];
        lineCount = inText.length;
        to = inTo;
        from = inFrom;
        when = inWhen;
       
    }
     */

