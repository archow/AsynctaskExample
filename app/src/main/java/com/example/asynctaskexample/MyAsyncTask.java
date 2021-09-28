package com.example.asynctaskexample;

import android.os.AsyncTask;

import java.net.URL;

public class MyAsyncTask extends AsyncTask<URL, Integer, Long> {
    @Override
    protected Long doInBackground(URL... urls) {
        int count = urls.length;
        long totalSize = 0;
        for (int i = 0; i < count; i++) {
            //obviously we don't know the implementation of Downloader object here
            //but let's assume it works and does its job
            totalSize += Downloader.downloadFile(urls[i]);

            //calls onProgressUpdate
            publishProgress((int) ((i / (float) count) * 100));
            // Escape early if cancel() is called
            if (isCancelled()) break;
        }
        return totalSize;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        setProgressPercent(progress[0]);
    }

    @Override
    protected void onPostExecute(Long result) {
        showDialog("Downloaded " + result + " bytes");
    }
}
