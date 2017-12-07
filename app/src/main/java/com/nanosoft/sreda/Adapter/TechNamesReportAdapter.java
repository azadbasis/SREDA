package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nanosoft.sreda.Model.Info_TechWiseGenReportData;
import com.nanosoft.sreda.R;
import com.nanosoft.sreda.Utility.Operation;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class TechNamesReportAdapter extends RecyclerView.Adapter<TechNamesReportAdapter.TechNamesReportHolder> {


    Context context;
    private ArrayList<Info_TechWiseGenReportData> _infoTechWiseGenReportResponseArrayList;

    public TechNamesReportAdapter(Context context, ArrayList<Info_TechWiseGenReportData> _infoTechWiseGenReportResponseArrayList) {
        this.context = context;
        this._infoTechWiseGenReportResponseArrayList = _infoTechWiseGenReportResponseArrayList;
    }



    @Override
    public TechNamesReportHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_tecno_name,null);
        return new TechNamesReportHolder(view);
    }

    @Override
    public void onBindViewHolder(TechNamesReportHolder holder, int position) {

        Info_TechWiseGenReportData _infoTechWiseGenReportResponse = _infoTechWiseGenReportResponseArrayList.get(position);

        String nam = _infoTechWiseGenReportResponse.getTechnology_name();
//        String [] name= new String[nam.length()];
//        String n ="";
//        for(int i=0;i<name.length;i++){
//            n = n+"\n"+nam.charAt(i);
//        }


        holder.tvTechnologyName.setText(nam);

        //Toast.makeText(context, ""+_infoTechWiseGenReportResponse.getSubCategory().size(), Toast.LENGTH_SHORT).show();
       if(_infoTechWiseGenReportResponse.getSub_category().size()>0){
                   holder.recyclerviewTechWiseSub.setLayoutManager(new LinearLayoutManager(context, HORIZONTAL, false));
        TechNamesSubcategoryAdapter techNamesReportAdapter=new TechNamesSubcategoryAdapter(context,  _infoTechWiseGenReportResponse.getSub_category());
        holder.recyclerviewTechWiseSub.setAdapter(techNamesReportAdapter);
       }


    }

    @Override
    public int getItemCount() {

        return _infoTechWiseGenReportResponseArrayList.size();
    }

    public class TechNamesReportHolder extends RecyclerView.ViewHolder{



        TextView tvTechnologyName;
                //tvTecnologyTitle,tvTecnologyName,tvNumSystem,tvOnGrid,tvOffGrid,tvToe,tvTotal;

        RecyclerView recyclerviewTechWiseSub;

        public TechNamesReportHolder(View itemView) {
            super(itemView);
            tvTechnologyName=(TextView)itemView.findViewById(R.id.tvTechnologyName);
            recyclerviewTechWiseSub=(RecyclerView)itemView.findViewById(R.id.recyclerviewTechWiseSub);
//            tvTecnologyTitle=(TextView)itemView.findViewById(R.id.tvTecnologyTitle);
//            tvTecnologyName=(TextView)itemView.findViewById(R.id.tvTechnologyName);
//            tvNumSystem=(TextView)itemView.findViewById(R.id.tvNumSystem);
//            tvOnGrid=(TextView)itemView.findViewById(R.id.tvOnGrid);
//            tvOffGrid=(TextView)itemView.findViewById(R.id.tvOffGrid);
//            tvToe=(TextView)itemView.findViewById(R.id.tvToe);
//            tvTotal=(TextView)itemView.findViewById(R.id.tvTotal);
        }



    }
}
