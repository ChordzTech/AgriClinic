package com.example.agroclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.agroclinic.loginActivities.model.CropsDataModel;
import com.example.agroclinic.loginActivities.model.HomeDataModel;

public class HomeDescActivity extends AppCompatActivity {
    private HomeDataModel homeDataModel;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_desc);
        imageView=findViewById(R.id.ivCropsImage);
        textView=findViewById(R.id.tvText);
        if (getIntent().getExtras().getParcelable("CropsDesc")!=null){
            homeDataModel=getIntent().getExtras().getBundle("CropsDesc").getParcelable("ImageUrl");
            updateUI(homeDataModel);
    }
}

    private void updateUI(HomeDataModel homeDataModel) {
        Glide.with(this).load(homeDataModel.getImgUrl()).centerCrop().into(imageView);
        textView.setText(homeDataModel.getCropDesc().toString());
    }
    }