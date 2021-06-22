package com.example.classroomalert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button buttonToRedirectForRegister;
    private Button singinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        buttonToRedirectForRegister = findViewById(R.id.buttonToRedirectForRegister);
        singinButton = findViewById(R.id.singinButton);

        buttonToRedirectForRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), activity_register.class));
                finish();
            }
        });

        singinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));
                finish();
            }
        });

    }
}