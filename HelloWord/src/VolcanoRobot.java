import practise.FourPoint;


public class VolcanoRobot {

	/**
	 * @param args
	 */
	//此类是用来定义机器人探测火山的种种方法
	 String status;
	 int speed;
	 float temperature;
	 
	 public VolcanoRobot(String status,int b,float c) {
		// TODO 自动生成的构造函数存根
		 this.status = status;//this是用来在方法或构造函数里面引用实例变量，但只有在出现同名变量的时候才需要
		 speed = b;
		 temperature = c;
	}
	
	public void checkTemperature() {
	        if (temperature > 660) {
	            this.status = "returning home";
	            speed = 5;
	        }
	    }
//显示变量的值，有时候当一项操作完成后需要显示信息，而显示变量又是重复的，就可以单独写出一个显示方法
	 void showAttributes() {
	        System.out.println("Status: " + status);
	        System.out.println("Speed: " + speed);
	        System.out.println("Temperature: " + temperature);
	    }
	 
	 //main方法是程序运行的入口，一个java程序里面没有main方法就不能够运行
	 public static void main(String[] args) {
			// TODO 自动生成的方法存根
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
			System.out.println("x坐标是：" + chapter52.x);
		    
		}
}
