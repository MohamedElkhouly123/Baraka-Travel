package com.example.barakatravelapp.view.fragment.HomeCycle2.accounts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.fragment.BaSeFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.discover.DiscoverFragment;

import butterknife.ButterKnife;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class GetEVisaFragment extends BaSeFragment {

    public GetEVisaFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_get_e_visa, container, false);

        ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onBack() {
        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new AccountFragment());
        homeCycleActivity.setNavigation("v");
        homeCycleActivity.bottomNavView.getMenu().getItem(4).setChecked(true);     }
}