import java.awt.Point;


public class PointSetter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		        Point location = new Point(4, 13);

		        System.out.println("Starting location:");
		        System.out.println("X equals " + location.x);
		        System.out.println("Y equals " + location.y);

		        System.out.println("\nMoving to (7, 6)");
		        location.setLocation(7, 6);
		        //location.x = 7;//����ȡʵ������������ʾ����ʾֵ,�����point������field x��y��ʾ�ж���������ʵ������
		        //location.y = 6;

		        System.out.println("\nEnding location:");
		        System.out.println("X equals " + location.x);
		        System.out.println("Y equals " + location.y);

	}

}
