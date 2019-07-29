package com.example.bprlab.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bprlab.project.Model.APODModel;
import com.example.bprlab.project.Network.ApodRequest;
import com.google.gson.Gson;

public class İcerikTitle extends AppCompatActivity implements ApodRequest.ApodListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icerik_title);
        ApodRequest request=new ApodRequest(İcerikTitle.this);
        request.execute();
    }

    @Override
    public void apodRequestDone(String result) {
        Gson gson=new Gson();
        APODModel apodModel= gson.fromJson(result,APODModel.class);
        ((TextView) findViewById(R.id.apodExplanation)).setText(apodModel.explanation);
    }
}
