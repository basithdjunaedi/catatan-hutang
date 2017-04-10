package com.basithdj.catatanhutang.controllers;

import android.util.Log;

import com.basithdj.catatanhutang.models.Pembayaran;
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

    public static Hutang getHutangById (int id) {
        return realm.where(Hutang.class).equalTo("id", id).findFirst();
    }

    public static RealmResults<Hutang> getAll () {
        return realm.where(Hutang.class).findAllSorted("id", false);
    }

    public static void update (final Hutang hutang, final String siapa, final boolean saya_hutang, final int jumlah, final String deskripsi) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                hutang.setSiapa(siapa);
                hutang.setSaya_hutang(saya_hutang);
                hutang.setJumlah(jumlah);
                hutang.setDeskripsi(deskripsi);
                realm.copyToRealmOrUpdate(hutang);
            }
        });
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

    public static void bayarHutang (final Hutang hutang, final int jumlah) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int lastIdPembayaran = (int) realm.where(Pembayaran.class).maximumInt("id");
                Pembayaran pembayaran = new Pembayaran(lastIdPembayaran + 1, jumlah);
                realm.copyToRealm(pembayaran);

                hutang.getPembayaren().add(pembayaran);
            }
        });
    }

    public static int getJumlahTerbayar (Hutang hutang) {
        int total = 0;

        for (Pembayaran pembayaran : hutang.getPembayaren()) {
            total += pembayaran.getJumlah();
        }

        return total;
    }
}
