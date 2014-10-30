
import java.util.*;
import java.lang.reflect.*;


public class ReflectTest {
	public static void main(String[] args)
	{
		int[] a = {1, 2, 3};
		a = (int[])goodArrayGrow(a);
		arrayPrint(a);
		
		String[] b = {"hhh", "ttt", "ggg"};
		b = (String[])goodArrayGrow(b);
		arrayPrint(b);
	}
	
	static Object goodArrayGrow(Object a)
	{
		Class cl = a.getClass();
		if (! cl.isArray())
		{
			return null;
		}
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		int newLength = length*11/10 + 10;
		
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, length);
		return newArray;
		
	}
	
	static void arrayPrint(Object a)
	{
		Class cl = a.getClass();
		if (! cl.isArray()) return;
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		System.out.print(componentType.getName() + "[" + length + "] = {");
		for (int i = 0; i < Array.getLength(a); i++)
		{
			Object obj = Array.get(a, i);
			System.out.print(obj + " ");			
		}
		System.out.println("}");
		
	}

}
