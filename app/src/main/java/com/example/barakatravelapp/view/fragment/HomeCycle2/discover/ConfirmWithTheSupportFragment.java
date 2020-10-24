package com.example.barakatravelapp.view.fragment.HomeCycle2.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.fragment.BaSeFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.flights.FlightDetailsFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.hotels.HottelViewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class ConfirmWithTheSupportFragment extends BaSeFragment {

    @BindView(R.id.fragment_confirm_with_the_support_discover_madinah_tv)
    TextView fragmentConfirmWithTheSupportDiscoverMadinahTv;
    @BindView(R.id.fragment_confirm_with_the_support_discover_approved_img_ly)
    ImageView fragmentConfirmWithTheSupportDiscoverApprovedImgLy;
    @BindView(R.id.fragment_confirm_with_the_support_filight_approved_img_ly)
    LinearLayout fragmentConfirmWithTheSupportFilightApprovedImgLy;
    @BindView(R.id.fragment_confirm_with_the_support_discover_hotel_img_ly)
    CardView fragmentConfirmWithTheSupportDiscoverHotelImgLy;
    @BindView(R.id.fragment_confirm_with_the_support_flight_item_ly)
    LinearLayout fragmentConfirmWithTheSupportFlightItemLy;
    private String isDiscoverOrFlight;

    public ConfirmWithTheSupportFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if (this.getArguments() != null) {
            isDiscoverOrFlight = this.getArguments().getString("ISDISCOVER");

        }
        View root = inflater.inflate(R.layout.fragment_confirm_with_the_support, container, false);

        ButterKnife.bind(this, root);

        if (isDiscoverOrFlight.equalsIgnoreCase("discover")) {
            fragmentConfirmWithTheSupportDiscoverApprovedImgLy.setVisibility(View.VISIBLE);
            fragmentConfirmWithTheSupportDiscoverHotelImgLy.setVisibility(View.VISIBLE);
            fragmentConfirmWithTheSupportDiscoverMadinahTv.setVisibility(View.VISIBLE);

        }else {
            fragmentConfirmWithTheSupportFlightItemLy.setVisibility(View.VISIBLE);
            fragmentConfirmWithTheSupportFilightApprovedImgLy.setVisibility(View.VISIBLE);

        }
        return root;
    }

    @Override
    public void onBack() {
        if (isDiscoverOrFlight.equalsIgnoreCase("discover")) {

            replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new HottelViewFragment());

        }else {

            replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new FlightDetailsFragment());


        }
    }

    @OnClick({R.id.fragment_confirm_with_the_support_view_my_booking, R.id.fragment_confirm_with_the_support_return_home})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_confirm_with_the_support_view_my_booking:
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new HottelViewFragment());
                break;
            case R.id.fragment_confirm_with_the_support_return_home:
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new DiscoverFragment());
                homeCycleActivity.setNavigation("v");
                homeCycleActivity.bottomNavView.getMenu().getItem(0).setChecked(true);
                break;
        }
    }
}