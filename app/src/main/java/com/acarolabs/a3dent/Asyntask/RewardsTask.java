package com.acarolabs.a3dent.Asyntask;

import android.app.Activity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

import com.acarolabs.a3dent.Adapters.RewardsAdapter;
import com.acarolabs.a3dent.AppConstants;
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

import com.acarolabs.a3dent.AppConstants.*;

/**
 * Created by personal on 21/05/15.
 */
public class RewardsTask extends AsyncTask<Void, Void, ArrayList<Rewards>> {

    private Activity activity;
    private final String LOG_TAG = RewardsTask.class.getSimpleName();
    ProgressDialog progressDialog;


    public RewardsTask(Activity activity) {
        super();
        this.activity = activity;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(activity, "Espera", "Descargando...");
    }

    @Override
    protected ArrayList<Rewards> doInBackground(Void... voids) {


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

            URL url = new URL(AppConstants.serverUrl + "api/v1/rewards" + "?token="+AppConstants.token);

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
            return getListRewards(forecastJsonStr);

        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            e.printStackTrace();
        }
        return null;

    }





/*
            imageUrl = new URL("http://www.innovus.center/images/logofull.jpg");
           // imageUrl = new URL("http://3dent.acarolabs.com/vendor/nova-theme/images/logo.png");
            conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2; // el factor de escala a minimizar la image, siempre es potencia de 2

            Bitmap imagen = BitmapFactory.decodeStream(conn.getInputStream(), new Rect(0, 0, 0, 0), options);
            //img.setImageBitmap(image);
            */
/*
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
        */


    @Override
    protected void onPostExecute(ArrayList<Rewards> result) {
        progressDialog.dismiss();


        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.my_recycler_view_rewards);
        recyclerView.setHasFixedSize(true);//que todo lo optimize
        recyclerView.setAdapter(new RewardsAdapter(result, R.layout.row_rewards, activity));
        //////////


        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = activity.getResources().getDisplayMetrics().density;
        float dpWidth = outMetrics.widthPixels / density;
        int columns = Math.round(dpWidth / 300);
        recyclerView.setLayoutManager(new GridLayoutManager(activity, columns));


        /////
      /*  recyclerView.setLayoutManager(new LinearLayoutManager(activity));//linear x q es lienas o si no tambn grillas
        recyclerView.setItemAnimator(new DefaultItemAnimator());*/
    }

    public static ArrayList<Rewards> getListRewards(String jsonStr) throws JSONException {

        ArrayList<Rewards> rewardsTemp = new ArrayList<Rewards>();

        //JSONObject mJsonObject = new JSONObject(jsonStr);
        JSONArray mJsonArrayProperty = new JSONArray(jsonStr);
        //JSONObject mJsonObject = mJsonArray.getJSONObject(0);

        // JSONArray mJsonArrayProperty = mJsonObject.getJSONArray("data");
        for (int i = 0; i < mJsonArrayProperty.length(); i++) {
            JSONObject rewardsJson = mJsonArrayProperty.getJSONObject(i);

            if (rewardsJson.getString("image_url").equals(null)) {

            }
            String name = rewardsJson.getString("name");
            String description = rewardsJson.getString("description");
            int points = rewardsJson.getInt("points");
            int id = rewardsJson.getInt("id");
            String imgUrl = rewardsJson.getString("image_url");


            Rewards rewards = new Rewards(id, name, description, points);
            rewards.setImgUrl(imgUrl);
            Bitmap imagen = null;
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
                    rewards.setImage(imagen);

                }
                rewardsTemp.add(rewards);


            } catch (Exception e) {
                //Log.e("Error", e.getMessage());
                e.printStackTrace();
            }

        }

        return rewardsTemp;

    }

}
