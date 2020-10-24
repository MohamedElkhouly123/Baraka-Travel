package com.example.barakatravelapp.view.fragment.HomeCycle2.hajj;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.fragment.BaSeFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.discover.DiscoverFragment;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class HujjAndUmrahFragment extends BaSeFragment {
    @BindView(R.id.top_part_in_nav_genral_part_search_til)
    TextInputLayout topPartInNavGenralPartSearchTil;
    public HujjAndUmrahFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home_hujj, container, false);

        ButterKnife.bind(this, root);
        topPartInNavGenralPartSearchTil.setVisibility(View.VISIBLE);

        return root;
    }

    @Override
    public void onBack() {
        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new DiscoverFragment());
        homeCycleActivity.setNavigation("v");
        homeCycleActivity.bottomNavView.getMenu().getItem(0).setChecked(true);      }
}