
public class test {
	
	public static int factorial(int n)
	{
		System.out.println("factorial(" + n + ")");
		
		Throwable t = new Throwable();
		StackTraceElement[] frames = t.getStackTrace();
		for (StackTraceElement frame : frames)
			System.out.println(frame);
		int r;
		if (n <= 1) r = 1;
		else
		{
			r = n*factorial(n-1);
		}
		System.out.println("return " + r);
		return r;
			
	}
	
	public static void main(String[] args)
	{
		factorial(4);
	}

}
