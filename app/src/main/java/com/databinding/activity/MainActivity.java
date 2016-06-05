package com.databinding.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.databinding.fragment.BeautyGirlFragment;
import com.databinding.fragment.StarFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private final String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;

    private DrawerLayout mDrawerLayout;

    private NavigationView mNavigationView;

    private ActionBarDrawerToggle mToggle;

    private FragmentManager mFragmentManager;

    private BeautyGirlFragment mGirlFragment;

    private StarFragment mStarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initView();
        addBeautyGirlFragment();
    }

    private void findView() {
        mToolbar = (Toolbar) findViewById(R.id.id_mToolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_mDrawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.id_mNavigationView);
    }

    private void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true); //设置后退键可以使用
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mToggle.syncState();
        mDrawerLayout.setDrawerListener(mToggle);
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    private void addBeautyGirlFragment() {
        mToolbar.setTitle("美女");
        FragmentTransaction mTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(mTransaction);
        if ( mGirlFragment == null ) {
            mGirlFragment = BeautyGirlFragment.newInstance();
            mTransaction.add(R.id.id_flContainer, mGirlFragment, mGirlFragment.getClass().getSimpleName());
        } else {
            mTransaction.show(mGirlFragment);
        }
        mTransaction.commit();
    }

    private void hideFragment(FragmentTransaction mTransaction) {
        if ( mGirlFragment != null ) {
            mTransaction.hide(mGirlFragment);
        }
        if ( mStarFragment != null ) {
            mTransaction.hide(mStarFragment);
        }
    }

    private void addStarFragment() {
        mToolbar.setTitle("明星");
        FragmentTransaction mTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(mTransaction);
        if ( mStarFragment == null ) {
            mStarFragment = StarFragment.newInstance();
            mTransaction.add(R.id.id_flContainer, mStarFragment, mStarFragment.getClass().getSimpleName());
        } else {
            mTransaction.show(mStarFragment);
        }
        mTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        mDrawerLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch ( item.getItemId() ) {
                    case R.id.id_mItem_Girl:
                        addBeautyGirlFragment();
                        break;
                    case R.id.id_mItem_Star:
                        addStarFragment();
                        break;
                }

            }
        }, 200);
        return true;
    }
}
