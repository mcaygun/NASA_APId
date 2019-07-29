package com.example.bprlab.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bprlab.project.Model.MARSModel;
import com.example.bprlab.project.Network.Constants;
import com.example.bprlab.project.Network.MarsRequest;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Mars extends AppCompatActivity  {
    private RequestQueue requestQueue;
    private ArrayList<MARSModel> marsModels;
    private RecyclerView recyclerView;
    private MarsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        marsModels = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        MarsRequesT();


    }
    private void MarsRequesT() {

        JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET, Constants.URL+Constants.MARS, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("photos");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject photos = jsonArray.getJSONObject(i);
                                String imageUrl = photos.getString("img_src");
                                String date = photos.getString("earth_date");
                                //String full=photos.getString("full_name");

                                marsModels.add(new MARSModel(imageUrl, date));
                            }
                            adapter = new MarsAdapter(Mars.this, marsModels);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}
