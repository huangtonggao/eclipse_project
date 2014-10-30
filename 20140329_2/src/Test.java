
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Test {

	public static void main(String[] args) {
		
		List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		
		Thread t1 = new Thread(new readThread(list));
		t1.start();
		
		Thread t2 = new Thread(new writeThread(list));
		t2.start();
		
		
		
		
	}
}

class readThread implements Runnable{
	
	

	public readThread(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		int firstVal = 0;
		int readVal = 0;
		while(true)
		{
			synchronized (list) {
				Iterator<Integer> iterator = list.iterator();
				boolean flag = false;
				
				while(iterator.hasNext())
				{
					if (!flag)
					{
						flag = true;
						firstVal = iterator.next();
						continue;
					}
					readVal = iterator.next();
					if (firstVal != readVal)
					{
						System.out.println("firatVal = " + firstVal + ", readVal = " + readVal);
					}	
					
				}
			}
			
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	private List<Integer> list;
	
}


class writeThread implements Runnable{
	
	

	public writeThread(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		int i = 0;
		int j;
		while(true)
		{
			i++;
			j = i % 10;
			synchronized (list) {
				list.set(0, j);
				list.set(1, j);
				list.set(2, j);
				list.set(3, j);
				list.set(4, j);
				list.set(5, j);
				list.set(6, j);
				list.set(7, j);
			}
			
		}		
	}
	
	private List<Integer> list;
	
}
