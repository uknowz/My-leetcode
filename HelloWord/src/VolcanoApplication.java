
public class VolcanoApplication {
//�����ֻ���������л����˵ģ�������ĺ������main���õķ�������RoBot��
//���涨���
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println("\nvirgil:");//��ʾ��һ�����󣬲�ͬ�Ļ�����
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
	    
	    //��ϰ��һ��
	    
	    
	    
	}

}
