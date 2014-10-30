package ExternalizableTest;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A implements Serializable, Externalizable
{
	private String name;
	private int age;
	
	public A(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("A constructor invoked, with parameters");
	}
	
	public A()
	{
		System.out.println("A constructor invoked, no parameter");
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
	
	 private void writeObject(java.io.ObjectOutputStream out)
		     throws IOException
	 {
		 System.out.println("writeObject invoked");
     }

	 private void readObject(java.io.ObjectInputStream in)
		     throws IOException, ClassNotFoundException
	 {
		 System.out.println("readObject invoked");		    
	 }


	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("writeExternal invoked");
		
	}


	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("readExternal invoked");
		
	}
	
}


public class ExternalizableTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/ExternalizableTest/file.txt"));
		
		A a1 = new A("aaa", 1);
		
		out.writeObject(a1);
		
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/ExternalizableTest/file.txt"));
		A aCopy = (A)in.readObject();
		in.close();
		
		
	}

}

