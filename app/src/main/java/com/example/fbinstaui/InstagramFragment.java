package com.example.fbinstaui;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

public class InstagramFragment extends Fragment {
    private ImageButton toFacebookUIButton;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_instagram, container, false);
        AttachNavigationToFacebookUIButton(view);
        return view;
    }
    private void AttachNavigationToFacebookUIButton(View view){
        toFacebookUIButton =  view.findViewById(R.id.toFacebookUIBtn);
        toFacebookUIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("hello world!");
                NavigateToFbUI();

            }
        });
    }
    private void NavigateToFbUI(){
        FacebookFragment facebookFragment = new FacebookFragment();
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                )
                .replace(R.id.nav_container,facebookFragment).commit();
    }
}

