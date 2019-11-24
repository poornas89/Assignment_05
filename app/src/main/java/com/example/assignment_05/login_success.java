package com.example.assignment_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_success extends AppCompatActivity {

    private Button latest_posts;
    private Button problems;
    private Button newsandevnts;
    private Button doations;
    private Button succsess;
    private Button find_loc;
    private Button abt_us;
    private Button cnt_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        latest_posts = findViewById(R.id.latest_posts);
        problems = findViewById(R.id.problems);
        newsandevnts = findViewById(R.id.newsandevnts);
        doations = findViewById(R.id.doations);
        succsess = findViewById(R.id.succsess);
        find_loc = findViewById(R.id.find_loc);
        abt_us = findViewById(R.id.abt_us);
        cnt_us = findViewById(R.id.cnt_us);

        latest_posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_success.this, com.example.assignment_05.latest_posts.class);
                startActivity(intent);
            }
        });


        problems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_success.this, com.example.assignment_05.problems.class);
                startActivity(intent);
            }
        });

        newsandevnts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_success.this, com.example.assignment_05.newsandevnts.class);
                startActivity(intent);
            }
        });

        doations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_success.this, com.example.assignment_05.doations.class);
                startActivity(intent);
            }
        });

        succsess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_success.this, success.class);
                startActivity(intent);
            }
        });

        find_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_success.this, findloc.class);
                startActivity(intent);
            }
        });

        abt_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_success.this, aboutus.class);
                startActivity(intent);
            }
        });

        cnt_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_success.this, contactus.class);
                startActivity(intent);
            }
        });


    }
}
