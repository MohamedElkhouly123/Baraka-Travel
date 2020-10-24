package com.example.barakatravelapp.view.fragment.HomeCycle2.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.fragment.BaSeFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.hotels.HottelViewFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class SuccessfulPaymentFragment extends BaSeFragment {

    public SuccessfulPaymentFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_successful_payment, container, false);

        ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onBack() {
        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram,new SelectPaymentMethodFragment());
    }

    @OnClick({R.id.fragment_successful_payment_view_my_booking_btn, R.id.fragment_successful_payment_return_home_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_successful_payment_view_my_booking_btn:
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram,new HottelViewFragment());

                break;
            case R.id.fragment_successful_payment_return_home_btn:
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram,new DiscoverFragment());
                homeCycleActivity.setNavigation("v");
                homeCycleActivity.bottomNavView.getMenu().getItem(0).setChecked(true);
                break;
        }
    }
}