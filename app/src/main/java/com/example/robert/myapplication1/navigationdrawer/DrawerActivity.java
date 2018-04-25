package com.example.robert.myapplication1.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.robert.myapplication1.R;


public class DrawerActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private FirstDrawerFragment firstFragment = new FirstDrawerFragment();
    private SecondDrawerFragment secondDrawerFragment = new SecondDrawerFragment();
    private ThirdDrawerFragment thirdDrawerFragment = new ThirdDrawerFragment();
    private FourthDrawerFragment fourthDrawerFragment = new FourthDrawerFragment();

    private NavigationView navigationView;
    private TextView textHomeDrawerHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        textHomeDrawerHeader = (TextView) findViewById(R.id.textHomeDrawerHeader);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        showToolbar();
        showActionBar();
        addDrawerListener();
        setFragments();


    }

    public void showToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void showActionBar() {
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addDrawerListener() {
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    public void setFragments(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()){
                    case R.id.nav_camera:
                        ft.replace(R.id.content_frame,firstFragment);
                        break;

                    case R.id.nav_gallery:
                        ft.replace(R.id.content_frame,secondDrawerFragment);
                        break;

                    case R.id.nav_slideshow:
                        ft.replace(R.id.content_frame,thirdDrawerFragment);
                        break;

                    case R.id.nav_manage:
                        ft.replace(R.id.content_frame,fourthDrawerFragment);
                        break;

                    default:
                        break;
                }
                ft.commit();
                return true;
            }
        });
    }

}
