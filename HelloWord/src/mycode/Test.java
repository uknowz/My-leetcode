package mycode;

public class Test extends Thread implements Runnable{

	/**
	 * @param args
	 */
	public void run(){
		System.out.println("thread start");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("�߳��ж�");
		}
		System.out.println("run finished");
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Test test = new Test();
		test.start();
		try{
			Thread.sleep(10000);
			test.wait(10000);
		}catch(InterruptedException e){
		System.out.println("a ");	
		}
		test.interrupt();
		Thread t1 = new Thread();

	}

}
