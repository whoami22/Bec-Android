package com.bec.bapatla.college;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class awaaz extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.awaaz, container, false);
        return view;
        /*android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)getActivity().findViewById(R.id.tbawaaz);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });*/
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton btn = (FloatingActionButton) getActivity().findViewById(R.id.awaaz2home);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        ImageButton fb = (ImageButton) view.findViewById(R.id.fbAwaaz);
        fb.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/becawaaz/"));
                startActivity(in);
            }
        });
        ImageButton wassup = (ImageButton) view.findViewById(R.id.whatsappAwaaz);
        wassup.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                try {
                    Uri uri = Uri.parse("smsto:" + "09515655976");
                    Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                    i.setPackage("com.whatsapp");
                    startActivity(Intent.createChooser(i, ""));

                } catch (Exception e) {
                    Toast.makeText(getActivity(), "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ImageButton call = (ImageButton) getActivity().findViewById(R.id.callAwaaz);
        call.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:09515655976"));
                startActivity(callIntent);
            }
        });
    }
}

    /*@Override
    public void onBackPressed(){
        if(getSupportFragmentManager().getBackStackEntryCount()>0)
        {
            getSupportFragmentManager().popBackStackImmediate();
        }
        else {
            super.onBackPressed();
        }
    }*/
