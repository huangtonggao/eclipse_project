package com.example.customdram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {

	public DrawView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public DrawView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}
	
	public float currentX = 0;
	public float currentY = 0;
	Paint p = new Paint();
	
	@Override
	public void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);		
		p.setColor(Color.RED);		
		canvas.drawCircle(currentX, currentY, 15, p);		
	}
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		currentX = event.getX();
		currentY = event.getY();
		invalidate();
		
		return true;
	}

}
