import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


class test
{
	public static int doubleNum(int n)
	{
		assert false : "assertTest false assertion";
		return n*n;
	}

	
}

public class assertTest {
	
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SecurityException, IOException
	{
		//assertTest.doubleNum(-1);
		/*assertTest t = new assertTest();
		ClassLoader cl = t.getClass().getClassLoader();
		cl.setDefaultAssertionStatus(true);*/
		
		ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
		
		/*Class cls = null;
		try {
			cls = Class.forName("test");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClassLoader loader = cls.getClassLoader();
		//loader.setDefaultAssertionStatus(true);
		loader.setClassAssertionStatus(cls.getName(), true);*/
		
		
		//new test().doubleNum(-1);
		/*Logger.getGlobal().setLevel(Level.INFO);
		Logger.getGlobal().severe("this is a test");*/
		FileHandler fh = new FileHandler("%u.log", true);
		fh.setFormatter(new SimpleFormatter());
		
		Logger myLogger = Logger.getLogger(assertTest.class.getName());
		myLogger.addHandler(fh);
		myLogger.setFilter(new Filter() {
			
			@Override
			public boolean isLoggable(LogRecord arg0) {
				// TODO Auto-generated method stub
				return true;
			}
		});
		
		/*myLogger.info("this is test");
		myLogger.severe("this is test");
		myLogger.warning("this is test");
		myLogger.fine("this is test");
		myLogger.finer("this is test");
		myLogger.finest("this is test");*/
		//myLogger.setLevel(Level.ALL);
		
		String str = System.getProperty("java.util.logging.config.class");
		System.out.println(str);
		str = System.getProperty("java.util.logging.config.file");
		System.out.println(str);
		
		Thread.dumpStack();
		
		
		
		
		
		
		
		
	}

}