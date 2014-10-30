import java.util.Date;


class A 
{
	public Object print()
	{
		System.out.println("A");
		return new Object();
	}
	
	public void set(A a){System.out.println("A set");}
}

class AA extends A
{
	public Date print() 
	{
		System.out.println("AA");
		return new Date();
	}
	
	public void set(AA aa){System.out.println("AA set");}
}


public class Test {
	
	public static void main(String[] args)
	{
		A a = new A();
		AA aa = new AA();
		
		a = aa;
		a.print();
		a.set(aa);
		
	}

}
