package com.example.agroclinic.loginActivities.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agroclinic.CropsDescActivity;
import com.example.agroclinic.EditActivity;
import com.example.agroclinic.R;
import com.example.agroclinic.loginActivities.model.CropsDataModel;
import com.example.agroclinic.loginActivities.recyclerView.CropsViewAdapter;

import java.util.ArrayList;


public class CropInfoFragment extends Fragment implements CropsViewAdapter.OnCropsSelectedI{

    private ArrayList<CropsDataModel> cropsInfoList = new ArrayList<>();
    private CropsViewAdapter cropsViewAdapter;
    private RecyclerView rvCropsrecyclerView;

    public CropInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crop_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        prepareData();
        loadData();
    }

    private void loadData() {
        cropsViewAdapter.setCropsList(prepareData());
        rvCropsrecyclerView.setAdapter(cropsViewAdapter);
        cropsViewAdapter.notifyDataSetChanged();
    }

    private ArrayList<CropsDataModel> prepareData() {
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Intensive SugarCane Production Status and Future Directions"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Land and Season for Sugarcane cultivation"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Soil Test"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Fertilization and Management of Amini and Substantial"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Green fertilizer"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Maximum cultivars for sugarcane cultivation and seed selection"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Seed required for sugarcane cultivation as per rainfall and Otra"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Sugarcane seed sowing process-importance"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Sugarcane planting technology"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Chemical fertilizers required in season as per soil test."));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Micronutrients required for sugarcane crop"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Central Fertilizer for Sugarcane Cultivation"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Water management of sugarcane"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Sugarcane intercropping"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Pests and diseases on sugarcane and control"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Management of cassava crop"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Making the living dead"));
        cropsInfoList.add(new CropsDataModel("https://www.shutterstock.com/image-photo/farmer-examining-corn-plant-field-600nw-2160350591.jpg", "Preparation of vermicompost."));

        return cropsInfoList;
    }

    private void initView(View view) {
        rvCropsrecyclerView = view.findViewById(R.id.rvCropsRecyclerView);
        cropsViewAdapter = new CropsViewAdapter();
        cropsViewAdapter.setOnCropsSelectedListener(this);
    }

    @Override
    public void onCropsSelectedI(CropsDataModel cropsDataModel) {
        Intent intent=new Intent(getActivity(), CropsDescActivity.class);
        Bundle bundle= new Bundle();
        bundle.putParcelable("ImageUrl",cropsDataModel);
        intent.putExtra("CropsDesc",bundle);
        startActivity(intent);

    }
}