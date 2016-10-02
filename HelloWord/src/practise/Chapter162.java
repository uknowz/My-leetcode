package practise;

import java.io.*;
import java.util.*;

public class Chapter162 {
    public static void main(String[] arguments) {
        try {
            Class messClass = Message.class;
            
           // Message mess = (Message)messClass.newInstance();
            String author = "Sam Wainwright, London";
            String recipient = "George Bailey, Bedford Falls";
            String[] letter = { "Mr. Gower cabled you need cash. Stop.",
                "My office instructed to advance you up to twenty-five",
                "thousand dollars. Stop. Hee-haw and Merry Christmas." };
            Date now = new Date();
            Message mess = new Message(author, recipient, now, letter, 0);
            mess = (Message)messClass.newInstance();
            
            //mess.writeMessage(author, recipient, now, letter);
                FileOutputStream fo = new FileOutputStream(
                    "NewMessage.obj");
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(mess);
                oo.close();
                System.out.println("Object created successfully.");
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        } catch (InstantiationException i) {
            System.out.println("Error creating class -- " + i.toString());
        } catch (IllegalAccessException l) {
            System.out.println("No access -- " + l.toString());
        }
    }
}
