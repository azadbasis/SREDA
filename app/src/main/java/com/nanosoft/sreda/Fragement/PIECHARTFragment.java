package com.nanosoft.sreda.Fragement;


import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.nanosoft.sreda.Activity.MainActivity;
import com.nanosoft.sreda.Adapter.CapacityReportChartAdapter;
import com.nanosoft.sreda.Adapter.ElectricGenMixChartAdapter;
import com.nanosoft.sreda.Model.CapacityData_Info;
import com.nanosoft.sreda.Model.ElectricityGenerationMixChart_Info;
import com.nanosoft.sreda.R;
import com.nanosoft.sreda.Utility.Operation;
import com.nanosoft.sreda.Utility.ServerResponseOperation;
import com.nanosoft.sreda.Utility.ShowPIECHART;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class PIECHARTFragment extends Fragment implements OnChartValueSelectedListener {

    PieChart pieChart, piechartElectricity;
    PieData data;
    ArrayList<String> xVals;
    ArrayList<Entry> yvalues;
    ServerResponseOperation serverResponseOperation;
    ElectricityGenerationMixChart_Info electricityGenerationMixChart_info, electricityGenerationMixChart_info1, electricityGenerationMixChart_info2, electricityGenerationMixChart_info3, electricityGenerationMixChart_info4;
    //ReGenerationChart_Info reGenerationChart_info1,reGenerationChart_info2,reGenerationChart_info3,reGenerationChart_info4,reGenerationChart_info5;
    ArrayList<ElectricityGenerationMixChart_Info> electricityGenerationMixChartInfoArrayList;
    //ArrayList<ReGenerationChart_Info> reGenerationChart_infoArrayList;
    RecyclerView recyclerviewGeneration, recyclerviewElectricity;
    ElectricGenMixChartAdapter electricGenMixChartAdapter;
    CapacityReportChartAdapter capacityReportChartAdapter;

    private String email,password;
    MainActivity mainActivity;
    List<CapacityData_Info> capacityData_InfoList ;
    public PIECHARTFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_piechart, container, false);
    }


    @Override
    public void onResume() {
        super.onResume();


        if(Operation.listCapacityData.size()>0){
            Toast.makeText(getActivity(), ""+Operation.listCapacityData.get(0).getTechnology_name(), Toast.LENGTH_SHORT).show();

            capacityData_InfoList=Operation.listCapacityData;
            capacityReportChartAdapter = new CapacityReportChartAdapter(getContext(), capacityData_InfoList);
            recyclerviewGeneration.setAdapter(capacityReportChartAdapter);

        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        capacityData_InfoList = new ArrayList<>();

        email = Operation.getString("email","");
        password = Operation.getString("password","");
        serverResponseOperation = new ServerResponseOperation(getContext());

        serverResponseOperation.getCapacityDataFormServer(email,password);

        mainActivity = (MainActivity) getActivity();
        recyclerviewGeneration = (RecyclerView) view.findViewById(R.id.recyclerviewGeneration);
        recyclerviewGeneration.setLayoutManager(new LinearLayoutManager(getActivity(), HORIZONTAL, false));
/*
        if(Operation.listCapacityData.size()>0){
            Toast.makeText(getActivity(), ""+Operation.listCapacityData.get(0).getTechnology_name(), Toast.LENGTH_SHORT).show();

            capacityData_InfoList=Operation.listCapacityData;
            capacityReportChartAdapter = new CapacityReportChartAdapter(getContext(), capacityData_InfoList);
            recyclerviewGeneration.setAdapter(capacityReportChartAdapter);

        }*/



        electricityGenerationMixChartInfoArrayList = new ArrayList<>();
        recyclerviewElectricity = (RecyclerView) view.findViewById(R.id.recyclerviewElectricity);
        recyclerviewElectricity.setLayoutManager(new LinearLayoutManager(getActivity(), HORIZONTAL, false));
        electricGenMixChartAdapter = new ElectricGenMixChartAdapter(getContext(), electricityGenerationMixChartInfoArrayList);
        recyclerviewElectricity.setAdapter(electricGenMixChartAdapter);


        pieChart = (PieChart) view.findViewById(R.id.piechartRegeneration);
        piechartElectricity = (PieChart) view.findViewById(R.id.piechartElectricity);

        ShowPIECHART showPIECHART= new ShowPIECHART(getActivity(),pieChart,piechartElectricity);

     //   showPIECHART.createPIECHART();

//        pieChart.setUsePercentValues(true);
//        piechartElectricity.setUsePercentValues(true);
//
//        // IMPORTANT: In a PieChart, no values (Entry) should have the same
//        // xIndex (even if from different DataSets), since no values can be
//        // drawn above each other.
//        yvalues = new ArrayList<Entry>();
//
//
//        yvalues.add(new Entry(88f, 0));
//        yvalues.add(new Entry(54f, 1));
//        yvalues.add(new Entry(53.56f, 2));
//        /*yvalues.add(new Entry(8f, 0));
//        yvalues.add(new Entry(15f, 1));
//        yvalues.add(new Entry(12f, 2));
//        yvalues.add(new Entry(25f, 3));
//        yvalues.add(new Entry(23f, 4));
//        yvalues.add(new Entry(17f, 5));*/
//
//        PieDataSet dataSet = new PieDataSet(yvalues, "Election Results");
//
//        xVals = new ArrayList<String>();
//
//        xVals.add(" Biogas to Electricity");
//        xVals.add("Biomass to Electricity");
//        xVals.add("Hydro");
//
// /*       xVals.add("January");
//        xVals.add("February");
//        xVals.add("March");
//        xVals.add("April");
//        xVals.add("May");
//        xVals.add("June");*/
//
//        data = new PieData(xVals, dataSet);
//        data.setValueFormatter(new PercentFormatter());
//        pieChart.setData(data);
//        pieChart.setDescription("This is Pie Chart");
//
//        pieChart.setDrawHoleEnabled(true);
//        pieChart.setTransparentCircleRadius(25f);
//        pieChart.setHoleRadius(25f);
//
//
//        piechartElectricity.setData(data);
//        piechartElectricity.setDescription("This is Pie Chart");
//
//        piechartElectricity.setDrawHoleEnabled(true);
//        piechartElectricity.setTransparentCircleRadius(25f);
//        piechartElectricity.setHoleRadius(25f);
//
//
//        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
//        data.setValueTextSize(13f);
//        data.setValueTextColor(Color.DKGRAY);
        pieChart.setOnChartValueSelectedListener(this);
        piechartElectricity.setOnChartValueSelectedListener(this);
//
//        pieChart.animateXY(1400, 1400);
//        piechartElectricity.animateXY(1400, 1400);


        electricityGenerationMixChart_info = new ElectricityGenerationMixChart_Info("azhar", 4.78, 8, 12.78);
        electricityGenerationMixChart_info1 = new ElectricityGenerationMixChart_Info("kutub", 4.58, 83, 87.53);
        electricityGenerationMixChart_info2 = new ElectricityGenerationMixChart_Info("arif", 4.48, 84, 88.48);
        electricityGenerationMixChart_info3 = new ElectricityGenerationMixChart_Info("sojib", 4.48, 85, 89.48);
        electricityGenerationMixChart_info4 = new ElectricityGenerationMixChart_Info("robin", 4.38, 87, 91.38);

        electricityGenerationMixChartInfoArrayList.add(electricityGenerationMixChart_info);
        electricityGenerationMixChartInfoArrayList.add(electricityGenerationMixChart_info1);
        electricityGenerationMixChartInfoArrayList.add(electricityGenerationMixChart_info2);
        electricityGenerationMixChartInfoArrayList.add(electricityGenerationMixChart_info3);
        electricityGenerationMixChartInfoArrayList.add(electricityGenerationMixChart_info4);


    }




    @Override
    public void onValueSelected(Entry e, int position, Highlight h) {

        // highlight the entry and x-position 50 in the first (0) DataSet
        h = new Highlight(50, 0);

        pieChart.highlightValue(h, true); // h
        piechartElectricity.highlightValue(h, true); // h
        if (e == null)
            return;
        Log.e("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + data.getDataSetByIndex(position));

        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.pie_data_dialogue);
        TextView tvTechName = dialog.findViewById(R.id.tvTechName);
        TextView tvTechDetail = dialog.findViewById(R.id.tvTechDetail);
        tvTechName.setText(xVals.get(e.getXIndex()).toString());
        tvTechDetail.setText(yvalues.get(e.getXIndex()).toString());
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.show();

    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }
}
