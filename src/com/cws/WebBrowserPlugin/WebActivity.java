package com.cws.WebBrowserPlugin;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends Activity {

	private WebView webView;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		{
			// !!����Ƽ ���� �� ����Ǵ� ��Ű�� ��θ� �������� �ؾ� ��
			// setContentView(R.layout.webbrowser);
			setContentView( getResources().getIdentifier("webbrowser", "layout", getPackageName()) );
			//webView = (WebView) findViewById(R.id.webView);
			int webviewID = getResources().getIdentifier("webView", "id", getPackageName());
			webView = (WebView)findViewById(webviewID);
		}
		
		webView.getSettings().setJavaScriptEnabled(true);

		if(null != getIntent().getStringExtra("url"))
			webView.loadUrl( getIntent().getStringExtra("url") );
		else if(null != getIntent().getStringExtra("data"))
		{
			String customHtml = getIntent().getStringExtra("data");
			webView.loadData(customHtml, "text/html", "UTF-8");
		}
	}

}
