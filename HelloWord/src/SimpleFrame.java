import javax.swing.JFrame;
import javax.swing.UIManager;

public class SimpleFrame extends JFrame {
	//���׸����캯��ʲô���Ĺ��ܷ������һ��ǲ�����գ�����
	//���������ִ���һϵ����ͬ������࣬ÿnewһ�������Ҫ����һ�����棬��ô�������Ĺ��캯���������÷�����������ÿ��
	//Ҫ���������ʱ����������÷�������ô���ܹ���
    public SimpleFrame() {//��Ĺ��캯����Ҫ��ɼ�������ʾ����
    	super("��Ŀ");//���ø����Ĺ��캯��������������Ǹ������캯������Ĳ���
        //super("Frame Title");
        /*setTitle("������ţ�");
        setSize(540, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        */
    }
    
    public static void main(String[] arguments) {
        SimpleFrame sf = new SimpleFrame();//����һϵ����ͬ��ܵ�ģ�ͣ�newһ�������Ǵ���һ�����ʵ��
        sf.setSize(540, 100);
        sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sf.setVisible(true);        
        
    }
}
