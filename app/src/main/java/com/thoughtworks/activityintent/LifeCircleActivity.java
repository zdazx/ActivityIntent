package com.thoughtworks.activityintent;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifeCircleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle);
        System.out.println("--- Life Circle start ---");
        System.out.println("--- onCreate ---");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("--- onStart ---");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("--- onResume ---");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("--- onPause ---");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("--- onStop ---");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("--- onDestroy ---");
        System.out.println("--- Life Circle End ---");
    }
}
