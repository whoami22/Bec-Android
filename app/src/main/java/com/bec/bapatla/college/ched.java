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

public class ched extends AppCompatActivity {
    WebView webView;
    public String fileName = "chem.html";
    public Switch s;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ched);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tbchem);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        webView = (WebView) findViewById(R.id.wvchem);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + fileName);
        s = (Switch)findViewById(R.id.chemswitch);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView ll = (WebView) findViewById(R.id.wvchem);
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
