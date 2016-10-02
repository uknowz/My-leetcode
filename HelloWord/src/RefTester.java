import java.awt.Point;


public class RefTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 Point pt1, pt2;
	        pt1 = new Point(100, 100);
	        pt2 = pt1;

	        pt1.x = 200;
	        pt1.y = 200;
	        System.out.println("Point1: " + pt1.x + ", " + pt1.y);
	        System.out.println("Point2: " + pt2.x + ", " + pt2.y);
	        float gpa = 2.25F;
	        System.out.println("我是天才" + (gpa + 1.5));
	       // Float fi = new Float(12.5F);
	        
	}

}
