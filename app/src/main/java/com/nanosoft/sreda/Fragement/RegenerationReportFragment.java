package com.nanosoft.sreda.Fragement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.nanosoft.sreda.Adapter.ReGenerationAdapter;
import com.nanosoft.sreda.Model.ReGeneration_Info;
import com.nanosoft.sreda.R;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;


/**
 * Created by User on 7/20/2016.
 */
public class RegenerationReportFragment extends Fragment {
    Context con;
    RecyclerView recyclerView;
    // View view;
    private RecyclerView recycler_view;
    private ReGenerationAdapter adapter;
    private ArrayList<ReGeneration_Info> reGenerationInfos = new ArrayList<>();

    private Toolbar toolbar;
    private Toolbar searchToolbar;
    private boolean isSearch = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.report_regeneration, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(isSearch ? R.menu.menu_search_toolbar : R.menu.menu_main, menu);
        if (isSearch) {
            inflater.inflate(R.menu.menu_search_toolbar, menu);
            final SearchView search = (SearchView) menu.findItem(R.id.action_search).getActionView();
            search.setIconified(false);
            search.setQueryHint("Search item...");

            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    adapter.getFilter().filter(s);
                    return true;
                }
            });
            search.setOnCloseListener(new SearchView.OnCloseListener() {
                @Override
                public boolean onClose() {
                    closeSearch();
                    return true;
                }
            });

        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search: {
                isSearch = true;
                searchToolbar.setVisibility(View.VISIBLE);
                prepareActionBar(searchToolbar);
                ((AppCompatActivity) getActivity()).supportInvalidateOptionsMenu();
                return true;
            }
            case android.R.id.home:
                closeSearch();
                //NavUtils.navigateUpFromSameTask(getActivity());
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void closeSearch() {
        if (isSearch) {
            isSearch = false;
            prepareActionBar(toolbar);
            searchToolbar.setVisibility(View.GONE);
            ((AppCompatActivity) getActivity()).supportInvalidateOptionsMenu();

        }
    }

    private void prepareActionBar(Toolbar toolbar) {

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("");
        //actionBar.setIcon(R.drawable.playstore_icon);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar_viewpager);
        searchToolbar = (Toolbar) view.findViewById(R.id.toolbar_search);

        con = getActivity();
     //   ReGeneration_Info h1 = new ReGeneration_Info();
      //  ReGeneration_Info h0 = new ReGeneration_Info(0, "F Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h2 = new ReGeneration_Info(1, "F Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h3 = new ReGeneration_Info(2, "G Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h4 = new ReGeneration_Info(3, "H Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h5 = new ReGeneration_Info(4, "I Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h6 = new ReGeneration_Info(5, "J Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h7 = new ReGeneration_Info(6, "L Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h8 = new ReGeneration_Info(7, "Middle Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h9 = new ReGeneration_Info(8, "A Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h10 = new ReGeneration_Info(9, "B Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h11 = new ReGeneration_Info(10, "C Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h12 = new ReGeneration_Info(11, "D Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");
        ReGeneration_Info h13 = new ReGeneration_Info(12, "E Name", "Solar", "2334r", "rup pur", "japan", "12/12/2017", "On working");


        //reGenerationInfos.add(h0);
       // reGenerationInfos.add(h1);
        reGenerationInfos.add(h2);
        reGenerationInfos.add(h3);
        reGenerationInfos.add(h4);

        reGenerationInfos.add(h5);
        reGenerationInfos.add(h6);
        reGenerationInfos.add(h7);
        reGenerationInfos.add(h8);
        reGenerationInfos.add(h9);

        reGenerationInfos.add(h10);
        reGenerationInfos.add(h11);
        reGenerationInfos.add(h12);
        reGenerationInfos.add(h13);
//        reGenerationInfos.add(h7);
//        reGenerationInfos.add(h8);
//
//        reGenerationInfos.add(h9);
//        reGenerationInfos.add(h10);
//        reGenerationInfos.add(h11);
//        reGenerationInfos.add(h12);

        recycler_view = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), HORIZONTAL, false);
        recycler_view.setLayoutManager(layoutManager);
        // recycler_view.setMinimumWidth(200);
        //  recycler_view.setNestedScrollingEnabled(false);
        //recycler_view.addItemDecoration(new SimpleDividerItemDecoration(con));
        adapter = new ReGenerationAdapter(reGenerationInfos, R.layout.raw_regen_report, con);
        recycler_view.setAdapter(adapter);
        prepareActionBar(toolbar);
    }


}
