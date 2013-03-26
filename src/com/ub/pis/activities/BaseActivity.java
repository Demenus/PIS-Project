package com.ub.pis.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class BaseActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//write here code comun in activites
		super.onCreate(savedInstanceState);
	}
	
	public void iniciarActivity(Class<?> classe) {
	 	Intent i = new Intent(this, classe);
        startActivity(i);
	}
}
