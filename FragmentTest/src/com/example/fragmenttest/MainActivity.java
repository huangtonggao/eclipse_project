package com.example.fragmenttest;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity 
                          implements BookListFragment.Callbacks{

	private boolean mTwoPane;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_list);
		
		if (findViewById(R.id.book_detail_container) != null)//大屏
		{
			mTwoPane = true;
			
			//让list响应
//			((BookListFragment)getFragmentManager()
//				.findFragmentById(R.id.book_list))
//				.setActivateOnItemClick(true);	//使能list选项可以单选			
		}
	}

	@Override
	public void onItemSelected(Integer id) { //Callbacks接口方法
		// TODO Auto-generated method stub
		if (mTwoPane)
		{
			Bundle arguments = new Bundle();
			arguments.putInt(BookDetailFragment.ITEM_ID, id);
			
			BookDetailFragment fragment = new BookDetailFragment();
			fragment.setArguments(arguments);
			
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			
			transaction.replace(R.id.book_detail_container, fragment);
			
			//transaction.addToBackStack(null);
			
			transaction.commit();	
		}
		else
		{
			Intent detailIntent = new Intent(this, BookDetailActivity.class);
			detailIntent.putExtra("item_id", id);
			startActivity(detailIntent);
		}
		
		
	}
}
