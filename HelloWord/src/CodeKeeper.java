import java.util.*;


public class CodeKeeper {
	ArrayList<String> list;
    String[] codes = { "alpha", "lambda", "gamma", "delta", "zeta" };
    
    public CodeKeeper(String[] userCodes) {
        list = new ArrayList<String>();//��������������������Ϊ��֪���ᴢ���������
        // load built-in codes
        for (int i = 0; i < codes.length; i++) {
            addCode(codes[i]);
        }
        // load user codes
        for (int j = 0; j < userCodes.length; j++) {
            addCode(userCodes[j]);
        }
        // display all codes ���Iterator���ݽӿڻ�Ҫ��һ��ʲô����
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
