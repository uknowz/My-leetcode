import java.io.*;
import java.net.*;
import java.util.*;

public class TimeServer extends Thread {
    private ServerSocket sock;

    public TimeServer() {
        super();
        try {
            sock = new ServerSocket(4413);//���ǳ��ֲ��ܲ���socket�����⣬�����Ƕ˿�û�б��ͷ�
            System.out.println("TimeServer running ...");
        } catch (IOException e) {
            System.out.println("Error: couldn't create socket.");
            System.exit(1);
        }
    }

    public void run() {
         

        while (true) {
            if (sock == null)
                return;
            try {
            	Socket client = sock.accept();//�ͻ������ӷ����������Ķ˿�:4413
            	/*
            	 * ����TCP�׽��֣��ڷ�������ͨ����������������ʵ�֣�
				ServerSocket serverSocket = new ServerSocket(8000); (1)
				Socket socket = serverSocket.accept(); (2)
				�ڣ�1���䴴����һ���ܼ���ĳЩ�ͻ��������š������ţ�serverSocket��8000�˿��ϼ�������ĳЩ�ͻ�����serverSocket����ʱ��
				�ڣ�2���䴴����һ���µ��׽��֣���Ϊsocket������׽���Ҳʹ��8000�˿ڣ���ʱ�������׽���ʹ������ͬ�Ķ˿ںţ�
				��ΪTCP�����׽�����һ����Ԫ�飨ԴIP��ַ��Դ�˿ںţ�Ŀ��IP��ַ��Ŀ�Ķ˿ںţ�����ʶ��
				UDP�׽��֣����������ӵģ���һ������Ŀ��IP��ַ��Ŀ�Ķ˿ں���ɵĶ�Ԫ������ʶ��
				֮��TCP�ڿͻ��˵�clientSocket�ͷ������˵�socket֮�佨����һ��ֱ�ӵ�����ܵ���
				�ÿͻ��������������ͨ���ùܵ��˴˷����ֽڣ����ҷ��͵������ֽڽ���˳�򵽴�Է���
				����socket�Ľ������÷������ܼ���ʹ��serverSocket���������ͻ������������� 
            	 */
               BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                PrintWriter os = new PrintWriter(bos, false);//��ӡ��
                Date now = new Date();
            /*
               String line;
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                
              
                do{
					line = in.readLine();
					if(line != null){
						System.out.println(line);
					}
				}while(line !=null);
               */
                os.println(now + "\n");//���͸��ͻ��ˣ��ڿͻ����ϴ�ӡ�����������κ�һ���ͻ��˶��У��������Ҳ�У�localhost:�˿ڣ�
               
                os.println("��ô��ӡ������");//[Java]Socket��ServerSocketѧϰ�ʼ�http://www.cnblogs.com/rond/p/3565113.html
                //����������������ǿͻ��˵�������
                os.flush();//ˢ����
                

                os.close();
                
                client.close();
                
            } catch (IOException e) {
                System.out.println("Error: couldn't connect to client."+'\n');
                System.err.println(e.toString());
                System.exit(1);
            }
        }
    }

    public static void main(String[] arguments) {
        TimeServer server = new TimeServer();
        server.start();
    }

}
