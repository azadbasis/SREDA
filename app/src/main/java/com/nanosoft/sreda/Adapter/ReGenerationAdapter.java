package com.nanosoft.sreda.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nanosoft.sreda.Model.ReGeneration_Info;
import com.nanosoft.sreda.R;

import java.util.ArrayList;


public class ReGenerationAdapter extends RecyclerView.Adapter<ReGenerationAdapter.MovieViewHolder> implements Filterable {


    //private List<OrderData> ordersPdf;
    private int rowLayout;
    private Context context;
    TextView tvGrandTotal;


    private ArrayList<ReGeneration_Info> reGenerationInfoArrayList= new ArrayList<>();
    public ArrayList<ReGeneration_Info> filtered_reReGeneration_infos = new ArrayList<>();
    ItemFilter mFilters = new ItemFilter();

    @Override
    public Filter getFilter() {
        return mFilters;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout allOrderLayout;
        TextView tvSerialNo,tvProjectName,tvTechnology,tvCapacity,tvLocation,tvFinance,tvCompDate,
        tvPresentStatus;
        public MovieViewHolder(View v) {
            super(v);
            tvSerialNo = (TextView) v.findViewById(R.id.tvSerialNo);
            tvProjectName = (TextView) v.findViewById(R.id.tvProjectName);
            tvTechnology = (TextView) v.findViewById(R.id.tvTechnology);
            tvCapacity = (TextView) v.findViewById(R.id.tvCapacity);
            tvLocation = (TextView) v.findViewById(R.id.tvLocation);
            tvFinance = (TextView) v.findViewById(R.id.tvFinance);
            tvCompDate = (TextView) v.findViewById(R.id.tvCompDate);
            tvPresentStatus = (TextView) v.findViewById(R.id.tvPresentStatus);
        }
    }



    public ReGenerationAdapter(ArrayList<ReGeneration_Info> orderHistoryDatas, int rowLayout, Context context) {

        this.context = context;
        this.reGenerationInfoArrayList = orderHistoryDatas;
        this.filtered_reReGeneration_infos = orderHistoryDatas;
        this.rowLayout = rowLayout;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {

        final ReGeneration_Info orderHistoryData =  filtered_reReGeneration_infos.get(position);


/*if(position==0){
    holder.tvSerialNo.setTextSize(16);
    holder.tvSerialNo.setTextColor(Color.parseColor("#000000"));
    holder.tvProjectName.setTextSize(16);
    holder.tvProjectName.setTextColor(Color.parseColor("#000000"));
    holder.tvTechnology.setTextSize(16);
    holder.tvTechnology.setTextColor(Color.parseColor("#000000"));
    holder.tvCapacity.setTextSize(16);
    holder.tvCapacity.setTextColor(Color.parseColor("#000000"));
    holder.tvLocation.setTextSize(16);
    holder.tvLocation.setTextColor(Color.parseColor("#000000"));
    holder.tvFinance.setTextSize(16);
    holder.tvFinance.setTextColor(Color.parseColor("#000000"));
    holder.tvCompDate.setTextSize(16);
    holder.tvCompDate.setTextColor(Color.parseColor("#000000"));
    holder.tvPresentStatus.setTextSize(16);
    holder.tvPresentStatus.setTextColor(Color.parseColor("#000000"));
}*/
//        if(position>0){
            holder.tvSerialNo.setText(orderHistoryData.getSl_No()+"");
            holder.tvProjectName.setText(orderHistoryData.getProjectName());
            holder.tvTechnology.setText(orderHistoryData.getTechnologyType());
            holder.tvCapacity.setText(orderHistoryData.getCapacity());
            holder.tvLocation.setText(orderHistoryData.getLocation());
            holder.tvFinance.setText(orderHistoryData.getFinance());
            holder.tvCompDate.setText(orderHistoryData.getCompletionDate());
            holder.tvPresentStatus.setText(orderHistoryData.getPresentStatus());

//        }




    }

    @Override
    public int getItemCount() {
        return filtered_reReGeneration_infos.size();
//        return reGenerationInfoArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public void filterList(ArrayList<ReGeneration_Info> filterdNames) {
        this.filtered_reReGeneration_infos = filterdNames;
        notifyDataSetChanged();
    }


    private class ItemFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String query = charSequence.toString().toLowerCase();
            FilterResults results = new FilterResults();
            final ArrayList<ReGeneration_Info> list = reGenerationInfoArrayList;
            final ArrayList<ReGeneration_Info> result_list = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i++){
                //int title = list.get(i).getProjectName();
                /*if(i==0){
                    result_list.add(list.get(0));
                }*/

          /*      if(i>0){*/
                    String str_title=list.get(i).getProjectName();
                    if (str_title.toLowerCase().contains(query)){
                        result_list.add(list.get(i));
                  /*  }*/
                }

            }
            results.values = result_list;
            results.count = result_list.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            filtered_reReGeneration_infos = (ArrayList<ReGeneration_Info>) filterResults.values;
            notifyDataSetChanged();

        }
    }
}