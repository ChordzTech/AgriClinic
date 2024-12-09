package com.example.agroclinic.loginActivities.fragments;

import static androidx.fragment.app.FragmentManager.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agroclinic.R;
import com.example.agroclinic.cards.AgriDataProvider;
import com.example.agroclinic.cards.FifthCardActivity;
import com.example.agroclinic.cards.FirstCardActivity;
import com.example.agroclinic.cards.FourthCardActivity;
import com.example.agroclinic.cards.SecondCardActivity;
import com.example.agroclinic.cards.SixthCardActivity;
import com.example.agroclinic.cards.ThirdCardActivity;
import com.example.agroclinic.data.response.AllInfoItem;
import com.example.agroclinic.data.response.PrastavikResponse;
import com.example.agroclinic.data.response.SoilInfo;
import com.example.agroclinic.loginActivities.IHomeActivityCallBack;
import com.example.agroclinic.loginActivities.model.HomeDataModel;
import com.example.agroclinic.loginActivities.recyclerView.HomeAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private ArrayList<HomeDataModel> cropDesc = new ArrayList<>();
    private HomeAdapter homeAdapter;
    private RecyclerView rvHomerecyclerView;
    private CardView cvFirstCard, cvSecond, cvThird, cvFourth, cvFifth, cvSixth;
    private TextView tvPrastavik;
    private ArrayList<AllInfoItem> prastavikMsg = new ArrayList<>();

    public HomeFragment(IHomeActivityCallBack iHomeActivityCallBack) {

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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvPrastavik = view.findViewById(R.id.tvPrastavik);
        cvFirstCard = view.findViewById(R.id.cvFirstCard);
        cvSecond = view.findViewById(R.id.cvSecond);
        cvThird = view.findViewById(R.id.cvThird);
        cvFourth = view.findViewById(R.id.cvFourth);
        cvFifth = view.findViewById(R.id.cvFifth);
        cvSixth = view.findViewById(R.id.cvSixth);

        setupCardViewListeners();
        // Fetch and display Prastavik data
        updatePrastavikText();


    }
    private void setupCardViewListeners() {
        cvFirstCard.setOnClickListener(v -> startActivity(new Intent(getActivity(), FirstCardActivity.class)));
        cvSecond.setOnClickListener(v -> startActivity(new Intent(getActivity(), SecondCardActivity.class)));
        cvThird.setOnClickListener(v -> startActivity(new Intent(getActivity(), ThirdCardActivity.class)));
        cvFourth.setOnClickListener(v -> startActivity(new Intent(getActivity(), FourthCardActivity.class)));
        cvFifth.setOnClickListener(v -> startActivity(new Intent(getActivity(), FifthCardActivity.class)));
        cvSixth.setOnClickListener(v -> startActivity(new Intent(getActivity(), SixthCardActivity.class)));
    }

    public void setPrastavik(ArrayList<AllInfoItem> prastavikMsg) {
        this.prastavikMsg = prastavikMsg;
        updatePrastavikText();
    }

    private void updatePrastavikText() {
        if (tvPrastavik != null && prastavikMsg != null && !prastavikMsg.isEmpty()) {
            tvPrastavik.setText(prastavikMsg.get(0).getPInfo());
        } else {

        }
    }

//    public void setSoilDetails(ArrayList<SoilInfo> soilInfos) {
//        this.soilInfos = soilInfos;
//        updatePrastavikText();
//    }
}