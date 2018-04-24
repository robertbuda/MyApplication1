package com.example.robert.myapplication1.simpleworks;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.fragment.FirstFragment;
import com.example.robert.myapplication1.fragment.FragmentActivity;
import com.example.robert.myapplication1.fragment.SecondFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fragments.AirplaneModeChangeReceiver;
import fragments.MyPagerAdapter;
import fragments.ThirdFragment;

public class PagesActivity extends AppCompatActivity {

    @BindView(R.id.pages_pager)
    ViewPager viewPager;

    private List<Fragment> fragmentList = new ArrayList<>();
    private AirplaneModeChangeReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages);
        ButterKnife.bind(this);
        setupViewPager();
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewPager.setCurrentItem(fragmentList.size() - 1);
        registerAirplaneModeChangeReceiver();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterAirplaneModeChangeReceiver();
    }

    private void setupViewPager() {
        fragmentList.add(new FirstFragment());
        fragmentList.add(new SecondFragment());
        //fragmentList.add(new ThirdFragment());

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragmentList));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // Notifies when a page was scrolled to (selected)
                Toast.makeText(getApplicationContext(), String.format("Hey! This is page %d", position + 1), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void registerAirplaneModeChangeReceiver() {
        receiver = new AirplaneModeChangeReceiver();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(receiver, intentFilter);
    }

    private void unregisterAirplaneModeChangeReceiver() {
        unregisterReceiver(receiver);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

}
