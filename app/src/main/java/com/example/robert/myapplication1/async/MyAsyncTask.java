package com.example.robert.myapplication1.async;

import android.os.AsyncTask;
import android.widget.ProgressBar;

public class MyAsyncTask extends AsyncTask<Integer,Integer,String>{


    private BackgroundTaskContract.View view;

    public void setView(BackgroundTaskContract.View view){
        this.view = view;
    }


    @Override
    protected void onPreExecute() {

        view.showProgress();
    }

    @Override
    protected String doInBackground(Integer... integers) {
        int start = integers[0];
        while (start < 100){
            publishProgress(start);
            start++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        return "finish";
    }

    @Override
    protected void onProgressUpdate(Integer... integers) {

        view.updateProgress(integers[0]);
    }


    @Override
    protected void onPostExecute(String finish) {

        view.hideProgress();
        view.showOutput(finish);
    }

}
