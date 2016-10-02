import java.awt.FlowLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonFrame extends SimpleFrame {
    JButton load = new JButton("load");
    JButton save = new JButton("sava");
    JButton unsubscribe = new JButton("a");
    
    public ButtonFrame() {
       // super("我是天才！");
       // setSize(340, 170);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        
        FlowLayout a = new FlowLayout(FlowLayout.LEFT,30,30);
        setLayout(a);
        //pane.add(load);
        //pane.add(save);
        //pane.add(unsubscribe);//调用JPanel实例方法，把组件加到面板上
        add(load);
        add(save);
        add(unsubscribe);//调用了JFrame的add(Componet)的方法将面板作为参数加到框架
        pack();
        setVisible(true);
    }
    private static void setLookAndFeel() {
    	try{
    		UIManager.setLookAndFeel(
    				"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
    				);
    	}catch(Exception exc){
    		//ignore exception
    	}
		
	}

    public static void main(String[] arguments) {
        @SuppressWarnings("unused")
		ButtonFrame bf = new ButtonFrame();
        setLookAndFeel();
    }
}
