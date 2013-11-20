package com.sii.mysii.webview;

import java.util.ArrayList;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SIIWebViewClient extends WebViewClient {
	
	private static final String TAG = "SIIWebViewClient";
	private ArrayList<String> urlAuthorized;
	
	public SIIWebViewClient(String... urlAuthorized){
		this.urlAuthorized = new ArrayList<String>();
		if( urlAuthorized != null ){
			for(int i = 0; i < urlAuthorized.length; i++){
				Log.d(TAG, "Adding ["+urlAuthorized[i]+"] to the list of white listed urls");
				this.urlAuthorized.add(urlAuthorized[i]);
			}
		}
	}

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		for(String whiteListedUrl : urlAuthorized){
			if(whiteListedUrl.contains(url)){
				// If the url is whitelisted, load it directly
				view.loadUrl(url);
				return true;
			}
		}
		// If the url is not whitelisted, intent the browser
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		view.getContext().startActivity(i);
		return true;
	}

	@Override
	public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
		switch (errorCode) {
		case ERROR_CONNECT:
			// Impossible to contact/connect API
			break;
		case ERROR_FILE_NOT_FOUND:
			// 404 not found
			break;
		case ERROR_TIMEOUT:
			// Server under timeout
		default:
			// Nothing important
			break;
		}
		super.onReceivedError(view, errorCode, description, failingUrl);
	}
	
}
