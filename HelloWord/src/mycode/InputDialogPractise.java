package mycode;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class InputDialogPractise extends JFrame {
	/*
    JButton a = new JButton("Alibi");
    JButton b = new JButton("Burglar");
    JButton c = new JButton("Corpse");
    JButton d = new JButton("Deadbeat");
    JButton e = new JButton("Evidence");
    JButton f = new JButton("Fugitive");
    */
    JButton[] lay = new JButton[6];

    public InputDialogPractise() {
        super("���ֹ�����");
        setSize(360, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        FlowLayout lm = new FlowLayout(FlowLayout.LEFT);
        p.setLayout(lm);
        
        for(int i=0;i<lay.length;i++){
        	String responce = JOptionPane.showInputDialog(null,"���밴ť����","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
        	lay[i] = new JButton(responce);
        	p.add(lay[i]);
        }
        add(p);
       /*
        add(a);
        add(b);
        add(c);
        add(d);
        add(e);
        add(f);//����Ҫ����ˣ�ֱ��add���
        */
        setVisible(true);
    }

    public static void main(String[] arguments) {
        InputDialogPractise frame = new InputDialogPractise();
    }
}
