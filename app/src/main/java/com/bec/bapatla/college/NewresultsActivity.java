package com.bec.bapatla.college;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class NewresultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newresults);
        final WebView wv =(WebView)findViewById(R.id.nrs);
        WebSettings webSettings = wv.getSettings();

        wv.setVisibility(View.VISIBLE);
        webSettings.setJavaScriptEnabled(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                wv.setVisibility(View.VISIBLE);
                wv.loadUrl("http://becbapatla.ac.in/html/results.html");
            }
        }, 1200);
    }
}
