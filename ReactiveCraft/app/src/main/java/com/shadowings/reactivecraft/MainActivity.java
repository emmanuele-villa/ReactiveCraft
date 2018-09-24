package com.shadowings.reactivecraft;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shadowings.reactivecraft.common.core.viewmodels.splash.SplashViewModel;
import com.shadowings.reactivecraft.fragments.splash.SplashFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SplashFragment splashFragment = new SplashFragment();
        SplashViewModel splashViewModel = new SplashViewModel();
        splashFragment.setViewModel(splashViewModel);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, splashFragment).commit();
    }
}
