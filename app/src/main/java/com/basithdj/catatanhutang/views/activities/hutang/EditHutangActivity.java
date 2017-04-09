package com.basithdj.catatanhutang.views.activities.hutang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.basithdj.catatanhutang.R;
import com.basithdj.catatanhutang.controllers.HutangController;
import com.basithdj.catatanhutang.models.Hutang;

/**
 * Created by basithdj on 4/9/17.
 */

public class EditHutangActivity extends AppCompatActivity {

    private EditText editTextSiapa, editTextJumlah, editTextDeskripsi;
    private RadioButton radioButtonSaya, radioButtonDia;
    private Button buttonSubmit;
    private Hutang hutang;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Edit Catatan Hutang");
        setContentView(R.layout.activity_create_hutang);

        editTextSiapa = (EditText) findViewById(R.id.editTextSiapa);
        editTextJumlah = (EditText) findViewById(R.id.editTextJumlah);
        editTextDeskripsi = (EditText) findViewById(R.id.editTextDeskripsi);
        radioButtonSaya = (RadioButton) findViewById(R.id.radioButtonSaya);
        radioButtonDia = (RadioButton) findViewById(R.id.radioButtonDia);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        hutang = HutangController.getHutangById(bundle.getInt("hutang_id"));

        editTextSiapa.setText(hutang.getSiapa());
        editTextJumlah.setText("" + hutang.getJumlah());
        editTextDeskripsi.setText(hutang.getDeskripsi());
        radioButtonSaya.setChecked(hutang.isSaya_hutang());
        radioButtonDia.setChecked(!hutang.isSaya_hutang());

        buttonSubmit.setText("Update");
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }

    private void update() {
        HutangController.update(hutang,
                editTextSiapa.getText().toString(), radioButtonSaya.isChecked(), Integer.parseInt(editTextJumlah.getText().toString()), editTextDeskripsi.getText().toString()
        );

        finish();
    }
}
