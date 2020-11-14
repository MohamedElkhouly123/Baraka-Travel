package com.example.barakatravelapp.view.fragment.HomeCycle2.accounts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.utils.MakeChangesDialog;
import com.example.barakatravelapp.view.fragment.BaSeFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class ChangeDetailsFragment extends BaSeFragment {

    private NavController navController;
    public ChangeDetailsFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_change_details, container, false);

        ButterKnife.bind(this, root);
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment);

        return root;
    }

    @Override
    public void onBack() {
//        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new AccountFragment());
        navController.navigate(R.id.action_changeDetailsFragment_to_navigation_account);
        homeCycleActivity.setNavigation("v");
//        homeCycleActivity.bottomNavView.getMenu().getItem(4).setChecked(true);
    }

    @OnClick({R.id.fragment_change_details_change_password_btn, R.id.fragment_change_details_payment_btn, R.id.fragment_change_details_save_changes_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_change_details_change_password_btn:
                new MakeChangesDialog().showDialog(getActivity());

                break;
            case R.id.fragment_change_details_payment_btn:
//                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new PaymentsFragment());
                navController.navigate(R.id.action_changeDetailsFragment_to_paymentsFragment);

                break;
            case R.id.fragment_change_details_save_changes_btn:
//                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new ChangeDetailsMoreFragment());
                navController.navigate(R.id.action_changeDetailsFragment_to_changeDetailsMoreFragment);

                break;
        }
    }
}