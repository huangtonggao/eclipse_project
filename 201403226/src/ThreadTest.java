
public class ThreadTest {
	public static void main(String[] args) {
		
		Thread t = new Thread(new Runnable()
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true)
				{
					System.out.println(Thread.currentThread());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		//t.start();
		
		//System.exit(0);
		
		myThread m = new myThread();
		myThread2 m2 = new myThread2();
		System.out.println(m.getName());
		System.out.println(m2.getName());
		
		//m.start();
		//m2.start();
		
		Thread tt = new Thread()
		{
			public void run() {
				System.out.println("thread");
			};
		};
		tt.start();
		
	}

}

class myThread extends Thread
{
	@Override
	public void run() {
		for (int i = 0; i < 100; i++)
		{
			System.out.println("hello world " + i);
		}
	}
}

class myThread2 extends Thread
{
	@Override
	public void run() {
		for (int i = 0; i < 100; i++)
		{
			System.out.println("welcome " + i);
		}
	}
}

