package com.yale.bulletin;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.parse.*;


public class MainActivity extends ActionBarActivity implements OnClickListener {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Parse.initialize(this, "wRxgdWYi8ihBguJB0JUNveNFrEgpoeOi2kn7Zb0T", "YvMevyPJ63zD5cSjDScxyll4q92V8ryHeJoqmXUx");
        
        Button signup = (Button) findViewById(R.id.signup);
    	signup.setOnClickListener(new View.OnClickListener() {

    	    public void onClick(View v) {
    	        signupClick(v);
    	    }
    	});
    	
    	Button login = (Button) findViewById(R.id.createuser);
    	login.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(final View v) {
    	    	EditText user = (EditText)findViewById(R.id.username);
    			String username = user.getText().toString();
    			EditText pass = (EditText)findViewById(R.id.password);
    			String password = pass.getText().toString();
    	    	ParseUser.logInInBackground(username, password, new LogInCallback() {
    	    		  public void done(ParseUser user, ParseException e) {
    	    		    if (user != null) {
    	    		    	loginClick(v);
    	    		    } else {
    	    		    	AlertDialog wrongusernameorpassword = new AlertDialog.Builder(MainActivity.this)
	    					.setTitle("incorrect login credentials or user doesn't exist")
	    			    	.show();
    	    		    }
    	    		  }
    	    		});
    	        
    	    }
    	});
    	
        
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
    
    public void signupClick(View v) {
    	Intent intent = new Intent(this, SignUpActivity.class);
    	startActivity(intent);
    }
    
    public void loginClick(View v) {
    	Intent intent = new Intent(this, HomeScreenActivity.class);
    	startActivity(intent);
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
