package com.example.agroclinic;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.example.agroclinic.databinding.ProgressDialogBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Utils {

    private static AlertDialog dialog;

    public static void showDialog(Context context, String message) {
        ProgressDialogBinding progress = ProgressDialogBinding.inflate(LayoutInflater.from(context));
        progress.tvMessage.setText(message);
        dialog = new AlertDialog.Builder(context).setView(progress.getRoot()).setCancelable(false).create();
        dialog.show();
    }

    public static void hideDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void getCorrectUserPhoneNumberSize(
            Context context,
            TextInputEditText textInputEditText,
            MaterialButton button
    ) {

        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int len = s.length();

                if (len == 10) {
                    button.setBackgroundColor(
                            ContextCompat.getColor(
                                    context,
                                    R.color.green
                            )
                    );
                } else {
                    button.setBackgroundColor(
                            ContextCompat.getColor(
                                    context,
                                    R.color.light_green
                            )
                    );
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    public static void getCorrectOTPSize(
            Context context,
            TextInputEditText textInputEditText,
            MaterialButton button
    ) {

        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int len = s.length();

                if (len == 6) {
                    button.setBackgroundColor(
                            ContextCompat.getColor(
                                    context,
                                    R.color.green
                            )
                    );
                } else {
                    button.setBackgroundColor(
                            ContextCompat.getColor(
                                    context,
                                    R.color.light_green
                            )
                    );
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
}

