package com.example.demo;


import java.io.IOException;


import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DisplayPage extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String str = "file:///android_asset/";
		setContentView(R.layout.activity_display_page);
		Intent intent = getIntent();
		String fin;
		String str1;
		String str2;
		str1 = intent.getStringExtra(MainActivity.STR1);
		str2 = intent.getStringExtra(MainActivity.STR2);
		//String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		try
		{if(Integer.parseInt(str2) == 0)
		{
			AssetManager mg = getResources().getAssets();
			for(int i = 1; i<=8; i++)
			{
				fin = "htmlman" + Integer.toString(i)+"/"+str1+"."+ Integer.toString(i) + ".html";
				
		   
				try {
					  mg.open(fin);
					  str2 = Integer.toString(i);
					  break;

					} catch (IOException ex) {
					  continue;
					}			
			}
		}}
		catch(NumberFormatException e)
		{
			str2 = "0";
		}
		fin = str +"htmlman" + str2+"/"+str1+"."+ str2 + ".html";			
		final WebView mywebview = (WebView) findViewById(R.id.webview);
		//WebSettings webSettings = mywebview.getSettings();
		mywebview.loadUrl(fin);
		mywebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                mywebview.loadUrl("file:///android_asset/err.html");

            }
        });
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_page, menu);
		return true;
	}
	/*@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && mywebview.canGoBack()) {
	        mywebview.goBack();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}*/

}
