package com.example.instagramapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseUser;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText("Welcome!" + ParseUser.getCurrentUser().get("username"));

        findViewById(R.id.btnLogOut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                finish();
            }
        });

    }
}