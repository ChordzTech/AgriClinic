package com.example.agroclinic.userInputTables;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivityUfifthTableBinding;

import java.text.DecimalFormat;

public class UFifthTableActivity extends AppCompatActivity {
    ActivityUfifthTableBinding binding;
    private DecimalFormat decimalFormat;
    private String valueOfLand = "0";
    private String valueOfN = "0";
    private String valueOfP = "0";
    private String valueOfK = "0";
    private String increasedValueN = "0";
    private String increasedValueP = "0";
    private String increasedValueK = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ufifth_table);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ufifth_table);
        initView();
    }

    private void initView() {
        decimalFormat = new DecimalFormat("#0.0");
        binding.etLand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    valueOfLand = s.toString();
                    if (binding.rbEkar.isChecked()) {
                        Toast.makeText(UFifthTableActivity.this, "एकर", Toast.LENGTH_SHORT).show();
                        valueForConditionOfAcer();
                    } else if (binding.rbHector.isChecked()) {
                        valueForConditionCheck();
                        Toast.makeText(UFifthTableActivity.this, "हेक्टर", Toast.LENGTH_SHORT).show();
                    } else if (binding.rbGunta.isChecked()) {
                        Toast.makeText(UFifthTableActivity.this, "गुंठा", Toast.LENGTH_SHORT).show();
                        valueForConditionOfGunta();
                    } else {
                        Toast.makeText(UFifthTableActivity.this, "कृपया एकक निवडा", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    binding.etLand.setText("0.0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                valueForCalculation(valueOfLand);
                valueForCalculationAcer(valueOfLand);
                valueForCalculationGunta(valueOfLand);
            }
        });

        binding.tietValueOfN.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    valueOfN = s.toString();

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.tietValueOfP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    valueOfP = s.toString();

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.tietValueOfK.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    valueOfK = s.toString();

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        binding.btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Decrease value by 0.5
                decreaseValue();
                if (binding.rbHector.isChecked()) {
                    valueForCalculation(valueOfLand);
                } else if (binding.rbEkar.isChecked()) {
                    valueForCalculationAcer(valueOfLand);
                } else {
                    valueForCalculationGunta(valueOfLand);
                }

            }
        });

        binding.btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increase value by 0.5
                increaseValue();
                if (binding.rbHector.isChecked()) {
                    valueForCalculation(valueOfLand);
                } else if (binding.rbEkar.isChecked()) {
                    valueForCalculationAcer(valueOfLand);
                } else {
                    valueForCalculationGunta(valueOfLand);
                }

            }
        });

    }

    private void valueForConditionOfGunta() {
        float inputFromEditTextN = Float.parseFloat(valueOfN);
        float inputFromEditTextP = Float.parseFloat(valueOfP);
        float inputFromEditTextK = Float.parseFloat(valueOfK);
        float inputFromEditTextLand = Float.parseFloat(valueOfLand);

        //4:1.7:1.7
        if (inputFromEditTextN < 1.4) {
            increasedValueN = String.valueOf(6.0);
        } else if (inputFromEditTextN >= 1.4 && inputFromEditTextN <= 2.8) {
            increasedValueN = String.valueOf(5.0);
        } else if (inputFromEditTextN >= 2.9 && inputFromEditTextN <= 3.5) {
            increasedValueN = String.valueOf(4.0);
        } else if (inputFromEditTextN >= 3.6 && inputFromEditTextN <= 7.0) {
            increasedValueN = String.valueOf(3.0);
        } else if (inputFromEditTextN > 7.1) {
            increasedValueN = String.valueOf(2.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }
        if (inputFromEditTextP < 0.075) {
            increasedValueP = String.valueOf(2.55);
        } else if (inputFromEditTextP >= 0.076 && inputFromEditTextP <= 0.14) {
            increasedValueP = String.valueOf(2.12);
        } else if ((inputFromEditTextP >= 0.15 && inputFromEditTextP <= 0.28)) {
            increasedValueP = String.valueOf(1.7);
        } else if ((inputFromEditTextP >= 0.29 && inputFromEditTextP <= 0.35)) {
            increasedValueP = String.valueOf(1.27);
        } else if (inputFromEditTextP > 0.36) {
            increasedValueP = String.valueOf(0.85);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

        if (inputFromEditTextK < 1.0) {
            increasedValueK = String.valueOf(2.55);
        } else if (inputFromEditTextK >= 1.01 && inputFromEditTextK <= 1.5) {
            increasedValueK = String.valueOf(2.12);
        } else if (inputFromEditTextK >= 1.6 && inputFromEditTextK <= 2.5) {
            increasedValueK = String.valueOf(1.7);
        } else if (inputFromEditTextK >= 2.6 && inputFromEditTextK <= 3.0) {
            increasedValueK = String.valueOf(1.27);
        } else if (inputFromEditTextK >3.1) {
            increasedValueK = String.valueOf(0.85);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

    }

    private void valueForConditionOfAcer() {
        //Acer 160:68:68
        float inputFromEditTextN = Float.parseFloat(valueOfN);
        float inputFromEditTextP = Float.parseFloat(valueOfP);
        float inputFromEditTextK = Float.parseFloat(valueOfK);
        float inputFromEditTextLand = Float.parseFloat(valueOfLand);

        if (inputFromEditTextN < 56.0) {
            increasedValueN = String.valueOf(240.0);
        } else if (inputFromEditTextN >= 56.0 && inputFromEditTextN <= 112.0) {
            increasedValueN = String.valueOf(200.0);
        } else if (inputFromEditTextN >= 113.0 && inputFromEditTextN <= 224.0) {
            increasedValueN = String.valueOf(160.0);
        } else if (inputFromEditTextN >= 225.0 && inputFromEditTextN <= 280.0) {
            increasedValueN = String.valueOf(120.0);
        } else if (inputFromEditTextN > 280.0) {
            increasedValueN = String.valueOf(80.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

        if (inputFromEditTextP < 3.0) {
            increasedValueP = String.valueOf(102.0);
        } else if (inputFromEditTextP >= 3.0 && inputFromEditTextP <= 5.6) {
            increasedValueP = String.valueOf(85.0);
        } else if ((inputFromEditTextP >= 6.0 && inputFromEditTextP <= 11.2)) {
            increasedValueP = String.valueOf(68.0);
        } else if ((inputFromEditTextP >= 12.0 && inputFromEditTextP <= 15.0)) {
            increasedValueP = String.valueOf(51.0);
        } else if (inputFromEditTextP > 15.0) {
            increasedValueP = String.valueOf(34.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

        if (inputFromEditTextK < 40.0) {
            increasedValueK = String.valueOf(102.0);
        } else if (inputFromEditTextK >= 40.4 && inputFromEditTextK <= 60.0) {
            increasedValueK = String.valueOf(85.0);
        } else if (inputFromEditTextK >= 61.4 && inputFromEditTextK <= 100.0) {
            increasedValueK = String.valueOf(68.0);
        } else if (inputFromEditTextK >= 101.0 && inputFromEditTextK <= 120.0) {
            increasedValueK = String.valueOf(51.0);
        } else if (inputFromEditTextK > 121.0) {
            increasedValueK = String.valueOf(34.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }
    }

    private void valueForConditionCheck() {
        //Hector 400:170:170
        float inputFromEditTextN = Float.parseFloat(valueOfN);
        float inputFromEditTextP = Float.parseFloat(valueOfP);
        float inputFromEditTextK = Float.parseFloat(valueOfK);
        float inputFromEditTextLand = Float.parseFloat(valueOfLand);

        if (inputFromEditTextN < 140.0) {
            increasedValueN = String.valueOf(600.0);
        } else if (inputFromEditTextN >= 141.0 && inputFromEditTextN <= 280.0) {
            increasedValueN = String.valueOf(500.0);
        } else if (inputFromEditTextN >= 281.0 && inputFromEditTextN <= 560.0) {
            increasedValueN = String.valueOf(400.0);
        } else if (inputFromEditTextN >= 561.0 && inputFromEditTextN <= 700.0) {
            increasedValueN = String.valueOf(300.0);
        } else if (inputFromEditTextN > 700.0) {
            increasedValueN = String.valueOf(200.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

        if (inputFromEditTextP < 7.0) {
            increasedValueP = String.valueOf(255.0);
        } else if (inputFromEditTextP >= 8.0 && inputFromEditTextP <= 14.0) {
            increasedValueP = String.valueOf(213.0);
        } else if ((inputFromEditTextP >= 15.0 && inputFromEditTextP <= 28.0)) {
            increasedValueP = String.valueOf(170.0);
        } else if ((inputFromEditTextP >= 29.0 && inputFromEditTextP <= 35.0)) {
            increasedValueP = String.valueOf(128.0);
        } else if (inputFromEditTextP > 35.0) {
            increasedValueP = String.valueOf(85.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

        if (inputFromEditTextK < 100.0) {
            increasedValueK = String.valueOf(255.0);
        } else if (inputFromEditTextK >= 101.0 && inputFromEditTextK <= 150.0) {
            increasedValueK = String.valueOf(213.0);
        } else if (inputFromEditTextK >= 151.0 && inputFromEditTextK <= 250.0) {
            increasedValueK = String.valueOf(170.0);
        } else if (inputFromEditTextK >= 251.0 && inputFromEditTextK <= 300.0) {
            increasedValueK = String.valueOf(128.0);
        } else if (inputFromEditTextK > 300.0) {
            increasedValueK = String.valueOf(85.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

    }

    private void valueForCalculationGunta(String input) {
        //for 1 Acer
        double inputFromEditText = Float.parseFloat(input);
        //NPK=5:2:2
        // Calculations for P & k
        // 10:26:26
        //Value of P
        double valueofP = Double.parseDouble(increasedValueP);
        double valueofPTwoDigits = Double.parseDouble(String.format("%.2f", valueofP));
        //50% of P
        double fiftyPercentOfP = (valueofPTwoDigits / 2.0);
        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double valueOfP = ((fiftyPercentOfPTwoDigits * 100.0) / 26.0);
        double roundValueOfP = Double.parseDouble(String.format("%.2f", valueOfP));

        //Value of K
        double valueofK = Double.parseDouble(increasedValueK);
        double valueofKTwoDigits = Double.parseDouble(String.format("%.2f", valueofK));
        //50% of P
        double fiftyPercentOfK = (valueofKTwoDigits / 2.0);
        double fiftyPercentOfKTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfK));
        double valueOfK = ((fiftyPercentOfKTwoDigits * 100.0) / 26.0);
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
        double bagForFirstDose = (halfOfPAndK / 50.0);
        double bagForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForFirstDose));
        double bagForLastDose = (halfOfPAndK / 50.0);
        double bagForLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForLastDose));

        binding.tvSSPInBag.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        binding.SSFBag4.setText(String.valueOf(bagForLastDoseTwoDigit + " गोणी"));

        //Caclutions for N
        //for 1st Dose
        double tenPercentOfPK = (halfOfPAndK / 10.0);
        double tenPercentOfPKTwoDigit = Double.parseDouble(String.format("%.2f", tenPercentOfPK));
        //Minus that value from 20 because 200/10 %=20 for first dose
        //Value of N
        double valueofN = Double.parseDouble(increasedValueN);
        double valueofNTwoDigits = Double.parseDouble(String.format("%.2f", valueofN));
        double dividebyTenPercent = (valueofNTwoDigits * 10.0 / 100.0);
        double dividebyTenPercentTwoDigits = Double.parseDouble(String.format("%.2f", dividebyTenPercent));
//        int updatedGlobalVariable = globalVariable;

        double tenPercent = (inputFromEditText * dividebyTenPercentTwoDigits);
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
        double fortyPercentN = ((valueofNTwoDigits * 40.0) / 100.0);
        double fortyPercentNTwoDigit = Double.parseDouble(String.format("%.2f", fortyPercentN));
        double nfortyPercent = ((fortyPercentNTwoDigit * 100.0) / 46.0);
        double outputnfortyPercent = inputFromEditText * nfortyPercent;
        double twodigitoutputnfortyPercent = Double.parseDouble(String.format("%.2f", outputnfortyPercent));
        binding.ureaInKg.setText(String.valueOf(twodigitoutputnfortyPercent + " किलो"));
        double ureaBag = twodigitoutputnfortyPercent / 45.0;
        double ureaBagtwoDigit = Double.parseDouble(String.format("%.2f", ureaBag));
        binding.Urea.setText(String.valueOf(ureaBagtwoDigit + " गोणी"));

        // 3rd dose 10%
        double thirtyPercentN = ((valueofNTwoDigits * 10.0) / 100.0);
        double thirtyPercentNTwoDigit = Double.parseDouble(String.format("%.2f", thirtyPercentN));
        double nTenPercent = ((thirtyPercentNTwoDigit * 100.0) / 46.0);
        double outputntenPercent = inputFromEditText * nTenPercent;
        double outputntenPercentTwoDigit = Double.parseDouble(String.format("%.2f", outputntenPercent));
        binding.tvUrea3.setText(String.valueOf(outputntenPercentTwoDigit + " किलो"));
        double ureaBagthirdDose = outputntenPercentTwoDigit / 45.0;
        double ureaBagthirdDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaBagthirdDose));
        binding.UreaBag3.setText(String.valueOf(ureaBagthirdDoseTwoDigit + " गोणी"));

        //4th dose
//      int fortyPercentGlobalVar = globalVarHector;
        double fortyPercent = (inputFromEditText * fortyPercentNTwoDigit);
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

    private void valueForCalculationAcer(String input) {
        //for 1 Acer
        double inputFromEditText = Float.parseFloat(input);
        //NPK=200:80:80
        // Calculations for P & k
        // 10:26:26
        //Value of P
        double valueofP = Double.parseDouble(increasedValueP);
        double valueofPTwoDigits = Double.parseDouble(String.format("%.2f", valueofP));
        //50% of P
        double fiftyPercentOfP = (valueofPTwoDigits / 2.0);
        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double valueOfP = ((fiftyPercentOfPTwoDigits * 100.0) / 26.0);
        double roundValueOfP = Double.parseDouble(String.format("%.2f", valueOfP));

        //Value of K
        double valueofK = Double.parseDouble(increasedValueK);
        double valueofKTwoDigits = Double.parseDouble(String.format("%.2f", valueofK));
        //50% of P
        double fiftyPercentOfK = (valueofKTwoDigits / 2.0);
        double fiftyPercentOfKTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfK));
        double valueOfK = ((fiftyPercentOfKTwoDigits * 100.0) / 26.0);
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
        double bagForFirstDose = (halfOfPAndK / 50.0);
        double bagForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForFirstDose));
        double bagForLastDose = (halfOfPAndK / 50.0);
        double bagForLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForLastDose));

        binding.tvSSPInBag.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        binding.SSFBag4.setText(String.valueOf(bagForLastDoseTwoDigit + " गोणी"));

        //Caclutions for N
        //for 1st Dose
        double tenPercentOfPK = (halfOfPAndK / 10.0);
        double tenPercentOfPKTwoDigit = Double.parseDouble(String.format("%.2f", tenPercentOfPK));
        //Minus that value from 20 because 200/10 %=20 for first dose
        //Value of N
        double valueofN = Double.parseDouble(increasedValueN);
        double valueofNTwoDigits = Double.parseDouble(String.format("%.2f", valueofN));
        double dividebyTenPercent = (valueofNTwoDigits * 10.0 / 100.0);
        double dividebyTenPercentTwoDigits = Double.parseDouble(String.format("%.2f", dividebyTenPercent));
//        int updatedGlobalVariable = globalVariable;

        double tenPercent = (inputFromEditText * dividebyTenPercentTwoDigits);
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
        double fortyPercentN = ((valueofNTwoDigits * 40.0) / 100.0);
        double fortyPercentNTwoDigit = Double.parseDouble(String.format("%.2f", fortyPercentN));
        double nfortyPercent = ((fortyPercentNTwoDigit * 100.0) / 46.0);
        double outputnfortyPercent = inputFromEditText * nfortyPercent;
        double twodigitoutputnfortyPercent = Double.parseDouble(String.format("%.2f", outputnfortyPercent));
        binding.ureaInKg.setText(String.valueOf(twodigitoutputnfortyPercent + " किलो"));
        double ureaBag = twodigitoutputnfortyPercent / 45.0;
        double ureaBagtwoDigit = Double.parseDouble(String.format("%.2f", ureaBag));
        binding.Urea.setText(String.valueOf(ureaBagtwoDigit + " गोणी"));

        // 3rd dose 10%
        double thirtyPercentN = ((valueofNTwoDigits * 10.0) / 100.0);
        double thirtyPercentNTwoDigit = Double.parseDouble(String.format("%.2f", thirtyPercentN));
        double nTenPercent = ((thirtyPercentNTwoDigit * 100.0) / 46.0);
        double outputntenPercent = inputFromEditText * nTenPercent;
        double outputntenPercentTwoDigit = Double.parseDouble(String.format("%.2f", outputntenPercent));
        binding.tvUrea3.setText(String.valueOf(outputntenPercentTwoDigit + " किलो"));
        double ureaBagthirdDose = outputntenPercentTwoDigit / 45.0;
        double ureaBagthirdDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaBagthirdDose));
        binding.UreaBag3.setText(String.valueOf(ureaBagthirdDoseTwoDigit + " गोणी"));

        //4th dose
//      int fortyPercentGlobalVar = globalVarHector;

        double fortyPercent = (inputFromEditText * fortyPercentNTwoDigit);
        double fortyPercentTwoDigit = Double.parseDouble(String.format("%.2f", fortyPercent));
        double minusForty = (fortyPercentTwoDigit - tenPercentOfPKTwoDigit);
        double minusFortyTwoDigit = Double.parseDouble(String.format("%.2f", minusForty));

        double ureaForLastDose = ((minusFortyTwoDigit * 100) / 46.0);
        double ureaForLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaForLastDose));
        binding.tvUrea4.setText(String.valueOf(ureaForLastDoseTwoDigit + " किलो"));
        //BagsCalculation
        double bagsOfUreaLastDose = (ureaForLastDoseTwoDigit / 45.0);
        double bagsOfUreaLastDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagsOfUreaLastDose));
        binding.UreaBag4.setText(String.valueOf(bagsOfUreaLastDoseTwoDigit + " गोणी"));

        //Total Urea
        double totalUrea = ureaForFirstDoseTwoDigit + twodigitoutputnfortyPercent + outputntenPercentTwoDigit + ureaForLastDoseTwoDigit;
        double totalUreaTwoDigit = Double.parseDouble(String.format("%.2f", totalUrea));
        binding.tvUrea.setText(String.valueOf(totalUreaTwoDigit + " किलो"));

    }

    private void valueForCalculation(String input) {
        //for 1 hector
        double inputFromEditText = Float.parseFloat(input);
        //NPK=500:200:200
        // Calculations for P & k
        // 10:26:26
        //Value of P
        double valueofP = Double.parseDouble(increasedValueP);
        double valueofPTwoDigits = Double.parseDouble(String.format("%.2f", valueofP));
        //50% of P
        double fiftyPercentOfP = (valueofPTwoDigits / 2.0);
        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double valueOfP = ((fiftyPercentOfPTwoDigits * 100.0) / 26.0);
        double roundValueOfP = Double.parseDouble(String.format("%.2f", valueOfP));

        //Value of K
        double valueofK = Double.parseDouble(increasedValueK);
        double valueofKTwoDigits = Double.parseDouble(String.format("%.2f", valueofK));
        //50% of P
        double fiftyPercentOfK = (valueofKTwoDigits / 2.0);
        double fiftyPercentOfKTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfK));
        double valueOfK = ((fiftyPercentOfKTwoDigits * 100.0) / 26.0);
        double roundValueOfK = Double.parseDouble(String.format("%.2f", valueOfK));

        double total = (roundValueOfP + roundValueOfK);
        double valueFromTiet = (total * inputFromEditText);
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
        //Value of N
        double valueofN = Double.parseDouble(increasedValueN);
        double valueofNTwoDigits = Double.parseDouble(String.format("%.2f", valueofN));
        double dividebyTenPercent = (valueofNTwoDigits * 10.0 / 100.0);
        double dividebyTenPercentTwoDigits = Double.parseDouble(String.format("%.2f", dividebyTenPercent));
//        int updatedGlobalVariable = globalVariable;


        double tenPercent = (inputFromEditText * dividebyTenPercentTwoDigits);
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
        //Calculate 40% of N
        double fortyPercentN = ((valueofNTwoDigits * 40.0) / 100.0);
        double fortyPercentNTwoDigit = Double.parseDouble(String.format("%.2f", fortyPercentN));
        double nfortyPercent = ((fortyPercentNTwoDigit * 100.0) / 46.0);
        double outputnfortyPercent = inputFromEditText * nfortyPercent;
        double twodigitoutputnfortyPercent = Double.parseDouble(String.format("%.2f", outputnfortyPercent));
        binding.ureaInKg.setText(String.valueOf(twodigitoutputnfortyPercent + " किलो"));
        double ureaBag = twodigitoutputnfortyPercent / 45.0;
        double ureaBagtwoDigit = Double.parseDouble(String.format("%.2f", ureaBag));
        binding.Urea.setText(String.valueOf(ureaBagtwoDigit + " गोणी"));

        // 3rd dose 10%
        double tenPercentN = ((valueofNTwoDigits * 10.0) / 100.0);
        double tenPercentNTwoDigit = Double.parseDouble(String.format("%.2f", tenPercentN));
        double nTenPercent = ((tenPercentNTwoDigit * 100.0) / 46.0);
        double outputntenPercent = inputFromEditText * nTenPercent;
        double outputntenPercentTwoDigit = Double.parseDouble(String.format("%.2f", outputntenPercent));
        binding.tvUrea3.setText(String.valueOf(outputntenPercentTwoDigit + " किलो"));
        double ureaBagthirdDose = outputntenPercentTwoDigit / 45.0;
        double ureaBagthirdDoseTwoDigit = Double.parseDouble(String.format("%.2f", ureaBagthirdDose));
        binding.UreaBag3.setText(String.valueOf(ureaBagthirdDoseTwoDigit + " गोणी"));

        //4th dose
//      int fortyPercentGlobalVar = globalVarHector;

        double fortyPercent = (inputFromEditText * fortyPercentNTwoDigit);
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