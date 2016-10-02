import javax.swing.*;
import java.net.*;
import java.io.*;

public class WebReader extends JFrame {
    JTextArea box = new JTextArea("Getting data ...");

    public WebReader() {
        super("Get File Application");//�̳и������캯��������ڹ��캯����λ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        //pack();
        JScrollPane pane = new JScrollPane(box);
        add(pane);
        setVisible(true);
    }

    void getData(String address) throws MalformedURLException {
        setTitle(address);
        URL page = new URL(address);
        StringBuffer text = new StringBuffer();
        try {
            HttpURLConnection conn = (HttpURLConnection)page.openConnection();
            conn.connect();//��ȡ����
            //������URL������conn
            //InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
            InputStreamReader in = new InputStreamReader(conn.getInputStream());//���ڶ�ȡURLconnection
            //�����������Ķ���
            //��ʵ����д������ BufferedReader buff = new BufferedReader(new InputStreamReader(
            BufferedReader buff = new BufferedReader(in);
            //������Ч������
            box.setText("Getting data ...");
            /*
            String key,header;
            int i = 0;
            do{
            	key = conn.getHeaderFieldKey(i);
            	header = conn.getHeaderField(i);
            	if(key == null){
            		key = "";
            	}else{
            		key = key +": ";
            	}
            	if(header != null){
            		text.append(key + header + "\n");
            	}
            	i++;
            }while(header!=null);
            text.append("\n");
            */
            //��������ж�ȡ�ķ������죬�Ժ�read�������ѭ����
            String line = new String();
            do {
                line = buff.readLine();//���ж�ȡ�ַ��������ض���nullֹͣ��
                if(line !=null)
                text.append(line + "\n");//�ַ����������,stringbuffer��һ������
            } while (line != null);
            box.setText(text.toString());
            buff.close();
        } catch (IOException ioe) {
            System.out.println("IO Error:" + ioe.getMessage());
        }
    }

    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("Usage: java WebReader url");
            System.exit(1);//system.exit(0)ָ�����˳���system.exit(1)ָ�������˳�
        }
        try {
            WebReader app = new WebReader();
            app.getData(arguments[0]);
        } catch (MalformedURLException mue) {
            System.out.println("Bad URL: " + arguments[0]);
        }
    }
}
