package pachong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;  

public class FlcvdCanshu {

	/**
	 * @param args��param�ǶԲ����Ľ���
	 */
	/*
	public void flvcd_connect1()throws MalformedURLException{
		StringBuffer str2 = new StringBuffer();
		try {
			URL flcvd = new URL("http://www.flvcd.com/parse.php?");
			HttpURLConnection conn = (HttpURLConnection)flcvd.openConnection();
			conn.connect();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("User-Agent",
					    "Mozilla/5.0 (Windows NT 6.1; WOW64) " +
					    "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36");
			FileReader downloadlist = new FileReader("C://User//Administrator//Desktop//downloadlist.txt");
			BufferedReader input = new BufferedReader(downloadlist);
			String str1 = new String();
			do{
				
				str1 = input.readLine();
				if(str1 != null){
					str2.append(str1 + "\n");
				}
			}while(str1 != null);
			String str = str2.toString();
			input.close();
			
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(),"uft-8");//���������ҳ�ϵĸ�ʽ
			BufferedWriter wri = new BufferedWriter(out);
			wri.write(str);
			wri.close();
			
			BufferedReader webinput = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			//Outputw out = new 
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println(e.getMessage());
		}
	}*/
	/**
	 * �÷�����ҳ�洫�����߲�����Ƶ��ַ����
	 * @param flcvd_url ������Ƶ���ŵ�ַ
	 * @throws IOException
	 */
	public void flcvd_connect2()throws IOException{
		Document doc;
		String flcvd_url = "http://www.flvcd.com/parse.php?";
		try{
			Connection connect = Jsoup.connect(flcvd_url);
			doc = connect.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) " +
                		"AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
                		timeout(10000).data("query", "Java").post();//post()���������Ǵ��ݲ��������Ƿ���url�Ĳ�ͬ����������get()һ��
			//����ҳ�����
			doc.select("input[type=text]").attr("value","http://v.youku.com/v_show/id_XMTI3NDI3MDUzMg==.html?" +
					"from=y1.2-2.4.25");//���ú��ӵ�����3���һ�����ŵ�ַΪ�������ܲ��ܽ��������ص�ַ
			
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		FlcvdCanshu flcvd = new FlcvdCanshu();
		//�������׳��쳣�����õ�ʱ��Ҫ��try���Χ
		try {
			flcvd.flcvd_connect2();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		

	}

}
