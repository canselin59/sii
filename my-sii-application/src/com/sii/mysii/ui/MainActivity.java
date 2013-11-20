package com.sii.mysii.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;

import com.sii.mysii.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 ImageButton zimbra = (ImageButton) findViewById(R.id.zimbra);
		 ImageButton geoloc = (ImageButton) findViewById(R.id.geoloc);
		 ImageButton siimeo = (ImageButton) findViewById(R.id.siimeo);
		 ImageButton food = (ImageButton) findViewById(R.id.food);

	}
	
	

}
