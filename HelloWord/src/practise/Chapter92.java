package practise;

import javax.swing.*;

public class Chapter92 extends JFrame{

	/**
	 * @param args
	 */
	JLabel label1 = new JLabel("用户名",SwingConstants.LEFT);
	JLabel label2 = new JLabel("密码啊",SwingConstants.LEFT);
	JPanel panel = new JPanel();
	JButton button1 = new JButton("OK");
	JButton button2 = new JButton("Cancel");
	
	//有一点，就是现在还在用纯代码设计界面，而且还没有布局管理器，有直观的UI设计，不用纯代码
	public Chapter92(){
		super("登录界面");
		JTextField text1 = new JTextField(15);
		JPasswordField text2 = new JPasswordField(15);
		text2.setEchoChar('#');
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(button1);
		panel.add(button2);
		
		setSize(240,220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Chapter92 login = new Chapter92();
	}

}
