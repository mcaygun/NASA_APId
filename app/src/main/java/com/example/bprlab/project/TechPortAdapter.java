package com.example.bprlab.project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bprlab.project.Model.MARSModel;
import com.example.bprlab.project.Model.TECHPORTModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TechPortAdapter extends RecyclerView.Adapter<TechPortAdapter.VeriCekme> {
    private Context Tcontext;
    private ArrayList<TECHPORTModel> techportModels;
    public TechPortAdapter(Context context, ArrayList<TECHPORTModel> techportModels){
        Tcontext=context;
        this.techportModels=techportModels;
    }



    @Override
    public TechPortAdapter.VeriCekme onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(Tcontext).inflate(R.layout.tech_list,parent,false);
        return new VeriCekme(v);

    }

    @Override
    public void onBindViewHolder( VeriCekme veriCekme, int position) {
        TECHPORTModel techportModel= techportModels.get(position);
        String Title=techportModel.getTitle();
        String Status=techportModel.getStatus();
        String Startdate=techportModel.getStartDate();
        String Enddate=techportModel.getEndDate();



        veriCekme.Title.setText(Title);
        veriCekme.Status.setText(Status);
        veriCekme.EndDate.setText(Enddate);
        veriCekme.StartDate.setText(Startdate);



    }

    @Override
    public int getItemCount() {
        return techportModels.size();
    }

    public  class  VeriCekme extends  RecyclerView.ViewHolder{

        public TextView Title;
        public TextView Status;
        public TextView EndDate;
        public TextView StartDate;
        public VeriCekme(View itemView) {
            super(itemView);
            Title=itemView.findViewById(R.id.Tvtitle);
            Status=itemView.findViewById(R.id.Tvstatus);
            EndDate=itemView.findViewById(R.id.TvendDate);
            StartDate=itemView.findViewById(R.id.TvstartDate);

        }
    }
}
