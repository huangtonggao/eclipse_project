package com.example.launcheractivitytest;

import java.util.List;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.Toast;

public class PreferenceActivityTest extends PreferenceActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//直接加载选项设置布局文件，Android3.0后不推荐这么用，建议选项设置列表、选项设置共同使用
		//addPreferencesFromResource(R.xml.preference);
		
		if (hasHeaders())
		{
			Button btn = new Button(this);
			btn.setText("设置操作");
			
			setListFooter(btn);
		}
	}
	
	@Override
	public void onBuildHeaders(List<Header> target) {
		// TODO Auto-generated method stub
		super.onBuildHeaders(target);
		
		loadHeadersFromResource(R.xml.preference_headers, target);
	}
	
	public static class Prefs1Fragment extends PreferenceFragment
	{
		@Override
		public void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.preference);
		}
	}
	public static class Prefs2Fragment extends PreferenceFragment
	{
		@Override
		public void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.display_prefs);
			
			String website = getArguments().getString("website");
			Toast.makeText(getActivity(), "网站域名是" + website, Toast.LENGTH_LONG).show();
		}
	}
}
	
