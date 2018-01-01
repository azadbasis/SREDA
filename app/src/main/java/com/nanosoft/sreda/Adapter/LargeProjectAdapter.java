package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanosoft.sreda.Model.Info_TechWiseGenReportSubCategory;
import com.nanosoft.sreda.Model.ReReport;
import com.nanosoft.sreda.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanosoft-Android on 12/3/2017.
 */

public class LargeProjectAdapter extends RecyclerView.Adapter<LargeProjectAdapter.ReGenSummeryReportChartHolder> {


    Context context;
    private ReReport[] reReport;


    public LargeProjectAdapter(Context context, ReReport[] reReport){
        this.context=context;
        this.reReport=reReport;

    }


    @Override
    public ReGenSummeryReportChartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_large_project,null);

        return new ReGenSummeryReportChartHolder(view);
    }

    @Override
    public void onBindViewHolder(ReGenSummeryReportChartHolder holder, int position) {

        ReReport data=reReport[position];

        int serial = position+1;
        holder.tvSeriNo.setText(serial+"");
        holder.tvCapaci.setText(data.getCapacity());
        holder.tvTechnoname.setText(data.getTech_name());
        holder.tvCompleteDate.setText(data.getCompletion_date());
        holder.tvFinna.setText(data.getFinance_name());
        holder.tvLocat.setText(data.getVillage()+"\n"+data.getUnion_name()
                +"\n"+data.getDistrict_name()+"\n"+data.getDivision_name());
        holder.tvOrganization.setText(data.getUser_name());
        holder.tvProjName.setText(data.getPi_name());
        holder.tvPresStatus.setText(data.getPresent_status());

    }

    @Override
    public int getItemCount() {
        return reReport.length;
    }

    class ReGenSummeryReportChartHolder extends RecyclerView.ViewHolder{

        TextView tvSeriNo,tvProjName,tvTechnoname,tvCapaci,tvLocat,tvFinna,tvCompleteDate,
                tvOrganization,tvPresStatus;
        public ReGenSummeryReportChartHolder(View itemView) {
            super(itemView);
            tvSeriNo=(TextView)itemView.findViewById(R.id.tvSeriNo);
            tvProjName=(TextView)itemView.findViewById(R.id.tvProjName);
            tvTechnoname=(TextView)itemView.findViewById(R.id.tvTechnoname);
            tvCapaci=(TextView)itemView.findViewById(R.id.tvCapaci);
            tvLocat=(TextView)itemView.findViewById(R.id.tvLocat);
            tvFinna=(TextView)itemView.findViewById(R.id.tvFinna);
            tvCompleteDate=(TextView)itemView.findViewById(R.id.tvCompleteDate);
            tvOrganization=(TextView)itemView.findViewById(R.id.tvOrganization);
            tvPresStatus=(TextView)itemView.findViewById(R.id.tvPresStatus);
        }
    }
}
