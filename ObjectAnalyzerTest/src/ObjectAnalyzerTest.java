import   java.lang.reflect.*;   
import   java.util.*;   
import java.util.Date;

class A
{
    private int a1 = 1;
	public  int a2 = 2;
	protected int a3 = 3;
}
class AA extends A
{
    private double aa1 = 4;
	public double aa2 = 5;
	protected double aa3 = 6;
	
	public Date date = new Date();
}
  
public class ObjectAnalyzerTest   
{   
public static void main(String[] args)   
 {    
 /*ArrayList<Integer> squares = new ArrayList<Integer>();
 for (int i = 1; i <= 5; i++)squares.add(i*i);
 System.out.println(new   ObjectAnalyzer().toString(squares));   */ 
   
 AA aa = new AA();
 String str = new String("hello");
 System.out.println(new ObjectAnalyzer().toString(aa));   
 
 }
}   
  
class ObjectAnalyzer   
{   
 
public String toString(Object obj)   
{   
 if   (obj==null) return   "null";   
 if(visited.contains(obj)) return   "...";   
 visited.add(obj);   
 Class cl = obj.getClass();   
 if(cl == String.class) return (String)obj;   //////////////去掉  给个String对象测试下
 if(cl.isArray())   
 {   
String r = cl.getComponentType() + "[]{";   
for(int i = 0;i < Array.getLength(obj); i++)   
{   
if(i>0) r +=",";   
Object val=Array.get(obj,i);   
if(cl.getComponentType().isPrimitive()) r += val;   
else r += toString(val);   
 }   
return r + "}";   
}   
  
String r = cl.getName();   
do   
{   
r += "[";   
Field[] fields = cl.getDeclaredFields();   
AccessibleObject.setAccessible(fields,true);   
for(Field f : fields)   
{   
if(!Modifier.isStatic(f.getModifiers()))   
{   
if(!r.endsWith("[")) r += ",";   
r += f.getName( )+  "=";   
try   
{   
 Class t = f.getType();   
 Object val = f.get(obj);   
 if(t.isPrimitive()) r += val;   
else r += val.toString();   
}   
catch (Exception e){e.printStackTrace();}   
  }   
 }
 r += "]";
 cl = cl.getSuperclass();
}
while (cl != null);
return r;
}
private ArrayList<Object> visited = new ArrayList<Object>();
}


