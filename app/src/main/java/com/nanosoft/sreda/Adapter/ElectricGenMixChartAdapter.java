package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanosoft.sreda.Model.ElectricityGenerationMixChart_Info;
import com.nanosoft.sreda.R;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/3/2017.
 */

public class ElectricGenMixChartAdapter extends RecyclerView.Adapter<ElectricGenMixChartAdapter.ElectricGenMixChartViewHolder> {


    public ArrayList<ElectricityGenerationMixChart_Info> electricityGenerationMixChart_infos;
    Context context;

    public ElectricGenMixChartAdapter(Context context, ArrayList<ElectricityGenerationMixChart_Info> electricityGenerationMixChart_infos) {
        this.context = context;
        this.electricityGenerationMixChart_infos = electricityGenerationMixChart_infos;
    }

    @Override
    public ElectricGenMixChartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_headar_electricity_chart, null);
        return new ElectricGenMixChartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ElectricGenMixChartViewHolder holder, int position) {

        ElectricityGenerationMixChart_Info electricityGenerationMixChart_info = electricityGenerationMixChart_infos.get(position);
        holder.tvName.setText(electricityGenerationMixChart_info.getName());
        holder.tvCapacity.setText(electricityGenerationMixChart_info.getCapacity() + "");
        holder.tvPercentage.setText(electricityGenerationMixChart_info.getPercentage() + "");
        holder.tvTotal.setText(electricityGenerationMixChart_info.getTotal() + "");

    }

    @Override
    public int getItemCount() {
        return electricityGenerationMixChart_infos.size();
    }

    class ElectricGenMixChartViewHolder extends RecyclerView.ViewHolder {


        TextView tvName, tvCapacity, tvPercentage,tvTotal;

        public ElectricGenMixChartViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvCapacity = (TextView) view.findViewById(R.id.tvCapacity);
            tvPercentage = (TextView) view.findViewById(R.id.tvPercentage);
            tvTotal = (TextView) view.findViewById(R.id.tvTotal);

        }
    }

}
