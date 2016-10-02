    package pachong;  
    //这是爬优酷电影频道里，选择show page中的某一电影后，可以在线播放的正片url地址  
    //这里只有一部电影的爬取，多部电影可以考虑把影片地址放到map中
    import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;  
import java.io.PrintWriter;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;  
      
    public class YoukuMovie2 {  
      
        /** 
         * @param args 
         */  
    	public void pashipinTools(String inurl){
    		String url= inurl;  
          
              
            //HashMap list=new HashMap();  
              
            Document doc;//这个实例建立不是new，而是与url connect
            try { 
            	//这种get的方法，可以制造认为访问，防止反爬虫
                doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) " +
                		"AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
                		.timeout(10000).get();  //如果从该url解析html发生错误，就会抛出IOException异常
                  
                Elements links1 = doc.select("[class=btnShow btnplayposi]"); //取正片播放地址（根据html页面元素）
                Element link2 = links1.select("a[href]").first();//a[href]表示指向的超链接，只取正片一个链接就行，只考虑电影，不考虑电视剧专辑
                String v_url = link2.attr("abs:href");//abs取绝对地址url
                Element title = doc.select("span[class=name]").first();//取电影片名
                String title2 = title.ownText();
                //是否url匹配
                if(v_url.startsWith("http://v.youku.com/v_show") && !(title2.isEmpty())){
                	  System.out.println(v_url + " Movies name: 正片-" + title2);
                }  
                //把视频url写到txt文件内
                FileWriter o_url = new FileWriter("C:\\Users\\Administrator\\Desktop\\downloadlist.txt");
                PrintWriter print = new PrintWriter(new BufferedWriter(o_url));
                print.println(v_url);
                print.close();
                
                } catch (IOException e) {  
                e.printStackTrace();  
            }  
    	}
        public static void main(String[] args) {                 
      
              YoukuMovie2 example = new YoukuMovie2();
              example.pashipinTools("http://www.youku.com/show_page/id_zf988399c0e7611e5abda.html?from=y1.12-96");
              
      
        }  
        
      
    }
    /*助手类，用第三方软件flcvd，自动下载视频
     * 初步思想：java客户端给服务端传参数，然后获取跳转后页面的下载地址，
     * java web是一个难点
     */
     class Flcvd{
    	
    }
    