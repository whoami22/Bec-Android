package com.bec.bapatla.college;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bec.bapatla.CircleMenu;
import com.bec.bapatla.CircleMenuButton;


public class home extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home,container,false);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");


        //CIRCLE MENU ACTIONS

       // final ViewGroup snackbarContainer = getActivity().findViewById(R.id.clearhere);
        final CircleMenu circleMenu = getActivity().findViewById(R.id.circle_menuhome);

            circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
                @Override
                public void onItemClick(CircleMenuButton menuButton) {
                    Fragment fragment = null;
                    if (menuButton.getHintText().equals("Notifications")) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Intent intent = new Intent(getBaseContext(), results.class);
                                //startActivity(intent);
                            }
                        }, 1200);
                    } else if (menuButton.getHintText().equals("Estimators")) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getActivity().getBaseContext(), atcal.class);
                                startActivity(intent);
                            }
                        }, 1200);

                    }

                }
            });

        circleMenu.setEventListener(new CircleMenu.EventListener() {
            @Override
            public void onMenuOpenAnimationStart() {
                Log.d("CircleMenuStatus", "onMenuOpenAnimationStart");
            }

            @Override
            public void onMenuOpenAnimationEnd() {
                Log.d("CircleMenuStatus", "onMenuOpenAnimationEnd");
            }

            @Override
            public void onMenuCloseAnimationStart() {
                Log.d("CircleMenuStatus", "onMenuCloseAnimationStart");
            }

            @Override
            public void onMenuCloseAnimationEnd() {
                Log.d("CircleMenuStatus", "onMenuCloseAnimationEnd");
            }

            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuButton menuButton) {
                Log.d("CircleMenuStatus", "onButtonClickAnimationStart");
            }

            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuButton menuButton) {
                Log.d("CircleMenuStatus", "onButtonClickAnimationEnd");
            }

        });



    }
}
