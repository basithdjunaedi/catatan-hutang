package com.basithdj.catatanhutang.views.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.basithdj.catatanhutang.R;
import com.basithdj.catatanhutang.controllers.HutangController;
import com.basithdj.catatanhutang.models.Hutang;
import com.basithdj.catatanhutang.views.activities.MainActivity;

/**
 * Created by basithdj on 4/9/17.
 */

public class BayarHutangDialog extends AlertDialog.Builder {
    private MainActivity mainActivity;
    private Hutang hutang;

    public BayarHutangDialog(final Context context, final Hutang hutang) {
        super(context);
        mainActivity = (MainActivity) context;
        this.hutang = hutang;

        setTitle("Bayar Hutang");
        setView(R.layout.dialog_bayar_hutang);
        setPositiveButton("Bayar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }
}
