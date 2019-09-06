package com.example.memo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MemoActivity extends AppCompatActivity {
    ArrayList<String> mu = mex.getRandommemo();
    ListView lv;
    String s,st;
    final DatabaseReference dbref= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lv=findViewById(R.id.lv);
        final mexAdapter muadapter= new mexAdapter();
        lv.setAdapter(muadapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MemoActivity.this, Final.class);
                startActivity(j);

            }
        });
        st=getIntent().getExtras().getString("titu");
        s=getIntent().getExtras().getString("bod");
        dbref.child("Title").push().setValue(st);
        dbref.child("Body").push().setValue(s);
        dbref.child("Title").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String data = dataSnapshot.getValue(String.class);
                mu.add(data);
                muadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbref.child("Body").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String da=dataSnapshot.getValue(String.class);
                mu.add(da);
                muadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    class mexAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mu.size();
        }

        @Override
        public String getItem(int i) {
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
            ti.setText(st);
            bo.setText(s);
            return itemView;
        }
    }

}
