package com.example.spikeexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        homepage_Init();
    }

    public void homepage_Init() {

        TextView textView_id = (TextView) findViewById(R.id.textView_id);


        Intent intent_01 = getIntent();

        String id = intent_01.getStringExtra("Entered id");


        textView_id.setText(String.valueOf(id));

    }




}
