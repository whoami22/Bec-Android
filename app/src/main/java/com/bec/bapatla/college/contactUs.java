package com.bec.bapatla.college;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.net.Uri;

public class contactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tbContact);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void contact(View view){
        switch (view.getId()){
            case R.id.call:
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:08643223200"));
                startActivity(intent);
                break;
            case R.id.mail:
                Intent inte = new Intent(
                        Intent.ACTION_SENDTO,
                        Uri.parse("mailto:bec_principal@yahoo.com")
                );
                startActivity(inte);
                break;
            case R.id.coemail:
                Intent inten = new Intent(
                        Intent.ACTION_SENDTO,
                        Uri.parse("mailto:becexamsection@gmail.com")
                );
                startActivity(inten);
                break;
            case R.id.site:
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.becbapatla.ac.in"));
                startActivity(i);
                break;
            case R.id.map:
                /*Intent i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:15.890772,80.441692"));
                startActivity(i1);*/
                double latitude = 15.890772;
                double longitude = 80.441692;
                String label = "ABC Label";
                String uriBegin = "geo:" + latitude + "," + longitude;
                String query = latitude + "," + longitude + "(" + label + ")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                Intent intent1 = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(intent1);
                break;
        }
    }
}
