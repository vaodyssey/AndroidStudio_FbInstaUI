package com.example.fbinstaui.features.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fbinstaui.R;

public class HomeActivity extends AppCompatActivity {
    private TextView welcomeUserTextView;
    private Button closeAppButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.welcomeUserTextView = (TextView)findViewById(R.id.hello_user_text_view);
        InitializeCloseAppButton();
        GetBundles();
        EdgeToEdge.enable(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void InitializeCloseAppButton(){
        this.closeAppButton = (Button) findViewById(R.id.close_app_button);
        closeAppButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                }
        );
    }

    private void GetBundles() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String email = extras.getString("email");
            this.welcomeUserTextView.setText("Welcome back, "+email+"!");
        }
    }
}