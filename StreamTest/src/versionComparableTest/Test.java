package versionComparableTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class A implements Serializable
{
	private static final long serialVersionUID = -946063198828303242L;
	
	private String name;
	private int age;	
	private double salary;
	//private double height;
	private double width;
	
	public A(String name, int age, double salary, double height, double width) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.width = width;
		//this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}	

	/*public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}*/
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name: " + name + " age: " + age + "salary: " + salary + "width: " + width;
	}
	

	
	
	
	
}

public class Test {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
//		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/versionComparableTest/test.txt"));
//		
//		A a1 = new A("aaa", 1, 2.0, 3.0);
//		
//		out.writeObject(a1);
//		out.close();	
		
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/versionComparableTest/test.txt"));
		
		A a2 = (A)input.readObject();
		input.close();
		
		System.out.println(a2);
		
		
			
		
	}

}










