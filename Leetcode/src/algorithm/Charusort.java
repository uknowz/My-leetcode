package algorithm;
//��������ļ��㷨
public class Charusort {
	public Charusort(int[] a){
		
	}

    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("����֮ǰ��");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //ֱ�Ӳ�������
        for (int i = 1; i < a.length; i++) {
            //������Ԫ��
            int temp = a[i];
            int j;
            
            for (j = i-1; j>=0; j--) {
                //������temp�������ƶ�һλ
                if(a[j]>temp){ //������temp������Ҫ�����Ԫ��װ�����������������ƶ���ʱ�򣬾Ͱѵ�ǰҪ�����Ԫ�ظ����ǵ���
                    a[j+1] = a[j];
                }else{
                    break;//��ִ���´�ѭ���Ļ���j�ǲ���--�ģ�ֱ������ѭ��ʱj��ֵ�����һ
                }
            }
            a[j+1] = temp;//Ϊʲô���Ǹ���a[j]������������Ϊ��a[j]<=temp��ʱ���������ĺ������temp�ģ���������Ϊj��һ��ԭ��
            //��Ϊjû�м�һ
        }
        System.out.println();
        System.out.println("����֮��");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

}