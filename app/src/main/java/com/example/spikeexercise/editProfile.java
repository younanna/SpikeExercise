package com.example.spikeexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class editProfile extends AppCompatActivity {

    String id;
    String pw;
    UserDB dbhelper;

    EditText text_username;
    EditText text_pw;
    EditText text_intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        TextView textView_id = (TextView) findViewById(R.id.textView_id);
        EditText textView_pw = (EditText) findViewById(R.id.editPW);

        Intent intent = getIntent();
        id = intent.getStringExtra("User id");
        pw = intent.getStringExtra("User pw");
        textView_id.setText(String.valueOf(id));
        textView_pw.setText(String.valueOf(pw));

        Edit_Init();


    }

    public void Edit_Init() {
        text_username = (EditText) findViewById(R.id.editUsername);
        text_intro = (EditText) findViewById(R.id.editIntro);
        text_pw = (EditText) findViewById(R.id.editPW);

        dbhelper = new UserDB(
                editProfile.this,
                UserDB.getTableName(),
                null,
                UserDB.getVersion());
    }


    public void save01(View v) {
        if(dbhelper.checkUpdateProfile(
                editProfile.this, id , text_username.getText().toString(), text_intro.getText().toString(), text_pw.getText().toString())) {
            Toast.makeText(editProfile.this, "Profile edited", Toast.LENGTH_SHORT).show();

            // move to which page?
            Intent intent = new Intent(getApplicationContext(), homepage.class);
            // put&pass data
            //intent.putExtra("Entered id", id);
             startActivity(intent);
             finish();
        }
    }
}




