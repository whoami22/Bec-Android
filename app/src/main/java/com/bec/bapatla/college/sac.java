package com.bec.bapatla.college;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class sac extends Fragment {
    public sac() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sac, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton btn= (FloatingActionButton) getActivity().findViewById(R.id.sac2home);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        ImageButton fb = (ImageButton)view.findViewById(R.id.fbSac);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/SuryodayaSocietyForAwakeningCommunity/"));
                startActivity(in);
            }
        });
        ImageButton wassup =(ImageButton)view.findViewById(R.id.whatsappSac);
        wassup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri uri = Uri.parse("smsto:" +"9640480000");
                    Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                    i.setPackage("com.whatsapp");
                    startActivity(Intent.createChooser(i, ""));

                } catch (Exception e) {
                    Toast.makeText(getActivity(), "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ImageButton call = (ImageButton)getActivity().findViewById(R.id.callSac);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:9640480000"));
                //callIntent.setData(Uri.parse("tel:+9640480000"));
                startActivity(callIntent);
            }
        });
        TextView mtv = (TextView)view.findViewById(R.id.sac_number);
        String mst = mtv.getText().toString();
        int istart = mst.indexOf("9");
        int iclose= mst.indexOf(".");
        mtv.setMovementMethod(LinkMovementMethod.getInstance());
        mtv.setText(mst, TextView.BufferType.SPANNABLE);
        Spannable msp = (Spannable)mtv.getText();
        ClickableSpan mcb = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                Intent t = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:9640480000"));
                startActivity(t);
            }
        };
        msp.setSpan(mcb, istart, iclose+ 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
}


