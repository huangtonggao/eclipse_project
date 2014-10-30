
import java.util.*;

enum Weekday {Monday, Tuesday, Wednesday, Thursday, Friday, Statuadu, Sunday}

class A
{
	@Override
	public int hashCode()
	{
		return val;
		
	}
	
	private int val;

	public A(int val) {
		super();
		this.val = val;
	}
}


public class Test {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Object[] o = new String[10];
		o[0] = "hello";
		o[1] = "world";
		
				
		System.out.println(Arrays.toString(o));
		
		String[] s = new String[10];
//		Object[] o1 = new Object[10];
		Object[] o1 = new String[10];

		
		s = (String[])o1;
		s[0] = "helloddd";
		System.out.println(o1[0]);
		
		
		
//		Object[] t = new String[10];
//		
//		String[] ss = (String[])t;
//		
//		
//		Object[] o = new String[10];
//		o[0] = "hello";
//		o[1] = "hello";
//		o[2] = "hello";
//		o[3] = "hello";
//		
//		System.out.println(Arrays.toString(o));
		
		
		
//		String[] s = new String[1];
//		Object[] o = new Object[1];
//		
//		System.out.println(s.getClass());
//		System.out.println(o.getClass());
//		
//		
//		System.out.println(s.getClass().getSuperclass());
//		System.out.println(o.getClass().getSuperclass());
		
		
		
//		String[] a1 = new  String[10];
//		a1[0] = "hello";
//		a1[1] = "world";
//		a1[2] = "welcome";
//				
//		HashSet<String> staff = new HashSet<String>(Arrays.asList(a1));
//		
//		String[] val = (String[])staff.toArray();
//		System.out.println(Arrays.toString(val));
//		
		
		
		

//		
//		ArrayList<Integer> a2  = new ArrayList<Integer>();
//		a2.addAll(a1);
//
//		System.out.println(a2);
//		a2.clear();
//		System.out.println(a2);
//		
//		System.out.println(a1);
		
		
		
		
		
//		ArrayList<String> string = new ArrayList<String>();
//		List<String> safeString = Collections.checkedList(string, String.class);
//		
//		safeString.add(new String("hello"));           
//		
//		String i = (String)safeString.get(0);
//		System.out.println(i);

		
		
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		map.put(1, 111);
//		map.put(2, 2);
//		map.put(3, 3);
//		map.put(4, 4);
//		map.put(5, 5);
//		map.put(6, 6);
//		
//		System.out.println(map);
//		
//		Map<Integer, Integer> map1 = Collections.unmodifiableMap(map);
//		
//		System.out.println(map1.get(1));
//		
//		map1.remove(1);
		
		
//		Set<Map.Entry<Integer, Integer>> entry = map.entrySet();
//		entry.clear();
//		
//		System.out.println(map);
		
		
		
//		LinkedList<Integer> list = new LinkedList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		System.out.println(list);
//		
//		List<Integer> subList = list.subList(1, 3);
//
//		System.out.println(subList);
//		subList.clear();
//		System.out.println(list);
		
		
		//IdentityHashMap<A, Integer> map = new IdentityHashMap<A, Integer>();
//		HashMap<A, Integer> map = new HashMap<A, Integer>();
//		
//		A a1 = new A(1);
//		A a2 = new A(2);
//		A a3 = new A(1);
//		
//		map.put(a1, 22);
//		map.put(a2, 2);
//		map.put(a3, 21);
//		
//		
//		
//		System.out.println(map);
		
		
		
		
//		EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
//		
//		System.out.println(always);
//		
//		always.remove(Weekday.Monday);
//		
//		
//		System.out.println(always);
		
		
		
//		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
//		map.put(1, 1);
//		map.put(10, 2);
//		map.put(3, 3);
//		map.put(4, 4);
//		map.put(15, 5);
//		map.put(62, 6);
//		map.put(7, 7);
//		map.put(4, 4);
//		map.put(4, 5);
//		map.put(4, 4);
//		System.out.println(map);
//		
//		Set<Map.Entry<Integer, Integer>> entry = map.entrySet();
//		
//		System.out.println(entry.size());
//		
//		for (Map.Entry<Integer, Integer> a : entry)
//		{
//			System.out.println(a.getKey()); }
//		
		
//		LinkedHashSet<String> set = new LinkedHashSet<String>();
//		
//		set.add("1");
//		set.add("3");
//		set.add("8");
//		set.add("2");
//		set.add("9");
//		set.add("3");
//		set.add("1");
//		set.add("3");
//		
//		Iterator setIterator = set.iterator();
//		
//		System.out.println(set);
//		
//		setIterator.next();
//		setIterator.remove();
//		
//		System.out.println(set);
		
		
		
	}

}
