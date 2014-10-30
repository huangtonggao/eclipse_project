import java.util.ArrayList;
import java.util.List;



class CalcCount
{
	public static <T extends Number> int myCount(T[] a)
	{
		if (a == null || a.length == 0) return 0;
		int count = 0;
		for (T index : a)
		{
			if (index.intValue() % 2 == 1)
				count++;
		}	
		
		return count;		
	}
	
	public static <T> void exchange(ArrayList<T> a, int pos1, int pos2)
	{
		T temp;
		temp = a.get(pos1);
		
		a.set(pos1, a.get(pos2));
		a.set(pos2, temp);
		
	}
	
	public static void print(List<? extends Number> list) {
	    for (Number n : list)
	        System.out.print(n + " ");
	    System.out.println();
	}
}

public class Test {
	public static void main(String[] args) {
		
		ArrayList<String> s = new ArrayList<>();
		s.add("hello");
		s.add("world");
		s.add("welcome");
		s.add("test");
		System.out.println(s.toString());
		
		CalcCount.exchange(s, 0, 1);
		System.out.println(s.toString());
		
		
		
//		Double[] i = {1.0,2.0,4.0,5.0,3.1};
//		
//		int count = CalcCount.myCount(i);
//		System.out.println(count);
		
		
		
	}

}
