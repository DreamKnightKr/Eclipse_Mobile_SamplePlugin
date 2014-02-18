package com.cws.WebBrowserPlugin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

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
}

