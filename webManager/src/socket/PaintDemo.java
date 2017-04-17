package socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintDemo extends ShowImage {
	//������
	
	//�滭���
	 
	//���嵱ǰ������
	 int x, y;

	public PaintDemo () {
		//���� MouseAdapter
		MouseAdapter ma = new MouseAdapter() {
			//��ӵ���¼�
			@Override
			public void mousePressed (MouseEvent me) {
				//��갴�£���ѵ�ǰ�������趨Ϊ���λ��
				x = me.getX();
				y = me.getY();
				//���ߣ��ӵ� (x,y) ���� (x,y)
				panelzo.getGraphics().drawLine(x, y, x, y);
			}
			//�����ק�¼�
			@Override
			public void mouseDragged (MouseEvent me) {
				//���ߣ��ӵ� (x,y) ����굱ǰλ��
				panelzo.getGraphics().drawLine(x, y, me.getX(), me.getY());
				//���µ�ǰ�㣬����Ϊ���λ��
				x = me.getX();
				y = me.getY();
			}
		};

		//��ʼ���滭���
		//pnlPaint.setBackground(Color.WHITE);
		panelzo.addMouseListener(ma);
		panelzo.addMouseMotionListener(ma);
		
		/*
		//��ʼ��������
		frmPaint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaint.setSize(800, 600);
		frmPaint.setLocationRelativeTo(null);
		frmPaint.setContentPane(pnlPaint);
		frmPaint.setVisible(true);
		*/
	}
	

	
}