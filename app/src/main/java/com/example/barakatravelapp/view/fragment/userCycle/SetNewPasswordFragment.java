package com.example.barakatravelapp.view.fragment.userCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.fragment.BaSeFragment;

import butterknife.ButterKnife;


public class SetNewPasswordFragment extends BaSeFragment {

    public SetNewPasswordFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_splash, container, false);

        ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onBack() {
//        replaceFragment(getActivity().getSupportFragmentManager(), R.id.user_activity_fram, new LoginFragment());
    }
}