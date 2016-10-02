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
            	//����get�ķ���������������Ϊ���ʣ���ֹ������
                doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) " +
                		"AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
                		.timeout(10000).get();  //����Ӹ�url����html�������󣬾ͻ��׳�IOException�쳣
                  
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
                        System.out.println(link.attr("abs:href")+" ӰƬ��Ŀ��"+link.ownText());  
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