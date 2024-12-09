package com.example.agroclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.agroclinic.loginActivities.model.CropsDataModel;

public class CropsDescActivity extends AppCompatActivity {
    
    private CropsDataModel cropsDataModel;
    private ImageView imageView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crops_desc);
        imageView=findViewById(R.id.ivCropsImage);
        textView=findViewById(R.id.tvText);
        if (getIntent().getExtras().getParcelable("CropsDesc")!=null){
            cropsDataModel=getIntent().getExtras().getBundle("CropsDesc").getParcelable("ImageUrl");
            updateUI(cropsDataModel);
        }

    }

    private void updateUI(CropsDataModel cropsDataModel) {
        Glide.with(this).load(cropsDataModel.getImageUrl()).centerCrop().into(imageView);
        textView.setText(cropsDataModel.getTitle().toString());
    }
}