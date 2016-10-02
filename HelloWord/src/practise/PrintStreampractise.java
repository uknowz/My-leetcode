package practise;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class PrintStreampractise {

	/**
	 * @param args(�ӿڲ���ʵ������interface����new)
	 */
	public PrintStreampractise(){
		try{
			Date now = new Date();
			String[] a = {"a","b","c","d","sh","sji"};
			FileWriter file = new FileWriter("file.txt");
			BufferedWriter fo = new BufferedWriter(file);
			PrintWriter print = new PrintWriter(fo);
			print.println(now);//������printwriter������println������ӡ��������bufferedwriter��write����Ҫ�ð�
			for(int i=0; i<a.length;i++){
				print.print(a[i]+' ');
				
			}
			print.print('\n');
			print.close();
		}catch(IOException io){
			System.out.println(io.toString());
		}
	}
	//�������Լ�д�Ķ�ȡ�ļ��ַ��ķ��������ı��ʹ��ı��������ã���д��������������쳣��print����û���쳣
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
		// TODO �Զ����ɵķ������
		/*
		PrintStreampractise a = new PrintStreampractise();
		a.readMessage();
		*/
		//дһ���򵥵Ŀͻ��˳������ӷ�������Ҳ������telnet�ͻ��������ӣ�������tcp/ipЭ���
		try{
			String line;
			Date now = new Date();
			Socket client = new Socket("",4413);//socket������������string��Ϊnullʱ����ʾ�ػ���ַ
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
