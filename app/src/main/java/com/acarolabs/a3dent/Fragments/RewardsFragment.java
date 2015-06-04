package com.acarolabs.a3dent.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acarolabs.a3dent.Adapters.RewardsAdapter;
import com.acarolabs.a3dent.Asyntask.RewardsTask;
import com.acarolabs.a3dent.Models.Rewards;
import com.acarolabs.a3dent.R;

import java.util.ArrayList;


/**
 * Created by hp1 on 21-01-2015.
 */
public class RewardsFragment extends android.support.v4.app.Fragment {

    RewardsAdapter rewardsAdapter;
    RecyclerView recyclerView;

    public RewardsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_rewards,container,false);
        return v;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        ArrayList<Rewards> rewardsArrayList = new ArrayList<Rewards>();

        //beneficiosArrayList.add(new Beneficios("hola","10","esta"));


        /*
        creamos arraylist purbea
         */

       // beneficiosArrayList.add(new Beneficios("hola","10","esta"));
        new RewardsTask(this.getActivity()).execute();

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_rewards);
        recyclerView.setHasFixedSize(true);//que todo lo optimize
        //crea adaptador
        rewardsAdapter = new RewardsAdapter(rewardsArrayList,R.layout.row_rewards,getActivity());
        recyclerView.setAdapter(rewardsAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//linear x q es lienas o si no tambn grillas
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //new BeneficiosTask(this.getActivity()).execute();
        //new RewardsTask(this.getActivity()).execute();



    }
}

