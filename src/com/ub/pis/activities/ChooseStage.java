package com.ub.pis.activities;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.ub.pis.R;

public class ChooseStage extends BaseActivity {
	private ListView listView1;
	private Escenari data[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_choose_stage);
        data = new Escenari[]
        {
            new Escenari(R.drawable.arma, "Raid",false), 
            new Escenari(R.drawable.nieve, "Downhill",true),
            new Escenari(R.drawable.fuego, "Afghan",true),
            new Escenari(R.drawable.nieve, "Hijacked",true),
            new Escenari(R.drawable.fuego, "Express",true),
            new Escenari(R.drawable.arma, "Drone",true),
        };
        
        EscenariAdapter adapter = new EscenariAdapter(this, R.layout.listview_item_row, data);
        
        listView1 = (ListView)findViewById(R.id.list);
         
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new OnItemClickListener(){
            @Override 
            public void onItemClick(AdapterView<?> adapter, View arg1,int position, long arg3){
	            	if(data[position].bloqueado) Toast.makeText(getApplicationContext(), "Escenario bloqueado", Toast.LENGTH_SHORT).show();
	            	else iniciarActivity(Waiting.class);
            }
        });
    }
    
    
    
    
}