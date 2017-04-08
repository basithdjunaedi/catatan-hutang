package com.basithdj.catatanhutang.views.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by basithdj on 4/8/17.
 */

public class HutangDialog extends AlertDialog.Builder {

    public HutangDialog(Context context) {
        super(context);

        final Context finalContext = context;
        setTitle("Detail");
        setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(finalContext, "Enjek!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
