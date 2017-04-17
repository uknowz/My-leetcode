package socket;
import java.io.FileInputStream;
import java.io.IOException;

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

public class XmlFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1407789606539936799L;

	/**
	 * @param args
	 */
	
	XmlFrame(){
		super("xml文件元素显示");
		setSize(100, 100);
       
        JPanel panel = new JPanel();
        JTextArea text = new JTextArea(100,100);//设置20行20列的文本区域
    	JScrollPane scroll = new JScrollPane(text,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    	XmlDom2 parser = new XmlDom2(); 
        String pathName = "F:\\socketXml\\bbu.xml";
        Document document = parser.parse(pathName); 
        String xmlFrame = parser.xmlMethodBBU(document);
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
 class XmlDom2 { 
	   
	   //Load and parse XML file into DOM 
	   public Document parse(String filePath) {
		  DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
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
	   public String xmlMethod(Document docu){
		   NodeList nodes = docu.getElementsByTagName("headNode");
		   StringBuffer str = new StringBuffer();
	       str.append("headNode:" + "\n");
	       //traverse child elements         
	       for (int i=1; i <= nodes.getLength(); i++) 
	       { 
	      	 NodeList childNodes = nodes.item(i).getChildNodes();
	      	 for(int j = 0;j<childNodes.getLength();j++){
	      		 if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {  //判断子节点是否含有空节点
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
	      		 if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {  //判断子节点是否含有空节点
	      			 str.append(childNodes.item(j).getNodeName()+ ":" + childNodes.item(j).getTextContent()+" ");	 
	      	 }                      
	          }
	      	str.append("\n");
	       }
	       return str.toString();
	   }
	  
	   public String xmlMethod2(Document docu){
		   NodeList nodelist = docu.getElementsByTagName("PHYSICAL_LINK_LIST");//总的physical_link_list节点
		   StringBuffer str = new StringBuffer("物理拓扑：");
		   
		   for(int i=0; i<nodelist.getLength();i++){
			   NodeList childNodes1 = nodelist.item(i).getChildNodes();//每一个子physical_link_list节点列表
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
	   //物理拓扑好像用的是method3
	   public String xmlMethod3(Document docu){//解析物理拓扑
		   NodeList nodelist = docu.getElementsByTagName("physical_link_list");//每一个子physical_link_list节点列表
		   StringBuffer str = new StringBuffer("物理拓扑：");
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

	   public String xmlMethodRRU(Document docu){//解析物理拓扑
		   NodeList nodelist = docu.getElementsByTagName("rru_list");//每一个子physical_link_list节点列表
		   StringBuffer str = new StringBuffer("RRU状态：");
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
	   public String xmlMethodBBU(Document docu){//解析BBU资源
		   NodeList nodelist = docu.getElementsByTagName("bbu_list");//每一个子bbu_list节点列表
		   StringBuffer str = new StringBuffer("BBU资源："+ "\n");
		   str.append("loadStatus: 0表示不过载，1表示过载。CoMPStatus: 0表示不进行CoMP，1表示进行CoMP");
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
		
	   public String xmlMethodBBUjuhe(Document docu){//解析物理拓扑
		   NodeList nodelist = docu.getElementsByTagName("status");
		   StringBuffer str = new StringBuffer("BBU聚合结果："+"\n");
		   for(int i=0; i<nodelist.getLength();i++){
			   if(nodelist.item(i).getNodeType() == Node.ELEMENT_NODE){
				   
				   str.append(nodelist.item(i).getNodeName()+":"+nodelist.item(i).getTextContent()+" ");
			  }
		   }
		   return str.toString();
	   }
	 }
