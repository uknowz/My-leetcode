import javax.swing.*;
import java.net.*;
import java.io.*;

public class WebReader extends JFrame {
    JTextArea box = new JTextArea("Getting data ...");

    public WebReader() {
        super("Get File Application");//继承父辈构造函数必须放在构造函数首位
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
            conn.connect();//获取连接
            //创建和URL的连接conn
            //InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
            InputStreamReader in = new InputStreamReader(conn.getInputStream());//用于读取URLconnection
            //创建输入流阅读器
            //其实可以写成这样 BufferedReader buff = new BufferedReader(new InputStreamReader(
            BufferedReader buff = new BufferedReader(in);
            //创建高效输入流
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
            //下面的逐行读取的方法记熟，以后read就用这个循环了
            String line = new String();
            do {
                line = buff.readLine();//逐行读取字符串，返回对象null停止，
                if(line !=null)
                text.append(line + "\n");//字符串缓冲添加,stringbuffer的一个方法
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
            System.exit(1);//system.exit(0)指正常退出，system.exit(1)指非正常退出
        }
        try {
            WebReader app = new WebReader();
            app.getData(arguments[0]);
        } catch (MalformedURLException mue) {
            System.out.println("Bad URL: " + arguments[0]);
        }
    }
}
