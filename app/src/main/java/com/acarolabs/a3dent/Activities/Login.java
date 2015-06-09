package com.acarolabs.a3dent.Activities;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.acarolabs.a3dent.R;
import org.apache.http.client.HttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Login extends ActionBarActivity {

    // private String email,password;
    private EditText editEmail, editPassword;
    private final String LOG_TAG = Login.class.getSimpleName();
    private final String HTTP_EVENT = "http://3dent.acarolabs.com/api/v1/auth?email=cortes.pablo@hotmail.es&password=secret";
    private HttpClient httpclient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = (EditText) findViewById(R.id.txtEmailLogin);
        editPassword = (EditText) findViewById(R.id.txtPasswordLogin);
    }


    public void onclick(View view) throws Exception {
        // token();
       /* Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
        finish();*/


       executeHttpGet();

    }

    public void token() {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString("token", editEmail.getText().toString());
        editor.commit();
    }

    public void recoverToken() {
        editEmail.setTextColor(Color.GREEN);
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        editPassword.setText(pref.getString("token", "No encontrado"));
    }

    //public String executeHttpGet(String url) throws Exception{
    public void executeHttpGet() throws Exception {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        // Will contain the raw JSON response as a string.
        String forecastJsonStr = null;


        try {

            URL url = new URL(HTTP_EVENT);

            // Create the request to OpenWeatherMap, and open the connection
              urlConnection = (HttpURLConnection) url.openConnection();
              urlConnection.setRequestMethod("GET");
              urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                  // Nothing to do.
                  return ;
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
              return ;
            }
            forecastJsonStr = buffer.toString();
            JSONObject mJsonObject = new JSONObject(forecastJsonStr);
            JSONArray mJsonArrayProperty = mJsonObject.getJSONArray("token");
            for (int i = 0; i < mJsonArrayProperty.length(); i++) {
                JSONObject rewardsJson = mJsonArrayProperty.getJSONObject(i);
                String names = rewardsJson.getString("token");
                editEmail.setText(names.toString());
            }


        }catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attemping
            // to parse it.
            return;
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
    }
}


