package practise;

public class Chapter32 {

	/**
	 * @param args
	 */
	int height,weight,depth;//ʵ�����������캯�������󸳳�ֵ������ʵ������������
	 public Chapter32(int a, int b, int c) {
		 
		// TODO �Զ����ɵĹ��캯�����
		 height = a;
		 weight = b;
		 depth = c;
		
	}
		
	

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Chapter32 zmf = new Chapter32(160,92,3);
		/*zmf.weight = 92;
		zmf.depth=3;
		zmf.height = 160;
		*/
		System.out.println("height:" + zmf.height);
		System.out.println("weight:" + zmf.weight);
		System.out.println("depth:" + zmf.depth);
		
		
		

	}

}
