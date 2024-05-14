package com.example.fbinstaui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

public class FacebookFragment extends Fragment {
    private ImageButton toInstagramUIButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facebook, container, false);
        AttachNavigationToInstagramUIButton(view);
        return view;
    }

    private void AttachNavigationToInstagramUIButton(View view) {
        toInstagramUIButton = view.findViewById(R.id.toInstagramUIBtn);
        toInstagramUIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigateToInstagramUI();
            }
        });
    }
    private void NavigateToInstagramUI(){
        InstagramFragment instagramFragment = new InstagramFragment();
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                )
                .replace(R.id.nav_container, instagramFragment).commit();
    }
}
