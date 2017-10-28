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

public class CafeActivity extends AppCompatActivity {
    private ImageView imv_cafe_den;
    private  ImageView imv_cafe_sua;
    private  ImageView imv_cafe_capu;
    private  ImageView imv_cafe_bacxiu;
    private Button bt_them;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        imv_cafe_den = (ImageView)findViewById(R.id.imv_cf_den);
        imv_cafe_sua = (ImageView)findViewById(R.id.imv_cf_sua);
        imv_cafe_bacxiu = (ImageView)findViewById(R.id.imv_cf_bacxiu);
        imv_cafe_capu = (ImageView)findViewById(R.id.imv_cf_capuchino);
        bt_them = (Button)findViewById(R.id.bt_them1);

        imv_cafe_den.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CafeActivity.this,Cafe_denActivity.class);
                startActivity(intent);
            }
        });
        imv_cafe_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CafeActivity.this,Cafe_suaActivity.class);
                startActivity(intent);
            }
        });
        imv_cafe_capu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CafeActivity.this,Cafe_capuActivity.class);
                startActivity(intent);
            }
        });
        imv_cafe_bacxiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CafeActivity.this,Cafe_bacxiuActivity.class);
                startActivity(intent);
            }
        });
        bt_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CafeActivity.this,AddmoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
