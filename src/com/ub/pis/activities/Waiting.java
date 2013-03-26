package com.ub.pis.activities;

import java.util.Timer;
import java.util.TimerTask;

import com.ub.pis.R;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class Waiting extends BaseActivity {

	private TextView waiting_text;
	private View bola1;
	private View bola2;
	private View bola3;
	
	private Timer myTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_waiting);
		waiting_text = (TextView) findViewById(R.id.waiting_text);
		bola1 = findViewById(R.id.bola1);
		bola2 = findViewById(R.id.bola2);
		bola3 = findViewById(R.id.bola3);
		waiting_text.setTextColor(Color.YELLOW);
		myTimer=new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
	            public void run() {
                    iniciarActivity(GameActivity.class);	
            		//Toast.makeText(getBaseContext(), "Comienza la partida!", Toast.LENGTH_SHORT).show();
            		finish();
	            }
        }, 5000);
	}
	
	@Override
	protected void onDestroy() {
		if(myTimer!=null) {
			myTimer.cancel();
		}
		super.onDestroy();
	}
}
