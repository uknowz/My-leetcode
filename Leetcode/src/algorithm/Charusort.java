package algorithm;
//插入排序的简单算法
public class Charusort {
	public Charusort(int[] a){
		
	}

    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //直接插入排序
        for (int i = 1; i < a.length; i++) {
            //待插入元素
            int temp = a[i];
            int j;
            
            for (j = i-1; j>=0; j--) {
                //将大于temp的往后移动一位
                if(a[j]>temp){ //必须用temp变量将要插入的元素装起来，否则后面向后移动的时候，就把当前要插入的元素给覆盖掉了
                    a[j+1] = a[j];
                }else{
                    break;//不执行下次循环的话，j是不会--的，直接跳出循环时j的值不会减一
                }
            }
            a[j+1] = temp;//为什么不是赋给a[j]？？？？？因为当a[j]<=temp的时候，是在它的后面插入temp的，而不是因为j减一的原因
            //因为j没有减一
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

}