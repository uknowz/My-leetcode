import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class FeedBar extends JFrame {

    public FeedBar() {
        super("FeedBar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //这一段显示带图标的button总是有问题
        // create icons
        ImageIcon loadIcon = new ImageIcon("load.gif");
        ImageIcon saveIcon = new ImageIcon("save.gif");
        ImageIcon subscribeIcon = new ImageIcon("subscribe.gif");
        ImageIcon unsubscribeIcon = new ImageIcon("unsubscribe.gif");
        // create buttons
        JButton load = new JButton("Load", loadIcon); 
        JButton save = new JButton("Save", saveIcon);
        JButton subscribe = new JButton("Subscribe", subscribeIcon);
        JButton unsubscribe = new JButton("Unsubscribe", unsubscribeIcon);
        
        
        
        // add buttons to toolbar
        JToolBar bar = new JToolBar();
        bar.add(load);
        bar.add(save);
        bar.add(subscribe);
        bar.add(unsubscribe);
        // prepare user interface
        JTextArea edit = new JTextArea(8, 40);
        JScrollPane scroll = new JScrollPane(edit);
       // BorderLayout bord = new BorderLayout();
        setLayout(new BorderLayout());
        add("South", bar);
        add("Center", scroll);
        pack();
        setVisible(true);
    }

    public static void main(String[] arguments) {
        FeedBar frame = new FeedBar();
    }
}
