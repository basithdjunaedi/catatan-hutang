package com.basithdj.catatanhutang.models;

import android.util.Log;

import com.basithdj.catatanhutang.views.activities.MainActivity;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by basithdj on 4/8/17.
 */

public class Hutang extends RealmObject {
    @PrimaryKey
    private int id;

    private String siapa;
    private boolean saya_hutang;
    private int jumlah;
    private String deskripsi;

    private RealmList<Pembayaran> pembayaren;

    public Hutang () {
    }

    public Hutang(int id, String siapa, boolean saya_hutang, int jumlah, String deskripsi) {
        this.id = id;
        this.siapa = siapa;
        this.saya_hutang = saya_hutang;
        this.jumlah = jumlah;
        this.deskripsi = deskripsi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiapa() {
        return siapa;
    }

    public void setSiapa(String siapa) {
        this.siapa = siapa;
    }

    public boolean isSaya_hutang() {
        return saya_hutang;
    }

    public void setSaya_hutang(boolean saya_hutang) {
        this.saya_hutang = saya_hutang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public RealmList<Pembayaran> getPembayaren() {
        return pembayaren;
    }

    public void setPembayaren(RealmList<Pembayaran> pembayaren) {
        this.pembayaren = pembayaren;
    }
}
