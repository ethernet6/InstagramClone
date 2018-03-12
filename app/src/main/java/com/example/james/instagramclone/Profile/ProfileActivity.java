package com.example.james.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.james.instagramclone.R;
import com.example.james.instagramclone.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by James on 12/09/2017.
 */

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";

    private Context mContext = ProfileActivity.this;
    private static final int ACTIVITY_NUM = 4;

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: starting...");

        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);

        //setupBottomNavigationView();
        setupToolbar();
    }

private void setupToolbar(){
    Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
    setSupportActionBar(toolbar);

    ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);

    profileMenu.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Log.d(TAG, "onClick: naviagating to account settings. ");
            Intent intent = new Intent(mContext, AccountSettingsActivity.class);
            startActivity(intent);
        }
    });

//    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//        @Override
//        public boolean onMenuItemClick(MenuItem item) {
//            Log.d(TAG, "onMenuItemClick: clicked menu item " + item);
//
//            switch (item.getItemId()){
//
//                case R.id.profileMenu:
//                    Log.d(TAG, "onMenuItemClick: Navigating to profile preferences");
//            }
//            return false;
//        }
//    });
}
    /**
     * BottomNavigationView Setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up Bottom Navigation View");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);

        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.profile_menu, menu);
//        return true;
//    }
}
