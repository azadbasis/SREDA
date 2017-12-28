package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanosoft.sreda.Model.Info_TechWiseGenReportData;
import com.nanosoft.sreda.R;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;
import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class TechNamesReportAdapterHorizontal extends RecyclerView.Adapter<TechNamesReportAdapterHorizontal.TechNamesReportHolder> {


    Context context;
    private List<Info_TechWiseGenReportData> _infoTechWiseGenReportResponseArrayList = new ArrayList<>();

    public TechNamesReportAdapterHorizontal(Context context, List<Info_TechWiseGenReportData> _infoTechWiseGenReportResponseArrayList) {
        this.context = context;
        this._infoTechWiseGenReportResponseArrayList = _infoTechWiseGenReportResponseArrayList;
    }



    @Override
    public TechNamesReportHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_teno_horizontal,null);
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


        holder.tvTecTitle.setText(nam);
        holder.tvSerial.setText(String.valueOf(position+1));

        //Toast.makeText(context, ""+_infoTechWiseGenReportResponse.getSubCategory().size(), Toast.LENGTH_SHORT).show();
       if(_infoTechWiseGenReportResponse.getSub_category().size()>0){
                   holder.recyclerviewTechWiseSub.setLayoutManager(new LinearLayoutManager(context, VERTICAL, false));
        TechNamesSubcategoryAdapterHorizontal techNamesReportAdapter=new TechNamesSubcategoryAdapterHorizontal(context,  _infoTechWiseGenReportResponse.getSub_category());
        holder.recyclerviewTechWiseSub.setAdapter(techNamesReportAdapter);
       }


    }

    @Override
    public int getItemCount() {

        return _infoTechWiseGenReportResponseArrayList.size();
    }

    public class TechNamesReportHolder extends RecyclerView.ViewHolder{



        TextView tvSerial,tvTecTitle;
                //tvTecnologyTitle,tvTecnologyName,tvNumSystem,tvOnGrid,tvOffGrid,tvToe,tvTotal;

        RecyclerView recyclerviewTechWiseSub;

        public TechNamesReportHolder(View itemView) {
            super(itemView);
            tvSerial=(TextView)itemView.findViewById(R.id.tvSerial);
            tvTecTitle=(TextView)itemView.findViewById(R.id.tvTecTitle);
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
