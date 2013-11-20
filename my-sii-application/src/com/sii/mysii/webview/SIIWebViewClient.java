package com.sii.mysii.webview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SIIWebViewClient extends WebViewClient {

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		view.loadUrl(url);
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
