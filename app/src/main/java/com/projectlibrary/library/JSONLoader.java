package com.projectlibrary.library;


import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import org.json.*;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static android.content.ContentValues.TAG;

public class JSONLoader extends AsyncTask<Void, Void, Void> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Void doInBackground(Void... arg0) {
        Log.d("JSON","Started");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response
        String url = "http://booky.lkarev.com/test.json";
        String jsonStr = sh.makeServiceCall(url);
        //String jsonStr = "http://booky.lkarev.com/test.json";
        Log.e("JSON", "Response from url: " + jsonStr);
        if (jsonStr != null) {

            JSONObject reader;
            try
            {
                reader = new JSONObject(jsonStr);

                JSONObject sys  = reader.getJSONObject("address");
                String country = sys.getString("state");

                JSONObject main  = reader.getJSONObject("firstName");
                String temperature = main.getString("firstName");

                Log.d("JSON", country);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }

        } else {
            Log.e("JSON", "Couldn't get json from server.");

        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

    }



}
