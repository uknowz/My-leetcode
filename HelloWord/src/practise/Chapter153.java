package practise;

import java.io.*;

public class Chapter153 {
    public static void main(String[] arguments) {
        try {
            FileInputStream file = new
                FileInputStream("C:\\Users\\Administrator\\Desktop\\re.dat");
            boolean eof = false;
            int size = 0;
            while (!eof) {
                int input = file.read();
                if (input == -1)
                    eof = true;
                else
                    size++;
            }
            file.close();
            FileOutputStream outFile = new
                FileOutputStream("C:\\Users\\Administrator\\Desktop\\re.dat");
            for (int i = 0; i < size; i++)
                outFile.write( (byte)0 );
            outFile.close();
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}

