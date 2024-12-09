package com.example.agroclinic.sugarcaneSeeds;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivitySugarCaneSeedsBinding;

import java.text.DecimalFormat;

public class SugarCaneSeedsActivity extends AppCompatActivity {
    ActivitySugarCaneSeedsBinding binding;
    private DecimalFormat decimalFormat;
    private String valueofEditText = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sugar_cane_seeds);
        initView();
    }

    private void initView() {
        // Initialize decimal format to show one decimal place
        decimalFormat = new DecimalFormat("#0.0");
        binding.rgRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                binding.etLand.setText("0.0");
                if (binding.rbEkar.isChecked()) {
                    Toast.makeText(SugarCaneSeedsActivity.this, "अंतर निवडा", Toast.LENGTH_SHORT).show();
                } else if (binding.rbHector.isChecked()) {
                    Toast.makeText(SugarCaneSeedsActivity.this, "अंतर निवडा", Toast.LENGTH_SHORT).show();
                } else if (binding.rbGunta.isChecked()) {
                    Toast.makeText(SugarCaneSeedsActivity.this, "अंतर निवडा", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SugarCaneSeedsActivity.this, "एकक निवडा", Toast.LENGTH_SHORT).show();
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
                    valueofEditText = s.toString();
                    if (binding.rbGunta.isChecked() && binding.rbSixInch.isChecked()) {
                        binding.rbFirst.setText(" 4' X 6'' ");
                        binding.rbSecond.setText(" 4.5' X 6'' ");
                        binding.rbThird.setText(" 5' X 6'' ");
                        binding.rbFourth.setText(" 5.5' X 6'' ");
                        binding.rbFifth.setText(" 6' X 6'' ");
                        calculationForGuntaSixInch(valueofEditText);
                    } else if (binding.rbGunta.isChecked() && binding.rbNineInch.isChecked()) {
                        binding.rbFirst.setText(" 4' X 9'' ");
                        binding.rbSecond.setText(" 4.5' X 9'' ");
                        binding.rbThird.setText(" 5' X 9'' ");
                        binding.rbFourth.setText(" 5.5' X 9'' ");
                        binding.rbFifth.setText(" 6' X 9'' ");
                        calculationForGuntaNineInch(valueofEditText);
                    } else if (binding.rbEkar.isChecked() && binding.rbSixInch.isChecked()) {
                        binding.rbFirst.setText(" 4' X 6'' ");
                        binding.rbSecond.setText(" 4.5' X 6'' ");
                        binding.rbThird.setText(" 5' X 6'' ");
                        binding.rbFourth.setText(" 5.5' X 6'' ");
                        binding.rbFifth.setText(" 6' X 6'' ");
                        calculationForAcerSixInch(valueofEditText);
                    } else if (binding.rbEkar.isChecked() && binding.rbNineInch.isChecked()) {
                        binding.rbFirst.setText(" 4' X 9'' ");
                        binding.rbSecond.setText(" 4.5' X 9'' ");
                        binding.rbThird.setText(" 5' X 9'' ");
                        binding.rbFourth.setText(" 5.5' X 9'' ");
                        binding.rbFifth.setText(" 6' X 9'' ");
                        calculationForAcerNineInch(valueofEditText);
                    } else if (binding.rbHector.isChecked() && binding.rbSixInch.isChecked()) {
                        binding.rbFirst.setText(" 4' X 6'' ");
                        binding.rbSecond.setText(" 4.5' X 6'' ");
                        binding.rbThird.setText(" 5' X 6'' ");
                        binding.rbFourth.setText(" 5.5' X 6'' ");
                        binding.rbFifth.setText(" 6' X 6'' ");
                        calculationForHectorSixInch(valueofEditText);
                    } else if (binding.rbHector.isChecked() && binding.rbNineInch.isChecked()) {
                        binding.rbFirst.setText(" 4' X 9'' ");
                        binding.rbSecond.setText(" 4.5' X 9'' ");
                        binding.rbThird.setText(" 5' X 9'' ");
                        binding.rbFourth.setText(" 5.5' X 9'' ");
                        binding.rbFifth.setText(" 6' X 9'' ");
                        calculationForHectorNineInch(valueofEditText);
                    } else {
                        Toast.makeText(SugarCaneSeedsActivity.this, "अंतर निवडा", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.rbNineInch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (binding.rbNineInch.isChecked()){
                    binding.etLand.setText("0.0");
                    binding.rbFirst.setText(" 4' X 9'' ");
                    binding.rbSecond.setText(" 4.5' X 9'' ");
                    binding.rbThird.setText(" 5' X 9'' ");
                    binding.rbFourth.setText(" 5.5' X 9'' ");
                    binding.rbFifth.setText(" 6' X 9'' ");
                }else if ((binding.rbSixInch.isChecked())){
                    binding.etLand.setText("0.0");
                    binding.rbFirst.setText(" 4' X 6'' ");
                    binding.rbSecond.setText(" 4.5' X 6'' ");
                    binding.rbThird.setText(" 5' X 6'' ");
                    binding.rbFourth.setText(" 5.5' X 6'' ");
                    binding.rbFifth.setText(" 6' X 6'' ");
                }else {
                    binding.etLand.setText("0.0");
                    binding.rbFirst.setText("0 ");
                    binding.rbSecond.setText("0 ");
                    binding.rbThird.setText("0 ");
                    binding.rbFourth.setText("0 ");
                    binding.rbFifth.setText("0 ");
                }
            }
        });
    }


    private void calculationForGuntaSixInch(String input) {
        // 4'X6"
        binding.rbFirst.setText(" 4' X 6'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 204.19);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));
        //Moli Calculation
        double moliRequried=(seedsRequiredFor4TwoDigits/90.0);
        double moliRequriedTwoDigits = Double.parseDouble(String.format("%.2f", moliRequried));
        double round=Math.round(moliRequriedTwoDigits);
        binding.tvMoliFirst.setText(String.valueOf(round));

        // 4.5'X6"
        binding.rbSecond.setText(" 4.5' X 6'' ");
        double seedsRequiredFor45 = (inputFromEditText * 181.42);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));
        //Moli Calculation
        double moliRequried45=(seedsRequiredFor45TwoDigits/90.0);
        double moliRequriedTwoDigits45 = Double.parseDouble(String.format("%.2f", moliRequried45));
        double round45=Math.round(moliRequriedTwoDigits45);
        binding.tvMoliSecond.setText(String.valueOf(round45));

        // 5'X6"
        binding.rbThird.setText(" 5' X 6'' ");
        double seedsRequiredFor5 = (inputFromEditText * 163.35);
        double seedsRequiredFor5TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor5));
        binding.tvThird.setText(String.valueOf(seedsRequiredFor5TwoDigits));
        //Moli Calculation
        double moliRequried5=(seedsRequiredFor5TwoDigits/90.0);
        double moliRequriedTwoDigits5 = Double.parseDouble(String.format("%.2f", moliRequried5));
        double round5=Math.round(moliRequriedTwoDigits5);
        binding.tvMoliThird.setText(String.valueOf(round5));

        // 5.5'X6"
        binding.rbFourth.setText(" 5.5' X 6'' ");
        double seedsRequiredFor55 = (inputFromEditText * 148.5);
        double seedsRequiredFor55TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor55));
        binding.tvFourth.setText(String.valueOf(seedsRequiredFor55TwoDigits));
        //Moli Calculation
        double moliRequried55=(seedsRequiredFor55TwoDigits/90.0);
        double moliRequriedTwoDigits55 = Double.parseDouble(String.format("%.2f", moliRequried55));
        double round55=Math.round(moliRequriedTwoDigits55);
        binding.tvMoliFourth.setText(String.valueOf(round55));

        // 6'X6"
        binding.rbFifth.setText(" 6' X 6'' ");
        double seedsRequiredFor6 = (inputFromEditText * 136.13);
        double seedsRequiredFor6TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor6));
        binding.tvFifth.setText(String.valueOf(seedsRequiredFor6TwoDigits));
        //Moli Calculation
        double moliRequried6=(seedsRequiredFor6TwoDigits/90.0);
        double moliRequriedTwoDigits6 = Double.parseDouble(String.format("%.2f", moliRequried6));
        double round6=Math.round(moliRequriedTwoDigits6);
        binding.tvMoliFifth.setText(String.valueOf(round6));
    }

    private void calculationForGuntaNineInch(String input) {
        // 4'X9"
        binding.rbFirst.setText(" 4' X 9'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 181.5);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));
        //Moli Calculation
        double moliRequried=(seedsRequiredFor4TwoDigits/90.0);
        double moliRequriedTwoDigits = Double.parseDouble(String.format("%.2f", moliRequried));
        double round=Math.round(moliRequriedTwoDigits);
        binding.tvMoliFirst.setText(String.valueOf(round));

        // 4.5'X9"
        binding.rbSecond.setText(" 4.5' X 9'' ");
        double seedsRequiredFor45 = (inputFromEditText * 161.26);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));
        //Moli Calculation
        double moliRequried45=(seedsRequiredFor45TwoDigits/90.0);
        double moliRequriedTwoDigits45 = Double.parseDouble(String.format("%.2f", moliRequried45));
        double round45=Math.round(moliRequriedTwoDigits45);
        binding.tvMoliSecond.setText(String.valueOf(round45));

        // 5'X9"
        binding.rbThird.setText(" 5' X 9'' ");
        double seedsRequiredFor5 = (inputFromEditText * 145.2);
        double seedsRequiredFor5TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor5));
        binding.tvThird.setText(String.valueOf(seedsRequiredFor5TwoDigits));
        //Moli Calculation
        double moliRequried5=(seedsRequiredFor5TwoDigits/90.0);
        double moliRequriedTwoDigits5 = Double.parseDouble(String.format("%.2f", moliRequried5));
        double round5=Math.round(moliRequriedTwoDigits5);
        binding.tvMoliThird.setText(String.valueOf(round5));

        // 5.5'X9"
        binding.rbFourth.setText(" 5.5' X 9'' ");
        double seedsRequiredFor55 = (inputFromEditText * 132);
        double seedsRequiredFor55TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor55));
        binding.tvFourth.setText(String.valueOf(seedsRequiredFor55TwoDigits));
        //Moli Calculation
        double moliRequried55=(seedsRequiredFor55TwoDigits/90.0);
        double moliRequriedTwoDigits55 = Double.parseDouble(String.format("%.2f", moliRequried55));
        double round55=Math.round(moliRequriedTwoDigits55);
        binding.tvMoliFourth.setText(String.valueOf(round55));

        // 6'X9"
        binding.rbFifth.setText(" 6' X 9'' ");
        double seedsRequiredFor6 = (inputFromEditText * 121);
        double seedsRequiredFor6TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor6));
        binding.tvFifth.setText(String.valueOf(seedsRequiredFor6TwoDigits));
        //Moli Calculation
        double moliRequried6=(seedsRequiredFor6TwoDigits/90.0);
        double moliRequriedTwoDigits6 = Double.parseDouble(String.format("%.2f", moliRequried6));
        double round6=Math.round(moliRequriedTwoDigits6);
        binding.tvMoliFifth.setText(String.valueOf(round6));
    }

    private void calculationForAcerSixInch(String input) {
        // 4'X6"
        binding.rbFirst.setText(" 4' X 6'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 8167.6);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));
        //Moli Calculation
        double moliRequried=(seedsRequiredFor4TwoDigits/90.0);
        double moliRequriedTwoDigits = Double.parseDouble(String.format("%.2f", moliRequried));
        double round=Math.round(moliRequriedTwoDigits);
        binding.tvMoliFirst.setText(String.valueOf(round));

        // 4.5'X6"
        binding.rbSecond.setText(" 4.5' X 6'' ");
        double seedsRequiredFor45 = (inputFromEditText * 7256.8);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));
        //Moli Calculation
        double moliRequried45=(seedsRequiredFor45TwoDigits/90.0);
        double moliRequriedTwoDigits45 = Double.parseDouble(String.format("%.2f", moliRequried45));
        double round45=Math.round(moliRequriedTwoDigits45);
        binding.tvMoliSecond.setText(String.valueOf(round45));

        // 5'X6"
        binding.rbThird.setText(" 5' X 6'' ");
        double seedsRequiredFor5 = (inputFromEditText * 6534);
        double seedsRequiredFor5TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor5));
        binding.tvThird.setText(String.valueOf(seedsRequiredFor5TwoDigits));
        //Moli Calculation
        double moliRequried5=(seedsRequiredFor5TwoDigits/90.0);
        double moliRequriedTwoDigits5 = Double.parseDouble(String.format("%.2f", moliRequried5));
        double round5=Math.round(moliRequriedTwoDigits5);
        binding.tvMoliThird.setText(String.valueOf(round5));

        // 5.5'X6"
        binding.rbFourth.setText(" 5.5' X 6'' ");
        double seedsRequiredFor55 = (inputFromEditText * 5940);
        double seedsRequiredFor55TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor55));
        binding.tvFourth.setText(String.valueOf(seedsRequiredFor55TwoDigits));
        //Moli Calculation
        double moliRequried55=(seedsRequiredFor55TwoDigits/90.0);
        double moliRequriedTwoDigits55 = Double.parseDouble(String.format("%.2f", moliRequried55));
        double round55=Math.round(moliRequriedTwoDigits55);
        binding.tvMoliFourth.setText(String.valueOf(round55));

        // 6'X6"
        binding.rbFifth.setText(" 6' X 6'' ");
        double seedsRequiredFor6 = (inputFromEditText * 5445);
        double seedsRequiredFor6TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor6));
        binding.tvFifth.setText(String.valueOf(seedsRequiredFor6TwoDigits));
        //Moli Calculation
        double moliRequried6=(seedsRequiredFor6TwoDigits/90.0);
        double moliRequriedTwoDigits6 = Double.parseDouble(String.format("%.2f", moliRequried6));
        double round6=Math.round(moliRequriedTwoDigits6);
        binding.tvMoliFifth.setText(String.valueOf(round6));
    }

    private void calculationForAcerNineInch(String input) {
        // 4'X9"
        binding.rbFirst.setText(" 4' X 9'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 7260);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));
        //Moli Calculation
        double moliRequried=(seedsRequiredFor4TwoDigits/90.0);
        double moliRequriedTwoDigits = Double.parseDouble(String.format("%.2f", moliRequried));
        double round=Math.round(moliRequriedTwoDigits);
        binding.tvMoliFirst.setText(String.valueOf(round));

        // 4.5'X9"
        binding.rbSecond.setText(" 4.5' X 9'' ");
        double seedsRequiredFor45 = (inputFromEditText * 6450.4);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));
        //Moli Calculation
        double moliRequried45=(seedsRequiredFor45TwoDigits/90.0);
        double moliRequriedTwoDigits45 = Double.parseDouble(String.format("%.2f", moliRequried45));
        double round45=Math.round(moliRequriedTwoDigits45);
        binding.tvMoliSecond.setText(String.valueOf(round45));

        // 5'X9"
        binding.rbThird.setText(" 5' X 9'' ");
        double seedsRequiredFor5 = (inputFromEditText * 5808);
        double seedsRequiredFor5TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor5));
        binding.tvThird.setText(String.valueOf(seedsRequiredFor5TwoDigits));
        //Moli Calculation
        double moliRequried5=(seedsRequiredFor5TwoDigits/90.0);
        double moliRequriedTwoDigits5 = Double.parseDouble(String.format("%.2f", moliRequried5));
        double round5=Math.round(moliRequriedTwoDigits5);
        binding.tvMoliThird.setText(String.valueOf(round5));

        // 5.5'X9"
        binding.rbFourth.setText(" 5.5' X 9'' ");
        double seedsRequiredFor55 = (inputFromEditText * 5280);
        double seedsRequiredFor55TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor55));
        binding.tvFourth.setText(String.valueOf(seedsRequiredFor55TwoDigits));
        //Moli Calculation
        double moliRequried55=(seedsRequiredFor55TwoDigits/90.0);
        double moliRequriedTwoDigits55 = Double.parseDouble(String.format("%.2f", moliRequried55));
        double round55=Math.round(moliRequriedTwoDigits55);
        binding.tvMoliFourth.setText(String.valueOf(round55));

        // 6'X9"
        binding.rbFifth.setText(" 6' X 9'' ");
        double seedsRequiredFor6 = (inputFromEditText * 4840);
        double seedsRequiredFor6TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor6));
        binding.tvFifth.setText(String.valueOf(seedsRequiredFor6TwoDigits));
        //Moli Calculation
        double moliRequried6=(seedsRequiredFor6TwoDigits/90.0);
        double moliRequriedTwoDigits6 = Double.parseDouble(String.format("%.2f", moliRequried6));
        double round6=Math.round(moliRequriedTwoDigits6);
        binding.tvMoliFifth.setText(String.valueOf(round6));

    }

    private void calculationForHectorSixInch(String input) {
        // 4'X6"
        binding.rbFirst.setText(" 4' X 6'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 20419.0);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));
        //Moli Calculation
        double moliRequried=(seedsRequiredFor4TwoDigits/90.0);
        double moliRequriedTwoDigits = Double.parseDouble(String.format("%.2f", moliRequried));
        double round=Math.round(moliRequriedTwoDigits);
        binding.tvMoliFirst.setText(String.valueOf(round));

        // 4.5'X6"
        binding.rbSecond.setText(" 4.5' X 6'' ");
        double seedsRequiredFor45 = (inputFromEditText * 18142.0);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));
        //Moli Calculation
        double moliRequried45=(seedsRequiredFor45TwoDigits/90.0);
        double moliRequriedTwoDigits45 = Double.parseDouble(String.format("%.2f", moliRequried45));
        double round45=Math.round(moliRequriedTwoDigits45);
        binding.tvMoliSecond.setText(String.valueOf(round45));

        // 5'X6"
        binding.rbThird.setText(" 5' X 6'' ");
        double seedsRequiredFor5 = (inputFromEditText * 16335.0);
        double seedsRequiredFor5TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor5));
        binding.tvThird.setText(String.valueOf(seedsRequiredFor5TwoDigits));
        //Moli Calculation
        double moliRequried5=(seedsRequiredFor5TwoDigits/90.0);
        double moliRequriedTwoDigits5 = Double.parseDouble(String.format("%.2f", moliRequried5));
        double round5=Math.round(moliRequriedTwoDigits5);
        binding.tvMoliThird.setText(String.valueOf(round5));

        // 5.5'X6"
        binding.rbFourth.setText(" 5.5' X 6'' ");
        double seedsRequiredFor55 = (inputFromEditText * 14850.0);
        double seedsRequiredFor55TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor55));
        binding.tvFourth.setText(String.valueOf(seedsRequiredFor55TwoDigits));
        //Moli Calculation
        double moliRequried55=(seedsRequiredFor55TwoDigits/90.0);
        double moliRequriedTwoDigits55 = Double.parseDouble(String.format("%.2f", moliRequried55));
        double round55=Math.round(moliRequriedTwoDigits55);
        binding.tvMoliFourth.setText(String.valueOf(round55));

        // 6'X6"
        binding.rbFifth.setText(" 6' X 6'' ");
        double seedsRequiredFor6 = (inputFromEditText * 13612.5);
        double seedsRequiredFor6TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor6));
        binding.tvFifth.setText(String.valueOf(seedsRequiredFor6TwoDigits));
        //Moli Calculation
        double moliRequried6=(seedsRequiredFor6TwoDigits/90.0);
        double moliRequriedTwoDigits6 = Double.parseDouble(String.format("%.2f", moliRequried6));
        double round6=Math.round(moliRequriedTwoDigits6);
        binding.tvMoliFifth.setText(String.valueOf(round6));

    }

    private void calculationForHectorNineInch(String input) {
        // 4'X9"
        binding.rbFirst.setText(" 4' X 9'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 18150.0);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));
        //Moli Calculation
        double moliRequried=(seedsRequiredFor4TwoDigits/90.0);
        double moliRequriedTwoDigits = Double.parseDouble(String.format("%.2f", moliRequried));
        double round=Math.round(moliRequriedTwoDigits);
        binding.tvMoliFirst.setText(String.valueOf(round));

        // 4.5'X9"
        binding.rbSecond.setText(" 4.5' X 9'' ");
        double seedsRequiredFor45 = (inputFromEditText * 16126.0);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));
        //Moli Calculation
        double moliRequried45=(seedsRequiredFor45TwoDigits/90.0);
        double moliRequriedTwoDigits45 = Double.parseDouble(String.format("%.2f", moliRequried45));
        double round45=Math.round(moliRequriedTwoDigits45);
        binding.tvMoliSecond.setText(String.valueOf(round45));

        // 5'X9"
        binding.rbThird.setText(" 5' X 9'' ");
        double seedsRequiredFor5 = (inputFromEditText * 14520.0);
        double seedsRequiredFor5TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor5));
        binding.tvThird.setText(String.valueOf(seedsRequiredFor5TwoDigits));
        //Moli Calculation
        double moliRequried5=(seedsRequiredFor5TwoDigits/90.0);
        double moliRequriedTwoDigits5 = Double.parseDouble(String.format("%.2f", moliRequried5));
        double round5=Math.round(moliRequriedTwoDigits5);
        binding.tvMoliThird.setText(String.valueOf(round5));

        // 5.5'X9"
        binding.rbFourth.setText(" 5.5' X 9'' ");
        double seedsRequiredFor55 = (inputFromEditText * 13200.0);
        double seedsRequiredFor55TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor55));
        binding.tvFourth.setText(String.valueOf(seedsRequiredFor55TwoDigits));
        //Moli Calculation
        double moliRequried55=(seedsRequiredFor55TwoDigits/90.0);
        double moliRequriedTwoDigits55 = Double.parseDouble(String.format("%.2f", moliRequried55));
        double round55=Math.round(moliRequriedTwoDigits55);
        binding.tvMoliFourth.setText(String.valueOf(round55));

        // 6'X9"
        binding.rbFifth.setText(" 6' X 9'' ");
        double seedsRequiredFor6 = (inputFromEditText * 12100.0);
        double seedsRequiredFor6TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor6));
        binding.tvFifth.setText(String.valueOf(seedsRequiredFor6TwoDigits));
        //Moli Calculation
        double moliRequried6=(seedsRequiredFor6TwoDigits/90.0);
        double moliRequriedTwoDigits6 = Double.parseDouble(String.format("%.2f", moliRequried6));
        double round6=Math.round(moliRequriedTwoDigits6);
        binding.tvMoliFifth.setText(String.valueOf(round6));

    }

    private void increaseValue() {

        String currentValueStr = binding.etLand.getText().toString();
        float currentValue = Float.parseFloat(currentValueStr);
        currentValue += 0.5;
        binding.etLand.setText(decimalFormat.format(currentValue));
        if (binding.rbGunta.isChecked() && binding.rbSixInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 6'' ");
            binding.rbSecond.setText(" 4.5' X 6'' ");
            binding.rbThird.setText(" 5' X 6'' ");
            binding.rbFourth.setText(" 5.5' X 6'' ");
            binding.rbFifth.setText(" 6' X 6'' ");
            calculationForGuntaSixInch(valueofEditText);
        } else if (binding.rbGunta.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 9'' ");
            binding.rbSecond.setText(" 4.5' X 9'' ");
            binding.rbThird.setText(" 5' X 9'' ");
            binding.rbFourth.setText(" 5.5' X 9'' ");
            binding.rbFifth.setText(" 6' X 9'' ");
            calculationForGuntaNineInch(valueofEditText);
        } else if (binding.rbEkar.isChecked() && binding.rbSixInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 6'' ");
            binding.rbSecond.setText(" 4.5' X 6'' ");
            binding.rbThird.setText(" 5' X 6'' ");
            binding.rbFourth.setText(" 5.5' X 6'' ");
            binding.rbFifth.setText(" 6' X 6'' ");
            calculationForAcerSixInch(valueofEditText);
        } else if (binding.rbEkar.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 9'' ");
            binding.rbSecond.setText(" 4.5' X 9'' ");
            binding.rbThird.setText(" 5' X 9'' ");
            binding.rbFourth.setText(" 5.5' X 9'' ");
            binding.rbFifth.setText(" 6' X 9'' ");
            calculationForAcerNineInch(valueofEditText);
        } else if (binding.rbHector.isChecked() && binding.rbSixInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 6'' ");
            binding.rbSecond.setText(" 4.5' X 6'' ");
            binding.rbThird.setText(" 5' X 6'' ");
            binding.rbFourth.setText(" 5.5' X 6'' ");
            binding.rbFifth.setText(" 6' X 6'' ");
            calculationForHectorSixInch(valueofEditText);
        } else if (binding.rbHector.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 9'' ");
            binding.rbSecond.setText(" 4.5' X 9'' ");
            binding.rbThird.setText(" 5' X 9'' ");
            binding.rbFourth.setText(" 5.5' X 9'' ");
            binding.rbFifth.setText(" 6' X 9'' ");
            calculationForHectorNineInch(valueofEditText);
        } else {
            Toast.makeText(this, "अंतर निवडा", Toast.LENGTH_SHORT).show();
        }
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
        if (binding.rbGunta.isChecked() && binding.rbSixInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 6'' ");
            binding.rbSecond.setText(" 4.5' X 6'' ");
            binding.rbThird.setText(" 5' X 6'' ");
            binding.rbFourth.setText(" 5.5' X 6'' ");
            binding.rbFifth.setText(" 6' X 6'' ");
            calculationForGuntaSixInch(valueofEditText);
        } else if (binding.rbGunta.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 9'' ");
            binding.rbSecond.setText(" 4.5' X 9'' ");
            binding.rbThird.setText(" 5' X 9'' ");
            binding.rbFourth.setText(" 5.5' X 9'' ");
            binding.rbFifth.setText(" 6' X 9'' ");
            calculationForGuntaNineInch(valueofEditText);
        } else if (binding.rbEkar.isChecked() && binding.rbSixInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 6'' ");
            binding.rbSecond.setText(" 4.5' X 6'' ");
            binding.rbThird.setText(" 5' X 6'' ");
            binding.rbFourth.setText(" 5.5' X 6'' ");
            binding.rbFifth.setText(" 6' X 6'' ");
            calculationForAcerSixInch(valueofEditText);
        } else if (binding.rbEkar.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 9'' ");
            binding.rbSecond.setText(" 4.5' X 9'' ");
            binding.rbThird.setText(" 5' X 9'' ");
            binding.rbFourth.setText(" 5.5' X 9'' ");
            binding.rbFifth.setText(" 6' X 9'' ");
            calculationForAcerNineInch(valueofEditText);
        } else if (binding.rbHector.isChecked() && binding.rbSixInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 6'' ");
            binding.rbSecond.setText(" 4.5' X 6'' ");
            binding.rbThird.setText(" 5' X 6'' ");
            binding.rbFourth.setText(" 5.5' X 6'' ");
            binding.rbFifth.setText(" 6' X 6'' ");
            calculationForHectorSixInch(valueofEditText);
        } else if (binding.rbHector.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 4' X 9'' ");
            binding.rbSecond.setText(" 4.5' X 9'' ");
            binding.rbThird.setText(" 5' X 9'' ");
            binding.rbFourth.setText(" 5.5' X 9'' ");
            binding.rbFifth.setText(" 6' X 9'' ");
            calculationForHectorNineInch(valueofEditText);
        } else {
            Toast.makeText(this, "अंतर निवडा", Toast.LENGTH_SHORT).show();
        }
    }
}