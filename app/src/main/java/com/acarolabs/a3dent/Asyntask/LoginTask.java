package com.acarolabs.a3dent.Asyntask;

import android.app.Activity;


import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.acarolabs.a3dent.AppConstants.*;
import com.acarolabs.a3dent.Models.SessionManager;

/**
 * Created by ASUS on 09/06/2015.
 */
public class LoginTask extends AsyncTask<String,Void,String> {
    private final String LOG_TAG = RewardsTask.class.getSimpleName();
    SessionManager sessionManager;


    Activity activity;
    public LoginTask(Activity activity){
        this.activity = activity;
        sessionManager = new SessionManager(activity.getApplicationContext());
    }
    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        // Will contain the raw JSON response as a string.
        String forecastJsonStr = null;


        try {
            String serverUrls = com.acarolabs.a3dent.AppConstants.serverUrl;

            URL url = new URL(serverUrls+"api/v1/auth?email="+params[0]+"&password="+params[1]);

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
            JSONObject mJsonObject = null;
            try {
                mJsonObject = new JSONObject(forecastJsonStr);
                String token = mJsonObject.getString("token");


                return token;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attemping
            // to parse it.
            return null;
        }finally {
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
        return null;
    }


    @Override
    protected void onPostExecute(String result) {

        /*SharedPreferences pref = activity.getPreferences(activity.MODE_PRIVATE);
        String preferencesToken = pref.getString("token", "No encontrado");
        Toast toast1 =
                Toast.makeText(activity,preferencesToken, Toast.LENGTH_SHORT);

        toast1.show();*/
        /*if(result.equals("invalid")){
            Toast toast1 =
                    Toast.makeText(activity,"Credencial Invalida", Toast.LENGTH_SHORT);

            toast1.show();
        }else {
            //sessionManager.createLoginSession(result);
            Toast toast1 =
                    Toast.makeText(activity,result, Toast.LENGTH_SHORT);

            toast1.show();
        }*/


        sessionManager.createLoginSession(result);

    }


}
