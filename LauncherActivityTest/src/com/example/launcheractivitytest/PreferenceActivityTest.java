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
		
		//ֱ�Ӽ���ѡ�����ò����ļ���Android3.0���Ƽ���ô�ã�����ѡ�������б�ѡ�����ù�ͬʹ��
		//addPreferencesFromResource(R.xml.preference);
		
		if (hasHeaders())
		{
			Button btn = new Button(this);
			btn.setText("���ò���");
			
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
			Toast.makeText(getActivity(), "��վ������" + website, Toast.LENGTH_LONG).show();
		}
	}
}
	
