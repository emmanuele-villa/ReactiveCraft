package com.shadowings.reactivecraft.fragments.charactercreation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.shadowings.reactivecraft.R;
import com.shadowings.reactivecraft.common.core.models.charactercreation.RealmList;
import com.shadowings.reactivecraft.common.core.models.charactercreation.RegionList;
import com.shadowings.reactivecraft.common.core.viewmodels.charactercreation.CreateCharacterViewModel;
import com.shadowings.reactivecraft.common.droid.fragments.MainSectionFragmentBase;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class CreateCharacterFragment extends MainSectionFragmentBase<CreateCharacterViewModel> {

    Spinner regionSpinner;
    Spinner realmSpinner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        assert view != null;
        regionSpinner = view.findViewById(R.id.regionSpinner);
        realmSpinner = view.findViewById(R.id.realmSpinner);

        regionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                viewModel.setRegion((String)adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    @Override
    protected void registerRules() {
        register(
                viewModel
                        .getRegions()
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::setRegions)
        );

        register(
                viewModel
                        .realmList
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::setRealms)
        );
    }

    private void setRealms(RealmList strings) {
        setSpinner(realmSpinner, strings);
    }

    private void setRegions(RegionList strings) {
        setSpinner(regionSpinner, strings);
    }

    private void setSpinner(Spinner spinner, ArrayList<String> values)
    {
        Context context = getContext();

        assert context != null;

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, values);
        spinner.setAdapter(dataAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_create_character;
    }
}
