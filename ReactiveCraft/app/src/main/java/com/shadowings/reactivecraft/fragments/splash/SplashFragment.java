package com.shadowings.reactivecraft.fragments.splash;

import com.shadowings.reactivecraft.R;
import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.splash.SplashViewModel;
import com.shadowings.reactivecraft.common.droid.fragments.MainSectionFragmentBase;
import com.shadowings.reactivecraft.fragments.home.HomeFragment;

import java.util.Objects;

public class SplashFragment extends MainSectionFragmentBase<SplashViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }

    @Override
    protected void registerRules() {
        register(
                viewModel
                        .homeViewModelObservable
                        .subscribe(this::openHome)
        );
    }

    private void openHome(HomeViewModel homeViewModel) {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setViewModel(homeViewModel);

        Objects.requireNonNull(getActivity())
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, homeFragment)
                .commit();
    }
}
