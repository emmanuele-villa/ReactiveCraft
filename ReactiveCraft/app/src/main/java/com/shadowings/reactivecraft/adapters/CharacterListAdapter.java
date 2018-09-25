package com.shadowings.reactivecraft.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.shadowings.reactivecraft.common.core.viewmodels.home.CharacterPreviewListViewModel;
import com.shadowings.reactivecraft.views.home.CharacterPreviewView;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder> {

    private CharacterPreviewListViewModel characterPreviewList;

    public CharacterListAdapter(CharacterPreviewListViewModel characterPreviewList) {
        this.characterPreviewList = characterPreviewList;
    }

    public void setCharacterPreviewList(CharacterPreviewListViewModel list) {
        this.characterPreviewList = list;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CharacterPreviewView v = new CharacterPreviewView(viewGroup.getContext());
        return new CharacterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder characterViewHolder, int i) {
        CharacterPreviewView view = (CharacterPreviewView) characterViewHolder.itemView;
        view.setViewModel(characterPreviewList.get(i));
    }

    @Override
    public int getItemCount() {
        return characterPreviewList.size();
    }

    public static class CharacterViewHolder extends RecyclerView.ViewHolder {
        public CharacterViewHolder(CharacterPreviewView v) {
            super(v);
        }
    }
}
