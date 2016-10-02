package practise;

public class Chapter42 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Long translation = 0l;
		
		if(args.length > 0){
			
			
			char firstChar = args[0].charAt(0);
			char secondChar = args[0].charAt(1);
	
		switch(firstChar){
			case 'o':
				translation = 1l;
				break;
			case 't':
				switch (secondChar){
					case 'w':
						translation = 2l;
						break;
					case 'e':
						translation = 10l;
						break;
					case 'h':
						translation = 3l;
						break;
				}
				break;
			case 'f':
				if(secondChar == 'o')
					translation = 4l;
				else 
					translation = 5l;
				break;
			case 's':
				if(secondChar == 'i')
					translation = 6l;
				else
					translation = 7l;
				break;
			case 'e':
				translation = 8l;
				break;
			case 'n':
				translation = 9l;
				break;								
			}
		System.out.println("单词转换的long值:" + translation);
		}
	}
}

	


