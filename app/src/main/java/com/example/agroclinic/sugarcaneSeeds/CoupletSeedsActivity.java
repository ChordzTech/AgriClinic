package com.example.agroclinic.sugarcaneSeeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.agroclinic.R;
import com.example.agroclinic.databinding.ActivityCoupletSeedsBinding;

import java.text.DecimalFormat;

public class CoupletSeedsActivity extends AppCompatActivity {
    ActivityCoupletSeedsBinding binding;
    private DecimalFormat decimalFormat;
    private String valueofEditText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_couplet_seeds);
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
                    Toast.makeText(CoupletSeedsActivity.this, "अंतर निवडा", Toast.LENGTH_SHORT).show();
                } else if (binding.rbHector.isChecked()) {
                    Toast.makeText(CoupletSeedsActivity.this, "अंतर निवडा", Toast.LENGTH_SHORT).show();
                } else if (binding.rbGunta.isChecked()) {
                    Toast.makeText(CoupletSeedsActivity.this, "अंतर निवडा", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CoupletSeedsActivity.this, "एकक निवडा", Toast.LENGTH_SHORT).show();
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
                        binding.rbFirst.setText(" 5' X 6'' ");
                        binding.rbSecond.setText(" 6' X 6'' ");
                        calculationForGuntaSixInch(valueofEditText);
                    } else if (binding.rbGunta.isChecked() && binding.rbNineInch.isChecked()) {
                        binding.rbFirst.setText(" 5' X 9'' ");
                        binding.rbSecond.setText(" 6' X 9'' ");

                        calculationForGuntaNineInch(valueofEditText);
                    } else if (binding.rbEkar.isChecked() && binding.rbSixInch.isChecked()) {
                        binding.rbFirst.setText(" 5' X 6'' ");
                        binding.rbSecond.setText(" 6' X 6'' ");

                        calculationForAcerSixInch(valueofEditText);
                    } else if (binding.rbEkar.isChecked() && binding.rbNineInch.isChecked()) {
                        binding.rbFirst.setText(" 5' X 9'' ");
                        binding.rbSecond.setText(" 6' X 9'' ");

                        calculationForAcerNineInch(valueofEditText);
                    } else if (binding.rbHector.isChecked() && binding.rbSixInch.isChecked()) {
                        binding.rbFirst.setText(" 5' X 6'' ");
                        binding.rbSecond.setText(" 6' X 6'' ");

                        calculationForHectorSixInch(valueofEditText);
                    } else if (binding.rbHector.isChecked() && binding.rbNineInch.isChecked()) {
                        binding.rbFirst.setText(" 5' X 9'' ");
                        binding.rbSecond.setText(" 6' X 9'' ");

                        calculationForHectorNineInch(valueofEditText);
                    } else {
                        Toast.makeText(CoupletSeedsActivity.this, "अंतर निवडा", Toast.LENGTH_SHORT).show();
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
                    binding.rbFirst.setText(" 5' X 9'' ");
                    binding.rbSecond.setText(" 6' X 9'' ");

                }else if ((binding.rbSixInch.isChecked())){
                    binding.etLand.setText("0.0");
                    binding.rbFirst.setText(" 5' X 6'' ");
                    binding.rbSecond.setText(" 6' X 6'' ");

                }else {
                    binding.rbFirst.setText("0 ");
                    binding.rbSecond.setText("0 ");
                }
            }
        });
    }

    private void calculationForGuntaSixInch(String input) {
        // 5'X6"
        binding.rbFirst.setText(" 5' X 6'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 217.8);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));

        // 6'X6"
        binding.rbSecond.setText(" 6' X 6'' ");
        double seedsRequiredFor45 = (inputFromEditText * 181.67);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));
    }

    private void calculationForGuntaNineInch(String input) {
        // 4'X9"
        binding.rbFirst.setText(" 5' X 9'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 183.39);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));

        // 4.5'X9"
        binding.rbSecond.setText(" 6' X 9'' ");
        double seedsRequiredFor45 = (inputFromEditText * 152.99);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));

    }

    private void calculationForAcerSixInch(String input) {
        // 4'X6"
        binding.rbFirst.setText(" 5' X 6'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 8712.0);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));

        // 4.5'X6"
        binding.rbSecond.setText(" 6' X 6'' ");
        double seedsRequiredFor45 = (inputFromEditText * 7266.8);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));

    }

    private void calculationForAcerNineInch(String input) {
        // 4'X9"
        binding.rbFirst.setText(" 5' X 9'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 7335.6);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));

        // 4.5'X9"
        binding.rbSecond.setText(" 6' X 9'' ");
        double seedsRequiredFor45 = (inputFromEditText * 6119.6);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));

    }

    private void calculationForHectorSixInch(String input) {
        // 4'X6"
        binding.rbFirst.setText(" 5' X 6'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 21780.0);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));

        // 4.5'X6"
        binding.rbSecond.setText(" 6' X 6'' ");
        double seedsRequiredFor45 = (inputFromEditText * 18167.0);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));

    }

    private void calculationForHectorNineInch(String input) {
        // 4'X9"
        binding.rbFirst.setText(" 5' X 9'' ");
        float inputFromEditText = Float.parseFloat(input);
        double seedsRequiredFor4 = (inputFromEditText * 18339.0);
        double seedsRequiredFor4TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor4));
        binding.tvFirst.setText(String.valueOf(seedsRequiredFor4TwoDigits));

        // 4.5'X9"
        binding.rbSecond.setText(" 6' X 9'' ");
        double seedsRequiredFor45 = (inputFromEditText * 15299.0);
        double seedsRequiredFor45TwoDigits = Double.parseDouble(String.format("%.2f", seedsRequiredFor45));
        binding.tvSecond.setText(String.valueOf(seedsRequiredFor45TwoDigits));

    }

    private void increaseValue() {

        String currentValueStr = binding.etLand.getText().toString();
        float currentValue = Float.parseFloat(currentValueStr);
        currentValue += 0.5;
        binding.etLand.setText(decimalFormat.format(currentValue));
        if (binding.rbGunta.isChecked() && binding.rbSixInch.isChecked()) {
            binding.rbFirst.setText(" 5' X 6'' ");
            binding.rbSecond.setText(" 6' X 6'' ");

            calculationForGuntaSixInch(valueofEditText);
        } else if (binding.rbGunta.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 5' X 9'' ");
            binding.rbSecond.setText(" 6' X 9'' ");

            calculationForGuntaNineInch(valueofEditText);
        } else if (binding.rbEkar.isChecked() && binding.rbSixInch.isChecked()) {
            binding.rbFirst.setText(" 5' X 6'' ");
            binding.rbSecond.setText(" 6' X 6'' ");

            calculationForAcerSixInch(valueofEditText);
        } else if (binding.rbEkar.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 5' X 9'' ");
            binding.rbSecond.setText(" 6' X 9'' ");

            calculationForAcerNineInch(valueofEditText);
        } else if (binding.rbHector.isChecked() && binding.rbSixInch.isChecked()) {
            binding.rbFirst.setText(" 5' X 6'' ");
            binding.rbSecond.setText(" 6' X 6'' ");

            calculationForHectorSixInch(valueofEditText);
        } else if (binding.rbHector.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 5' X 9'' ");
            binding.rbSecond.setText(" 6' X 9'' ");

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
            binding.rbFirst.setText(" 5' X 6'' ");
            binding.rbSecond.setText(" 6' X 6'' ");

            calculationForGuntaSixInch(valueofEditText);
        } else if (binding.rbGunta.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 5' X 9'' ");
            binding.rbSecond.setText(" 6' X 9'' ");

            calculationForGuntaNineInch(valueofEditText);
        } else if (binding.rbEkar.isChecked() && binding.rbSixInch.isChecked()) {
            binding.rbFirst.setText(" 5' X 6'' ");
            binding.rbSecond.setText(" 6' X 6'' ");

            calculationForAcerSixInch(valueofEditText);
        } else if (binding.rbEkar.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 5' X 9'' ");
            binding.rbSecond.setText(" 6' X 9'' ");

            calculationForAcerNineInch(valueofEditText);
        } else if (binding.rbHector.isChecked() && binding.rbSixInch.isChecked()) {
            binding.rbFirst.setText(" 5' X 6'' ");
            binding.rbSecond.setText(" 6' X 6'' ");

            calculationForHectorSixInch(valueofEditText);
        } else if (binding.rbHector.isChecked() && binding.rbNineInch.isChecked()) {
            binding.rbFirst.setText(" 5' X 9'' ");
            binding.rbSecond.setText(" 6' X 9'' ");

            calculationForHectorNineInch(valueofEditText);
        } else {
            Toast.makeText(this, "अंतर निवडा", Toast.LENGTH_SHORT).show();
        }
    }
}