package com.example.agroclinic.loginActivities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivityMultiLanguageBinding;

public class MultiLanguageActivity extends AppCompatActivity {
    ActivityMultiLanguageBinding multiLanguageBinding;
    RadioButton rbEnglish, rbMarathi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        multiLanguageBinding = DataBindingUtil.setContentView(this, R.layout.activity_multi_language);
        initView();

    }

    private void initView() {
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation dropDown = AnimationUtils.loadAnimation(this, R.anim.dropdown);
        multiLanguageBinding.linearLayout.setAnimation(dropDown);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            multiLanguageBinding.tvAgroClinic.setAnimation(fadeIn);
            multiLanguageBinding.cvMain.setAnimation(fadeIn);
        }, 1000);
        rbEnglish = findViewById(R.id.rbEnglish);
        rbMarathi = findViewById(R.id.rbMarathi);
        multiLanguageBinding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbEnglish) {
                    LocaleHelper.setLocal(MultiLanguageActivity.this, "en");
                } else {
                    LocaleHelper.setLocal(MultiLanguageActivity.this, "mr");
                }
            }
        });
        multiLanguageBinding.btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiLanguageActivity.this, RegistrationActivity.class);
                // changed login to register .......
                startActivity(intent);
            }
        });

        multiLanguageBinding.tvAgroClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiLanguageActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}