package com.example.barakatravelapp.view.fragment.userCycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.activity.HomeCycleActivity;
import com.example.barakatravelapp.view.activity.UserCycleActivity;
import com.example.barakatravelapp.view.fragment.BaSeFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class LoginFragment extends BaSeFragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onBack() {
//        replaceFragment(getActivity().getSupportFragmentManager(), R.id.splash_activity_fram, new LoginFragment());
    }


    @OnClick({R.id.fragment_login_for_sign_up_tv, R.id.about_app_slide4_btn_begin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_login_for_sign_up_tv:
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.user_activity_fram, new SignUpFragment());

                break;
            case R.id.about_app_slide4_btn_begin:
                startActivity(new Intent(getActivity(), HomeCycleActivity.class));
                getActivity().finish();
                break;
        }
    }
}