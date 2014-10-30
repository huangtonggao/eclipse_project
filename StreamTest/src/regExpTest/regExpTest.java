package regExpTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regExpTest {
	public static void main(String[] args) {
		
		String input = "12345687";
		
		Pattern pattern = Pattern.compile("(?<=\\d)(\\d{3})+\\b");
		Matcher m = pattern.matcher(input);
		
		while (m.find())
		{
			System.out.println(m.start());
			System.out.println(m.end());
			
			System.out.println(input.substring(m.start(), m.end()));
		}
		
		
//		System.out.println(m.groupCount());
//		
//		System.out.println(m.matches());

//		while (m.find())
//		{
////			System.out.println("start: " + m.start());
////			System.out.println("end: " + m.end());
////			System.out.println("hi this is hi hi hii".substring(m.start(), m.end()));
//			String output = m.replaceFirst("#"); //会重置匹配器，下次find时，会从头开始匹配
//			System.out.println(output);
//			m = pattern.matcher(output);  //必须用output更新下Matcher类对象，不然m还是匹配的"hi this is hi hi hii"，不然会死循环
//			
//		}
//		
//		String output = m.replaceFirst("#");
//		System.out.println(output);
				
		
		
		
		
		
		
	}

}
