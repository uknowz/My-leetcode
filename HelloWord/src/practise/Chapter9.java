package practise;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chapter9 extends JFrame{
	JButton[] dvr = new JButton[5];
	JPanel panel = new JPanel();
	
	public Chapter9(String[] button) {
		// TODO 自动生成的构造函数存根
		super("第九章练习程序");//这个构造函数的调用必须是第一个语句
		if(button.length == dvr.length){
			for(int i=0; i<dvr.length;i++){
				dvr[i] = new JButton(button[i]);
				panel.add(dvr[i]);
			}
		}else{
			System.out.println("参数输入错误");
		}
		
		setSize(540, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		setVisible(true);
	}
	//main方法里的程序只是用来运行，不进行设计，算法，参数的设计工作放在实例方法和构造函数中
	public static void main(String[] args) {
		if(args.length>0){
			Chapter9 application = new Chapter9(args);
			
		}
		
	}
	
}
