package com.example.spikeexercise;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;


public class MainActivity extends AppCompatActivity {

    EditText text_id;
    EditText text_pw;
    Button btnLogin;
    Button btnSignin;

    UserDB dbhelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    private void Init() {
        text_id = (EditText) findViewById(R.id.enter_id);
        text_pw = (EditText) findViewById(R.id.enter_password);

        btnLogin = (Button)findViewById(R.id.btn_login);
        //btnSignin = (Button)findViewById(R.id.btn_signin);
        dbhelper = new UserDB(
                MainActivity.this,
                UserDB.getTableName(),
                null,
                UserDB.getVersion());

        // limit keyboard input char type ??

    }

    /* perform when login button is clicked */
    public void Login01(View v) {




        if(dbhelper.checkLogin(
                MainActivity.this, text_id.getText().toString(), text_pw.getText().toString())) {
            Toast.makeText(MainActivity.this, "You are logged in!", Toast.LENGTH_SHORT).show();

            String id = text_id.getText().toString();
            String pw = text_pw.getText().toString();

            // move to which page?
            Intent intent = new Intent(getApplicationContext(), Login_subActivity.class);
            // put&pass data
            intent.putExtra("Entered id", id);
            intent.putExtra("Entered password", pw);
            startActivity(intent);
            finish();
        }

//
//        // declare
////        text_id = (EditText) findViewById(R.id.enter_id);
////        text_pw = (EditText) findViewById(R.id.enter_password);
//
//        String id = text_id.getText().toString();
//        String pw = text_pw.getText().toString();
//
//
//        Intent intent_01 = new Intent(getApplicationContext(), Login_subActivity.class);
//
//        // put&pass data
//        intent_01.putExtra("Entered id", id);
//        intent_01.putExtra("Entered password", pw);
//
//
//        startActivity(intent_01);
    }

    public void Signin01(View v) {

        Intent intent = new Intent(getApplicationContext(), signin.class);
        startActivity(intent);


    }

}



