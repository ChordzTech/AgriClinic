package com.example.agroclinic.cards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivityFirstCardBinding;
import com.example.agroclinic.tables.EighthTableActivity;
import com.example.agroclinic.tables.EleventhTableActivity;
import com.example.agroclinic.tables.FifthTableActivity;
import com.example.agroclinic.tables.FirstTableActivity;
import com.example.agroclinic.tables.FourthTableActivity;
import com.example.agroclinic.tables.NinthTableActivity;
import com.example.agroclinic.tables.SecondTableActivity;
import com.example.agroclinic.tables.SeventhTableActivity;
import com.example.agroclinic.tables.SixthTableActivity;
import com.example.agroclinic.tables.TenthTableActivity;
import com.example.agroclinic.tables.ThirdTableActivity;
import com.example.agroclinic.tables.TwelevthTableActivity;

import java.text.DecimalFormat;

public class FirstCardActivity extends AppCompatActivity {
    private ActivityFirstCardBinding binding;
    private DecimalFormat decimalFormat;
    private String valueofEditText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first_card);
        initView();
    }

    private void initView() {
        binding.cvTableName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstCardActivity.this, FirstTableActivity.class);
                startActivity(intent);

            }
        });
        binding.cvTableName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FirstCardActivity.this, SecondTableActivity.class);
                startActivity(intent1);
            }
        });
        binding.cvTableName3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(FirstCardActivity.this, ThirdTableActivity.class);
                startActivity(intent2);
            }
        });
        binding.cvTableName4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(FirstCardActivity.this, FourthTableActivity.class);
                startActivity(intent3);
            }
        });
        binding.cvTableName5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(FirstCardActivity.this, FifthTableActivity.class);
                startActivity(intent4);
            }
        });
        binding.cvTableName6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(FirstCardActivity.this, SixthTableActivity.class);
                startActivity(intent5);
            }
        });
        binding.cvTableName7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(FirstCardActivity.this, SeventhTableActivity.class);
                startActivity(intent6);
            }
        });
        binding.cvTableName8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(FirstCardActivity.this, EighthTableActivity.class);
                startActivity(intent7);
            }
        });
        binding.cvTableName9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(FirstCardActivity.this, NinthTableActivity.class);
                startActivity(intent8);
            }
        });
        binding.cvTableName10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent9 = new Intent(FirstCardActivity.this, TenthTableActivity.class);
                startActivity(intent9);
            }
        });
        binding.cvTableName11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent10 = new Intent(FirstCardActivity.this, EleventhTableActivity.class);
                startActivity(intent10);
            }
        });
        binding.cvTableName12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent11 = new Intent(FirstCardActivity.this, TwelevthTableActivity.class);
                startActivity(intent11);
            }
        });
    }

}