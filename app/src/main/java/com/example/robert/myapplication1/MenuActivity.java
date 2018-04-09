package com.example.robert.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by Robert on 2018-02-22.
 */

public class MenuActivity extends AppCompatActivity {

    private ShareActionProvider mshareActionProvider;

    @BindView(R.id.butterKnifeID)
    TextView butterKnifeIdText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //robert sadzi sredniki gdzie popdanie

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.main_menu_myicon){
            Intent intent = new Intent(this,Call.class);
            startActivity(intent);
        }

        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student, menu);
        return true;
    }
    //;
   /* public void setShareIntent(Intent shareIntent) {
        if (mshareActionProvider != null) {
            mshareActionProvider.setShareIntent(shareIntent);
        }
    }*/

//;

}
