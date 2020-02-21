package com.example.spikeexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signin extends AppCompatActivity {

    EditText text_signin_id;
    EditText text_signin_pw;
    UserDB dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Signin_Init();
    }

    public void Signin_Init() {
        text_signin_id = (EditText) findViewById(R.id.signin_id);
        text_signin_pw = (EditText) findViewById(R.id.signin_pw);

        dbhelper = new UserDB(
                signin.this,
                UserDB.getTableName(),
                null,
                UserDB.getVersion());
    }



    public void Submit01(View v) {


        if(dbhelper.checkSignin(
                signin.this, text_signin_id.getText().toString(), text_signin_pw.getText().toString())) {
            Toast.makeText(signin.this, "Welcome!", Toast.LENGTH_SHORT).show();

            // move to which page?
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    public void goLogin(View v) {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();


    }


}
