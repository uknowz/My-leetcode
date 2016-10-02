import java.awt.BorderLayout;

import javax.swing.*;


public class Border extends JFrame {

	/**
	 * @param args
	 */
	public Border() {
		// TODO 自动生成的构造函数存根
		super("边界布局");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JButton nbu = new JButton("北");
		JButton wbu = new JButton("西");
		JButton cbu = new JButton("中间");
		JButton ebu = new JButton("东");
		JButton sbu = new JButton("南");
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
		// TODO 自动生成的方法存根
		Border bo = new Border();
	}

}
