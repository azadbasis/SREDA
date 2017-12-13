package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanosoft.sreda.Model.Info_FuelGenReport;
import com.nanosoft.sreda.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanosoft-Android on 12/3/2017.
 */

public class FuelGenerationChartAdapterVertical extends RecyclerView.Adapter<FuelGenerationChartAdapterVertical.ReGenSummeryReportChartHolder> {


    Context context;
    List<Info_FuelGenReport> fuelGenerationInfoList = new ArrayList<>();

    public FuelGenerationChartAdapterVertical(Context context, List<Info_FuelGenReport> fuelGenerationInfoList){
        this.context=context;
        this.fuelGenerationInfoList=fuelGenerationInfoList;

    }


    @Override
    public ReGenSummeryReportChartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_headar_electricity_chart_vertical,null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ReGenSummeryReportChartHolder(view);
    }

    @Override
    public void onBindViewHolder(ReGenSummeryReportChartHolder holder, int position) {

        Info_FuelGenReport fuelGenerationInfo=fuelGenerationInfoList.get(position);


        holder.tvName.setText(fuelGenerationInfo.getName());
        holder.tvName.setBackgroundColor(Color.parseColor(fuelGenerationInfo.getColor()));
       // holder.tvPercentage.setText(capacityData_Info.getOn_grid()+"");
        holder.tvCapacity.setText(fuelGenerationInfo.getInstalled_capacity());

    }

    @Override
    public int getItemCount() {
        return fuelGenerationInfoList.size();
    }

    class ReGenSummeryReportChartHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvPercentage,tvCapacity;
        public ReGenSummeryReportChartHolder(View itemView) {
            super(itemView);
            tvName=(TextView)itemView.findViewById(R.id.tvName);
            tvPercentage=(TextView)itemView.findViewById(R.id.tvPercentage);
            tvCapacity=(TextView)itemView.findViewById(R.id.tvCapacity);
        }
    }
}
