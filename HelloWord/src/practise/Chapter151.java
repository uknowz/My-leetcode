package practise;
import java.io.*;

class Chapter151 {
    /*String[] input = { "000A110D1D260219 ",
        "78700F1318141E0C ",
        "6A197D45B0FFFFFF " };
        */

    public static void main(String[] arguments) {
    	/*
    	Chapter151 hex = new Chapter151();
        for (int i = 0; i < hex.input.length; i++)
            hex.readLine(hex.input[i]);
    	try{
    		
    	FileReader fil = new FileReader("C:\\Users\\Administrator\\Desktop\\r.dat");
    	BufferedReader buf = new BufferedReader(fil);
    	boolean eof = false;
    	 while (!eof) {
             String line = buf.readLine();
             if (line == null)
                 eof = true;
             else
                 System.out.println(line+"\n");
         }
    	}catch(IOException ioe){
    		System.out.println("error: " + ioe.getMessage());
    	}
    	*/
    	
    	
    }

    void readLine(String code) {
        try {
            for (int j = 0; j + 1 < code.length(); j += 2) {
                String sub = code.substring(j, j+2);
                int num = Integer.parseInt(sub, 16);
                if (num == 255)
                    return;
                System.out.print(num + " ");
            }
        } finally {
            System.out.println("**");
        }
        return;
    }
}
