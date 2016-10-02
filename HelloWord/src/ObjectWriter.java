import java.io.*;
import java.util.*;

public class ObjectWriter {
    public static void main(String[] arguments) {
        
        String author = "微软招聘小组";
        String recipient = "郑茗方，北京邮电大学";
        String[] letter = { "郑茗方小姐，鉴于您优秀的表现",
            "现在我们诚挚的邀请您加入微软大家庭",
            "具体工作事宜，将会另行通知，请注意查收邮件" };
        Date now = new Date();
        Message mess = new Message(author,recipient,now,letter);
       // mess.writeMessage(author, recipient, now, letter);
        try {
            FileOutputStream fo = new FileOutputStream(
                "Message.obj");//创建字节流,这不是一个文本文件输入，不用字符流，图片、视频、音频都有字节流
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(mess);//writeObject方法的对象的类必须是可序列化的，mess的类message要承接接口Serializable
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
	//这个接口启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。
	//可序列化类的所有子类型本身都是可序列化的。序列化接口没有方法或字段，仅用于标识可序列化的语义。
    int lineCount;
    String from, to;
    Date when;
    String[] text;
   transient int  a;//暂态变量，变量属性不会序列化保存
   
   
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

