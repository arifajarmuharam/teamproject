package com.example.projectmobprog_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button log;
    private EditText user,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        log = (Button) findViewById(R.id.loginbutt);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage();
            }
        });
    }
    public void nextpage(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}