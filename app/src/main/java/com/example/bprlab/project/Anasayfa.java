package com.example.bprlab.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Anasayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        findViewById(R.id.btnMars).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Anasayfa.this,Mars.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btnTechport).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Anasayfa.this,TechPort.class);
                startActivity(i);

            }
        });

    }
}
