package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public static final String EXTRA_MESSAGE = "com.example.demo.message";
	public static final String STR1 = "com.example.demo.str1";
	public static final String STR2 = "com.example.demo.str2";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	public void fetchMan(View view)
	{
		String fin = null;
		Intent intent = new Intent(this, DisplayPage.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		String[] strt;
		strt = message.split("\\s+");
		if(strt.length == 1)
		{
				String rad;
				rad = strt[0];
				strt = new String[2];
				strt[0] = rad;
				strt[1] = "0";
		}
		
		/*StringTokenizer st = new StringTokenizer(message);
		String str1 = null;
		String str2 = null;
		str1 = st.nextToken();
		str2 = st.nextToken();
		if(str2 == null)
			str2 = "1";*/
		
		intent.putExtra(EXTRA_MESSAGE, fin);
		intent.putExtra(STR1, strt[0]);
		intent.putExtra(STR2, strt[1]);
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
