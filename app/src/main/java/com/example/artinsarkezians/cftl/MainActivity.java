package com.example.artinsarkezians.cftl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_qf) {
            // Handle the camera action
        } else if (id == R.id.nav_vector) {

        } else if (id == R.id.nav_otherShit) {

        } else if (id == R.id.nav_otherOtherShit) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void buttonClick (View view) {
        TextView t1 = (TextView) findViewById(R.id.ansOne);
        TextView t2 = (TextView) findViewById(R.id.ansTwo);
        TextView aValInp = (TextView) findViewById(R.id.editText3);
        TextView bValInp = (TextView) findViewById(R.id.editText4);
        TextView cValInp = (TextView) findViewById(R.id.editText2);
        double a = 0, b = 0, c = 0;

        try {
            a = Double.parseDouble(aValInp.getText().toString());
            b = Double.parseDouble(bValInp.getText().toString());
            c = Double.parseDouble(cValInp.getText().toString());
        }
        catch (Exception e) {
            //do nothing
        }

        double ansOne, ansTwo, temp = (b*b)-(4*a*c);

        if (temp <0) {
            ansOne = (((b*-1) + Math.sqrt(temp*-1)) /(2*a));
            ansTwo = (((b*-1) - Math.sqrt(temp*-1)) /(2*a));

            ansOne *= 10000;
            ansOne = Math.round(ansOne);
            ansOne /= 10000;
            ansTwo *= 10000;
            ansTwo = Math.round(ansTwo);
            ansTwo /= 10000;

            t1.setText("Ans 1: " + ansOne +"i");
            t2.setText("Ans 2: " + ansTwo +"i");
        }
        else {
            ansOne = (((b*-1) + Math.sqrt(temp)) /(2*a));
            ansTwo = (((b*-1) - Math.sqrt(temp)) /(2*a));

            ansOne *= 10000;
            ansOne = Math.round(ansOne);
            ansOne /= 10000;
            ansTwo *= 10000;
            ansTwo = Math.round(ansTwo);
            ansTwo /= 10000;

            t1.setText("Ans 1: " + ansOne);
            t2.setText("Ans 2: " + ansTwo);
        }

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
