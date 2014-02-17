package com.cws.IndicatorPlugin;
import com.unity3d.player.UnityPlayer;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;

public class IndicatorPlugin {
	private static Activity	m_activity = null;
	private static MyProgressDialog progressDialog = null;
	private static Handler dialogHandlerShow = null;
	private static Handler dialogHandlerClose = null;
	HandlerThread handlerThread = new HandlerThread("HandlerName");
  	
	public void Init(Activity arg)
    {
		m_activity = arg;
		
		{
			// Handler Class 참조 : http://aroundck.tistory.com/1022
			handlerThread.start();
	
			dialogHandlerShow = new Handler( handlerThread.getLooper() ){      
		        public void handleMessage(Message msg){ 
		           if(null == progressDialog)
		           {
		        	   progressDialog = MyProgressDialog.show(m_activity, "", "", true, false);
		           }
		        }    
		     }; 
		     
		     dialogHandlerClose = new Handler( handlerThread.getLooper() ){      
		         public void handleMessage(Message msg){ 
		            if(null != progressDialog)
		            {
		         	   progressDialog.dismiss();
		         	   progressDialog = null;
		            }
		            else
		         	   Log.d("TT", "null != progressDialog");
		         }    
		      };
		}
    }
	
	
	public void ShowProgressIndicator(int bShow)
 	{	    
 	   if(1 == bShow)
 	   {
 	      Message msg = dialogHandlerShow.obtainMessage();
 	      dialogHandlerShow.sendMessage(msg);
 	   }
 	   else if(0 == bShow)
 	   {
 	      Message msg = dialogHandlerClose.obtainMessage();
 	      dialogHandlerClose.sendMessage(msg);
 	   }
 	   
   	   Log.d("TT", "ShowProgressIndicator : " + bShow);
 	}
}

class MyProgressDialog extends Dialog {

	public static MyProgressDialog show(Context context, CharSequence title, CharSequence message) {
	    return show(context, title, message, false);
	}

	public static MyProgressDialog show(Context context, CharSequence title,
	        CharSequence message, boolean indeterminate) {
	    return show(context, title, message, indeterminate, false, null);
	}

	public static MyProgressDialog show(Context context, CharSequence title,
	        CharSequence message, boolean indeterminate, boolean cancelable) {
	    return show(context, title, message, indeterminate, cancelable, null);
	}

	public static MyProgressDialog show(Context context, CharSequence title,
	        CharSequence message, boolean indeterminate,
	        boolean cancelable, OnCancelListener cancelListener) {
	    MyProgressDialog dialog = new MyProgressDialog(context);
	    dialog.setTitle(title);
	    dialog.setCancelable(cancelable);
	    dialog.setOnCancelListener(cancelListener);
	    /* The next line will add the ProgressBar to the dialog. */
	    dialog.addContentView(new ProgressBar(context), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	    dialog.show();

	    return dialog;
	}

	public MyProgressDialog(Context context) {
//	    super(context, R.style.NewDialog);
		super(context, context.getResources().getIdentifier("NewDialog", "style", context.getPackageName()));
	}
}
