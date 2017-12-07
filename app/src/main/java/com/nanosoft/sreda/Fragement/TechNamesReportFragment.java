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
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.nanosoft.sreda.Adapter.TechNamesReportAdapter;
import com.nanosoft.sreda.Model.GetTechnologyNamesData_Info;
import com.nanosoft.sreda.Model.GetTechnologyNames_Info;
import com.nanosoft.sreda.Model.Info_TechWiseGenReportResponse;
import com.nanosoft.sreda.Model.TechWiseGenReportData_Info;
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

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;
import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechNamesReportFragment extends Fragment {


    Spinner techWiseSpinner;
    public TechNamesReportFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerviewTechWise;
    private TechNamesReportAdapter techNamesReportAdapter;
    private Info_TechWiseGenReportResponse _infoTechWiseGenReportResponse;
    private ArrayList<Info_TechWiseGenReportResponse> _infoTechWiseGenReportResponseArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tchno_parent, container, false);
    }
        String email,password;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _infoTechWiseGenReportResponseArrayList =new ArrayList<>();
        recyclerviewTechWise=(RecyclerView)view.findViewById(R.id.recyclerviewTechWise);
        techWiseSpinner=(Spinner)view.findViewById(R.id.techWiseSpinner);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), VERTICAL, false);
        recyclerviewTechWise.setLayoutManager(layoutManager);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                layoutManager.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.divider_line));

        recyclerviewTechWise.addItemDecoration(dividerItemDecoration);

        email = Operation.getString("email","");
        password = Operation.getString("password","");


        //serverResponseOperation.getCapacityDataFormServer(email,password);
        getTechnologyNameFromServer(email,password);
        getTechnologyNameReportFromServer(email,password);
    }



    public void getTechnologyNameFromServer(String email, final String password) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);
        Call<GetTechnologyNames_Info> call = api.getTechnologyName(email,password);

        call.enqueue(new Callback<GetTechnologyNames_Info>() {
            @Override
            public void onResponse(Call<GetTechnologyNames_Info> call, Response<GetTechnologyNames_Info> response) {
                GetTechnologyNames_Info responseInfo = response.body();



                if(responseInfo.getStatus()==2000){

                    Toast.makeText(getActivity(), "Tecnology"+responseInfo.getStatus(), Toast.LENGTH_SHORT).show();

                    // Spinner Drop down elements
                    List<String> categories = new ArrayList<String>();
                    categories.add(0,"Select an Option");
                    for(GetTechnologyNamesData_Info temp:responseInfo.getData()){
                      categories.add(temp.getName());
                    }
                    // Creating adapter for spinner
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

                    // Drop down layout style - list view with radio button
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    // attaching data adapter to spinner
                    techWiseSpinner.setAdapter(dataAdapter);


                }

                Toast.makeText(getActivity(), ""+responseInfo.getData().size(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<GetTechnologyNames_Info> call, Throwable t) {
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
                Info_TechWiseGenReportResponse responseInfo = response.body();



                if(responseInfo.getStatus()==2000){

                    ArrayList<TechWiseGenReportData_Info> catagories = new ArrayList<>();
                    Toast.makeText(getActivity(), "Tecnology"+responseInfo.getStatus(), Toast.LENGTH_SHORT).show();

                    for(int i= 0;i<responseInfo.getData().size();i++){
                        catagories.add(responseInfo.getData().get(i));
                    }

                    techNamesReportAdapter=new TechNamesReportAdapter(getContext(), catagories);
                    recyclerviewTechWise.setAdapter(techNamesReportAdapter);


                }




            }

            @Override
            public void onFailure(Call<Info_TechWiseGenReportResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

                // busyNow.dismis();
            }
        });
    }

}
