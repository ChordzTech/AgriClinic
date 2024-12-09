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
import com.example.agroclinic.databinding.ActivityThirdTableBinding;

import java.text.DecimalFormat;

public class ThirdTableActivity extends AppCompatActivity {
    ActivityThirdTableBinding binding;
    private DecimalFormat decimalFormat;
    private String valueofEditText = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_third_table);
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
                    binding.tvN.setText("नत्र     - (N) :  10 किलो");
                    binding.tvP.setText("स्फुरद - (P): 20 किलो");
                    binding.tvK.setText("पालाश - (K): 20 किलो");
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
                        Toast.makeText(ThirdTableActivity.this, "कृपया एकक निवडा", Toast.LENGTH_SHORT).show();
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

    private void valueForCalculationOfGunta(String toString) {
        //Calculation of Urea For One Gunta
        double inputFromEditText = Float.parseFloat(toString);
        double ureaForOneAcer = ((1 * 348) / 40.0);
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
        binding.tvUreaInKg.setText(String.valueOf(roundbag + " किलो"));
        binding.tvUreaInBags.setText(String.valueOf(ureaBagRequired+" गोणी "));
        binding.ureaInKg.setText(String.valueOf(totalUrea+" किलो"));
        binding.Urea.setText(String.valueOf(ureaBagRequired2+" गोणी "));
        binding.tvUrea3.setText(String.valueOf(roundbag+" किलो"));
        binding.UreaBag3.setText(String.valueOf(ureaBagRequired+" गोणी "));
        binding.tvUrea4.setText(String.valueOf(totalUrea+" किलो"));
        binding.UreaBag4.setText(String.valueOf(ureaBagRequired2+" गोणी "));

        //Calculation of SSF for One Gunta
        double ssfForOneAcer = ((1 * 425) / 40.0);
        double outputofssf = inputFromEditText * ssfForOneAcer;
        double roundValueofssf = Double.parseDouble(String.format("%.2f", outputofssf));
        double bagValueofssf=roundValueofssf/10;
        double roundSsfbag= Double.parseDouble(String.format("%.2f",bagValueofssf));
        double bagValueofssf1=roundValueofssf *.50;
        double roundSsfbag1= Double.parseDouble(String.format("%.2f",bagValueofssf1));
        double bagssf=roundValueofssf *.40;
        double totalSsf= Double.parseDouble(String.format("%.2f",roundSsfbag1));

        double ssfBag3 = roundSsfbag/50;
        double ssfBagRequired3=Double.parseDouble(String.format("%.2f",ssfBag3));
        double ssfBag5 = totalSsf/50;
        double ssfBagRequired5=Double.parseDouble(String.format("%.2f",ssfBag5));

        binding.tvSsf.setText(String.valueOf(roundValueofssf+" किलो"));
        binding.tvSSPInKg.setText(String.valueOf(roundSsfbag1 + " किलो"));
        binding.tvSSPInBag.setText(String.valueOf(ssfBagRequired5+" गोणी "));
//        binding.SSPInKg.setText(String.valueOf(roundValueofssf));
//        binding.SSF.setText(String.valueOf(ssfBagRequired5));
//        binding.tvSSF3.setText(String.valueOf(roundValueofssf));
//        binding.SSFBag3.setText(String.valueOf(ssfBagRequired3));
        binding.tvSSF4.setText(String.valueOf(roundSsfbag1+" किलो"));
        binding.SSFBag4.setText(String.valueOf(ssfBagRequired5+" गोणी "));

        //Calculation of MoP for One Gunta
        double mopForOneAcer = ((1 * 113) / 40.0);
        double outputofmop = inputFromEditText * mopForOneAcer;
        double roundValueofmop = Double.parseDouble(String.format("%.2f", outputofmop));
        double bagValueofmop=roundValueofmop/10;
        double roundmopbag= Double.parseDouble(String.format("%.2f",bagValueofmop));
        double bagValueofmop1=roundValueofmop *.50;
        double roundMopbag1= Double.parseDouble(String.format("%.2f",bagValueofmop1));
        double bagmop=roundValueofmop *.40;
        double totalMop= Double.parseDouble(String.format("%.2f",roundMopbag1));

        double mopBag2 = roundmopbag/50;
        double mopBagRequired2=Double.parseDouble(String.format("%.2f",mopBag2));
        double mopBag4 = totalMop/50;
        double mopBagRequired4=Double.parseDouble(String.format("%.2f",mopBag4));

        binding.tvMop.setText(String.valueOf(roundValueofmop+" किलो"));
        binding.tvMopInKg.setText(String.valueOf(roundMopbag1 + " किलो"));
        binding.MopInBag.setText(String.valueOf(mopBagRequired4+" गोणी "));
//        binding.MopInKg.setText(String.valueOf(roundValueofmop));
//        binding.MOP.setText(String.valueOf(mopBagRequired4));
//        binding.tvMOP3.setText(String.valueOf(roundValueofmop));
//        binding.MOPBag3.setText(String.valueOf(mopBagRequired2));
        binding.tvMOP4.setText(String.valueOf(roundMopbag1+" किलो"));
        binding.MOPBag4.setText(String.valueOf(mopBagRequired4+" गोणी "));
    }

    private void valueForCalculationOfHector(String toString) {
        //Calculation of Urea For One Hector
        float inputFromEditText = Float.parseFloat(toString);
        double ureaForOneHector = ((400 * 100) / 46.0);
        double output = inputFromEditText * ureaForOneHector;
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
        binding.tvUreaInKg.setText(String.valueOf(roundbag + " किलो"));
        binding.tvUreaInBags.setText(String.valueOf(ureaBagRequired+" गोणी "));
        binding.ureaInKg.setText(String.valueOf(totalUrea+" किलो"));
        binding.Urea.setText(String.valueOf(ureaBagRequired2+" गोणी "));
        binding.tvUrea3.setText(String.valueOf(roundbag+" किलो"));
        binding.UreaBag3.setText(String.valueOf(ureaBagRequired+" गोणी "));
        binding.tvUrea4.setText(String.valueOf(totalUrea+" किलो"));
        binding.UreaBag4.setText(String.valueOf(ureaBagRequired2+" गोणी "));

        //Calculation of SSF for One Acer
        double ssfForOneAcer = ((170 * 100) / 16.0);
        double outputofssf = inputFromEditText * ssfForOneAcer;
        double roundValueofssf = Double.parseDouble(String.format("%.2f", outputofssf));
        double bagValueofssf=roundValueofssf/10;
        double roundSsfbag= Double.parseDouble(String.format("%.2f",bagValueofssf));
        double bagValueofssf1=roundValueofssf *.50;
        double roundSsfbag1= Double.parseDouble(String.format("%.2f",bagValueofssf1));
        double bagssf=roundValueofssf *.40;
        double totalSsf= Double.parseDouble(String.format("%.2f",roundSsfbag1));

        double ssfBag3 = roundSsfbag/50;
        double ssfBagRequired3=Double.parseDouble(String.format("%.2f",ssfBag3));
        double ssfBag5 = totalSsf/50;
        double ssfBagRequired5=Double.parseDouble(String.format("%.2f",ssfBag5));

        binding.tvSsf.setText(String.valueOf(roundValueofssf+" किलो"));
        binding.tvSSPInKg.setText(String.valueOf(roundSsfbag1 + " किलो"));
        binding.tvSSPInBag.setText(String.valueOf(ssfBagRequired5+" गोणी "));
//        binding.SSPInKg.setText(String.valueOf(roundValueofssf));
//        binding.SSF.setText(String.valueOf(ssfBagRequired5));
//        binding.tvSSF3.setText(String.valueOf(roundValueofssf));
//        binding.SSFBag3.setText(String.valueOf(ssfBagRequired3));
        binding.tvSSF4.setText(String.valueOf(roundSsfbag1+" किलो"));
        binding.SSFBag4.setText(String.valueOf(ssfBagRequired5+" गोणी "));

        //Calculation of MoP for One acer
        double mopForOneAcer = ((170 * 100) / 60.0);
        double outputofmop = inputFromEditText * mopForOneAcer;
        double roundValueofmop = Double.parseDouble(String.format("%.2f", outputofmop));
        double bagValueofmop=roundValueofmop/10;
        double roundmopbag= Double.parseDouble(String.format("%.2f",bagValueofmop));
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
        binding.MopInBag.setText(String.valueOf(mopBagRequired2+" गोणी "));
//        binding.MopInKg.setText(String.valueOf(roundValueofmop));
//        binding.MOP.setText(String.valueOf(mopBagRequired4));
//        binding.tvMOP3.setText(String.valueOf(roundValueofmop));
//        binding.MOPBag3.setText(String.valueOf(mopBagRequired2));
        binding.tvMOP4.setText(String.valueOf(roundMopbag1+" किलो"));
        binding.MOPBag4.setText(String.valueOf(mopBagRequired2+" गोणी "));

    }

    private void valueForCalculation(String input) {
        //Calculation of Urea For One Acer
        float inputFromEditText = Float.parseFloat(input);
        double ureaForOneAcer = ((160 * 100) / 46.0);
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
        double ssfForOneAcer = ((68 * 100) / 16.0);
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
        binding.tvSSPInBag.setText(String.valueOf(ssfBagRequired3+" गोणी "));
//        binding.SSPInKg.setText(String.valueOf(totalSsf));
//        binding.SSF.setText(String.valueOf(ssfBagRequired5));
//        binding.tvSSF3.setText(String.valueOf(roundValueofssf));
//        binding.SSFBag3.setText(String.valueOf(ssfBagRequired3));
        binding.tvSSF4.setText(String.valueOf(roundSsfbag1+" किलो"));
        binding.SSFBag4.setText(String.valueOf(ssfBagRequired3+" गोणी "));

        //Calculation of MoP for One acer
        double mopForOneAcer = ((68 * 100) / 60.0);
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
        binding.MopInBag.setText(String.valueOf(mopBagRequired2+" गोणी "));
//        binding.MopInKg.setText(String.valueOf(totalMop));
//        binding.MOP.setText(String.valueOf(mopBagRequired4));
//        binding.tvMOP3.setText(String.valueOf(roundValueofmop));
//        binding.MOPBag3.setText(String.valueOf(mopBagRequired2));
        binding.tvMOP4.setText(String.valueOf(roundMopbag1+" किलो"));
        binding.MOPBag4.setText(String.valueOf(mopBagRequired2+" गोणी "));
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