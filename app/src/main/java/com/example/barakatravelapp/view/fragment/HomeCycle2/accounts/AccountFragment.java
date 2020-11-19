package com.example.barakatravelapp.view.fragment.HomeCycle2.accounts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.fragment.BaSeFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.discover.DiscoverFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class AccountFragment extends BaSeFragment {

    private NavController navController;
    public AccountFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home_account_profile, container, false);

        ButterKnife.bind(this, root);
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment);

        return root;
    }

    @Override
    public void onBack() {
//        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new DiscoverFragment());
        navController.navigate(R.id.action_navigation_account_to_navigation_discover);
//        homeCycleActivity.setNavigation("v");
//        homeCycleActivity.bottomNavView.getMenu().getItem(0).setChecked(true);
    }

    @OnClick({R.id.fragment_home_account_profile_edit_bttn, R.id.fragment_home_account_profile_e_visa_bttn, R.id.fragment_home_account_profile_cardview_my_account_item_next_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_account_profile_edit_bttn:
//                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new ChangeDetailsFragment());
                navController.navigate(R.id.action_navigation_account_to_changeDetailsFragment);
                homeCycleActivity.setNavigation("g");

                break;
            case R.id.fragment_home_account_profile_e_visa_bttn:
//                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new GetEVisaFragment());
                navController.navigate(R.id.action_navigation_account_to_getEVisaFragment);
                homeCycleActivity.setNavigation("g");


                break;
            case R.id.fragment_home_account_profile_cardview_my_account_item_next_btn:
//                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new MyUmrahBookingFragment());
                navController.navigate(R.id.action_navigation_account_to_myUmrahBookingFragment);
                homeCycleActivity.setNavigation("g");

                break;
        }
    }
}