package practise;

import java.awt.Point;

public class FourPoint extends Point {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8847492362137626408L;
	/**
	 * 
	 */
	
	int z,k;
	 public FourPoint(int x, int y,int z, int k) {
		// TODO �Զ����ɵĹ��캯�����
		 this.x = x;//this�������ڷ������캯����������ʵ����������ֻ���ڳ���ͬ��������ʱ�����Ҫ
		 this.y = y;
		 this.z = z;
		 this.k = k;
	
		
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		FourPoint  chapter52 =new FourPoint(3,2,1,4);
		System.out.println("x�����ǣ�" + chapter52.x);
		System.out.println("y�����ǣ�" + chapter52.y);
		System.out.println("z�����ǣ�" + chapter52.z);
		System.out.println("k�����ǣ�" + chapter52.k);
		

	}

}
