package com.example.agroclinic.cards;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivityFourthCardBinding;

public class FourthCardActivity extends AppCompatActivity {
    ActivityFourthCardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fourth_card);

    }
}