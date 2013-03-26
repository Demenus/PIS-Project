package com.ub.pis.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.ub.pis.R;

public class AtackButton extends View {

	private Paint contorno;
	private Paint interior;
	
	private Bitmap bm;
	
	private int centerX;
	private int centerY;
	private int radiusButton;
	
	private boolean principi;
	
	private OnClickListener listener;
	
	public static interface OnClickListener {
		public void onClick();
	}
	
	public AtackButton(Context context, AttributeSet attrs) {
		super(context, attrs); 
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.AtackButton, 0, 0);
	    int color = ta.getColor(R.styleable.AtackButton_circleColor, 0);
	    int refDw = ta.getResourceId(R.styleable.AtackButton_abilityImage, 0);
	    if(refDw!=0) { 
	    	bm  = BitmapFactory.decodeResource(context.getResources(),refDw);
	    }else{
	    	bm = null;
	    }
	    
	    
		init(color);
	}
	
	public void init(int color) {
		contorno = new Paint(Paint.ANTI_ALIAS_FLAG);
		contorno.setColor(Color.YELLOW);
		int con = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics());
		contorno.setStrokeWidth(con);
		contorno.setStyle(Paint.Style.STROKE);
		
		interior = new Paint(Paint.ANTI_ALIAS_FLAG);
		interior.setColor(color);
		interior.setStrokeWidth(0);
		interior.setStyle(Paint.Style.FILL);
		
		principi = true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.save();
		if(principi) {
			centerX = getWidth()/2;
			centerY = getHeight()/2;
			
			radiusButton = (int) ((getWidth()-contorno.getStrokeWidth())/2);
			
			int t = (int) Math.sqrt((radiusButton*radiusButton)/2)*2;
			if(bm!=null) {
				bm = Bitmap.createScaledBitmap(bm, t, t, true);
			}
			
			principi = false;
		}
		canvas.drawCircle(centerX, centerY, radiusButton, contorno);
		canvas.drawCircle(centerX, centerY, radiusButton, interior);
		if(bm!=null) {
			canvas.drawBitmap(bm, (getWidth()-bm.getWidth())/2, (getHeight()-bm.getHeight())/2, null);
		}
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		final int posX = (int) event.getX();
		final int posY = (int) event.getY();
		final int action = event.getAction();
		switch (action & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_UP:
				double abs = Math.sqrt((posX-centerX)*(posX-centerX)+(posY-centerY)*(posY-centerY));
				if(abs<=radiusButton && listener != null) {
					listener.onClick();
				}
				return true;
		}
		return true;
	}
	
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	public void setImage(int ref) {
		bm  = BitmapFactory.decodeResource(getResources(),ref);
		principi = true;
		invalidate();
	}

}
