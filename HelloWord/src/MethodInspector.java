import java.lang.reflect.*;

public class MethodInspector {
    public static void main(String[] arguments)  {
        Class inspect;
        try {
            if (arguments.length > 0)
                inspect = Class.forName(arguments[0]);
            else
                inspect = Class.forName("MethodInspector");
            Method[] methods = inspect.getDeclaredMethods();//�ҳ����������з������������
            
            for (int i = 0; i < methods.length; i++) {
                Method methVal = methods[i];
                Class returnVal = methVal.getReturnType();
                int mods = methVal.getModifiers();
                String modVal = Modifier.toString(mods);
                Class[] paramVal = methVal.getParameterTypes();//������ôû�д�С��
                StringBuffer params = new StringBuffer();
                for (int j = 0; j < paramVal.length; j++) {
                    if (j > 0)
                        params.append(", ");
                    params.append(paramVal[j].getName());
                }
                System.out.println("Method: " + methVal.getName() + "()");
                System.out.println("Modifiers: " + modVal);
                System.out.println("Return Type: " + returnVal.getName());
                System.out.println("Parameters: " + params + "\n");
            }
        } catch (ClassNotFoundException c) {
            System.out.println(c.toString());
        }
    }
}
