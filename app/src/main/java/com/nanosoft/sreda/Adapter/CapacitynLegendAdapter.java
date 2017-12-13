package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanosoft.sreda.Model.Info_CapacityData;
import com.nanosoft.sreda.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanosoft-Android on 12/3/2017.
 */

public class CapacitynLegendAdapter extends RecyclerView.Adapter<CapacitynLegendAdapter.ReGenSummeryReportChartHolder> {


    Context context;
    List<Info_CapacityData> _InfoCapacityDataList = new ArrayList<>();


    public CapacitynLegendAdapter(Context context, List<Info_CapacityData> fuelGenerationInfoList){
        this.context=context;
        this._InfoCapacityDataList=fuelGenerationInfoList;

    }


    @Override
    public ReGenSummeryReportChartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rawlegend,null);

        return new ReGenSummeryReportChartHolder(view);
    }

    @Override
    public void onBindViewHolder(ReGenSummeryReportChartHolder holder, int position) {

        Info_CapacityData fuelGenerationInfo=_InfoCapacityDataList.get(position);

        holder.tvLegendTitle.setText(fuelGenerationInfo.getTechnology_name());
        holder.tvLegendColor.setBackgroundColor(Color.parseColor(fuelGenerationInfo.getColor()));

    }

    @Override
    public int getItemCount() {
        return _InfoCapacityDataList.size();
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
