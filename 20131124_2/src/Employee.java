//package htg_class;

import java.util.*;

public class Employee
{
    public Employee(String n, double s, int year, int month, int day)
	{
	    name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
		hireDay = calendar.getTime();	
		
		id = nextId;
		nextId++;
	}
	public Employee()
	{
	    this("noName", 0, 0, 0, 0);
	}
	
	public String getName()
	{
	    return name;
	}
	public void setName(String s)
	{
	    name = s;
	}
	public double getSalary()
	{
	    return salary;
	}
	public void setSalary(double s)
	{
	    salary = s;
	}
	public Date getHireDay()
	{
	    return (Date)hireDay.clone();
	}
	public void raiseSalary(double byPercent)
	{
	    double raise = salary*byPercent/100;
		salary += raise;
	}
	
	public static int getNextId()
	{
	    return nextId;
	}
	public int getId()
	{
	    return id;
	}
	
	public void printTest(String str, int i)
	{
		System.out.println(str + i);
	}
	
	
	
	/*public static void main(String[] args)
	{
	    Employee e = new Employee("Harry", 5000, 2013, 10, 10);
		System.out.println(e.getName() + " " + e.getSalary());
	*/
	
	private String name;
	private double salary;
	private Date hireDay;
	
	private int id;
	private static int nextId = 0;

	public static int nextId2 = 888;
}