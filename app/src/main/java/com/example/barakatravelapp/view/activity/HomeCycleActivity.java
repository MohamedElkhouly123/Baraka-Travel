package com.example.barakatravelapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.example.barakatravelapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.ButterKnife;


public class HomeCycleActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


//    public HomeFragment homeFragment;


    public BottomNavigationView navView;
//    private ClientData clientData;

    public HomeCycleActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cycle);
        ButterKnife.bind(this);
//        child = this;
//        homeFragment=new HomeFragment();
//        clientData = LoadUserData(this);
//        replaceFragment(getSupportFragmentManager(), R.id.home_activity_fram,new HomeFragment());
        navView = (BottomNavigationView) findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);


    }

    private void displayView(int position) {
        switch (position) {
            case 0:
                Intent intentHome = new Intent(HomeCycleActivity.this,HomeCycleActivity.class);
                startActivity(intentHome);
                break;
            case 1:
                Intent intentHome2 = new Intent(HomeCycleActivity.this,HomeCycleActivity.class);
                startActivity(intentHome2);
                break;}}
    public void setNavigation(String visibility) {
        navView = (BottomNavigationView) findViewById(R.id.nav_view);
        if (visibility.equals("v")) {
            navView.setVisibility(View.VISIBLE);
        } else if (visibility.equals("g")) {
            navView.setVisibility(View.GONE);
        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navigation_account) {
//            replaceFragment(getSupportFragmentManager(), R.id.home_activity_fram,new HomeFragment());
        } else if (id == R.id.navigation_hotels) {
//            if(clientData!=null) {
//                replaceFragment(getSupportFragmentManager(), R.id.home_activity_fram, new RestaurantAndClientEditProfileFragment());
//            }else {
//                goToRegisterFirst(this);
//                goLogin = true;
//                backFromLogin=true;
//            }
        } else if (id == R.id.navigation_flight) {
//            replaceFragment(getSupportFragmentManager(), R.id.home_activity_fram, new MenuesFragment());

        } else if (id == R.id.navigation_hajj) {
//            replaceFragment(getSupportFragmentManager(), R.id.home_activity_fram, new MoreFragment());
        }
        else if (id == R.id.navigation_discover) {
//            replaceFragment(getSupportFragmentManager(), R.id.home_activity_fram, new MoreFragment());
        }

        return true;
    }






}
