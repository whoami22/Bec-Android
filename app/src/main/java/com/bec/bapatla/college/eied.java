package com.bec.bapatla.college;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Switch;

/**
 * Created by Lenovo on 10-02-2018.
 */

public class eied extends AppCompatActivity {
    WebView webView;
    public String fileName = "eie.html";
    public Switch s;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eied);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tbeie);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        webView = (WebView) findViewById(R.id.wveie);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + fileName);
        s = (Switch)findViewById(R.id.eieswitch);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView ll = (WebView) findViewById(R.id.wveie);
                if(s.isChecked()==true)
                {
                    ll.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
