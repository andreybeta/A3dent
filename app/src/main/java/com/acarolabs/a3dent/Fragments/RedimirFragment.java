package com.acarolabs.a3dent.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acarolabs.a3dent.Adapters.RedimirAdapters;
import com.acarolabs.a3dent.Models.Redimir;
import com.acarolabs.a3dent.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RedimirFragment extends Fragment {


    public RedimirFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_redimir, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<Redimir> redimirArrayList = new ArrayList<>();
        Redimir redimir = new Redimir();
        redimir.setPoint("50");
        redimir.setAux("10");
        redimir.setText("Redimir en ...........................");
        redimirArrayList.add(redimir);
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_redimir);
        recyclerView.setHasFixedSize( true);
        recyclerView.setAdapter(new RedimirAdapters(redimirArrayList,R.layout.row_redimir));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }




}
