package practise;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;


public class Chapter12 extends JFrame implements FocusListener{

	/**
	 * @param args
	 */
	JLabel lab = new JLabel("ֻ����������");
	JTextField text = new JTextField(" ",5);
	JPanel panel = new JPanel();
	public Chapter12(){
		super("�����ı���");
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
		// TODO �Զ����ɵķ������
		Chapter12 exam = new Chapter12();
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO �Զ����ɵķ������
		if(Float.parseFloat(text.getText())<0){
			float a = Float.parseFloat(text.getText()) * -1;
			text.setText(" " + a);
		}
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO �Զ����ɵķ������
		focusGained(arg0);
	}

}
