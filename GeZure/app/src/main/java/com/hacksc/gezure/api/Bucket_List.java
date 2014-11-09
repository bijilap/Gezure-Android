package com.hacksc.gezure.api;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

/**
 * Created by Arul on 11/9/2014.
 */
public class Bucket_List extends AsyncTask<String,String,String> {
    protected String doInBackground(String... params){
        String endpoint = params[0];
        String user_id = params[1];

        URL url = null;
        try {
            endpoint += "?user_id="+user_id;
            Log.d("Bucket_List", endpoint);
            url = new URL(endpoint);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

