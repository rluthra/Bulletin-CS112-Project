package com.yale.bulletin;

import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		
		Button technologyback = (Button) findViewById(R.id.signupgoback);
		technologyback.setOnClickListener(new View.OnClickListener() {

    	    public void onClick(View v) {
    	    	signupgobackClick(v);
    	    }
    	});
		
		Button loginsignup = (Button) findViewById(R.id.loginsignup);
    	loginsignup.setOnClickListener(new View.OnClickListener() {

    	    public void onClick(final View v) {
    	    	EditText newuser = (EditText)findViewById(R.id.usernamesignup);
    			String username = newuser.getText().toString();
    			EditText pass = (EditText)findViewById(R.id.passwordsignup);
    			String password = pass.getText().toString();
    			EditText email = (EditText)findViewById(R.id.emailaddress);
    			String useremail = email.getText().toString();
    			
    	    	if (username.length() >= 5 && password.length() >=8){
    	    		ParseUser user = new ParseUser();
    	    		user.setUsername(username);
    	    		user.setPassword(password);
    	    		user.setEmail(useremail);
    	    		//**************************
    	    		// this is WHERE THE PROBLEM IS -- not entering this loop
    	    		
    	    		user.signUpInBackground(new SignUpCallback() {
    	    			  public void done(ParseException e) {
    	    			    if (e == null) {
    	    			    	loginsignupClick(v);
    	    			    } else {
    	    			    	AlertDialog repeatusernameorpassword = new AlertDialog.Builder(SignUpActivity.this)
    	    					.setTitle("this username or email adress is already in use")
    	    			    	.show();
    	    			    }
    	    			  }
    	    		

						@Override
						public void done(com.parse.ParseException e) {
							// TODO Auto-generated method stub
							
						}
    	    		});
    	    	} else {
    	    				AlertDialog badusernameorpassword = new AlertDialog.Builder(SignUpActivity.this)
   	    					.setTitle("make sure your username and password are long enough")
   	    			    	.show();
    	    				  
    	    			  }
    	    		}
						
    	    			});
    	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
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

	public void loginsignupClick(View v) {
    	Intent intent = new Intent(this, HomeScreenActivity.class);
    	startActivity(intent);
    }
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//public void allowlogin(){
		//loginsignupClick(v);
	//}
	}
	
	public void signupgobackClick(View v) {
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }
	
}
