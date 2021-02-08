package com.example.instagramapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtLoginEmail, edtLoginPassword;
    private Button btnLoginActivity, btnSignUpLogInActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Log In");

        edtLoginEmail = findViewById(R.id.edtLogInEmail);
        edtLoginPassword = findViewById(R.id.edtLogInPassword);
        btnLoginActivity = findViewById(R.id.btnLoginActivity);
        btnSignUpLogInActivity = findViewById(R.id.btnSignUpLoginActivity);

        btnLoginActivity.setOnClickListener(this);
        btnSignUpLogInActivity.setOnClickListener(this);

        if (ParseUser.getCurrentUser() != null) {

            ParseUser.getCurrentUser().logOut();
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnLoginActivity:
                ParseUser.logInInBackground(edtLoginEmail.getText().toString() , edtLoginPassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user!= null && e == null) {
                            FancyToast.makeText(LoginActivity.this, user.getUsername()+ "is signed up", Toast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                            transitionToSocialActivity();
                        } else {
                            FancyToast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT, FancyToast.ERROR, true).show();

                        }
                    }
                });
                break;
            case R.id.btnSignUpLoginActivity:
                break;
        }
    }
    private void transitionToSocialActivity() {

        Intent intent = new Intent(LoginActivity.this, SocialMediaActivity.class );
        startActivity(intent);
    }
}