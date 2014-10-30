import java.lang.reflect.*;
import java.util.*;

public class ProxyTest {
	public static void main(String[] args) {
		   // Ԫ����(���������)
		   ManagerImpl managerImpl = new ManagerImpl();
		   // ҵ�������
		   BusinessHandler securityHandler = new BusinessHandler(managerImpl);
		   // ��ô�����($Proxy0 extends Proxy implements Manager)��ʵ��.
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

