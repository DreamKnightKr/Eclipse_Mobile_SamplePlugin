package com.cws.unitysimpleplugin;
import com.unity3d.player.UnityPlayer;

public class SimplePlugin {
	
	// Return Message to Unity
	public void initActivity(String strObj, String strFunc, String messageFromUnity)
    {
		UnityPlayer.UnitySendMessage(strObj, strFunc, messageFromUnity);
    }
}
