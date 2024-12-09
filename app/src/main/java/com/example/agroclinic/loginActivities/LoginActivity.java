package com.example.agroclinic.loginActivities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation dropDown = AnimationUtils.loadAnimation(this, R.anim.dropdown);

        loginBinding.linearLayout.setAnimation(dropDown);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            loginBinding.tvAgroClinic.setAnimation(fadeIn);
            loginBinding.cvMain.setAnimation(fadeIn);
            loginBinding.cvFacebook.setAnimation(fadeIn);
            loginBinding.cvGoogle.setAnimation(fadeIn);
            loginBinding.tvDontHaveAccount.setAnimation(fadeIn);
            loginBinding.btRegister.setAnimation(fadeIn);
        }, 1000);
        loginBinding.btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);

            }
        });
        loginBinding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginBinding.tietPhoneNumber.setText("");
        loginBinding.tietEnterPassword.setText("");
    }
}