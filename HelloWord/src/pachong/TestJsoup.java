package pachong;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TestJsoup {
    
    public  Document getDocument (String url){
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        TestJsoup t = new TestJsoup();
        Document doc = t.getDocument("http://www.weather.com.cn/html/weather/101280101.shtml");
        // ��ȡĿ��HTML����
        Elements elements1 = doc.select("[class=sky skyid lv3 on]");
        // ����
        Elements elements2 = elements1.select("h1");
        String today = elements2.text();
        System.out.println(today);
        // ����
        Elements elements3 = elements1.select("h2");
        String number = elements3.text();
        System.out.println(number);
        // �Ƿ�����
        Elements elements4 = elements1.select("[class=wea]");
        String rain = elements4.text();
        System.out.println(rain);
        // �ߵ��¶�
        Elements elements5 = elements1.select("span");
        String highTemperature = elements5.text();
        System.out.println(highTemperature);
        // �͵��¶�
        String lowTemperature = elements5.text();
        System.out.println(lowTemperature);
        // ����
        Elements elements6 = elements1.select("i");
        String wind = elements6.text();
        System.out.println(wind);
    }
}