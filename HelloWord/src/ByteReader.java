import java.io.*;

public class ByteReader {
    public static void main(String[] arguments) {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\Administrator\\Desktop\\example.txt");//��ȡsaveͼƬ��ֻ���ļ����Ļ��������Ƿ���ͬһ��Ŀ�ļ�����
            //boolean eof = false;C:\\Users\\Administrator\\Desktop\\example.txt
            int count = 0;
            System.out.println("�ֽ���Ϣ�ǣ�");
            for(; ;) {
                int input = file.read();//read����ֵ��int���ֽ�
                
                if (input == -1)
                    break;
                else{
                	
                    System.out.print(input + " ");
                    count++;
                }
                    
            }
            file.close();
            System.out.println("\n��ȡ�ֽ�����: " + count);
        } catch (IOException e) {
            System.out.println("error��" + e.toString());
        }
        /*
        for (String string : arguments) {for
			
		}
		*/
    }
}