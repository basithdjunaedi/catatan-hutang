package com.basithdj.catatanhutang.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by basithdj on 4/9/17.
 */

public class Pembayaran extends RealmObject {

    @PrimaryKey
    private int id;

    private int jumlah;
    private Hutang hutang;

    public Pembayaran () {}

    public Pembayaran(int id, int jumlah) {
        this.id = id;
        this.jumlah = jumlah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Hutang getHutang() {
        return hutang;
    }

    public void setHutang(Hutang hutang) {
        this.hutang = hutang;
    }
}
