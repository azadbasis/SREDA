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
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.nanosoft.sreda.Activity.Activity_Main;
import com.nanosoft.sreda.Adapter.CapacityReportChartAdapterVertical;
import com.nanosoft.sreda.Adapter.CapacitynLegendAdapter;
import com.nanosoft.sreda.Adapter.FuelGenerationChartAdapter;
import com.nanosoft.sreda.Model.Info_CapacityData;
import com.nanosoft.sreda.Model.Info_CapacityResponse;
import com.nanosoft.sreda.Model.Info_ElectricGenMixChart;
import com.nanosoft.sreda.Model.Info_FuelGenResponse;
import com.nanosoft.sreda.R;
import com.nanosoft.sreda.Utility.Api;
import com.nanosoft.sreda.Utility.Operation;
import com.nanosoft.sreda.Utility.ServerResponseOperation;
import com.nanosoft.sreda.Utility.ShowPIECHART;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;
import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_PIECHART_Capacity extends Fragment {

    PieChart pieChart, piechartElectricity;
    PieData data;
    ArrayList<String> xVals;
    ArrayList<Entry> yvalues;
    ServerResponseOperation serverResponseOperation;
    Info_ElectricGenMixChart _infoElectricGenMixChart, _infoElectricGenMixChart1, _infoElectricGenMixChart2, _infoElectricGenMixChart3, _infoElectricGenMixChart4;
    RecyclerView recyclerviewGeneration,recylerCapacityLegend;
    CapacityReportChartAdapterVertical capacityReportChartAdapterVertical;

    private String email,password;
    Activity_Main activityMain;
    List<Info_CapacityData> _InfoCapacityDataList;
    private TextView tvOnGridTotal,tvOffGridTotal,tvAllTotal;

    public Fragment_PIECHART_Capacity() {
        // Required empty public constructor
    }

    EditText testEdi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_piechart_capacity, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _InfoCapacityDataList = new ArrayList<>();


        email = Operation.getString("email","");
        password = Operation.getString("password","");
        serverResponseOperation = new ServerResponseOperation(getContext());


        getCapacityDataFormServer(email,password);
        //getFuelDataFormServer(email,password);

        activityMain = (Activity_Main) getActivity();


        tvOnGridTotal = (TextView)view.findViewById(R.id.tvOnGridTotal);
        tvOffGridTotal = (TextView)view.findViewById(R.id.tvOffGridTotal);
        tvAllTotal = (TextView)view.findViewById(R.id.tvAllTotal);


        recylerCapacityLegend = (RecyclerView) view.findViewById(R.id.recylerCapacityLegend);
        recylerCapacityLegend.setLayoutManager(new LinearLayoutManager(getActivity(), HORIZONTAL, false));

        recyclerviewGeneration = (RecyclerView) view.findViewById(R.id.recyclerviewGeneration);
        recyclerviewGeneration.setLayoutManager(new LinearLayoutManager(getActivity(), VERTICAL, false));
        recyclerviewGeneration.setNestedScrollingEnabled(true);

        pieChart = (PieChart) view.findViewById(R.id.piechartRegeneration);
        piechartElectricity = (PieChart) view.findViewById(R.id.piechartElectricity);


    }


    @Override
    public void onResume() {
        super.onResume();



    }

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

                        capacityReportChartAdapterVertical = new CapacityReportChartAdapterVertical(getContext(), responseInfo.getData(),pieChart);
                        recyclerviewGeneration.setAdapter(capacityReportChartAdapterVertical);


                        recylerCapacityLegend.setAdapter(new CapacitynLegendAdapter(getActivity(),responseInfo.getData()));

                        new ShowPIECHART(getActivity(),pieChart,responseInfo.getData());

//                        for(Info_CapacityData temp:responseInfo.getData()){
//                            Operation.listCapacityData.add(temp);
//                        }

                        double onGridTotal = 0.0,offGridTotal = 0.0,allTotal = 0.0;
                        for(int i = 0; i<responseInfo.getData().size();i++){
                            onGridTotal+=responseInfo.getData().get(i).getOn_grid();
                            offGridTotal+=responseInfo.getData().get(i).getOff_grid();
                            allTotal+=responseInfo.getData().get(i).getTotal();
                        }

                        DecimalFormat precision = new DecimalFormat("0.00");
                        tvOnGridTotal.setText(precision.format(onGridTotal)+"");
                        tvOffGridTotal.setText(precision.format(offGridTotal)+"");
                        tvAllTotal.setText(precision.format(allTotal)+"");
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


}
