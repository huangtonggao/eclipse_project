import java.util.Date;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;


class A
{
    public A(){}
    public A(int i){}
    public void test(){}
    
    public double data_i = 1;
	public double data_d = 2;
	private double data_c = 3;
	
	public void set(double i){data_i = i;}
}
class AA extends A
{
	public AA(){super(10);}
    public int data_aa = 4;
}


public class test
{
    public static void main(String[] args)
	{
	    AA a = new AA();
	    AA a1 = new AA();
	    a.set(20);
	    Field[] f = new Field[10];
		
		
		try
		{
		    f = a.getClass().getFields();
		}
		catch (Exception e1)
		{
		    e1.printStackTrace();
		}
		
		for (Field i : f)		
		System.out.println(i.toString());
		/*try{System.out.println(f.getName());}
		catch (Exception e2) {e2.printStackTrace();}*/
		

	

		
		
	
	    /*A a = new A();
		Field[] f = new Field[10];
		try
		{
		    f = a.getClass().getDeclaredFields();
		}
		catch (Exception e1)
		{
		    e1.printStackTrace();
		}
		
		System.out.println("length of f is " + f.length);
		
		try{
			for (Field f1 : f) System.out.println(f1.getDouble());
		}
		catch (Exception e2)
		{
		    e2.printStackTrace();
		}*/
		
		
		
		
	
	
	
	    /*String className = "java.util.Date";
		Class cl = null;
		try{cl = Class.forName(className);}
		catch (Exception e1)
		{
		    e1.printStackTrace();
		}*/
	    //System.out.println(cl.getName());	
	    //System.out.println((new Date()).getClass().getName());	
	    
	}
}