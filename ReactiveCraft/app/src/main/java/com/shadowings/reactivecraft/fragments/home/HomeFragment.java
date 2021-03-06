package com.shadowings.reactivecraft.fragments.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shadowings.reactivecraft.R;
import com.shadowings.reactivecraft.adapters.CharacterListAdapter;
import com.shadowings.reactivecraft.common.core.viewmodels.charactercreation.CreateCharacterViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.home.CharacterPreviewListViewModel;
import com.shadowings.reactivecraft.common.core.viewmodels.home.HomeViewModel;
import com.shadowings.reactivecraft.common.droid.fragments.MainSectionFragmentBase;
import com.shadowings.reactivecraft.fragments.charactercreation.CreateCharacterFragment;

import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class HomeFragment extends MainSectionFragmentBase<HomeViewModel> {

    //region view setup

    private FloatingActionButton fab;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        assert v != null;
        setupRecyclerView(v);
        setupFab(v);
        return v;
    }

    private void setupFab(View v) {
        fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(this::requestOpenCharacterCreation);
    }

    private void requestOpenCharacterCreation(View view) {
        viewModel.requestCharacterCreationViewModel();
    }

    private void setupRecyclerView(View v) {
        recyclerView = v.findViewById(R.id.character_list_recyclerView);

        LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(lm);

        CharacterListAdapter adapter = new CharacterListAdapter(new CharacterPreviewListViewModel());
        recyclerView.setAdapter(adapter);
    }

    //endregion

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void registerRules() {
        register(
                viewModel
                        .characterPreviewListObservable
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::updateList)
        );

        register(
                viewModel
                        .createCharacterViewModelObservable
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::openCharacterCreation)
        );
    }

    private void openCharacterCreation(CreateCharacterViewModel createCharacterViewModel) {

        CreateCharacterFragment createCharacterFragment = new CreateCharacterFragment();
        createCharacterFragment.setViewModel(createCharacterViewModel);

        Objects.requireNonNull(getActivity())
                .getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(createCharacterFragment.getClass().getName())
                .replace(R.id.frame_layout, createCharacterFragment)
                .commit();
    }

    private void updateList(CharacterPreviewListViewModel vms) {
        CharacterListAdapter adapter = (CharacterListAdapter) recyclerView.getAdapter();
        assert adapter != null;
        adapter.setCharacterPreviewList(vms);
        adapter.notifyDataSetChanged();
    }
}
