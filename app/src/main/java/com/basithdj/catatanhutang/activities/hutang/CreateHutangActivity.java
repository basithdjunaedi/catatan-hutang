package com.basithdj.catatanhutang.activities.hutang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.basithdj.catatanhutang.R;
import com.basithdj.catatanhutang.controllers.HutangController;

public class CreateHutangActivity extends AppCompatActivity {

    private EditText editTextSiapa, editTextJumlah, editTextDeskripsi;
    private RadioButton radioButtonSaya, radioButtonDia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Buat Catatan Hutang");
        setContentView(R.layout.activity_create_hutang);

        editTextSiapa = (EditText) findViewById(R.id.editTextSiapa);
        editTextJumlah = (EditText) findViewById(R.id.editTextJumlah);
        editTextDeskripsi = (EditText) findViewById(R.id.editTextJumlah);
        radioButtonSaya = (RadioButton) findViewById(R.id.radioButtonSaya);
        radioButtonSaya.setEnabled(true);
        radioButtonDia = (RadioButton) findViewById(R.id.radioButtonDia);
    }

    public void simpanCatatanHutang (View v) {
        HutangController.create(
            editTextSiapa.getText().toString(), radioButtonSaya.isSelected(), Double.parseDouble(editTextJumlah.getText().toString()), editTextDeskripsi.getText().toString()
        );

        finish();
    }
}
