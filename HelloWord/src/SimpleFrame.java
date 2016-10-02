import javax.swing.JFrame;
import javax.swing.UIManager;

public class SimpleFrame extends JFrame {
	//到底给构造函数什么样的功能方法，我还是不会把握！！！
	//但是像这种创建一系列相同界面的类，每new一个对象就要创建一个界面，那么最好在类的构造函数里面设置方法，否则你每次
	//要创建界面的时候才想起来用方法，那么不能共享
    public SimpleFrame() {//类的构造函数就要完成几项框架显示工作
    	super("题目");//调用父辈的构造函数，括号里面的是父辈构造函数定义的参数
        //super("Frame Title");
        /*setTitle("我是天才！");
        setSize(540, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        */
    }
    
    public static void main(String[] arguments) {
        SimpleFrame sf = new SimpleFrame();//类是一系列相同框架的模型，new一个对象是创建一个框架实例
        sf.setSize(540, 100);
        sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sf.setVisible(true);        
        
    }
}
