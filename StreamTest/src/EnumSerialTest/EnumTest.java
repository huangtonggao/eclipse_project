package EnumSerialTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;

enum Orientation
{
	H(1),V(2);
	private Orientation()
	{
		System.out.println("default constructor invoked");
	}
	
	private Orientation(int value)
	{
		System.out.println("Orientation constructor invoked, value = " + value);
		this.value = value;
	}
	private int value;
	
	private Object readResolve() throws ObjectStreamException {
		  // Switch on this instance's value to figure out which class variable
		  // this is meant to match
		System.out.println("readResolve invoked");
		  switch(value) {
		   case 1: return H;
		   case 2: return V;
		   
		  }
		  return null;
	}
}



public class EnumTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/EnumSerialTest/test.txt"));
		Orientation original = Orientation.V;
		
		System.out.println(original);
		
		out.writeObject(original);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/EnumSerialTest/test.txt"));
		Orientation saved = (Orientation) in.readObject();
		System.out.println(saved == Orientation.V);
		
		in.close();
		
	}
	

}
