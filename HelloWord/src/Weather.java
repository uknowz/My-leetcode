//import java.math.BigDecimal;


public class Weather {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		float fah = 86;
		System.out.println("���������¶��ǣ�" + fah);
		fah = (86 - 32)/1.8F;
		//fah = (fah - 32) / 9 * 5;
		System.out.println("ת��Ϊ�����¶��ǣ�" + fah + '\n');
		
		
		float cel = 33;
		System.out.println("���ڻ����¶��ǣ�" + cel);
		cel = cel *18/10 + 32 ;//float�����ݼ����Ƕ����ƣ����Ȳ�̫׼ȷ��ֱ��*1.8FС����ĩλ������������һ
		//����Ҫô�ȷŴ�����ͱ�����
		System.out.println("ת��Ϊ�����¶��ǣ�" + cel);
		/**
		 * 
		BigDecimal cell = new BigDecimal("33");
		BigDecimal cell2 = new BigDecimal("1.8");
		BigDecimal cell3 = new BigDecimal("cell.multiply(cell2)");
		���д������������ֵ����Ϊ���������������BigDecimal�����Ǽ򵥵���ֵ���ͣ�
		���Ǵ��ˣ�
		BigDecimal cell4 = new BigDecimal("32");
		System.out.println(cell3.add(cell4)); 
		 */
		
		
		
		
	}

}
