import java.awt.BorderLayout;

import javax.swing.*;


public class Border extends JFrame {

	/**
	 * @param args
	 */
	public Border() {
		// TODO �Զ����ɵĹ��캯�����
		super("�߽粼��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JButton nbu = new JButton("��");
		JButton wbu = new JButton("��");
		JButton cbu = new JButton("�м�");
		JButton ebu = new JButton("��");
		JButton sbu = new JButton("��");
		panel.add(sbu,BorderLayout.SOUTH);
		panel.add(ebu,BorderLayout.EAST);
		panel.add(cbu, BorderLayout.CENTER);
		panel.add(wbu,BorderLayout.WEST);
		panel.add(nbu,BorderLayout.NORTH);
		add(panel);
		//pack();
		setSize(240,280);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Border bo = new Border();
	}

}
