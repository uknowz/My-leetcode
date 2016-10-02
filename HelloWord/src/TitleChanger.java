import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TitleChanger extends JFrame implements ActionListener {
    JButton b1 = new JButton("˧��");
    JButton b2 = new JButton("��Ů");
    JPanel panel = new JPanel();

    public TitleChanger() {
        super("Title Bar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(this);//�����ڹ��캯���е����Զ���ķ�����
        b2.addActionListener(this);
       // FlowLayout flow = new FlowLayout();
        panel.setLayout(new FlowLayout());
        panel.add(b1);
        panel.add(b2);
        add(panel);
        setSize(500,300);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source == b1) {
            this.setTitle("˧��");
        } else if (source == b2) {
            this.setTitle("��Ů");
        }
        repaint();//�޸ı�����ػ���
    }

    public static void main(String[] arguments) {
        TitleChanger frame = new TitleChanger();
    }
}
