package com.example.speedrecords.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.speedrecords.R;
import com.example.speedrecords.model.Speed;

import java.util.Locale;

public class SpeedAdpter extends RecyclerView.Adapter<SpeedAdpter.MyViewHolder> {

    private Context mContext;
    private Speed[] mSpeeds;

    public SpeedAdpter(Context context, Speed[] Speed) {
        this.mContext = context;
        this.mSpeeds = Speed;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Speed speed = mSpeeds[position];
        holder.calTextView.setText(speed.resultStr + " KM/H");
        holder.detailTextView.setText(speed.time +" METERS,"+
                speed.time+" SECONDS");
    }

    @Override
    public int getItemCount() {
        return mSpeeds.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView calTextView;
        TextView detailTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.calTextView = itemView.findViewById(R.id.cal_text_view);
            this.detailTextView = itemView.findViewById(R.id.detail_text_view);
        }
    }
}

