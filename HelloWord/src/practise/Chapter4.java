package practise;

public class Chapter4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int yearln = 2008;
		if(args.length>0)
			yearln = Integer.parseInt(args[0]);//现在还没有学怎么外界给值，只能用命令行参数来给值
		System.out.println(yearln + "年的每一天");
		Chapter4.displayDays(yearln);
	}
			
		// TODO 自动生成的方法存根
		public static void displayDays (int year) {
	        for(int i = 1;i<=12;i++){
	        	switch (i){
	        		case 1:
	        		case 3:
	        		case 5:
		            case 7:
		            case 8:
		            case 10:
		            case 12:
		            	for (int y=1; y<=31; y++){
		            		System.out.println(i + "月" + y + "日");
		            		
		            	}
		            	System.out.println("\n");
		            	break;
		            case 4:
		            case 6:
		            case 9: 
		            case 11:
		            	for (int y=1; y<=30; y++){
		            		System.out.println(i + "月" + y + "日");
		            		
		            	}
		            	System.out.println("\n");
		            	break;
		            case 2:
		            	if(((year % 4 == 0)&(year % 100 != 0)) | (year % 400 == 0)){
		            		for (int y = 1; y<=29; y++)
		            			System.out.println(i + "月" + y + "日");
		            	}
		            	else{
		            		for (int y = 1; y<=28; y++)
		            			System.out.println(i + "月" + y + "日");
		            		
		            	}
		            	
		            	System.out.println("\n");
		            	break;
		            		
	        	
	        	}
	        	
	        }
	        

		}
	}

	
	

	
		


