package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.nanosoft.sreda.Model.Info_CapacityData;
import com.nanosoft.sreda.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanosoft-Android on 12/3/2017.
 */

public class CapacityReportChartAdapterVertical extends RecyclerView.Adapter<CapacityReportChartAdapterVertical.ReGenSummeryReportChartHolder> {

    PieChart pieChart;
    Context context;
    List<Info_CapacityData> _InfoCapacityDataList = new ArrayList<>();

    public CapacityReportChartAdapterVertical(Context context, List<Info_CapacityData> _InfoCapacityDataList, PieChart pieChart){
        this.context=context;
        this._InfoCapacityDataList = _InfoCapacityDataList;
        this.pieChart = pieChart;

    }


    @Override
    public ReGenSummeryReportChartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_headar_regeneration_chart_virtical,null);

        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        return new ReGenSummeryReportChartHolder(view);
    }

    @Override
    public void onBindViewHolder(ReGenSummeryReportChartHolder holder, int position) {

        Info_CapacityData _InfoCapacityData = _InfoCapacityDataList.get(position);


        holder.tvTechnology.setText(_InfoCapacityData.getTechnology_name());
        holder.tvTechnology.setBackgroundColor(Color.parseColor(_InfoCapacityData.getColor()));

        holder.tvOnGrid.setText(_InfoCapacityData.getOn_grid()+"");
        holder.tvOffGrid.setText(_InfoCapacityData.getOff_grid()+"");
        holder.tvTotal.setText(_InfoCapacityData.getTotal()+"");

    }

    @Override
    public int getItemCount() {
        return _InfoCapacityDataList.size();
    }

    class ReGenSummeryReportChartHolder extends RecyclerView.ViewHolder{

        TextView tvTechnology,tvOnGrid,tvOffGrid,tvTotal;
        public ReGenSummeryReportChartHolder(View itemView) {
            super(itemView);
            tvTechnology=(TextView)itemView.findViewById(R.id.tvTechnology);
            tvOnGrid=(TextView)itemView.findViewById(R.id.tvOnGrid);
            tvOffGrid=(TextView)itemView.findViewById(R.id.tvOffGrid);
            tvTotal=(TextView)itemView.findViewById(R.id.tvTotal);
        }



    }




}
