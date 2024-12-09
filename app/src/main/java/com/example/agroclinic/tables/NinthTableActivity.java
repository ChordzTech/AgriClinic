package com.example.agroclinic.tables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivityNinthTableBinding;

import java.text.DecimalFormat;

public class NinthTableActivity extends AppCompatActivity {
    ActivityNinthTableBinding binding;
    private DecimalFormat decimalFormat;
    private String valueofEditText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_ninth_table);
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
                    binding.tvN.setText("नत्र     - (N) :  4 किलो");
                    binding.tvP.setText("स्फुरद - (P): 1.7 किलो");
                    binding.tvK.setText("पालाश - (K): 1.7 किलो");
                    binding.tvMeasurement.setText("गुंठा");
                } else if (checkedId == R.id.rbHector) {
                    binding.tvN.setText("नत्र     - (N) : 400 किलो");
                    binding.tvP.setText("स्फुरद - (P): 170 किलो");
                    binding.tvK.setText("पालाश - (K): 170 किलो");
                    binding.tvMeasurement.setText("हेक्टर");
                } else if (checkedId == R.id.rbEkar) {
                    binding.tvN.setText("नत्र     - (N): 160 किलो");
                    binding.tvP.setText("स्फुरद - (P): 68 किलो");
                    binding.tvK.setText("पालाश - (K): 68 किलो");
                    binding.tvMeasurement.setText("एकर");
                } else {
                    binding.tvN.setText("नत्र     - (N): 0 किलो");
                    binding.tvP.setText("स्फुरद - (P): 0 किलो");
                    binding.tvK.setText("पालाश - (K): 0 किलो");
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
                        Toast.makeText(NinthTableActivity.this, "कृपया एकक निवडा", Toast.LENGTH_SHORT).show();
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
        float inputFromEditText = Float.parseFloat(input);
        //NPK=4:1.7:1.7
        //Calculations for 19:19:19
        //First Dose
        //First Dose
        double hundredKg = (2.10 * inputFromEditText);
        double hundredKgTwoDigits = Double.parseDouble(String.format("%.2f", hundredKg));
        binding.tv19InKg.setText(String.valueOf(hundredKgTwoDigits + " किलो"));
        binding.tv19InKgFourthWeek.setText(String.valueOf(hundredKgTwoDigits + " किलो"));
        //Bags Calculation
        double bagForFirstDose = (hundredKgTwoDigits / 45.0);
        double bagForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForFirstDose));
        binding.tv19InBags.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        binding.tv19InBagsFourthWeek.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        //Total
        double total19 = (hundredKgTwoDigits * 2);
        double total19TwoDigits = Double.parseDouble(String.format("%.2f", total19));
        binding.tvTotal19.setText(String.valueOf(total19TwoDigits + " किलो"));

        // Calculation for ssp
        // fifty percent of 1.7 =0.85
        double fiftyPercentOfP = (inputFromEditText * 0.85);
        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double minus19 = (fiftyPercentOfPTwoDigits - 0.4);
        double minus19TwoDigits = Double.parseDouble(String.format("%.2f", minus19));
        //        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double sspForFirstDose = ((minus19TwoDigits * 100.0) / 16.0);
        double sspForFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", sspForFirstDose));
        binding.tvSSPInKg.setText(String.valueOf(sspForFirstDoseTwoDigits + " किलो"));
        binding.tvSSF4.setText(String.valueOf(sspForFirstDoseTwoDigits + " किलो"));
        //Bags for ssp
        double bagsForSsp = (sspForFirstDoseTwoDigits / 50.0);
        double bagsForSspTwoDigits = Double.parseDouble(String.format("%.2f", bagsForSsp));
        binding.SSFBag4.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        binding.tvSSPInBag.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        //Total Ssp
        double totalSsp = (sspForFirstDoseTwoDigits * 2);
        double totalSspTwoDigits = Double.parseDouble(String.format("%.2f", totalSsp));
        binding.tvSsf.setText(String.valueOf(totalSspTwoDigits + " किलो"));

        //Calculation for Mop
        // fifty percent of 1.7 =0.85
        double fiftyPercentOfK = (inputFromEditText * 0.85);
        double fiftyPercentOfKTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfK));
        double minus19ForMop = (fiftyPercentOfKTwoDigits - 0.4);
        double minus19ForMopTwoDigits = Double.parseDouble(String.format("%.2f", minus19ForMop));
        double mopForFirstDose = ((minus19ForMopTwoDigits * 100.0) / 60.0);
        double mopForFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", mopForFirstDose));
        binding.tvMopInKg.setText(String.valueOf(mopForFirstDoseTwoDigits + " किलो"));
        binding.tvMOP4.setText(String.valueOf(mopForFirstDoseTwoDigits + " किलो"));
        //Bags for Mop
        double bagsForMop = (mopForFirstDoseTwoDigits / 50.0);
        double bagsForMopTwoDigits = Double.parseDouble(String.format("%.2f", bagsForMop));
        binding.MopInBag.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        binding.MOPBag4.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        //Total Mop
        double totalMop = (mopForFirstDoseTwoDigits * 2.0);
        double totalMopTwoDigits = Double.parseDouble(String.format("%.2f", totalMop));
        binding.tvMop.setText(String.valueOf(totalMopTwoDigits + " किलो"));

        // N for 2nd 3rd and 4th dose
        // for 2nd dose 40% of 5
        //4*40%=1.6
        double inputInto80 = (inputFromEditText * 1.6);
        double inputInto80TwoDigits = Double.parseDouble(String.format("%.2f", inputInto80));
        double ureaFor2ndDose = ((inputInto80TwoDigits * 100.0) / 46.0);
        double ureaFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor2ndDose));
        binding.ureaInKgSecondDose.setText(String.valueOf(ureaFor2ndDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor2ndDose = (ureaFor2ndDoseTwoDigits / 45.0);
        double bagsFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor2ndDose));
        binding.UreaBagSecondDose.setText(String.valueOf(bagsFor2ndDoseTwoDigits + " गोणी"));

        // for 3rd dose 10% of 80
        //4*10%=0.4
        double inputInto20 = (inputFromEditText * 0.4);
        double inputInto20TwoDigits = Double.parseDouble(String.format("%.2f", inputInto20));
        double ureaFor3rdDose = ((inputInto20TwoDigits * 100.0) / 46.0);
        double ureaFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor3rdDose));
        binding.tvUrea3.setText(String.valueOf(ureaFor3rdDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor3rdDose = (ureaFor3rdDoseTwoDigits / 45.0);
        double bagsFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor3rdDose));
        binding.UreaBag3.setText(String.valueOf(bagsFor3rdDoseTwoDigits + " गोणी"));

        // 4th Dose
        //4*40%=1.6
        double inputInto80LastDose = (inputFromEditText * 1.6);
        double inputInto80LastDoseTwoDigits = Double.parseDouble(String.format("%.2f", inputInto80LastDose));
        double minusNineteen = (inputInto80LastDoseTwoDigits - 0.4);
        double minusNineteenTwoDigits = Double.parseDouble(String.format("%.2f", minusNineteen));
        double ureaForLastDose = ((minusNineteenTwoDigits * 100) / 46.0);
        double ureaForLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaForLastDose));
        binding.tvUrea4.setText(String.valueOf(ureaForLastDoseTwoDigits + " किलो"));
        //Bags
        double bagsForLastDose = (ureaForLastDoseTwoDigits / 45.0);
        double bagsForLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsForLastDose));
        binding.UreaBag4.setText(String.valueOf(bagsForLastDoseTwoDigits + " गोणी"));

        //Total urea
        double totalUrea = (ureaFor2ndDoseTwoDigits + ureaFor3rdDoseTwoDigits + ureaForLastDoseTwoDigits);
        double totalUreaTwoDigits = Double.parseDouble(String.format("%.2f", totalUrea));
        binding.tvUrea.setText(String.valueOf(totalUreaTwoDigits + " किलो"));
    }
    private void valueForCalculationOfHector(String input) {
        float inputFromEditText = Float.parseFloat(input);
        //NPK=400:170:170
        //Calculations for 19:19:19
        //First Dose
        double hundredKg = (210.52 * inputFromEditText);
        double hundredKgTwoDigits = Double.parseDouble(String.format("%.2f", hundredKg));
        binding.tv19InKg.setText(String.valueOf(hundredKgTwoDigits + " किलो"));
        binding.tv19InKgFourthWeek.setText(String.valueOf(hundredKgTwoDigits + " किलो"));
        //Bags Calculation
        double bagForFirstDose = (hundredKgTwoDigits / 45.0);
        double bagForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForFirstDose));
        binding.tv19InBags.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        binding.tv19InBagsFourthWeek.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        //Total
        double total19 = (hundredKgTwoDigits * 2);
        double total19TwoDigits = Double.parseDouble(String.format("%.2f", total19));
        binding.tvTotal19.setText(String.valueOf(total19TwoDigits + " किलो"));

        // Calculation for ssp
        // fifty percent of 170=85
        double fiftyPercentOfP = ((inputFromEditText * 85.0));
        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double minus19 = (fiftyPercentOfPTwoDigits - 40.0);
        double minus19TwoDigits = Double.parseDouble(String.format("%.2f", minus19));
        //        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double sspForFirstDose = ((minus19TwoDigits * 100.0) / 16.0);
        double sspForFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", sspForFirstDose));
        binding.tvSSPInKg.setText(String.valueOf(sspForFirstDoseTwoDigits + " किलो"));
        binding.tvSSF4.setText(String.valueOf(sspForFirstDoseTwoDigits + " किलो"));
        //Bags for ssp
        double bagsForSsp = (sspForFirstDoseTwoDigits / 50.0);
        double bagsForSspTwoDigits = Double.parseDouble(String.format("%.2f", bagsForSsp));
        binding.SSFBag4.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        binding.tvSSPInBag.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        //Total Ssp
        double totalSsp = (sspForFirstDoseTwoDigits * 2);
        double totalSspTwoDigits = Double.parseDouble(String.format("%.2f", totalSsp));
        binding.tvSsf.setText(String.valueOf(totalSspTwoDigits + " किलो"));

        //Calculation for Mop
        // fifty percent of 170 =85
        double fiftyPercentOfK = (inputFromEditText * 85.0);
        double fiftyPercentOfKTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfK));
        double minus19ForMop = (fiftyPercentOfKTwoDigits - 40.0);
        double minus19ForMopTwoDigits = Double.parseDouble(String.format("%.2f", minus19ForMop));
        double mopForFirstDose = ((minus19ForMopTwoDigits * 100.0) / 60.0);
        double mopForFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", mopForFirstDose));
        binding.tvMopInKg.setText(String.valueOf(mopForFirstDoseTwoDigits + " किलो"));
        binding.tvMOP4.setText(String.valueOf(mopForFirstDoseTwoDigits + " किलो"));
        //Bags for Mop
        double bagsForMop = (mopForFirstDoseTwoDigits / 50.0);
        double bagsForMopTwoDigits = Double.parseDouble(String.format("%.2f", bagsForMop));
        binding.MopInBag.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        binding.MOPBag4.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        //Total Mop
        double totalMop = (mopForFirstDoseTwoDigits * 2.0);
        double totalMopTwoDigits = Double.parseDouble(String.format("%.2f", totalMop));
        binding.tvMop.setText(String.valueOf(totalMopTwoDigits + " किलो"));

        // N for 2nd 3rd and 4th dose
        // for 2nd dose 40% of 80
        //400*40%=160
        double inputInto80 = (inputFromEditText * 160.0);
        double inputInto80TwoDigits = Double.parseDouble(String.format("%.2f", inputInto80));
        double ureaFor2ndDose = ((inputInto80TwoDigits * 100.0) / 46.0);
        double ureaFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor2ndDose));
        binding.ureaInKgSecondDose.setText(String.valueOf(ureaFor2ndDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor2ndDose = (ureaFor2ndDoseTwoDigits / 45.0);
        double bagsFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor2ndDose));
        binding.UreaBagSecondDose.setText(String.valueOf(bagsFor2ndDoseTwoDigits + " गोणी"));

        // for 3rd dose 10% of 80
        //400*10%=40
        double inputInto20 = (inputFromEditText * 40.0);
        double inputInto20TwoDigits = Double.parseDouble(String.format("%.2f", inputInto20));
        double ureaFor3rdDose = ((inputInto20TwoDigits * 100.0) / 46.0);
        double ureaFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor3rdDose));
        binding.tvUrea3.setText(String.valueOf(ureaFor3rdDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor3rdDose = (ureaFor3rdDoseTwoDigits / 45.0);
        double bagsFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor3rdDose));
        binding.UreaBag3.setText(String.valueOf(bagsFor3rdDoseTwoDigits + " गोणी"));

        // 4th Dose
        //400*40%=160
        double inputInto80LastDose = (inputFromEditText * 160.0);
        double inputInto80LastDoseTwoDigits = Double.parseDouble(String.format("%.2f", inputInto80LastDose));
        double minusNineteen = (inputInto80LastDoseTwoDigits - 40.0);
        double minusNineteenTwoDigits = Double.parseDouble(String.format("%.2f", minusNineteen));
        double ureaForLastDose = ((minusNineteenTwoDigits * 100) / 46.0);
        double ureaForLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaForLastDose));
        binding.tvUrea4.setText(String.valueOf(ureaForLastDoseTwoDigits + " किलो"));
        //Bags
        double bagsForLastDose = (ureaForLastDoseTwoDigits / 45.0);
        double bagsForLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsForLastDose));
        binding.UreaBag4.setText(String.valueOf(bagsForLastDoseTwoDigits + " गोणी"));

        //Total urea
        double totalUrea = (ureaFor2ndDoseTwoDigits + ureaFor3rdDoseTwoDigits + ureaForLastDoseTwoDigits);
        double totalUreaTwoDigits = Double.parseDouble(String.format("%.2f", totalUrea));
        binding.tvUrea.setText(String.valueOf(totalUreaTwoDigits + " किलो"));

    }
    private void valueForCalculation(String input) {
        float inputFromEditText = Float.parseFloat(input);
        //NPK=160:68:68
        //Calculations for 19:19:19
        //First Dose
        double hundredKg = (84.21 * inputFromEditText);
        double hundredKgTwoDigits = Double.parseDouble(String.format("%.2f", hundredKg));
        binding.tv19InKg.setText(String.valueOf(hundredKgTwoDigits + " किलो"));
        binding.tv19InKgFourthWeek.setText(String.valueOf(hundredKgTwoDigits + " किलो"));
        //Bags Calculation
        double bagForFirstDose = (hundredKgTwoDigits / 45.0);
        double bagForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForFirstDose));
        binding.tv19InBags.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        binding.tv19InBagsFourthWeek.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        //Total
        double total19 = (hundredKgTwoDigits * 2);
        double total19TwoDigits = Double.parseDouble(String.format("%.2f", total19));
        binding.tvTotal19.setText(String.valueOf(total19TwoDigits + " किलो"));

        // Calculation for ssp
        // fifty percent of 68 =34
        double fiftyPercentOfP = (inputFromEditText * 34.0);
        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double minus19 = (fiftyPercentOfPTwoDigits - 16.0);
        double minus19TwoDigits = Double.parseDouble(String.format("%.2f", minus19));
        //        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double sspForFirstDose = ((minus19TwoDigits * 100.0) / 16.0);
        double sspForFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", sspForFirstDose));
        binding.tvSSPInKg.setText(String.valueOf(sspForFirstDoseTwoDigits + " किलो"));
        binding.tvSSF4.setText(String.valueOf(sspForFirstDoseTwoDigits + " किलो"));
        //Bags for ssp
        double bagsForSsp = (sspForFirstDoseTwoDigits / 50.0);
        double bagsForSspTwoDigits = Double.parseDouble(String.format("%.2f", bagsForSsp));
        binding.SSFBag4.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        binding.tvSSPInBag.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        //Total Ssp
        double totalSsp = (sspForFirstDoseTwoDigits * 2);
        double totalSspTwoDigits = Double.parseDouble(String.format("%.2f", totalSsp));
        binding.tvSsf.setText(String.valueOf(totalSspTwoDigits + " किलो"));

        //Calculation for Mop
        // fifty percent of 68 =34
        double fiftyPercentOfK = (inputFromEditText * 34.0);
        double fiftyPercentOfKTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfK));
        double minus19ForMop = (fiftyPercentOfKTwoDigits - 16.0);
        double minus19ForMopTwoDigits = Double.parseDouble(String.format("%.2f", minus19ForMop));
        double mopForFirstDose = ((minus19ForMopTwoDigits * 100.0) / 60.0);
        double mopForFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", mopForFirstDose));
        binding.tvMopInKg.setText(String.valueOf(mopForFirstDoseTwoDigits + " किलो"));
        binding.tvMOP4.setText(String.valueOf(mopForFirstDoseTwoDigits + " किलो"));
        //Bags for Mop
        double bagsForMop = (mopForFirstDoseTwoDigits / 50.0);
        double bagsForMopTwoDigits = Double.parseDouble(String.format("%.2f", bagsForMop));
        binding.MopInBag.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        binding.MOPBag4.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        //Total Mop
        double totalMop = (mopForFirstDoseTwoDigits * 2.0);
        double totalMopTwoDigits = Double.parseDouble(String.format("%.2f", totalMop));
        binding.tvMop.setText(String.valueOf(totalMopTwoDigits + " किलो"));

        // N for 2nd 3rd and 4th dose
        // for 2nd dose 40% of 80
        //160*40%=64
        double inputInto80 = (inputFromEditText * 64.0);
        double inputInto80TwoDigits = Double.parseDouble(String.format("%.2f", inputInto80));
        double ureaFor2ndDose = ((inputInto80TwoDigits * 100.0) / 46.0);
        double ureaFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor2ndDose));
        binding.ureaInKgSecondDose.setText(String.valueOf(ureaFor2ndDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor2ndDose = (ureaFor2ndDoseTwoDigits / 45.0);
        double bagsFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor2ndDose));
        binding.UreaBagSecondDose.setText(String.valueOf(bagsFor2ndDoseTwoDigits + " गोणी"));

        // for 3rd dose 10% of 80
        //160*10%=16
        double inputInto20 = (inputFromEditText * 16.0);
        double inputInto20TwoDigits = Double.parseDouble(String.format("%.2f", inputInto20));
        double ureaFor3rdDose = ((inputInto20TwoDigits * 100.0) / 46.0);
        double ureaFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor3rdDose));
        binding.tvUrea3.setText(String.valueOf(ureaFor3rdDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor3rdDose = (ureaFor3rdDoseTwoDigits / 45.0);
        double bagsFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor3rdDose));
        binding.UreaBag3.setText(String.valueOf(bagsFor3rdDoseTwoDigits + " गोणी"));

        // 4th Dose
        //160*40%=64
        double inputInto80LastDose = (inputFromEditText * 64.0);
        double inputInto80LastDoseTwoDigits = Double.parseDouble(String.format("%.2f", inputInto80LastDose));
        double minusNineteen = (inputInto80LastDoseTwoDigits - 16.0);
        double minusNineteenTwoDigits = Double.parseDouble(String.format("%.2f", minusNineteen));
        double ureaForLastDose = ((minusNineteenTwoDigits * 100) / 46.0);
        double ureaForLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaForLastDose));
        binding.tvUrea4.setText(String.valueOf(ureaForLastDoseTwoDigits + " किलो"));
        //Bags
        double bagsForLastDose = (ureaForLastDoseTwoDigits / 45.0);
        double bagsForLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsForLastDose));
        binding.UreaBag4.setText(String.valueOf(bagsForLastDoseTwoDigits + " गोणी"));

        //Total urea
        double totalUrea = (ureaFor2ndDoseTwoDigits + ureaFor3rdDoseTwoDigits + ureaForLastDoseTwoDigits);
        double totalUreaTwoDigits = Double.parseDouble(String.format("%.2f", totalUrea));
        binding.tvUrea.setText(String.valueOf(totalUreaTwoDigits + " किलो"));
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