package com.example.agroclinic.sugarcaneSeeds;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivitySeedsInTrayBinding;

import java.text.DecimalFormat;

public class SeedsInTrayActivity extends AppCompatActivity {

    ActivitySeedsInTrayBinding binding;
    private DecimalFormat decimalFormat;
    private String valueofEditText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_seeds_in_tray);
        initView();
    }

    private void initView() {
        // Initialize decimal format to show one decimal place
        decimalFormat = new DecimalFormat("#0.0");
        binding.rgRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                binding.etLand.setText("0.0");
                if (checkedId == R.id.rbGunta) {

                    binding.tvMeasurement.setText("गुंठा");
                } else if (checkedId == R.id.rbHector) {

                    binding.tvMeasurement.setText("हेक्टर");
                } else if (checkedId == R.id.rbEkar) {

                    binding.tvMeasurement.setText("एकर");
                } else {

                    binding.tvMeasurement.setText(" ");
                }
            }
        });

        binding.btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Decrease value by 0.5
                decreaseValue();
            }
        });

        binding.btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increase value by 0.5
                increaseValue();
            }
        });
        // Add a TextWatcher to continuously monitor EditText changes
        binding.etLand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    String input = s.toString();
                    if (binding.rbEkar.isChecked()) {
                        valueForCalculation(input);
                    } else if (binding.rbHector.isChecked()) {
                        valueForCalculationOfHector(input);
                    } else if (binding.rbGunta.isChecked()) {
                        valueForCalculationOfGunta(input);
                    } else {
                        Toast.makeText(SeedsInTrayActivity.this, "कृपया एकक निवडा", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    binding.etLand.setText("0.0");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.tvMeasurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void valueForCalculationOfGunta(String input) {
        //Calculation for 4
        //CalculationFor1.5
        float inputFromEditText = Float.parseFloat(input);
        double seedsForOneFive = (inputFromEditText * 181.5);
        double seedsForOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForOneFive));
        double roundSeedsForOneFiveTwoDigits=Math.round(seedsForOneFiveTwoDigits);
        binding.tvSeedsOneFive.setText(String.valueOf(roundSeedsForOneFiveTwoDigits));

        double cocoPitOneFive = (inputFromEditText * 7.62);
        double cocoPitOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitOneFive));
        double roundCocoPitOneFiveTwoDigits=Math.round(cocoPitOneFiveTwoDigits);
        binding.tvCoCoOneFive.setText(String.valueOf(roundCocoPitOneFiveTwoDigits+" किलो"));

        double shenKhatOneFive = (inputFromEditText * 2.17);
        double shenKhatOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatOneFive));
        double roundshenKhatOneFiveTwoDigits=Math.round(shenKhatOneFiveTwoDigits);
        binding.tvManureOneFive.setText(String.valueOf(roundshenKhatOneFiveTwoDigits+" किलो"));
        binding.tvPoytaOneFive.setText(String.valueOf(roundshenKhatOneFiveTwoDigits+" किलो"));


        double barikMOneFive = (inputFromEditText * 1.08);
        double barikMOneFiveFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMOneFive));
        double roundBarikMOneFiveTwoDigits=Math.round(barikMOneFiveFiveTwoDigits);
        binding.tvSamllSOneFive.setText(String.valueOf(roundBarikMOneFiveTwoDigits+" किलो"));

        //Calculation 2
        double seedsForTwo = (inputFromEditText * 136.12);
        double seedsForTwoTwoDigits = Double.parseDouble(String.format("%.2f", seedsForTwo));
        double roundSeedsForTwoTwoDigits=Math.round(seedsForTwoTwoDigits);
        binding.tvSeedsTwo.setText(String.valueOf(roundSeedsForTwoTwoDigits));

        double cocoPitTwo = (inputFromEditText * 5.71);
        double cocoPitTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitTwo));
        double roundCocoPitTwoDigits=Math.round(cocoPitTwoDigits);
        binding.tvCoCoTwo.setText(String.valueOf(roundCocoPitTwoDigits+" किलो"));

        double shenKhatTwo = (inputFromEditText * 1.63);
        double shenKhatTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatTwo));
        double roundshenKhatTwoDigits=Math.round(shenKhatTwoDigits);
        binding.tvManureTwo.setText(String.valueOf(roundshenKhatTwoDigits+" किलो"));
        binding.tvPoytaTwo.setText(String.valueOf(roundshenKhatTwoDigits+" किलो"));

        double barikMTwo = (inputFromEditText * 0.81);
        double barikMTwoDigits = Double.parseDouble(String.format("%.2f", barikMTwo));
        double roundBarikMTwoDigits=Math.round(barikMTwoDigits);
        binding.tvSamllSTwo.setText(String.valueOf(roundBarikMTwoDigits+" किलो"));

        //Calculation 2.5
        double seedsForTwoFive = (inputFromEditText * 108.9);
        double seedsForTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForTwoFive));
        double roundSeedsForTwoFiveTwoDigits=Math.round(seedsForTwoFiveTwoDigits);
        binding.tvSeedsTwoFive.setText(String.valueOf(roundSeedsForTwoFiveTwoDigits));

        double cocoPitTwoFive = (inputFromEditText * 4.57);
        double cocoPitTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitTwoFive));
        double roundCocoPitTwoFiveTwoDigits=Math.round(cocoPitTwoFiveTwoDigits);
        binding.tvCoCoTwoFive.setText(String.valueOf(roundCocoPitTwoFiveTwoDigits+" किलो"));

        double shenKhatTwoFive = (inputFromEditText * 1.30);
        double shenKhatOneTwoTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatTwoFive));
        double roundshenKhatTwoFiveTwoDigits=Math.round(shenKhatOneTwoTwoDigits);
        binding.tvManureTwoFive.setText(String.valueOf(roundshenKhatTwoFiveTwoDigits+" किलो"));
        binding.tvPoytaTwoFive.setText(String.valueOf(roundshenKhatTwoFiveTwoDigits+" किलो"));


        double barikMTwoFive = (inputFromEditText * 0.65);
        double barikMTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMTwoFive));
        double roundBarikMTwoFiveTwoDigits=Math.round(barikMTwoFiveTwoDigits);
        binding.tvSamllSTwoFive.setText(String.valueOf(roundBarikMTwoFiveTwoDigits+" किलो"));

        //calculationFor4.5
        //CalculationFor1.5
        double seedsForFFOneFive = (inputFromEditText * 161.32);
        double seedsForFFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFFOneFive));
        double roundSeedsFFForOneFiveTwoDigits=Math.round(seedsForFFOneFiveTwoDigits);
        binding.tvSeedsFFOneFive.setText(String.valueOf(roundSeedsFFForOneFiveTwoDigits));

        double cocoPitFFOneFive = (inputFromEditText * 6.77);
        double cocoPitFFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFFOneFive));
        double roundCocoFFPitOneFiveTwoDigits=Math.round(cocoPitFFOneFiveTwoDigits);
        binding.tvCoCoOneFFFive.setText(String.valueOf(roundCocoFFPitOneFiveTwoDigits+" किलो"));

        double shenKhatFFOneFive = (inputFromEditText * 1.93);
        double shenKhatFFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFFOneFive));
        double roundshenKhatOneFFFiveTwoDigits=Math.round(shenKhatFFOneFiveTwoDigits);
        binding.tvManureFFOneFive.setText(String.valueOf(roundshenKhatOneFFFiveTwoDigits+" किलो"));
        binding.tvPoytaFFOneFive.setText(String.valueOf(roundshenKhatOneFFFiveTwoDigits+" किलो"));


        double barikMFFOneFive = (inputFromEditText * 0.96);
        double barikMFFOneFiveFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFFOneFive));
        double roundFFBarikMOneFiveTwoDigits=Math.round(barikMFFOneFiveFiveTwoDigits);
        binding.tvSamllSFFOneFive.setText(String.valueOf(roundFFBarikMOneFiveTwoDigits+" किलो"));

        //Calculation 2
        double seedsForFFTwo = (inputFromEditText * 121.0);
        double seedsForFFTwoTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFFTwo));
        double roundSeedsForFFTwoTwoDigits=Math.round(seedsForFFTwoTwoDigits);
        binding.tvSeedsFFTwo.setText(String.valueOf(roundSeedsForFFTwoTwoDigits));

        double cocoPitFFTwo = (inputFromEditText * 5.08);
        double cocoPitFFTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFFTwo));
        double roundCocoPitFFTwoDigits=Math.round(cocoPitFFTwoDigits);
        binding.tvCoCoFFTwo.setText(String.valueOf(roundCocoPitFFTwoDigits+" किलो"));

        double shenKhatFFTwo = (inputFromEditText * 1.45);
        double shenKhatFFTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFFTwo));
        double roundshenKhatFFTwoDigits=Math.round(shenKhatFFTwoDigits);
        binding.tvManureFFTwo.setText(String.valueOf(roundshenKhatFFTwoDigits+" किलो"));
        binding.tvPoytaFFTwo.setText(String.valueOf(roundshenKhatFFTwoDigits+" किलो"));

        double barikMFFTwo = (inputFromEditText * 0.72);
        double barikMFFTwoDigits = Double.parseDouble(String.format("%.2f", barikMFFTwo));
        double roundBarikMFFTwoDigits=Math.round(barikMFFTwoDigits);
        binding.tvSamllSFFTwo.setText(String.valueOf(roundBarikMFFTwoDigits+" किलो"));


        //Calculation 2.5
        double seedsForFFTwoFive = (inputFromEditText * 96.8);
        double seedsForFFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFFTwoFive));
        double roundSeedsForFFTwoFiveTwoDigits=Math.round(seedsForFFTwoFiveTwoDigits);
        binding.tvSeedsFFTwoFive.setText(String.valueOf(roundSeedsForFFTwoFiveTwoDigits));

        double cocoPitFFTwoFive = (inputFromEditText * 4.06);
        double cocoPitFFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFFTwoFive));
        double roundCocoPitFFTwoFiveTwoDigits=Math.round(cocoPitFFTwoFiveTwoDigits);
        binding.tvCoCoFFTwoFive.setText(String.valueOf(roundCocoPitFFTwoFiveTwoDigits+" किलो"));

        double shenKhatFFTwoFive = (inputFromEditText * 1.16);
        double shenKhatFFOneTwoTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFFTwoFive));
        double roundshenKhatFFTwoFiveTwoDigits=Math.round(shenKhatFFOneTwoTwoDigits);
        binding.tvManureFFTwoFive.setText(String.valueOf(roundshenKhatFFTwoFiveTwoDigits+" किलो"));
        binding.tvPoytaFFTwoFive.setText(String.valueOf(roundshenKhatFFTwoFiveTwoDigits+" किलो"));


        double barikMFFTwoFive = (inputFromEditText * 0.58);
        double barikMFFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFFTwoFive));
        double roundBarikFFMTwoFiveTwoDigits=Math.round(barikMFFTwoFiveTwoDigits);
        binding.tvSamllSFFTwoFive.setText(String.valueOf(roundBarikFFMTwoFiveTwoDigits+" किलो"));

        //Calculation For 5
        //CalculationFor1.5
        double seedsForFOneFive = (inputFromEditText * 145.2);
        double seedsForFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFOneFive));
        double roundSeedsFForOneFiveTwoDigits=Math.round(seedsForFOneFiveTwoDigits);
        binding.tvSeedsFOneFive.setText(String.valueOf(roundSeedsFForOneFiveTwoDigits));

        double cocoPitFOneFive = (inputFromEditText * 6.09);
        double cocoPitFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFOneFive));
        double roundCocoFPitOneFiveTwoDigits=Math.round(cocoPitFOneFiveTwoDigits);
        binding.tvCoCoOneFFive.setText(String.valueOf(roundCocoFPitOneFiveTwoDigits+" किलो"));

        double shenKhatFOneFive = (inputFromEditText * 1.74);
        double shenKhatFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFOneFive));
        double roundshenKhatOneFFiveTwoDigits=Math.round(shenKhatFOneFiveTwoDigits);
        binding.tvManureFOneFive.setText(String.valueOf(roundshenKhatOneFFiveTwoDigits+" किलो"));
        binding.tvPoytaFOneFive.setText(String.valueOf(roundshenKhatOneFFiveTwoDigits+" किलो"));


        double barikMFOneFive = (inputFromEditText * 0.87);
        double barikMFOneFiveFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFOneFive));
        double roundFBarikMOneFiveTwoDigits=Math.round(barikMFOneFiveFiveTwoDigits);
        binding.tvSamllSFOneFive.setText(String.valueOf(roundFBarikMOneFiveTwoDigits+" किलो"));


        //Calculation 2
        double seedsForFTwo = (inputFromEditText * 108.9);
        double seedsForFTwoTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFTwo));
        double roundSeedsForFTwoTwoDigits=Math.round(seedsForFTwoTwoDigits);
        binding.tvSeedsFTwo.setText(String.valueOf(roundSeedsForFTwoTwoDigits));

        double cocoPitFTwo = (inputFromEditText * 4.57);
        double cocoPitFTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFTwo));
        double roundCocoPitFTwoDigits=Math.round(cocoPitFTwoDigits);
        binding.tvCoCoFTwo.setText(String.valueOf(roundCocoPitFTwoDigits+" किलो"));

        double shenKhatFTwo = (inputFromEditText * 1.30);
        double shenKhatFTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFTwo));
        double roundshenKhatFTwoDigits=Math.round(shenKhatFTwoDigits);
        binding.tvManureFTwo.setText(String.valueOf(roundshenKhatFTwoDigits+" किलो"));
        binding.tvPoytaFTwo.setText(String.valueOf(roundshenKhatFTwoDigits+" किलो"));

        double barikMFTwo = (inputFromEditText * 0.65);
        double barikMFTwoDigits = Double.parseDouble(String.format("%.2f", barikMFTwo));
        double roundBarikMFTwoDigits=Math.round(barikMFTwoDigits);
        binding.tvSamllSFTwo.setText(String.valueOf(roundBarikMFTwoDigits+" किलो"));

        //Calculation 2.5
        double seedsForFTwoFive = (inputFromEditText * 87.12);
        double seedsForFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFTwoFive));
        double roundSeedsForFTwoFiveTwoDigits=Math.round(seedsForFTwoFiveTwoDigits);
        binding.tvSeedsFTwoFive.setText(String.valueOf(roundSeedsForFTwoFiveTwoDigits));

        double cocoPitFTwoFive = (inputFromEditText * 3.65);
        double cocoPitFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFTwoFive));
        double roundCocoPitFTwoFiveTwoDigits=Math.round(cocoPitFTwoFiveTwoDigits);
        binding.tvCoCoFTwoFive.setText(String.valueOf(roundCocoPitFTwoFiveTwoDigits+" किलो"));

        double shenKhatFTwoFive = (inputFromEditText * 1.04);
        double shenKhatFOneTwoTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFTwoFive));
        double roundshenKhatFTwoFiveTwoDigits=Math.round(shenKhatFOneTwoTwoDigits);
        binding.tvManureFTwoFive.setText(String.valueOf(roundshenKhatFTwoFiveTwoDigits+" किलो"));
        binding.tvPoytaFTwoFive.setText(String.valueOf(roundshenKhatFTwoFiveTwoDigits+" किलो"));


        double barikMFTwoFive = (inputFromEditText * 0.52);
        double barikMFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFTwoFive));
        double roundBarikFMTwoFiveTwoDigits=Math.round(barikMFTwoFiveTwoDigits);
        binding.tvSamllSFTwoFive.setText(String.valueOf(roundBarikFMTwoFiveTwoDigits+" किलो"));
    }

    private void valueForCalculationOfHector(String input) {
        //Calculation for 4
        //CalculationFor1.5
        float inputFromEditText = Float.parseFloat(input);
        double seedsForOneFive = (inputFromEditText * 18150.0);
        double seedsForOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForOneFive));
        double roundSeedsForOneFiveTwoDigits=Math.round(seedsForOneFiveTwoDigits);
        binding.tvSeedsOneFive.setText(String.valueOf(roundSeedsForOneFiveTwoDigits));

        double cocoPitOneFive = (inputFromEditText * 762.32);
        double cocoPitOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitOneFive));
        double roundCocoPitOneFiveTwoDigits=Math.round(cocoPitOneFiveTwoDigits);
        binding.tvCoCoOneFive.setText(String.valueOf(roundCocoPitOneFiveTwoDigits+" किलो"));

        double shenKhatOneFive = (inputFromEditText * 217.8);
        double shenKhatOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatOneFive));
        double roundshenKhatOneFiveTwoDigits=Math.round(shenKhatOneFiveTwoDigits);
        binding.tvManureOneFive.setText(String.valueOf(roundshenKhatOneFiveTwoDigits+" किलो"));
        binding.tvPoytaOneFive.setText(String.valueOf(roundshenKhatOneFiveTwoDigits+" किलो"));


        double barikMOneFive = (inputFromEditText * 108.9);
        double barikMOneFiveFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMOneFive));
        double roundBarikMOneFiveTwoDigits=Math.round(barikMOneFiveFiveTwoDigits);
        binding.tvSamllSOneFive.setText(String.valueOf(roundBarikMOneFiveTwoDigits+" किलो"));

        //Calculation 2
        double seedsForTwo = (inputFromEditText * 13612.5);
        double seedsForTwoTwoDigits = Double.parseDouble(String.format("%.2f", seedsForTwo));
        double roundSeedsForTwoTwoDigits=Math.round(seedsForTwoTwoDigits);
        binding.tvSeedsTwo.setText(String.valueOf(roundSeedsForTwoTwoDigits));

        double cocoPitTwo = (inputFromEditText * 517.12);
        double cocoPitTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitTwo));
        double roundCocoPitTwoDigits=Math.round(cocoPitTwoDigits);
        binding.tvCoCoTwo.setText(String.valueOf(roundCocoPitTwoDigits+" किलो"));

        double shenKhatTwo = (inputFromEditText * 163.35);
        double shenKhatTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatTwo));
        double roundshenKhatTwoDigits=Math.round(shenKhatTwoDigits);
        binding.tvManureTwo.setText(String.valueOf(roundshenKhatTwoDigits+" किलो"));
        binding.tvPoytaTwo.setText(String.valueOf(roundshenKhatTwoDigits+" किलो"));

        double barikMTwo = (inputFromEditText * 81.65);
        double barikMTwoDigits = Double.parseDouble(String.format("%.2f", barikMTwo));
        double roundBarikMTwoDigits=Math.round(barikMTwoDigits);
        binding.tvSamllSTwo.setText(String.valueOf(roundBarikMTwoDigits+" किलो"));

        //Calculation 2.5
        double seedsForTwoFive = (inputFromEditText * 10890.0);
        double seedsForTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForTwoFive));
        double roundSeedsForTwoFiveTwoDigits=Math.round(seedsForTwoFiveTwoDigits);
        binding.tvSeedsTwoFive.setText(String.valueOf(roundSeedsForTwoFiveTwoDigits));

        double cocoPitTwoFive = (inputFromEditText * 457.37);
        double cocoPitTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitTwoFive));
        double roundCocoPitTwoFiveTwoDigits=Math.round(cocoPitTwoFiveTwoDigits);
        binding.tvCoCoTwoFive.setText(String.valueOf(roundCocoPitTwoFiveTwoDigits+" किलो"));

        double shenKhatTwoFive = (inputFromEditText * 130.67);
        double shenKhatOneTwoTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatTwoFive));
        double roundshenKhatTwoFiveTwoDigits=Math.round(shenKhatOneTwoTwoDigits);
        binding.tvManureTwoFive.setText(String.valueOf(roundshenKhatTwoFiveTwoDigits+" किलो"));
        binding.tvPoytaTwoFive.setText(String.valueOf(roundshenKhatTwoFiveTwoDigits+" किलो"));


        double barikMTwoFive = (inputFromEditText * 65.35);
        double barikMTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMTwoFive));
        double roundBarikMTwoFiveTwoDigits=Math.round(barikMTwoFiveTwoDigits);
        binding.tvSamllSTwoFive.setText(String.valueOf(roundBarikMTwoFiveTwoDigits+" किलो"));

        //calculationFor4.5
        //CalculationFor1.5
        double seedsForFFOneFive = (inputFromEditText * 16132.5);
        double seedsForFFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFFOneFive));
        double roundSeedsFFForOneFiveTwoDigits=Math.round(seedsForFFOneFiveTwoDigits);
        binding.tvSeedsFFOneFive.setText(String.valueOf(roundSeedsFFForOneFiveTwoDigits));

        double cocoPitFFOneFive = (inputFromEditText * 677.67);
        double cocoPitFFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFFOneFive));
        double roundCocoFFPitOneFiveTwoDigits=Math.round(cocoPitFFOneFiveTwoDigits);
        binding.tvCoCoOneFFFive.setText(String.valueOf(roundCocoFFPitOneFiveTwoDigits+" किलो"));

        double shenKhatFFOneFive = (inputFromEditText * 193.6);
        double shenKhatFFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFFOneFive));
        double roundshenKhatOneFFFiveTwoDigits=Math.round(shenKhatFFOneFiveTwoDigits);
        binding.tvManureFFOneFive.setText(String.valueOf(roundshenKhatOneFFFiveTwoDigits+" किलो"));
        binding.tvPoytaFFOneFive.setText(String.valueOf(roundshenKhatOneFFFiveTwoDigits+" किलो"));


        double barikMFFOneFive = (inputFromEditText * 96.8);
        double barikMFFOneFiveFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFFOneFive));
        double roundFFBarikMOneFiveTwoDigits=Math.round(barikMFFOneFiveFiveTwoDigits);
        binding.tvSamllSFFOneFive.setText(String.valueOf(roundFFBarikMOneFiveTwoDigits+" किलो"));

        //Calculation 2
        double seedsForFFTwo = (inputFromEditText * 12100.0);
        double seedsForFFTwoTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFFTwo));
        double roundSeedsForFFTwoTwoDigits=Math.round(seedsForFFTwoTwoDigits);
        binding.tvSeedsFFTwo.setText(String.valueOf(roundSeedsForFFTwoTwoDigits));

        double cocoPitFFTwo = (inputFromEditText * 508.2);
        double cocoPitFFTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFFTwo));
        double roundCocoPitFFTwoDigits=Math.round(cocoPitFFTwoDigits);
        binding.tvCoCoFFTwo.setText(String.valueOf(roundCocoPitFFTwoDigits+" किलो"));

        double shenKhatFFTwo = (inputFromEditText * 145.2);
        double shenKhatFFTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFFTwo));
        double roundshenKhatFFTwoDigits=Math.round(shenKhatFFTwoDigits);
        binding.tvManureFFTwo.setText(String.valueOf(roundshenKhatFFTwoDigits+" किलो"));
        binding.tvPoytaFFTwo.setText(String.valueOf(roundshenKhatFFTwoDigits+" किलो"));

        double barikMFFTwo = (inputFromEditText * 72.6);
        double barikMFFTwoDigits = Double.parseDouble(String.format("%.2f", barikMFFTwo));
        double roundBarikMFFTwoDigits=Math.round(barikMFFTwoDigits);
        binding.tvSamllSFFTwo.setText(String.valueOf(roundBarikMFFTwoDigits+" किलो"));


        //Calculation 2.5
        double seedsForFFTwoFive = (inputFromEditText * 9680.0);
        double seedsForFFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFFTwoFive));
        double roundSeedsForFFTwoFiveTwoDigits=Math.round(seedsForFFTwoFiveTwoDigits);
        binding.tvSeedsFFTwoFive.setText(String.valueOf(roundSeedsForFFTwoFiveTwoDigits));

        double cocoPitFFTwoFive = (inputFromEditText * 406.55);
        double cocoPitFFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFFTwoFive));
        double roundCocoPitFFTwoFiveTwoDigits=Math.round(cocoPitFFTwoFiveTwoDigits);
        binding.tvCoCoFFTwoFive.setText(String.valueOf(roundCocoPitFFTwoFiveTwoDigits+" किलो"));

        double shenKhatFFTwoFive = (inputFromEditText * 116.15);
        double shenKhatFFOneTwoTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFFTwoFive));
        double roundshenKhatFFTwoFiveTwoDigits=Math.round(shenKhatFFOneTwoTwoDigits);
        binding.tvManureFFTwoFive.setText(String.valueOf(roundshenKhatFFTwoFiveTwoDigits+" किलो"));
        binding.tvPoytaFFTwoFive.setText(String.valueOf(roundshenKhatFFTwoFiveTwoDigits+" किलो"));


        double barikMFFTwoFive = (inputFromEditText * 65.04);
        double barikMFFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFFTwoFive));
        double roundBarikFFMTwoFiveTwoDigits=Math.round(barikMFFTwoFiveTwoDigits);
        binding.tvSamllSFFTwoFive.setText(String.valueOf(roundBarikFFMTwoFiveTwoDigits+" किलो"));

        //Calculation For 5
        //CalculationFor1.5
        double seedsForFOneFive = (inputFromEditText * 14520.0);
        double seedsForFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFOneFive));
        double roundSeedsFForOneFiveTwoDigits=Math.round(seedsForFOneFiveTwoDigits);
        binding.tvSeedsFOneFive.setText(String.valueOf(roundSeedsFForOneFiveTwoDigits));

        double cocoPitFOneFive = (inputFromEditText * 609.85);
        double cocoPitFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFOneFive));
        double roundCocoFPitOneFiveTwoDigits=Math.round(cocoPitFOneFiveTwoDigits);
        binding.tvCoCoOneFFive.setText(String.valueOf(roundCocoFPitOneFiveTwoDigits+" किलो"));

        double shenKhatFOneFive = (inputFromEditText * 174.25);
        double shenKhatFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFOneFive));
        double roundshenKhatOneFFiveTwoDigits=Math.round(shenKhatFOneFiveTwoDigits);
        binding.tvManureFOneFive.setText(String.valueOf(roundshenKhatOneFFiveTwoDigits+" किलो"));
        binding.tvPoytaFOneFive.setText(String.valueOf(roundshenKhatOneFFiveTwoDigits+" किलो"));


        double barikMFOneFive = (inputFromEditText * 87.12);
        double barikMFOneFiveFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFOneFive));
        double roundFBarikMOneFiveTwoDigits=Math.round(barikMFOneFiveFiveTwoDigits);
        binding.tvSamllSFOneFive.setText(String.valueOf(roundFBarikMOneFiveTwoDigits+" किलो"));


        //Calculation 2
        double seedsForFTwo = (inputFromEditText * 10890.0);
        double seedsForFTwoTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFTwo));
        double roundSeedsForFTwoTwoDigits=Math.round(seedsForFTwoTwoDigits);
        binding.tvSeedsFTwo.setText(String.valueOf(roundSeedsForFTwoTwoDigits));

        double cocoPitFTwo = (inputFromEditText * 457.37);
        double cocoPitFTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFTwo));
        double roundCocoPitFTwoDigits=Math.round(cocoPitFTwoDigits);
        binding.tvCoCoFTwo.setText(String.valueOf(roundCocoPitFTwoDigits+" किलो"));

        double shenKhatFTwo = (inputFromEditText * 130.67);
        double shenKhatFTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFTwo));
        double roundshenKhatFTwoDigits=Math.round(shenKhatFTwoDigits);
        binding.tvManureFTwo.setText(String.valueOf(roundshenKhatFTwoDigits+" किलो"));
        binding.tvPoytaFTwo.setText(String.valueOf(roundshenKhatFTwoDigits+" किलो"));

        double barikMFTwo = (inputFromEditText * 65.35);
        double barikMFTwoDigits = Double.parseDouble(String.format("%.2f", barikMFTwo));
        double roundBarikMFTwoDigits=Math.round(barikMFTwoDigits);
        binding.tvSamllSFTwo.setText(String.valueOf(roundBarikMFTwoDigits+" किलो"));

        //Calculation 2.5
        double seedsForFTwoFive = (inputFromEditText * 8712.5);
        double seedsForFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFTwoFive));
        double roundSeedsForFTwoFiveTwoDigits=Math.round(seedsForFTwoFiveTwoDigits);
        binding.tvSeedsFTwoFive.setText(String.valueOf(roundSeedsForFTwoFiveTwoDigits));

        double cocoPitFTwoFive = (inputFromEditText * 365.92);
        double cocoPitFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFTwoFive));
        double roundCocoPitFTwoFiveTwoDigits=Math.round(cocoPitFTwoFiveTwoDigits);
        binding.tvCoCoFTwoFive.setText(String.valueOf(roundCocoPitFTwoFiveTwoDigits+" किलो"));

        double shenKhatFTwoFive = (inputFromEditText * 104.55);
        double shenKhatFOneTwoTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFTwoFive));
        double roundshenKhatFTwoFiveTwoDigits=Math.round(shenKhatFOneTwoTwoDigits);
        binding.tvManureFTwoFive.setText(String.valueOf(roundshenKhatFTwoFiveTwoDigits+" किलो"));
        binding.tvPoytaFTwoFive.setText(String.valueOf(roundshenKhatFTwoFiveTwoDigits+" किलो"));


        double barikMFTwoFive = (inputFromEditText * 52.27);
        double barikMFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFTwoFive));
        double roundBarikFMTwoFiveTwoDigits=Math.round(barikMFTwoFiveTwoDigits);
        binding.tvSamllSFTwoFive.setText(String.valueOf(roundBarikFMTwoFiveTwoDigits+" किलो"));
    }

    private void valueForCalculation(String input) {

        //Calculation for 4
        //CalculationFor1.5
        float inputFromEditText = Float.parseFloat(input);
        double seedsForOneFive = (inputFromEditText * 7260.0);
        double seedsForOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForOneFive));
        double roundSeedsForOneFiveTwoDigits=Math.round(seedsForOneFiveTwoDigits);
        binding.tvSeedsOneFive.setText(String.valueOf(roundSeedsForOneFiveTwoDigits));

        double cocoPitOneFive = (inputFromEditText * 304.92);
        double cocoPitOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitOneFive));
        double roundCocoPitOneFiveTwoDigits=Math.round(cocoPitOneFiveTwoDigits);
        binding.tvCoCoOneFive.setText(String.valueOf(roundCocoPitOneFiveTwoDigits+" किलो"));

        double shenKhatOneFive = (inputFromEditText * 87.12);
        double shenKhatOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatOneFive));
        double roundshenKhatOneFiveTwoDigits=Math.round(shenKhatOneFiveTwoDigits);
        binding.tvManureOneFive.setText(String.valueOf(roundshenKhatOneFiveTwoDigits+" किलो"));
        binding.tvPoytaOneFive.setText(String.valueOf(roundshenKhatOneFiveTwoDigits+" किलो"));


        double barikMOneFive = (inputFromEditText * 43.56);
        double barikMOneFiveFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMOneFive));
        double roundBarikMOneFiveTwoDigits=Math.round(barikMOneFiveFiveTwoDigits);
        binding.tvSamllSOneFive.setText(String.valueOf(roundBarikMOneFiveTwoDigits+" किलो"));

        //Calculation 2
        double seedsForTwo = (inputFromEditText * 5445.0);
        double seedsForTwoTwoDigits = Double.parseDouble(String.format("%.2f", seedsForTwo));
        double roundSeedsForTwoTwoDigits=Math.round(seedsForTwoTwoDigits);
        binding.tvSeedsTwo.setText(String.valueOf(roundSeedsForTwoTwoDigits));

        double cocoPitTwo = (inputFromEditText * 228.69);
        double cocoPitTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitTwo));
        double roundCocoPitTwoDigits=Math.round(cocoPitTwoDigits);
        binding.tvCoCoTwo.setText(String.valueOf(roundCocoPitTwoDigits+" किलो"));

        double shenKhatTwo = (inputFromEditText * 65.34);
        double shenKhatTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatTwo));
        double roundshenKhatTwoDigits=Math.round(shenKhatTwoDigits);
        binding.tvManureTwo.setText(String.valueOf(roundshenKhatTwoDigits+" किलो"));
        binding.tvPoytaTwo.setText(String.valueOf(roundshenKhatTwoDigits+" किलो"));

        double barikMTwo = (inputFromEditText * 32.67);
        double barikMTwoDigits = Double.parseDouble(String.format("%.2f", barikMTwo));
        double roundBarikMTwoDigits=Math.round(barikMTwoDigits);
        binding.tvSamllSTwo.setText(String.valueOf(roundBarikMTwoDigits+" किलो"));

        //Calculation 2.5
        double seedsForTwoFive = (inputFromEditText * 4356.0);
        double seedsForTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForTwoFive));
        double roundSeedsForTwoFiveTwoDigits=Math.round(seedsForTwoFiveTwoDigits);
        binding.tvSeedsTwoFive.setText(String.valueOf(roundSeedsForTwoFiveTwoDigits));

        double cocoPitTwoFive = (inputFromEditText * 182.95);
        double cocoPitTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitTwoFive));
        double roundCocoPitTwoFiveTwoDigits=Math.round(cocoPitTwoFiveTwoDigits);
        binding.tvCoCoTwoFive.setText(String.valueOf(roundCocoPitTwoFiveTwoDigits+" किलो"));

        double shenKhatTwoFive = (inputFromEditText * 52.27);
        double shenKhatOneTwoTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatTwoFive));
        double roundshenKhatTwoFiveTwoDigits=Math.round(shenKhatOneTwoTwoDigits);
        binding.tvManureTwoFive.setText(String.valueOf(roundshenKhatTwoFiveTwoDigits+" किलो"));
        binding.tvPoytaTwoFive.setText(String.valueOf(roundshenKhatTwoFiveTwoDigits+" किलो"));


        double barikMTwoFive = (inputFromEditText * 26.14);
        double barikMTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMTwoFive));
        double roundBarikMTwoFiveTwoDigits=Math.round(barikMTwoFiveTwoDigits);
        binding.tvSamllSTwoFive.setText(String.valueOf(roundBarikMTwoFiveTwoDigits+" किलो"));

        //calculationFor4.5
        //CalculationFor1.5
        double seedsForFFOneFive = (inputFromEditText * 6453.0);
        double seedsForFFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFFOneFive));
        double roundSeedsFFForOneFiveTwoDigits=Math.round(seedsForFFOneFiveTwoDigits);
        binding.tvSeedsFFOneFive.setText(String.valueOf(roundSeedsFFForOneFiveTwoDigits));

        double cocoPitFFOneFive = (inputFromEditText * 271.07);
        double cocoPitFFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFFOneFive));
        double roundCocoFFPitOneFiveTwoDigits=Math.round(cocoPitFFOneFiveTwoDigits);
        binding.tvCoCoOneFFFive.setText(String.valueOf(roundCocoFFPitOneFiveTwoDigits+" किलो"));

        double shenKhatFFOneFive = (inputFromEditText * 77.44);
        double shenKhatFFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFFOneFive));
        double roundshenKhatOneFFFiveTwoDigits=Math.round(shenKhatFFOneFiveTwoDigits);
        binding.tvManureFFOneFive.setText(String.valueOf(roundshenKhatOneFFFiveTwoDigits+" किलो"));
        binding.tvPoytaFFOneFive.setText(String.valueOf(roundshenKhatOneFFFiveTwoDigits+" किलो"));


        double barikMFFOneFive = (inputFromEditText * 38.72);
        double barikMFFOneFiveFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFFOneFive));
        double roundFFBarikMOneFiveTwoDigits=Math.round(barikMFFOneFiveFiveTwoDigits);
        binding.tvSamllSFFOneFive.setText(String.valueOf(roundFFBarikMOneFiveTwoDigits+" किलो"));

        //Calculation 2
        double seedsForFFTwo = (inputFromEditText * 4840.0);
        double seedsForFFTwoTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFFTwo));
        double roundSeedsForFFTwoTwoDigits=Math.round(seedsForFFTwoTwoDigits);
        binding.tvSeedsFFTwo.setText(String.valueOf(roundSeedsForFFTwoTwoDigits));

        double cocoPitFFTwo = (inputFromEditText * 203.28);
        double cocoPitFFTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFFTwo));
        double roundCocoPitFFTwoDigits=Math.round(cocoPitFFTwoDigits);
        binding.tvCoCoFFTwo.setText(String.valueOf(roundCocoPitFFTwoDigits+" किलो"));

        double shenKhatFFTwo = (inputFromEditText * 58.08);
        double shenKhatFFTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFFTwo));
        double roundshenKhatFFTwoDigits=Math.round(shenKhatFFTwoDigits);
        binding.tvManureFFTwo.setText(String.valueOf(roundshenKhatFFTwoDigits+" किलो"));
        binding.tvPoytaFFTwo.setText(String.valueOf(roundshenKhatFFTwoDigits+" किलो"));

        double barikMFFTwo = (inputFromEditText * 29.04);
        double barikMFFTwoDigits = Double.parseDouble(String.format("%.2f", barikMFFTwo));
        double roundBarikMFFTwoDigits=Math.round(barikMFFTwoDigits);
        binding.tvSamllSFFTwo.setText(String.valueOf(roundBarikMFFTwoDigits+" किलो"));


        //Calculation 2.5
        double seedsForFFTwoFive = (inputFromEditText * 3872.0);
        double seedsForFFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFFTwoFive));
        double roundSeedsForFFTwoFiveTwoDigits=Math.round(seedsForFFTwoFiveTwoDigits);
        binding.tvSeedsFFTwoFive.setText(String.valueOf(roundSeedsForFFTwoFiveTwoDigits));

        double cocoPitFFTwoFive = (inputFromEditText * 162.62);
        double cocoPitFFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFFTwoFive));
        double roundCocoPitFFTwoFiveTwoDigits=Math.round(cocoPitFFTwoFiveTwoDigits);
        binding.tvCoCoFFTwoFive.setText(String.valueOf(roundCocoPitFFTwoFiveTwoDigits+" किलो"));

        double shenKhatFFTwoFive = (inputFromEditText * 46.46);
        double shenKhatFFOneTwoTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFFTwoFive));
        double roundshenKhatFFTwoFiveTwoDigits=Math.round(shenKhatFFOneTwoTwoDigits);
        binding.tvManureFFTwoFive.setText(String.valueOf(roundshenKhatFFTwoFiveTwoDigits+" किलो"));
        binding.tvPoytaFFTwoFive.setText(String.valueOf(roundshenKhatFFTwoFiveTwoDigits+" किलो"));


        double barikMFFTwoFive = (inputFromEditText * 23.23);
        double barikMFFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFFTwoFive));
        double roundBarikFFMTwoFiveTwoDigits=Math.round(barikMFFTwoFiveTwoDigits);
        binding.tvSamllSFFTwoFive.setText(String.valueOf(roundBarikFFMTwoFiveTwoDigits+" किलो"));

        //Calculation For 5
        //CalculationFor1.5
        double seedsForFOneFive = (inputFromEditText * 5808.0);
        double seedsForFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFOneFive));
        double roundSeedsFForOneFiveTwoDigits=Math.round(seedsForFOneFiveTwoDigits);
        binding.tvSeedsFOneFive.setText(String.valueOf(roundSeedsFForOneFiveTwoDigits));

        double cocoPitFOneFive = (inputFromEditText * 243.94);
        double cocoPitFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFOneFive));
        double roundCocoFPitOneFiveTwoDigits=Math.round(cocoPitFOneFiveTwoDigits);
        binding.tvCoCoOneFFive.setText(String.valueOf(roundCocoFPitOneFiveTwoDigits+" किलो"));

        double shenKhatFOneFive = (inputFromEditText * 69.70);
        double shenKhatFOneFiveTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFOneFive));
        double roundshenKhatOneFFiveTwoDigits=Math.round(shenKhatFOneFiveTwoDigits);
        binding.tvManureFOneFive.setText(String.valueOf(roundshenKhatOneFFiveTwoDigits+" किलो"));
        binding.tvPoytaFOneFive.setText(String.valueOf(roundshenKhatOneFFiveTwoDigits+" किलो"));


        double barikMFOneFive = (inputFromEditText * 34.85);
        double barikMFOneFiveFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFOneFive));
        double roundFBarikMOneFiveTwoDigits=Math.round(barikMFOneFiveFiveTwoDigits);
        binding.tvSamllSFOneFive.setText(String.valueOf(roundFBarikMOneFiveTwoDigits+" किलो"));


        //Calculation 2
        double seedsForFTwo = (inputFromEditText * 4356.0);
        double seedsForFTwoTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFTwo));
        double roundSeedsForFTwoTwoDigits=Math.round(seedsForFTwoTwoDigits);
        binding.tvSeedsFTwo.setText(String.valueOf(roundSeedsForFTwoTwoDigits));

        double cocoPitFTwo = (inputFromEditText * 182.95);
        double cocoPitFTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFTwo));
        double roundCocoPitFTwoDigits=Math.round(cocoPitFTwoDigits);
        binding.tvCoCoFTwo.setText(String.valueOf(roundCocoPitFTwoDigits+" किलो"));

        double shenKhatFTwo = (inputFromEditText * 52.27);
        double shenKhatFTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFTwo));
        double roundshenKhatFTwoDigits=Math.round(shenKhatFTwoDigits);
        binding.tvManureFTwo.setText(String.valueOf(roundshenKhatFTwoDigits+" किलो"));
        binding.tvPoytaFTwo.setText(String.valueOf(roundshenKhatFTwoDigits+" किलो"));

        double barikMFTwo = (inputFromEditText * 26.14);
        double barikMFTwoDigits = Double.parseDouble(String.format("%.2f", barikMFTwo));
        double roundBarikMFTwoDigits=Math.round(barikMFTwoDigits);
        binding.tvSamllSFTwo.setText(String.valueOf(roundBarikMFTwoDigits+" किलो"));

        //Calculation 2.5
        double seedsForFTwoFive = (inputFromEditText * 3485.0);
        double seedsForFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", seedsForFTwoFive));
        double roundSeedsForFTwoFiveTwoDigits=Math.round(seedsForFTwoFiveTwoDigits);
        binding.tvSeedsFTwoFive.setText(String.valueOf(roundSeedsForFTwoFiveTwoDigits));

        double cocoPitFTwoFive = (inputFromEditText * 146.37);
        double cocoPitFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", cocoPitFTwoFive));
        double roundCocoPitFTwoFiveTwoDigits=Math.round(cocoPitFTwoFiveTwoDigits);
        binding.tvCoCoFTwoFive.setText(String.valueOf(roundCocoPitFTwoFiveTwoDigits+" किलो"));

        double shenKhatFTwoFive = (inputFromEditText * 41.82);
        double shenKhatFOneTwoTwoDigits = Double.parseDouble(String.format("%.2f", shenKhatFTwoFive));
        double roundshenKhatFTwoFiveTwoDigits=Math.round(shenKhatFOneTwoTwoDigits);
        binding.tvManureFTwoFive.setText(String.valueOf(roundshenKhatFTwoFiveTwoDigits+" किलो"));
        binding.tvPoytaFTwoFive.setText(String.valueOf(roundshenKhatFTwoFiveTwoDigits+" किलो"));


        double barikMFTwoFive = (inputFromEditText * 20.19);
        double barikMFTwoFiveTwoDigits = Double.parseDouble(String.format("%.2f", barikMFTwoFive));
        double roundBarikFMTwoFiveTwoDigits=Math.round(barikMFTwoFiveTwoDigits);
        binding.tvSamllSFTwoFive.setText(String.valueOf(roundBarikFMTwoFiveTwoDigits+" किलो"));
    }

    private void increaseValue() {

        String currentValueStr = binding.etLand.getText().toString();
        float currentValue = Float.parseFloat(currentValueStr);
        currentValue += 0.5;
        binding.etLand.setText(decimalFormat.format(currentValue));
    }

    private void decreaseValue() {

        // Get current value from EditText
        String currentValueStr = binding.etLand.getText().toString();
        // Convert it to float
        float currentValue = Float.parseFloat(currentValueStr);
        // Decrease by 0.5 if currentValue > 0
        if (currentValue > 0) {
            currentValue -= 0.5;
            // If the  result is negative, set it to 0
            if (currentValue < 0) {
                currentValue = 0;
            }
            // Update EditText with the new value
            binding.etLand.setText(decimalFormat.format(currentValue)); // Potential issue here
        }
    }
}