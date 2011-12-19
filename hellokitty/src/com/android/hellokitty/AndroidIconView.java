package com.android.hellokitty;

import android.R.*;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

public class AndroidIconView  extends View implements View.OnTouchListener{
	
	private Bitmap kittyclose;
	private Bitmap kittyopen;
	private Bitmap kittycloseL;
	private Bitmap kittyopenL;
	private Bitmap hairball;
	private Bitmap iphone4s;
	private Bitmap candy;
	private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private PointF point = new PointF();
	private Path path = new Path();
	private boolean open = true;
	private boolean left = false;
	
	float previosX = 0.0f;
	
	public AndroidIconView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		
		
		
		kittyclose = BitmapFactory.decodeResource(getResources(), R.drawable.kitty1);
		kittyopen = BitmapFactory.decodeResource(getResources(), R.drawable.kitty2);
		kittycloseL = BitmapFactory.decodeResource(getResources(), R.drawable.kitty3);
		kittyopenL = BitmapFactory.decodeResource(getResources(), R.drawable.kitty4);
		
		candy = BitmapFactory.decodeResource(getResources(), R.drawable.candy);
		hairball= BitmapFactory.decodeResource(getResources(), R.drawable.hairball);
		iphone4s= BitmapFactory.decodeResource(getResources(), R.drawable.iphone4s);
		
		point.set(0,0);
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(65);
		setOnTouchListener(this);
	}
	
	public boolean onTouch(View v, MotionEvent event) {
		switch(event.getAction()) {
	
		case MotionEvent.ACTION_MOVE:
			point.set(event.getX(), event.getY());
			path.lineTo(event.getX(), event.getY());
			
			//check the new xposition against previous
			if(previosX < event.getX()){
				left = false;
				
			}
			
			else if(previosX > event.getX()){
				left = true;
			}
			previosX = event.getX();
			
			
			//Open or Close switcher
			if(open) open = false;
			else if (!open) open = true;
			
			//force redraw
			invalidate();
			return true;

		default:
			return true;
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		//set put candy and hairball
		canvas.drawBitmap(candy,300,50, paint);
		canvas.drawBitmap(candy,40,180, paint);
		canvas.drawBitmap(iphone4s,350,192, paint);
		canvas.drawBitmap(candy,125,300, paint);
		canvas.drawBitmap(candy,60,340, paint);
		canvas.drawBitmap(hairball,180,400, paint);
		canvas.drawBitmap(candy,325,480, paint);
		
		canvas.translate(40, 40);
		canvas.drawPath(path, paint);
		//Clear position
		canvas.restore();
		
		
		//check the direction and open/close for proper image
		if(!left){
			
			if(!open){
				canvas.drawBitmap(kittyclose,point.x,point.y, paint);
			}
			
			else{
				canvas.drawBitmap(kittyopen,point.x,point.y, paint);
			}
		}
		
		else{
			
			if(!open){
				canvas.drawBitmap(kittycloseL,point.x,point.y, paint);
			}
			
			else{
				canvas.drawBitmap(kittyopenL,point.x,point.y, paint);
			}
		}	
	}

}
