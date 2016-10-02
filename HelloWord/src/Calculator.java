import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame implements FocusListener {
    JTextField value1 = new JTextField(" ", 5);
    JLabel plus = new JLabel("+");
    JTextField value2 = new JTextField(" ", 5);
    JLabel equals = new JLabel("=");
    JTextField sum = new JTextField(" ", 5);
    
    public Calculator() {
        super("Add Two Numbers");
        this.setSize(350, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        setLayout(flow);
        // add listeners
        value1.addFocusListener(this);
        value2.addFocusListener(this);
        // set up sum field
        sum.setEditable(false);
        // add components
        add(value1);
        add(plus);
        add(value2);
        add(equals);
        add(sum);
        setVisible(true);
    }

    public void focusGained(FocusEvent event) {
        try {
        	
        		float total = Float.parseFloat(value1.getText()) +
                        Float.parseFloat(value2.getText());//得到文本框信息，以字符串返回
                    sum.setText("" + total);
        	
            //文本框设置字符串，使用了+号计算符
        } catch (NumberFormatException nfe) {
            value1.setText("0");
            value2.setText("0");
            sum.setText("0");
        }
    }

    public void focusLost(FocusEvent event) {
        this.focusGained(event);//失去焦点的组件和得到焦点的组件所做的事相同
    }

    public static void main(String[] arguments) {
        Calculator frame = new Calculator();
    }
}
