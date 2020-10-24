package com.example.barakatravelapp.view.fragment.HomeCycle2.accounts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.fragment.BaSeFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.discover.DiscoverFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.hotels.HottelViewFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class AccountFragment extends BaSeFragment {

    public AccountFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home_account_profile, container, false);

        ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onBack() {
        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new DiscoverFragment());
        homeCycleActivity.setNavigation("v");
        homeCycleActivity.bottomNavView.getMenu().getItem(0).setChecked(true);      }

    @OnClick({R.id.fragment_home_account_profile_edit_bttn, R.id.fragment_home_account_profile_e_visa_bttn, R.id.fragment_home_account_profile_cardview_my_account_item_next_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_account_profile_edit_bttn:
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new ChangeDetailsFragment());
                homeCycleActivity.setNavigation("g");

                break;
            case R.id.fragment_home_account_profile_e_visa_bttn:
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new GetEVisaFragment());
                homeCycleActivity.setNavigation("g");

                break;
            case R.id.fragment_home_account_profile_cardview_my_account_item_next_btn:
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new MyUmrahBookingFragment());
                homeCycleActivity.setNavigation("g");

                break;
        }
    }
}