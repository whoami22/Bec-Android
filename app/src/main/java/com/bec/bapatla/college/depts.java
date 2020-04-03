package com.bec.bapatla.college;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Adnin on 26-01-2018.
 */
public class depts extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depts);
        /*android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tbdepts);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        */
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar
        //toolbar.setTitle("AbhiAndroid"); // setting a title for this Toolbar
        toolbar.setTitleTextColor(Color.WHITE); // set title text color for Toolbar.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        CardView cs=(CardView)findViewById(R.id.cse);
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent csi=new Intent(getBaseContext(),csd.class);
                startActivity(csi);
            }
        });
        CardView ec=(CardView)findViewById(R.id.ece);
        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eci=new Intent(getBaseContext(),eced.class);
                startActivity(eci);
            }
        });
        CardView civ=(CardView)findViewById(R.id.civ);
        civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cvi=new Intent(getBaseContext(),civd.class);
                startActivity(cvi);
            }
        });
        CardView mec=(CardView)findViewById(R.id.mech);
        mec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mi=new Intent(getBaseContext(),mechd.class);
                startActivity(mi);
            }
        });
        CardView ee=(CardView)findViewById(R.id.eee);
        ee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eei=new Intent(getBaseContext(),eeed.class);
                startActivity(eei);
            }
        });
        CardView che=(CardView)findViewById(R.id.chem);
        che.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chi=new Intent(getBaseContext(),ched.class);
                startActivity(chi);
            }
        });
        CardView it=(CardView)findViewById(R.id.it);
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(getBaseContext(),itd.class);
                startActivity(ii);
            }
        });
        CardView eie=(CardView)findViewById(R.id.eie);
        eie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ei=new Intent(getBaseContext(),eied.class);
                startActivity(ei);
            }
        });

    }
}
