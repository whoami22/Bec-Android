package com.bec.bapatla.college;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.annotation.NonNull;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bec.bapatla.CircleMenu;
import com.bec.bapatla.CircleMenuButton;

public class Main2Activity extends AppCompatActivity {
    Handler setDelay;
    Runnable startDelay;
    int ab=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarsa);
        setSupportActionBar(toolbar);
        //CIRCLE MENU ACTIONS

        //final ViewGroup snackbarContainer = findViewById(R.id.clearhere);
        final CircleMenu circleMenu = findViewById(R.id.circle_menu);
        try {
            ImageView imv=(ImageView)findViewById(R.id.texts);

            circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
                @Override
                public void onItemClick(CircleMenuButton menuButton) {

                    //public Fragment fragment = null;

                    if (menuButton.getHintText().equals("Departments")) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getBaseContext(), depts.class);
                                startActivity(intent);
                            }
                        }, 1200);
                    } else if (menuButton.getHintText().equals("Estimators")) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getBaseContext(), estimators.class);
                                startActivity(intent);
                            }
                        }, 1200);

                    }
                    else if (menuButton.getHintText().equals("Results")) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getBaseContext(), results.class);
                                startActivity(intent);
                            }
                        }, 1200);

                    }
                    else if (menuButton.getHintText().equals("Student Activities")) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getBaseContext(), sa.class);
                                startActivity(intent);
                            }
                        }, 1200);

                    }
                    else if (menuButton.getHintText().equals("Downloads")) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getBaseContext(), downloads.class);
                                startActivity(intent);
                            }
                        }, 1200);

                    }
                    else if (menuButton.getHintText().equals("Notifications")) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getBaseContext(), notifications.class);
                                startActivity(intent);
                            }
                        }, 1200);

                    }

                }
            });
        }catch (Exception exxx)
        {

        }

        circleMenu.setEventListener(new CircleMenu.EventListener() {
            @Override
            public void onMenuOpenAnimationStart() {
                ImageView imv=findViewById(R.id.texts);
                imv.setVisibility(View.VISIBLE);
                //Log.d("CircleMenuStatus", "onMenuOpenAnimationStart");
            }

            @Override
            public void onMenuOpenAnimationEnd() {
                ImageView imv=findViewById(R.id.texts);
                imv.setVisibility(View.VISIBLE);
               // Log.d("CircleMenuStatus", "onMenuOpenAnimationEnd");
            }

            @Override
            public void onMenuCloseAnimationStart() {
                ImageView imv=findViewById(R.id.texts);
                imv.setVisibility(View.INVISIBLE);
              //  Log.d("CircleMenuStatus", "onMenuCloseAnimationStart");
            }

            @Override
            public void onMenuCloseAnimationEnd() {
                ImageView imv=findViewById(R.id.texts);
                imv.setVisibility(View.INVISIBLE);
               // Log.d("CircleMenuStatus", "onMenuCloseAnimationEnd");
            }

            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuButton menuButton) {
                ImageView imv=findViewById(R.id.texts);
                imv.setVisibility(View.INVISIBLE);
                //Log.d("CircleMenuStatus", "onButtonClickAnimationStart");
            }

            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuButton menuButton) {
                ImageView imv=findViewById(R.id.texts);
                imv.setVisibility(View.INVISIBLE);
               // Log.d("CircleMenuStatus", "onButtonClickAnimationEnd");
            }

        });


//College Info More
       TextView myTextView = (TextView)findViewById(R.id.textView3);
        String myString = myTextView.getText().toString();
        int i1 = myString.indexOf("More A");
        int i2 = myString.indexOf(">");
        myTextView.setMovementMethod(LinkMovementMethod.getInstance());
        myTextView.setText(myString, TextView.BufferType.SPANNABLE);
        Spannable mySpannable = (Spannable)myTextView.getText();
        ClickableSpan myClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                Intent t = new Intent(getBaseContext(),ci.class);
                startActivity(t);
            }
        };
        mySpannable.setSpan(myClickableSpan, i1, i2 + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//Gallery

        TextView mtv = (TextView)findViewById(R.id.galer);
        String mst = mtv.getText().toString();
        int istart = mst.indexOf("G");
        int iclose= mst.indexOf("y");
        mtv.setMovementMethod(LinkMovementMethod.getInstance());
        mtv.setText(mst, TextView.BufferType.SPANNABLE);
        Spannable msp = (Spannable)mtv.getText();
        ClickableSpan mcb = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                Intent t = new Intent(getBaseContext(),gallery.class);
                startActivity(t);
            }
        };
        msp.setSpan(mcb, istart, iclose+ 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        circleMenu.setBackgroundColor(Color.parseColor("#2b2f43"));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/html");
            //String shareBodyText =getResources().getText(R.string.share_text).toString();
            String shareBodyText ="Check out the new Bapatla Engineering College Application for instant notifications and updates about Results and stuff . https://play.google.com/store/apps/details?id=com.bec.bapatla.college";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Download BEC Application");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
            startActivity(Intent.createChooser(sharingIntent, "Share BEC App with your Friends"));
            return true;
        }
        else if(id == R.id.action_settings) {
            Intent i = new Intent(this,contactUs.class);
            startActivity(i);
            return true;
        }
        else if(id == R.id.devOps) {
            Intent i = new Intent(this,developers.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 1600);
    }
    public  void clickGal(View view){
        Intent t = new Intent(getBaseContext(),gallery.class);
        startActivity(t);
    }

}
