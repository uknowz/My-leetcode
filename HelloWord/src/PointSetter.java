import java.awt.Point;


public class PointSetter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		        Point location = new Point(4, 13);

		        System.out.println("Starting location:");
		        System.out.println("X equals " + location.x);
		        System.out.println("Y equals " + location.y);

		        System.out.println("\nMoving to (7, 6)");
		        location.setLocation(7, 6);
		        //location.x = 7;//对象取实例变量，句点表示法显示值,在这个point类里有field x和y表示有定义这两个实例变量
		        //location.y = 6;

		        System.out.println("\nEnding location:");
		        System.out.println("X equals " + location.x);
		        System.out.println("Y equals " + location.y);

	}

}
