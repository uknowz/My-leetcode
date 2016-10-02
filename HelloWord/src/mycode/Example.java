package mycode;
//验证跳出循环后，j不会减一，只有开始下一循环，才会减一
public class Example{
	public static void main(String args[]){
		/*
		int j,i;
		for(j=3; j>1; j--){
			i = 48;
			System.out.println(i);
			if(j!=2){
				i = 49;
				System.out.println(i);
			}
			else
			break;
		}
		
		System.out.println(j);
		*/
		char[] a = { 'a','b','5','f','J'};
		for(int i=0; i<a.length;i++){
			if(a[i]=='5'){
				System.out.println("this is 5!");
			}
			if(a[i]=='J'){
					System.out.println("this is J!");
			}else{
				System.out.println("other words.");
			}
		}
	}
	
}