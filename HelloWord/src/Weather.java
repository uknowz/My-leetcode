//import java.math.BigDecimal;


public class Weather {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		float fah = 86;
		System.out.println("现在摄氏温度是：" + fah);
		fah = (86 - 32)/1.8F;
		//fah = (fah - 32) / 9 * 5;
		System.out.println("转换为华氏温度是：" + fah + '\n');
		
		
		float cel = 33;
		System.out.println("现在华氏温度是：" + cel);
		cel = cel *18/10 + 32 ;//float型数据计算是二进制，精度不太准确，直接*1.8F小数点末位可能舍弃，减一
		//所以要么先放大除数和被除数
		System.out.println("转换为摄氏温度是：" + cel);
		/**
		 * 
		BigDecimal cell = new BigDecimal("33");
		BigDecimal cell2 = new BigDecimal("1.8");
		BigDecimal cell3 = new BigDecimal("cell.multiply(cell2)");
		上行代码是想给对象赋值，因为计算出来的类型是BigDecimal，不是简单的数值类型，
		但是错了，
		BigDecimal cell4 = new BigDecimal("32");
		System.out.println(cell3.add(cell4)); 
		 */
		
		
		
		
	}

}
