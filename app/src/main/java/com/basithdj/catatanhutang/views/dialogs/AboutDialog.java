package com.basithdj.catatanhutang.views.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.basithdj.catatanhutang.R;

/**
 * Created by basithdj on 4/24/17.
 */

public class AboutDialog extends AlertDialog.Builder {
    public AboutDialog(Context context) {
        super(context);
        setTitle("Info Aplikasi");
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_about, null);
        setView(view);
    }

    public AboutDialog(Context context, int themeResId) {
        super(context, themeResId);
    }
}
