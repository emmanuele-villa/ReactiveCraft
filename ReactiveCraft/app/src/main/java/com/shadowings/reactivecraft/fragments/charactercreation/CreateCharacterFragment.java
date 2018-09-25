package com.shadowings.reactivecraft.fragments.charactercreation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.shadowings.reactivecraft.R;
import com.shadowings.reactivecraft.common.core.models.charactercreation.RegionList;
import com.shadowings.reactivecraft.common.core.viewmodels.CreateCharacterViewModel;
import com.shadowings.reactivecraft.common.droid.fragments.MainSectionFragmentBase;

import java.util.ArrayList;

public class CreateCharacterFragment extends MainSectionFragmentBase<CreateCharacterViewModel> {

    Spinner regionSpinner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        assert view != null;
        regionSpinner = view.findViewById(R.id.regionSpinner);
        return view;
    }

    @Override
    protected void registerRules() {
        register(
                viewModel.getRegions().subscribe(this::setRegions)
        );
    }

    private void setRegions(RegionList strings) {
        // Creating adapter for spinner
        Context context = getContext();

        assert context != null;

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, strings);
        regionSpinner.setAdapter(dataAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_create_character;
    }
}
