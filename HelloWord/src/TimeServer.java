import java.io.*;
import java.net.*;
import java.util.*;

public class TimeServer extends Thread {
    private ServerSocket sock;

    public TimeServer() {
        super();
        try {
            sock = new ServerSocket(4413);//总是出现不能产生socket的问题，可能是端口没有被释放
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
            	Socket client = sock.accept();//客户端连接服务器监听的端口:4413
            	/*
            	 * 对于TCP套接字，在服务器端通常采用下面的语句来实现：
				ServerSocket serverSocket = new ServerSocket(8000); (1)
				Socket socket = serverSocket.accept(); (2)
				第（1）句创建了一个能监听某些客户机“敲门”声的门，serverSocket在8000端口上监听；当某些客户机与serverSocket连接时，
				第（2）句创建了一个新的套接字，称为socket，这个套接字也使用8000端口，这时，两个套接字使用了相同的端口号，
				因为TCP连接套接字由一个四元组（源IP地址，源端口号，目的IP地址，目的端口号）来标识，
				UDP套接字（面向无连接的）由一个包含目的IP地址和目的端口号组成的二元组来标识。
				之后，TCP在客户端的clientSocket和服务器端的socket之间建立了一条直接的虚礼管道，
				该客户机与服务器可以通过该管道彼此发送字节，并且发送的所有字节将按顺序到达对方。
				随着socket的建立，该服务器能继续使用serverSocket监听其它客户机的连接请求。 
            	 */
               BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                PrintWriter os = new PrintWriter(bos, false);//打印流
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
                os.println(now + "\n");//发送给客户端，在客户端上打印出来，调用任何一个客户端都行，用浏览器也行（localhost:端口）
               
                os.println("怎么打印出来的");//[Java]Socket和ServerSocket学习笔记http://www.cnblogs.com/rond/p/3565113.html
                //服务器的输出流就是客户端的输入流
                os.flush();//刷新流
                

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
