import java.util.*;
//�����ר������������̨���������
class ConsoleInput2{
	
public static void main(String []args){
	//scanner������ɨ���������ڿ���̨����
	System.out.println("�������ĸ�����");
	Scanner cin;
    cin=new Scanner(System.in);
    /*
    ArrayList<Integer> a ;
    ArrayList<Integer> b ;
    int num =cin.nextInt();
    a = new ArrayList<>(num);//��̬�����Զ���������add��remove����ô���������̶����ȣ��ñ�Ŷ
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
    //��ס�������������̶�����ô�����飬���̶���ʱ����ö�̬���������map��
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
    //���ǲ����ܲ���ͬһ��main����������������̨��������cin��sca
	int a = cin.nextInt();
	//String b = cin.next();
	String b = cin.next();
	//String d = cin.nextLine();
	int c = cin.nextInt();
	
	Scanner sca = new Scanner(System.in);
	int e = sca.nextInt();
	int z = sca.nextInt();
	//String g = sca.nextLine();
	String f = sca.next();//Ҫ��string�Ļ���������next
	
	sca.close();
	cin.close();
	System.out.println(a+b+c+e+f+z);
	}
}