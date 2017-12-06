package com.nanosoft.sreda.Utility;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.nanosoft.sreda.Model.CapacityData_Info;
import com.nanosoft.sreda.Model.FuelGenerationReportInfo;
import com.nanosoft.sreda.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanosoft-Android on 12/4/2017.
 */

public class ShowPIECHART {

    Context context;
    PieChart pieChart;
    PieChart piechartElectricity;

    List<CapacityData_Info> listCapacityInfo;
    List<FuelGenerationReportInfo> listFuelInfo;
   Activity activity;

    public ShowPIECHART(Context context, PieChart pieChart, List<CapacityData_Info> listCapacityInfo) {
        this.context = context;
        this.pieChart = pieChart;
        this.listCapacityInfo = listCapacityInfo;

        createPIECHARTCapacity();
    }


    public ShowPIECHART(Context context,PieChart piechartElectricity, List<FuelGenerationReportInfo> listFuelInfo,String noData) {
        this.context = context;
        this.piechartElectricity = piechartElectricity;
        this.listFuelInfo = listFuelInfo;

        createFuelPieChart();
    }

    public void createPIECHARTCapacity() {

        PieData data;
        final ArrayList<String> xVals;
        final ArrayList<Integer> colorcode = new ArrayList<>();
        final ArrayList<Entry> yvalues;

        pieChart.setUsePercentValues(true);

        xVals = new ArrayList<String>();
        yvalues = new ArrayList<Entry>();

        for (int i = 0; i < listCapacityInfo.size(); i++) {
            double d = listCapacityInfo.get(i).getTotal();
            float f = (float) d;
            yvalues.add(new Entry(f, i));
            xVals.add(listCapacityInfo.get(i).getTechnology_name());
            int parseColor =(Color.parseColor(listCapacityInfo.get(i).getColor()));
            colorcode.add(parseColor);

        }

        PieDataSet dataSet = new PieDataSet(yvalues, "Election Results");

        data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        pieChart.setData(data);
        pieChart.setDescription("This is Pie Chart");

        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(25f);
        pieChart.setHoleRadius(25f);


        //dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        dataSet.setColors(colorcode);
        data.setValueTextSize(8f);
        data.setValueTextColor(Color.DKGRAY);

        pieChart.animateXY(1400, 1400);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.pie_data_dialogue);
                TextView tvTechName = dialog.findViewById(R.id.tvTechName);
                TextView tvTechDetail = dialog.findViewById(R.id.tvTechDetail);
                tvTechName.setText(xVals.get(e.getXIndex()).toString());
                tvTechDetail.setText(listCapacityInfo.get(e.getXIndex()).getTotal()+"MW");
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(true);
                dialog.setCancelable(true);
                dialog.show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
    }


    public void createFuelPieChart() {

        PieData data = null;
        PieDataSet dataSet = null;
        final ArrayList<String> xVals = new ArrayList<>();
        final ArrayList<Entry> yvalues = new ArrayList<>();
        final ArrayList<Integer> colorcode = new ArrayList<>();
        piechartElectricity.setUsePercentValues(true);


        for (int i = 0; i < listFuelInfo.size(); i++) {
            String d = listFuelInfo.get(i).getInstalled_capacity();
            float f = Float.parseFloat(d);
            yvalues.add(new Entry(f, i));
            xVals.add(listFuelInfo.get(i).getName());
            int parseColor =(Color.parseColor(listFuelInfo.get(i).getColor()));
            colorcode.add(parseColor);
            dataSet = new PieDataSet(yvalues, "");
            data = new PieData(xVals, dataSet);
        }



       // data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        piechartElectricity.setData(data);
        showLegend(piechartElectricity);
        piechartElectricity.invalidate();
//        chart.setData(pieData);
//        showLegend(chart); // !!! MUST BE BEFORE SET DATA !!!
//        chart.invalidate(); // refresh

        piechartElectricity.setDescription("Fuel chart");

        piechartElectricity.setDrawHoleEnabled(true);
        piechartElectricity.setTransparentCircleRadius(25f);
        piechartElectricity.setHoleRadius(25f);


        dataSet.setColors(colorcode);
        data.setValueTextSize(8f);
        data.setValueTextColor(Color.WHITE);

        piechartElectricity.animateXY(1400, 1400);

        piechartElectricity.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.pie_data_dialogue);
                TextView tvTechName = dialog.findViewById(R.id.tvTechName);
                TextView tvTechDetail = dialog.findViewById(R.id.tvTechDetail);
                tvTechName.setText(xVals.get(e.getXIndex()).toString());
                tvTechDetail.setText(listFuelInfo.get(e.getXIndex()).getInstalled_capacity()+"MW");
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setCanceledOnTouchOutside(true);
                dialog.setCancelable(true);
                dialog.show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
    }


    private void showLegend(PieChart chart) {
        Legend l = chart.getLegend();
        l.setWordWrapEnabled(true);
        l.setXEntrySpace(8f);
        l.setYEntrySpace(3f);
        l.setYOffset(3f);
    }


}
