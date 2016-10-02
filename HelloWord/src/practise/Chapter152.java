package practise;

import java.io.*;
import java.nio.BufferOverflowException;

import javax.naming.LinkLoopException;

public class Chapter152 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		try{
			FileInputStream file = new FileInputStream("C:\\Users\\Administrator\\Desktop\\re.dat");
			BufferedInputStream buff = new BufferedInputStream(file);
			FileOutputStream file1 = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\re.dat");
			BufferedOutputStream buff1 = new BufferedOutputStream(file1);
			
			int count=0;int newByte = 0;
			do{
				newByte = buff.read();
				count++;
				
				
			}while(newByte !=-1);
			buff.close();
			for(int i=0; i<count;i++){
				
				
				buff1.write((byte)0);
			}
			buff1.close();
			System.out.println("total bytes:" + count);
		}catch(IOException ioe){
			System.out.println("error--" + ioe.getMessage());
		}

	}

}
