
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
		prefer.put("title", "test"); //���û���Ŀ¼/htg����Ӽ�ֵ

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
		
		//�Ƴ����нڵ㣨�������ӽڵ�
		/*try
		{
			Preferences.userRoot().removeNode(); //root�ǲ��ܱ��Ƴ��ģ��ô��ᱨ��
			//���Ի�ȡָ�������֣�Ȼ����ͨ��root��������Ӧ���ӽڵ㣬Ȼ���Ƴ�
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
		}*/
		
		
		
		
		
	}
	
	private Preferences prefer;
	

}


