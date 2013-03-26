package com.ub.pis.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomEditText extends EditText{

	public CustomEditText(Context context) {
		super(context);
		Typeface face = Typeface.createFromAsset(context.getAssets(), ConstantsView.FUENTE);
		setTypeface(face);
	}
	
	public CustomEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		Typeface face = Typeface.createFromAsset(context.getAssets(), ConstantsView.FUENTE);
		setTypeface(face);
	}
	
	public CustomEditText(Context context, AttributeSet attrs, int style) {
		super(context, attrs, style);
		Typeface face = Typeface.createFromAsset(context.getAssets(), ConstantsView.FUENTE);
		setTypeface(face);
	}

}
