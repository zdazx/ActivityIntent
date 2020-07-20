package com.thoughtworks.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button practice = findViewById(R.id.practice);
        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSelectContactActivity();
            }
        });
    }

    private void openSelectContactActivity() {
        Intent intent = new Intent(this, SelectContactActivity.class);
        startActivity(intent);
    }
}