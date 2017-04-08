package com.basithdj.catatanhutang.controllers;

import io.realm.Realm;

/**
 * Created by basithdj on 4/8/17.
 */

public class RealmController {

    public static RealmController instance;
    protected static final Realm realm = Realm.getDefaultInstance();

    public static RealmController getInstance() {
        return instance;
    }

    public static void setInstance(RealmController instance) {
        RealmController.instance = instance;
    }

    public Realm getRealm() {
        return realm;
    }
}
