package mycode;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Joptionpanle extends JFrame{

	/**
	 * @param args
	 */
	public Joptionpanle(){
		super();
		setTitle("好东西");
		setSize(400,300);
		JOptionPane pane = new JOptionPane();
		String a =JOptionPane.showInputDialog("请输入正确值");
		int b = Integer.parseInt(a);
		JOptionPane.showMessageDialog(pane,"输入的值是：" + b);
		add(pane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Joptionpanle example = new Joptionpanle();
	}

}
