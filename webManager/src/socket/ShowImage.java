package socket;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
 
public class ShowImage extends JPanel {
	 JPanel panelzo = new JPanel();//frame里的panel
	 JPanel panel1bu = new JPanel();//组件和button的panel
	 JPanel panel = new JPanel();//组件的panel
	 JPanel panel1 = new JPanel();
	 JPanel panel2 = new JPanel();
	 JPanel panel3 = new JPanel();
	 JPanel panel4 = new JPanel();//放rru3
	 JPanel panel5 = new JPanel();//textarea
	 JLabel textlab = new JLabel("组件元素信息:");
	 JPanel panelbut = new JPanel();//button panel
	 JButton but1 = new JButton("测BBU利用率");
	 JButton but2 = new JButton("启动BBU聚合");
	 JButton but3 = new JButton("启动COMP");
	 JButton but4 = new JButton("建 路 请 求");
	 JButton but5 = new JButton("获取物理拓扑");
	 JTextArea text = new JTextArea(20,80);
	 JScrollPane scroll = new JScrollPane(text,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 JLabel lbel1 = new JLabel("BBUpool(id:1.2)");
	 JLabel lbel2 = new JLabel("WSS1(id:9)");
	 JLabel lbel3 = new JLabel("NE(id:3)");
	 JLabel lbel4 = new JLabel("RRU1(id:4)");
	 JLabel lbel5 = new JLabel("RRU2(id:5)");
	 JLabel lbel6 = new JLabel("RRU3(id:6)");
	 JLabel lbel7 = new JLabel("RRU4(id:7)");
	 JLabel lbel8 = new JLabel("RRU5(id:8)");
	 JLabel lbel9 = new JLabel("WSS2(id:10)");
	 JLabel lbel10 = new JLabel("WSS3(id:11)");
	 JLabel lbel11 = new JLabel("WSS4(id:12)");
	 JLabel lbel12 = new JLabel("WSS5(id:13)");
	 Point po1 ;
     Point po2 ;
     Point po3 ;
     Point po4 ;
     Point po5 ;
     Point po6 ;
     Point po7 ;
     Point po8 ;
     Point po9 ;
     Point po10 ;
     Point po11 ;
     Point po12 ;
     
	public ShowImage(){	
		
		 textlab.setFont(new Font("Dialog", 1, 20));
		 textlab.setForeground(Color.red);				 		 
		 but1.setPreferredSize(new Dimension(100,100));		 
		// BoxLayout boxzo = new BoxLayout(panelzo, BoxLayout.Y_AXIS);
		 //panelzo.setLayout(boxzo);
		 BoxLayout box = new BoxLayout(panel, BoxLayout.X_AXIS);
		 panel.setLayout(box);//总的panel
		 BoxLayout box1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
		 panel1.setLayout(box1);
		 BoxLayout box2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
		 panel2.setLayout(box2);
		 BoxLayout box3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
		 panel3.setLayout(box3);
		 BoxLayout box4 = new BoxLayout(panel4, BoxLayout.Y_AXIS);
		 panel4.setLayout(box4);
		 BoxLayout boxbut = new BoxLayout(panelbut, BoxLayout.Y_AXIS);
		 panelbut.setLayout(boxbut);
		 BoxLayout box5 = new BoxLayout(panel1bu, BoxLayout.X_AXIS);//组件和butoon水平布局
		 panel1bu.setLayout(box5);
				 		 
	     BufferedImage image1 = null;
	     BufferedImage image2 = null;
	     BufferedImage image3 = null;
	     BufferedImage image4 = null;
	     String path1 = "C:\\Users\\Administrator\\Desktop\\973image\\WSS.jpg";
	     String path2 = "C:\\Users\\Administrator\\Desktop\\973image\\NE.jpg";
	     String path3 = "C:\\Users\\Administrator\\Desktop\\973image\\RRU.jpg";
	     String path4 = "C:\\Users\\Administrator\\Desktop\\973image\\BBUpool.jpg";
	        try {//读取图片
	            image1 = ImageIO.read(new File(path1));
	            image2 = ImageIO.read(new File(path2));
	            image3 = ImageIO.read(new File(path3));
	            image4 = ImageIO.read(new File(path4));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        //设置图片标签，共十三个
	        lbel1.setIcon(new ImageIcon(image4));//bbu
	        lbel1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel1.setHorizontalTextPosition(SwingConstants.CENTER);//jlabel实现了swingconstants接口
	        lbel2.setIcon(new ImageIcon(image1));//wss
	        lbel2.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel2.setHorizontalTextPosition(SwingConstants.CENTER);
	        lbel3.setIcon(new ImageIcon(image2));//ne
	        lbel3.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel3.setHorizontalTextPosition(SwingConstants.CENTER);
	        lbel4.setIcon(new ImageIcon(image3));//rru
	        lbel4.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel4.setHorizontalTextPosition(SwingConstants.CENTER);
	        lbel5.setIcon(new ImageIcon(image3));//rru
	        lbel5.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel5.setHorizontalTextPosition(SwingConstants.CENTER);
	        lbel6.setIcon(new ImageIcon(image3));//rru
	        lbel6.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel6.setHorizontalTextPosition(SwingConstants.CENTER);
	        lbel7.setIcon(new ImageIcon(image3));//rru
	        lbel7.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel7.setHorizontalTextPosition(SwingConstants.CENTER);
	        lbel8.setIcon(new ImageIcon(image3));//rru
	        lbel8.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel8.setHorizontalTextPosition(SwingConstants.CENTER);
	        lbel9.setIcon(new ImageIcon(image1));//wss
	        lbel9.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel9.setHorizontalTextPosition(SwingConstants.CENTER);
	        lbel10.setIcon(new ImageIcon(image1));//wss
	        lbel10.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel10.setHorizontalTextPosition(SwingConstants.CENTER);
	        lbel12.setIcon(new ImageIcon(image1));//wss
	        lbel12.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel12.setHorizontalTextPosition(SwingConstants.CENTER);
	        lbel11.setIcon(new ImageIcon(image1));//wss
	        lbel11.setVerticalTextPosition(SwingConstants.BOTTOM);
	        lbel11.setHorizontalTextPosition(SwingConstants.CENTER);
	        
	        panel1.add(lbel1);
	        
	        panel1.add(Box.createHorizontalStrut(120));
	        panel1.add(lbel3);
	        panel2.add(lbel4);
	        panel2.add(Box.createVerticalStrut(80));
	        panel2.add(lbel2);
	        panel2.add(Box.createVerticalStrut(80));
	        panel2.add(lbel12);
	        panel2.add(Box.createVerticalStrut(80));
	        panel2.add(lbel8);
	        panel3.add(lbel5);
	        panel3.add(Box.createVerticalStrut(80));
	        panel3.add(lbel9);
	        panel3.add(Box.createVerticalStrut(80));
	        panel3.add(lbel11);
	        panel3.add(Box.createVerticalStrut(80));
	        panel3.add(lbel7);	        
	        panel4.add(lbel6);
	        panel4.add(Box.createVerticalStrut(80));
	        panel4.add(lbel10);	               
	        
	        panel5.add(textlab);
	        panel5.add(Box.createHorizontalStrut(30));
	        panel5.add(scroll);
	        panelbut.add(but5);
	        panelbut.add(Box.createVerticalStrut(80));
	        panelbut.add(but1);
	        panelbut.add(Box.createVerticalStrut(80));
	        panelbut.add(but2);
	        panelbut.add(Box.createVerticalStrut(80));
	        panelbut.add(but3);
	        panelbut.add(Box.createVerticalStrut(80));
	        panelbut.add(but4);
	        
	        
	        panel.add(panel1);
	        panel.add(Box.createHorizontalStrut(150));
	        panel.add(panel2);
	        panel.add(Box.createHorizontalStrut(150));
	        panel.add(panel3);
	        panel.add(Box.createHorizontalStrut(150));
	        panel.add(panel4);
	        panel.add(Box.createHorizontalStrut(150));
	        
	        panel1bu.add(panelbut);
	        panel1bu.add(Box.createHorizontalStrut(300));
	        panel1bu.add(panel);
	        panel1bu.add(Box.createHorizontalStrut(150));
	        panelzo.add(panel1bu);
	        panelzo.add(Box.createVerticalStrut(60));
	        panelzo.add(panel5);
	        panelzo.add(Box.createVerticalStrut(60));
	        JFrame frame = new JFrame("智能光载无线网络平台");
	        
			frame.add(panelzo);
			
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(1000,1000);
		    frame.setVisible(true);
		    po1 = lbel1.getLocationOnScreen();
	        po2 = lbel2.getLocationOnScreen();
	        po3 = lbel3.getLocationOnScreen();
	        po4 = lbel4.getLocationOnScreen();
	        po5 = lbel5.getLocationOnScreen();
	        po6 = lbel6.getLocationOnScreen();
	        po7 = lbel7.getLocationOnScreen();
	        po8 = lbel8.getLocationOnScreen();
	        po9 = lbel9.getLocationOnScreen();
	        po10 = lbel10.getLocationOnScreen();
	        po11 = lbel11.getLocationOnScreen();
	        po12 = lbel12.getLocationOnScreen();
	        
	        
	        
	       
	      
	       
	}
	
}

	

