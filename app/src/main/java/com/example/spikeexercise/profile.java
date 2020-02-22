package com.example.spikeexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    UserDB dbhelper;

    TextView textView_id;
    String id;
    TextView textView_username;
    TextView textView_intro;
    String username;
    String intro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        dbhelper = new UserDB(
//                profile.this,
//                UserDB.getTableName(),
//                null,
//                UserDB.getVersion());


        textView_id = (TextView) findViewById(R.id.textView_id);
        textView_username = (TextView) findViewById(R.id.textView_username);
        textView_intro = (TextView) findViewById(R.id.textView_intro);

        Intent intent = getIntent();
        id = intent.getStringExtra("User id");
        textView_id.setText(String.valueOf(id));

        username = intent.getStringExtra("User name");
        textView_username.setText(String.valueOf(username));

        intro = intent.getStringExtra("User intro");
        textView_intro.setText(String.valueOf(intro));

    }





    public void gohome03(View v) {
        Intent intent = new Intent(getApplicationContext(), homepage.class);
        intent.putExtra("User id", id);
        //intent.putExtra("User pw", pw);
        startActivity(intent);
        finish();
    }
}
