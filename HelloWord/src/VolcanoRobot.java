import practise.FourPoint;


public class VolcanoRobot {

	/**
	 * @param args
	 */
	//�������������������̽���ɽ�����ַ���
	 String status;
	 int speed;
	 float temperature;
	 
	 public VolcanoRobot(String status,int b,float c) {
		// TODO �Զ����ɵĹ��캯�����
		 this.status = status;//this�������ڷ������캯����������ʵ����������ֻ���ڳ���ͬ��������ʱ�����Ҫ
		 speed = b;
		 temperature = c;
	}
	
	public void checkTemperature() {
	        if (temperature > 660) {
	            this.status = "returning home";
	            speed = 5;
	        }
	    }
//��ʾ������ֵ����ʱ��һ�������ɺ���Ҫ��ʾ��Ϣ������ʾ���������ظ��ģ��Ϳ��Ե���д��һ����ʾ����
	 void showAttributes() {
	        System.out.println("Status: " + status);
	        System.out.println("Speed: " + speed);
	        System.out.println("Temperature: " + temperature);
	    }
	 
	 //main�����ǳ������е���ڣ�һ��java��������û��main�����Ͳ��ܹ�����
	 public static void main(String[] args) {
			// TODO �Զ����ɵķ������
			VolcanoRobot dante = new VolcanoRobot("exploring",2,510);
			//VolcanoRobot dante = new VolcanoRobot("beginning", 2, 1);
		   
		     

		    dante.showAttributes();
		   System.out.println("\nIncreasing speed to 3.");
		    dante.speed = 3;
		    dante.showAttributes();
		    System.out.println("\nChanging temperature to 670.");
		    dante.temperature = 670;
		    dante.showAttributes();
		    System.out.println("\nChecking the temperature.");
		    dante.checkTemperature();
		    dante.showAttributes();
		    
		    FourPoint  chapter52 =new FourPoint(3,2,1,4);
			System.out.println("x�����ǣ�" + chapter52.x);
		    
		}
}
