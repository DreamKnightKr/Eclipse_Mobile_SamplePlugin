package com.cws.WebBrowserPlugin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

// [Reference]
// > http://examples.javacodegeeks.com/android/core/ui/webview/android-webview-example/

public class WebBrowserPlugin {
	private static Activity	m_activity = null;
  	
	public void Init(Activity arg)
    {
		m_activity = arg;
    }
	
	public static void OpenEmbeddedWebBrowser(String url)
	{
		Intent intent = new Intent(m_activity, WebActivity.class);
		
		Bundle b = new Bundle();
		b.putString("url", url); //Your id
		intent.putExtras(b); //Put your id to your next Intent
		
		m_activity.startActivity(intent);
	}
	
	public static void OpenEmbeddedWebBrowserData(String data)
	{
		Intent intent = new Intent(m_activity, WebActivity.class);
		
		Bundle b = new Bundle();
		b.putString("data", data); //Your id
		intent.putExtras(b); //Put your id to your next Intent
		
		m_activity.startActivity(intent);
	}
}

