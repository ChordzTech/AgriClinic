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
import com.example.agroclinic.databinding.ActivitySixthTableBinding;

import java.text.DecimalFormat;

public class SixthTableActivity extends AppCompatActivity {
    ActivitySixthTableBinding binding;
    private DecimalFormat decimalFormat;
    private String valueofEditText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_sixth_table);
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
                    binding.tvN.setText("नत्र     - (N) :  3 किलो");
                    binding.tvP.setText("स्फुरद - (P): 1.4 किलो");
                    binding.tvK.setText("पालाश - (K): 1.4 किलो");
                    binding.tvMeasurement.setText("गुंठा");
                } else if (checkedId == R.id.rbHector) {
                    binding.tvN.setText("नत्र     - (N) : 300 किलो");
                    binding.tvP.setText("स्फुरद - (P): 140 किलो");
                    binding.tvK.setText("पालाश - (K): 140 किलो");
                    binding.tvMeasurement.setText("हेक्टर");
                } else if (checkedId == R.id.rbEkar) {
                    binding.tvN.setText("नत्र     - (N): 120 किलो");
                    binding.tvP.setText("स्फुरद - (P): 56 किलो");
                    binding.tvK.setText("पालाश - (K): 56 किलो");
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
                        Toast.makeText(SixthTableActivity.this, "कृपया एकक निवडा", Toast.LENGTH_SHORT).show();
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
        //for 1 gunta
        double inputFromEditText = Float.parseFloat(input);
        //NPK=200:80:80
        // Calculations for P & k
        // 10:26:26
        //Value of P
        double valueOfP = ((0.7 * 100.0) / 26.0);
        double roundValueOfP = Double.parseDouble(String.format("%.2f", valueOfP));
        //Value of K
        double valueOfK = ((0.7* 100.0) / 26.0);
        double roundValueOfK = Double.parseDouble(String.format("%.2f", valueOfK));

        double total = roundValueOfP + roundValueOfK;
        double valueFromTiet = total * inputFromEditText;
        double totalOfPK = Double.parseDouble(String.format("%.2f", valueFromTiet));

        binding.tvSsf.setText(String.valueOf(totalOfPK + " किलो"));
        //Set 10:26:26 for first and last dose
        double halfOfPAndK = (totalOfPK / 2.0);

        binding.tvSSPInKg.setText(String.valueOf(halfOfPAndK + " किलो"));
        binding.tvSSF4.setText(String.valueOf(halfOfPAndK + " किलो"));
        // Calculation for bags
        double bagForFirstDose = (halfOfPAndK / 45.0);
        double bagForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForFirstDose));
        double bagForLastDose = (halfOfPAndK / 45.0);
        double bagForLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForLastDose));

        binding.tvSSPInBag.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        binding.SSFBag4.setText(String.valueOf(bagForLastDoseTwoDigit + " गोणी"));


        //Caclutions for N
        //for 1st Dose
        double tenPercentOfPK = (halfOfPAndK / 10.0);
        double tenPercentOfPKTwoDigit = Double.parseDouble(String.format("%.2f", tenPercentOfPK));
        //Minus that value from 20 because 200/10 %=20 for first dose


        double onValueEnter = (inputFromEditText / 3.3);
        double round=Math.round(onValueEnter);
        double tonValueEnterTwoDigit = Double.parseDouble(String.format("%.2f", round));


        double minusTwenty = (tonValueEnterTwoDigit - tenPercentOfPKTwoDigit);
        double minusTwentyTwoDigit = Double.parseDouble(String.format("%.2f", minusTwenty));

        double ureaForFirstDose = ((minusTwentyTwoDigit * 100) / 46.0);
        double ureaForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaForFirstDose));
        binding.tvUreaInKg.setText(String.valueOf(ureaForFirstDoseTwoDigit + " किलो"));
        //BagsCalculation
        double bagsOfUrea = (ureaForFirstDoseTwoDigit / 45);
        double bagsOfUreaTwoDigit = Double.parseDouble(String.format("%.2f", bagsOfUrea));
        binding.tvUreaInBags.setText(String.valueOf(bagsOfUreaTwoDigit + " गोणी"));


        //2nd dose 40% N
        double nfortyPercent = ((1.2 * 100.0) / 46.0);
        double outputnfortyPercent = inputFromEditText * nfortyPercent;
        double twodigitoutputnfortyPercent = Double.parseDouble(String.format("%.2f", outputnfortyPercent));
        binding.ureaInKg.setText(String.valueOf(twodigitoutputnfortyPercent + " किलो"));
        double ureaBag = twodigitoutputnfortyPercent / 45.0;
        double ureaBagtwoDigit = Double.parseDouble(String.format("%.2f", ureaBag));
        binding.Urea.setText(String.valueOf(ureaBagtwoDigit + " गोणी"));

        // 3rd dose
        double nTenPercent = ((0.3 * 100.0) / 46.0);
        double outputntenPercent = inputFromEditText * nTenPercent;
        double outputntenPercentTwoDigit = Double.parseDouble(String.format("%.2f", outputntenPercent));
        binding.tvUrea3.setText(String.valueOf(outputntenPercentTwoDigit + " किलो"));
        double ureaBagthirdDose = outputntenPercentTwoDigit / 45.0;
        double ureaBagthirdDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaBagthirdDose));
        binding.UreaBag3.setText(String.valueOf(ureaBagthirdDoseTwoDigit + " गोणी"));

        //4th dose
//        double fortyPercentGlobalVar = globalVarGunta;
        double onValueEnterFourthDose = (inputFromEditText * 3);
        double fortyPercent = (onValueEnterFourthDose * .40);
        double fortyPercentTwoDigit = Double.parseDouble(String.format("%.2f", fortyPercent));
        double minusForty = (fortyPercentTwoDigit - tenPercentOfPKTwoDigit);
        double minusFortyTwoDigit = Double.parseDouble(String.format("%.2f", minusForty));

        double ureaForLastDose = ((minusFortyTwoDigit * 100) / 46.0);
        double ureaForLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaForLastDose));
        binding.tvUrea4.setText(String.valueOf(ureaForLastDoseTwoDigit + " किलो"));
        //BagsCalculation
        double bagsOfUreaLastDose = (ureaForLastDoseTwoDigit / 45);
        double bagsOfUreaLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagsOfUreaLastDose));
        binding.UreaBag4.setText(String.valueOf(bagsOfUreaLastDoseTwoDigit + " गोणी"));
        //Total Urea
        double totalUrea = ureaForFirstDoseTwoDigit + twodigitoutputnfortyPercent + outputntenPercentTwoDigit + ureaForLastDoseTwoDigit;
        double totalUreaTwoDigit = Double.parseDouble(String.format("%.2f", totalUrea));
        binding.tvUrea.setText(String.valueOf(totalUreaTwoDigit + " किलो"));
    }

    private void valueForCalculationOfHector(String input) {
        //for 1 acer
        double inputFromEditText = Float.parseFloat(input);
        //NPK=300:140:140
        // Calculations for P & k
        // 10:26:26
        //Value of P
        double valueOfP = ((70.0 * 100.0) / 26.0);
        double roundValueOfP = Double.parseDouble(String.format("%.2f", valueOfP));
        //Value of K
        double valueOfK = ((70.0 * 100.0) / 26.0);
        double roundValueOfK = Double.parseDouble(String.format("%.2f", valueOfK));

        double total = roundValueOfP + roundValueOfK;
        double valueFromTiet = total * inputFromEditText;
        double totalOfPK = Double.parseDouble(String.format("%.2f", valueFromTiet));

        binding.tvSsf.setText(String.valueOf(totalOfPK + " किलो"));
        //Set 10:26:26 for first and last dose
        double halfOfPAndK = (totalOfPK / 2.0);

        binding.tvSSPInKg.setText(String.valueOf(halfOfPAndK + " किलो"));
        binding.tvSSF4.setText(String.valueOf(halfOfPAndK + " किलो"));
        // Calculation for bags
        double bagForFirstDose = (halfOfPAndK / 45.0);
        double bagForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForFirstDose));
        double bagForLastDose = (halfOfPAndK / 45.0);
        double bagForLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForLastDose));

        binding.tvSSPInBag.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        binding.SSFBag4.setText(String.valueOf(bagForLastDoseTwoDigit + " गोणी"));


        //Caclutions for N
        //for 1st Dose
        double tenPercentOfPK = (halfOfPAndK / 10.0);
        double tenPercentOfPKTwoDigit = Double.parseDouble(String.format("%.2f", tenPercentOfPK));
        //Minus that value from 20 because 200/10 %=20 for first dose


//        int updatedGlobalVariable = globalVarHector;

        double tenPercent = (inputFromEditText * 30.0);
        double tenPercentTwoDigit = Double.parseDouble(String.format("%.2f", tenPercent));

        double minusTwenty = (tenPercentTwoDigit - tenPercentOfPKTwoDigit);
        double minusTwentyTwoDigit = Double.parseDouble(String.format("%.2f", minusTwenty));

        double ureaForFirstDose = ((minusTwentyTwoDigit * 100) / 46.0);
        double ureaForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaForFirstDose));
        binding.tvUreaInKg.setText(String.valueOf(ureaForFirstDoseTwoDigit + " किलो"));
        //BagsCalculation
        double bagsOfUrea = (ureaForFirstDoseTwoDigit / 45);
        double bagsOfUreaTwoDigit = Double.parseDouble(String.format("%.2f", bagsOfUrea));
        binding.tvUreaInBags.setText(String.valueOf(bagsOfUreaTwoDigit + " गोणी"));


        //2nd dose 40% N
        double nfortyPercent = ((120.0 * 100.0) / 46.0);
        double outputnfortyPercent = inputFromEditText * nfortyPercent;
        double twodigitoutputnfortyPercent = Double.parseDouble(String.format("%.2f", outputnfortyPercent));
        binding.ureaInKg.setText(String.valueOf(twodigitoutputnfortyPercent + " किलो"));
        double ureaBag = twodigitoutputnfortyPercent / 45.0;
        double ureaBagtwoDigit = Double.parseDouble(String.format("%.2f", ureaBag));
        binding.Urea.setText(String.valueOf(ureaBagtwoDigit + " गोणी"));

        // 3rd dose
        double nTenPercent = ((30.0 * 100.0) / 46.0);
        double outputntenPercent = inputFromEditText * nTenPercent;
        double outputntenPercentTwoDigit = Double.parseDouble(String.format("%.2f", outputntenPercent));
        binding.tvUrea3.setText(String.valueOf(outputntenPercentTwoDigit + " किलो"));
        double ureaBagthirdDose = outputntenPercentTwoDigit / 45.0;
        double ureaBagthirdDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaBagthirdDose));
        binding.UreaBag3.setText(String.valueOf(ureaBagthirdDoseTwoDigit + " गोणी"));

        //4th dose
//        int fortyPercentGlobalVar = globalVarHector;

        double fortyPercent = (inputFromEditText * 120.0);
        double fortyPercentTwoDigit = Double.parseDouble(String.format("%.2f", fortyPercent));
        double minusForty = (fortyPercentTwoDigit - tenPercentOfPKTwoDigit);
        double minusFortyTwoDigit = Double.parseDouble(String.format("%.2f", minusForty));

        double ureaForLastDose = ((minusFortyTwoDigit * 100) / 46.0);
        double ureaForLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaForLastDose));
        binding.tvUrea4.setText(String.valueOf(ureaForLastDoseTwoDigit + " किलो"));
        //BagsCalculation
        double bagsOfUreaLastDose = (ureaForLastDoseTwoDigit / 45);
        double bagsOfUreaLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagsOfUreaLastDose));
        binding.UreaBag4.setText(String.valueOf(bagsOfUreaLastDoseTwoDigit + " गोणी"));

        //Total Urea
        double totalUrea = ureaForFirstDoseTwoDigit + twodigitoutputnfortyPercent + outputntenPercentTwoDigit + ureaForLastDoseTwoDigit;
        double totalUreaTwoDigit = Double.parseDouble(String.format("%.2f", totalUrea));
        binding.tvUrea.setText(String.valueOf(totalUreaTwoDigit + " किलो"));
    }

    private void valueForCalculation(String input) {
        //for 1 acer
        double inputFromEditText = Float.parseFloat(input);
        //NPK=120:56:56
        // Calculations for P & k
        // 10:26:26
        //Value of P
        double valueOfP = ((28.0 * 100.0) / 26.0);
        double roundValueOfP = Double.parseDouble(String.format("%.2f", valueOfP));
        //Value of K
        double valueOfK = ((28.0 * 100.0) / 26.0);
        double roundValueOfK = Double.parseDouble(String.format("%.2f", valueOfK));

        double total = roundValueOfP + roundValueOfK;
        double valueFromTiet = total * inputFromEditText;
        double totalOfPK = Double.parseDouble(String.format("%.2f", valueFromTiet));

        binding.tvSsf.setText(String.valueOf(totalOfPK + " किलो"));
        //Set 10:26:26 for first and last dose
        double halfOfPAndK = (totalOfPK / 2.0);

        binding.tvSSPInKg.setText(String.valueOf(halfOfPAndK + " किलो"));
        binding.tvSSF4.setText(String.valueOf(halfOfPAndK + " किलो"));
        // Calculation for bags
        double bagForFirstDose = (halfOfPAndK / 45.0);
        double bagForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForFirstDose));
        double bagForLastDose = (halfOfPAndK / 45.0);
        double bagForLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForLastDose));

        binding.tvSSPInBag.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        binding.SSFBag4.setText(String.valueOf(bagForLastDoseTwoDigit + " गोणी"));


        //Caclutions for N
        //for 1st Dose
        double tenPercentOfPK = (halfOfPAndK / 10.0);
        double tenPercentOfPKTwoDigit = Double.parseDouble(String.format("%.2f", tenPercentOfPK));
        //Minus that value from 20 because 200/10 %=20 for first dose


//        int updatedGlobalVariable = globalVariable;

        double tenPercent = (inputFromEditText * 12.0);
        double tenPercentTwoDigit = Double.parseDouble(String.format("%.2f", tenPercent));

        double minusTwenty = (tenPercentTwoDigit - tenPercentOfPKTwoDigit);
        double minusTwentyTwoDigit = Double.parseDouble(String.format("%.2f", minusTwenty));

        double ureaForFirstDose = ((minusTwentyTwoDigit * 100) / 46.0);
        double ureaForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaForFirstDose));
        binding.tvUreaInKg.setText(String.valueOf(ureaForFirstDoseTwoDigit + " किलो"));
        //BagsCalculation
        double bagsOfUrea = (ureaForFirstDoseTwoDigit / 45);
        double bagsOfUreaTwoDigit = Double.parseDouble(String.format("%.2f", bagsOfUrea));
        binding.tvUreaInBags.setText(String.valueOf(bagsOfUreaTwoDigit + " गोणी"));


        //2nd dose 40% N
        double nfortyPercent = ((48.0 * 100.0) / 46.0);
        double outputnfortyPercent = inputFromEditText * nfortyPercent;
        double twodigitoutputnfortyPercent = Double.parseDouble(String.format("%.2f", outputnfortyPercent));
        binding.ureaInKg.setText(String.valueOf(twodigitoutputnfortyPercent + " किलो"));
        double ureaBag = twodigitoutputnfortyPercent / 45.0;
        double ureaBagtwoDigit = Double.parseDouble(String.format("%.2f", ureaBag));
        binding.Urea.setText(String.valueOf(ureaBagtwoDigit + " गोणी"));

        // 3rd dose
        double nTenPercent = ((12.0 * 100.0) / 46.0);
        double outputntenPercent = inputFromEditText * nTenPercent;
        double outputntenPercentTwoDigit = Double.parseDouble(String.format("%.2f", outputntenPercent));
        binding.tvUrea3.setText(String.valueOf(outputntenPercentTwoDigit + " किलो"));
        double ureaBagthirdDose = outputntenPercentTwoDigit / 45.0;
        double ureaBagthirdDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaBagthirdDose));
        binding.UreaBag3.setText(String.valueOf(ureaBagthirdDoseTwoDigit + " गोणी"));

        //4th dose
//        int fortyPercentGlobalVar = globalVariable;

        double fortyPercent = (inputFromEditText * 48);
        double fortyPercentTwoDigit = Double.parseDouble(String.format("%.2f", fortyPercent));
        double minusForty = (fortyPercentTwoDigit - tenPercentOfPKTwoDigit);
        double minusFortyTwoDigit = Double.parseDouble(String.format("%.2f", minusForty));

        double ureaForLastDose = ((minusFortyTwoDigit * 100) / 46.0);
        double ureaForLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaForLastDose));
        binding.tvUrea4.setText(String.valueOf(ureaForLastDoseTwoDigit + " किलो"));
        //BagsCalculation
        double bagsOfUreaLastDose = (ureaForLastDoseTwoDigit / 45);
        double bagsOfUreaLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagsOfUreaLastDose));
        binding.UreaBag4.setText(String.valueOf(bagsOfUreaLastDoseTwoDigit + " गोणी"));
        //Total Urea
        double totalUrea = ureaForFirstDoseTwoDigit + twodigitoutputnfortyPercent + outputntenPercentTwoDigit + ureaForLastDoseTwoDigit;
        double totalUreaTwoDigit = Double.parseDouble(String.format("%.2f", totalUrea));
        binding.tvUrea.setText(String.valueOf(totalUreaTwoDigit + " किलो"));
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
            // If the result is negative, set it to 0
            if (currentValue < 0) {
                currentValue = 0;
            }
            // Update EditText with the new value
            binding.etLand.setText(decimalFormat.format(currentValue)); // Potential issue here
        }
    }
}