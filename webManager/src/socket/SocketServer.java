    /* 
    服务端原先有很大的局限性 
    原先我们没有考虑客户端的文件名,和客户端判断是否有重名文件,我们是另外指定了文件名和路径 
    当客户端A连接服务端,被服务端获取到后,服务端执行具体流程, 
    这时如果B客户端尝试连接服务端,但只能等待 
    因为服务端还没有处理完A客户端的请求,不能回while起始位置执行accept方法,所以 
    暂时获取不到B客户端对象,那么为了可以让多个客户端同时被服务端并发接收, 
    那么服务端最好就是将每个客户端封装到一个个单独的线程中,这样,就可以同时处理多个客户端请求 
    如何定义线程呢? 
    只要明确每一个客户端要再服务端执行的代码即可,将该代码放到run方法中 
    如果服务端存在同名文件就返回信息并断开该次连接 
     
     
    如果要让客户端选择是否要覆盖文件,可以再加个反馈操作应该就可以了 
     
    [示例]:传送任意文件 (服务端并发执行) 
    */  
	package socket;
    import java.net.*;  
    import java.io.*;  
    public class SocketServer  { 
      public static void main(String[] args) throws Exception  
      {  
        new FileServer();  //启动文件存储服务端  
      }  
    }  
      
    class FileServer  //服务端  
    {  
      FileServer() throws Exception  
      {   
        s.op("服务端启动......");  
        server();  
      }  
      
      public void server() throws Exception  
      {  
        ServerSocket serversock = new ServerSocket(10009);  //监听端口  
        while(true)  
        {     
          Socket sock = serversock.accept();            //循环等待客户端连接  
          new Thread(new FileServThread(sock)).start(); //当成功连接客户端后开启新线程接收文件  
        }  
      }  
    }  
      
    class FileServThread implements Runnable   //服务端线程  
    {  
      private Socket sock;  
      FileServThread(Socket sock)  
      {  
        this.sock = sock;  
      }  
        
      public void run()  
      {  
        String ip = sock.getInetAddress().getHostAddress();   //获取客户端ip  
        try  
        {  
          s.op("开启新线程接收来自客户端IP: "+ip+" 的文件");  
          InputStream sockIn= sock.getInputStream();//定义socket输入流,接收客户端的信息。服务器的输入流就是客户端的输出流  
          File file =getClientFileName(sockIn);     //创建同名文件  
          if(file==null)  
          {  
            writeOutInfo(sock,"存在同名文件或获取文件失败,服务端断开连接!");  
            sock.close();              
            return;  
          }  
           
          FileOutputStream fos= new FileOutputStream(file); //用来写入硬盘  
          byte[] bufFile = new byte[1024*1024];   //接收数据的缓存  
          int len=0;  
          while(true)  
          {  
            len=sockIn.read(bufFile); //接收数据  
            if(len!=-1)  
            {  
              fos.write(bufFile,0,len); //写入硬盘文件  
            }  
            else  
            {  
              break;  
            }  
          }  
          writeOutInfo(sock,"上传成功!");   //文件接收成功后给客户端反馈一个信息  
          s.op("文件接收成功!"+System.getProperty("line.separator"));  //服务端打印一下  
          fos.close();  
          sock.close();       
        }  
        catch(Exception ex)  
        {  
          throw new RuntimeException(ip+"异常!!!");  
        }  
      }  
        
      public void writeOutInfo(Socket sock,String infoStr)throws Exception//将信息反馈给服务端  
      {  
        OutputStream sockOut = sock.getOutputStream();  
        sockOut.write(infoStr.getBytes());  
      }  
        
      public File getClientFileName(InputStream sockIn) throws Exception //获取文件名并创建  
      {    
        //获取客户端请求发送的文件名,并判断在D盘创建同名文件的情况  
        byte[] bufName=new byte[1024];  
        int lenInfo =0;  
        lenInfo = sockIn.read(bufName);  //获取文件名  
        String fileName = new String(bufName,0,lenInfo);  
        String path = "F:\\socketXml\\";
        
          
        File dir = new File(path);    //存到F盘这个文件夹下,dir文件对象
        File[] files=dir.listFiles();   //遍历F:\\socketXml\\目录
        for(File f:files)  
        {  
          if(!f.isDirectory())  //如果遍历到的该文件不是一个目录的话  
          {   
            if(f.getName().equals(fileName))  //判断是否是同名文件  
            {  
              s.op(f.getName()+"文件已存在,断开该ip连接."+System.getProperty("line.separator"));  //获取系统属性，行分隔符
              writeOutInfo(sock,"服务端已存在同名文件!"); //反馈给客户端的信息  
              return null;         
            }  
          }  
        }  
        s.op("将客户端发来的文件( "+fileName+" )存到"+dir.getAbsolutePath());       
        File file= new File(dir+"\\"+ fileName);    
        if(file.createNewFile())  
        {   
          s.op("成功创建文件("+fileName+" )准备写入数据");  
          writeOutInfo(sock,"FileSendNow");    //告诉客户端,开始传送数据吧    
          return file;  
        }  
        else  
        {  
          return null; //如果由于硬盘满了等原因创建文件失败的话  
        }  
      }  
    }  
      
  