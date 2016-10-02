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
            return;//���ֽ������ִ�к���Ĵ��룬��return��system.exit�������������
        }
        try {
            Socket digit = new Socket(host, 80);
            digit.setSoTimeout(20000);//����������Ӧʱ��
            StringBuffer finger = new StringBuffer();
            String line;
            PrintStream out = new PrintStream(digit.getOutputStream());
           out.print(user + "\015\012");//\015�ǻس���\012�ǻ��з���finger��Э��Ҫ��ͨ���׽����������û���
            BufferedReader in = new BufferedReader(new InputStreamReader(digit.getInputStream()));
           //�����Ƕ�ȡ��ѭ������
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
