import java.util.StringTokenizer;


public class TokenTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//StringTokenizer st1, st2;

        String quote1 = "VIZY 3 -1/16";
        StringTokenizer st1 = new StringTokenizer(quote1);//将一个字符串按标记分成多个字符串
        System.out.println("Token 1: " + st1.nextToken()+" " + st1.countTokens());
        System.out.println("Token 2: " + st1.nextToken() +" " + st1.countTokens());
        System.out.println(st1.hasMoreTokens());
        System.out.println("Token 3: " + st1.nextToken()+" " + st1.countTokens());
        System.out.println(st1.hasMoreTokens());

        
        String quote2 = "NPLI@9 27/32@3/32";
        StringTokenizer st2 = new StringTokenizer(quote2, "@",true);//如果是系统已经定义的类，用构造函数，自己开发的类，为了理解别用
        System.out.println("\nToken 1: " + st2.nextToken());
        System.out.println("Token 2: " + st2.nextToken());
        System.out.println("Token 3: " + st2.nextToken());
        System.out.println("Token 4: " + st2.nextToken());
        System.out.println("Token 5: " + st2.nextToken());

	}

}
