package com.ub.pis.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

public class CustomButton extends Button{

	public CustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		Typeface face = Typeface.createFromAsset(context.getAssets(), ConstantsView.FUENTE);
		setTypeface(face);
	}
	public CustomButton(Context context) {
		super(context);
		Typeface face = Typeface.createFromAsset(context.getAssets(), ConstantsView.FUENTE);
		setTypeface(face);
	}

	public CustomButton(Context context, AttributeSet attrs, int style) {
		super(context, attrs, style);
		Typeface face = Typeface.createFromAsset(context.getAssets(), ConstantsView.FUENTE);
		setTypeface(face);
	}
}
