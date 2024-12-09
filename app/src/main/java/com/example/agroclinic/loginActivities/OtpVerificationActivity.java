package com.example.agroclinic.loginActivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.Utils;
import com.example.agroclinic.databinding.ActivityOtpVerificationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OtpVerificationActivity extends AppCompatActivity {
    ActivityOtpVerificationBinding otpVerificationBinding;
    String backEndOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        otpVerificationBinding = DataBindingUtil.setContentView(this, R.layout.activity_otp_verification);


        Utils.getCorrectOTPSize(this, otpVerificationBinding.userOTP, otpVerificationBinding.btVerifyAndLogin);

        otpVerificationBinding.btVerifyAndLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otpVerificationBinding.userOTP.getText().toString().isEmpty()) {
                    Utils.showToast(OtpVerificationActivity.this, "Please enter otp");
                } else {
                    verifyUser(otpVerificationBinding.userOTP.getText().toString());
                }
            }
        });



//        otpVerificationBinding.tvVerify.setText(String.format("Verify" + "+91-%s", getIntent().getStringExtra("mobile")));
//        backEndOtp = getIntent().getStringExtra("backEndOtp");
//
//        otpVerificationBinding.btVerifyAndLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!otpVerificationBinding.inputOtpOne.getText().toString().trim().isEmpty() && !otpVerificationBinding.inputOtpTwo.getText().toString().trim().isEmpty()) {
//                    String enterCodeOtp = otpVerificationBinding.inputOtpOne.getText().toString() +
//                            otpVerificationBinding.inputOtpTwo.getText().toString() +
//                            otpVerificationBinding.inputOtpThree.getText().toString() +
//                            otpVerificationBinding.inputOtpFour.getText().toString() +
//                            otpVerificationBinding.inputOtpFive.getText().toString() +
//                            otpVerificationBinding.inputOtpSix.getText().toString();
//                    if (backEndOtp != null) {
//                        otpVerificationBinding.pbVerifyOtp.setVisibility(View.VISIBLE);
//                        otpVerificationBinding.btVerifyAndLogin.setVisibility(View.INVISIBLE);
//                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
//                                backEndOtp, enterCodeOtp
//                        );
//                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
//                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<AuthResult> task) {
//                                        otpVerificationBinding.pbVerifyOtp.setVisibility(View.GONE);
//                                        otpVerificationBinding.btVerifyAndLogin.setVisibility(View.VISIBLE);
//                                        if (task.isSuccessful()) {
//                                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                            startActivity(intent);
//                                        } else {
//                                            Toast.makeText(OtpVerificationActivity.this, "Enter Correct OTP", Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                });
//                    } else {
//                        Toast.makeText(OtpVerificationActivity.this, "Please Check Internet Connection", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(OtpVerificationActivity.this, "Please Enter All Numbers", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        numberOtpMove();

    }

    private void verifyUser(String otp) {
        Utils.showDialog(this, "Verifying please wait");
        String verificationId = getIntent().getStringExtra("verificationId");
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, otp);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Utils.hideDialog();

                            String userNumber = getIntent().getStringExtra("number");

                            SharedPreferences preferences = getSharedPreferences("user", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("number", userNumber);
                            editor.apply();

                            startActivity(new Intent(OtpVerificationActivity.this, HomeActivity.class));
                            finish();
                        } else {
                            Utils.hideDialog();
                            Utils.showToast(OtpVerificationActivity.this, "Something went wrong");
                        }
                    }
                });
    }


//    private void numberOtpMove() {
//        otpVerificationBinding.inputOtpOne.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (!charSequence.toString().trim().isEmpty()) {
//                    otpVerificationBinding.inputOtpTwo.requestFocus();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        otpVerificationBinding.inputOtpTwo.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (!charSequence.toString().trim().isEmpty()) {
//                    otpVerificationBinding.inputOtpThree.requestFocus();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        otpVerificationBinding.inputOtpThree.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (!charSequence.toString().trim().isEmpty()) {
//                    otpVerificationBinding.inputOtpFour.requestFocus();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        otpVerificationBinding.inputOtpFour.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (!charSequence.toString().trim().isEmpty()) {
//                    otpVerificationBinding.inputOtpFive.requestFocus();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        otpVerificationBinding.inputOtpFive.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (!charSequence.toString().trim().isEmpty()) {
//                    otpVerificationBinding.inputOtpSix.requestFocus();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//    }


}