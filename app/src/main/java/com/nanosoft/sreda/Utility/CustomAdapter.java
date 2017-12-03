package com.nanosoft.sreda.Utility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanosoft.sreda.Model.Employee;
import com.nanosoft.sreda.R;

import java.util.List;

/**
 * Created by Nanosoft-Android on 11/19/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    List<Employee> employeeList;
    Context context;

    public CustomAdapter(List<Employee> employeeList, Context context) {
        this.employeeList = employeeList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Employee employee = employeeList.get(position);
        holder.emailTv.setText(employee.email);
        holder.nameTv.setText(employee.name);
        holder.bodyTv.setText(employee.body);

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv,emailTv,bodyTv;
        public MyViewHolder(View view) {
            super(view);
            nameTv = (TextView)view.findViewById(R.id.nameTv);
            emailTv = (TextView)view.findViewById(R.id.emailTv);
            bodyTv = (TextView)view.findViewById(R.id.bodyTv);
        }
    }
}
