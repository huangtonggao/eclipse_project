import java.lang.reflect.*;
import java.util.*;

public class ProxyTest {
	public static void main(String[] args) {
		   // 元对象(被代理对象)
		   ManagerImpl managerImpl = new ManagerImpl();
		   // 业务代理类
		   BusinessHandler securityHandler = new BusinessHandler(managerImpl);
		   // 获得代理类($Proxy0 extends Proxy implements Manager)的实例.
		   Manager managerProxy = (Manager) Proxy.newProxyInstance(managerImpl.getClass().getClassLoader(), 
		                                                           managerImpl.getClass().getInterfaces(), 
		                                                           securityHandler);
		   managerProxy.modify();
	}

}

class BusinessHandler implements InvocationHandler {
private Object object = null;
public BusinessHandler(Object object) {
   this.object = object;
    }

public Object invoke(Object proxy, Method method, Object[] args)
    throws Throwable {
   System.out.println("do something before method");
   Object ret = method.invoke(this.object, args);
   System.out.println("do something after method");
   return ret;
     }
}

