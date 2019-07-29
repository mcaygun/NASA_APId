package com.example.bprlab.project.Network;

import android.os.AsyncTask;
import android.view.View;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ApodRequest extends AsyncTask<Void,Void,Void> {
    public  ApodListener listener;
    private  String result="";
    public  interface ApodListener{
        void apodRequestDone(String result);
    }
    public  ApodRequest(ApodListener listener){
        this.listener=listener;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        DefaultHttpClient httpClient=new DefaultHttpClient();
        HttpGet httpGet=new HttpGet(Constants.URL+Constants.APOD);
        try {
            HttpResponse response= httpClient.execute(httpGet);
            InputStream ınputStream= response.getEntity().getContent();
            BufferedReader reader=new BufferedReader(new InputStreamReader(ınputStream));
            String s="";
            while ((s=reader.readLine())!=null ){

                result+=s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.apodRequestDone(result);
        //bar.setVisibility(View.VISIBLE);
    }
}
