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

public class FuelGenerationLegendAdapter extends RecyclerView.Adapter<FuelGenerationLegendAdapter.ReGenSummeryReportChartHolder> {


    Context context;
    List<Info_FuelGenReport> fuelGenerationInfoList = new ArrayList<>();

    public FuelGenerationLegendAdapter(Context context, List<Info_FuelGenReport> fuelGenerationInfoList){
        this.context=context;
        this.fuelGenerationInfoList=fuelGenerationInfoList;

    }


    @Override
    public ReGenSummeryReportChartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rawlegend,null);

        return new ReGenSummeryReportChartHolder(view);
    }

    @Override
    public void onBindViewHolder(ReGenSummeryReportChartHolder holder, int position) {

        Info_FuelGenReport fuelGenerationInfo=fuelGenerationInfoList.get(position);

        holder.tvLegendTitle.setText(fuelGenerationInfo.getName());
        holder.tvLegendColor.setBackgroundColor(Color.parseColor(fuelGenerationInfo.getColor()));

    }

    @Override
    public int getItemCount() {
        return fuelGenerationInfoList.size();
    }

    class ReGenSummeryReportChartHolder extends RecyclerView.ViewHolder{

        TextView tvLegendColor,tvLegendTitle;
        public ReGenSummeryReportChartHolder(View itemView) {
            super(itemView);
            tvLegendColor=(TextView)itemView.findViewById(R.id.tvLegendColor);
            tvLegendTitle=(TextView)itemView.findViewById(R.id.tvLegendTitle);
        }
    }
}
