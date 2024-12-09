package com.example.agroclinic.cards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.agroclinic.R;
import com.example.agroclinic.data.MainRepository;
import com.example.agroclinic.data.remote.RetroFitService;
import com.example.agroclinic.data.response.SoilInfo;
import com.example.agroclinic.data.response.SugarCane;
import com.example.agroclinic.databinding.ActivityThirdCardBinding;
import com.example.agroclinic.sugarcaneSeeds.CoupletSeedsActivity;
import com.example.agroclinic.sugarcaneSeeds.SeedsInTrayActivity;
import com.example.agroclinic.sugarcaneSeeds.SugarCaneSeedsActivity;
import com.example.agroclinic.viewModel.AppViewModelFactory;
import com.example.agroclinic.viewModel.HomeViewModel;

import java.util.ArrayList;

public class ThirdCardActivity extends AppCompatActivity {
    private ActivityThirdCardBinding binding;
    private HomeViewModel homeViewModel;
    private ArrayList<SoilInfo> soilInfos = new ArrayList<>();
    private ArrayList<SugarCane> sugarCanes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_third_card);
        initView();
        fetchData();
        initObservale();

    }

    private void initObservale() {
        homeViewModel.getSoilInfoLiveData().observe(this, soilResponse -> {
            if (soilResponse.getAllInfo() != null) {
                soilInfos = new ArrayList<>(soilResponse.getAllInfo());
                binding.tvMsg.setText(soilInfos.get(0).getMInfo());
                AgriDataProvider.INSTANCE.setSoilDetails(soilResponse);
            }
        });
        homeViewModel.getSugarCaneInfo().observe(this, sugarCaneResponse -> {
            if (sugarCaneResponse.getAllInfo() != null) {
                sugarCanes = new ArrayList<>(sugarCaneResponse.getAllInfo());
                StringBuilder sugarCaneInfoBuilder = new StringBuilder();
                for (SugarCane sugarCane : sugarCanes) {
                    if (sugarCane.getUInfo() != null) {
                        sugarCaneInfoBuilder.append(sugarCane.getUInfo()).append("\n\n");
                    }
                }
                binding.tvSugarCaneInfo.setText(sugarCaneInfoBuilder.toString().trim());
            }
        });
    }


    private void fetchData() {
        homeViewModel.getSoil();
        homeViewModel.getSugarCane();
    }

    private void initView() {

        RetroFitService retrofitService = RetroFitService.Companion.getInstance();
        MainRepository mainRepository = new MainRepository(retrofitService);
        homeViewModel = new ViewModelProvider(this, new AppViewModelFactory(mainRepository)).get(HomeViewModel.class);

        binding.cvTableName1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdCardActivity.this, SugarCaneSeedsActivity.class);
                startActivity(intent);
            }
        });
        binding.cvTableName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ThirdCardActivity.this, CoupletSeedsActivity.class);
                startActivity(intent1);
            }
        });
        binding.cvTableName3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(ThirdCardActivity.this, SeedsInTrayActivity.class);
                startActivity(intent2);
            }
        });

    }

}