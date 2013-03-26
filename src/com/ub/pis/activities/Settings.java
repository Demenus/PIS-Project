package com.ub.pis.activities;

import java.util.Locale;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ub.pis.R;

public class Settings extends BaseActivity {
	private Button language_button;
	private Locale locale;
	private Button quit_button;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		locale = Locale.getDefault();
		initActivity();
	}
	
	public void initActivity() {
		setContentView(R.layout.activity_settings);
		language_button = (Button)findViewById(R.id.button1);
		language_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(locale.getLanguage().equals("es")) locale = new Locale("ca");
				else if(locale.getLanguage().equals("ca"))locale = new Locale("en");
				else if(locale.getLanguage().equals("en"))locale = new Locale("es");
			    Locale.setDefault(locale);
			    Configuration config = new Configuration();
			    config.locale = locale; 
			    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
			    
		    	initActivity();
			}
		});
		quit_button = (Button)findViewById(R.id.quit_button);
		quit_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	public void refresh(Class<?> classe) {
	    finish();
	    iniciarActivity(classe);
	}

}
