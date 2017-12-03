package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanosoft.sreda.Model.ReGenerationChart_Info;
import com.nanosoft.sreda.R;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/3/2017.
 */

public class ReGenSummeryReportChartAdapter extends RecyclerView.Adapter<ReGenSummeryReportChartAdapter.ReGenSummeryReportChartHolder> {


    Context context;
    ArrayList<ReGenerationChart_Info> reGenerationChart_infoArrayList;

    public  ReGenSummeryReportChartAdapter(Context context, ArrayList<ReGenerationChart_Info> reGenerationChart_infoArrayList){
        this.context=context;
        this.reGenerationChart_infoArrayList=reGenerationChart_infoArrayList;

    }


    @Override
    public ReGenSummeryReportChartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_headar_regeneration_chart,null);

        return new ReGenSummeryReportChartHolder(view);
    }

    @Override
    public void onBindViewHolder(ReGenSummeryReportChartHolder holder, int position) {

        ReGenerationChart_Info reGenerationChart_info=reGenerationChart_infoArrayList.get(position);


        holder.tvTechnology.setText(reGenerationChart_info.getTechnology());
        holder.tvOnGrid.setText(reGenerationChart_info.getOn_Grid()+"");
        holder.tvOffGrid.setText(reGenerationChart_info.getOff_Grid()+"");
        holder.tvTotal.setText(reGenerationChart_info.getTotal()+"");

    }

    @Override
    public int getItemCount() {
        return reGenerationChart_infoArrayList.size();
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
