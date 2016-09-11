package hihocoder;
//������ǽ�ʮ����ip��ַת���ʶ����ơ�����ipv4ÿ����8λ����32λ��������λ�����ԣ���IP2Int.java
public class IP2Long {
    // ��127.0.0.1 ��ʽ��IP��ַת����10��������������û�н����κδ�����
    public static long ipToLong(String strIP) {
        long[] ip = new long[4];
        // ���ҵ�IP��ַ�ַ�����.��λ�ã�
        int position1 = strIP.indexOf(".");
        int position2 = strIP.indexOf(".", position1 + 1);
        int position3 = strIP.indexOf(".", position2 + 1);
        // ��ÿ��.֮����ַ���ת��������
        ip[0] = Long.parseLong(strIP.substring(0, position1));
        ip[1] = Long.parseLong(strIP.substring(position1 + 1, position2));
        ip[2] = Long.parseLong(strIP.substring(position2 + 1, position3));
        ip[3] = Long.parseLong(strIP.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }
 
    // ��10����������ʽת����127.0.0.1��ʽ��IP��ַ
    public static String longToIP(long longIP) {
        StringBuffer sb = new StringBuffer("");
        // ֱ������24λ
        sb.append(String.valueOf(longIP >>> 24));
        sb.append(".");
        // ����8λ��0��Ȼ������16λ
        sb.append(String.valueOf((longIP & 0x00FFFFFF) >>> 16));
        sb.append(".");
        sb.append(String.valueOf((longIP & 0x0000FFFF) >>> 8));
        sb.append(".");
        sb.append(String.valueOf(longIP & 0x000000FF));
        return sb.toString();
    }
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        String ipStr = "1.1.1.1";
        long ipLong = IP2Long.ipToLong(ipStr);
        System.out.println(ipLong);
        System.out.println("1�İ�λ�����ƣ�" + Long.toBinaryString(1));//�����ת�������Ƶĺ��������⣬û�а���λ����ip��ַת������Ҫÿһ������ת��Ϊ�����ƶ�Ҫ�а�λ��
 
        // IP��ַת���ɶ�������ʽ���
        System.out.println("��������ʽΪ: "
                + Long.toBinaryString(IP2Long.ipToLong(ipStr))+" " +Long.toBinaryString(IP2Long.ipToLong(ipStr)).length());
    }
}


//������ǽ�ʮ����ip��ַת���ʶ����ơ�����ipv4ÿ����8λ����32λ
//�Լ�����д��һ�������������IP2Long�����λ����ȷ
class IP2Int {
  // ��127.0.0.1 ��ʽ��IP��ַת����10��������������û�н����κδ�����
	
	public static String ipToint(String strIP) {
      String[] ip = new String[4];
      String zero = "00000000";//������λ��
      String[] ipstr = strIP.split("\\.");
      // ��ÿ��.֮����ַ���ת��������
      ip[0] = Integer.toBinaryString(Integer.parseInt(ipstr[0]));
      ip[1] = Integer.toBinaryString(Integer.parseInt(ipstr[1]));
      ip[2] = Integer.toBinaryString(Integer.parseInt(ipstr[2]));
      ip[3] = Integer.toBinaryString(Integer.parseInt(ipstr[3]));
      for(int i=0;i<4;i++){
      	if(ip[i].length()<8){
      		ip[i] =zero.substring(0,8-ip[i].length()) + ip[i];//���ÿһ��ip�����λ����ô���ַ����ӷ���λ��0,����ѭ����һ���Բ�0����Ϊip.length()һֱ���  
      	}
      }
      return ip[0]+ip[1]+ip[2]+ip[3];
  }

  // ��10����������ʽת����127.0.0.1��ʽ��IP��ַ
  public static String longToIP(long longIP) {
      StringBuffer sb = new StringBuffer("");
      // ֱ������24λ
      sb.append(String.valueOf(longIP >>> 24));
      sb.append(".");
      // ����8λ��0��Ȼ������16λ
      sb.append(String.valueOf((longIP & 0x00FFFFFF) >>> 16));
      sb.append(".");
      sb.append(String.valueOf((longIP & 0x0000FFFF) >>> 8));
      sb.append(".");
      sb.append(String.valueOf(longIP & 0x000000FF));
      return sb.toString();
  }
	
  public static void main(String[] args) {
      String ipStr = "123.234.12.23";
     String ipout = IP2Int.ipToint(ipStr);
      // IP��ַת���ɶ�������ʽ���
      System.out.println("��������ʽΪ: "+ ipout+" λ��Ϊ�� " +ipout.length());
  }
 
}