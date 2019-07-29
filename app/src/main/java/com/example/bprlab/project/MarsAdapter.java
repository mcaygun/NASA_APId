package com.example.bprlab.project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bprlab.project.Model.MARSModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarsAdapter extends RecyclerView.Adapter<MarsAdapter.VeriCekme> {
    private  Context mcontext;
    private ArrayList<MARSModel> marsModels;
    public MarsAdapter(Context context, ArrayList<MARSModel> marsModels){
        mcontext=context;
       this.marsModels=marsModels;
    }



    @Override
    public MarsAdapter.VeriCekme onCreateViewHolder(  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.mars_list,parent,false);
       return new VeriCekme(v);

    }

    @Override
    public void onBindViewHolder( VeriCekme veriCekme, int position) {
        MARSModel marsModel= marsModels.get(position);
        String imageurl=marsModel.getImg_src();
       String date=marsModel.getEarth_date();
        //String fm=marsModel.getFull_name();



        veriCekme.Date.setText(date);
       // veriCekme.mFullname.setText(fm);

        Picasso.with(mcontext).load(imageurl).fit().centerInside().into(veriCekme.img);


    }

    @Override
    public int getItemCount() {
        return marsModels.size();
    }

    public  class  VeriCekme extends  RecyclerView.ViewHolder{
        public ImageView img;
        public TextView Date;
        public TextView Fullname;
        public VeriCekme(View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.image_view);
            Date=itemView.findViewById(R.id.TvDate);
            Fullname=itemView.findViewById(R.id.TvFullName);

        }
    }
}
