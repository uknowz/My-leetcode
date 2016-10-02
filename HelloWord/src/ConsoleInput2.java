import java.util.*;
//这个类专门用来练控制台输入输出的
class ConsoleInput2{
	
public static void main(String []args){
	//scanner输入流扫描器，用于控制台输入
	System.out.println("请输入四个参数");
	Scanner cin;
    cin=new Scanner(System.in);
    /*
    ArrayList<Integer> a ;
    ArrayList<Integer> b ;
    int num =cin.nextInt();
    a = new ArrayList<>(num);//动态数组自动增减容量add和remove，怎么可能用来固定长度，好笨哦
    b = new ArrayList<>(num);
    for(int i=0;i<a.size();i++){
    	int input = cin.nextInt();
    	a.add(input);	
    }
    for(int j=0;j<a.size();j++){
    	b.add(a.get(j)+1);
    	System.out.println(b.get(j));
    }
    */
    //记住，如果输入输出固定，那么用数组，不固定的时候采用动态数组或链表，map等
    /*
    int size = cin.nextInt();
    int[] a = new int[size];
    for(int i=0;i<a.length;i++){
    	a[i] = cin.nextInt();
    }
    for(int j=0;j<a.length;j++){
    	System.out.println(a[j]);
    }
    */
    //这是测试能不能同一个main函数里用两个控制台输入流。cin和sca
	int a = cin.nextInt();
	//String b = cin.next();
	String b = cin.next();
	//String d = cin.nextLine();
	int c = cin.nextInt();
	
	Scanner sca = new Scanner(System.in);
	int e = sca.nextInt();
	int z = sca.nextInt();
	//String g = sca.nextLine();
	String f = sca.next();//要读string的话，可以用next
	
	sca.close();
	cin.close();
	System.out.println(a+b+c+e+f+z);
	}
}