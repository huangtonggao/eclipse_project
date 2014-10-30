

//package htg_class;

public class Manager extends Employee
{
    public Manager(String n, double s, int year, int month, int day)
	{
	    super(n, s, year, month, day);
		bonus = 1000;
	}
	public Manager()
	{
	    super("noName", 0, 0, 0, 0);
		bonus = 0;
	}
	
	public double getBonus()
	{
	    return bonus;
	}
	public void setBonus(double b)
	{
	    bonus = b;
	}
	public double getSalary()
	{
	    double salary = super.getSalary();
		salary += bonus;
		return salary;
	}
	
	
	private double bonus;


}

