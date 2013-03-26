package com.ub.pis.activities;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.ub.pis.R;

public class Characters extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_characters);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.characters, menu);
		return true;
	}

}
