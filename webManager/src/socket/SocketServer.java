    /* 
    �����ԭ���кܴ�ľ����� 
    ԭ������û�п��ǿͻ��˵��ļ���,�Ϳͻ����ж��Ƿ��������ļ�,����������ָ�����ļ�����·�� 
    ���ͻ���A���ӷ����,������˻�ȡ����,�����ִ�о�������, 
    ��ʱ���B�ͻ��˳������ӷ����,��ֻ�ܵȴ� 
    ��Ϊ����˻�û�д�����A�ͻ��˵�����,���ܻ�while��ʼλ��ִ��accept����,���� 
    ��ʱ��ȡ����B�ͻ��˶���,��ôΪ�˿����ö���ͻ���ͬʱ������˲�������, 
    ��ô�������þ��ǽ�ÿ���ͻ��˷�װ��һ�����������߳���,����,�Ϳ���ͬʱ�������ͻ������� 
    ��ζ����߳���? 
    ֻҪ��ȷÿһ���ͻ���Ҫ�ٷ����ִ�еĴ��뼴��,���ô���ŵ�run������ 
    �������˴���ͬ���ļ��ͷ�����Ϣ���Ͽ��ô����� 
     
     
    ���Ҫ�ÿͻ���ѡ���Ƿ�Ҫ�����ļ�,�����ټӸ���������Ӧ�þͿ����� 
     
    [ʾ��]:���������ļ� (����˲���ִ��) 
    */  
	package socket;
    import java.net.*;  
    import java.io.*;  
    public class SocketServer  { 
      public static void main(String[] args) throws Exception  
      {  
        new FileServer();  //�����ļ��洢�����  
      }  
    }  
      
    class FileServer  //�����  
    {  
      FileServer() throws Exception  
      {   
        s.op("���������......");  
        server();  
      }  
      
      public void server() throws Exception  
      {  
        ServerSocket serversock = new ServerSocket(10009);  //�����˿�  
        while(true)  
        {     
          Socket sock = serversock.accept();            //ѭ���ȴ��ͻ�������  
          new Thread(new FileServThread(sock)).start(); //���ɹ����ӿͻ��˺������߳̽����ļ�  
        }  
      }  
    }  
      
    class FileServThread implements Runnable   //������߳�  
    {  
      private Socket sock;  
      FileServThread(Socket sock)  
      {  
        this.sock = sock;  
      }  
        
      public void run()  
      {  
        String ip = sock.getInetAddress().getHostAddress();   //��ȡ�ͻ���ip  
        try  
        {  
          s.op("�������߳̽������Կͻ���IP: "+ip+" ���ļ�");  
          InputStream sockIn= sock.getInputStream();//����socket������,���տͻ��˵���Ϣ�������������������ǿͻ��˵������  
          File file =getClientFileName(sockIn);     //����ͬ���ļ�  
          if(file==null)  
          {  
            writeOutInfo(sock,"����ͬ���ļ����ȡ�ļ�ʧ��,����˶Ͽ�����!");  
            sock.close();              
            return;  
          }  
           
          FileOutputStream fos= new FileOutputStream(file); //����д��Ӳ��  
          byte[] bufFile = new byte[1024*1024];   //�������ݵĻ���  
          int len=0;  
          while(true)  
          {  
            len=sockIn.read(bufFile); //��������  
            if(len!=-1)  
            {  
              fos.write(bufFile,0,len); //д��Ӳ���ļ�  
            }  
            else  
            {  
              break;  
            }  
          }  
          writeOutInfo(sock,"�ϴ��ɹ�!");   //�ļ����ճɹ�����ͻ��˷���һ����Ϣ  
          s.op("�ļ����ճɹ�!"+System.getProperty("line.separator"));  //����˴�ӡһ��  
          fos.close();  
          sock.close();       
        }  
        catch(Exception ex)  
        {  
          throw new RuntimeException(ip+"�쳣!!!");  
        }  
      }  
        
      public void writeOutInfo(Socket sock,String infoStr)throws Exception//����Ϣ�����������  
      {  
        OutputStream sockOut = sock.getOutputStream();  
        sockOut.write(infoStr.getBytes());  
      }  
        
      public File getClientFileName(InputStream sockIn) throws Exception //��ȡ�ļ���������  
      {    
        //��ȡ�ͻ��������͵��ļ���,���ж���D�̴���ͬ���ļ������  
        byte[] bufName=new byte[1024];  
        int lenInfo =0;  
        lenInfo = sockIn.read(bufName);  //��ȡ�ļ���  
        String fileName = new String(bufName,0,lenInfo);  
        String path = "F:\\socketXml\\";
        
          
        File dir = new File(path);    //�浽F������ļ�����,dir�ļ�����
        File[] files=dir.listFiles();   //����F:\\socketXml\\Ŀ¼
        for(File f:files)  
        {  
          if(!f.isDirectory())  //����������ĸ��ļ�����һ��Ŀ¼�Ļ�  
          {   
            if(f.getName().equals(fileName))  //�ж��Ƿ���ͬ���ļ�  
            {  
              s.op(f.getName()+"�ļ��Ѵ���,�Ͽ���ip����."+System.getProperty("line.separator"));  //��ȡϵͳ���ԣ��зָ���
              writeOutInfo(sock,"������Ѵ���ͬ���ļ�!"); //�������ͻ��˵���Ϣ  
              return null;         
            }  
          }  
        }  
        s.op("���ͻ��˷������ļ�( "+fileName+" )�浽"+dir.getAbsolutePath());       
        File file= new File(dir+"\\"+ fileName);    
        if(file.createNewFile())  
        {   
          s.op("�ɹ������ļ�("+fileName+" )׼��д������");  
          writeOutInfo(sock,"FileSendNow");    //���߿ͻ���,��ʼ�������ݰ�    
          return file;  
        }  
        else  
        {  
          return null; //�������Ӳ�����˵�ԭ�򴴽��ļ�ʧ�ܵĻ�  
        }  
      }  
    }  
      
  