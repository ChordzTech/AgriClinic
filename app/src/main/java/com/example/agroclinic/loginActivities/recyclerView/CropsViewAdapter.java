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
import com.example.agroclinic.loginActivities.model.CropsDataModel;

import java.util.ArrayList;

public class CropsViewAdapter extends RecyclerView.Adapter<CropsViewAdapter.CropsViewHolder> {
    private OnCropsSelectedI onCropsSelectedI;
    private ArrayList<CropsDataModel> cropsInfoList;

    public void setOnCropsSelectedListener(OnCropsSelectedI onCropsSelectedListener) {
        this.onCropsSelectedI = onCropsSelectedListener;
    }

    @NonNull
    @Override
    public CropsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_sugar_cane, parent, false);
        return new CropsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CropsViewHolder holder, int position) {
        CropsDataModel cropsDataModel = cropsInfoList.get(position);
        holder.tvText.setText(cropsDataModel.getTitle());
        Glide.with(holder.itemView.getContext())
                .load(cropsDataModel.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(holder.ivCropsImage);
    }

    @Override
    public int getItemCount() {
        return cropsInfoList.size();
    }

    public void setCropsList(ArrayList<CropsDataModel> cropsInfoList) {
        this.cropsInfoList = cropsInfoList;
    }

    public OnCropsSelectedI getOnCropsSelectedI() {
        return onCropsSelectedI;
    }

    public interface OnCropsSelectedI {
        public void onCropsSelectedI(CropsDataModel cropsDataModel);

    }

    class CropsViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCropsImage;
        private TextView tvText;

        public CropsViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCropsImage = itemView.findViewById(R.id.ivCropsImage);
            tvText = itemView.findViewById(R.id.tvText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCropsSelectedI.onCropsSelectedI(cropsInfoList.get(getAdapterPosition()));
                }
            });
        }
    }
}
