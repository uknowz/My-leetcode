package hihocoder;
import java.util.Scanner;
//΢����Եڶ��� 403 forbidden�����İ����гɹ�,�ı���rules�ṹ������allow��deny�ֿ�����rules˳��ƥ��(�ַ���ƥ�䴦��,δ��ǰ׺��)��ʱ�临�Ӷȴ��Թ���Ϊo(n^2)
//���Ǳ������ѣ�û���õ��κ��㷨��ֻ��һһ�����ַ���
public class Forbidden {
	private static class IPtoInt {//����Ϊ�ڲ���̬�ֻ࣬�ܸ���ʹ�ã��ڲ��Ǿ�̬�಻�Ƕ��徲̬��Ա
	    // ��д�˷�������ip��ַת��Ϊ�����ơ��������������ԭ������
	    public static String ipToint(String strIP) {
	        String[] ip = new String[4];
	        String zero = "00000000";//������λ��
	        String[] ipstr = strIP.split("\\.");
	        //����ת��Ϊ�ַ��������ƣ�tobinarystring������������Ͳ��Ჹ��λ
	        ip[0] = Integer.toBinaryString(Integer.parseInt(ipstr[0]));
	        ip[1] = Integer.toBinaryString(Integer.parseInt(ipstr[1]));
	        ip[2] = Integer.toBinaryString(Integer.parseInt(ipstr[2]));
	        ip[3] = Integer.toBinaryString(Integer.parseInt(ipstr[3]));
	        for(int i=0;i<4;i++){
	        	if(ip[i].length()<8){
	        		ip[i] =zero.substring(0,8-ip[i].length()) + ip[i];//���ÿһ��ip�����λ����ô���ַ����ӷ���λ��0,����ѭ����һ���Բ�0����Ϊip.length()һֱ���  
	        	}
	        }
	        return ip[0]+ip[1]+ip[2]+ip[3];
	    }
	 } 

	Forbidden(Scanner in){
		int N = in.nextInt();
		int M = in.nextInt();
		@SuppressWarnings("unused")
		String delete = in.nextLine();//��ȡ��ĩβ����Ҫ����ʱ��Ҫ���һ��string.nextline()
		if(1<=N && M<=100000){
			String[] rules = new String[N];//��ȡrules����
			for(int i=0;i<N;i++){
				rules[i] = in.nextLine();
			}
			String[] request = new String[M];//��ȡrequest����
			for(int j=0;j<M;j++){
				request[j] = in.nextLine();
			}
			/*
			 * @param output[]Ϊ������
			 * �������ѭ������ÿһ��request�Ƿ�ƥ��rules
			 */
			String[] output = new String[M];
			for(int j=0;j<M;j++){
				for(int i =0;i<N;i++){
					output[j]=matchRules(request[j], rules[i]);
					if(output[j].equals("noMatch")){
						if(i==N-1) output[j] = "YES";//�������һ���ٸ�ֵ������ÿ�θ�ֵyes
						continue;
					}else{
						break;
					}
						
				}
				System.out.println(output[j]);
			}		
		}
		in.close();
	}
	
	/*
	 * @param nΪrules�������˷���������װrules
	 * @param sΪÿһ�ж�ȡ��rules string
	 */
	public String matchRules(String request,String rules){
		
		String[] ruleSplit = rules.split(" ");//��rulesǰ��ı�Ǻ�ip�ָ�
		if(ruleSplit[0].equals("allow")){
			if(request.equals(ruleSplit[1])){
				return "YES";
			}else if(ruleSplit[1].contains("/")){
				String requBina = IPtoInt.ipToint(request);
				String[] ruleSplit2 = ruleSplit[1].split("/");//rule������/�ķָ�
				int mask = Integer.parseInt(ruleSplit2[1]);
				String ruleBina = IPtoInt.ipToint(ruleSplit2[0]);
				if(requBina.substring(0,mask).equals(ruleBina.substring(0,mask))){
					return "YES";
				}
			}
		}else if(ruleSplit[0].equals("deny")){
			if(request.equals(ruleSplit[1])){
				return "NO";
			}else if(ruleSplit[1].contains("/")){
				String requBina = IPtoInt.ipToint(request);
				String[] ruleSplit2 = ruleSplit[1].split("/");//rule������/�ķָ�
				int mask = Integer.parseInt(ruleSplit2[1]);
				String ruleBina = IPtoInt.ipToint(ruleSplit2[0]);
				if(requBina.substring(0,mask).equals(ruleBina.substring(0,mask))){
					return "NO";
				}
			}
		}
		return "noMatch";//���û��ƥ������rules���򷵻��ض��ַ��������Լ���ƥ����һ��rules����Ҳ��˳��ƥ��Ĺؼ��ʡ�
		//��Ϊ��Ŀ��ƥ������ǣ���requestһ��һ��ƥ��rules�����˳��ƥ��������һ��rule����������Ϣ��ֹͣ����rules��ƥ�䣬���ԣ�����ζ�ţ��ҵ�ƥ�䷽������Ӧ��д��rules����ƥ�䣬���ؽ������
		//Ӧ���ǵ���ruleƥ�䣬���ص���ƥ���������õ������ȥ�ж�����ƥ������
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		@SuppressWarnings("unused")
		Forbidden forbidden = new Forbidden(in);
		

	}
	
}

 

