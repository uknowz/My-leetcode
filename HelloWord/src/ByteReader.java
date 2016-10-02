import java.io.*;

public class ByteReader {
    public static void main(String[] arguments) {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\Administrator\\Desktop\\example.txt");//读取save图片，只用文件名的话，必须是放在同一项目文件夹下
            //boolean eof = false;C:\\Users\\Administrator\\Desktop\\example.txt
            int count = 0;
            System.out.println("字节信息是：");
            for(; ;) {
                int input = file.read();//read返回值是int型字节
                
                if (input == -1)
                    break;
                else{
                	
                    System.out.print(input + " ");
                    count++;
                }
                    
            }
            file.close();
            System.out.println("\n读取字节总数: " + count);
        } catch (IOException e) {
            System.out.println("error：" + e.toString());
        }
        /*
        for (String string : arguments) {for
			
		}
		*/
    }
}