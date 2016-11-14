/**
 * 
 */
package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingfang.z
 * �ж������ַ����Ƿ�Ϊ��ת��
 * 2016-11-9
 */
public class Rotation {
	public static void main(String[] args){
		System.out.println(new Rotation().chkRotation("12345", 5, "23451", 5));
	}
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if(lena!=lenb) return false;
        String str = new String(A+A);
        boolean result = kmp(str,lena+lena,B,lenb);
        return result;
        
    }
    //kmp�㷨�����ַ���a�Ƿ�����ַ���b
    public boolean kmp(String a,int lena,String b,int lenb){
        int i = 0;//a����
        int j = 0;//b����
        while(i<lena){
            if(a.charAt(i)==b.charAt(j)){
                if(j==lenb-1) 
                	return true;
                else{
                   i++;j++; 
                }
                
            }else{
                if(j==0){
                    i++;//ֱ�������ʺ���
                    j=0;
                }else{
                    int match = partMatch(b.substring(j));
                    i = i-match;
                    j = 0;//b��������ͷ�ַ�
                }
            }
        }
        return false;
    }
    //ǰ׺�ͺ�׺�����Ԫ�صĳ���
    public int partMatch(String str){
        int n = str.length();
        List<String> li1 = new ArrayList<>(n-1);
        List<String> li2 = new ArrayList<>(n-1);
        for(int i=0;i<n-1;i++){
            li1.add(str.substring(0,i+1));
        }
        for(int j=n-2;j>0;j--){
            li2.add(str.substring(j));
        }
        int max = 0;
        for(String s:li1){
            if(li2.contains(s))
                max = Math.max(max,s.length());
        }
        return max;
    }
}
