package mycode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Google2 {

//д������Լ���Ԫ����һ�飬������߳�����ȷ��
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Google2 test = new Google2();
		/*�����в���
		if(args.length<0){
			System.out.println("error");
			System.exit(1);
		}else{
			int x1 = Integer.parseInt(args[0]);
			test.method(x1);
		}
		*/
		Scanner sca = new Scanner(System.in);
		System.out.println("Please input a number!");
		if(sca.hasNext()){
			int temp = sca.nextInt();
			test.method(temp);
		}else{
			System.out.println("The wrong number");
			System.exit(1);
		}
		sca.close();
	}
	public void method (int x){
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Character> b = new ArrayList<>();
		
		int r = x;
		int m;
		if(x % 26 !=0){
			//�������ѭ���ǳ�kȡ�෨����ס����26Ϊ����
			for(;;){//�����Ըĸģ�����r��=0��������ɲ����ԣ�һֱadd����m����
				m = r % 26;
				r = r / 26;
				if(r>26){//��һ������һֱ����26��������������list a����
					a.add(m);
				}
				if(r<26 && r!=0){//��һ�����ǵ��������������ʱ��r�������ˣ�ҲҪ��r�Ž�list a
					a.add(m);
					a.add(r);
					break;
				}if(r==0){//һ��ʼ����26��û���̵ģ���С��26��������ʱ��Ϊ0���ѵ�һ��ȡģ��ֵ���뼴��
					a.add(m);
					break;
				}
			}
			//������֤method����д��������ȷ����kȡ�෨��ȷ
			for(Iterator<Integer> ite = a.iterator(); ite.hasNext();){
				int array = ite.next();
				System.out.print(array +" ");//һ��Ҫ��ס��print��ӡ�ַ�����ʱ�򣬱���+�ַ����ո���˫���ţ����õ�����
				
			}
			
			for(int i=0;i<a.size();i++){
				int num = a.get(i)-1;
				char chr = (char)('A'+num);//��������õ�26����ת��Ϊ�ַ�����ÿһλ��Ӧһ���ַ�
				b.add(chr); 
			}
			System.out.println("\n" + "result is:");//���з�Ҫ��˫����
			for(int j=b.size()-1; j>=0; j--){
				System.out.print(b.get(j));//Ϊʲô��indexoutofbound����Ϊ��j�����ʼ�㣬����list����������size-1
			}
			
		}else{//���Ǳ߽�ֵ���⣬�ܳ���26�Ļ�������
			for(;r>=26;){
				m = r % 26;
				r = r / 26;
				a.add(m);
			}
			a.add(r);//���һ������ӽ�ȥ
			for(Iterator<Integer> ite = a.iterator(); ite.hasNext();){
				int array = ite.next();
				System.out.print(array +" ");//һ��Ҫ��ס��print��ӡ�ַ�����ʱ�򣬱���+�ַ����ո���˫���ţ����õ�����
				
			}
			b.add('z');
			for(int i=1;i<a.size();i++){
				if(a.get(i)==1){
					b.add('z');
					continue;
				}else if(a.get(i)>1){
					int num3 = a.get(i)-2;
					char chr2 = (char) ('A' + num3);
					
					
				}
				
			}
		}
	}

}
