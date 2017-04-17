package socket; 
/* 
    TCPͨѶ 
    ����:���������ļ� 
     
    tcp����Ҫ����2���˵�,�ͻ��˺ͷ���� 
    ���� 
    1.�������, ������ip�ͽ��ն˿� 
    2.��ȡ�ͻ������е�ͼƬ�ļ� 
    3.ʹ��socket����������ݷ�������� 
    4.��ȡ����˵ķ�����Ϣ 
    5.�ر���Դ 
     
    ע��: 
    1.��whileѭ���е�read�����������ļ��������-1��ѭ���˳��� 
      ��û�н��ñ��д��socket����,��ô����˽��յ��������ǲ�������,����ͣ������ 
      ��shutdownOutput�������߷�����ļ�����ĩβ���������� 
     
    [ʾ��]:���������ļ� (�ͻ���) 
    */  
      
    import java.net.*;  
    import java.io.*;  
   public class SocketClient  
    {  
      public static void main(String[] args) throws Exception  
      {  
        new FileClient("C:\\Users\\Administrator\\Desktop\\font size.txt"); //�����ͻ���,׼������ָ���ļ�  
      }  
    }  
      
    class FileClient  //�ͻ���  
    {  
      FileClient(String fileStr) throws Exception  
      {  
        s.op("�ͻ�������....");  
        File file = new File(fileStr);  //����һ���ļ�c:\\FoxitReader_CHS.rar  
        if(file.isFile())  //��һ����׼�ļ���?  
        {  
          client(file);    //��������  
        }  
        else  
        {  
          s.op("Ҫ���͵��ļ� "+fileStr+" ����һ����׼�ļ�,����ȷָ��");  
        }  
      }  
        
      public void client(File file)throws Exception  
      {  
        Socket sock= new Socket("",10007); //ָ������˵�ַ�Ͷ˿�        
        FileInputStream fis = new FileInputStream(file); //��ȡ�����ļ�  
        OutputStream sockOut = sock.getOutputStream();   //����socket�����  
          
        //�ȷ����ļ���.�÷����֪��  
        String fileName = file.getName();  
        s.op("�������ļ�:"+fileName);  
        sockOut.write(fileName.getBytes());  
          
        String serverInfo= servInfoBack(sock); //��������Ϣ:������Ƿ��ȡ�ļ����������ļ��ɹ�  
        if(serverInfo.equals("FileSendNow"))   //�����˵�Ѿ�׼�������ļ�,����  
        {  
          byte[] bufFile= new byte[1024];  
          int len=0;  
          while(true)  
          {  
            len=fis.read(bufFile);  
            if(len!=-1)  
            {  
              sockOut.write(bufFile,0,len); //����Ӳ���϶�ȡ���ֽ�����д��socket�����  
            }  
            else  
            {  
              break;  
            }  
          }        
        }  
        else  
        {  
          s.op("����˷�����Ϣ:"+serverInfo);  
        }  
        sock.shutdownOutput();   //�����,Ҫ���߷���˸��ļ���������д�� ����Ϊread-1�����ֹ�ֽ�û��д���ֽ�������
        s.op("��������һ��������Ϣ:"+servInfoBack(sock));//��ʾ�������󷵻ص���Ϣ  
          
        fis.close();  
        sock.close();  
      }  
        
      public String servInfoBack(Socket sock) throws Exception  //��ȡ����˵ķ�����Ϣ  
      {  
        InputStream sockIn = sock.getInputStream(); //����socket������  
        byte[] bufIn =new byte[1024];  
        int lenIn=sockIn.read(bufIn);            //������˷��ص���Ϣд��bufIn�ֽڻ�����,������һ����ͬ������read��������ͨ�����������ֽڲ�һ���������������������ǿͻ��˵������
        String info=new String(bufIn,0,lenIn);  
        return info;  
      }  
    }  
      
    class s    
    {  
      public static void op(Object obj) //��ӡ  
      {  
        System.out.println(obj);  
      }  
    }  