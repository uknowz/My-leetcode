package socket;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//�����Լ�д�����ܽ���xml����
public class XmlFrame2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1407789606539936799L;

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	
	XmlFrame2() throws MalformedURLException{
		super("xml�ļ�Ԫ����ʾ");
		setSize(100, 100);
       
        JPanel panel = new JPanel();
        JTextArea text = new JTextArea(100,100);//����20��20�е��ı�����
    	JScrollPane scroll = new JScrollPane(text,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    	UrlDom parser = new UrlDom(); 
        String pathName = "F:\\socketXml\\bbuJUHE.xml";//��·��url
        Document document = parser.parse(pathName); 
        String xmlFrame = parser.xmlMethodBBUjuhe(document);
        text.setText(xmlFrame);
        panel.add(scroll);
        pack();
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
        
	}
	public static void main(String[] args) { 
         new XmlFrame();
   } 

}
 class UrlDom { 
	   
	   //Load and parse XML file into DOM 
	   public Document parse(String url)throws MalformedURLException {
		  DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	      Document document = null; 
	      try { 
	         //DOM parser instance 
	         DocumentBuilder builder = builderFactory.newDocumentBuilder(); 
	         //parse an XML file into a DOM tree 
	         URL urls = new URL(url);
	         try{
	        	 HttpURLConnection http = (HttpURLConnection)urls.openConnection();//����һ��URLConnection��ʾ���ӵ�Զ�̵�URL����
	        	 http.setRequestProperty("accept", "*/*");
	             http.setRequestProperty("connection", "Keep-Alive");
	             http.setRequestProperty("user-agent",
	                     "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	             String userPassword= "username:password";
	        	 http.connect();//��������
	 			 document = builder.parse(http.getInputStream());//��string pathname �ĳ�url intputstream
	         }catch (IOException e) {
	 			// TODO �Զ����ɵ� catch ��
	 			System.out.println("io error:" + e.toString());
	 		}
	          
	      } catch (ParserConfigurationException e) { 
	         e.printStackTrace();  
	      } catch (SAXException e) { 
	         e.printStackTrace(); 
	      } catch (IOException e) { 
	         e.printStackTrace(); 
	      } 
	      return document; 
	   } 
	   public String xmlMethod(Document docu){
		   NodeList nodes = docu.getElementsByTagName("headNode");
		   StringBuffer str = new StringBuffer();
	       str.append("headNode:" + "\n");
	       //traverse child elements         
	       for (int i=1; i <= nodes.getLength(); i++) 
	       { 
	      	 NodeList childNodes = nodes.item(i).getChildNodes();
	      	 for(int j = 0;j<childNodes.getLength();j++){
	      		 if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {  //�ж��ӽڵ��Ƿ��пսڵ�
	      			 str.append(childNodes.item(j).getNodeName()+ ":" + childNodes.item(j).getTextContent()+" ");	 
	      	 }                      
	          }
	      	 str.append("\n");
	       } 
	       NodeList nodes2 = docu.getElementsByTagName("tailNode");
	       str.append("tailNode:" + "\n");
	       for (int i=0; i < nodes2.getLength(); i++) 
	       { 
	      	 NodeList childNodes = nodes2.item(i).getChildNodes();
	      	 for(int j = 0;j<childNodes.getLength();j++){
	      		 if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {  //�ж��ӽڵ��Ƿ��пսڵ�
	      			 str.append(childNodes.item(j).getNodeName()+ ":" + childNodes.item(j).getTextContent()+" ");	 
	      	 }                      
	          }
	      	str.append("\n");
	       }
	       return str.toString();
	   }
	  
	   public String xmlMethod2(Document docu){
		   NodeList nodelist = docu.getElementsByTagName("PHYSICAL_LINK_LIST");//�ܵ�physical_link_list�ڵ�
		   StringBuffer str = new StringBuffer("�������ˣ�");
		   
		   for(int i=0; i<nodelist.getLength();i++){
			   NodeList childNodes1 = nodelist.item(i).getChildNodes();//ÿһ����physical_link_list�ڵ��б�
			   //str.append("Link " + (i+1) +"\n");
			   for(int j =0;j<childNodes1.getLength();j++){
				   str.append("\n");
				   NodeList childNodes2 = childNodes1.item(j).getChildNodes();//headnode.tailnode.bandwidth.wavelength
				   for(int k=0;k<childNodes2.getLength();k++){
					   if(childNodes2.item(k).getNodeType() == Node.ELEMENT_NODE){
						   
						   str.append(childNodes2.item(k).getNodeName()+":"+childNodes2.item(k).getTextContent()+" ");
					  } 
					   
				   }
				   
				   
			   }
			  // break;
		   }
		   return str.toString();
	   }
	   //�������˺����õ���method3
	   public String xmlMethod3(Document docu){//������������
		   NodeList nodelist = docu.getElementsByTagName("physical_link_list");//ÿһ����physical_link_list�ڵ��б�
		   StringBuffer str = new StringBuffer("�������ˣ�");
		   str.append("\n");
		   for(int i=0; i<nodelist.getLength();i++){
			  NodeList childNodes1 = nodelist.item(i).getChildNodes();//headnode.tailnode.bandwidth.wavelength
			   //str.append("Link " + (i+1) +"\n");
			  str.append("\n");
			  for(int j=0;j<childNodes1.getLength();j++){
				  //
				  if(childNodes1.item(j).getNodeType() == Node.ELEMENT_NODE){
					   
					   str.append(childNodes1.item(j).getNodeName()+":"+childNodes1.item(j).getTextContent()+" ");
				  } 
			  }
			   
			   
		   }
		   return str.toString();
	   }

	   public String xmlMethodRRU(Document docu){//������������
		   NodeList nodelist = docu.getElementsByTagName("rru_list");//ÿһ����physical_link_list�ڵ��б�
		   StringBuffer str = new StringBuffer("RRU״̬��");
		   for(int i=0; i<nodelist.getLength();i++){
			  NodeList childNodes1 = nodelist.item(i).getChildNodes();//headnode.tailnode.bandwidth.wavelength
			   //str.append("Link " + (i+1) +"\n");
			  str.append("\n");
			  for(int j=0;j<childNodes1.getLength();j++){
				  //
				  if(childNodes1.item(j).getNodeType() == Node.ELEMENT_NODE){
					   
					   str.append(childNodes1.item(j).getNodeName()+":"+childNodes1.item(j).getTextContent()+" ");
				  } 
			  }
			   
			   
		   }
		   return str.toString();
	   }
	   public String xmlMethodBBU(Document docu){//����BBU��Դ
		   NodeList nodelist = docu.getElementsByTagName("bbu_list");//ÿһ����bbu_list�ڵ��б�
		   StringBuffer str = new StringBuffer("BBU��Դ��"+ "\n");
		   str.append("loadStatus: 0��ʾ�����أ�1��ʾ���ء�coMPStatus: 0��ʾ������coMP��1��ʾ����coMP");
		   for(int i=0; i<nodelist.getLength();i++){
			  NodeList childNodes1 = nodelist.item(i).getChildNodes();//headnode.tailnode.bandwidth.wavelength
			   //str.append("Link " + (i+1) +"\n");
			  str.append("\n");
			  for(int j=0;j<childNodes1.getLength();j++){
				  //
				  if(childNodes1.item(j).getNodeType() == Node.ELEMENT_NODE){
					   
					   str.append(childNodes1.item(j).getNodeName()+":"+childNodes1.item(j).getTextContent()+" ");
				  } 
			  }
			   
			   
		   }
		   return str.toString();
	   }
		
	   public String xmlMethodBBUjuhe(Document docu){//������������
		   NodeList nodelist = docu.getElementsByTagName("status");
		   StringBuffer str = new StringBuffer("BBU�ۺϽ����"+"\n");
		   for(int i=0; i<nodelist.getLength();i++){
			   if(nodelist.item(i).getNodeType() == Node.ELEMENT_NODE){
				   
				   str.append(nodelist.item(i).getNodeName()+":"+nodelist.item(i).getTextContent()+" ");
			  }
		   }
		   return str.toString();
	   }
	 }
