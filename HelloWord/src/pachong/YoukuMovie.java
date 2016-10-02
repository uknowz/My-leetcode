    package pachong;  
      
    import java.io.IOException;  
import java.util.HashMap;  
      
    import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;  
      
    public class YoukuMovie {  
      
        /** 
         * @param args 
         */  
    	public void pashipinTools(String inurl){
    		String url= inurl;  
          
              
            HashMap<String, String> list=new HashMap<String, String>();  
              
            Document doc;  
            try { 
            	//这种get的方法，可以制造认为访问，防止反爬虫
                doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) " +
                		"AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
                		.timeout(10000).get();  //如果从该url解析html发生错误，就会抛出IOException异常
                  
                Elements links = doc.select("a[href]"); //jsoup选择器 ，a[href]表示指向的超链接
                  
                int s=0; // 计算获取了多少个视频地址href的值
                  
                for (Element link : links) {  //for (循环变量类型 循环变量名称 : 要被遍历的对象) 循环体
      
                    String v_url=link.attr("abs:href");  //获取绝对路径href
                      
                    if  (link.ownText().length()==0)  
                    {  
                        continue;  
                    }  
      
                    if (list.containsKey(v_url))  
                    {  
                        continue;  
                    }  
                      
                    if (v_url.startsWith("http://v.youku.com/v_show"))  
                    {  
                        System.out.println(link.attr("abs:href")+" 影片题目："+link.ownText());  
                        list.put(v_url, v_url);  
                        s++;  
                    }  
      
                }  
                System.out.println("total:"+ s);  
                  
                  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
    	}
        public static void main(String[] args) {                 
      
              YoukuMovie example = new YoukuMovie();
              example.pashipinTools("http://www.youku.com/show_page/id_z364c9f96fed011e4b432.html?from=y1.12-96");
              
      
        }  
        
      
    }  