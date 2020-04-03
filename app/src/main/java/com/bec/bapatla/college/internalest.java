package com.bec.bapatla.college;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Manohar on 25-02-2018.
 */

public class internalest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tbintr);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Button b = (Button) findViewById(R.id.am);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    String attan = String.valueOf(spinner.getSelectedItem());
                    double att = Double.parseDouble(attan);
                    double ass1 = 0.0, ass2 = 0.0, tot = 0.0, target1 = 0.0;
                    EditText assi = (EditText) findViewById(R.id.aat);
                    EditText assi2 = (EditText) findViewById(R.id.aat2);
                    EditText tr = (EditText) findViewById(R.id.tar);
                    target1 = Double.parseDouble(tr.getText().toString());
                    if (target1 < 0.0 || target1 > 40.0) {
                        Toast.makeText(getBaseContext(), "Target marks must between 0.0 to 40.0", Toast.LENGTH_LONG).show();
                    } else {
                        try {
                            ass1 = Double.parseDouble(assi.getText().toString());
                            ass2 = Double.parseDouble(assi2.getText().toString());
                            if (ass1 > 10.0 || ass1 < 0.0 || ass2 > 10.0 || ass2 < 0.0) {
                                Toast.makeText(getBaseContext(), "Assignment Marks Range 0 - 10", Toast.LENGTH_LONG).show();
                            } else {
                                if (ass1 > ass2) {
                                    tot = ass1;
                                    tot += ass2 / 2;
                                } else {
                                    tot = ass2;
                                    tot += ass1 / 2;
                                }

                            }
                        } catch (Exception er) {
                            Toast.makeText(getBaseContext(), "Target or Assignment marks are Empty", Toast.LENGTH_LONG).show();
                        }
                        tot += att;
                        target1 -= tot;
                        double mid1 = 0.0;
                        try {
                            TextView t = (TextView) findViewById(R.id.printtar);
                            EditText md = (EditText) findViewById(R.id.editText);

                            mid1 = Double.parseDouble(md.getText().toString());

                            double xh, xl, yh, yl;
                            xl = (mid1 * 6.5) / 30;
                            xh = (mid1 * 13.5) / 30;
                            if (mid1 < 0.0 || mid1 > 30.0 || target1 > 20.0 || target1 < 0.0) {
                                //Toast.makeText(getBaseContext(), "Mid-Term Marks are Not Valid", Toast.LENGTH_LONG).show();
                                t.setTextColor(getColor(R.color.Red));
                                t.setText("Target Cannot Be Reached");
                            } else if (target1 <= xh || target1 <= xl) {
                                //Toast.makeText(getBaseContext(), "Target must be greater than "+xh+" or "+xl, Toast.LENGTH_LONG).show();
                            } else {
                                double mid2 = 0.0;
                                for (int i = 0; i <= 30; i++) {
                                    yh = (i * 13.5) / 30;
                                    yl = (i * 6.5) / 30;
                                    if (Math.ceil(xh + yl) >= target1) {
                                        mid2 = i;
                                        break;
                                    } else if (Math.ceil(xl + yh) >= target1) {
                                        mid2 = i;
                                        break;
                                    }
                                }
                                if (mid2 == 0.0) {
                                     t.setTextColor(getColor(R.color.Red));
                                    t.setText("Target Cannot Be Reached");
                                } else {
                                    t.setTextColor(getColor(R.color.Green));
                                    t.setText("Your target is " + mid2 + " Marks for Mid-2");
                                }
                            }
                        } catch (Exception eed) {
                            Toast.makeText(getBaseContext(), "Target or Mid marks are Empty", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                catch (Exception exe) {
                    Toast.makeText(getBaseContext(), "Please Fill All Fields ", Toast.LENGTH_LONG).show();
                }
                ConstraintLayout mainLayout = (ConstraintLayout)findViewById(R.id.internalLayout);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });

        Switch abc = (Switch) findViewById(R.id.switchinternal);
        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Switch abc = (Switch) findViewById(R.id.switchinternal);
                TextView tv = (TextView) findViewById(R.id.internalHow);
                if (abc.isChecked() == true) {

                    tv.setVisibility(View.VISIBLE);
                } else
                    tv.setVisibility(View.INVISIBLE);
            }
        });
    }
}
