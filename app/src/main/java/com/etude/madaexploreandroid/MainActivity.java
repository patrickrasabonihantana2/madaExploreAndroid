package com.etude.madaexploreandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.etude.madaexploreandroid.controller.auth.AuthActivity;
import com.etude.madaexploreandroid.controller.front.FrontActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, FrontActivity.class);
        this.startActivity(i);
    }
}