package com.nanosoft.sreda.Fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nanosoft.sreda.Adapter.LargeProjectAdapter;
import com.nanosoft.sreda.Model.Info_Large_Database_Report;
import com.nanosoft.sreda.R;
import com.nanosoft.sreda.Utility.Api;
import com.nanosoft.sreda.Utility.Operation;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

/**
 * Created by NanoSoft on 1/1/2018.
 */

public class Fragment_Large_Project_Map extends Fragment{

    private List <String> listFinance = new ArrayList<>();
    private List <String> listTechno = new ArrayList<String>();
    private List <String> listLocation = new ArrayList<>();
    private Spinner techWiseSpinner,locationSpinner,financialSpinner,userSpinner,presentStatusSpinner;
    private RecyclerView recyclerviewLarge;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.large_db_map, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi();
        //addView();
    }

    private void addView() {
        // Parent layout
        LinearLayout parentLayout = (LinearLayout)getView().findViewById(R.id.displayLinear);


        for (int i = 0; i < 7; i++) {

            TextView textView = new TextView(getActivity());
            textView.setText("Row " + i);
            parentLayout.addView(textView);
        }
    }

    private void initUi() {

        techWiseSpinner = (Spinner)getView().findViewById(R.id.techWiseSpinner);
        locationSpinner = (Spinner)getView().findViewById(R.id.locationSpinner);
        financialSpinner = (Spinner)getView().findViewById(R.id.financialSpinner);
        userSpinner = (Spinner)getView().findViewById(R.id.userSpinner);
        presentStatusSpinner = (Spinner)getView().findViewById(R.id.presentStatusSpinner);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_spinner_item,listTechno);
        recyclerviewLarge = (RecyclerView)getView().findViewById(R.id.recyclerviewLarge);
        recyclerviewLarge.setLayoutManager(new LinearLayoutManager(getActivity(), VERTICAL, false));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.financial_year_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinnerFormYear.setAdapter(adapter);

        String email = Operation.getString("email","");
        String password = Operation.getString("password","");
        getLargeProjectReportFromServer(email, password);
    }

    public void getLargeProjectReportFromServer(String email, final String password) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);
        Call<Info_Large_Database_Report> call = api.getLargeProjectReport(email,password);

        call.enqueue(new Callback<Info_Large_Database_Report>() {
            @Override
            public void onResponse(Call<Info_Large_Database_Report> call, Response<Info_Large_Database_Report> response) {
                Info_Large_Database_Report data = response.body();


                Log.e("getReReport",""+data.getReReport().length);
                data.getReReport()[0].getProject_name();
                LargeProjectAdapter largeProjectAdapter = new LargeProjectAdapter(getActivity(),data.getReReport());
                recyclerviewLarge.setAdapter(largeProjectAdapter);
                listTechno.add(0,"Technology");
                for(int i = 0; i< data.getReReport().length;i++){
                    listFinance.add(data.getReReport()[i].getFinance_name());
                    listLocation.add(data.getReReport()[i].getFinance_name());
                    listTechno.add(data.getReReport()[i].getTech_name()+"");
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                        R.layout.simple_spinner_item,listTechno);
                techWiseSpinner.setAdapter(adapter);



                LinearLayout parentLayout = (LinearLayout)getView().findViewById(R.id.displayLinear);
                for (int i = 0; i < data.getResults().getTechnologies().length; i++) {

                    TextView textView = new TextView(getActivity());
                    textView.setText(data.getResults().getTechnologies()[i]);
                    parentLayout.addView(textView);
                }
            }

            @Override
            public void onFailure(Call<Info_Large_Database_Report> call, Throwable t) {
                Toast.makeText(getActivity(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                // busyNow.dismis();
            }
        });
    }

}
