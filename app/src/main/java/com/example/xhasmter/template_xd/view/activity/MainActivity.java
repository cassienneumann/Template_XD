package com.example.xhasmter.template_xd.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.xhasmter.template_xd.R;
import com.example.xhasmter.template_xd.services.adapter.ViewPagerAdapter;
import com.example.xhasmter.template_xd.view.fragment.ActualiteFragment;
import com.example.xhasmter.template_xd.view.fragment.GeneralFragment;
import com.example.xhasmter.template_xd.view.fragment.NouveauFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //object tabLayout
    private TabLayout tabLayout;
    //object viewPager
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the toolbar with view ID toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //make the action bar visible
        setSupportActionBar(toolbar);

        //Find the drawer with view ID drawer_layout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //Set the opening and closing navigation drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        // Listener the drawer toggle
        drawer.addDrawerListener(toggle);
        //Sync the state of toggle
        toggle.syncState();

        //Find the navigationView with view ID nav_view
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //
        navigationView.setNavigationItemSelectedListener(this);

        //Find the viewPager with view ID viewpager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //
        setupViewPager(viewPager);

        //Find the tabLayout with view ID tabs
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        //
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     *
     */
    public void setupViewPager(ViewPager viewPager) {
        //
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ActualiteFragment(), "Actualite");
        adapter.addFragment(new NouveauFragment(), "Nouveau");
        adapter.addFragment(new GeneralFragment(), "General");
        viewPager.setAdapter(adapter);
    }

    /**
     *  Setting the onBackPressed of drawer
     */
    @Override
    public void onBackPressed() {
        //
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     *  setting onCreateOptionsMenu for getting view of Menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     *  Setting onOptionItemSelected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //Handle the Mon appareil action
        if (id == R.id.nav_my_account) {

            Toast.makeText(this,"My Account",Toast.LENGTH_SHORT).show();

            // Handle the Notification action
        } else if (id == R.id.nav_notification) {

            Toast.makeText(this,"Notifications",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_xda_forum) {

            Intent intent = new Intent(this,ConnexionActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_share_app){

            Toast.makeText(this,"Share app",Toast.LENGTH_SHORT).show();


        }else if (id == R.id.nav_rate_app){

            Toast.makeText(this,"Rate App",Toast.LENGTH_SHORT).show();


        }else if (id == R.id.nav_help){

            Toast.makeText(this,"Help",Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void settingClick(View view) {

        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }
}
