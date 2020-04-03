package com.bec.bapatla.college;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.content.Intent;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class downloads extends AppCompatActivity {

     private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.downloads);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tbDown);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        MobileAds.initialize(this,"ca-app-pub-5316829605239412~6788932846");
        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    public void get(View view) {
        switch (view.getId()) {
            case R.id.csed:
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.becbapatla.ac.in/cse/btechqp_new.html"));
                startActivity(i);
                break;
            case R.id.itd:
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.becbapatla.ac.in/it/downloads.html"));
                startActivity(i1);
                break;
            case R.id.eced:
                Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.becbapatla.ac.in/ece/btechqa.html"));
                startActivity(i2);
                break;
            case R.id.eeed:
                Intent i3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.becbapatla.ac.in/eee/btechq.html"));
                startActivity(i3);
                break;
            case R.id.eied:
                Intent i4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.becbapatla.ac.in/eie/eiqp.html"));
                startActivity(i4);
                break;
            case R.id.med:
                Intent i5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.becbapatla.ac.in/mechanical/btechqp_new.html"));
                startActivity(i5);
                break;
            case R.id.chd:
                Intent i6 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.becbapatla.ac.in/chemical/downloads.html"));
                startActivity(i6);
                break;
            case R.id.ced:
                Intent i7 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.becbapatla.ac.in/civil/downloads.html"));
                startActivity(i7);
                break;
        }
    }
}
