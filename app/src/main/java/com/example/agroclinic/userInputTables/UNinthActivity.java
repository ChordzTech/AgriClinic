package com.example.agroclinic.userInputTables;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivityUninthBinding;

import java.text.DecimalFormat;

public class UNinthActivity extends AppCompatActivity {
    ActivityUninthBinding binding;
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_uninth);
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
                        Toast.makeText(UNinthActivity.this, "एकर", Toast.LENGTH_SHORT).show();
                        valueForConditionOfAcer();
                    } else if (binding.rbHector.isChecked()) {
                        valueForConditionCheck();
                        Toast.makeText(UNinthActivity.this, "हेक्टर", Toast.LENGTH_SHORT).show();
                    } else if (binding.rbGunta.isChecked()) {
                        Toast.makeText(UNinthActivity.this, "गुंठा", Toast.LENGTH_SHORT).show();
                        valueForConditionOfGunta();
                    } else {
                        Toast.makeText(UNinthActivity.this, "कृपया एकक निवडा", Toast.LENGTH_SHORT).show();
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
        //Gunta 3:1.4:1.4
        float inputFromEditTextN = Float.parseFloat(valueOfN);
        float inputFromEditTextP = Float.parseFloat(valueOfP);
        float inputFromEditTextK = Float.parseFloat(valueOfK);
        float inputFromEditTextLand = Float.parseFloat(valueOfLand);

        if (inputFromEditTextN < 1.4) {
            increasedValueN = String.valueOf(4.5);
        } else if (inputFromEditTextN >= 1.4 && inputFromEditTextN <= 2.8) {
            increasedValueN = String.valueOf(3.75);
        } else if (inputFromEditTextN >= 2.9 && inputFromEditTextN <= 5.6) {
            increasedValueN = String.valueOf(3.0);
        } else if (inputFromEditTextN >= 5.7 && inputFromEditTextN <= 7.0) {
            increasedValueN = String.valueOf(2.25);
        } else if (inputFromEditTextN > 7.1) {
            increasedValueN = String.valueOf(1.5);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }
        if (inputFromEditTextP < 0.075) {
            increasedValueP = String.valueOf(2.1);
        } else if (inputFromEditTextP >= 0.076 && inputFromEditTextP <= 0.14) {
            increasedValueP = String.valueOf(1.75);
        } else if ((inputFromEditTextP >= 0.15 && inputFromEditTextP <= 0.28)) {
            increasedValueP = String.valueOf(1.4);
        } else if ((inputFromEditTextP >= 0.29 && inputFromEditTextP <= 0.35)) {
            increasedValueP = String.valueOf(1.05);
        } else if (inputFromEditTextP > 0.36) {
            increasedValueP = String.valueOf(0.7);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

        if (inputFromEditTextK < 1.0) {
            increasedValueK = String.valueOf(2.1);
        } else if (inputFromEditTextK >= 1.01 && inputFromEditTextK <= 1.5) {
            increasedValueK = String.valueOf(1.75);
        } else if (inputFromEditTextK >= 1.6 && inputFromEditTextK <= 2.5) {
            increasedValueK = String.valueOf(1.4);
        } else if (inputFromEditTextK >= 2.6 && inputFromEditTextK <= 3.0) {
            increasedValueK = String.valueOf(1.05);
        } else if (inputFromEditTextK > 3.1) {
            increasedValueK = String.valueOf(0.7);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

    }

    private void valueForConditionOfAcer() {
        //120:56:56
        float inputFromEditTextN = Float.parseFloat(valueOfN);
        float inputFromEditTextP = Float.parseFloat(valueOfP);
        float inputFromEditTextK = Float.parseFloat(valueOfK);
        float inputFromEditTextLand = Float.parseFloat(valueOfLand);

        if (inputFromEditTextN < 56.0) {
            increasedValueN = String.valueOf(180.0);
        } else if (inputFromEditTextN >= 56.0 && inputFromEditTextN <= 112.0) {
            increasedValueN = String.valueOf(150.0);
        } else if (inputFromEditTextN >= 113.0 && inputFromEditTextN <= 224.0) {
            increasedValueN = String.valueOf(120.0);
        } else if (inputFromEditTextN >= 225.0 && inputFromEditTextN <= 280.0) {
            increasedValueN = String.valueOf(90.0);
        } else if (inputFromEditTextN > 280.0) {
            increasedValueN = String.valueOf(60.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

        if (inputFromEditTextP < 2.8) {
            increasedValueP = String.valueOf(84.0);
        } else if (inputFromEditTextP >= 3.0 && inputFromEditTextP <= 5.6) {
            increasedValueP = String.valueOf(70.0);
        } else if ((inputFromEditTextP >= 6.0 && inputFromEditTextP <= 11.2)) {
            increasedValueP = String.valueOf(56.0);
        } else if ((inputFromEditTextP >= 12.0 && inputFromEditTextP <= 14.0)) {
            increasedValueP = String.valueOf(42.0);
        } else if (inputFromEditTextP > 15.0) {
            increasedValueP = String.valueOf(28.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

        if (inputFromEditTextK < 40.0) {
            increasedValueK = String.valueOf(84.0);
        } else if (inputFromEditTextK >= 40.4 && inputFromEditTextK <= 60.0) {
            increasedValueK = String.valueOf(70.0);
        } else if (inputFromEditTextK >= 61.4 && inputFromEditTextK <= 100.0) {
            increasedValueK = String.valueOf(56.0);
        } else if (inputFromEditTextK >= 101.0 && inputFromEditTextK <= 120.0) {
            increasedValueK = String.valueOf(42.0);
        } else if (inputFromEditTextK > 121.0) {
            increasedValueK = String.valueOf(28.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }
    }

    private void valueForConditionCheck() {
        //300:140:140
        float inputFromEditTextN = Float.parseFloat(valueOfN);
        float inputFromEditTextP = Float.parseFloat(valueOfP);
        float inputFromEditTextK = Float.parseFloat(valueOfK);
        float inputFromEditTextLand = Float.parseFloat(valueOfLand);

        if (inputFromEditTextN < 140.0) {
            increasedValueN = String.valueOf(450.0);
        } else if (inputFromEditTextN >= 141.0 && inputFromEditTextN <= 280.0) {
            increasedValueN = String.valueOf(375.0);
        } else if (inputFromEditTextN >= 281.0 && inputFromEditTextN <= 560.0) {
            increasedValueN = String.valueOf(300.0);
        } else if (inputFromEditTextN >= 561.0 && inputFromEditTextN <= 700.0) {
            increasedValueN = String.valueOf(225.0);
        } else if (inputFromEditTextN > 700.0) {
            increasedValueN = String.valueOf(150.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

        if (inputFromEditTextP < 7.0) {
            increasedValueP = String.valueOf(210.0);
        } else if (inputFromEditTextP >= 8.0 && inputFromEditTextP <= 14.0) {
            increasedValueP = String.valueOf(175.0);
        } else if ((inputFromEditTextP >= 15.0 && inputFromEditTextP <= 28.0)) {
            increasedValueP = String.valueOf(140.0);
        } else if ((inputFromEditTextP >= 29.0 && inputFromEditTextP <= 35.0)) {
            increasedValueP = String.valueOf(105.0);
        } else if (inputFromEditTextP > 35.0) {
            increasedValueP = String.valueOf(70.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

        if (inputFromEditTextK < 100.0) {
            increasedValueK = String.valueOf(210.0);
        } else if (inputFromEditTextK >= 101.0 && inputFromEditTextK <= 150.0) {
            increasedValueK = String.valueOf(175.0);
        } else if (inputFromEditTextK >= 151.0 && inputFromEditTextK <= 250.0) {
            increasedValueK = String.valueOf(140.0);
        } else if (inputFromEditTextK >= 251.0 && inputFromEditTextK <= 300.0) {
            increasedValueK = String.valueOf(105.0);
        } else if (inputFromEditTextK > 300.0) {
            increasedValueK = String.valueOf(70.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

    }
    private void valueForCalculationGunta(String input) {
        float inputFromEditText = Float.parseFloat(input);
        //Firstly get NPK
        double valueOfN = Double.parseDouble(increasedValueN);
        double valueOfP = Double.parseDouble(increasedValueP);
        double valueOfK = Double.parseDouble(increasedValueK);
        //Now get 10% of N
        double inputIntoN = (valueOfN * inputFromEditText);
        double inputIntoNTwoDigits = Double.parseDouble(String.format("%.2f", inputIntoN));
        double tenPercentOfN = ((inputIntoNTwoDigits * 10.0) / 100.0);
        double tenPercentOfNTwoDigits = Double.parseDouble(String.format("%.2f", tenPercentOfN));
        //First Dose Of 19:19:19
        //we are getting 100 from 19 we have to get tenPercentOfNTwoDigits from 100
        double firstDoseOf19 = ((tenPercentOfNTwoDigits * 100.0) / 19.0);
        double firstDoseOf19TwoDigits = Double.parseDouble(String.format("%.2f", firstDoseOf19));
        binding.tv19InKg.setText(String.valueOf(firstDoseOf19TwoDigits + " किलो"));
        binding.tv19InKgFourthWeek.setText(String.valueOf(firstDoseOf19TwoDigits + " किलो"));
        //Bags Calculation
        double bagForFirstDose = (firstDoseOf19TwoDigits / 45.0);
        double bagForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForFirstDose));
        binding.tv19InBags.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        binding.tv19InBagsFourthWeek.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        //Total
        double total19 = (firstDoseOf19TwoDigits * 2);
        double total19TwoDigits = Double.parseDouble(String.format("%.2f", total19));
        binding.tvTotal19.setText(String.valueOf(total19TwoDigits + " किलो"));

        //Calculation for SSP
        // fifty % of P and minus from 10 % of n
        double fiftyPercentOfP = (valueOfP / 2.0);
        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double inputIntoP = (fiftyPercentOfPTwoDigits * inputFromEditText);
        double inputIntoPTwoDigits = Double.parseDouble(String.format("%.2f", inputIntoP));
        double minusNFromP = (inputIntoPTwoDigits - 0.29);
        double minusNFromPTwoDigits = Double.parseDouble(String.format("%.2f", minusNFromP));
        double sspFirstDose = ((minusNFromPTwoDigits * 100.0) / 16.0);
        double sspFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", sspFirstDose));
        binding.tvSSPInKg.setText(String.valueOf(sspFirstDoseTwoDigits + " किलो"));
        binding.tvSSF4.setText(String.valueOf(sspFirstDoseTwoDigits + " किलो"));
        //Bags for ssp
        double bagsForSsp = (sspFirstDoseTwoDigits / 50.0);
        double bagsForSspTwoDigits = Double.parseDouble(String.format("%.2f", bagsForSsp));
        binding.SSFBag4.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        binding.tvSSPInBag.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        //Total Ssp
        double totalSsp = (sspFirstDoseTwoDigits * 2);
        double totalSspTwoDigits = Double.parseDouble(String.format("%.2f", totalSsp));
        binding.tvSsf.setText(String.valueOf(totalSspTwoDigits + " किलो"));

        //Calculation for MOP
        // fifty % of K and minus from 10 % of n
        double fiftyPercentOfK = (valueOfK / 2.0);
        double fiftyPercentOfKTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfK));
        double inputIntoK = (fiftyPercentOfKTwoDigits * inputFromEditText);
        double inputIntoKTwoDigits = Double.parseDouble(String.format("%.2f", inputIntoK));
        double minusNFromK = (inputIntoKTwoDigits - 0.29);
        double minusNFromKTwoDigits = Double.parseDouble(String.format("%.2f", minusNFromK));
        double mopFirstDose = ((minusNFromKTwoDigits * 100.0) / 60.0);
        double mopFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", mopFirstDose));
        binding.tvMopInKg.setText(String.valueOf(mopFirstDoseTwoDigits + " किलो"));
        binding.tvMOP4.setText(String.valueOf(mopFirstDoseTwoDigits + " किलो"));
        //Bags for Mop
        double bagsForMop = (mopFirstDoseTwoDigits / 50.0);
        double bagsForMopTwoDigits = Double.parseDouble(String.format("%.2f", bagsForMop));
        binding.MopInBag.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        binding.MOPBag4.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        //Total Mop
        double totalMop = (mopFirstDoseTwoDigits * 2.0);
        double totalMopTwoDigits = Double.parseDouble(String.format("%.2f", totalMop));
        binding.tvMop.setText(String.valueOf(totalMopTwoDigits + " किलो"));

        // N for 2nd 3rd and 4th dose
        // for 2nd dose 40% of N
        double fortyPercentOfN = ((inputIntoNTwoDigits * 40.0) / 100.0);
        double fortyPercentOfNTwoDigits = Double.parseDouble(String.format("%.2f", fortyPercentOfN));
        double ureaFor2ndDose = ((fortyPercentOfNTwoDigits * 100.0) / 46.0);
        double ureaFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor2ndDose));
        binding.ureaInKgSecondDose.setText(String.valueOf(ureaFor2ndDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor2ndDose = (ureaFor2ndDoseTwoDigits / 45.0);
        double bagsFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor2ndDose));
        binding.UreaBagSecondDose.setText(String.valueOf(bagsFor2ndDoseTwoDigits + " गोणी"));

        // for 3rd dose 10% of N
        double ureaFor3rdDose = ((tenPercentOfNTwoDigits * 100.0) / 46.0);
        double ureaFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor3rdDose));
        binding.tvUrea3.setText(String.valueOf(ureaFor3rdDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor3rdDose = (ureaFor3rdDoseTwoDigits / 45.0);
        double bagsFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor3rdDose));
        binding.UreaBag3.setText(String.valueOf(bagsFor3rdDoseTwoDigits + " गोणी"));

        // 4th Dose 40 % of N
//        forty percent =fortyPercentOfNTwoDigits
//        tenPercentOfNTwoDigits
        double minusFortyPFromTenP=(fortyPercentOfNTwoDigits-0.29);
        double minusFortyPFromTenPTwoDigits = Double.parseDouble(String.format("%.2f", minusFortyPFromTenP));
        double ureaLastDose=((minusFortyPFromTenPTwoDigits*100.0)/46.0);
        double ureaLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaLastDose));
        binding.tvUrea4.setText(String.valueOf(ureaLastDoseTwoDigits + " किलो"));
        //Bags
        double bagsForLastDose = (ureaLastDoseTwoDigits / 45.0);
        double bagsForLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsForLastDose));
        binding.UreaBag4.setText(String.valueOf(bagsForLastDoseTwoDigits + " गोणी"));

        //Total urea
        double totalUrea = (ureaFor2ndDoseTwoDigits + ureaFor3rdDoseTwoDigits + ureaLastDoseTwoDigits);
        double totalUreaTwoDigits = Double.parseDouble(String.format("%.2f", totalUrea));
        binding.tvUrea.setText(String.valueOf(totalUreaTwoDigits + " किलो"));
    }

    private void valueForCalculationAcer(String input) {
        float inputFromEditText = Float.parseFloat(input);
        //Firstly get NPK
        double valueOfN = Double.parseDouble(increasedValueN);
        double valueOfP = Double.parseDouble(increasedValueP);
        double valueOfK = Double.parseDouble(increasedValueK);
        //Now get 10% of N
        double inputIntoN = (valueOfN * inputFromEditText);
        double inputIntoNTwoDigits = Double.parseDouble(String.format("%.2f", inputIntoN));
        double tenPercentOfN = ((inputIntoNTwoDigits * 10.0) / 100.0);
        double tenPercentOfNTwoDigits = Double.parseDouble(String.format("%.2f", tenPercentOfN));
        //First Dose Of 19:19:19
        //we are getting 100 from 19 we have to get tenPercentOfNTwoDigits from 100
        double firstDoseOf19 = ((tenPercentOfNTwoDigits * 100.0) / 19.0);
        double firstDoseOf19TwoDigits = Double.parseDouble(String.format("%.2f", firstDoseOf19));
        binding.tv19InKg.setText(String.valueOf(firstDoseOf19TwoDigits + " किलो"));
        binding.tv19InKgFourthWeek.setText(String.valueOf(firstDoseOf19TwoDigits + " किलो"));
        //Bags Calculation
        double bagForFirstDose = (firstDoseOf19TwoDigits / 45.0);
        double bagForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForFirstDose));
        binding.tv19InBags.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        binding.tv19InBagsFourthWeek.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        //Total
        double total19 = (firstDoseOf19TwoDigits * 2);
        double total19TwoDigits = Double.parseDouble(String.format("%.2f", total19));
        binding.tvTotal19.setText(String.valueOf(total19TwoDigits + " किलो"));

        //Calculation for SSP
        // fifty % of P and minus from 10 % of n
        double fiftyPercentOfP = (valueOfP / 2.0);
        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double inputIntoP = (fiftyPercentOfPTwoDigits * inputFromEditText);
        double inputIntoPTwoDigits = Double.parseDouble(String.format("%.2f", inputIntoP));
        double minusNFromP = (inputIntoPTwoDigits - 12.0);
        double minusNFromPTwoDigits = Double.parseDouble(String.format("%.2f", minusNFromP));
        double sspFirstDose = ((minusNFromPTwoDigits * 100.0) / 16.0);
        double sspFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", sspFirstDose));
        binding.tvSSPInKg.setText(String.valueOf(sspFirstDoseTwoDigits + " किलो"));
        binding.tvSSF4.setText(String.valueOf(sspFirstDoseTwoDigits + " किलो"));
        //Bags for ssp
        double bagsForSsp = (sspFirstDoseTwoDigits / 50.0);
        double bagsForSspTwoDigits = Double.parseDouble(String.format("%.2f", bagsForSsp));
        binding.SSFBag4.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        binding.tvSSPInBag.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        //Total Ssp
        double totalSsp = (sspFirstDoseTwoDigits * 2);
        double totalSspTwoDigits = Double.parseDouble(String.format("%.2f", totalSsp));
        binding.tvSsf.setText(String.valueOf(totalSspTwoDigits + " किलो"));

        //Calculation for MOP
        // fifty % of K and minus from 10 % of n
        double fiftyPercentOfK = (valueOfK / 2.0);
        double fiftyPercentOfKTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfK));
        double inputIntoK = (fiftyPercentOfKTwoDigits * inputFromEditText);
        double inputIntoKTwoDigits = Double.parseDouble(String.format("%.2f", inputIntoK));
        double minusNFromK = (inputIntoKTwoDigits - 12.0);
        double minusNFromKTwoDigits = Double.parseDouble(String.format("%.2f", minusNFromK));
        double mopFirstDose = ((minusNFromKTwoDigits * 100.0) / 60.0);
        double mopFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", mopFirstDose));
        binding.tvMopInKg.setText(String.valueOf(mopFirstDoseTwoDigits + " किलो"));
        binding.tvMOP4.setText(String.valueOf(mopFirstDoseTwoDigits + " किलो"));
        //Bags for Mop
        double bagsForMop = (mopFirstDoseTwoDigits / 50.0);
        double bagsForMopTwoDigits = Double.parseDouble(String.format("%.2f", bagsForMop));
        binding.MopInBag.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        binding.MOPBag4.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        //Total Mop
        double totalMop = (mopFirstDoseTwoDigits * 2.0);
        double totalMopTwoDigits = Double.parseDouble(String.format("%.2f", totalMop));
        binding.tvMop.setText(String.valueOf(totalMopTwoDigits + " किलो"));

        // N for 2nd 3rd and 4th dose
        // for 2nd dose 40% of N
        double fortyPercentOfN = ((inputIntoNTwoDigits * 40.0) / 100.0);
        double fortyPercentOfNTwoDigits = Double.parseDouble(String.format("%.2f", fortyPercentOfN));
        double ureaFor2ndDose = ((fortyPercentOfNTwoDigits * 100.0) / 46.0);
        double ureaFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor2ndDose));
        binding.ureaInKgSecondDose.setText(String.valueOf(ureaFor2ndDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor2ndDose = (ureaFor2ndDoseTwoDigits / 45.0);
        double bagsFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor2ndDose));
        binding.UreaBagSecondDose.setText(String.valueOf(bagsFor2ndDoseTwoDigits + " गोणी"));

        // for 3rd dose 10% of N
        double ureaFor3rdDose = ((tenPercentOfNTwoDigits * 100.0) / 46.0);
        double ureaFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor3rdDose));
        binding.tvUrea3.setText(String.valueOf(ureaFor3rdDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor3rdDose = (ureaFor3rdDoseTwoDigits / 45.0);
        double bagsFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor3rdDose));
        binding.UreaBag3.setText(String.valueOf(bagsFor3rdDoseTwoDigits + " गोणी"));

        // 4th Dose 40 % of N
//        forty percent =fortyPercentOfNTwoDigits
//        tenPercentOfNTwoDigits
        double minusFortyPFromTenP=(fortyPercentOfNTwoDigits-12.0);
        double minusFortyPFromTenPTwoDigits = Double.parseDouble(String.format("%.2f", minusFortyPFromTenP));
        double ureaLastDose=((minusFortyPFromTenPTwoDigits*100.0)/46.0);
        double ureaLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaLastDose));
        binding.tvUrea4.setText(String.valueOf(ureaLastDoseTwoDigits + " किलो"));
        //Bags
        double bagsForLastDose = (ureaLastDoseTwoDigits / 45.0);
        double bagsForLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsForLastDose));
        binding.UreaBag4.setText(String.valueOf(bagsForLastDoseTwoDigits + " गोणी"));

        //Total urea
        double totalUrea = (ureaFor2ndDoseTwoDigits + ureaFor3rdDoseTwoDigits + ureaLastDoseTwoDigits);
        double totalUreaTwoDigits = Double.parseDouble(String.format("%.2f", totalUrea));
        binding.tvUrea.setText(String.valueOf(totalUreaTwoDigits + " किलो"));
    }

    private void valueForCalculation(String input) {
        float inputFromEditText = Float.parseFloat(input);
        //Firstly get NPK
        double valueOfN = Double.parseDouble(increasedValueN);
        double valueOfP = Double.parseDouble(increasedValueP);
        double valueOfK = Double.parseDouble(increasedValueK);
        //Now get 10% of N
        double inputIntoN = (valueOfN * inputFromEditText);
        double inputIntoNTwoDigits = Double.parseDouble(String.format("%.2f", inputIntoN));
        double tenPercentOfN = ((inputIntoNTwoDigits * 10.0) / 100.0);
        double tenPercentOfNTwoDigits = Double.parseDouble(String.format("%.2f", tenPercentOfN));
        //First Dose Of 19:19:19
        //we are getting 100 from 19 we have to get tenPercentOfNTwoDigits from 100
        double firstDoseOf19 = ((tenPercentOfNTwoDigits * 100.0) / 19.0);
        double firstDoseOf19TwoDigits = Double.parseDouble(String.format("%.2f", firstDoseOf19));
        binding.tv19InKg.setText(String.valueOf(firstDoseOf19TwoDigits + " किलो"));
        binding.tv19InKgFourthWeek.setText(String.valueOf(firstDoseOf19TwoDigits + " किलो"));
        //Bags Calculation
        double bagForFirstDose = (firstDoseOf19TwoDigits / 45.0);
        double bagForFirstDoseTwoDigit = Double.parseDouble(String.format("%.2f", bagForFirstDose));
        binding.tv19InBags.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        binding.tv19InBagsFourthWeek.setText(String.valueOf(bagForFirstDoseTwoDigit + " गोणी"));
        //Total
        double total19 = (firstDoseOf19TwoDigits * 2);
        double total19TwoDigits = Double.parseDouble(String.format("%.2f", total19));
        binding.tvTotal19.setText(String.valueOf(total19TwoDigits + " किलो"));

        //Calculation for SSP
        // fifty % of P and minus from 10 % of n
        double fiftyPercentOfP = (valueOfP / 2.0);
        double fiftyPercentOfPTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfP));
        double inputIntoP = (fiftyPercentOfPTwoDigits * inputFromEditText);
        double inputIntoPTwoDigits = Double.parseDouble(String.format("%.2f", inputIntoP));
        double minusNFromP = (inputIntoPTwoDigits - 30.0);
        double minusNFromPTwoDigits = Double.parseDouble(String.format("%.2f", minusNFromP));
        double sspFirstDose = ((minusNFromPTwoDigits * 100.0) / 16.0);
        double sspFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", sspFirstDose));
        binding.tvSSPInKg.setText(String.valueOf(sspFirstDoseTwoDigits + " किलो"));
        binding.tvSSF4.setText(String.valueOf(sspFirstDoseTwoDigits + " किलो"));
        //Bags for ssp
        double bagsForSsp = (sspFirstDoseTwoDigits / 50.0);
        double bagsForSspTwoDigits = Double.parseDouble(String.format("%.2f", bagsForSsp));
        binding.SSFBag4.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        binding.tvSSPInBag.setText(String.valueOf(bagsForSspTwoDigits + " गोणी"));
        //Total Ssp
        double totalSsp = (sspFirstDoseTwoDigits * 2);
        double totalSspTwoDigits = Double.parseDouble(String.format("%.2f", totalSsp));
        binding.tvSsf.setText(String.valueOf(totalSspTwoDigits + " किलो"));

        //Calculation for MOP
        // fifty % of K and minus from 10 % of n
        double fiftyPercentOfK = (valueOfK / 2.0);
        double fiftyPercentOfKTwoDigits = Double.parseDouble(String.format("%.2f", fiftyPercentOfK));
        double inputIntoK = (fiftyPercentOfKTwoDigits * inputFromEditText);
        double inputIntoKTwoDigits = Double.parseDouble(String.format("%.2f", inputIntoK));
        double minusNFromK = (inputIntoKTwoDigits - 30.0);
        double minusNFromKTwoDigits = Double.parseDouble(String.format("%.2f", minusNFromK));
        double mopFirstDose = ((minusNFromKTwoDigits * 100.0) / 60.0);
        double mopFirstDoseTwoDigits = Double.parseDouble(String.format("%.2f", mopFirstDose));
        binding.tvMopInKg.setText(String.valueOf(mopFirstDoseTwoDigits + " किलो"));
        binding.tvMOP4.setText(String.valueOf(mopFirstDoseTwoDigits + " किलो"));
        //Bags for Mop
        double bagsForMop = (mopFirstDoseTwoDigits / 50.0);
        double bagsForMopTwoDigits = Double.parseDouble(String.format("%.2f", bagsForMop));
        binding.MopInBag.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        binding.MOPBag4.setText(String.valueOf(bagsForMopTwoDigits + " गोणी"));
        //Total Mop
        double totalMop = (mopFirstDoseTwoDigits * 2.0);
        double totalMopTwoDigits = Double.parseDouble(String.format("%.2f", totalMop));
        binding.tvMop.setText(String.valueOf(totalMopTwoDigits + " किलो"));

        // N for 2nd 3rd and 4th dose
        // for 2nd dose 40% of N
        double fortyPercentOfN = ((inputIntoNTwoDigits * 40.0) / 100.0);
        double fortyPercentOfNTwoDigits = Double.parseDouble(String.format("%.2f", fortyPercentOfN));
        double ureaFor2ndDose = ((fortyPercentOfNTwoDigits * 100.0) / 46.0);
        double ureaFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor2ndDose));
        binding.ureaInKgSecondDose.setText(String.valueOf(ureaFor2ndDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor2ndDose = (ureaFor2ndDoseTwoDigits / 45.0);
        double bagsFor2ndDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor2ndDose));
        binding.UreaBagSecondDose.setText(String.valueOf(bagsFor2ndDoseTwoDigits + " गोणी"));

        // for 3rd dose 10% of N
        double ureaFor3rdDose = ((tenPercentOfNTwoDigits * 100.0) / 46.0);
        double ureaFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaFor3rdDose));
        binding.tvUrea3.setText(String.valueOf(ureaFor3rdDoseTwoDigits + " किलो"));
        //Bags
        double bagsFor3rdDose = (ureaFor3rdDoseTwoDigits / 45.0);
        double bagsFor3rdDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsFor3rdDose));
        binding.UreaBag3.setText(String.valueOf(bagsFor3rdDoseTwoDigits + " गोणी"));

        // 4th Dose 40 % of N
//        forty percent =fortyPercentOfNTwoDigits
//        tenPercentOfNTwoDigits
        double minusFortyPFromTenP=(fortyPercentOfNTwoDigits-30.0);
        double minusFortyPFromTenPTwoDigits = Double.parseDouble(String.format("%.2f", minusFortyPFromTenP));
        double ureaLastDose=((minusFortyPFromTenPTwoDigits*100.0)/46.0);
        double ureaLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", ureaLastDose));
        binding.tvUrea4.setText(String.valueOf(ureaLastDoseTwoDigits + " किलो"));
        //Bags
        double bagsForLastDose = (ureaLastDoseTwoDigits / 45.0);
        double bagsForLastDoseTwoDigits = Double.parseDouble(String.format("%.2f", bagsForLastDose));
        binding.UreaBag4.setText(String.valueOf(bagsForLastDoseTwoDigits + " गोणी"));

        //Total urea
        double totalUrea = (ureaFor2ndDoseTwoDigits + ureaFor3rdDoseTwoDigits + ureaLastDoseTwoDigits);
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
            // If the result is negative, set it to 0
            if (currentValue < 0) {
                currentValue = 0;
            }
            // Update EditText with the new value
            binding.etLand.setText(decimalFormat.format(currentValue)); // Potential issue here
        }
    }
}