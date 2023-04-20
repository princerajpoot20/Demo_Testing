package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.paper.Adapters.CuratedAdapter;
import com.example.paper.Listeners.CuratedResponseListener;
import com.example.paper.Listeners.OnRecyclerClickListener;
import com.example.paper.Listeners.SearchResponseListener;
import com.example.paper.Models.CuratedAPIResponse;
import com.example.paper.Models.Photo;
import com.example.paper.Models.SearchAPIResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnRecyclerClickListener {

    RecyclerView recyclerView_home;
    CuratedAdapter adapter;
    ProgressDialog dialog;
    RequestManager manager;
    FloatingActionButton fab_next,fab_prev;
    int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        fab_next = findViewById(R.id.fab_next);
        fab_prev = findViewById(R.id.fab_prev);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Good thing come to those who wait...");

        manager = new RequestManager(this);
        manager.getCuratedWallpapers(listener,"1");

        fab_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String next_page = String.valueOf(page+1);
                manager.getCuratedWallpapers(listener,next_page);
                dialog.show();
            }
        });
        fab_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (page>1) {
                    String prev_page = String.valueOf(page-1);
                    manager.getCuratedWallpapers(listener,prev_page);
                    dialog.show();
                }
            }
        });
    }



}