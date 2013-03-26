package com.ub.pis.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.ub.pis.R;

public class MainActivity extends BaseActivity {
	private TextView textRegister;
	private Button login_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initActivity();
	}
	
	
	private void initActivity() {
		setContentView(R.layout.activity_main);
		textRegister = (TextView)findViewById(R.id.register_text);
		login_button = (Button)findViewById(R.id.login_buton);
		textRegister.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				iniciarActivity(Register.class);
			}
		});
		login_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivityForResult(new Intent(getApplicationContext(), MenuPrincipal.class), 1);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		Log.v("RESULT", "HOLAA???");
		initActivity();
		super.onActivityResult(requestCode, resultCode, data);
	}
}
