package mycode;

//������򲻺ã���thread�Ǹ�
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
					//����1s���У�Ϊ��ʹЧ�������ԣ�������ܳ�����Ч��
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
		System.out.println(Thread.currentThread().getName()+"�Ŵ���������"+this.ticket+"��Ʊ");
		ticket--;
		
	}
	
	 public static void main(String args[]){
		 
		 //���ڻ�Ʊ������������
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
