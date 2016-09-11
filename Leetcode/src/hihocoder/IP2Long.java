package hihocoder;
//这个类是将十进制ip地址转换问二进制。其中ipv4每个点8位，共32位，这个输出位数不对，看IP2Int.java
public class IP2Long {
    // 将127.0.0.1 形式的IP地址转换成10进制整数，这里没有进行任何错误处理
    public static long ipToLong(String strIP) {
        long[] ip = new long[4];
        // 先找到IP地址字符串中.的位置，
        int position1 = strIP.indexOf(".");
        int position2 = strIP.indexOf(".", position1 + 1);
        int position3 = strIP.indexOf(".", position2 + 1);
        // 将每个.之间的字符串转换成整型
        ip[0] = Long.parseLong(strIP.substring(0, position1));
        ip[1] = Long.parseLong(strIP.substring(position1 + 1, position2));
        ip[2] = Long.parseLong(strIP.substring(position2 + 1, position3));
        ip[3] = Long.parseLong(strIP.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }
 
    // 将10进制整数形式转换成127.0.0.1形式的IP地址
    public static String longToIP(long longIP) {
        StringBuffer sb = new StringBuffer("");
        // 直接右移24位
        sb.append(String.valueOf(longIP >>> 24));
        sb.append(".");
        // 将高8位置0，然后右移16位
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
        System.out.println("1的八位二进制：" + Long.toBinaryString(1));//是这个转换二进制的函数有问题，没有把握位数，ip地址转换，需要每一段整数转换为二进制都要有八位数
 
        // IP地址转化成二进制形式输出
        System.out.println("二进制形式为: "
                + Long.toBinaryString(IP2Long.ipToLong(ipStr))+" " +Long.toBinaryString(IP2Long.ipToLong(ipStr)).length());
    }
}


//这个类是将十进制ip地址转换问二进制。其中ipv4每个点8位，共32位
//自己重新写了一个方法，这个比IP2Long输出的位数正确
class IP2Int {
  // 将127.0.0.1 形式的IP地址转换成10进制整数，这里没有进行任何错误处理
	
	public static String ipToint(String strIP) {
      String[] ip = new String[4];
      String zero = "00000000";//用来补位的
      String[] ipstr = strIP.split("\\.");
      // 将每个.之间的字符串转换成整型
      ip[0] = Integer.toBinaryString(Integer.parseInt(ipstr[0]));
      ip[1] = Integer.toBinaryString(Integer.parseInt(ipstr[1]));
      ip[2] = Integer.toBinaryString(Integer.parseInt(ipstr[2]));
      ip[3] = Integer.toBinaryString(Integer.parseInt(ipstr[3]));
      for(int i=0;i<4;i++){
      	if(ip[i].length()<8){
      		ip[i] =zero.substring(0,8-ip[i].length()) + ip[i];//如果每一段ip不足八位，那么用字符串加法高位补0,不用循环，一次性补0，因为ip.length()一直会变  
      	}
      }
      return ip[0]+ip[1]+ip[2]+ip[3];
  }

  // 将10进制整数形式转换成127.0.0.1形式的IP地址
  public static String longToIP(long longIP) {
      StringBuffer sb = new StringBuffer("");
      // 直接右移24位
      sb.append(String.valueOf(longIP >>> 24));
      sb.append(".");
      // 将高8位置0，然后右移16位
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
      // IP地址转化成二进制形式输出
      System.out.println("二进制形式为: "+ ipout+" 位数为： " +ipout.length());
  }
 
}