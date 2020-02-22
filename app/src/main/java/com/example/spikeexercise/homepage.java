package com.example.spikeexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    String id;
    String pw;
    String username;
    String intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

//        ImageButton btn_editInfo;
//        btn_editInfo = (ImageButton)findViewById(R.id.btn_editInfo);

        homepage_Init();
    }

    public void homepage_Init() {

        TextView textView_id = (TextView) findViewById(R.id.textView_id);
        Intent intent = getIntent();
        id = intent.getStringExtra("User id");
        pw = intent.getStringExtra("User pw");
        username = intent.getStringExtra("User name");
        intro = intent.getStringExtra("User intro");
        //username = intent.getStringExtra("User username");
        textView_id.setText(String.valueOf(id));

    }

    /* log out and go back to login page */
    public void logout01(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }


    /* move to edit profile page */
    public void editProfile01(View v){
        Intent intent = new Intent(getApplicationContext(), editProfile.class);
        intent.putExtra("User id", id);
        intent.putExtra("User pw", pw);
        startActivity(intent);
        finish();
    }

    /* move to view profile page */
    public void viewProfile01(View v) {
        Intent intent = new Intent(getApplicationContext(), profile.class);
        intent.putExtra("User id", id);
        intent.putExtra("User name", username);
        intent.putExtra("User intro", intro);

        startActivity(intent);
        finish();
    }




}
