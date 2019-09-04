package com.example.memo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MemoActivity extends AppCompatActivity {
    ArrayList<mex> mu = mex.getRandommemo();
    ListView lv;
    String s,st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lv=findViewById(R.id.lv);
        mexAdapter muadapter= new mexAdapter();
        lv.setAdapter(muadapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MemoActivity.this, Final.class);
                startActivity(j);

            }
        });

    }
    class mexAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mu.size();
        }

        @Override
        public mex getItem(int i) {
            return mu.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View itemView=getLayoutInflater().inflate(R.layout.items,viewGroup,false);
            TextView ti=itemView.findViewById(R.id.title);
            TextView bo=itemView.findViewById(R.id.body);
            st=getIntent().getExtras().getString("titu");
            s=getIntent().getExtras().getString("bod");
            ti.setText(st);
            bo.setText(s);
            return itemView;
        }
    }


}
