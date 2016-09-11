package googleJam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//10^9����int�;��ܸ㶨
public class RobotRockBand {

	/**
	 * @param args
	 */
	public RobotRockBand(Scanner in){
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			int n = in.nextInt();
			int k = in.nextInt();
			int[][] nums = new int[4][n];
			for(int i=0;i<4;i++){
				for(int j=0;j<n;j++){
					nums[i][j] = in.nextInt();
				}
				
			}
			Map<Integer, Integer> AB = new HashMap<Integer, Integer>();
			int ab=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					ab= nums[0][i]^nums[1][j];
					if(!AB.containsKey(ab)){
						AB.put(ab, 1);
					}else AB.put(ab, AB.get(ab)+1);//map��ֵ�������10^6���ᳬ��int��value��¼key���ֵĴ���
				}
			}
			long result = 0;
			int cdk =0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					cdk = nums[2][i]^nums[3][j]^k;
					if(AB.containsKey(cdk)){//Ҫ�Ƚ�ab�Ƿ��cdk��ȣ��Ƚ�map����û�и�keyֵ����
						result = result + AB.get(cdk);//���ܵ������Ϊn^4=12λ�����Ա�����long��
					}
				}
			}
			/*
			Map<Integer, Integer> CDK = new HashMap<>();
			int cdk=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					cdk = nums[2][i]^nums[3][j]^k;
					if(!CDK.containsKey(cdk)){
						CDK.put(cdk, 1);
					}else CDK.put(cdk, CDK.get(cdk)+1);
				}
			}
			Iterator iter1 =AB.entrySet().iterator(); 
			Iterator iter2 =CDK.entrySet().iterator();
			while(iter1.hasNext()){
				while(iter2.hasNext()){
					if(((Map.Entry<Integer,Integer>) iter1.next()).getKey()==((Map.Entry<Integer,Integer>) iter2.next()).getKey()){//���д���
						result = result + ((Map.Entry<Integer,Integer>) iter1.next()).getValue()*((Map.Entry<Integer,Integer>) iter2.next()).getValue();
					}
				}
			}*/
			
			System.out.println("Case #"+t+": "+result);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		String filename = "B-large-practice.in";
		System.setIn(new FileInputStream(filename));	
		System.setOut(new PrintStream(new FileOutputStream("B-large-practice-out.txt")));
		Scanner in = new Scanner(System.in);
	    new RobotRockBand(in);
		in.close();

	}
	

}
