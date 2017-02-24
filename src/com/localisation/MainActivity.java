package com.localisation;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	private ImageButton imageButton1;
	private ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ajouterEcouteur();
    }


    private void ajouterEcouteur() {
		// TODO Auto-generated method stub
		imageButton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				enregister();
			}

			
		});
imageButton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				localiser();
			}

			
		});
	}


	protected void localiser() {
		// TODO Auto-generated method stub
		Bundle bundle =new Bundle();
		Intent intent =new Intent(MainActivity.this,LocaliserVoiture.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,1);
	}


	protected void enregister() {
		// TODO Auto-generated method stub
		Bundle bundle =new Bundle();
		Intent intent =new Intent(MainActivity.this,EnregistrerVoiture.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,1);

		
	}


	private void init() {
		// TODO Auto-generated method stub
		imageButton1=(ImageButton)findViewById(R.id.imageButton1);
		imageButton2=(ImageButton)findViewById(R.id.imageButton2);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
