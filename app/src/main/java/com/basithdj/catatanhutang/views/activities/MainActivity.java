package com.basithdj.catatanhutang.views.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.basithdj.catatanhutang.R;
import com.basithdj.catatanhutang.views.activities.hutang.CreateHutangActivity;
import com.basithdj.catatanhutang.controllers.HutangController;
import com.basithdj.catatanhutang.models.Hutang;
import com.basithdj.catatanhutang.views.activities.hutang.EditHutangActivity;
import com.basithdj.catatanhutang.views.adapters.HutangAdapter;
import com.basithdj.catatanhutang.views.dialogs.BayarHutangDialog;
import com.basithdj.catatanhutang.views.dialogs.HutangDialog;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class
MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String LOG_TITLE = "catatan_hutang";
    private ListView listViewCatatanHutang;
    private HutangAdapter hutangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RealmConfiguration configuration = new RealmConfiguration.Builder(this)
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(configuration);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listViewCatatanHutang = (ListView) findViewById(R.id.listViewCatatanHutang);
        listViewCatatanHutang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final HutangAdapter adapter = (HutangAdapter) listViewCatatanHutang.getAdapter();
                final Hutang hutang = (Hutang) adapter.getItem(position);
                new HutangDialog(MainActivity.this, hutang)
                        .setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                loadCatatanHutang();
                            }
                        }).show();
            }
        });
        hutangAdapter = new HutangAdapter(this);
        listViewCatatanHutang.setAdapter(hutangAdapter);
    }

    public void loadCatatanHutang() {
        hutangAdapter.refresh();
        hutangAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        loadCatatanHutang();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openCreateActivity (View view) {
        startActivity(new Intent(this, CreateHutangActivity.class));
    }
}
