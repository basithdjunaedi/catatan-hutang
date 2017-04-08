package com.basithdj.catatanhutang.controllers;

import com.basithdj.catatanhutang.models.Hutang;

import io.realm.Realm;

/**
 * Created by basithdj on 4/8/17.
 */

public class HutangController extends RealmController {

    public static void create (final String siapa, final boolean saya_hutang, final double jumlah, final String deskripsi) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int lastId = (int) realm.where(Hutang.class).maximumInt("id");

                Hutang hutang = new Hutang(lastId + 1, siapa, saya_hutang, jumlah, deskripsi);

                System.out.println(hutang.toString());
            }
        });
    }
}
