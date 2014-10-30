import java.util.ArrayList;
import java.util.List;


interface Pair<T>
{
	void set(T t);
	T get();
}
class Box<T> implements Pair<T>
{
	private T obj;
	
	public Box(T obj) {
		super();
		this.obj = obj;
	}
	public void set(T t){
		this.obj = t;
	}
	public T get()
	{
		return this.obj;
	}
}

class A<T>
{
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
}

class B
{
	public void print(A<? extends String> t)
	{
		
	}
	
}

class WildcardError {

    void foo(List<? super Number> i) {
    //i.set(0, i.get(0));
    i.get(0);
    i.add(0, 1);
    //i.add(0, element);
    
    }
    
    public  <T> void fooHelper(List<T> l) {
//        l.set(0, l.get(0));
    	
    	l.set(0, l.get(0));
    }
}



public class Test {
	public static void main(String[] args) {
		//@SuppressWarnings("unchecked")
		Pair<String> p = new Box<String>("hello");
		System.out.println(p.get());
		
//		A a = new A<String>();
		A<String> a1 = new A<String>();
		
		System.out.println(a1.getClass());
		
		ArrayList<String> list  = new ArrayList<String>();
		
		list.add("hello");
		
		ArrayList<Object> bbbb = new ArrayList<Object>();
		bbbb.add("String");
		
		
		
		ArrayList<? super Number> i = new ArrayList<Number>();
		ArrayList<? super Integer> i1 = i;
		
		
		
		
		
		
		
	}

}
