
public class RangeLister {

	/**
	 * @param args
	 */
	int[] makeRange(int lower, int upper) {
        int[] range = new int[(upper-lower) + 1];

        for (int i = 0; i <range.length; i++) {
            range[i] = lower++;
        }
        return range;//�������鲻�ü�[]
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		 int[] range;
	        RangeLister lister = new RangeLister();

	        range = lister.makeRange(4, 13);//����������鸳ֵ�Ͳ���ָ������
	        System.out.print("The array: [ ");
	        for (int i = 0; i < range.length; i++) {
	            System.out.print(range[i] + " ");
	        }//��ʾ�����Ԫ�ص�ֵ
	        System.out.println("]");
	       // float a = 2.3f/2;

	}

}
