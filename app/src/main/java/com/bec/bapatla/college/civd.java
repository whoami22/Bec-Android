package com.bec.bapatla.college;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Lenovo on 10-02-2018.
 */

public class civd extends AppCompatActivity {
    WebView webView;
    public String fileName = "civ.html";
    public Switch s;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.civd);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tbciv);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        webView = (WebView) findViewById(R.id.wvciv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + fileName);
       s = (Switch)findViewById(R.id.civswitch);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView ll = (WebView) findViewById(R.id.wvciv);
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
