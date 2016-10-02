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
	 * @param args，param是对参数的解释
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
			
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(),"uft-8");//输出流到网页上的格式
			BufferedWriter wri = new BufferedWriter(out);
			wri.write(str);
			wri.close();
			
			BufferedReader webinput = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			//Outputw out = new 
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println(e.getMessage());
		}
	}*/
	/**
	 * 该方法给页面传递在线播放视频地址参数
	 * @param flcvd_url 在线视频播放地址
	 * @throws IOException
	 */
	public void flcvd_connect2()throws IOException{
		Document doc;
		String flcvd_url = "http://www.flvcd.com/parse.php?";
		try{
			Connection connect = Jsoup.connect(flcvd_url);
			doc = connect.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) " +
                		"AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
                		timeout(10000).data("query", "Java").post();//post()方法并不是传递参数，而是访问url的不同方法，就如get()一样
			//设置页面参数
			doc.select("input[type=text]").attr("value","http://v.youku.com/v_show/id_XMTI3NDI3MDUzMg==.html?" +
					"from=y1.2-2.4.25");//先用黑子的篮球3最后一话播放地址为例，看能不能解析出下载地址
			
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		FlcvdCanshu flcvd = new FlcvdCanshu();
		//方法有抛出异常，调用的时候要用try块包围
		try {
			flcvd.flcvd_connect2();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		

	}

}
