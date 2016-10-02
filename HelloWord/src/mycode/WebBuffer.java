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
	JTextArea txt = new JTextArea("Please wait...");//����Ҫ�����ó�ֵ�������ڹ��캯��������newʵ�����г�ֵ
	//�������ܷ��ڹ��캯�����棬���캯����������ķ���
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
			HttpURLConnection http = (HttpURLConnection)url.openConnection();//����һ��URLConnection��ʾ���ӵ�Զ�̵�URL����
			http.connect();//��������
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
			����Ҫ��ͨ��
			*/
			FileWriter out = new FileWriter("webBuffer.html");
			BufferedWriter outb = new BufferedWriter(out);
			PrintWriter print = new PrintWriter(outb);
			String strout = str.toString();
			//String strout = str.substring(0);
			print.println(strout);
			print.close();
			
			
			} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("io error:" + e.toString());
		}
	}
	
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
