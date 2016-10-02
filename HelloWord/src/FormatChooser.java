import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormatChooser extends JFrame implements ItemListener {
    String[] formats = { "(choose format)", "Atom", "RSS 0.92",
        "RSS 1.0", "RSS 2.0" };
    String[] descriptions = {
        "Atom weblog and syndication format",
        "RSS syndication format 0.92 (Netscape)",
        "RSS 1.0 (RDF)",
        "RSS 2.0 (RSS Advisory Board)"
    };
    JComboBox formatBox = new JComboBox();
    JLabel descriptionLabel = new JLabel("");
    
    public FormatChooser() {
        super("Syndication Format");
        setSize(420, 125);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        for (int i = 0; i < formats.length; i++) {
            formatBox.addItem(formats[i]);
        }
        formatBox.addItemListener(this);//选项事件，对于复选框，单选按钮，按钮都可以
        add(BorderLayout.NORTH, formatBox);
        add(BorderLayout.CENTER, descriptionLabel);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent event) {
        int choice = formatBox.getSelectedIndex();
        if (choice > 0) {
             descriptionLabel.setText(descriptions[choice-1]);
        }
    }

    public Insets getInsets() {
        return new Insets(50, 10, 10, 10);
    }

    public static void main(String[] arguments) {
        FormatChooser fc = new FormatChooser();
    }
}
