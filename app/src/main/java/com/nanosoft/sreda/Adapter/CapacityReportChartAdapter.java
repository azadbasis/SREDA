package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanosoft.sreda.Model.CapacityData_Info;
import com.nanosoft.sreda.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanosoft-Android on 12/3/2017.
 */

public class CapacityReportChartAdapter extends RecyclerView.Adapter<CapacityReportChartAdapter.ReGenSummeryReportChartHolder> {


    Context context;
    List<CapacityData_Info> capacityData_InfoList = new ArrayList<>();

    public CapacityReportChartAdapter(Context context, List<CapacityData_Info> capacityData_InfoList){
        this.context=context;
        this.capacityData_InfoList=capacityData_InfoList;

    }


    @Override
    public ReGenSummeryReportChartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_headar_regeneration_chart,null);

        return new ReGenSummeryReportChartHolder(view);
    }

    @Override
    public void onBindViewHolder(ReGenSummeryReportChartHolder holder, int position) {

        CapacityData_Info capacityData_Info=capacityData_InfoList.get(position);


        holder.tvTechnology.setText(capacityData_Info.getTechnology_name());
        holder.tvTechnology.setBackgroundColor(Color.parseColor(capacityData_Info.getColor()));

        holder.tvOnGrid.setText(capacityData_Info.getOn_grid()+"");
        holder.tvOffGrid.setText(capacityData_Info.getOff_grid()+"");
        holder.tvTotal.setText(capacityData_Info.getTotal()+"");

    }

    @Override
    public int getItemCount() {
        return capacityData_InfoList.size();
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
