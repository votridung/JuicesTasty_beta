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

public class StActivity extends AppCompatActivity {
    private ImageView imv_st_dau;
    private  ImageView imv_st_bo;
    private  ImageView imv_st_vietquat;
    private  ImageView imv_st_sapo;
    private Button bt_them;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st);

        imv_st_dau = (ImageView) findViewById(R.id.imv_std);
        imv_st_bo = (ImageView) findViewById(R.id.imv_stb);
        imv_st_vietquat = (ImageView) findViewById(R.id.imv_stvq);
        imv_st_sapo = (ImageView) findViewById(R.id.imv_stsp) ;
        bt_them = (Button)findViewById(R.id.bt_them3);

        imv_st_dau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StActivity.this,St_dauActivity.class);
                startActivity(intent);
            }
        });
        imv_st_bo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StActivity.this,St_boActivity.class);
                startActivity(intent);
            }
        });
        imv_st_sapo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StActivity.this,St_sapoActivity.class);
                startActivity(intent);
            }
        });
        imv_st_vietquat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StActivity.this,St_vietquatActivity.class);
                startActivity(intent);
            }
        });
        bt_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StActivity.this,AddmoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
