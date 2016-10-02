    package pachong;  
      
    import java.io.IOException;  
    import java.util.HashMap;  
      
    import org.jsoup.Jsoup;  
    import org.jsoup.nodes.Document;  
    import org.jsoup.nodes.Element;  
    import org.jsoup.select.Elements;  
      
    public class Youku2 {  
      
        /** 
         * @param args 
         */  
    	public void pashipinTools(String inurl){
    		String url= inurl;  
          
              
            HashMap list=new HashMap();  
              
            Document doc;  
            try {  
                doc = Jsoup.connect(url).get();  //如果从该url解析html发生错误，就会抛出IOException异常
                  
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
                        System.out.println(link.attr("abs:href")+"-"+link.ownText());  
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
      
              Youku2 example = new Youku2();
              example.pashipinTools("http://www.youku.com");
              
      
        }  
        
      
    }  