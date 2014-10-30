package com.example;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultActivity extends ExpandableListActivity {

	private String[] province = new String[]{
			"江苏", "湖南", "浙江"
	};
	private String[][] cities = new String[][]{
			{"南京", "苏州", "无锡", "泰州"},
			{"长沙", "岳阳", "衡阳"},
			{"宁波", "温州", "金华", "嘉兴"}
			
	};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ExpandableListAdapter adapter = new BaseExpandableListAdapter(){
			
			public TextView getTextView()
			{
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
											ViewGroup.LayoutParams.MATCH_PARENT, 64);

				TextView textView = new TextView(ResultActivity.this);
				textView.setLayoutParams(lp);
				
				textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
				textView.setPadding(36, 0, 0, 0);
				textView.setTextSize(20);
				
				return textView;
				
			}
			
			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout layout = new LinearLayout(ResultActivity.this);
				layout.setOrientation(LinearLayout.HORIZONTAL);
				
				ImageView logo = new ImageView(ResultActivity.this);
				layout.addView(logo);
				
				TextView textView = getTextView();
				textView.setText(getGroup(groupPosition).toString());
				layout.addView(textView);
				
				return layout;
			}
			
			@Override
			public long getGroupId(int groupPosition) {
				// TODO Auto-generated method stub
				return groupPosition;
			}
			
			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return province.length;
			}
			
			@Override
			public Object getGroup(int groupPosition) {
				// TODO Auto-generated method stub
				return province[groupPosition];
			}
			
			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO Auto-generated method stub
				return cities[groupPosition].length;
			}
			
			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView textView = getTextView();
				textView.setText(getChild(groupPosition, childPosition).toString());
				textView.setTextSize(10);
				return textView;
			}
			
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return childPosition;
			}
			
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return cities[groupPosition][childPosition];
			}
		};
		
		setListAdapter(adapter);
		
		getExpandableListView().setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				//获取启动该A车提比他要之前的Activity对应的Intent，即MainActivity携带过来的Intent
				Intent intent = getIntent();
				intent.putExtra("city", cities[groupPosition][childPosition]);
				
				//ResultActivity.this.setResult(1, intent); //resultCode为1
				
				//ResultActivity.this.finish();
				
				setResult(1, intent);
				finish();
				
				return false;
			}
		});
		
		
	}
	
//	@Override
//	public boolean onChildClick(ExpandableListView parent, View v,
//			int groupPosition, int childPosition, long id) {
//		// TODO Auto-generated method stub
//		Intent intent = getIntent();
//		intent.putExtra("city", cities[groupPosition][childPosition]);
//		
//		ResultActivity.this.setResult(1, intent); //resultCode为1
//		
//		ResultActivity.this.finish();
//
//		
//		return super.onChildClick(parent, v, groupPosition, childPosition, id);
//	}


}
