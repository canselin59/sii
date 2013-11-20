package com.sii.mysii.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.sii.mysii.R;
import com.sii.mysii.webview.SIIWebViewClient;

public class WebViewActivity extends Activity {
	
	private String[] authorizedUrls = new String[]{"https://lille.siimeo.sii.fr", "https://zimbra.sii.fr"};
	private WebView view;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_web_view);

		view = (WebView) findViewById(R.id.webView);
		view.getSettings().setJavaScriptEnabled(true);
		view.setWebViewClient(new SIIWebViewClient(authorizedUrls));
		view.loadUrl(getIntent().getStringExtra("url"));
	}
}
