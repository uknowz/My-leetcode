package socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintDemo extends ShowImage {
	//主窗口
	
	//绘画面板
	 
	//定义当前点坐标
	 int x, y;

	public PaintDemo () {
		//创建 MouseAdapter
		MouseAdapter ma = new MouseAdapter() {
			//添加点击事件
			@Override
			public void mousePressed (MouseEvent me) {
				//鼠标按下，则把当前点坐标设定为鼠标位置
				x = me.getX();
				y = me.getY();
				//画线，从点 (x,y) 到点 (x,y)
				panelzo.getGraphics().drawLine(x, y, x, y);
			}
			//添加拖拽事件
			@Override
			public void mouseDragged (MouseEvent me) {
				//画线，从点 (x,y) 到鼠标当前位置
				panelzo.getGraphics().drawLine(x, y, me.getX(), me.getY());
				//更新当前点，这是为鼠标位置
				x = me.getX();
				y = me.getY();
			}
		};

		//初始化绘画面板
		//pnlPaint.setBackground(Color.WHITE);
		panelzo.addMouseListener(ma);
		panelzo.addMouseMotionListener(ma);
		
		/*
		//初始化主窗口
		frmPaint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaint.setSize(800, 600);
		frmPaint.setLocationRelativeTo(null);
		frmPaint.setContentPane(pnlPaint);
		frmPaint.setVisible(true);
		*/
	}
	

	
}