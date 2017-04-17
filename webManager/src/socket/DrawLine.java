package socket;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawLine extends ShowImage{

	DrawLine()
	{
		super();
	}
public void paint(Graphics g) {
	super.paint(g);
	new ShowImage();
	Graphics2D g2d = (Graphics2D)g;
    g2d.setColor(Color.BLUE);
    g2d.setStroke(new BasicStroke(2f));
    g2d.drawLine(po1.x, po1.y, po3.x, po3.y);
    g2d.drawLine(po3.x, po3.y, po2.x, po2.y);
    g2d.drawLine(po3.x, po3.y, po12.x, po12.y);
    g2d.drawLine(po4.x, po4.y, po2.x, po2.y);
    g2d.drawLine(po8.x, po8.y, po12.x, po12.y);
    g2d.drawLine(po2.x, po2.y, po9.x, po9.y);
    g2d.drawLine(po11.x, po11.y, po12.x, po12.y);
    g2d.drawLine(po5.x, po5.y, po9.x, po9.y);
    g2d.drawLine(po7.x, po7.y, po11.x, po11.y);
    g2d.drawLine(po10.x, po10.y, po9.x, po9.y);
    g2d.drawLine(po10.x, po10.y, po11.x, po11.y);
    g2d.drawLine(po6.x, po6.y, po10.x, po10.y);
    
	}
	/*
	public static void main(String[] args)
	{
		new DrawLine();
	}
	*/
}
