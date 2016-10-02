
public class ZipCode {

	/**
	 * @param args
	 */
	private int zipCode=1;
	
	public ZipCode(int zipCode){
		if((zipCode>9999)&(zipCode<100000)){
			this.zipCode = zipCode;
		}
	}
	public int getZipCode() {
		return this.zipCode;
		
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根	
		ZipCode zip1 = new ZipCode(75044);
		ZipCode zip2 = new ZipCode(320840);
		if(zip1.getZipCode() != 1)
			System.out.println(zip1.zipCode);
		if(zip2.getZipCode() !=1)
			System.out.println("zip2的变量zipCode值是：" + zip2.zipCode);
		

	}

}
