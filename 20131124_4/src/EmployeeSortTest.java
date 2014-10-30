import java.util.*;

public class EmployeeSortTest {
	public static void main(String[] args)
	{
		Employee[] staff = new Employee[4];
		
		staff[0] = new Employee("hhh", 3);
		staff[1] = new Employee("ttt", 1);
		staff[2] = new Manager("jjj", 0);
		
		staff[3] = new Manager("ggg", -1);
		
		Arrays.sort(staff);
		
		for (Employee e : staff)
		{
			System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
		}
	}
}

class Employee implements Comparable<Employee> //实现接口
{
	public Employee(String n, double s)
	{
		name = n;
		salary = s;
		rank = 0;
	}
	
	public String getName()
	{
		return name;
	}
	public double getSalary()
	{
		return salary;
	}
	public void raiseSalary(double byPercent)
	{
		double raise = salary*byPercent/100;
		salary += raise;
	}
	public int compareTo(Employee other) //实现方法
	{
		if (getRank() > other.getRank())
		{
			return 1;
		}
		if (getRank() < other.getRank())
		{
			return -1;
		}

		if (salary < other.salary) return -1;
		if (salary > other.salary) return 1;
		return 0;
	}
	public void setRank(int i)
	{
		rank = i;
	}
	public int getRank()
	{
		return rank;
	}
	
	private String name;
	private double salary;
	
	private int rank; //指示该类处于什么层次，方便设置Manager永远大于Employee
}

class Manager extends Employee
{
	public Manager(String s, double salary)
	{
		super(s, salary);
		setRank(1);
	}
	public int compareTo(Manager other) 
	{
		if (getRank() > other.getRank())
		{
			return 1;
		}
		if (getRank() < other.getRank())
		{
			return -1;
		}
		if (getSalary() < other.getSalary()) return -1;
		if (getSalary() > other.getSalary()) return 1;
		return 0;		
		
		
		
	}
	
	
}

