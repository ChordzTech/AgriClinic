package com.example.agroclinic.userInputTables;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivityUsecondTableBinding;

import java.text.DecimalFormat;

public class USecondTableActivity extends AppCompatActivity {
    ActivityUsecondTableBinding binding;
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_usecond_table);
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
                        Toast.makeText(USecondTableActivity.this, "एकर", Toast.LENGTH_SHORT).show();
                        valueForConditionOfAcer();
                    } else if (binding.rbHector.isChecked()) {
                        valueForConditionCheck();
                        Toast.makeText(USecondTableActivity.this, "हेक्टर", Toast.LENGTH_SHORT).show();
                    } else if (binding.rbGunta.isChecked()) {
                        Toast.makeText(USecondTableActivity.this, "गुंठा", Toast.LENGTH_SHORT).show();
                        valueForConditionOfGunta();
                    } else {
                        Toast.makeText(USecondTableActivity.this, "कृपया एकक निवडा", Toast.LENGTH_SHORT).show();
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
                if (binding.rbHector.isChecked()){
                    valueForCalculation(valueOfLand);
                } else if (binding.rbEkar.isChecked()) {
                    valueForCalculationAcer(valueOfLand);
                }else {
                    valueForCalculationGunta(valueOfLand);
                }

            }
        });

        binding.btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increase value by 0.5
                increaseValue();
                if (binding.rbHector.isChecked()){
                    valueForCalculation(valueOfLand);
                } else if (binding.rbEkar.isChecked()) {
                    valueForCalculationAcer(valueOfLand);
                }else {
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
        } else if (inputFromEditTextN >= 224.0 && inputFromEditTextN <= 280.0) {
            increasedValueN = String.valueOf(120.0);
        } else if (inputFromEditTextN > 280.0) {
            increasedValueN = String.valueOf(80.0);
        } else {
            Toast.makeText(this, "Formulas Not Found", Toast.LENGTH_SHORT).show();
        }

        if (inputFromEditTextP < 2.8) {
            increasedValueP = String.valueOf(102.0);
        } else if (inputFromEditTextP >= 3.0 && inputFromEditTextP <= 5.6) {
            increasedValueP = String.valueOf(85.0);
        } else if ((inputFromEditTextP >= 6.0 && inputFromEditTextP <= 11.2)) {
            increasedValueP = String.valueOf(68.0);
        } else if ((inputFromEditTextP >= 12.0 && inputFromEditTextP <= 14.0)) {
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
        //Calculation of Urea For One Gunta
        float inputFromEditText = Float.parseFloat(input);
        double valueofN = Double.parseDouble(increasedValueN);
        double valueofNTwoDigits = Double.parseDouble(String.format("%.2f", valueofN));
        double ureaForOneAcer = ((valueofNTwoDigits * 100) / 46.0);
        double output = inputFromEditText * ureaForOneAcer;
        double roundValue = Double.parseDouble(String.format("%.2f", output));
        double bagValue = roundValue / 10;
        double roundbag = Double.parseDouble(String.format("%.2f", bagValue));
        double bagUrea = roundValue * .40;
        double totalUrea = Double.parseDouble(String.format("%.2f", bagUrea));

        double ureaBag = roundbag / 45;
        double ureaBagRequired = Double.parseDouble(String.format("%.2f", ureaBag));
        double ureaBag2 = totalUrea / 45;
        double ureaBagRequired2 = Double.parseDouble(String.format("%.2f", ureaBag2));


        binding.tvUrea.setText(String.valueOf(roundValue + " किलो"));
        binding.tvUreaInKg.setText(String.valueOf(roundbag + " किलो"));
        binding.tvUreaInBags.setText(String.valueOf(ureaBagRequired + " गोणी "));
        binding.ureaInKg.setText(String.valueOf(totalUrea + " किलो"));
        binding.Urea.setText(String.valueOf(ureaBagRequired2 + " गोणी "));
        binding.tvUrea3.setText(String.valueOf(roundbag + " किलो"));
        binding.UreaBag3.setText(String.valueOf(ureaBagRequired + " गोणी "));
        binding.tvUrea4.setText(String.valueOf(totalUrea + " किलो"));
        binding.UreaBag4.setText(String.valueOf(ureaBagRequired2 + " गोणी "));

        //Calculation of SSF for One Acer
        double valueofP = Double.parseDouble(increasedValueP);
        double valueofPTwoDigits = Double.parseDouble(String.format("%.2f", valueofP));
        double ssfForOneAcer = ((valueofPTwoDigits * 100.0) / 16.0);
        double outputofssf = inputFromEditText * ssfForOneAcer;
        double roundValueofssf = Double.parseDouble(String.format("%.2f", outputofssf));
        double bagValueofssf = roundValueofssf / 10;
        double roundSsfbag = Double.parseDouble(String.format("%.2f", bagValueofssf));
        double bagValueofssf1 = roundValueofssf * .50;
        double roundSsfbag1 = Double.parseDouble(String.format("%.2f", bagValueofssf1));
        double bagssf = roundValueofssf * .40;
        double totalSsf = Double.parseDouble(String.format("%.2f", bagssf));


        double ssfBag3 = roundSsfbag1 / 50;
        double ssfBagRequired3 = Double.parseDouble(String.format("%.2f", ssfBag3));
        double ssfBag5 = totalSsf / 50;
        double ssfBagRequired5 = Double.parseDouble(String.format("%.2f", ssfBag5));

        binding.tvSsf.setText(String.valueOf(roundValueofssf + " किलो"));
        binding.tvSSPInKg.setText(String.valueOf(roundSsfbag1 + " किलो"));
        binding.tvSSPInBag.setText(String.valueOf(ssfBagRequired5 + " गोणी "));
//        binding.SSPInKg.setText(String.valueOf(totalSsf));
//        binding.SSF.setText(String.valueOf(ssfBagRequired5));
//        binding.tvSSF3.setText(String.valueOf(roundValueofssf));
//        binding.SSFBag3.setText(String.valueOf(ssfBagRequired3));
        binding.tvSSF4.setText(String.valueOf(roundSsfbag1 + " किलो"));
        binding.SSFBag4.setText(String.valueOf(ssfBagRequired5 + " गोणी "));

        //Calculation of MoP for One acer
        double valueofK = Double.parseDouble(increasedValueK);
        double valueofKTwoDigits = Double.parseDouble(String.format("%.2f", valueofK));
        double mopForOneAcer = ((valueofKTwoDigits * 100.0) / 60.0);
        double outputofmop = inputFromEditText * mopForOneAcer;
        double roundValueofmop = Double.parseDouble(String.format("%.2f", outputofmop));
        double bagValueofmop = roundValueofmop / 10;
        double roundMopbag = Double.parseDouble(String.format("%.2f", bagValueofmop));
        double bagValueofmop1 = roundValueofmop * .50;
        double roundMopbag1 = Double.parseDouble(String.format("%.2f", bagValueofmop1));
        double bagmop = roundValueofmop * .40;
        double totalMop = Double.parseDouble(String.format("%.2f", bagmop));


        double mopBag2 = roundMopbag1 / 50;
        double mopBagRequired2 = Double.parseDouble(String.format("%.2f", mopBag2));
        double mopBag4 = totalMop / 50;
        double mopBagRequired4 = Double.parseDouble(String.format("%.2f", mopBag4));

        binding.tvMop.setText(String.valueOf(roundValueofmop + " किलो"));
        binding.tvMopInKg.setText(String.valueOf(roundMopbag1 + " किलो"));
        binding.MopInBag.setText(String.valueOf(mopBagRequired4 + " गोणी "));
//        binding.MopInKg.setText(String.valueOf(totalMop));
//        binding.MOP.setText(String.valueOf(mopBagRequired4));
//        binding.tvMOP3.setText(String.valueOf(roundValueofmop));
//        binding.MOPBag3.setText(String.valueOf(mopBagRequired2));
        binding.tvMOP4.setText(String.valueOf(roundMopbag1 + " किलो"));
        binding.MOPBag4.setText(String.valueOf(mopBagRequired4 + " गोणी "));
    }
    private void valueForCalculationAcer(String input) {
        //Calculation of Urea For One Acer
        float inputFromEditText = Float.parseFloat(input);
        double valueofN = Double.parseDouble(increasedValueN);
        double valueofNTwoDigits = Double.parseDouble(String.format("%.2f", valueofN));
        double ureaForOneAcer = ((valueofNTwoDigits * 100) / 46.0);
        double output = inputFromEditText * ureaForOneAcer;
        double roundValue = Double.parseDouble(String.format("%.2f", output));
        double bagValue=roundValue/10;
        double roundbag= Double.parseDouble(String.format("%.2f",bagValue));
        double bagUrea=roundValue *.40;
        double totalUrea= Double.parseDouble(String.format("%.2f",bagUrea));

        double ureaBag = roundbag/45;
        double ureaBagRequired=Double.parseDouble(String.format("%.2f",ureaBag));
        double ureaBag2 = totalUrea/45;
        double ureaBagRequired2=Double.parseDouble(String.format("%.2f",ureaBag2));


        binding.tvUrea.setText(String.valueOf(roundValue+" किलो"));
        binding.tvUreaInKg.setText(String.valueOf(roundbag+" किलो"));
        binding.tvUreaInBags.setText(String.valueOf(ureaBagRequired +" गोणी "));
        binding.ureaInKg.setText(String.valueOf(totalUrea+" किलो"));
        binding.Urea.setText(String.valueOf(ureaBagRequired2+" गोणी "));
        binding.tvUrea3.setText(String.valueOf(roundbag+" किलो"));
        binding.UreaBag3.setText(String.valueOf(ureaBagRequired+" गोणी "));
        binding.tvUrea4.setText(String.valueOf(totalUrea+" किलो"));
        binding.UreaBag4.setText(String.valueOf(ureaBagRequired2+" गोणी "));

        //Calculation of SSF for One Acer
        double valueofP = Double.parseDouble(increasedValueP);
        double valueofPTwoDigits = Double.parseDouble(String.format("%.2f", valueofP));
        double ssfForOneAcer = ((valueofPTwoDigits * 100.0) / 16.0);
        double outputofssf = inputFromEditText * ssfForOneAcer;
        double roundValueofssf = Double.parseDouble(String.format("%.2f", outputofssf));
        double bagValueofssf=roundValueofssf/10;
        double roundSsfbag= Double.parseDouble(String.format("%.2f",bagValueofssf));
        double bagValueofssf1=roundValueofssf *.50;
        double roundSsfbag1= Double.parseDouble(String.format("%.2f",bagValueofssf1));
        double bagssf=roundValueofssf *.40;
        double totalSsf= Double.parseDouble(String.format("%.2f",bagssf));


        double ssfBag3 = roundSsfbag1/50;
        double ssfBagRequired3=Double.parseDouble(String.format("%.2f",ssfBag3));
        double ssfBag5 = totalSsf/50;
        double ssfBagRequired5=Double.parseDouble(String.format("%.2f",ssfBag5));

        binding.tvSsf.setText(String.valueOf(roundValueofssf+" किलो"));
        binding.tvSSPInKg.setText(String.valueOf(roundSsfbag1 + " किलो"));
        binding.tvSSPInBag.setText(String.valueOf(ssfBagRequired5+" गोणी "));
//        binding.SSPInKg.setText(String.valueOf(totalSsf));
//        binding.SSF.setText(String.valueOf(ssfBagRequired5));
//        binding.tvSSF3.setText(String.valueOf(roundValueofssf));
//        binding.SSFBag3.setText(String.valueOf(ssfBagRequired3));
        binding.tvSSF4.setText(String.valueOf(roundSsfbag1+" किलो"));
        binding.SSFBag4.setText(String.valueOf(ssfBagRequired5+" गोणी "));

        //Calculation of MoP for One acer
        double valueofK = Double.parseDouble(increasedValueK);
        double valueofKTwoDigits = Double.parseDouble(String.format("%.2f", valueofK));
        double mopForOneAcer = ((valueofKTwoDigits * 100.0) / 60.0);
        double outputofmop = inputFromEditText * mopForOneAcer;
        double roundValueofmop = Double.parseDouble(String.format("%.2f", outputofmop));
        double bagValueofmop=roundValueofmop/10;
        double roundMopbag= Double.parseDouble(String.format("%.2f",bagValueofmop));
        double bagValueofmop1=roundValueofmop *.50;
        double roundMopbag1= Double.parseDouble(String.format("%.2f",bagValueofmop1));
        double bagmop=roundValueofmop *.40;
        double totalMop= Double.parseDouble(String.format("%.2f",bagmop));


        double mopBag2 = roundMopbag1/50;
        double mopBagRequired2=Double.parseDouble(String.format("%.2f",mopBag2));
        double mopBag4 = totalMop/50;
        double mopBagRequired4=Double.parseDouble(String.format("%.2f",mopBag4));

        binding.tvMop.setText(String.valueOf(roundValueofmop+" किलो"));
        binding.tvMopInKg.setText(String.valueOf(roundMopbag1 + " किलो"));
        binding.MopInBag.setText(String.valueOf(mopBagRequired4+" गोणी "));
//        binding.MopInKg.setText(String.valueOf(totalMop));
//        binding.MOP.setText(String.valueOf(mopBagRequired4));
//        binding.tvMOP3.setText(String.valueOf(roundValueofmop));
//        binding.MOPBag3.setText(String.valueOf(mopBagRequired2));
        binding.tvMOP4.setText(String.valueOf(roundMopbag1+" किलो"));
        binding.MOPBag4.setText(String.valueOf(mopBagRequired4+" गोणी "));
    }


    public void valueForCalculation(String input) {
        //Calculation of Urea For One Acer
        float inputFromEditText = Float.parseFloat(input);
        double valueofN = Double.parseDouble(increasedValueN);
        double valueofNTwoDigits = Double.parseDouble(String.format("%.2f", valueofN));
        double ureaForOneAcer = ((valueofNTwoDigits * 100) / 46.0);
        double output = inputFromEditText * ureaForOneAcer;
        double roundValue = Double.parseDouble(String.format("%.2f", output));
        double bagValue = roundValue / 10;
        double roundbag = Double.parseDouble(String.format("%.2f", bagValue));
        double bagUrea = roundValue * .40;
        double totalUrea = Double.parseDouble(String.format("%.2f", bagUrea));

        double ureaBag = roundbag / 45;
        double ureaBagRequired = Double.parseDouble(String.format("%.2f", ureaBag));
        double ureaBag2 = totalUrea / 45;
        double ureaBagRequired2 = Double.parseDouble(String.format("%.2f", ureaBag2));


        binding.tvUrea.setText(String.valueOf(roundValue + " किलो"));
        binding.tvUreaInKg.setText(String.valueOf(roundbag + " किलो"));
        binding.tvUreaInBags.setText(String.valueOf(ureaBagRequired + " गोणी "));
        binding.ureaInKg.setText(String.valueOf(totalUrea + " किलो"));
        binding.Urea.setText(String.valueOf(ureaBagRequired2 + " गोणी "));
        binding.tvUrea3.setText(String.valueOf(roundbag + " किलो"));
        binding.UreaBag3.setText(String.valueOf(ureaBagRequired + " गोणी "));
        binding.tvUrea4.setText(String.valueOf(totalUrea + " किलो"));
        binding.UreaBag4.setText(String.valueOf(ureaBagRequired2 + " गोणी "));

        //Calculation of SSF for One Acer
        double valueofP = Double.parseDouble(increasedValueP);
        double valueofPTwoDigits = Double.parseDouble(String.format("%.2f", valueofP));
        double ssfForOneAcer = ((valueofPTwoDigits * 100.0) / 16.0);
        double outputofssf = inputFromEditText * ssfForOneAcer;
        double roundValueofssf = Double.parseDouble(String.format("%.2f", outputofssf));
        double bagValueofssf = roundValueofssf / 10;
        double roundSsfbag = Double.parseDouble(String.format("%.2f", bagValueofssf));
        double bagValueofssf1 = roundValueofssf * .50;
        double roundSsfbag1 = Double.parseDouble(String.format("%.2f", bagValueofssf1));
        double bagssf = roundValueofssf * .40;
        double totalSsf = Double.parseDouble(String.format("%.2f", bagssf));


        double ssfBag3 = roundSsfbag1 / 50;
        double ssfBagRequired3 = Double.parseDouble(String.format("%.2f", ssfBag3));
        double ssfBag5 = totalSsf / 50;
        double ssfBagRequired5 = Double.parseDouble(String.format("%.2f", ssfBag5));

        binding.tvSsf.setText(String.valueOf(roundValueofssf + " किलो"));
        binding.tvSSPInKg.setText(String.valueOf(roundSsfbag1 + " किलो"));
        binding.tvSSPInBag.setText(String.valueOf(ssfBagRequired5 + " गोणी "));
//        binding.SSPInKg.setText(String.valueOf(totalSsf));
//        binding.SSF.setText(String.valueOf(ssfBagRequired5));
//        binding.tvSSF3.setText(String.valueOf(roundValueofssf));
//        binding.SSFBag3.setText(String.valueOf(ssfBagRequired3));
        binding.tvSSF4.setText(String.valueOf(roundSsfbag1 + " किलो"));
        binding.SSFBag4.setText(String.valueOf(ssfBagRequired5 + " गोणी "));

        //Calculation of MoP for One acer
        double valueofK = Double.parseDouble(increasedValueK);
        double valueofKTwoDigits = Double.parseDouble(String.format("%.2f", valueofK));
        double mopForOneAcer = ((valueofKTwoDigits * 100.0) / 60.0);
        double outputofmop = inputFromEditText * mopForOneAcer;
        double roundValueofmop = Double.parseDouble(String.format("%.2f", outputofmop));
        double bagValueofmop = roundValueofmop / 10;
        double roundMopbag = Double.parseDouble(String.format("%.2f", bagValueofmop));
        double bagValueofmop1 = roundValueofmop * .50;
        double roundMopbag1 = Double.parseDouble(String.format("%.2f", bagValueofmop1));
        double bagmop = roundValueofmop * .40;
        double totalMop = Double.parseDouble(String.format("%.2f", bagmop));


        double mopBag2 = roundMopbag1 / 50;
        double mopBagRequired2 = Double.parseDouble(String.format("%.2f", mopBag2));
        double mopBag4 = totalMop / 50;
        double mopBagRequired4 = Double.parseDouble(String.format("%.2f", mopBag4));

        binding.tvMop.setText(String.valueOf(roundValueofmop + " किलो"));
        binding.tvMopInKg.setText(String.valueOf(roundMopbag1 + " किलो"));
        binding.MopInBag.setText(String.valueOf(mopBagRequired4 + " गोणी "));
//        binding.MopInKg.setText(String.valueOf(totalMop));
//        binding.MOP.setText(String.valueOf(mopBagRequired4));
//        binding.tvMOP3.setText(String.valueOf(roundValueofmop));
//        binding.MOPBag3.setText(String.valueOf(mopBagRequired2));
        binding.tvMOP4.setText(String.valueOf(roundMopbag1 + " किलो"));
        binding.MOPBag4.setText(String.valueOf(mopBagRequired4 + " गोणी "));
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