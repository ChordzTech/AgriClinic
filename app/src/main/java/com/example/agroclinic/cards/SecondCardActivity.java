package com.example.agroclinic.cards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivitySecondCardBinding;
import com.example.agroclinic.userInputTables.UEighthActivity;
import com.example.agroclinic.userInputTables.UEleventhTableActivity;
import com.example.agroclinic.userInputTables.UFifthTableActivity;
import com.example.agroclinic.userInputTables.UFirstTableActivity;
import com.example.agroclinic.userInputTables.UFourthTableActivity;
import com.example.agroclinic.userInputTables.UNinthActivity;
import com.example.agroclinic.userInputTables.USeventhTableActivity;
import com.example.agroclinic.userInputTables.USixthTableActivity;
import com.example.agroclinic.userInputTables.UTenthTableActivity;
import com.example.agroclinic.userInputTables.UThirdTableActivity;
import com.example.agroclinic.userInputTables.UTwelthTableActivity;

public class SecondCardActivity extends AppCompatActivity {
    private ActivitySecondCardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second_card);
        initView();
    }

    private void initView() {
        binding.cvTableName1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondCardActivity.this, UFirstTableActivity.class);
                startActivity(intent);
            }
        });
        binding.cvTableName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SecondCardActivity.this, UFirstTableActivity.class);
                startActivity(intent1);
            }
        });
       binding.cvTableName3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent2 = new Intent(SecondCardActivity.this, UThirdTableActivity.class);
               startActivity(intent2);
           }
       });
        binding.cvTableName4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(SecondCardActivity.this, UFourthTableActivity.class);
                startActivity(intent3);
            }
        });
        binding.cvTableName5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(SecondCardActivity.this, UFifthTableActivity.class);
                startActivity(intent4);
            }
        });
        binding.cvTableName6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(SecondCardActivity.this, USixthTableActivity.class);
                startActivity(intent5);
            }
        });
        binding.cvTableName7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(SecondCardActivity.this, USeventhTableActivity.class);
                startActivity(intent6);
            }
        });
        binding.cvTableName8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(SecondCardActivity.this, UEighthActivity.class);
                startActivity(intent7);
            }
        });
        binding.cvTableName9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(SecondCardActivity.this, UNinthActivity.class);
                startActivity(intent8);
            }
        });
        binding.cvTableName10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent9 = new Intent(SecondCardActivity.this, UTenthTableActivity.class);
                startActivity(intent9);
            }
        });
        binding.cvTableName11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent10 = new Intent(SecondCardActivity.this, UEleventhTableActivity.class);
                startActivity(intent10);
            }
        });
        binding.cvTableName12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent11 = new Intent(SecondCardActivity.this, UTwelthTableActivity.class);
                startActivity(intent11);
            }
        });
    }
}