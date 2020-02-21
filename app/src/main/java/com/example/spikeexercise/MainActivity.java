package com.example.spikeexercise;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* perform when login button is clicked */
    public void Login01(View v) {


        // declare
        EditText text_id = (EditText) findViewById(R.id.enter_id);
        EditText text_pw = (EditText) findViewById(R.id.enter_password);

        String id = text_id.getText().toString();
        String pw = text_pw.getText().toString();


        Intent intent_01 = new Intent(getApplicationContext(), Login_subActivity.class);

        // put&pass data
        intent_01.putExtra("Entered id", id);
        intent_01.putExtra("Entered password", pw);


        startActivity(intent_01);
    }

}



