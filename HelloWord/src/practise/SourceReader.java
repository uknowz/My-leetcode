package practise;

import java.io.*;

public class SourceReader {
    public static void main(String[] arguments) {
        try {
            FileReader file = new
                FileReader("D:\\java\\eclipseworkspace\\HelloWord\\src\\practise\\Fruit.java");
            //BufferedReader buff = new
              //  BufferedReader(new InputStreamReader(System.in));
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;
            //System.out.println("我是天才吗？\n");
            while (!eof) {
                String line = buff.readLine();
                if (line == null)
                    eof = true;
                else
                    System.out.println(line+"\n");
            }
            buff.close();
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}
