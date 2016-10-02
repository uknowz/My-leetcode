package mycode;

public class CompareTest{

	/**
	 * @param args
	 */
	int a ;
	public CompareTest(int value){
		a = value;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		CompareTest test = new CompareTest(5);
		int i;
		for(i=0;i<2;i++){
			if(i !=0){
				System.out.print(i);
			}
			else{
				break;
			}
		}
		System.out.println(i);
		
			

	}
	
	
	

}
