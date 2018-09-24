package com.shadowings.reactivecraft.fragments.splash;

import com.shadowings.reactivecraft.R;
import com.shadowings.reactivecraft.common.core.viewmodels.splash.SplashViewModel;
import com.shadowings.reactivecraft.common.droid.fragments.FragmentBase;
import com.shadowings.reactivecraft.common.droid.fragments.MainSectionFragmentBase;

public class SplashFragment extends MainSectionFragmentBase<SplashViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }
}
