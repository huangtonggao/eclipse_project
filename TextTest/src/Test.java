import java.util.Date;
class A implements Cloneable
{
	public A clone() throws CloneNotSupportedException  
	{
	    A a = (A)super.clone();
		
		a.hireDate = (Date)hireDate.clone();
	    return a;
	}
	private Date hireDate;
	public int a1 = 1;
	{
	    hireDate = new Date();
	}
}

class AA extends A
{
    public AA(int i)
	{
	    aa_data = i;
	}
    
    public int aa_data;
}
class test
{
    public static void main(String... args)
	{
		AA aa1 = new AA(111);
		AA aa2 = null;
		try
		{
		    aa2 = (AA)aa1.clone();
		}
		catch (Exception e1)
		{
		    e1.printStackTrace();
		}
		
		System.out.println(aa2.aa_data);
	}
}