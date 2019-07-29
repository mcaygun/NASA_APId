package com.example.bprlab.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bprlab.project.Model.MARSModel;
import com.example.bprlab.project.Model.TECHPORTModel;
import com.example.bprlab.project.Network.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TechPort extends AppCompatActivity {

    private RequestQueue requestQueue;
    private ArrayList<TECHPORTModel> techportModels;
    private RecyclerView recyclerView1;
    private TechPortAdapter adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_port);

        recyclerView1 = (RecyclerView) findViewById(R.id.recycler1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        techportModels = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        TechReq();


    }
    private void TechReq() {
           // String yol="https://api.nasa.gov/techport/api/projects/94182?api_key=DEMO_KEY";
        JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET, Constants.URL+Constants.TECHPORT, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("project");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject prject = jsonArray.getJSONObject(i);
                                String tit = prject.getString("title");
                                String stat = prject.getString("status");
                                String end=prject.getString("endDate");
                                String start=prject.getString("startDate");



                                techportModels.add(new TECHPORTModel(tit, stat,end,start));
                            }
                            adapter1 = new TechPortAdapter(TechPort.this, techportModels);
                            recyclerView1.setAdapter(adapter1);
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
