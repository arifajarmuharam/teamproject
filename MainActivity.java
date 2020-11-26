package com.example.menuutama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton = (Button) findViewById(R.id.preorder);
        Button mButton = (Button) findViewById(R.id.product);
        Button mButton = (Button) findViewById(R.id.promo);
        Button mButton = (Button) findViewById(R.id.artikel);

        Button mButton = (Button) findViewById(R.id.viewall);

    }
}
