package com.shadowings.reactivecraft.fragments.home;

import com.shadowings.reactivecraft.R;
import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;
import com.shadowings.reactivecraft.common.droid.fragments.MainSectionFragmentBase;

public class HomeFragment extends MainSectionFragmentBase<HomeViewModel> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
