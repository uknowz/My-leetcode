package mycode;

//这个程序不好，换thread那个
public class Runnable_demo extends Thread implements Runnable{
	private int ticket=10;
	private int threadNo;
	public Runnable_demo(int threadNo){
		this.threadNo = threadNo;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
				if(this.ticket>0){
					//休眠1s秒中，为了使效果更明显，否则可能出不了效果
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					this.sale();
				}
			
		}
	}
	public synchronized void  sale() {
		if(this.ticket>0)
		System.out.println(Thread.currentThread().getName()+"号窗口卖出："+this.ticket+"号票");
		ticket--;
		
	}
	
	 public static void main(String args[]){
		 
		 //基于火车票创建三个窗口
		 /*
		 new Thread(demo,"a").start();
		 new Thread(demo,"b").start();
		 new Thread(demo,"c").start();
		 */
		 for(int i=0;i<3;i++){
			 new Runnable_demo(i).start();
		 }
		 
	 }
	
}
