package practise;

public class Chapter4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int yearln = 2008;
		if(args.length>0)
			yearln = Integer.parseInt(args[0]);//���ڻ�û��ѧ��ô����ֵ��ֻ���������в�������ֵ
		System.out.println(yearln + "���ÿһ��");
		Chapter4.displayDays(yearln);
	}
			
		// TODO �Զ����ɵķ������
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
		            		System.out.println(i + "��" + y + "��");
		            		
		            	}
		            	System.out.println("\n");
		            	break;
		            case 4:
		            case 6:
		            case 9: 
		            case 11:
		            	for (int y=1; y<=30; y++){
		            		System.out.println(i + "��" + y + "��");
		            		
		            	}
		            	System.out.println("\n");
		            	break;
		            case 2:
		            	if(((year % 4 == 0)&(year % 100 != 0)) | (year % 400 == 0)){
		            		for (int y = 1; y<=29; y++)
		            			System.out.println(i + "��" + y + "��");
		            	}
		            	else{
		            		for (int y = 1; y<=28; y++)
		            			System.out.println(i + "��" + y + "��");
		            		
		            	}
		            	
		            	System.out.println("\n");
		            	break;
		            		
	        	
	        	}
	        	
	        }
	        

		}
	}

	
	

	
		


