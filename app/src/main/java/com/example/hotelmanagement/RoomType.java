package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class RoomType extends AppCompatActivity {

    ViewFlipper viewFlipper;

    CardView luxury_dulex_roomBtn,super_dulex_roomBtn,
            ac_room_roomBtn,non_ac_room_roomBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_type);

        luxury_dulex_roomBtn = findViewById(R.id.luxury_dulex_roomBtn);
        super_dulex_roomBtn = findViewById(R.id.super_dulex_roomBtn);
        ac_room_roomBtn = findViewById(R.id.ac_room_roomBtn);
        non_ac_room_roomBtn = findViewById(R.id.non_ac_room_roomBtn);

        int imageArray[]={R.drawable.ac_room,
                R.drawable.luxury_dulex_room,
                R.drawable.non_ac_room,
                R.drawable.super_dulex_room};
        viewFlipper = (ViewFlipper)findViewById(R.id.flipper);

        for (int i=0; i<imageArray.length;i++)
            showImage(imageArray[i]);



        luxury_dulex_roomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomType.this,MainActivity.class);
                MemoryData.savedRoomType("Luxury Dulex Room",RoomType.this);
                startActivity(intent);
            }
        });

        super_dulex_roomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomType.this,MainActivity.class);
                MemoryData.savedRoomType("Super Dulex Room",RoomType.this);
                startActivity(intent);
            }
        });

        ac_room_roomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomType.this,MainActivity.class);
                MemoryData.savedRoomType("AC Room",RoomType.this);
                startActivity(intent);
            }
        });

        non_ac_room_roomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomType.this,MainActivity.class);
                MemoryData.savedRoomType("Non AC Room",RoomType.this);
                startActivity(intent);
            }
        });

    }

    public void showImage(int img){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (img==R.drawable.ac_room){
                    Intent intent = new Intent(RoomType.this,MainActivity.class);
                    MemoryData.savedRoomType("AC Room",RoomType.this);
                    startActivity(intent);
                }

                if (img==R.drawable.luxury_dulex_room){
                    Intent intent = new Intent(RoomType.this,MainActivity.class);
                    MemoryData.savedRoomType("Luxury Dulex Room",RoomType.this);
                    startActivity(intent);
                }

                if (img==R.drawable.non_ac_room){
                    Intent intent = new Intent(RoomType.this,MainActivity.class);
                    MemoryData.savedRoomType("Non AC Room",RoomType.this);
                    startActivity(intent);
                }

                if (img==R.drawable.super_dulex_room){
                    Intent intent = new Intent(RoomType.this,MainActivity.class);
                    MemoryData.savedRoomType("Super Dulex Room",RoomType.this);
                    startActivity(intent);
                }




            }
        });

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}