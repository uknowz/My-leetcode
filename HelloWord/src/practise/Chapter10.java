package practise;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Chapter10 extends JFrame {

	/**
	 * @param args
	 */
	public Chapter10() {
		// TODO �Զ����ɵĹ��캯�����
		String response1 = JOptionPane.showInputDialog(null,
	            "���������","ѯ��",JOptionPane.INFORMATION_MESSAGE);
		setTitle(response1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setVisible(true);
		
	}
	 
	
	
	public static void main(String[] args) {
		Chapter10 a = new Chapter10();
		// TODO �Զ����ɵķ������

	}

}
