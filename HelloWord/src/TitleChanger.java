import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TitleChanger extends JFrame implements ActionListener {
    JButton b1 = new JButton("帅哥");
    JButton b2 = new JButton("美女");
    JPanel panel = new JPanel();

    public TitleChanger() {
        super("Title Bar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(this);//可以在构造函数中调用自定义的方法，
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
            this.setTitle("帅哥");
        } else if (source == b2) {
            this.setTitle("美女");
        }
        repaint();//修改标题后，重绘框架
    }

    public static void main(String[] arguments) {
        TitleChanger frame = new TitleChanger();
    }
}
