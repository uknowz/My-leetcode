package mycode;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Joptionpanle extends JFrame{

	/**
	 * @param args
	 */
	public Joptionpanle(){
		super();
		setTitle("�ö���");
		setSize(400,300);
		JOptionPane pane = new JOptionPane();
		String a =JOptionPane.showInputDialog("��������ȷֵ");
		int b = Integer.parseInt(a);
		JOptionPane.showMessageDialog(pane,"�����ֵ�ǣ�" + b);
		add(pane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Joptionpanle example = new Joptionpanle();
	}

}
