package com.etude.madaexploreandroid.controller.front.home.site.detail;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etude.madaexploreandroid.R;

public class SiteDetailFragment extends Fragment {

    private SiteDetailViewModel mViewModel;

    public static SiteDetailFragment newInstance() {
        return new SiteDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_site_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SiteDetailViewModel.class);
        // TODO: Use the ViewModel
    }

}