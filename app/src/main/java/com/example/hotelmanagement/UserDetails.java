package com.example.hotelmanagement;

import static com.example.hotelmanagement.R.drawable.luxury_dulex_room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

import java.io.InputStreamReader;

public class UserDetails extends AppCompatActivity {

    TextView uName,uphone,uRoom,uCheck_in_time,uCheck_in_date,uCheck_out_time,uCheck_out_date,uToken,uNote,uAmount;
    Button logoutbtn;
    ImageView uimg;
    ImageButton exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        FirebaseMessaging.getInstance().subscribeToTopic("test");

        uName = findViewById(R.id.uName);
        uphone = findViewById(R.id.uphone);
        uRoom = findViewById(R.id.uRoom);
        uimg = findViewById(R.id.uimg);
        uCheck_in_time = findViewById(R.id.uCheck_in_time);
        uCheck_in_date = findViewById(R.id.uCheck_in_date);
        uCheck_out_time= findViewById(R.id.uCheck_out_time);
        uCheck_out_date= findViewById(R.id.uCheck_out_date);
        uToken = findViewById(R.id.uToken);
        uNote = findViewById(R.id.uNote);
        uAmount = findViewById(R.id.uAmount);

        exit = findViewById(R.id.exit);

        //String
        String Roomm = MemoryData.getRoomType(this);
        //Button
        logoutbtn = findViewById(R.id.logoutbtn);

        uName.setText("Name: "+MemoryData.getName(UserDetails.this));
        uphone.setText("Phone: "+MemoryData.getPhone(UserDetails.this));
        uRoom.setText("Room: "+MemoryData.getRoomType(UserDetails.this));
        uCheck_in_time.setText(MemoryData.getCheck_in_time(UserDetails.this));
        uCheck_in_date.setText(MemoryData.getCheck_in_date(UserDetails.this));
        uCheck_out_time.setText(MemoryData.getCheck_out_time(UserDetails.this));
        uCheck_out_date.setText(MemoryData.getCheck_out_date(UserDetails.this));
        uToken.setText("Token: "+MemoryData.getToken(UserDetails.this));
        uNote.setText("Note: Please do not logout till "+MemoryData.getCheck_out_date(this));
        uAmount.setText(MemoryData.getAmount(this));


        if (Roomm.equals("Luxury Dulex Room")){
            uimg.setImageResource(R.drawable.luxury_dulex_room);
        }
        if (Roomm.equals("Super Dulex Room")){
            uimg.setImageResource(R.drawable.super_dulex_room);
        }
        if (Roomm.equals("AC Room")){
            uimg.setImageResource(R.drawable.ac_room);
        }
        if (Roomm.equals("Non AC Room")){
            uimg.setImageResource(R.drawable.non_ac_room);
        }

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MemoryData.savedName("",UserDetails.this);
                MemoryData.savedPhone("",UserDetails.this);
                MemoryData.savedToken("",UserDetails.this);
                MemoryData.savedCheck_out_date("",UserDetails.this);
                MemoryData.savedCheck_in_date("",UserDetails.this);
                MemoryData.savedCheck_out_time("",UserDetails.this);
                MemoryData.savedCheck_in_time("",UserDetails.this);
                finish();
                System.exit(0);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RoomType.class);
                startActivity(intent);
            }
        });


    }
}