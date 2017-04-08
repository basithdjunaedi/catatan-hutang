package com.basithdj.catatanhutang.views.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.basithdj.catatanhutang.R;
import com.basithdj.catatanhutang.controllers.HutangController;
import com.basithdj.catatanhutang.models.Hutang;

import io.realm.RealmResults;

/**
 * Created by basithdj on 4/8/17.
 */

public class HutangAdapter extends BaseAdapter {

    private RealmResults<Hutang> hutangs;
    private Context context;
    private static LayoutInflater inflater;

    public HutangAdapter(Context context) {
        this.hutangs = HutangController.getAll();
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return hutangs.size();
    }

    @Override
    public Object getItem(int position) {
        return hutangs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return hutangs.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = inflater.inflate(R.layout.listview_hutang, null);
        }

        TextView textViewJudul = (TextView) view.findViewById(R.id.textViewJudul);
        TextView textViewJumlah = (TextView) view.findViewById(R.id.textViewJumlah);

        Hutang hutang = (Hutang) getItem(position);
        textViewJudul.setText(hutang.getSiapa());
        textViewJumlah.setText("Rp, " + hutang.getJumlah());

        if (hutang.isSaya_hutang()) {
            textViewJumlah.setTextColor(Color.RED);
        }

        return view;
    }

    public void refresh() {
        hutangs = HutangController.getAll();
    }
}
