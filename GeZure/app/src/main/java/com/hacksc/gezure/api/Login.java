package com.hacksc.gezure.api;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Arul on 11/9/2014.
 */
public class Login extends AsyncTask<String,String,String> {
    protected String doInBackground(String... params){
        String endpoint = params[0];
        String user_id = params[1];
        String device_id = params[2];

        URL url = null;
        try {
            endpoint += "?user_id="+user_id+"&device_id="+device_id;
            Log.d("Login", endpoint);
            url = new URL(endpoint);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

