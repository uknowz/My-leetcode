import java.io.*;

public class ByteReader2 {
    public static void main(String[] arguments) {
        try {
            FileInputStream file = new
                FileInputStream("C:\\Users\\Administrator\\Desktop\\���.txt");
            boolean eof = false;
            int count = 0;
            int input;
            /*
            while (!eof) {
                 input = file.read();
                System.out.print(input + " ");
                if (input == -1)
                    eof = true;
                else
                    count++;
            }
            */
            //���ѭ���������Ǹ�Ҫ��һ�㣬�������-1��Ҳ����˵��������һ�α߽�ֵ��ѭ������������ı䣬��ôӦ���ڿ���
            //�����ı�֮�����ж��Ƿ����ѭ��������while do����do while
            do{
            	 input = file.read();
            	if(input != -1){
            		System.out.print(input +" ");
            		count++;
            	}
            }while(input != -1);
            
            file.close();
            System.out.println("\nBytes read: " + count);
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}