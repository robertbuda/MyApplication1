package com.example.robert.myapplication1.SpaceX;

import android.os.AsyncTask;
import android.util.Log;

import com.example.robert.myapplication1.async.BackgroundTaskContract;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import timber.log.Timber;

public class GetCompanyInfoTask extends AsyncTask<String, Void, String> {




    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();

            int responseCode = urlConnection.getResponseCode();
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
            result = inputStreamToString(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("API CALL", e.toString());
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        Timber.d(result);
        return result;
    }



    private String inputStreamToString(InputStream inputStream) {
        String currentLine;
        StringBuilder response = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            while ((currentLine = bufferedReader.readLine()) != null) {
                response.append(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}



