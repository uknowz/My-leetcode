import java.io.*;

public class ConsoleInput {
	//控制台输入读取方法
    public static String readLine() {//使用类方法是有原因的，如果用实例，控制台只有一个，不需要每次都new一个控制台对象，这个方法就专门为控制台输入设定
        StringBuffer response = new StringBuffer();
        try {
            BufferedInputStream buff = new
                BufferedInputStream(System.in);
            int in = 0;
            char inChar;
            do {
                in = buff.read();
                inChar = (char) in;//一个char型数据是一个字节
                if ((in != -1) & (in != '\n') & (in != '\r')) {
                    response.append(inChar);
                }             
            } while ((in != -1) & (inChar != '\n') & (in != '\r'));
            buff.close();
            return response.toString();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] arguments) {
        System.out.print("\nWhat is your name? ");
        String input = ConsoleInput.readLine();
        System.out.println("\nHello, " + input);
    }
}
