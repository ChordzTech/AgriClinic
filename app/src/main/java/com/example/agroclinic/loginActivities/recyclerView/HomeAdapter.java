package com.example.agroclinic.loginActivities.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.agroclinic.R;
import com.example.agroclinic.data.response.AllInfoItem;
import com.example.agroclinic.loginActivities.model.HomeDataModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private OnCropsSelectedI onCropsSelectedI;
    private ArrayList<HomeDataModel> cropsDescList;
    private ArrayList<AllInfoItem> prastavikMsg = new ArrayList<>();

    public void setOnCropsSelectedListener(OnCropsSelectedI onCropsSelectedListener) {
        this.onCropsSelectedI = onCropsSelectedListener;
    }

    public void setPrastavikMsg(ArrayList<AllInfoItem> prastavikMsg) {
        this.prastavikMsg = prastavikMsg;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_sugar_cane, parent, false);
        return new HomeAdapter.HomeViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        AllInfoItem allInfoItem= prastavikMsg.get(position);
        holder.tvText.setText(allInfoItem.getPInfo().toString());

        HomeDataModel homeDataModel = cropsDescList.get(position);
        holder.tvText.setText(homeDataModel.getCropDesc());
        Glide.with(holder.itemView.getContext())
                .load(homeDataModel.getImgUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(holder.ivCropsImage);
    }

    @Override
    public int getItemCount() {

        return cropsDescList.size();
    }

    public void setCropsDescList(ArrayList<HomeDataModel> cropsDescList) {
        this.cropsDescList = cropsDescList;
    }

    public interface OnCropsSelectedI {
        public void onCropsSelectedI(HomeDataModel homeDataModel);
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCropsImage;
        private TextView tvText,tvPrastavik;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCropsImage = itemView.findViewById(R.id.ivCropsImage);
            tvText = itemView.findViewById(R.id.tvText);
            tvPrastavik=itemView.findViewById(R.id.tvPrastavik);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCropsSelectedI.onCropsSelectedI(cropsDescList.get(getAdapterPosition()));
                }
            });
        }
    }
}

