package com.example.agroclinic.loginActivities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivitySplashBinding;
import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding splashBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        Animation fadeIn= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        splashBinding.ivLogo.setAnimation(fadeIn);

//        new Handler(Looper.getMainLooper()).postDelayed(() -> {
//            Intent intent = new Intent(SplashActivity.this, MultiLanguageActivity.class);
//            startActivity(intent);
//            finish();
//        }, 3000);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {

            if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }else {

                Intent intent = new Intent(SplashActivity.this, MultiLanguageActivity.class);
                startActivity(intent);
                finish();

            }

        }, 3000);








    }
}