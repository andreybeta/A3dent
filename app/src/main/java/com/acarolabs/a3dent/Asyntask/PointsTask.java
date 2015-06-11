package com.acarolabs.a3dent.Asyntask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.acarolabs.a3dent.Adapters.PointsAdapter;
import com.acarolabs.a3dent.AppConstants;
import com.acarolabs.a3dent.Models.Point;
import com.acarolabs.a3dent.Models.Rewards;
import com.acarolabs.a3dent.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by personal on 24/05/15.
 */
public class PointsTask extends AsyncTask<Void, Void, ArrayList<Point>> {

    private Activity activity;
    private final String LOG_TAG = RewardsTask.class.getSimpleName();


    public PointsTask(Activity activity) {
        super();
        this.activity = activity;
    }

    @Override
    protected ArrayList<Point> doInBackground(Void... voids) {


        /* pruebas sin internet
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(1, "Panomarica dental", "10", 10));
        points.add(new Point(1, "Radiografia maxo", "10", 10));
        points.add(new Point(1, "Prueba 2", "10", 10));



        return points;
        */


        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;


        // Will contain the raw JSON response as a string.
        String forecastJsonStr = null;

/*
        ArrayList<Rewards> rewardsTemp = new ArrayList<Rewards>();
        rewardsTemp.add(new Rewards(1,"Panomarica dental","kdfkdfkfdkfdk",10));
        rewardsTemp.add(new Rewards(1,"Panomarica dental","kdfkdfkfdkfdk",10));
        rewardsTemp.add(new Rewards(1,"Panomarica dental","kdfkdfkfdkfdk",10));

        return rewardsTemp;*/
        try {

            URL url = new URL(AppConstants.serverUrl + "api/v1/points" + "?token="+AppConstants.token);

            // Create the request to OpenWeatherMap, and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }
            forecastJsonStr = buffer.toString();
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attemping
            // to parse it.
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(LOG_TAG, "Error closing stream", e);
                }
            }
        }
        try {
            return getListPoints(forecastJsonStr);

        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            e.printStackTrace();
        }
        return null;

    }





    @Override
    protected void onPostExecute(ArrayList<Point> result) {

        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.my_recycler_view_point);
        recyclerView.setHasFixedSize(true);//que todo lo optimize
        recyclerView.setAdapter(new PointsAdapter(result, R.layout.row_points, activity));
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));//linear x q es lienas o si no tambn grillas
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public static ArrayList<Point> getListPoints(String jsonStr) throws JSONException {

        ArrayList<Point> pointsTemp = new ArrayList<Point>();

        //JSONObject mJsonObject = new JSONObject(jsonStr);
        JSONArray mJsonArrayProperty = new JSONArray(jsonStr);
        //JSONObject mJsonObject = mJsonArray.getJSONObject(0);

        // JSONArray mJsonArrayProperty = mJsonObject.getJSONArray("data");
        for (int i = 0; i < mJsonArrayProperty.length(); i++) {
            JSONObject pointJson = mJsonArrayProperty.getJSONObject(i);

            int id = pointJson.getInt("id");
            int service = pointJson.getInt("service_id");
            String notes = pointJson.getString("notes");
            int bonus = pointJson.getInt("bonus");
            int points = pointJson.getInt("points");

            //String imgUrl = pointJson.getString("image_url");


            Point point = new Point(id,service, notes, bonus, points);
            //rewards.setImgUrl(imgUrl);
           /* Bitmap imagen = null;
            URL imageUrl = null;
            HttpURLConnection conn = null;

            try {
                if (imgUrl.equals("null")) {

                } else {
                    imageUrl = new URL(imgUrl);
                    conn = (HttpURLConnection) imageUrl.openConnection();
                    conn.connect();

                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 1; // el factor de escala a minimizar la imagen, siempre es potencia de 2

                    imagen = BitmapFactory.decodeStream(conn.getInputStream(), new Rect(0, 0, 0, 0), options);
                    // mIcon11 = BitmapFactory.decodeStream((InputStream) new URL(imgUrl).getContent());
                    point.setImage(imagen);

                }
                rewardsTemp.add(point);


            } catch (Exception e) {
                //Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            */
            pointsTemp.add(point);

        }


        return pointsTemp;

    }
}
