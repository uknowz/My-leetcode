package practise;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;


public class Chapter12 extends JFrame implements FocusListener{

	/**
	 * @param args
	 */
	JLabel lab = new JLabel("只能输入正数");
	JTextField text = new JTextField(" ",5);
	JPanel panel = new JPanel();
	public Chapter12(){
		super("正数文本框");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		panel.setLayout(new BorderLayout());
		panel.add(lab,BorderLayout.NORTH);
		text.addFocusListener(this);
		panel.add(text,BorderLayout.CENTER);
		add(panel);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Chapter12 exam = new Chapter12();
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO 自动生成的方法存根
		if(Float.parseFloat(text.getText())<0){
			float a = Float.parseFloat(text.getText()) * -1;
			text.setText(" " + a);
		}
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO 自动生成的方法存根
		focusGained(arg0);
	}

}
