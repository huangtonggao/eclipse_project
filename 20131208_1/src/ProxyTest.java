import java.util.*;
import java.lang.reflect.*;

public class ProxyTest {
	
	public static void main(String[] args)
	{
		Ainterface interF = new interfaceImp();
		if (interF.getClass() == interfaceImp.class)
		{
			System.out.println("equal");
		}
		interF.printInterface();
		
		Object obj1 = interF;

		
		
		MyHandler myhandler = new MyHandler(interF);
		Ainterface proxy = (Ainterface)Proxy.newProxyInstance(interF.getClass().getClassLoader(), 
	                                              interF.getClass().getInterfaces(),
	                                              myhandler);
		proxy.printInterface();
		
		
		
	}
}

class MyHandler implements InvocationHandler
{
	public MyHandler(Object obj)
	{
		this.obj = obj;
	}
	
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
	{
		System.out.println("pre invoke");
		Object rtn = m.invoke(this.obj, args);
		System.out.println("after invoke");
		
		return rtn;
	}
	
	
	private Object obj;
}
