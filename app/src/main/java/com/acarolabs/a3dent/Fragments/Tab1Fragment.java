package com.acarolabs.a3dent.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acarolabs.a3dent.Adapters.BeneficiosAdapter;
import com.acarolabs.a3dent.Models.Beneficios;
import com.acarolabs.a3dent.R;

import java.util.ArrayList;


/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab1Fragment extends Fragment {

    BeneficiosAdapter beneficiosAdapter;
    RecyclerView recyclerView;

    public Tab1Fragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_1,container,false);
        return v;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        ArrayList<Beneficios> beneficiosArrayList = new ArrayList<Beneficios>();

        /*
        creamos arraylist purbea
         */

        beneficiosArrayList.add(new Beneficios("hola","10","esta"));

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);//que todo lo optimize
        //crea adaptador
        beneficiosAdapter = new BeneficiosAdapter(beneficiosArrayList,R.layout.row_beneficios,getActivity());
        recyclerView.setAdapter(beneficiosAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//linear x q es lienas o si no tambn grillas
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}

