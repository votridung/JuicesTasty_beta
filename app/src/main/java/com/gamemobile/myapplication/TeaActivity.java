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

public class TeaActivity extends AppCompatActivity {
    private ImageView imv_tea_bee;
    private  ImageView imv_tea_gung;
    private  ImageView imv_tea_chanh;
    private  ImageView imv_tea_tat;
    private Button bt_them;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea);

        imv_tea_bee = (ImageView)findViewById(R.id.imv_tea_bee);
        imv_tea_chanh = (ImageView)findViewById(R.id.imv_tea_chanh);
        imv_tea_gung = (ImageView)findViewById(R.id.imv_tea_gung);
        imv_tea_tat = (ImageView)findViewById(R.id.imv_tea_tac);
        bt_them = (Button)findViewById(R.id.bt_them2);

        imv_tea_bee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeaActivity.this,Tea_beeActivity.class);
                startActivity(intent);
            }
        });
        imv_tea_gung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeaActivity.this,Tea_gungActivity.class);
                startActivity(intent);
            }
        });
        imv_tea_tat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeaActivity.this,Tea_tatActivity.class);
                startActivity(intent);
            }
        });
        imv_tea_chanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeaActivity.this,Tea_chanhActivity.class);
                startActivity(intent);
            }
        });
        bt_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeaActivity.this,AddmoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
