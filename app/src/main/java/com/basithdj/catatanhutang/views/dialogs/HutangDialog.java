package com.basithdj.catatanhutang.views.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.basithdj.catatanhutang.R;
import com.basithdj.catatanhutang.models.Hutang;

/**
 * Created by basithdj on 4/8/17.
 */

public class HutangDialog extends AlertDialog.Builder {

    private Hutang hutang;
    public HutangDialog(Context context, Hutang hutang) {
        super(context);

        this.hutang = hutang;
        final Context finalContext = context;
        setTitle(hutang.getSiapa());
//        setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(finalContext, "Enjek!", Toast.LENGTH_SHORT).show();
//            }
//        });
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_hutang, null);

        TextView textViewJumlah = (TextView) view.findViewById(R.id.textViewJumlah);
        textViewJumlah.setText("Rp. " + hutang.getJumlah());

        if (hutang.isSaya_hutang()) {
            textViewJumlah.setTextColor(Color.RED);
        }

        setView(view);
    }
}
