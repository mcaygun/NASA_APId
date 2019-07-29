package com.example.bprlab.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bprlab.project.Model.APODModel;
import com.example.bprlab.project.Network.ApodRequest;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements ApodRequest.ApodListener {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //send request
        ApodRequest request=new ApodRequest(MainActivity.this);
        request.execute();
        findViewById(R.id.apodTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent icerikgec=new Intent(MainActivity.this,İcerikTitle.class);
                startActivity(icerikgec);
            }
        });
        findViewById(R.id.apodButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anasayfagec=new Intent(MainActivity.this,Anasayfa.class);
                startActivity(anasayfagec);
            }
        });
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent icerikgec=new Intent(MainActivity.this,İcerikTitle.class);
                startActivity(icerikgec);
            }
        });
    }

    @Override
    public void apodRequestDone(String result) {
        Gson gson=new Gson();
        APODModel apodModel= gson.fromJson(result,APODModel.class);
        ((TextView) findViewById(R.id.apodTitle)).setText(apodModel.title);
        image=(ImageView)findViewById(R.id.imageView);
        Picasso.with(getApplicationContext()).load(apodModel.hdurl).into(image);



    }

}
