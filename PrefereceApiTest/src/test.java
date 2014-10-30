
import java.io.FileOutputStream;
import java.util.prefs.Preferences;


public class test {
	public static void main(String[] args)
	{
		test f = new test();
		f.setPreferences();
	}
	
	public void setPreferences()
	{
		//System.out.println("htg." + this.getClass().getName());
		prefer = Preferences.userRoot().node("htg." + this.getClass().getName());
		Preferences.userRoot().node("htg." + this.getClass().getName()+ ".sunzi");
		prefer = Preferences.userRoot();
		
		try
		{
			//String[] str = Preferences.userRoot().childrenNames();
			String[] str = prefer.childrenNames();
			for (String s : str)
			{
				System.out.println(s);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		//prefer = Preferences.userRoot().node("htg.test");
		prefer = Preferences.userRoot().node("htg");
		prefer.put("title", "test"); //在用户根目录/htg下添加键值

		FileOutputStream outFile = null;
		try
		{
			outFile = new FileOutputStream("output");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		try
		{   prefer = Preferences.userRoot();
			prefer.exportSubtree(outFile);
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
		//移除所有节点（包括）子节点
		/*try
		{
			Preferences.userRoot().removeNode(); //root是不能被移除的，该处会报错
			//可以获取指树的名字，然后在通过root索引到相应的子节点，然后移除
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
		}*/
		
		
		
		
		
	}
	
	private Preferences prefer;
	

}


