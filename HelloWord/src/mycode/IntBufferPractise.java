package mycode;
import java.io.*;
import java.nio.*;
import java.util.*;
import java.net.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class IntBufferPractise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] temps = {90,85,87,78,80,75,70,79,85,92,99};
		IntBuffer tempBuffer = IntBuffer.allocate(temps.length);
		//往缓冲区添加int数据
		for(int i=0; i<temps.length; i++){
			float celsius = ((float)temps[i] - 32)/9*5;
			tempBuffer.put((int)celsius);
			}
		
		tempBuffer.position(0);
		for(int i=0; tempBuffer.remaining()>0; i++){
			System.out.println(tempBuffer.get());
			}

	}

}
