package com.sii.mysii.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
		
		zimbra.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
				intent.putExtra("url", "https://zimbra.sii.fr");
				startActivity(intent);
			}
		});
		
		/*Zimbra client*/
		siimeo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
				intent.putExtra("url", "https://lille.siimeo.sii.fr");
				startActivity(intent);
			}
		});
		
	}

}
