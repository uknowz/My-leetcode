
public class HalfDollars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 //int[] denver = { 2500000, 2900000, 3500000  };
		int [] denver = new int [3];
		denver[0] = 2500000;
		denver[1] = 2900000;
		denver[2] = 3500000;
	
	        int[] philadelphia = new int[denver.length];	 
	        int[] total = new int[denver.length];
	        int average;

	        philadelphia[0] = 2500000;
	        philadelphia[1] = 2900000;
	        philadelphia[2] = 3800000;

	        total[0] = denver[0] + philadelphia[0];
	        total[1] = denver[1] + philadelphia[1];
	        total[2] = denver[2] + philadelphia[2];
	        average = (total[0] + total[1] + total[2]) / 3;//平均值为int型，舍弃了小数

	        System.out.print("2003 production: ");
	        System.out.format("%,d%n", total[0]);
	        System.out.print("2004 production: ");
	        System.out.format("%,d%n", total[1]);
	        System.out.print("2005 production: ");
	        System.out.format("%,d%n", total[2]);
	        System.out.print("Average production: ");
	        System.out.format("%,d%n", average);

	}

}
