package com.gamemobile.myapplication.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gamemobile.myapplication.R;
import com.gamemobile.myapplication.model.Addmore;

import java.util.List;

/**
 * Created by hands on 28/10/2017.
 */

public class CustomAdapter extends ArrayAdapter<Addmore> {
    private Context context;
    private int resoure;
    private List<Addmore> listAddmore;


    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Addmore> objects) {
        super(context, resource, objects);
        this.context=  context;
        this.resoure= resource;
        this.listAddmore = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_add,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = (TextView)convertView.findViewById(R.id.tv_id);
            viewHolder.tvTen = (TextView)convertView.findViewById(R.id.tv_tenmon);
            viewHolder.tvNguyenlieu = (TextView)convertView.findViewById(R.id.tv_nguyenlieu);
            viewHolder.tvCachlam  = (TextView)convertView.findViewById(R.id.tv_cachlam);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Addmore addmore = listAddmore.get(position);
        viewHolder.tvId.setText(String.valueOf(addmore.getmID()));
        viewHolder.tvTen.setText(addmore.getmTen());
        viewHolder.tvNguyenlieu.setText(addmore.getmNguyenlieu());
        viewHolder.tvCachlam.setText(addmore.getmCachlam());
        return convertView;
    }
    public class ViewHolder{

        private TextView tvId;
        private TextView tvTen;
        private TextView tvNguyenlieu;
        private TextView tvCachlam;
    }
}
