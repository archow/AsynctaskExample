package com.example.asynctaskexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<String>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //we start our Asynctask here to kick off our background work
        //let's say we get an URL from our user (or list of urls) that we
        //want to download from
        //we then pass those urls to our asynctask class

        List<URL> someList = new ArrayList<URL>();
        //let's just assume we have a list of url's
        MyAsyncTask downloaderTask = new MyAsyncTask();
        downloaderTask.execute(someList.get(0),
                someList.get(1));
    }

    onCreateLoader()

    @NonNull
    @Override
    public Loader<List<String>> onCreateLoader(int id, @Nullable Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<String>> loader, List<String> data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<String>> loader) {

    }
}