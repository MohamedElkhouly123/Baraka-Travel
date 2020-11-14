package com.example.barakatravelapp.view.fragment.HomeCycle2.hotels;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.fragment.BaSeFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HottelViewFragment extends BaSeFragment {

    @BindView(R.id.fragment_home_hottel_view_mv_map)
    MapView fragmentHomeHottelViewMvMap;
    private NavController navController;
    private String isSuccessfulOrFlightOrDiscoffer;

    public HottelViewFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if (this.getArguments() != null) {
            isSuccessfulOrFlightOrDiscoffer = this.getArguments().getString("ISSUCCESSFUL");

        }
        View root = inflater.inflate(R.layout.fragment_home_hottel_view, container, false);
        ButterKnife.bind(this, root);
        fragmentHomeHottelViewMvMap.onCreate(savedInstanceState);
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment);
        setData();
        return root;
    }

    private void setData() {
        fragmentHomeHottelViewMvMap.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        fragmentHomeHottelViewMvMap.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                try {

                    MarkerOptions currentUserLocation = new MarkerOptions();
                    currentUserLocation.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker_alt_solid));

                    LatLng currentUserLatLang = new LatLng(Double.parseDouble("999"), Double.parseDouble("98831371"));
                    currentUserLocation.position(currentUserLatLang);
                    googleMap.addMarker(currentUserLocation);
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentUserLatLang, 16));

                    float zoom = 10;
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentUserLatLang, zoom));

                } catch (Exception e) {

                }
            }
        });
    }

    @Override
    public void onBack() {
//        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment,new SuccessfulPaymentFragment());
        Bundle bundle = new Bundle();
        if (isSuccessfulOrFlightOrDiscoffer.equalsIgnoreCase("successfullPayment")) {
            navController.navigate(R.id.action_hottelViewFragment_to_successfulPaymentFragment);
        }else if (isSuccessfulOrFlightOrDiscoffer.equalsIgnoreCase("discover")) {
            bundle.putString("ISDISCOVER", "discover");
            navController.navigate(R.id.action_hottelViewFragment_to_confirmWithTheSupportFragment,bundle);
        }else {
            bundle.putString("ISDISCOVER","flight");
            navController.navigate(R.id.action_hottelViewFragment_to_confirmWithTheSupportFragment,bundle);

        }
    }

    @OnClick(R.id.fragment_home_hottel_view_book_btn)
    public void onViewClicked() {
        Bundle bundle = new Bundle();
        bundle.putString("ISDISCOVER", "discover");
//        ConfirmWithTheSupportFragment confirmWithTheSupportFragment=new ConfirmWithTheSupportFragment();
//        confirmWithTheSupportFragment.setArguments(bundle);
//        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment,confirmWithTheSupportFragment);
        navController.navigate(R.id.action_hottelViewFragment_to_confirmWithTheSupportFragment, bundle);

    }
}