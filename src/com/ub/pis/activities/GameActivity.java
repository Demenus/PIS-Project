/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ub.pis.activities;


import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.ub.pis.R;
import com.ub.pis.app.MyGLSurfaceView;
import com.ub.pis.renderer.models.Model;
import com.ub.pis.views.AtackButton;
import com.ub.pis.views.AtackButton.OnClickListener;
import com.ub.pis.views.JoystickView;
import com.ub.pis.views.JoystickView.OnJoystickChangeListener;

public class GameActivity extends Activity {

    private MyGLSurfaceView mGLView;
    private JoystickView joystick;
	private AtackButton attckButton;
	private AtackButton[] spells;
	private TextView stage;
	
	private float x = 0;
	private float y = 0;
	
	private Timer timer;
	
	private int angulo;
	private float dx;
	private float dy;
	private float velocidad = 3;
	
	private Model model;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_activity);
		
		mGLView = (MyGLSurfaceView) findViewById(R.id.my_view);
		joystick = (JoystickView) findViewById(R.id.joystickView);
		attckButton = (AtackButton) findViewById(R.id.buttonatck);
		spells = new AtackButton[3]; 
		
		model = mGLView.getModel();
		//model.getPosition().getValues();
		
		/*Les habilitats van de dreta a esquerra respecte com es veuen en pantalla*/
		int[] refs = {R.id.ability1, R.id.ability2, R.id.ability3};
		for (int i = 0; i < spells.length; i++) {
			spells[i] = (AtackButton) findViewById(refs[i]);
		}
		stage = (TextView) findViewById(R.id.stageView);
		
		/*Carregar aquí les imatges de les tres habilitats que té un player*/
		/*Cada player té habilitats diferents*/
		spells[0].setImage(R.drawable.ojo);
		spells[1].setImage(R.drawable.fletxa_circular);
		spells[2].setImage(R.drawable.mort);
		
		attckButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				//Toast.makeText(getApplicationContext(), "button pressed", Toast.LENGTH_SHORT).show();
				velocidad -= 0.5f;
				if(velocidad <= 0) {
					velocidad = 0.5f;
				}
				
			}
		});
		for (int i = 0; i < spells.length; i++) {
			spells[i].setOnClickListener(new OnClickListener() {
				@Override
				public void onClick() {
					//Toast.makeText(getApplicationContext(), "spell pressed", Toast.LENGTH_SHORT).show();
					velocidad += 0.5f;
					if(velocidad>10) {
						velocidad = 10;
					}
				}
			});
		}
		joystick.setOnJoystickListener(new OnJoystickChangeListener() {
			@Override
			public void onValueChanged(int ang) {
				angulo = ang;
				stage.setText(ang+"");
			}

			@Override
			public void onValueChanged(float xRel, float yRel) {
				dx = xRel/velocidad;
				dy = yRel/velocidad;
			}

			@Override
			public void onJoystickDown() {
				timer = new Timer();
				timer.schedule(new MyTimerTask(), 0, 16);
			}

			@Override
			public void onJoystickUp() {
				timer.cancel();
			}
		});
	}
	
	private class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			model.rotateZ(angulo);
			model.translate(x-=dx, y+=dy, 1.75f);
		}
	}
}
