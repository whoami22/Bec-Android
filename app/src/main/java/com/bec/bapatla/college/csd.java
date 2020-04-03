package com.bec.bapatla.college;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.View;

public class csd extends AppCompatActivity{
    WebView webView;
    public String fileName = "cse.html";
     public Switch s;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.csd);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tbcs);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

     /*   WebView wb = (WebView) findViewById(R.id.csebg);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wb.setVerticalScrollBarEnabled(false);
        wb.setHorizontalScrollBarEnabled(false);
        wb.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return (motionEvent.getAction() == MotionEvent.ACTION_MOVE);
            }
        }); */
        //wb.loadUrl("file:///android_asset/" + "csedept.html");

        webView = (WebView) findViewById(R.id.wvcse);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + fileName);
        s = (Switch)findViewById(R.id.csswitch);
       s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WebView ll = (WebView) findViewById(R.id.wvcse);
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
