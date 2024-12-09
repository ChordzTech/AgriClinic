package com.example.agroclinic.cards;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivityFifthCardBinding;

public class FifthCardActivity extends AppCompatActivity {
    ActivityFifthCardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_fifth_card);

    }
}