package practise;

public class NegativeNumberException extends Exception {
	public NegativeNumberException(){
		
	}
	public NegativeNumberException(String mrg){
		super(mrg);
	}
	//public NegativeNumberException er = new NegativeNumberException("异常：构造函数参数传递了负值");
	//throw er;
}
