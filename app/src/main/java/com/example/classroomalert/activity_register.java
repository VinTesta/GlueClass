package com.example.classroomalert;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;

public class activity_register extends AppCompatActivity {

    private Button buttonReturnToLoginPage;
    private Button singupButton;
    private EditText emailRegisterEditText;
    private EditText passwordRegisterEditText;
    private EditText passwordRegisterConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonReturnToLoginPage = findViewById(R.id.buttonReturnToLoginPage);
        singupButton = findViewById(R.id.singupButton);
        emailRegisterEditText = findViewById(R.id.emailRegisterEditText);
        passwordRegisterConfirmation = findViewById(R.id.passwordRegisterConfirmation);
        passwordRegisterEditText = findViewById(R.id.passwordRegisterEditText);

        buttonReturnToLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
        });

        singupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = emailRegisterEditText.getText().toString();
                String userPassword = passwordRegisterEditText.getText().toString();
                String userConfirmPassword = passwordRegisterConfirmation.getText().toString();

                if(!TextUtils.isEmpty(userEmail) || !TextUtils.isEmpty(userConfirmPassword) || !TextUtils.isEmpty(userPassword)) {
                    if(userPassword.equals(userConfirmPassword)) {
                        
                    }
                }
            }
        });
    }
}