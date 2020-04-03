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

public class cca extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cca, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      FloatingActionButton btn= (FloatingActionButton) getActivity().findViewById(R.id.cca2home);
      btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        ImageButton fb = (ImageButton)view.findViewById(R.id.fbCca);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ccaarts/"));
                startActivity(in);
            }
        });
        ImageButton wassup =(ImageButton)view.findViewById(R.id.whatsappCca);
        wassup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri uri = Uri.parse("smsto:" +"8297691663");
                    Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                    i.setPackage("com.whatsapp");
                    startActivity(Intent.createChooser(i, ""));

                } catch (Exception e) {
                    Toast.makeText(getActivity(), "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ImageButton call = (ImageButton)getActivity().findViewById(R.id.callCca);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:8297691663"));
                startActivity(callIntent);
            }
        });
    }
}
