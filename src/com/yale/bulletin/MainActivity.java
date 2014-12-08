package com.yale.bulletin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends ActionBarActivity {
	public final static String GET_STARTED = "com.yale.bulletin.START";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Parse.initialize(this, "wRxgdWYi8ihBguJB0JUNveNFrEgpoeOi2kn7Zb0T", "YvMevyPJ63zD5cSjDScxyll4q92V8ryHeJoqmXUx");
        
        ParseObject username = new ParseObject("username");
        username.put("name", "rluthra");
        username.saveInBackground();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void getStarted(View view) {
    	Intent intent = new Intent(this, HomeScreenActivity.class);
//    	EditText editText = (EditText) findViewById(R.id.usernameprompt);
//    	String getStarted = editText.getText().toString();
    	startActivity(intent);
    }
    
    
}
