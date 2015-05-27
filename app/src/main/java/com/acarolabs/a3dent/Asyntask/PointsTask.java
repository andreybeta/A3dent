package com.acarolabs.a3dent.Asyntask;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.acarolabs.a3dent.Adapters.PointsAdapter;
import com.acarolabs.a3dent.Models.Point;
import com.acarolabs.a3dent.R;

import java.util.ArrayList;

/**
 * Created by personal on 24/05/15.
 */
public class PointsTask extends AsyncTask<Void, Void, ArrayList<Point>> {

    private Activity activity;


    public PointsTask(Activity activity) {
        super();
        this.activity = activity;
    }

    @Override
    protected ArrayList<Point> doInBackground(Void... voids) {


        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(1, "Panomarica dental", "10", 10));
        points.add(new Point(1, "Radiografia maxo", "10", 10));
        points.add(new Point(1, "Prueba 2", "10", 10));



        return points;
    }

    @Override
    protected void onPostExecute(ArrayList<Point> result) {

        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.my_recycler_view_point);
        recyclerView.setHasFixedSize(true);//que todo lo optimize
        recyclerView.setAdapter(new PointsAdapter(result, R.layout.row_points, activity));
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));//linear x q es lienas o si no tambn grillas
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
