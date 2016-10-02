import java.io.*;

public class ByteReader2 {
    public static void main(String[] arguments) {
        try {
            FileInputStream file = new
                FileInputStream("C:\\Users\\Administrator\\Desktop\\告别.txt");
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
            //这个循环比上面那个要好一点，不会读到-1，也就是说，如果最后一次边界值，循环控制条件会改变，那么应该在控制
            //条件改变之后再判断是否继续循环，不用while do，用do while
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