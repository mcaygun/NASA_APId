package com.example.bprlab.project.Network;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MarsRequest extends AsyncTask<Void,Void,Void> {
    public MarsListener listener;
    private  String result="";
    public  interface MarsListener{
        void MarsRequestDone(String result);
    }
    public  MarsRequest(MarsListener listener){
        this.listener=listener;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        DefaultHttpClient httpClient=new DefaultHttpClient();
        HttpGet httpGet=new HttpGet(Constants.URL+Constants.MARS);
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
        listener.MarsRequestDone(result);
        //bar.setVisibility(View.VISIBLE);
    }
}
