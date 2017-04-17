package socket;

import java.io.File; 
import java.io.FileInputStream;
import java.io.IOException; 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import org.w3c.dom.Document; 
import org.w3c.dom.Node; 
import org.w3c.dom.NodeList; 
import org.xml.sax.SAXException; 
//这是网上解析xml文件的简单例子
 public class XmlDom { 
   DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance(); 
   //Load and parse XML file into DOM 
   public Document parse(String filePath) { 
      Document document = null; 
      try { 
         //DOM parser instance 
         DocumentBuilder builder = builderFactory.newDocumentBuilder(); 
         //parse an XML file into a DOM tree 
         document = builder.parse(new FileInputStream(filePath)); 
      } catch (ParserConfigurationException e) { 
         e.printStackTrace();  
      } catch (SAXException e) { 
         e.printStackTrace(); 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } 
      return document; 
   } 
	
   public static void main(String[] args) { 
         XmlDom parser = new XmlDom(); 
         String pathName = "F:\\socketXml\\test.xml";
         Document document = parser.parse(pathName); 
         //get root element 
         //Element rootElement = document.getDocumentElement(); 
         NodeList nodes = document.getElementsByTagName("headNode");
         System.out.println("headNode:");
         //traverse child elements         
         for (int i=0; i < nodes.getLength(); i++) 
         { 
        	 NodeList childNodes = nodes.item(i).getChildNodes();
        	 for(int j = 0;j<childNodes.getLength();j++){
        		 if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {  //判断子节点是否含有空节点
        			 System.out.print(childNodes.item(j).getNodeName()+ ":" + childNodes.item(j).getTextContent()+" ");	 
        	 }                      
            } 
         } 
         NodeList nodes2 = document.getElementsByTagName("tailNode");
         System.out.println("\n"+"tailNode:");
         for (int i=0; i < nodes2.getLength(); i++) 
         { 
        	 NodeList childNodes = nodes2.item(i).getChildNodes();
        	 for(int j = 0;j<childNodes.getLength();j++){
        		 if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {  //判断子节点是否含有空节点
        			 System.out.print(childNodes.item(j).getNodeName()+ ":" + childNodes.item(j).getTextContent()+" ");	 
        	 }                      
            } 
         } 
         /*
         NodeList nodeList = rootElement.getElementsByTagName("book"); 
         if(nodeList != null) 
         { 
            for (int i = 0 ; i < nodeList.getLength(); i++) 
            { 
               Element element = (Element)nodeList.item(i); 
               String id = element.getAttribute("id"); 
            } 
         }*/ 
   } 
 }