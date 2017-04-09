package com.basithdj.catatanhutang.views.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.basithdj.catatanhutang.R;
import com.basithdj.catatanhutang.controllers.HutangController;
import com.basithdj.catatanhutang.models.Hutang;
import com.basithdj.catatanhutang.views.activities.MainActivity;
import com.basithdj.catatanhutang.views.activities.hutang.EditHutangActivity;

/**
 * Created by basithdj on 4/8/17.
 */

public class HutangDialog extends AlertDialog.Builder {

    private Hutang hutang;
    private MainActivity mainActivity;

    public HutangDialog(final Context context, final Hutang hutang) {
        super(context);
        mainActivity = (MainActivity) context;

        this.hutang = hutang;
        final Context finalContext = context;
        setTitle(hutang.getSiapa());
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_hutang, null);

        TextView textViewJumlah = (TextView) view.findViewById(R.id.textViewJumlah);
        textViewJumlah.setText("Rp. " + hutang.getJumlah());

        TextView textViewDeskripsi = (TextView) view.findViewById(R.id.textViewDeskripsi);
        textViewDeskripsi.setText(hutang.getDeskripsi());

        if (hutang.isSaya_hutang()) {
            textViewJumlah.setTextColor(Color.RED);
        }

        setView(view);

        setNegativeButton("Edit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(mainActivity, EditHutangActivity.class);
                intent.putExtra("hutang_id", hutang.getId());

                mainActivity.startActivity(intent);
            }
        });

        setNeutralButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new AlertDialog.Builder(mainActivity)
                        .setTitle("Anda yakin akan menghapus?")
                        .setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                HutangController.delete(hutang.getId());
                                mainActivity.loadCatatanHutang();
                            }
                        }).show();
            }
        });

        setPositiveButton("Bayar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new BayarHutangDialog(context, hutang).show();
            }
        });
    }
}
