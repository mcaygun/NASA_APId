package com.example.bprlab.project.Model;

public class MARSModel {
   public String earth_date;
   public String img_src;
  // public String full_name;

   /* public String getFull_name() {
        return full_name;
    }*/

    public MARSModel(String imageUrl, String Date) {

        img_src = imageUrl;
        earth_date = Date;
       // full_name=fname;

    }


    public String getEarth_date() {
        return earth_date;
    }

    public String getImg_src() {
        return img_src;
    }


    }

