import java.util.Date;



class Pair<T /*extends Comparable*/>
{
	public Pair()
	{
		first = null;
		second = null;
	}
	public Pair(T first, T second)
	{
		this.first = first;
		this.second = second;
	}
	public T getFirst(){return first;}
	public T getSecond(){return second;}
		
	private T first;
	private T second;
	
}

class Arrayalg
{
	public static Pair<String> minmax(String[] a)
	{
		if (a == null || a.length == 0) return null;
		String min = a[0];
		String max = a[0];
		
		for (int i = 0; i < a.length; i++)
		{
			if (min.compareTo(a[i]) > 0) min = a[i];
			if (max.compareTo(a[i]) < 0) max = a[i];			
		}		
		return new Pair<String>(min, max);
	}
}

class GenericMethod
{
	public static <T extends Comparable> T getMiddle(T[] a)
	{
		return a[a.length/2];
	}
}

class emptyClass implements Comparable
{
	public emptyClass()
	{
		ObjectIndex = index;
		index ++;
	}
	
	private  int ObjectIndex;
	private static int index = 0;
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class A
{
	@Override
	public String toString()
	{
		return this.getClass() + "";
	}
}
class AA extends A
{
	
}
class B
{
	@Override
	public String toString()
	{
		return this.getClass() + "";
	}
}
class BB extends B
{
	
}

class GenericMethod2
{
	public static <T extends  B> void print(T t)
	{
		System.out.println(t);
	}

}

public class Test {
	
	public static void main(String[] args)
	{
		A a = new A();
		B b = new B();
		GenericMethod2.print(b);
		
		Date d = new Date();
		
		
		/*String[] words = {"a", "b", "c", "d", "e"};
		Pair<String> mm = Arrayalg.minmax(words);
		
		System.out.println(mm.getFirst());
		System.out.println(mm.getSecond());
		
		String middleString = GenericMethod.getMiddle(words);
		System.out.println(middleString);*/
		
//		double[] middleDouble = GenericMethod.getMiddle();
		
		/*emptyClass[] a = new emptyClass[3];
		a[0] = new emptyClass();
		a[1] = new emptyClass();
		a[2] = new emptyClass();
		//GenericMethod.getMiddle(a);
		
		if (a[0] instanceof Comparable) 
			System.out.println("yes");*/
		
		
		
		
		
	}

}
