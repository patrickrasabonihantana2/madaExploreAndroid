package com.etude.madaexploreandroid.controller.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.etude.madaexploreandroid.R;
import com.etude.madaexploreandroid.controller.auth.login.LoginFragment;
import com.etude.madaexploreandroid.controller.auth.subscribe.SubscribeFragment;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, LoginFragment.class, null)
                    .commit();
        }
    }
}