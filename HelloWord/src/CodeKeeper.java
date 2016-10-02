import java.util.*;


public class CodeKeeper {
	ArrayList<String> list;
    String[] codes = { "alpha", "lambda", "gamma", "delta", "zeta" };
    
    public CodeKeeper(String[] userCodes) {
        list = new ArrayList<String>();//用链表来储存数据是因为不知道会储存多少数据
        // load built-in codes
        for (int i = 0; i < codes.length; i++) {
            addCode(codes[i]);
        }
        // load user codes
        for (int j = 0; j < userCodes.length; j++) {
            addCode(userCodes[j]);
        }
        // display all codes 这个Iterator数据接口还要查一查什么功能
        for (Iterator<String> ite = list.iterator(); ite.hasNext(); ) {
            String output = (String) ite.next();
            System.out.println(output);
       }
    }

    private void addCode(String code) {
        if (!list.contains(code)) {
            list.add(code);
        }
    }

   
}
