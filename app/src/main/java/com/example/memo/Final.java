package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Final extends AppCompatActivity {
    ArrayList<mex> mu = mex.getRandommemo();
    EditText Title,Body;
    Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Title = (EditText)findViewById(R.id.Title);
        Body = (EditText)findViewById(R.id.Body);
        Save = (Button) findViewById(R.id.Save);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = Title.getText().toString();
                String b = Body.getText().toString();
                mex e = new mex(t,b);
                mu.add(e);
                Intent j = new Intent(Final.this, MemoActivity.class);
                startActivity(j);
                finish();
            }
        });


    }
}
