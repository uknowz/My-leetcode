package socket;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UI973 extends JFrame implements ActionListener {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	 JButton but1 = new JButton("��BBU��Դ");
	
	 JButton but2 = new JButton("��RRU״̬");
	 JButton but3 = new JButton("����BBU�ۺ�");
	 //JButton but4 = new JButton("�� · �� ��");
	 JButton but5 = new JButton("��ȡ��������");
	
	 JTextArea text = new JTextArea(55,100);
	 JScrollPane scroll = new JScrollPane(text,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	UI973() throws MalformedURLException{
		super("���ܹ�����������ƽ̨");
		JPanel panelzo = new JPanel();//frame���panel
		BoxLayout box = new BoxLayout(panelzo, BoxLayout.X_AXIS);
		panelzo.setLayout(box);//�ܵ�panel
		JPanel panelbut = new JPanel();//button��panel
		BoxLayout box2 = new BoxLayout(panelbut, BoxLayout.Y_AXIS);
		panelbut.setLayout(box2);
		JPanel panellbe = new JPanel();//����ͼƬpanel
		JPanel paneltxt = new JPanel();//text panel
		BoxLayout box5 = new BoxLayout(paneltxt, BoxLayout.X_AXIS);
		paneltxt.setLayout(box5);
		
		JPanel paneltl = new JPanel();// topu text panel
		BoxLayout box3 = new BoxLayout(paneltl, BoxLayout.Y_AXIS);
		paneltl.setLayout(box3);
		JLabel label1 = new JLabel();//topu label
		
		
		 JLabel textlab = new JLabel("Ԫ����Ϣ��ʾ:");
		 
		 textlab.setFont(new Font("Dialog", 1, 20));
		 textlab.setForeground(Color.red);
		 BufferedImage image = null;
		 String path = "C:\\Users\\Administrator\\Desktop\\973top3.jpg";
		 try {//��ȡͼƬ
	            image = ImageIO.read(new File(path));
		 } catch (Exception e) {
	            e.printStackTrace();
	        }
		 label1.setIcon(new ImageIcon(image));
		
		 panellbe.add(label1);
		 panellbe.setBackground(Color.WHITE);
		 paneltxt.add(textlab);
	     paneltxt.add(Box.createHorizontalStrut(30));
	     paneltxt.add(scroll);
	     paneltxt.add(Box.createHorizontalStrut(100));
	     paneltxt.setBackground(Color.WHITE);
		 
		 paneltl.add(panellbe);	
		
		 paneltl.add(paneltxt);
		 paneltl.add(Box.createVerticalStrut(50));
		 paneltl.setBackground(Color.WHITE);
		 
		 but1.setPreferredSize(new Dimension(500,200));
		 but1.addActionListener(this);
		 but2.addActionListener(this);
		 but3.addActionListener(this);
		 but5.addActionListener(this);
		 
		 panelbut.add(but5);
	     panelbut.add(Box.createVerticalStrut(80));
	     panelbut.add(but1);
	     panelbut.add(Box.createVerticalStrut(80));
	     panelbut.add(but2);
	     panelbut.add(Box.createVerticalStrut(80));
	     panelbut.add(but3);
	     panelbut.add(Box.createVerticalStrut(250));
	    // panelbut.add(Box.createVerticalStrut(80));
	     //panelbut.add(but4);
	     panelbut.setBackground(Color.WHITE);
	     
	     panelzo.add(Box.createHorizontalStrut(100));
		 panelzo.add(panelbut);
		 panelzo.add(Box.createHorizontalStrut(300));
		 panelzo.add(paneltl);
		 panelzo.add(Box.createHorizontalStrut(150));
		 panelzo.add(Box.createVerticalGlue());//û��
		 panelzo.add(Box.createHorizontalStrut(100));
		 panelzo.setBackground(Color.WHITE);
		 
		 
		 		 	        
		 add(panelzo);			
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(1000,1000);
		 setVisible(true);
	}
	public void showTopo(){
		//��ʾ��������
		XmlDom2 parser = new XmlDom2(); 
	    String pathName = "F:\\socketXml\\physicalTopo.xml";
	    Document document = parser.parse(pathName); 
	    String xmlFrame = parser.xmlMethod3(document);
        text.setText(xmlFrame);
        text.setFont(new Font("����",Font.BOLD,18));
        text.setForeground(Color.BLACK);
	}
	public void showBBU(){
		//��ʾbbu
		XmlDom2 parser = new XmlDom2();
	    String pathName = "F:\\socketXml\\bbu.xml";
	    Document document = parser.parse(pathName); 
	    String xmlFrame = parser.xmlMethodBBU(document);
        text.setText(xmlFrame);
        text.setFont(new Font("����",Font.BOLD,18));
        text.setForeground(Color.BLACK);
	}
	public void showRRU(){
		//��ʾrru
		XmlDom2 parser = new XmlDom2(); 
	    String pathName = "F:\\socketXml\\rru.xml";
	    Document document = parser.parse(pathName); 
	    String xmlFrame = parser.xmlMethodRRU(document);
        text.setText(xmlFrame);
        text.setFont(new Font("����",Font.BOLD,18));
        text.setForeground(Color.BLACK);
	}
	public void showBBUjuhe(){
		//��ʾbbu�ۺ�  
		XmlDom2 parser = new XmlDom2(); 
	    String url = "F:\\socketXml\\bbuJUHE.xml";
	    Document document = parser.parse(url); 
	    String xmlFrame = parser.xmlMethodBBUjuhe(document);
        text.setText(xmlFrame);
        text.setFont(new Font("����",Font.BOLD,18));
        text.setForeground(Color.BLACK);
	}
	public void actionPerformed(ActionEvent event){
		Object source = event.getSource();
		if(source == but5){
			this.showTopo();
		}if(source == but1){
			this.showBBU();//this��ʾ��ǰ����
		}if(source == but2){
			this.showRRU();
		}if(source == but3){
			this.showBBUjuhe();
		}
	}
	public static void main(String[] args) throws MalformedURLException {
		// TODO �Զ����ɵķ������
		new UI973();

	}
	//������д���xml����url
	

}
