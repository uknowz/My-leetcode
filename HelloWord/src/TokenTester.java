import java.util.StringTokenizer;


public class TokenTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//StringTokenizer st1, st2;

        String quote1 = "VIZY 3 -1/16";
        StringTokenizer st1 = new StringTokenizer(quote1);//��һ���ַ�������Ƿֳɶ���ַ���
        System.out.println("Token 1: " + st1.nextToken()+" " + st1.countTokens());
        System.out.println("Token 2: " + st1.nextToken() +" " + st1.countTokens());
        System.out.println(st1.hasMoreTokens());
        System.out.println("Token 3: " + st1.nextToken()+" " + st1.countTokens());
        System.out.println(st1.hasMoreTokens());

        
        String quote2 = "NPLI@9 27/32@3/32";
        StringTokenizer st2 = new StringTokenizer(quote2, "@",true);//�����ϵͳ�Ѿ�������࣬�ù��캯�����Լ��������࣬Ϊ��������
        System.out.println("\nToken 1: " + st2.nextToken());
        System.out.println("Token 2: " + st2.nextToken());
        System.out.println("Token 3: " + st2.nextToken());
        System.out.println("Token 4: " + st2.nextToken());
        System.out.println("Token 5: " + st2.nextToken());

	}

}
