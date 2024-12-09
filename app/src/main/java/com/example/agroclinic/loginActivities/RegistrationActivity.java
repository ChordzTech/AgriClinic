package com.example.agroclinic.loginActivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.Utils;
import com.example.agroclinic.databinding.ActivityRegistrationBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rajapps.otplogin.auth.UserModel;

import java.util.concurrent.TimeUnit;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegistrationBinding activityRegistrationBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegistrationBinding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation dropDown = AnimationUtils.loadAnimation(this, R.anim.dropdown);
        activityRegistrationBinding.linearLayoutInRegistration.setAnimation(dropDown);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            activityRegistrationBinding.tvAgroClinic.setAnimation(fadeIn);
            activityRegistrationBinding.cvMain.setAnimation(fadeIn);
            activityRegistrationBinding.tvAlreadyAccount.setAnimation(fadeIn);
            activityRegistrationBinding.btLogin.setAnimation(fadeIn);
        }, 1000);

        activityRegistrationBinding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        activityRegistrationBinding.btRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              sendOtp();
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        activityRegistrationBinding.tietEnterName.setText("");
//        activityRegistrationBinding.tietEnterPhoneNumber.setText("");
        activityRegistrationBinding.tietEnterPassword.setText("");
        activityRegistrationBinding.tietEnterName.setText("");
    }


    // Storing user name and phone number to firebase ..................
    private void storeData() {
        //Utils.showDialog(this, "Loading please wait...");

        String userName = activityRegistrationBinding.tietEnterName.getText().toString();
        String userNumber = activityRegistrationBinding.tietEnterPhoneNumber.getText().toString();

        SharedPreferences preferences = this.getSharedPreferences("users", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", userName);
        editor.putString("number", userNumber);
        editor.apply();



        UserModel data = new UserModel(userName, userNumber);

        FirebaseFirestore.getInstance().collection("users").document(userNumber)
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Utils.hideDialog();
                        Utils.showToast(RegistrationActivity.this, "User registered");
                       // sendOtp(userNumber);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Utils.hideDialog();
                        Utils.showToast(RegistrationActivity.this, "Something went wrong");
                    }
                });


    }



    private void sendOtp() {
        //Utils.showDialog(this, "Sending OTP...");

        if (!activityRegistrationBinding.tietEnterPhoneNumber.getText().toString().trim().isEmpty()) {
            if ((activityRegistrationBinding.tietEnterPhoneNumber.getText().toString().trim()).length() == 10) {
                activityRegistrationBinding.pbSendingOtp.setVisibility(View.VISIBLE);
                activityRegistrationBinding.btRegister.setVisibility(View.INVISIBLE);

                storeData();

                PhoneAuthProvider.getInstance().verifyPhoneNumber("+91" + activityRegistrationBinding.tietEnterPhoneNumber.getText().toString(),

                        60, TimeUnit.SECONDS, RegistrationActivity.this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                activityRegistrationBinding.pbSendingOtp.setVisibility(View.GONE);
                                activityRegistrationBinding.btRegister.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                activityRegistrationBinding.pbSendingOtp.setVisibility(View.GONE);
                                activityRegistrationBinding.btRegister.setVisibility(View.VISIBLE);
                                Toast.makeText(RegistrationActivity.this, "Check Internet Connection", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(s, forceResendingToken);
                               // Utils.hideDialog();
                                Utils.showToast(RegistrationActivity.this, "OTP sent");
                                activityRegistrationBinding.pbSendingOtp.setVisibility(View.GONE);
                                activityRegistrationBinding.btRegister.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(), OtpVerificationActivity.class);
                                //intent.putExtra("mobile", activityRegistrationBinding.tietEnterPhoneNumber.getText().toString());
                                //intent.putExtra("backEndOtp", s);
                                intent.putExtra("verificationId", s);
                                intent.putExtra("number", activityRegistrationBinding.tietEnterPhoneNumber.getText().toString());
                                startActivity(intent);
                                finish();
                            }
                        });
            } else {
              //  Utils.hideDialog();
                Toast.makeText(RegistrationActivity.this, "Please Enter Correct Number", Toast.LENGTH_SHORT).show();
            }
        } else {
            //Utils.hideDialog();
            Toast.makeText(RegistrationActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
        }
    }



}