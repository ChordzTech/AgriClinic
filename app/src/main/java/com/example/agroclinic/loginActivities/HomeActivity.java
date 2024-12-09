package com.example.agroclinic.loginActivities;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.agroclinic.R;
import com.example.agroclinic.cards.AgriDataProvider;
import com.example.agroclinic.data.MainRepository;
import com.example.agroclinic.data.remote.RetroFitService;
import com.example.agroclinic.data.response.AllInfoItem;
import com.example.agroclinic.databinding.ActivityHomeBinding;
import com.example.agroclinic.loginActivities.fragments.ContactUsFragment;
import com.example.agroclinic.loginActivities.fragments.CropInfoFragment;
import com.example.agroclinic.loginActivities.fragments.HomeFragment;
import com.example.agroclinic.loginActivities.fragments.ProfileFragment;
import com.example.agroclinic.viewModel.AppViewModelFactory;
import com.example.agroclinic.viewModel.HomeViewModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements IHomeActivityCallBack {
    private ActivityHomeBinding homeBinding;
    private HomeViewModel homeViewModel;
    private ArrayList<AllInfoItem> prastavikMsg = new ArrayList<>();
    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private CropInfoFragment cropInfoFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        initView();
        initObservables();
        fetchData();
        homeFragment = new HomeFragment(this); // Initialize here
        replaceFragment(new HomeFragment(this));

    }

    private void fetchData() {
        homeViewModel.getPrastavikMsg();
    }

    private void initObservables() {
        homeViewModel.getPrastavikLiveData().observe(this, prastavikResponse -> {
            if (prastavikResponse.getAllInfo() != null) {
                prastavikMsg = new ArrayList<>(prastavikResponse.getAllInfo());
                AgriDataProvider.INSTANCE.setPrastavikDetails(prastavikResponse);

            }
        });
    }

    private void initView() {
        RetroFitService retrofitService = RetroFitService.Companion.getInstance();
        MainRepository mainRepository = new MainRepository(retrofitService);
        homeViewModel = new ViewModelProvider(this, new AppViewModelFactory(mainRepository)).get(HomeViewModel.class);


//        homeFragment = new HomeFragment(this);
        profileFragment = new ProfileFragment();
        cropInfoFragment = new CropInfoFragment();

        homeBinding.bottomnav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.hhome) {
                replaceFragment(homeFragment);
                if (homeFragment != null) {
                    homeFragment.setPrastavik(prastavikMsg);
                }

            } else if (item.getItemId() == R.id.crops) {
                replaceFragment(new CropInfoFragment());
            } else if (item.getItemId() == R.id.profile) {
                replaceFragment(new ProfileFragment());
            } else {
                replaceFragment(new ContactUsFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl1, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void loadCropsFragment() {
        replaceFragment(new CropInfoFragment());
    }

}