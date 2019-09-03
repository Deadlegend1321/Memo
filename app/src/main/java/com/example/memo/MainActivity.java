package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    EditText us, ps;
    Button b2,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        us = (EditText) findViewById(R.id.us);
        ps = (EditText) findViewById(R.id.ps);
        b2 = (Button) findViewById(R.id.b2);
        b = (Button) findViewById(R.id.b);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(j);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display(view);
            }

            private void display(View v) {
                Toast.makeText(MainActivity.this,"Not Registered",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
