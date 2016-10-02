
public class DayCounter {

	/**
	 * @param args
	 */
	public static void main(String[] arguments) {
		// TODO 自动生成的方法存根
		int yearIn = 2008;
        int monthIn = 2;
        if (arguments.length > 0)
            monthIn = Integer.parseInt(arguments[0]);//这个类方法是用来返回String对象的int值，参数是String对象
        if (arguments.length > 1)
            yearIn = Integer.parseInt(arguments[1]);
        System.out.println(monthIn + "/" + yearIn + " has "
            + countDays(monthIn, yearIn) + " days.");//调用方法用实参传递用变量是为了方便以后修改，不用全部改调用过的方法，只要变量就行了
    }

   static int countDays(int month, int year) {//用静态方法是整个类都是用来干一件事，没有对象，就没有实例方法
        int count = -1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9: 
            case 11:
                count = 30;
                break;
            case 2:
                if (((year % 4 == 0)&(year % 100 != 0)) | (year % 400 == 0))
                    count = 29;
                else
                    count = 28;
                //if ((year % 100 == 0) & (year % 400 != 0))
                    //count = 28;
        }
        return count;

	}

}
