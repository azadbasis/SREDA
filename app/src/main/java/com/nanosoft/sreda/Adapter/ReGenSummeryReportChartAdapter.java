package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.nanosoft.sreda.Model.ReGenerationChart_Info;

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
        return null;
    }

    @Override
    public void onBindViewHolder(ReGenSummeryReportChartHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return reGenerationChart_infoArrayList.size();
    }

    class ReGenSummeryReportChartHolder extends RecyclerView.ViewHolder{

        public ReGenSummeryReportChartHolder(View itemView) {
            super(itemView);
        }
    }
}
