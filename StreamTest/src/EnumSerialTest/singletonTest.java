package EnumSerialTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class singleton1 implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4028618552459836818L;
	
	public static final singleton1 S = new singleton1(1);
	public static final singleton1 L = new singleton1(2);
	
	private singleton1(int value)
	{
		System.out.println("singleton1 constructor invoked, value = " + value);
		this.value = value;
	}
	private int value;
	
	private singleton1(){
		System.out.println("defalut constructor invoked");
	}
	
	protected Object readResolve() {
		// TODO Auto-generated method stub
		System.out.println("readResolved invoked, value = " + value);
		
		switch(value)
		{
		    case 1: return S;
		    case 2: return L;		    
		}
		return null;

	}
//	@Override
//	public String toString()
//	{
//		return "value = " + value;
//		
//	}
	
}


public class singletonTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/EnumSerialTest/test.txt"));
		
		singleton1 s1 = singleton1.S;
		System.out.println(s1);
		
		out.writeObject(s1);
		out.close();
		
		ObjectInputStream in  = new ObjectInputStream(new FileInputStream("src/EnumSerialTest/test.txt"));
		singleton1 sCopy = (singleton1)in.readObject();
		
		System.out.println(sCopy);
		
		in.close();
		
	}
	

}






