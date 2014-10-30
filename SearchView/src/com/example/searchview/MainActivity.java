package com.example.searchview;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnQueryTextListener {
	
	private SearchView sv;
	private ListView lv;
	private EditText et;
	
	private final String[] str = {"aaa", "bbb", "back", "balala", "ccc"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sv = (SearchView)findViewById(R.id.searchView);
		lv = (ListView)findViewById(R.id.listView);
		et = (EditText)findViewById(R.id.editText);
		
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str));
		lv.setTextFilterEnabled(true);
		
		sv.setIconifiedByDefault(false);
		
		sv.setOnQueryTextListener(this);
		
		sv.setSubmitButtonEnabled(true);
		
		sv.setQueryHint("find");
		
		
		
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		//Toast.makeText(this, "查询的字符串为" + query, Toast.LENGTH_SHORT);
		et.setText("查询的字符串为" + query);
		
		return true;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		if (TextUtils.isEmpty(newText))
		{
			lv.clearTextFilter();
		}
		else
		{
			lv.setFilterText(newText);
			Log.i("Test", "newText is " + newText + " textFilter is " + 
			               lv.isTextFilterEnabled());
		}

		return false;
	}
}
