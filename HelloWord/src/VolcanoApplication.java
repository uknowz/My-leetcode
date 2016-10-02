
public class VolcanoApplication {
//这个类只是用来运行机器人的，它里面的函数入口main调用的方法都是RoBot类
//里面定义的
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("\nvirgil:");//表示另一个对象，不同的机器人
		VolcanoRobot virgil = new VolcanoRobot("beginning",4,650);
	    
	    virgil.showAttributes();
	    
	    System.out.println("\ndante:");
		VolcanoRobot dante = new VolcanoRobot("exploring",2,510);
	    

	    dante.showAttributes();
	    System.out.println("Increasing speed to 3.");
	    dante.speed = 3;
	    dante.showAttributes();
	    System.out.println("Changing temperature to 670.");
	    dante.temperature = 670;
	    dante.showAttributes();
	    System.out.println("Checking the temperature.");
	    dante.checkTemperature();
	    dante.showAttributes();
	    
	    //练习第一章
	    
	    
	    
	}

}
