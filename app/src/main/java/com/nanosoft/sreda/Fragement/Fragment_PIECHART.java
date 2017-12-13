package com.nanosoft.sreda.Fragement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.nanosoft.sreda.Activity.Activity_Main;
import com.nanosoft.sreda.Adapter.CapacityReportChartAdapter;
import com.nanosoft.sreda.Adapter.CapacitynLegendAdapter;
import com.nanosoft.sreda.Adapter.FuelGenerationChartAdapter;
import com.nanosoft.sreda.Adapter.FuelGenerationLegendAdapter;
import com.nanosoft.sreda.Model.Info_CapacityData;
import com.nanosoft.sreda.Model.Info_CapacityResponse;
import com.nanosoft.sreda.Model.Info_ElectricGenMixChart;
import com.nanosoft.sreda.Model.Info_FuelGenResponse;
import com.nanosoft.sreda.R;
import com.nanosoft.sreda.Utility.Api;
import com.nanosoft.sreda.Utility.Operation;
import com.nanosoft.sreda.Utility.ServerResponseOperation;
import com.nanosoft.sreda.Utility.ShowPIECHART;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_PIECHART extends Fragment {

    PieChart pieChart, piechartElectricity;
    PieData data;
    ArrayList<String> xVals;
    ArrayList<Entry> yvalues;
    ServerResponseOperation serverResponseOperation;
    Info_ElectricGenMixChart _infoElectricGenMixChart, _infoElectricGenMixChart1, _infoElectricGenMixChart2, _infoElectricGenMixChart3, _infoElectricGenMixChart4;
    RecyclerView recyclerviewGeneration, recyclerviewFuel,recylerGenerationLegend,recylerCapacityLegend;
    CapacityReportChartAdapter capacityReportChartAdapter;

    private String email,password;
    Activity_Main activityMain;
    List<Info_CapacityData> _InfoCapacityDataList;
    public Fragment_PIECHART() {
        // Required empty public constructor
    }

    EditText testEdi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_piechart, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _InfoCapacityDataList = new ArrayList<>();


        email = Operation.getString("email","");
        password = Operation.getString("password","");
        serverResponseOperation = new ServerResponseOperation(getContext());

        //serverResponseOperation.getCapacityDataFormServer(email,password);
        getCapacityDataFormServer(email,password);
        getFuelDataFormServer(email,password);

        activityMain = (Activity_Main) getActivity();
        recylerGenerationLegend = (RecyclerView) view.findViewById(R.id.recylerGenerationLegend);
        recylerGenerationLegend.setLayoutManager(new LinearLayoutManager(getActivity(), HORIZONTAL, false));

        recylerCapacityLegend = (RecyclerView) view.findViewById(R.id.recylerCapacityLegend);
        recylerCapacityLegend.setLayoutManager(new LinearLayoutManager(getActivity(), HORIZONTAL, false));




        recyclerviewGeneration = (RecyclerView) view.findViewById(R.id.recyclerviewGeneration);
        recyclerviewGeneration.setLayoutManager(new LinearLayoutManager(getActivity(), HORIZONTAL, false));

        recyclerviewFuel = (RecyclerView) view.findViewById(R.id.recyclerviewFuel);
        recyclerviewFuel.setLayoutManager(new LinearLayoutManager(getActivity(), HORIZONTAL, false));

            //_InfoCapacityDataList=Operation.listCapacityData;



       /* if(Operation.listCapacityData.size()>0){
            Toast.makeText(getActivity(), ""+Operation.listCapacityData.get(0).getTechnology_name(), Toast.LENGTH_SHORT).show();

            _InfoCapacityDataList=Operation.listCapacityData;
            capacityReportChartAdapter = new CapacityReportChartAdapter(getContext(), _InfoCapacityDataList);
            recyclerviewGeneration.setAdapter(capacityReportChartAdapter);

        }*/






        pieChart = (PieChart) view.findViewById(R.id.piechartRegeneration);
        piechartElectricity = (PieChart) view.findViewById(R.id.piechartElectricity);



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
//        pieChart.setOnChartValueSelectedListener(this);
//        piechartElectricity.setOnChartValueSelectedListener(this);
//
//        pieChart.animateXY(1400, 1400);
//        piechartElectricity.animateXY(1400, 1400);


    }


    @Override
    public void onResume() {
        super.onResume();



    }

//    @Override
//    public void onValueSelected(Entry e, int position, Highlight h) {
//
//        // highlight the entry and x-position 50 in the first (0) DataSet
//        h = new Highlight(50, 0);
//
//        pieChart.highlightValue(h, true); // h
//        piechartElectricity.highlightValue(h, true); // h
//        if (e == null)
//            return;
//        Log.e("VAL SELECTED",
//                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
//                        + ", DataSet index: " + data.getDataSetByIndex(position));
//
//        Dialog dialog = new Dialog(getActivity());
//        dialog.setContentView(R.layout.pie_data_dialogue);
//        TextView tvTechName = dialog.findViewById(R.id.tvTechName);
//        TextView tvTechDetail = dialog.findViewById(R.id.tvTechDetail);
//        tvTechName.setText(xVals.get(e.getXIndex()).toString());
//        tvTechDetail.setText(yvalues.get(e.getXIndex()).toString());
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.setCancelable(true);
//        dialog.show();
//
//    }
//
//    @Override
//    public void onNothingSelected() {
//        Log.i("PieChart", "nothing selected");
//    }



    public void getCapacityDataFormServer(String email, final String password) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);
        Call<Info_CapacityResponse> call = api.getCapacity(email,password);

        call.enqueue(new Callback<Info_CapacityResponse>() {
            @Override
            public void onResponse(Call<Info_CapacityResponse> call, Response<Info_CapacityResponse> response) {
                Info_CapacityResponse responseInfo = response.body();

                if(responseInfo!=null){
                    if(responseInfo.getStatus()==2000){
                        // Operation.listCapacityData = responseInfo.getData();

                        capacityReportChartAdapter = new CapacityReportChartAdapter(getContext(), responseInfo.getData(),pieChart);
                        recyclerviewGeneration.setAdapter(capacityReportChartAdapter);

                        recylerCapacityLegend.setAdapter(new CapacitynLegendAdapter(getActivity(),responseInfo.getData()));

                        new ShowPIECHART(getActivity(),pieChart,responseInfo.getData());

                        for(Info_CapacityData temp:responseInfo.getData()){
                            Operation.listCapacityData.add(temp);
                        }
                    }
                }






            }

            @Override
            public void onFailure(Call<Info_CapacityResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

                // busyNow.dismis();
            }
        });
    }


    public void getFuelDataFormServer(String email, final String password) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);
        Call<Info_FuelGenResponse> call = api.getFuel(email,password);

        call.enqueue(new Callback<Info_FuelGenResponse>() {
            @Override
            public void onResponse(Call<Info_FuelGenResponse> call, Response<Info_FuelGenResponse> response) {
                Info_FuelGenResponse responseInfo = response.body();


                if(responseInfo!=null){
                    if(responseInfo.getStatus()==2000){
                        // Operation.listCapacityData = responseInfo.getData();

                        FuelGenerationChartAdapter fuelGenerationChartAdapter = new FuelGenerationChartAdapter(getContext(), responseInfo.getData());
                        recyclerviewFuel.setAdapter(fuelGenerationChartAdapter);
                        new ShowPIECHART(getActivity(),piechartElectricity,responseInfo.getData(),"");

                        recylerGenerationLegend.setAdapter(new FuelGenerationLegendAdapter(getActivity(),responseInfo.getData()));

                    }

                }



            }

            @Override
            public void onFailure(Call<Info_FuelGenResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

                // busyNow.dismis();
            }
        });
    }

}
