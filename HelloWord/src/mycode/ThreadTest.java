package mycode;
/*
这个程序很好的解释了多线程同步锁机制，在main方法里生成了三个线程，每个线程都共用
lock这个私有变量，然后我对lock对象用synchronized同步代码块，使得同一时间只能有
一个线程能执行我的同步锁的代码，所以结果是每个线程都依次数数，不会乱了套
*/
public class ThreadTest extends Thread{

	
	private int threadNo;
	private String lock;
	
	public ThreadTest(int threadNo1,String lock1){
		threadNo = threadNo1;
		lock = lock1;
	}
	public void run(){
		synchronized(lock){//没有明确的对象作为锁，只是想要在控制台数数这段代码同步，可以创造一个特殊的instance变量
			//这个变量必须是私有的对象，如byte[]数组，String对象，才能达到对象锁的效果
			for(int i=0;i<9;i++){
				System.out.println("the thread number is:" + threadNo +"count:" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		for(int i=0;i<3;i++){
			new ThreadTest(i, "lock").start();
		}

	}

}
