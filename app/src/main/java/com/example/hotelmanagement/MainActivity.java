package com.example.hotelmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Calendar;
import java.util.SplittableRandom;

public class MainActivity extends AppCompatActivity {

    TextView check_in_time, check_in_date, check_out_time, check_out_date;

    EditText adhar1, adhar2, promo;
    Spinner personSpn, childspn;

    TextView name, phone, roomtype, amount;
    Button bookBtn, apply;

    ImageView roomImg;

    DatabaseReference databaseUsers;

    String namee = "";
    String phonee = "";
    String roomtypeStr = "";
    String[] person = {"1", "2", "3", "4"};
    String[] child = {"0", "1", "2"};
    String value = "";
    String childValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().subscribeToTopic("test");


        //TextView
        check_in_time = findViewById(R.id.Check_In_time);
        check_in_date = findViewById(R.id.Check_In_date);
        check_out_time = findViewById(R.id.Check_Out_time);
        check_out_date = findViewById(R.id.Check_Out_date);
        amount = findViewById(R.id.amount);

        //
        adhar1 = findViewById(R.id.ETadhar1);
        adhar2 = findViewById(R.id.ETadhar2);
        promo = findViewById(R.id.promo);

        roomtype = findViewById(R.id.type_of_room);
        roomtype.setText(MemoryData.getRoomType(this));
        //name.setText(getIntent().getStringExtra("name"));
        //phone.setText(getIntent().getStringExtra("mobile"));

        personSpn = findViewById(R.id.personspn);
        childspn = findViewById(R.id.childspn);
        //Button
        bookBtn = findViewById(R.id.bookBtn);
        apply = findViewById(R.id.apply);

        //imageview
        roomImg = findViewById(R.id.room_image);

        //
        databaseUsers = FirebaseDatabase.getInstance().getReference();

        //time
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        //date
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        //
        ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle("Searching for Room");
        dialog.setMessage("Looking for Best Room for you");

        adhar2.setVisibility(View.INVISIBLE);

        //1st spn
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, person);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        personSpn.setAdapter(adapter);
        //2nd spn
        ArrayAdapter<String> adapterC = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, child);
        adapterC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        childspn.setAdapter(adapterC);


        check_in_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        check_in_time.setText(hourOfDay + ":" + minute);
                        MemoryData.savedCheck_in_time("Check In Time: " + hourOfDay + ":" + minute, MainActivity.this);
                    }
                }, hour, minute, false);

                timePickerDialog.show();

            }
        });
        //

        check_in_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        check_in_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        MemoryData.savedCheck_in_date("Check In Date: " + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year, MainActivity.this);
                    }
                }, year, month, day);

                datePickerDialog.show();
            }
        });
        //

        check_out_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        check_out_time.setText(hourOfDay + ":" + minute);
                        MemoryData.savedCheck_out_time("Check Out Time: " + hourOfDay + ":" + minute, MainActivity.this);
                    }
                }, hour, minute, false);

                timePickerDialog.show();

            }
        });
        //

        check_out_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        check_out_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        MemoryData.savedCheck_out_date("Check Out Date: " + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year, MainActivity.this);
                    }
                }, year, month, day);

                datePickerDialog.show();
            }
        });
        //

        personSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                value = adapterView.getItemAtPosition(i).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        personSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                value = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        childspn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                childValue = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        String room = MemoryData.getRoomType(this);

        if (room.equals("Luxury Dulex Room")) {
            roomImg.setImageResource(R.drawable.luxury_dulex_room);
            amount.setText("Amount: 4,000/- per day");
        }
        if (room.equals("Super Dulex Room")) {
            roomImg.setImageResource(R.drawable.super_dulex_room);
            amount.setText("Amount: 3,000/- per day");
        }
        if (room.equals("AC Room")) {
            roomImg.setImageResource(R.drawable.ac_room);
            amount.setText("Amount: 2,300/- per day");
        }
        if (room.equals("Non AC Room")) {
            roomImg.setImageResource(R.drawable.non_ac_room);
            amount.setText("Amount: 1,000/- per day");

        }


        //promo

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (promo.getText().toString().isEmpty()){
                    promo.setError("Enter Promo code");
                }

                if (room.equals("Luxury Dulex Room") && promo.getText().toString().equals("ltce5")) {
                    Toast.makeText(MainActivity.this, "Promo code applied", Toast.LENGTH_SHORT).show();
                    amount.setText("Amount:  3,800/- per day");

                }

                    if (room.equals("Super Dulex Room") && promo.getText().toString().equals("ltce5")) {
                        Toast.makeText(MainActivity.this, "Promo code applied", Toast.LENGTH_SHORT).show();
                        amount.setText("Amount: 2,850/- per day");
                    }

                    if (room.equals("AC Room") && promo.getText().toString().equals("ltce5")) {
                        Toast.makeText(MainActivity.this, "Promo code applied", Toast.LENGTH_SHORT).show();
                        amount.setText("Amount: 2,185/- per day");
                    }


                else{
                    Toast.makeText(MainActivity.this, "Invalid Promo code", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });


        String number = MemoryData.getPhone(MainActivity.this) + "/" + 1 + (int) (101 * Math.random());
        MemoryData.savedToken(number, MainActivity.this);

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (value.equals("2") || value.equals("3") || value.equals("4")) {
                    adhar2.setVisibility(View.VISIBLE);
                    adhar2.setError("Here");
                    Toast.makeText(MainActivity.this, "Plz add 2nd adhar card Number", Toast.LENGTH_SHORT).show();

                } else {
                    adhar2.setVisibility(View.INVISIBLE);
                }


                if (adhar1.getText().toString().isEmpty()) {
                    adhar1.setError("Plz enter proper Adhar card number");
                    return;
                }
                String ad1 = adhar1.getText().toString();

                if (ad1.length() > 12 || ad1.length() < 12) {
                    adhar1.setError("Plz enter 16 digit Adhar card number");
                    return;
                }

                //

                if (value.equals("1") && adhar2.getText().toString().isEmpty()) {
                    adhar2.setError("Plz enter proper Adhar card number");

                }
                String ad2 = adhar2.getText().toString();

                if (ad2.length() > 12 || ad2.length() < 12) {
                    adhar2.setError("Plz enter 16 digit Adhar card number");
                    return;
                }
                
                if(adhar1.getText().toString() == adhar2.getText().toString()){
                    Toast.makeText(MainActivity.this, "dono same hai", Toast.LENGTH_SHORT).show();
                    return;
                }


                //
                namee = "Name: " + MemoryData.getName(MainActivity.this);

                roomtypeStr = "Room Type: " + MemoryData.getRoomType(MainActivity.this);

                User user = new User(MemoryData.getName(MainActivity.this).trim(),
                        MemoryData.getPhone(MainActivity.this).trim(),
                        check_in_time.getText().toString().trim(),
                        check_in_date.getText().toString().trim(),
                        check_out_time.getText().toString().trim(),
                        check_out_date.getText().toString().trim(),
                        MemoryData.getRoomType(MainActivity.this).trim(),
                        MemoryData.getToken(MainActivity.this).trim(),
                        adhar1.getText().toString().trim(),
                        value.trim(),
                        adhar2.getText().toString().trim(),
                        childValue.trim(),
                        amount.getText().toString().trim());

                MemoryData.savedAmount(amount.getText().toString(),MainActivity.this);

                databaseUsers.child("Users").child(MemoryData.getPhone(MainActivity.this)).setValue(user)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                Intent intent = new Intent(getApplicationContext(), RoomType.class);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "Bookin successful", Toast.LENGTH_SHORT).show();
                                //dialog.show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Bookin successful due to" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });


                // Main database ke liye hai ye

                namee = "Name: " + MemoryData.getName(MainActivity.this);

                roomtypeStr = "Room Type: " + MemoryData.getRoomType(MainActivity.this);

                user = new User(MemoryData.getName(MainActivity.this).trim(),
                        MemoryData.getPhone(MainActivity.this).trim(),
                        check_in_time.getText().toString().trim(),
                        check_in_date.getText().toString().trim(),
                        check_out_time.getText().toString().trim(),
                        check_out_date.getText().toString().trim(),
                        MemoryData.getRoomType(MainActivity.this).trim(),
                        MemoryData.getToken(MainActivity.this).trim(),
                        adhar1.getText().toString().trim(),
                        value.trim(),
                        adhar2.getText().toString().trim(),
                        childValue,amount.getText().toString().trim());


                databaseUsers.child("Main Users").child(MemoryData.getPhone(MainActivity.this)).setValue(user)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                Intent intent = new Intent(getApplicationContext(), UserDetails.class);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "Booking successful", Toast.LENGTH_SHORT).show();
                                //dialog.show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Booking not successful due to " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });


    }

}