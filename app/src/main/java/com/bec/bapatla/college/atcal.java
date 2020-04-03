package com.bec.bapatla.college;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class atcal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atcal);
        setTitle("Assignment Marks Estimator");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button b = (Button) findViewById(R.id.am);
        LinearLayout tv = (LinearLayout) findViewById(R.id.aatinst);
        Switch abc = (Switch) findViewById(R.id.switchatcal);
        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Switch abc = (Switch) findViewById(R.id.switchatcal);
                LinearLayout tv = (LinearLayout) findViewById(R.id.aatinst);
                if (abc.isChecked() == true) {

                    tv.setVisibility(View.VISIBLE);
                } else
                    tv.setVisibility(View.INVISIBLE);
            }
        });


      /*  WebView wb = (WebView)findViewById(R.id.robot);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wb.setVerticalScrollBarEnabled(false);
        wb.setHorizontalScrollBarEnabled(false);
        wb.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return (motionEvent.getAction()==MotionEvent.ACTION_MOVE);
            }
        });
        wb.loadUrl("file:///android_asset/" + "robot.html");
        */


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout mainLayout = (ConstraintLayout) findViewById(R.id.aatLayout);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
                double ass1 = 0.0, target = 0.0;
                EditText assi = (EditText) findViewById(R.id.aat);
                try {
                    ass1 = Double.parseDouble(assi.getText().toString());
                    EditText targ = (EditText) findViewById(R.id.tar);
                    target = Double.parseDouble(targ.getText().toString());
                    double xh, xl, yh, yl, ass2 = 0.0;

                    xl = ass1 / 2;
                    xh = ass1;
                    if (ass1 > 10.0 || ass1 < 0.0 || target <= 0.0 || target > 15.0) {
                        Toast.makeText(getBaseContext(), "Assignment Marks Range 0 - 10\nTarget Marks Range 0 - 15", Toast.LENGTH_LONG).show();
                    } else if (target < ass1) {
                        Toast.makeText(getBaseContext(), "Target Marks Should Be greater than AAT-1 Marks", Toast.LENGTH_LONG).show();
                    } else {
                        for (int i = 0; i <= 10; i++) {
                            yh = i;
                            yl = i / 2;
                            if (Math.ceil(xh + yl) >= target) {
                                ass2 = i;
                                break;
                            } else if (Math.ceil(xl + yh) >= target) {
                                ass2 = i;
                                break;
                            }
                        }
                        TextView t = (TextView) findViewById(R.id.printtar);
                        if (ass2 == 0.0) {
                            t.setTextColor(getColor(R.color.Red));
                            t.setText("Target Cannot Be Reached");

                        } else {
                            t.setTextColor(getColor(R.color.Green));
                            t.setText("Your target is " + ass2 + " in AAT-2 Marks");
                        }
                    }
                } catch (Exception er) {
                    Toast.makeText(getBaseContext(), "Target or Assignment marks are Empty", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
