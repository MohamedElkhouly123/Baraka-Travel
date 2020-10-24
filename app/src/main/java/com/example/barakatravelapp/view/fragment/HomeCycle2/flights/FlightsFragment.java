package com.example.barakatravelapp.view.fragment.HomeCycle2.flights;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.fragment.BaSeFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.discover.DiscoverFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.hotels.HottelViewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class FlightsFragment extends BaSeFragment {

    @BindView(R.id.top_part_in_nav_flight_part)
    LinearLayout topPartInNavFlightPart;

    public FlightsFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home_flights, container, false);

        ButterKnife.bind(this, root);
        topPartInNavFlightPart.setVisibility(View.VISIBLE);
        return root;
    }

    @Override
    public void onBack() {
        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new DiscoverFragment());
        homeCycleActivity.setNavigation("v");
        homeCycleActivity.bottomNavView.getMenu().getItem(0).setChecked(true);    }

    @OnClick(R.id.fragment_home_flights_cardview_flight_offers_item_cr_ly)
    public void onViewClicked() {
        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new FlightDetailsFragment());
        homeCycleActivity.setNavigation("g");

    }
}