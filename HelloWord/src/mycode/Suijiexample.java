package mycode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
//�����1~36������7����������ͬһ��������h
public class Suijiexample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		Random random=new Random();
		//int [] r=new int[7];
		ArrayList<Integer> list = new ArrayList<>(7);
		
		System.out.print("���");
		for (int i = 0; i <list.size(); i++) {
			
			int temp=random.nextInt(37);//����0~36�������������ָ��value
			//�����������0
			System.out.print("���");
			if(temp==0 || list.contains(temp)){
				i--;
				continue;//��break��ͬ�������������жϱ���ѭ������ʼ��һ��ѭ�����������������ѭ�����Ͳ���ִ��
			}
		    //�������ѭ���������Ǽ��������r[i]��û�кͲ�����������ظ������ظ��򲻸�ֵ��r[]��һ��Ԫ��
			/*
			for(int j=0; j<=i; j++){
				if(r[j]==temp)
					continue;	
			}
			*/
			System.out.print("���");
			list.add(temp);
			
		}
		
		for(Iterator ite = list.iterator(); ite.hasNext();){
			int j = (Integer)ite.next();
			System.out.print(j);
		}


	}

}
