package com.bec.bapatla.college;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Lenovo on 10-02-2018.
 */

public class eced extends AppCompatActivity {
    WebView webView;
    public String fileName = "ece.html";
    public Switch s;
    //public String deptInfo = "<p>The <strong>Department of Electronics and Communication Engineering</strong> was established in the year <em>1981</em> .The National Board of Accreditation has accredited the department for three years. Department is headed by <span style=\"color: #ff9900;\"><strong>Dr. B. Chandra Mohan </strong></span>.<br />Department have 38 faculty and are members of professional bodies like <em><strong>ISTE,IEEE,IETE</strong></em> and <em><strong>CSI</strong></em>. All the students are the members of <strong>IETE</strong> student forum of the existing department. Having state of the art laboratories to gain good knowledge in the field of<em><strong> Electronics, Communication, Microwave, VLSI, DSP&amp;IMAGE, Networking Microprocessor and Microcontroller.</strong></em></p>";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eced);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tbece);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        webView = (WebView) findViewById(R.id.wvece);
        /*TextView tv = (TextView) findViewById(R.id.eceinfo);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {
            tv.setText(Html.fromHtml(deptInfo,Html.FROM_HTML_MODE_LEGACY));
        }
        else
            tv.setText(Html.fromHtml(deptInfo));*/
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + "ece.html");
        s = (Switch)findViewById(R.id.eceswitch);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView ll = (WebView) findViewById(R.id.wvece);
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
