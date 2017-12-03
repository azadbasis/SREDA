package com.nanosoft.sreda.Fragement;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.nanosoft.sreda.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PIECHARTFragment extends Fragment implements OnChartValueSelectedListener {

    PieChart pieChart;
    PieData data;
    ArrayList<String> xVals;
    ArrayList<Entry> yvalues;
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pieChart = (PieChart)view.findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        yvalues = new ArrayList<Entry>();


        yvalues.add(new Entry(88f, 0));
        yvalues.add(new Entry(54f, 1));
        yvalues.add(new Entry(53.56f, 2));
        /*yvalues.add(new Entry(8f, 0));
        yvalues.add(new Entry(15f, 1));
        yvalues.add(new Entry(12f, 2));
        yvalues.add(new Entry(25f, 3));
        yvalues.add(new Entry(23f, 4));
        yvalues.add(new Entry(17f, 5));*/

        PieDataSet dataSet = new PieDataSet(yvalues, "Election Results");

        xVals = new ArrayList<String>();

        xVals.add(" Biogas to Electricity");
        xVals.add("Biomass to Electricity");
        xVals.add("Hydro");

 /*       xVals.add("January");
        xVals.add("February");
        xVals.add("March");
        xVals.add("April");
        xVals.add("May");
        xVals.add("June");*/

        data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        pieChart.setData(data);
        pieChart.setDescription("This is Pie Chart");

        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(25f);
        pieChart.setHoleRadius(25f);

        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.DKGRAY);
        pieChart.setOnChartValueSelectedListener(this);

        pieChart.animateXY(1400, 1400);

    }

    @Override
    public void onValueSelected(Entry e, int position, Highlight h) {

        // highlight the entry and x-position 50 in the first (0) DataSet
        h = new Highlight(50, 0);

        pieChart.highlightValue(h, true); // h
        if (e == null)
            return;
        Log.e("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + data.getDataSetByIndex(position));

        Dialog dialog= new Dialog(getActivity());
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
