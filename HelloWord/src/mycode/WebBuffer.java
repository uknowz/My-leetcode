package mycode;
import java.io.*;
import java.lang.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WebBuffer extends JFrame{

	/**
	 * @param args
	 */
	JTextArea txt = new JTextArea("Please wait...");//还是要先设置初值，这样在构造函数里面先new实例才有初值
	//方法不能放在构造函数里面，构造函数就是特殊的方法
	public WebBuffer(){
		super();
		setTitle("Getting web date");
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane panel = new JScrollPane(txt);
		add(panel);
		setVisible(true);
	}
	public void webConnect(String inurl) throws MalformedURLException{
		URL url = new URL(inurl);
		//ByteBuffer webByte = ByteBuffer.allocate(10000);
		//StringBuffer string = new StringBuffer();
		
		String line;
		StringBuffer str = new StringBuffer();
		
		try {
			HttpURLConnection http = (HttpURLConnection)url.openConnection();//返回一个URLConnection表示连接到远程的URL对象
			http.connect();//不会重连
			BufferedReader webReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
			
			do{
				line = webReader.readLine();
				if(line != null);
				str.append(line + "\n");
			  }while(line != null);
			txt.setText(str.toString());
			webReader.close();
			
			/*
			FileChannel outchannel = out.getChannel();
			long inSize = outchannel.size();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int)inSize);
		
			outchannel.write(byteBuffer,0);
			byteBuffer.flip();
			不需要用通道
			*/
			FileWriter out = new FileWriter("webBuffer.html");
			BufferedWriter outb = new BufferedWriter(out);
			PrintWriter print = new PrintWriter(outb);
			String strout = str.toString();
			//String strout = str.substring(0);
			print.println(strout);
			print.close();
			
			
			} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println("io error:" + e.toString());
		}
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		if(args.length<1){
			System.out.println("Please input the correct url");
			System.exit(1);
		}
		
		try{
			WebBuffer example = new WebBuffer();
			example.webConnect(args[0]);
		}catch(IOException e){
			System.out.println("io error:" + e.toString());
		}
		

	}

}
