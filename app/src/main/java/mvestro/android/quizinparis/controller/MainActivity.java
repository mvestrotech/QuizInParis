package mvestro.android.quizinparis.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import mvestro.android.quizinparis.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        private Button mBtnP1;
        private Button mBtnP2;
        private Button mBtnP3;
        private Button mBtnP4;
        private Button mBtnP5;
        private Button mBtnP6;
        private Button mBtnP7;
        private Button mBtnP8;
        private Button mBtnP9;
        private Button mBtnP10;
        private Button mBtnP11;
        private Button mBtnP12;
        private Button mBtnP13;
        private Button mBtnP14;
        private Button mBtnP15;
        private Button mBtnP16;
        private Button mBtnP17;
        private Button mBtnP18;
        private Button mBtnP19;
        private Button mBtnP20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mBtnP1 = (Button) findViewById(R.id.activity_paris_1);
        mBtnP2 = (Button) findViewById(R.id.activity_paris_2);
        mBtnP3 = (Button) findViewById(R.id.activity_paris_3);
        mBtnP4 = (Button) findViewById(R.id.activity_paris_4);
        mBtnP5 = (Button) findViewById(R.id.activity_paris_5);
        mBtnP6 = (Button) findViewById(R.id.activity_paris_6);
        mBtnP7 = (Button) findViewById(R.id.activity_paris_7);
        mBtnP8 = (Button) findViewById(R.id.activity_paris_8);
        mBtnP9 = (Button) findViewById(R.id.activity_paris_9);
        mBtnP10 = (Button) findViewById(R.id.activity_paris_10);
        mBtnP11 = (Button) findViewById(R.id.activity_paris_11);
        mBtnP12 = (Button) findViewById(R.id.activity_paris_12);
        mBtnP13 = (Button) findViewById(R.id.activity_paris_13);
        mBtnP14 = (Button) findViewById(R.id.activity_paris_14);
        mBtnP15 = (Button) findViewById(R.id.activity_paris_15);
        mBtnP16 = (Button) findViewById(R.id.activity_paris_16);
        mBtnP17 = (Button) findViewById(R.id.activity_paris_17);
        mBtnP18 = (Button) findViewById(R.id.activity_paris_18);
        mBtnP19 = (Button) findViewById(R.id.activity_paris_19);
        mBtnP20 = (Button) findViewById(R.id.activity_paris_20);

        mBtnP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivityIntent);
            }
        });
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
}
