package com.basithdj.catatanhutang.controllers;

import android.util.Log;

import com.basithdj.catatanhutang.views.activities.MainActivity;
import com.basithdj.catatanhutang.models.Hutang;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by basithdj on 4/8/17.
 */

public class HutangController extends RealmController {

    public static void create (final String siapa, final boolean saya_hutang, final int jumlah, final String deskripsi) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int lastId = (int) realm.where(Hutang.class).maximumInt("id");

                Hutang hutang = new Hutang(lastId + 1, siapa, saya_hutang, jumlah, deskripsi);

                realm.copyToRealm(hutang);
                Log.d(MainActivity.LOG_TITLE, hutang.toString());
            }
        });

    }

    public static RealmResults<Hutang> getAll () {
        return realm.where(Hutang.class).findAllSorted("id", false);
    }

    public static void delete (final int id) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Hutang hutang = realm.where(Hutang.class).equalTo("id", id).findFirst();
                hutang.removeFromRealm();
            }
        });
    }
}
