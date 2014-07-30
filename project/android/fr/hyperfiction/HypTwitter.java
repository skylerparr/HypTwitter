package fr.hyperfiction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import org.haxe.lime.HaxeObject;

import org.haxe.lime.GameActivity;

/**
 * ...
 * @author shoe[box]
 */

public class HypTwitter{

//	static public native void onNewIntent( String jsIntent_url );
	static{
		System.loadLibrary( "HypTwitter" );
	}

    public static HaxeObject onNewIntent;
    public static String callbackName;

    public static void setOnIntentCallback(final HaxeObject cb, final String name) {
        onNewIntent = cb;
        callbackName = name;
    }

	private static String TAG = "trace";//HypTwitter";

	// -------o constructor
		
		/**
		* constructor
		*
		* @param	
		* @return	void
		*/
		private HypTwitter( ) {
			
		}
	
	// -------o public
		
		public static void onIntent( String s ){
			trace("s ::: "+s);
//			onNewIntent( s );
            onNewIntent.call(callbackName, new Object[]{s});
            onNewIntent = null;
            callbackName = null;
        }

	// -------o private
	
	// -------o misc
		
		/**
		* 
		* 
		* @public
		* @return	void
		*/
		public static void trace( String s ){
			Log.i( TAG, s );
		}
}