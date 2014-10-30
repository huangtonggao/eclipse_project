import java.util.*;

public class CloneTest {
	public static void main(String[] args)
	{
		try
		{
			Employee original = new Employee("hhh", 2000);
			original.setHireDay(2000, 1, 1);
			
			Employee copy = original.clone();
			copy.raiseSalary(10);
			copy.setHireDay(2011, 1, 5);
			
			System.out.println("original = " + original.toString());
			System.out.println("copy = " + copy.toString());			
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}

}

class Employee implements Cloneable
{
	public Employee(String str, double s)
	{
		name = str;
		salary =s;
		hireDay = new Date();		
	}
	
	public Employee clone() throws CloneNotSupportedException
	{
		Employee e = (Employee)super.clone();
		
		e.hireDay = (Date)hireDay.clone();
		
		return e;		
	}
	public void setHireDay(int year, int month, int day)
	{
		Date newHireDay = new GregorianCalendar(year, month-1, day).getTime();
		
		hireDay.setTime(newHireDay.getTime());
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	public double getSalary()
	{
		return salary;
	}
	public String toString()
	{
		return "Employee[name = " + name + ", salary = " + salary + ", hireDay" + hireDay;
	}
	
	private String name;
	private double salary;
	private Date hireDay;
}
