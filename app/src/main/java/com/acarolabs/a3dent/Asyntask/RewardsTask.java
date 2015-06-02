package com.acarolabs.a3dent.Asyntask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.acarolabs.a3dent.Adapters.RewardsAdapter;
import com.acarolabs.a3dent.Models.Rewards;
import com.acarolabs.a3dent.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by personal on 21/05/15.
 */
public class RewardsTask extends AsyncTask<Void,Void,ArrayList<Rewards>>{

    private Activity activity;



    public RewardsTask(Activity activity) {
        super();
        this.activity = activity;
    }
    @Override
    protected ArrayList<Rewards> doInBackground(Void... voids) {

        URL imageUrl = null;
        HttpURLConnection conn = null;

        ArrayList<Rewards> bene = new ArrayList<Rewards>() ;
        try {

            imageUrl = new URL("http://3dent.acarolabs.com/vendor/nova-theme/images/logo.png");
            conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2; // el factor de escala a minimizar la image, siempre es potencia de 2

            Bitmap imagen = BitmapFactory.decodeStream(conn.getInputStream(), new Rect(0, 0, 0, 0), options);
            //img.setImageBitmap(image);

            bene.add(new Rewards("Panomarica dental","10",imagen));
            bene.add(new Rewards("Radiografia Nueva","30",imagen));
            bene.add(new Rewards("Radiografia Nueva","30",imagen));
            bene.add(new Rewards("Radiografia Nueva","30",imagen));
            bene.add(new Rewards("Radiografia Nueva","30",imagen));
            bene.add(new Rewards("Radiografia Nueva","30",imagen));
            bene.add(new Rewards("Radiografia Nueva","30",imagen));
            return bene;

        } catch (IOException e) {

            e.printStackTrace();
        }



        return bene;

    }
    @Override
    protected void onPostExecute(ArrayList<Rewards> result) {

        RecyclerView recyclerView = (RecyclerView)  activity.findViewById(R.id.my_recycler_view_rewards);
        recyclerView.setHasFixedSize(true);//que todo lo optimize
        recyclerView.setAdapter(new RewardsAdapter(result, R.layout.row_rewards,activity));
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));//linear x q es lienas o si no tambn grillas
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
