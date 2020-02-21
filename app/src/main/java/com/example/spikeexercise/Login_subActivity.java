package com.example.spikeexercise;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class Login_subActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sub);


        TextView textView_id = (TextView) findViewById(R.id.textView_id);
        TextView textView_pw = (TextView) findViewById(R.id.textView_pw);

        Intent intent_01 = getIntent();

        String id = intent_01.getStringExtra("Entered id");
        String pw = intent_01.getStringExtra("Entered password");

        textView_id.setText(String.valueOf(id));
        textView_pw.setText(String.valueOf(pw));

    }

    public void goback01(View v){
        Intent intent = new Intent(getApplicationContext(), Login_subActivity.class);
        startActivity(intent);
        finish();
    }

}
