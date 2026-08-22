package com.example.hotelmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainDataBase extends AppCompatActivity {

    RecyclerView MainrecyclerView;
    ArrayList<User> list;
    DatabaseReference databaseReference;
    MyMainAdapter adapter;
    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_data_base);

        MainrecyclerView=findViewById(R.id.Maindata);

        databaseReference = FirebaseDatabase.getInstance().getReference("Main Users");
        list = new ArrayList<>();
        MainrecyclerView.setLayoutManager(new LinearLayoutManager(MainDataBase.this));
        adapter = new MyMainAdapter(MainDataBase.this, list);
        MainrecyclerView.setAdapter(adapter);

        query = FirebaseDatabase.getInstance().getReference("Main Users");

        query.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}