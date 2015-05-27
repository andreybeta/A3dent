package com.acarolabs.a3dent.Asyntask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.acarolabs.a3dent.Adapters.BeneficiosAdapter;
import com.acarolabs.a3dent.Models.Beneficios;
import com.acarolabs.a3dent.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by personal on 21/05/15.
 */
public class BeneficiosTask extends AsyncTask<Void,Void,ArrayList<Beneficios>>{

    private Activity activity;



    public BeneficiosTask(Activity activity) {
        super();
        this.activity = activity;
    }
    @Override
    protected ArrayList<Beneficios> doInBackground(Void... voids) {

        URL imageUrl = null;
        HttpURLConnection conn = null;

        ArrayList<Beneficios> bene = new ArrayList<Beneficios>() ;
        try {

            imageUrl = new URL("http://www.innovus.center/images/logofull.jpg");
            conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2; // el factor de escala a minimizar la imagen, siempre es potencia de 2

            Bitmap imagen = BitmapFactory.decodeStream(conn.getInputStream(), new Rect(0, 0, 0, 0), options);
            //img.setImageBitmap(imagen);

            bene.add(new Beneficios("Panomarica dental","10",imagen));
            bene.add(new Beneficios("Radiografia Nueva","30",imagen));
            bene.add(new Beneficios("Radiografia Nueva","30",imagen));
            bene.add(new Beneficios("Radiografia Nueva","30",imagen));
            bene.add(new Beneficios("Radiografia Nueva","30",imagen));
            bene.add(new Beneficios("Radiografia Nueva","30",imagen));
            bene.add(new Beneficios("Radiografia Nueva","30",imagen));
            return bene;

        } catch (IOException e) {

            e.printStackTrace();
        }


/*
            ArrayList<Beneficios> bene = new ArrayList<Beneficios>() ;
        bene.add(new Beneficios("Panomarica dental","10",imagen));
        bene.add(new Beneficios("Radiografia Nueva","30","Radiografia Nueva"));
        bene.add(new Beneficios("Radiografia Nueva","30","Radiografia Nueva"));
        bene.add(new Beneficios("Radiografia Nueva","30","Radiografia Nueva"));
        bene.add(new Beneficios("Radiografia Nueva","30","Radiografia Nueva"));
        bene.add(new Beneficios("Radiografia Nueva","30","Radiografia Nueva"));
        bene.add(new Beneficios("Radiografia Nueva","30","Radiografia Nueva"));
        */

        return bene;

    }
    @Override
    protected void onPostExecute(ArrayList<Beneficios> result) {

        RecyclerView recyclerView = (RecyclerView)  activity.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);//que todo lo optimize
        recyclerView.setAdapter(new BeneficiosAdapter(result, R.layout.row_beneficios,activity));
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));//linear x q es lienas o si no tambn grillas
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
