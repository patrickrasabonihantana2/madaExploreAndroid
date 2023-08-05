package com.etude.madaexploreandroid.controller.auth.subscribe;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.etude.madaexploreandroid.R;
import com.etude.madaexploreandroid.controller.auth.AuthActivity;
import com.etude.madaexploreandroid.controller.auth.login.LoginFragment;

public class SubscribeFragment extends Fragment {

    private SubscribeViewModel mViewModel;

    public static SubscribeFragment newInstance() {
        return new SubscribeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subscribe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button toSubscribeButton = (Button) view.findViewById(R.id.auth_link_button_login);
        toSubscribeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getParentFragmentManager();
                manager.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view, LoginFragment.class, null)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SubscribeViewModel.class);
        // TODO: Use the ViewModel
    }

}