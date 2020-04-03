package com.bec.bapatla.college;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.*;
import android.widget.*;

import java.util.regex.*;
/**
 * Created by Adnin on 26-01-2018.
 */
public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tbres);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Button b = (Button)findViewById(R.id.sub);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String regdno  = ((EditText)findViewById(R.id.regd)).getText().toString().toUpperCase();
                boolean be =   Pattern.matches("(Y|L)\\d{2}A(CS|ME|CE|IT|EC|EE|EI|CH)\\d{3}",regdno);
                if(be) {
                    Intent i = new Intent(getBaseContext(), marks.class);
                    i.putExtra("RegdNo", regdno );
                    startActivity(i);
                }
                else{
                    Toast.makeText(getBaseContext(),"Enter correct format like Y15ACS600",Toast.LENGTH_LONG).show();
                }
            }
        });

        TextView mtv = (TextView)findViewById(R.id.newResults);
        String mst = mtv.getText().toString();
        int istart = mst.indexOf("F");
        int iclose= mst.indexOf("!");
        mtv.setMovementMethod(LinkMovementMethod.getInstance());
        mtv.setText(mst, TextView.BufferType.SPANNABLE);
        Spannable msp = (Spannable)mtv.getText();
        ClickableSpan mcb = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                Intent t = new Intent(getBaseContext(),NewresultsActivity.class);
                startActivity(t);
            }
        };
        msp.setSpan(mcb, istart, iclose+ 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }


}
