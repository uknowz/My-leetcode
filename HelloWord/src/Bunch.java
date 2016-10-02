import java.awt.GridLayout;

import javax.swing.*;


public class Bunch extends JFrame {

	/**
	 * @param args
	 */
	JButton[] bu = new JButton[9];
	JPanel panel = new JPanel();
	public Bunch(){
		super("九按钮");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gr = new GridLayout(3,3);
		panel.setLayout(gr);
		
	}
	/*public void addpanel(String name){
		for(int i=0; i<bu.length; i++){
			bu[i] = new JButton(name);
			panel.add(bu[i]);
		}
	}
	*/
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		if(args.length>8){
			Bunch bunch = new Bunch();
			for(int j=0;j<args.length;j++){
				bunch.bu[j] = new JButton(args[j]);
				bunch.panel.add(bunch.bu[j]);
			}
			bunch.add(bunch.panel);
			bunch.pack();
			bunch.setVisible(true);
		}
	}

}
