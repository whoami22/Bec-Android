package com.bec.bapatla.college;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Manohar on 25-02-2018.
 */

public class estimators extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estimators);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.back2home);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        WebView wb = (WebView) findViewById(R.id.fidg);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wb.setVerticalScrollBarEnabled(false);
        wb.setHorizontalScrollBarEnabled(false);
        wb.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return (motionEvent.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        wb.loadUrl("file:///android_asset/" + "spinner.html");
    }
    public void aestClick(View v)
    {
        Intent i = new Intent(getBaseContext(),atcal.class);
        startActivity(i);
    }
    public void mestClick(View v)
    {
        Intent i = new Intent(getBaseContext(),midm.class);
        startActivity(i);
    }
    public void iestClick(View v)
    {
        Intent i = new Intent(getBaseContext(),internalest.class);
        startActivity(i);
    }
}
