package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanosoft.sreda.Model.Info_TechWiseGenReportSubCategory;
import com.nanosoft.sreda.R;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class TechNamesSubcategoryAdapterHorizontal extends RecyclerView.Adapter<TechNamesSubcategoryAdapterHorizontal.TechNamesReportHolder> {


    Context context;
    private ArrayList<Info_TechWiseGenReportSubCategory> _infoTechWiseGenReportResponseArrayList;

    public TechNamesSubcategoryAdapterHorizontal(Context context, ArrayList<Info_TechWiseGenReportSubCategory> _infoTechWiseGenReportResponseArrayList) {
        this.context = context;
        this._infoTechWiseGenReportResponseArrayList = _infoTechWiseGenReportResponseArrayList;
    }



    @Override
    public TechNamesReportHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_techno_sub,null);
        return new TechNamesReportHolder(view);
    }

    @Override
    public void onBindViewHolder(TechNamesReportHolder holder, int position) {

        Info_TechWiseGenReportSubCategory technosubinfo = _infoTechWiseGenReportResponseArrayList.get(position);
        holder.tvTechnoSubName.setText(technosubinfo.getSub_category_title());
        holder.tvNumOfSystem.setText(String.valueOf(technosubinfo.getNo_on_system()));
        holder.tvOnGride.setText(String.valueOf(technosubinfo.getOn_grid()));
        holder.tvOffGride.setText(String.valueOf(technosubinfo.getOff_grid()));
        holder.tvToe.setText(String.valueOf(technosubinfo.getToe()));
        holder.tvTotalTec.setText(String.valueOf(technosubinfo.getTotal()));

    }

    @Override
    public int getItemCount() {
        return _infoTechWiseGenReportResponseArrayList.size();
    }

    public class TechNamesReportHolder extends RecyclerView.ViewHolder{



        TextView tvTechnoSubName,tvNumOfSystem,tvOnGride,tvOffGride,tvToe,tvTotalTec;


        public TechNamesReportHolder(View itemView) {
            super(itemView);
            tvTechnoSubName=(TextView)itemView.findViewById(R.id.tvTechnoSubName);
            tvNumOfSystem=(TextView)itemView.findViewById(R.id.tvNumOfSystem);
            tvOnGride=(TextView)itemView.findViewById(R.id.tvOnGride);
            tvOffGride=(TextView)itemView.findViewById(R.id.tvOffGride);
            tvToe=(TextView)itemView.findViewById(R.id.tvToe);
            tvTotalTec=(TextView)itemView.findViewById(R.id.tvTotalTec);
        }



    }
}
