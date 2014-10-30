package com.example.fragmenttest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookContent {
	
	//�ڲ���
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
	
	//ʹ��List���ϼ�¼ϵͳ������Book����
	public static List<Book> ITEMS = new ArrayList<Book>();
	//ʹ��Map���ϼ�¼ϵͳ������Book����
	public static Map<Integer, Book> ITEM_MAP = new HashMap<Integer, Book>();
	
	static
	{
		addItem(new Book(1, "���Android����", "�Ȿ�齲�ú�ϸ���ʺ���Android������ѧ��"));
		addItem(new Book(2, "��ʫ�δ�", "�ռ���������������������ƪ"));
		addItem(new Book(3, "������", "��������˱���ΰ����ѧ�ҡ�˼��ҡ����μҵ�ΰ��һ��"));		
	}
	
	
	

}
