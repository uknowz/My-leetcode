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
                doc = Jsoup.connect(url).get();  //����Ӹ�url����html�������󣬾ͻ��׳�IOException�쳣
                  
                Elements links = doc.select("a[href]"); //jsoupѡ���� ��a[href]��ʾָ��ĳ�����
                  
                int s=0; // �����ȡ�˶��ٸ���Ƶ��ַhref��ֵ
                  
                for (Element link : links) {  //for (ѭ���������� ѭ���������� : Ҫ�������Ķ���) ѭ����
      
                    String v_url=link.attr("abs:href");  //��ȡ����·��href
                      
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