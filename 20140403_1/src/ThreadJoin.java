
public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Thread1());
		t1.start();
		
		t1.join();
		System.out.println("ThreadJoin");
	}

}

class Thread1 implements Runnable
{
	@Override
	public void run() {
		
		System.out.println("Thread start");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread end");
		
	}
	
}
