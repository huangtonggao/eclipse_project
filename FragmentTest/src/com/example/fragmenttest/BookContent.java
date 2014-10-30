package com.example.fragmenttest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookContent {
	
	//内部类
	public static class Book
	{
		public Integer id;
		public String title;
		public String desc;
		public Book(Integer id, String title, String desc) {
			super();
			this.id = id;
			this.title = title;
			this.desc = desc;
		}
		
		@Override
		public String toString()
		{
			return title;
		}		
	}
	
	private static void addItem(Book book)
	{
		ITEMS.add(book);
		ITEM_MAP.put(book.id, book);
	}
	
	//使用List集合记录系统包含的Book对象
	public static List<Book> ITEMS = new ArrayList<Book>();
	//使用Map集合记录系统包含的Book对象
	public static Map<Integer, Book> ITEM_MAP = new HashMap<Integer, Book>();
	
	static
	{
		addItem(new Book(1, "疯狂Android讲义", "这本书讲得很细，适合于Android开发初学者"));
		addItem(new Book(2, "唐诗宋词", "收集了唐宋以来，各名家名篇"));
		addItem(new Book(3, "苏轼传", "本书介绍了北宋伟大文学家、思想家、政治家的伟大一生"));		
	}
	
	
	

}
