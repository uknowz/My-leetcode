    package pachong;  
    //�������ſ��ӰƵ���ѡ��show page�е�ĳһ��Ӱ�󣬿������߲��ŵ���Ƭurl��ַ  
    //����ֻ��һ����Ӱ����ȡ���ಿ��Ӱ���Կ��ǰ�ӰƬ��ַ�ŵ�map��
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
              
            Document doc;//���ʵ����������new��������url connect
            try { 
            	//����get�ķ���������������Ϊ���ʣ���ֹ������
                doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) " +
                		"AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
                		.timeout(10000).get();  //����Ӹ�url����html�������󣬾ͻ��׳�IOException�쳣
                  
                Elements links1 = doc.select("[class=btnShow btnplayposi]"); //ȡ��Ƭ���ŵ�ַ������htmlҳ��Ԫ�أ�
                Element link2 = links1.select("a[href]").first();//a[href]��ʾָ��ĳ����ӣ�ֻȡ��Ƭһ�����Ӿ��У�ֻ���ǵ�Ӱ�������ǵ��Ӿ�ר��
                String v_url = link2.attr("abs:href");//absȡ���Ե�ַurl
                Element title = doc.select("span[class=name]").first();//ȡ��ӰƬ��
                String title2 = title.ownText();
                //�Ƿ�urlƥ��
                if(v_url.startsWith("http://v.youku.com/v_show") && !(title2.isEmpty())){
                	  System.out.println(v_url + " Movies name: ��Ƭ-" + title2);
                }  
                //����Ƶurlд��txt�ļ���
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
    /*�����࣬�õ��������flcvd���Զ�������Ƶ
     * ����˼�룺java�ͻ��˸�����˴�������Ȼ���ȡ��ת��ҳ������ص�ַ��
     * java web��һ���ѵ�
     */
     class Flcvd{
    	
    }
    