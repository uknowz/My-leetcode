package mycode;
/*
�������ܺõĽ����˶��߳�ͬ�������ƣ���main�����������������̣߳�ÿ���̶߳�����
lock���˽�б�����Ȼ���Ҷ�lock������synchronizedͬ������飬ʹ��ͬһʱ��ֻ����
һ���߳���ִ���ҵ�ͬ�����Ĵ��룬���Խ����ÿ���̶߳���������������������
*/
public class ThreadTest extends Thread{

	
	private int threadNo;
	private String lock;
	
	public ThreadTest(int threadNo1,String lock1){
		threadNo = threadNo1;
		lock = lock1;
	}
	public void run(){
		synchronized(lock){//û����ȷ�Ķ�����Ϊ����ֻ����Ҫ�ڿ���̨������δ���ͬ�������Դ���һ�������instance����
			//�������������˽�еĶ�����byte[]���飬String���󣬲��ܴﵽ��������Ч��
			for(int i=0;i<9;i++){
				System.out.println("the thread number is:" + threadNo +"count:" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		for(int i=0;i<3;i++){
			new ThreadTest(i, "lock").start();
		}

	}

}
