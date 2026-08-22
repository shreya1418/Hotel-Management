package com.example.hotelmanagement;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);



//        String name1 = MemoryData.getName(loading.this);
//        String phone1 = MemoryData.getPhone(loading.this);

        Handler handler =new Handler();

        String name = MemoryData.getName(this);
        String phone = MemoryData.getPhone(this);
        String cIn = MemoryData.getCheck_in_date(this);
        String cOut = MemoryData.getCheck_out_date(this);
        if (name.isEmpty() || phone.isEmpty() || cIn.isEmpty() || cOut.isEmpty()){


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(loading.this,SendOTP.class));
                    finish();

                }
            },2000);

        }//
        else if(name.equals("data")) {
            Intent intent = new Intent(getApplicationContext(), Admin.class);
            startActivity(intent);
        }
            else if(name.equals("Admin")) {
                Intent intent = new Intent(getApplicationContext(), MainDataBase.class);
                startActivity(intent);
            }

        else{
            Intent intent = new Intent(getApplicationContext(),UserDetails.class);
            startActivity(intent);
        }



    }
}