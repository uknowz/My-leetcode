package practise;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chapter9 extends JFrame{
	JButton[] dvr = new JButton[5];
	JPanel panel = new JPanel();
	
	public Chapter9(String[] button) {
		// TODO �Զ����ɵĹ��캯�����
		super("�ھ�����ϰ����");//������캯���ĵ��ñ����ǵ�һ�����
		if(button.length == dvr.length){
			for(int i=0; i<dvr.length;i++){
				dvr[i] = new JButton(button[i]);
				panel.add(dvr[i]);
			}
		}else{
			System.out.println("�����������");
		}
		
		setSize(540, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		setVisible(true);
	}
	//main������ĳ���ֻ���������У���������ƣ��㷨����������ƹ�������ʵ�������͹��캯����
	public static void main(String[] args) {
		if(args.length>0){
			Chapter9 application = new Chapter9(args);
			
		}
		
	}
	
}
