package mycode;

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.*;

public class BufferPractise {
    public static void main(String[] arguments) {
        try {
            // read byte data into a byte buffer
            String data = "friends2.dat";
           // FileReader file = new FileReader(data);
           // FileChannel inChannel = file.getChannel();
            FileInputStream inData = new FileInputStream(data);
           // InputStreamReader innData = new InputStreamReader(inData);
            FileChannel inChannel = inData.getChannel();//getchannel�������ֻ��fileinputstream����
            long inSize = inChannel.size();
            ByteBuffer source = ByteBuffer.allocate( (int)inSize );
            inChannel.read(source, 0);
            source.position(0);
            System.out.println("Original byte data:");
            //for (int i = 0; source.remaining() > 0; i++)
            while(source.remaining() > 0)
                System.out.print(source.get() + " ");
            
            // convert byte data into character data
            source.position(0);
            Charset ascii = Charset.forName("UTF-8");
            CharsetDecoder toAscii = ascii.newDecoder();//�ֽڵ��ַ�ת����������
            CharBuffer destination = toAscii.decode(source);
            destination.position(0);
            System.out.println("\n\nNew character data:");
            //for (int i = 0; destination.remaining() > 0; i++)
            while(destination.remaining() > 0)
                System.out.print(destination.get());
            inData.close();
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
