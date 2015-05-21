package com.acarolabs.a3dent.Asyntask;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.acarolabs.a3dent.Adapters.BeneficiosAdapter;
import com.acarolabs.a3dent.Models.Beneficios;
import com.acarolabs.a3dent.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by personal on 21/05/15.
 */
public class BeneficiosTask extends AsyncTask<Void,Void,List<Beneficios>>{

    private Activity activity;



    public BeneficiosTask(Activity activity) {
        super();
        this.activity = activity;
    }
    @Override
    protected List<Beneficios> doInBackground(Void... voids) {


        List<Beneficios> bene = new ArrayList<Beneficios>() ;
        bene.add(new Beneficios("hola","10","esta"));
        return bene;
    }
    @Override
    protected void onPostExecute(List<Beneficios> result) {

        RecyclerView recyclerView = (RecyclerView)  activity.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);//que todo lo optimize
        recyclerView.setAdapter(new BeneficiosAdapter(result, R.layout.row_beneficios,activity));
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));//linear x q es lienas o si no tambn grillas
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}