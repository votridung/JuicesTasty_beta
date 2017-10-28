package com.gamemobile.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.gamemobile.myapplication.adapter.CustomAdapter;
import com.gamemobile.myapplication.data.DBManager;
import com.gamemobile.myapplication.model.Addmore;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //bien menu
    private ImageView imvtea;//Khởi tạo biến
    private ImageView imvst;
    private ImageView imvcafe;
    private ImageView imvne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bat su kien menu
        imvtea = (ImageView) findViewById(R.id.tea);//gán các biến vào các địa chỉ các nút bên layout
        imvst = (ImageView) findViewById(R.id.st);
        imvcafe = (ImageView) findViewById(R.id.imv_cf);
        imvne = (ImageView) findViewById(R.id.imv_juice);

        imvtea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StActivity.class);
                startActivity(intent);
            }
        });
        imvcafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CafeActivity.class);
                startActivity(intent);
            }
        });
        imvne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NeActivity.class);
                startActivity(intent);
            }
        });

    }






}
