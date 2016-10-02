package mycode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class PrintStream {

		public PrintStream(){
			try{
				Date now = new Date();
				String[] a = {"a","b","c","d","sh","sji"};
				FileWriter file = new FileWriter("file.txt");
				BufferedWriter fo = new BufferedWriter(file);
				PrintWriter print = new PrintWriter(fo);
				print.println(now);//看来用printwriter这个类的println方法打印流，比用bufferedwriter的write方法要好啊
				for(int i=0; i<a.length;i++){
					print.print(a[i]+' ');
					
				}
				print.print('\n');
				print.close();
			}catch(IOException io){
				System.out.println(io.toString());
			}
		}
		//这是我自己写的读取文件字符的方法，超文本和纯文本都可以用，读写输入流都会存在异常，print方法没有异常
		public void readMessage(){
			StringBuffer string = new StringBuffer();
			try{
				FileReader file2 = new FileReader("file.txt");
				BufferedReader fo2 = new BufferedReader(file2);
				String line = null;
				do{
					line = fo2.readLine();
					if(line!=null){
						string.append(line +'\n');
					}
				}while(line!=null);
				System.out.println("The message of file is:" +'\n'+ string.toString());
				fo2.close();
				
			}catch(IOException io){
				System.out.println(io.toString());
			}
		}
		
		public static void main(String[] args) {
			// TODO 自动生成的方法存根
			/*
			PrintStreampractise a = new PrintStreampractise();
			a.readMessage();
			*/
			//写一个客户端程序，连接服务器
			try{
				String line;
				
				Socket client = new Socket("",4413);//socket函数主机名（string）为null时，表示回环地址
				//这行socket代码是客户端和服务器的本质区别，要连接服务器只要连接它开放的端口就行了
				BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()));
				do{
					line = read.readLine();
					if(line != null){
						System.out.println(line);
					}
				}while(line !=null);
				client.close();
			}catch(IOException io){
				System.out.println(io.toString());
			}
			
			
			

		}

}
