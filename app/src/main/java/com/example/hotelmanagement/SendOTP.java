package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SendOTP extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;


    EditText Rname,inputMobile;
    Button buttonGetOTP;
            //,btn;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otp);

        Rname = findViewById(R.id.RegName);
        inputMobile = findViewById(R.id.RegPhone);
        buttonGetOTP = findViewById(R.id.GetOTP);



        progressDialog = new ProgressDialog(SendOTP.this);
        progressDialog.setTitle("Sending OTP");
        progressDialog.setMessage("Plz wait we are sending you otp on this Number");

//        btn = findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),RoomType.class);
//                startActivity(intent);
//            }
//        });



        mAuth = FirebaseAuth.getInstance();



        buttonGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                if (inputMobile.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SendOTP.this, "Enter Mobile", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Rname.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SendOTP.this, "Enter Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Rname.getText().toString().trim().equals("data")&&
                        inputMobile.getText().toString().trim().equals("1234")){
                    MemoryData.savedName("data",getApplicationContext());
                    Intent intent = new Intent(getApplicationContext(),Admin.class);
                    startActivity(intent);
                    return;

                }

                if (Rname.getText().toString().trim().equals("Admin")&&
                        inputMobile.getText().toString().trim().equals("1234")){
                    MemoryData.savedName("Admin",getApplicationContext());
                    Intent intent = new Intent(getApplicationContext(),MainDataBase.class);
                    startActivity(intent);
                    return;

                }
                otpSend();
//                PhoneAuthOptions options =
//                        PhoneAuthOptions.newBuilder(mAuth)
//                                .setPhoneNumber("+91" + inputMobile.getText().toString())
//                                .setTimeout(60L, TimeUnit.SECONDS)
//                                .setActivity(this)
//                                .setCallbacks(mCallback)
//                                .build();

//                PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                       "+91" + inputMobile.getText().toString(),
//                        60,
//                        // 60 sec ke baad he naya otp aaega
//                        TimeUnit.SECONDS,
//                        SendOTPActivity.this,
//                      mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//
//                          @Override
//                          public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//                              progressBar.setVisibility(View.GONE);
//                              buttonGetOTP.setVisibility(View.VISIBLE);
//                          }
//
//                          @Override
//                          public void onVerificationFailed(@NonNull FirebaseException e) {
//                              progressBar.setVisibility(View.GONE);
//                              buttonGetOTP.setVisibility(View.VISIBLE);
//                              Toast.makeText(SendOTPActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                              //verifyWithRecaptcha();
//                          }
//
//                          @Override
//                          public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                              progressBar.setVisibility(View.GONE);
//                              buttonGetOTP.setVisibility(View.VISIBLE);
//                              Intent intent = new Intent(getApplicationContext(), VerifyOTPActivity.class);
//                              intent.putExtra("mobile", inputMobile.getText().toString());
//                              intent.putExtra("verificationId", verificationId);
//                              startActivity(intent);
//                          }
//
                progressDialog.show();
            }

        });
    }


    private void otpSend() {

       // progressBar.setVisibility(View.VISIBLE);
        buttonGetOTP.setVisibility(View.VISIBLE);

        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                //progressBar.setVisibility(View.GONE);
                progressDialog.dismiss();
                buttonGetOTP.setVisibility(View.VISIBLE);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                //progressBar.setVisibility(View.GONE);
                progressDialog.dismiss();
                buttonGetOTP.setVisibility(View.VISIBLE);
                Toast.makeText(SendOTP.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                //verifyWithRecaptcha();
            }

            @Override
            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
               // progressBar.setVisibility(View.GONE);
                buttonGetOTP.setVisibility(View.VISIBLE);
                progressDialog.show();
                MemoryData.savedPhone(inputMobile.getText().toString(),SendOTP.this);
                MemoryData.savedName(Rname.getText().toString(),SendOTP.this);

                Intent intent = new Intent(getApplicationContext(), VerifyOTPActivity.class);
                intent.putExtra("mobile", inputMobile.getText().toString());
                intent.putExtra("name", Rname.getText().toString());
                intent.putExtra("verificationId", verificationId);
                progressDialog.dismiss();
                startActivity(intent);
            }
        };
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91" + inputMobile.getText().toString().trim())
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallback)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}