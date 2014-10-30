import java.lang.reflect.*;
import java.util.*;

//import htg_class.*;

public class MyTest {
	public static void main(String[] args)
	{
		Employee e = new Employee("hhh", 2222, 2033, 2, 2);
		Class cl = e.getClass();
		try
		{
			Method m = cl.getDeclaredMethod("getName", null);	
			String n = (String)m.invoke(e);
			System.out.println(n);
			
			Method m1 = cl.getDeclaredMethod("getSalary", null);	
			double n1 = (double)m1.invoke(e);
			System.out.println(n1);		
			
			Method m2 = cl.getDeclaredMethod("printTest", String.class, int.class);
			m2.invoke(e, "m2 test", 111);
			
			
			
		}
		catch (Exception err)
		{
			err.printStackTrace();
		}	
		
		try
		{
			Field f1 = cl.getDeclaredField("nextId");
			//AccesibleObject.setAccessible(f1, true);
			//static void	setAccessible(AccessibleObject[] array, boolean flag)
			//第一个参数必须是数组，所以第一行报错
			f1.setAccessible(true);
			System.out.println(f1.get(e));	
		}
		catch (Exception err1)
		{
			err1.printStackTrace();
		}	

		
		
		System.out.println("hello world.");
	}

}
