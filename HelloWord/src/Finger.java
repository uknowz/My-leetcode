import java.io.*;
import java.net.*;
import java.util.*;

public class Finger {
    public static void main(String[] arguments) {
        String user;
        String host;
        if ((arguments.length == 1) && (arguments[0].indexOf("@") > -1)) {
            StringTokenizer split = new StringTokenizer(arguments[0],
                "@");
            user = split.nextToken();
            host = split.nextToken();
        } else {
            System.out.println("please give a finger address");
            return;//这种结果不能执行后面的代码，用return，system.exit是整个程序结束
        }
        try {
            Socket digit = new Socket(host, 80);
            digit.setSoTimeout(20000);//设立请求响应时间
            StringBuffer finger = new StringBuffer();
            String line;
            PrintStream out = new PrintStream(digit.getOutputStream());
           out.print(user + "\015\012");//\015是回车符\012是换行符，finger的协议要求通过套接字来发送用户名
            BufferedReader in = new BufferedReader(new InputStreamReader(digit.getInputStream()));
           //下面是读取的循环操作
           /*
            boolean eof = false;
            while (!eof) {
                String line = in.readLine();
                if (line != null)
                    System.out.println(line);
                else
                    eof = true;
            }
            */
            
            do{
            	 line = in.readLine();
            	if(line !=null){
            		finger.append(line + '\n');
            	}
            }while(line != null);
            System.out.println(finger.toString());
            
            digit.close();
        } catch (IOException e) {
            System.out.println("IO Error:" + e.getMessage());
        }
    }
}
