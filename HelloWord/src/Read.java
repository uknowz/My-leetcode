import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;


public class Read {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int newByte = 0;
		try{
		FileInputStream diskfile = new FileInputStream("c:\\Users\\Administrator\\Desktop\\r.txt");
		//StringBuffer str = new StringBuffer(50);
		char[] str1 = new char[100];
		/*while(newByte != -1){
			newByte = diskfile.read();
			System.out.print("�ı����ֽ���Ϣ�ǣ�" + newByte + ' ');
		}*/
		for( int i = 0; newByte != -1 ;i++ ){
			newByte = diskfile.read();
			//if(newByte == -1)
				//break;
			//else
				//str.append(newByte);
				str1[i]=(char)newByte;
				System.out.print("�ı��ֽ���Ϣ�ǣ�" + str1[i] + " ");
				
				
			
			
			
		}
		}catch(IOException ioe){
			System.out.println("�����ǣ�" + ioe.getMessage());
		}

	}

}
