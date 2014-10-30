package com.example.fragmenttest;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class BookDetailFragment extends Fragment {
	
	public static final String ITEM_ID = "item_id";
	private BookContent.Book book;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		if (getArguments().containsKey(ITEM_ID))
		{
			book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater
				.inflate(R.layout.fragment_book_detail, container, false);
		if (book != null)
		{
			 TextView tv1 = (TextView)rootView.findViewById(R.id.book_title);
			 tv1.setText(book.title);
			 
			 TextView tv2 = (TextView)rootView.findViewById(R.id.book_desc);
			 tv2.setText(book.desc);
		}
		
		return rootView;
	}

}
