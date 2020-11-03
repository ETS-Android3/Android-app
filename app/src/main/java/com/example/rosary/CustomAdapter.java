package com.example.rosary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] pray;
    LayoutInflater inflater;

    public CustomAdapter(Context c, String [] p){
        context = c;
        pray = p;
        inflater = (LayoutInflater.from(c));
    }

    @Override
    public int getCount() {
        return pray.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public void updateAdapter(String [] p){
        pray = p;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.list,null);
        TextView prayNow = (TextView) view.findViewById(R.id.pr);
        prayNow.setText(pray[i]);
        return view;
    }
}
