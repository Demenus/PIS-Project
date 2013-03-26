package com.ub.pis.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ub.pis.R;

public class MenuPrincipal extends BaseActivity {
	private Button options_button;
	private Button playNow_button;
	private Button quit_button;
	private Button highscores_button;
	private Button shop_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i("onCreated", "onCreated");
		initActivity();
	}
	
	
	
	public void initActivity() {
		setContentView(R.layout.activity_menu_principal);
		highscores_button = (Button)findViewById(R.id.highscores_button);
		options_button = (Button)findViewById(R.id.options_button);
		playNow_button = (Button)findViewById(R.id.playNow_button);
		shop_button = (Button)findViewById(R.id.shop_button);
		quit_button = (Button)findViewById(R.id.quit_button);
		quit_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					finish();
			}
		});
		shop_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					iniciarActivity(Shop.class);
			}
		});
		options_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivityForResult(new Intent(getApplicationContext(),Settings.class), 1);
			}
		});
		playNow_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				iniciarActivity(ChooseStage.class);
			}
		});
		highscores_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				iniciarActivity(Highscores.class);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		
		initActivity();
		super.onActivityResult(requestCode, resultCode, data);
	}
}
