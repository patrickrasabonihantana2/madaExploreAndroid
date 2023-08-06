package com.etude.madaexploreandroid.controller.front.publish;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etude.madaexploreandroid.R;

public class FrontPublishFragment extends Fragment {

    private FrontPublishViewModel mViewModel;

    public static FrontPublishFragment newInstance() {
        return new FrontPublishFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_front_publish, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FrontPublishViewModel.class);
        // TODO: Use the ViewModel
    }

}