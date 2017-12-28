package com.nanosoft.sreda.Fragement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.nanosoft.sreda.Adapter.TechNamesReportAdapter;
import com.nanosoft.sreda.Adapter.TechNamesReportAdapterHorizontal;
import com.nanosoft.sreda.Model.Info_GetTechnologyNames;
import com.nanosoft.sreda.Model.Info_GetTechnologyNamesData;
import com.nanosoft.sreda.Model.Info_TechWiseGenReportData;
import com.nanosoft.sreda.Model.Info_TechWiseGenReportResponse;
import com.nanosoft.sreda.Model.Info_TechWiseGenReportSubCategory;
import com.nanosoft.sreda.R;
import com.nanosoft.sreda.Utility.Api;
import com.nanosoft.sreda.Utility.Operation;
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
public class Fragment_TechNamesReport_horizintal extends Fragment {


    Spinner techWiseSpinner;
    private PieChart pieChartTechno;
    public Fragment_TechNamesReport_horizintal() {
        // Required empty public constructor
    }
    private RecyclerView recyclerviewTechHorizontal,recylerTechnoLegend;
    private TechNamesReportAdapterHorizontal techNamesReportAdapter;
    private Info_TechWiseGenReportResponse Info_TechWiseGenReportResponse;
    //ArrayList<Info_TechWiseGenReportData> catagories = new ArrayList<>();
   // private ArrayList<Info_TechWiseGenReportData> infoTecReportList;
    private ArrayList<Info_TechWiseGenReportData> filterTecReporList;
    //private TextView tvNumSys,tvtOnGrid,tvOffGrid,tvToe,tvTotal;
    private String email,password;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tecnology_report_horizontal, container, false);
    }
    List<Info_TechWiseGenReportSubCategory> listTechnoInfo= new ArrayList<>();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi();
    }

    private void initUi() {

        filterTecReporList =new ArrayList<>();

        pieChartTechno = (PieChart)getView().findViewById(R.id.pieChartTechno);
        recyclerviewTechHorizontal=(RecyclerView)getView().findViewById(R.id.recyclerviewTechHorizontal);
        recylerTechnoLegend=(RecyclerView)getView().findViewById(R.id.recylerTechnoLegend);
        recylerTechnoLegend.setLayoutManager(new LinearLayoutManager(getActivity(), HORIZONTAL, false));

        techWiseSpinner=(Spinner)getView().findViewById(R.id.techWiseSpinner);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), VERTICAL, false);
        recyclerviewTechHorizontal.setLayoutManager(layoutManager);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                layoutManager.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.divider_line));

        recyclerviewTechHorizontal.addItemDecoration(dividerItemDecoration);

        email = Operation.getString("email","");
        password = Operation.getString("password","");


        //serverResponseOperation.getCapacityDataFormServer(email,password);
        getTechnologyNameFromServer(email,password);
        getTechnologyNameReportFromServer(email,password);




        techWiseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                filterTecReporList.clear();
                listTechnoInfo.clear();

                if (i>0) {

                    for (int j = 0; j < Info_TechWiseGenReportResponse.getData().size(); j++) {
                        if (Info_TechWiseGenReportResponse.getData().get(j).getTechnology_name().equalsIgnoreCase(techWiseSpinner.getSelectedItem().toString())) {
                            filterTecReporList.add(Info_TechWiseGenReportResponse.getData().get(j));
                            for (int k = 0; k <filterTecReporList.get(j).getSub_category().size() ; k++) {
                                listTechnoInfo.add(filterTecReporList.get(j).getSub_category().get(k));
                            }
                        }


                    }

                    setDataFromServer(filterTecReporList);

//                    for (int j = 0; j < filterTecReporList.size(); j++) {
//                        for (int k = 0; k <filterTecReporList.get(j).getSub_category().size() ; k++) {
//                            listTechnoInfo.add(filterTecReporList.get(j).getSub_category().get(k));
//                        }
//                    }

                    if(listTechnoInfo.size()>0){
                        new ShowPIECHART(getActivity(),pieChartTechno,listTechnoInfo,"","");
                    }else {
                        pieChartTechno.setVisibility(View.GONE);
                        recylerTechnoLegend.setVisibility(View.GONE);
                    }


                }else if(i==0){
                    setDataFromServer(Info_TechWiseGenReportResponse.getData());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void getTechnologyNameFromServer(String email, final String password) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);
        Call<Info_GetTechnologyNames> call = api.getTechnologyName(email,password);

        call.enqueue(new Callback<Info_GetTechnologyNames>() {
            @Override
            public void onResponse(Call<Info_GetTechnologyNames> call, Response<Info_GetTechnologyNames> response) {
                Info_GetTechnologyNames responseInfo = response.body();



                if(responseInfo.getStatus()==2000){



                    // Spinner Drop down elements
                    List<String> categories = new ArrayList<String>();
                    categories.add(0,"Select an Option");
                    for(Info_GetTechnologyNamesData temp:responseInfo.getData()){
                      categories.add(temp.getName());
                    }
                    // Creating adapter for spinner
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

                    // Drop down layout style - list view with radio button
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    // attaching data adapter to spinner
                    techWiseSpinner.setAdapter(dataAdapter);




                }


            }

            @Override
            public void onFailure(Call<Info_GetTechnologyNames> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

                // busyNow.dismis();
            }
        });
    }
    public void getTechnologyNameReportFromServer(String email, final String password) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);
        Call<Info_TechWiseGenReportResponse> call = api.getTechnologyNameReport(email,password);

        call.enqueue(new Callback<Info_TechWiseGenReportResponse>() {
            @Override
            public void onResponse(Call<Info_TechWiseGenReportResponse> call, Response<Info_TechWiseGenReportResponse> response) {
                Info_TechWiseGenReportResponse = response.body();



                if(Info_TechWiseGenReportResponse.getStatus()==2000){

                    setDataFromServer(Info_TechWiseGenReportResponse.getData());

                }

            }

            @Override
            public void onFailure(Call<Info_TechWiseGenReportResponse> call, Throwable t) {
                Toast.makeText(getActivity(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                // busyNow.dismis();
            }
        });
    }


    private void setDataFromServer(List<Info_TechWiseGenReportData> listData ) {
       // catagories.clear();

        int numsys = 0;
        double ongrid = 0;
        double offgrid = 0;
        double toe = 0;
        double total = 0;
        for(int i= 0;i<listData.size();i++){
            //catagories.add(Info_TechWiseGenReportResponse.getData().get(i));
            //infoTecReportList.add(Info_TechWiseGenReportResponse.getData().get(i));

            for(int j= 0;j<listData.get(i).getSub_category().size();j++){
                numsys+= listData.get(i).getSub_category().get(j).getNo_on_system();
                ongrid+=listData.get(i).getSub_category().get(j).getOn_grid();
                offgrid+=listData.get(i).getSub_category().get(j).getOff_grid();
                toe+=listData.get(i).getSub_category().get(j).getToe();
                total+=listData.get(i).getSub_category().get(j).getTotal();
            }
        }
//        DecimalFormat precision = new DecimalFormat("0.00");
//        tvNumSys.setText("Number of system\n"+numsys);
//        tvtOnGrid.setText("On Grid\n"+precision.format(ongrid)+" MW");
//        tvOffGrid.setText("OffGrid\n"+precision.format(offgrid)+" MW");
//        tvToe.setText("Toe\n"+precision.format(toe)+" MW");
//        tvTotal.setText("Total\n"+precision.format(total)+" MW");

        //Toast.makeText(getActivity(), "sys: "+numsys, Toast.LENGTH_SHORT).show();

        techNamesReportAdapter=new TechNamesReportAdapterHorizontal(getContext(), listData);
        recyclerviewTechHorizontal.setAdapter(techNamesReportAdapter);
        techNamesReportAdapter.notifyDataSetChanged();


    }

}
