package practise;

import javax.swing.*;

public class Chapter92 extends JFrame{

	/**
	 * @param args
	 */
	JLabel label1 = new JLabel("�û���",SwingConstants.LEFT);
	JLabel label2 = new JLabel("���밡",SwingConstants.LEFT);
	JPanel panel = new JPanel();
	JButton button1 = new JButton("OK");
	JButton button2 = new JButton("Cancel");
	
	//��һ�㣬�������ڻ����ô�������ƽ��棬���һ�û�в��ֹ���������ֱ�۵�UI��ƣ����ô�����
	public Chapter92(){
		super("��¼����");
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
		// TODO �Զ����ɵķ������
		Chapter92 login = new Chapter92();
	}

}
