package com.gamemobile.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.gamemobile.myapplication.adapter.CustomAdapter;
import com.gamemobile.myapplication.data.DBManager;
import com.gamemobile.myapplication.model.Addmore;

import java.util.List;

/**
 * Created by hands on 26/10/2017.
 */

public class AddmoreActivity extends AppCompatActivity {
    //bien Addmore:
    private EditText edtTen;
    private EditText edtNguyenlieu;
    private EditText edtCachlam;
    private EditText edtId;
    private Button btnSave;
    private Button btnUpdate;
    private ListView lvAdd;
    private DBManager dbManager;
    private CustomAdapter customAdapter;
    private List<Addmore> addmoreList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmore);

        dbManager = new DBManager(this);
        initWidget();
        addmoreList = dbManager.getAllAdd();
        setAdapter();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Addmore addmore = createAdd();
                if (addmore != null) {
                    dbManager.addList(addmore);
                }
                updateListAdd();
                setAdapter();
            }
        });
        lvAdd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Addmore addmore = addmoreList.get(position);
                edtId.setText(String.valueOf(addmore.getmID()));
                edtTen.setText(addmore.getmTen());
                edtNguyenlieu.setText(addmore.getmNguyenlieu());
                edtCachlam.setText(addmore.getmCachlam());

                btnSave.setEnabled(false);
                btnUpdate.setEnabled(true);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Addmore addmore = new Addmore();
                addmore.setmID(Integer.parseInt(String.valueOf(edtId.getText())));
                addmore.setmTen(edtTen.getText()+"");
                addmore.setmNguyenlieu(edtNguyenlieu.getText()+"");
                addmore.setmCachlam(edtCachlam.getText()+"");

                int result = dbManager.updateAdd(addmore);
                if(result>0){
                    updateListAdd();
                }
                btnSave.setEnabled(true);
                btnUpdate.setEnabled(false);
            }
        });
        lvAdd.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Addmore addmore = addmoreList.get(position);
                int result = dbManager.deleteADD(addmore.getmID());
                if(result>0){
                    Toast.makeText(AddmoreActivity.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListAdd();
                }else{
                    Toast.makeText(AddmoreActivity.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
    private Addmore createAdd() {
        String ten = edtTen.getText().toString();
        String nguyenlieu = String.valueOf(edtNguyenlieu.getText());
        String cachlam = edtCachlam.getText().toString();

        Addmore addmore = new Addmore(ten, nguyenlieu, cachlam);
        return addmore;
    }

    private void initWidget() {
        edtTen = (EditText) findViewById(R.id.edt_tenmon);
        edtNguyenlieu = (EditText) findViewById(R.id.edt_nguyenlieu);
        edtCachlam = (EditText) findViewById(R.id.edt_cachlam);

        btnSave = (Button) findViewById(R.id.btn_save);
        lvAdd = (ListView) findViewById(R.id.lv_add);
        edtId = (EditText) findViewById(R.id.edt_id);
        btnUpdate = (Button) findViewById(R.id.btn_update);
    }

    private void setAdapter() {
        if (customAdapter == null) {
            customAdapter = new CustomAdapter(this, R.layout.item_list_add, addmoreList);
            lvAdd.setAdapter(customAdapter);
        }else{
            customAdapter.notifyDataSetChanged();
            lvAdd.setSelection(customAdapter.getCount()-1);
        }
    }
    public void updateListAdd(){
        addmoreList.clear();
        addmoreList.addAll(dbManager.getAllAdd());
        if(customAdapter!= null){
            customAdapter.notifyDataSetChanged();
        }
    }

}
