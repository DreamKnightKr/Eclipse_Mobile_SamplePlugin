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

		webView.loadUrl("http://www.javacodegeeks.com");

		//String customHtml = "<html><body><h2>Greetings from JavaCodeGeeks</h2></body></html>";
		//webView.loadData(customHtml, "text/html", "UTF-8");

	}

}
