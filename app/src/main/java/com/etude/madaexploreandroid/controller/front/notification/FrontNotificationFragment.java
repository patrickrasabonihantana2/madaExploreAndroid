package com.etude.madaexploreandroid.controller.front.notification;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etude.madaexploreandroid.R;

public class FrontNotificationFragment extends Fragment {

    private FronNotificationViewModel mViewModel;

    public static FrontNotificationFragment newInstance() {
        return new FrontNotificationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_front_notification, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FronNotificationViewModel.class);
        // TODO: Use the ViewModel
    }

}