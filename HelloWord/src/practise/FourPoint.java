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
		// TODO 自动生成的构造函数存根
		 this.x = x;//this是用来在方法或构造函数里面引用实例变量，但只有在出现同名变量的时候才需要
		 this.y = y;
		 this.z = z;
		 this.k = k;
	
		
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		FourPoint  chapter52 =new FourPoint(3,2,1,4);
		System.out.println("x坐标是：" + chapter52.x);
		System.out.println("y坐标是：" + chapter52.y);
		System.out.println("z坐标是：" + chapter52.z);
		System.out.println("k坐标是：" + chapter52.k);
		

	}

}
