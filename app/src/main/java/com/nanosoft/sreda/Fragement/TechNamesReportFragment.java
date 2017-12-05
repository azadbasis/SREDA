package com.nanosoft.sreda.Fragement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nanosoft.sreda.Adapter.TechNamesReportAdapter;
import com.nanosoft.sreda.Model.TechWiseGenReport_Info;
import com.nanosoft.sreda.R;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechNamesReportFragment extends Fragment {


    public TechNamesReportFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerviewTechWise;
    private TechNamesReportAdapter techNamesReportAdapter;
    private TechWiseGenReport_Info techWiseGenReport_info;
    private ArrayList<TechWiseGenReport_Info> techWiseGenReport_infoArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_technology_names_report, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        techWiseGenReport_infoArrayList=new ArrayList<>();
        recyclerviewTechWise=(RecyclerView)view.findViewById(R.id.recyclerviewTechWise);
        recyclerviewTechWise.setLayoutManager(new LinearLayoutManager(getActivity(), HORIZONTAL, false));

        techNamesReportAdapter=new TechNamesReportAdapter(getContext(),techWiseGenReport_infoArrayList);
        recyclerviewTechWise.setAdapter(techNamesReportAdapter);
    }
}
