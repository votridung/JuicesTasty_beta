package com.gamemobile.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by hands on 23/10/2017.
 */

public class NeActivity extends AppCompatActivity {
    private ImageView imv_ne_cam;
    private  ImageView imv_ne_nho;
    private  ImageView imv_ne_carot;
    private  ImageView imv_ne_nhadam;
    private Button bt_them;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ne);

        imv_ne_cam = (ImageView)findViewById(R.id.imv_ne_cam);
        imv_ne_nho = (ImageView)findViewById(R.id.imv_ne_nho);
        imv_ne_carot = (ImageView)findViewById(R.id.imv_ne_carot);
        imv_ne_nhadam = (ImageView)findViewById(R.id.imv_ne_nhadam);
        bt_them = (Button)findViewById(R.id.bt_them4);

        imv_ne_cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NeActivity.this,Ne_camActivity.class);
                startActivity(intent);
            }
        });
        imv_ne_nho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NeActivity.this,Ne_nhoActivity.class);
                startActivity(intent);
            }
        });
        imv_ne_carot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NeActivity.this,Ne_carotActivity.class);
                startActivity(intent);
            }
        });
        imv_ne_nhadam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NeActivity.this,Ne_nhadamActivity.class);
                startActivity(intent);
            }
        });
        bt_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NeActivity.this,AddmoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
