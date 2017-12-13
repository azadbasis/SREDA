package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanosoft.sreda.Model.Info_ElectricGenMixChart;
import com.nanosoft.sreda.R;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/3/2017.
 */

public class ElectricGenMixChartAdapterVertical extends RecyclerView.Adapter<ElectricGenMixChartAdapterVertical.ElectricGenMixChartViewHolder> {


    public ArrayList<Info_ElectricGenMixChart> _infoElectricGenMixCharts;
    Context context;

    public ElectricGenMixChartAdapterVertical(Context context, ArrayList<Info_ElectricGenMixChart> _infoElectricGenMixCharts) {
        this.context = context;
        this._infoElectricGenMixCharts = _infoElectricGenMixCharts;
    }

    @Override
    public ElectricGenMixChartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_headar_electricity_chart_vertical, null);

        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ElectricGenMixChartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ElectricGenMixChartViewHolder holder, int position) {

        Info_ElectricGenMixChart _infoElectricGenMixChart = _infoElectricGenMixCharts.get(position);
        holder.tvName.setText(_infoElectricGenMixChart.getName());
        holder.tvCapacity.setText(_infoElectricGenMixChart.getCapacity() + "");
        holder.tvPercentage.setText(_infoElectricGenMixChart.getPercentage() + "");
        holder.tvTotal.setText(_infoElectricGenMixChart.getTotal() + "");

    }

    @Override
    public int getItemCount() {
        return _infoElectricGenMixCharts.size();
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
