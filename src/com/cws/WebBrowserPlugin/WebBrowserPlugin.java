package com.cws.WebBrowserPlugin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

// [Reference]
// > http://examples.javacodegeeks.com/android/core/ui/webview/android-webview-example/

public class WebBrowserPlugin {
	private static Activity	m_activity = null;
  	
	public void Init(Activity arg)
    {
		m_activity = arg;
    }
	
	public static void OpenWebBrowser(String strURL)
	{
		Uri uri = Uri.parse(strURL);
		Intent it  = new Intent(Intent.ACTION_VIEW,uri);
		m_activity.startActivity(it);
		
		Log.d("CWS", "OpenWebBrowser" + strURL);
	}
	
	public static void OpenEmbeddedWebBrowser(String strURL)
	{
		Uri uri = Uri.parse(strURL);
		Intent intent = new Intent(m_activity, WebActivity.class);
		m_activity.startActivity(intent);
		
		Log.d("CWS", "OpenEmbeddedWebBrowser" + strURL);
	}
}

