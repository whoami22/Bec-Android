package com.bec.bapatla.college;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.solver.widgets.ConstraintHorizontalLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Adnin on 03-02-2018.
 */

public class midm extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.midm);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tbmidm);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        LinearLayout tv = (LinearLayout) findViewById(R.id.midinst);
        Switch abc= (Switch)findViewById(R.id.switchmidcal);
        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Switch abc= (Switch)findViewById(R.id.switchmidcal);
                LinearLayout tv = (LinearLayout) findViewById(R.id.midinst);
                if(abc.isChecked()==true)
                {

                    tv.setVisibility(View.VISIBLE);
                }
                else
                    tv.setVisibility(View.INVISIBLE);
            }
        });


        Button b = (Button) findViewById(R.id.midEsti);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout mainLayout = (ConstraintLayout)findViewById(R.id.midmlayout);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);

                double mid1=0.0,target=0.0;
                try {
                    TextView t = (TextView) findViewById(R.id.printtar);
                    EditText md = (EditText) findViewById(R.id.midMarks);
                    EditText tr = (EditText) findViewById(R.id.target);
                    mid1 = Double.parseDouble(md.getText().toString());
                    target = Double.parseDouble(tr.getText().toString());
                    double xh, xl, yh, yl;
                    xl= (mid1*6.5)/30;
                    xh= (mid1*13.5)/30;
                    if(mid1<0.0 ||mid1>30.0 || target>20.0 || target<0.0 )
                    {
                        Toast.makeText(getBaseContext(), "Enter Valid Mid and Target Marks", Toast.LENGTH_LONG).show();
                    }
                    else if(target <= xh || target<=xl)
                    {
                        Toast.makeText(getBaseContext(), "Target must be greater than "+xh+" or "+xl, Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        double mid2=0.0;
                        for(int i=0;i<=30;i++)
                        {
                            yh=(i*13.5)/30;
                            yl=(i*6.5)/30;
                            if(Math.ceil(xh+yl)>=target)
                            {
                                mid2 = i;
                                break;
                            }
                            else if(Math.ceil(xl+yh)>=target)
                            {
                                mid2 = i;
                                break;
                            }
                        }
                        if(mid2==0.0)
                        {
                            t.setTextColor(getColor(R.color.Red));
                            t.setText("Target Cannot Be Reached");
                        }
                        else
                        {
                            t.setTextColor(getColor(R.color.Green));
                            t.setText("Your target is " + mid2 + " Marks for Mid-2");
                        }
                    }
                }
                catch (Exception eed)
                {
                    Toast.makeText(getBaseContext(), "Target or Mid marks are Empty", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
