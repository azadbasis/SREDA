package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanosoft.sreda.Model.TechWiseGenReport_Info;
import com.nanosoft.sreda.R;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class TechNamesReportAdapter extends RecyclerView.Adapter<TechNamesReportAdapter.TechNamesReportHolder> {


    Context context;
    private ArrayList<TechWiseGenReport_Info> techWiseGenReport_infoArrayList;

    public TechNamesReportAdapter(Context context, ArrayList<TechWiseGenReport_Info> techWiseGenReport_infoArrayList) {
        this.context = context;
        this.techWiseGenReport_infoArrayList = techWiseGenReport_infoArrayList;
    }



    @Override
    public TechNamesReportHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_technology_wise,null);
        return new TechNamesReportHolder(view);
    }

    @Override
    public void onBindViewHolder(TechNamesReportHolder holder, int position) {

        TechWiseGenReport_Info techWiseGenReport_info=techWiseGenReport_infoArrayList.get(position);
        holder.tvSN.setText(position+1);
        holder.tvTecnologyTitle.setText(techWiseGenReport_info.getData().get(position).getSubCategory().get(position).getSub_category_title());
        holder.tvTecnologyName.setText(techWiseGenReport_info.getData().get(position).getSubCategory().get(position).getSub_category_title());
        holder.tvNumSystem.setText(techWiseGenReport_info.getData().get(position).getSubCategory().get(position).getNo_on_system());

        holder.tvOnGrid.setText(techWiseGenReport_info.getData().get(position).getSubCategory().get(position).getOn_grid()+"");
        holder.tvOffGrid.setText(techWiseGenReport_info.getData().get(position).getSubCategory().get(position).getOff_grid()+"");
        holder.tvToe.setText(techWiseGenReport_info.getData().get(position).getSubCategory().get(position).getToe()+"");
        holder.tvTotal.setText(techWiseGenReport_info.getData().get(position).getSubCategory().get(position).getTotal()+"");


    }

    @Override
    public int getItemCount() {
        return techWiseGenReport_infoArrayList.size();
    }

    public class TechNamesReportHolder extends RecyclerView.ViewHolder{



        TextView tvSN,tvTecnologyTitle,tvTecnologyName,tvNumSystem,tvOnGrid,tvOffGrid,tvToe,tvTotal;


        public TechNamesReportHolder(View itemView) {
            super(itemView);
            tvSN=(TextView)itemView.findViewById(R.id.tvSN);
            tvTecnologyTitle=(TextView)itemView.findViewById(R.id.tvTecnologyTitle);
            tvTecnologyName=(TextView)itemView.findViewById(R.id.tvTechnologyName);
            tvNumSystem=(TextView)itemView.findViewById(R.id.tvNumSystem);
            tvOnGrid=(TextView)itemView.findViewById(R.id.tvOnGrid);
            tvOffGrid=(TextView)itemView.findViewById(R.id.tvOffGrid);
            tvToe=(TextView)itemView.findViewById(R.id.tvToe);
            tvTotal=(TextView)itemView.findViewById(R.id.tvTotal);
        }



    }
}
