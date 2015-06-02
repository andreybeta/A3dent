package com.acarolabs.a3dent.Fragments;

/**
 * Created by personal on 21/05/15.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acarolabs.a3dent.Adapters.PointsAdapter;
import com.acarolabs.a3dent.Asyntask.PointsTask;
import com.acarolabs.a3dent.Models.Point;

import com.acarolabs.a3dent.R;

import java.util.ArrayList;

public class PointsFragment extends Fragment {

    PointsAdapter PointsAdapter;
    RecyclerView recyclerView;

    public PointsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_point,container,false);
        return v;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        ArrayList<Point> PointsArrayList = new ArrayList<Point>();


        new PointsTask(this.getActivity()).execute();

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_point);
        recyclerView.setHasFixedSize(true);//que todo lo optimize
        //crea adaptador
        PointsAdapter = new PointsAdapter(PointsArrayList,R.layout.row_points,getActivity());
        recyclerView.setAdapter(PointsAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//linear x q es lienas o si no tambn grillas
        recyclerView.setItemAnimator(new DefaultItemAnimator());





    }
}
