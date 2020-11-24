package com.example.barakatravelapp.view.fragment.HomeCycle2.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.adapter.HajjPhotoGallaryHzRvAdapter;
import com.example.barakatravelapp.adapter.SubHomeDiscoverTopHzRvAdapter;
import com.example.barakatravelapp.data.model.getUmrahAndHujjResponce.GetTopUmarAndTophajjPackage;
import com.example.barakatravelapp.utils.GeneralHajjDescriptionDetailsDialog;
import com.example.barakatravelapp.view.activity.HomeCycleActivity;
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


public class LuxuryUmrahPackageFragment extends BaSeFragment {

    @BindView(R.id.fragment_luxury_umrah_package_name_tv)
    TextView fragmentLuxuryUmrahPackageNameTv;
    @BindView(R.id.fragment_luxury_umrah_package_from_date_tv)
    TextView fragmentLuxuryUmrahPackageFromDateTv;
    @BindView(R.id.fragment_luxury_umrah_package_to_date_tv)
    TextView fragmentLuxuryUmrahPackageToDateTv;
    @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_additional_part)
    LinearLayout cardviewGeneralVertHajjAndHotelsItemAdditionalPart;
    @BindView(R.id.fragment_luxury_umrah_package_duration_tv)
    TextView fragmentLuxuryUmrahPackageDurationTv;
    @BindView(R.id.fragment_luxury_umrah_package_price_tv)
    TextView fragmentLuxuryUmrahPackagePriceTv;
    @BindView(R.id.fragment_luxury_umrah_package_rate_tv)
    TextView fragmentLuxuryUmrahPackageRateTv;
    @BindView(R.id.hajj_hide_part_ly)
    LinearLayout hajjHidePartLy;
    @BindView(R.id.fragment_luxury_umrah_package_mv_map)
    MapView fragmentLuxuryUmrahPackageMvMap;
    @BindView(R.id.home_discover_fragment_sub_home_rv_item_hz3_sr_vw)
    ScrollView homeDiscoverFragmentSubHomeRvItemHz3SrVw;
    @BindView(R.id.fragment_luxury_umrah_package_photo_galary_rv_item_hz_rv)
    RecyclerView fragmentLuxuryUmrahPackagePhotoGalaryRvItemHzRv;
    @BindView(R.id.fragment_luxury_umrah_package_package_include_rv_item_hz2_rv)
    RecyclerView fragmentLuxuryUmrahPackagePackageIncludeRvItemHz2Rv;
    @BindView(R.id.fragment_luxury_umrah_package_pricing_rv_item_hz3_rv)
    RecyclerView fragmentLuxuryUmrahPackagePricingRvItemHz3Rv;
    private NavController navController;
    private GetTopUmarAndTophajjPackage getTopUmarAndTophajjPackage;
    private LinearLayoutManager linearLayoutHorizental;
    private HajjPhotoGallaryHzRvAdapter hajjPhotoGallaryHzRvAdapter;

    public LuxuryUmrahPackageFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if (this.getArguments() != null) {
            getTopUmarAndTophajjPackage = (GetTopUmarAndTophajjPackage) this.getArguments().getSerializable("Object");
        }
        View root = inflater.inflate(R.layout.fragment_luxury_umrah_package, container, false);

        ButterKnife.bind(this, root);
        fragmentLuxuryUmrahPackageMvMap.onCreate(savedInstanceState);
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment);
        HomeCycleActivity homeCycleActivity = (HomeCycleActivity) getActivity();
        homeCycleActivity.setNavigation("g");
        setData();

//        if(getTopUmarAndTophajjPackage!=null){
//        showToast(getActivity(), String.valueOf(getTopUmarAndTophajjPackage.getPricing()));}
        return root;
    }

    private void setData() {
        fragmentLuxuryUmrahPackageDurationTv.setText(getTopUmarAndTophajjPackage.getUmar().getDuration());
        fragmentLuxuryUmrahPackagePriceTv.setText(getTopUmarAndTophajjPackage.getUmar().getMinPrice());
        fragmentLuxuryUmrahPackageRateTv.setText(getTopUmarAndTophajjPackage.getUmar().getCalRate());
        if (getTopUmarAndTophajjPackage.getUmar().getPackageType().equalsIgnoreCase("hajj")) {
            hajjHidePartLy.setVisibility(View.VISIBLE);

        }
        initHozental(getTopUmarAndTophajjPackage, fragmentLuxuryUmrahPackagePhotoGalaryRvItemHzRv, 1);
        fragmentLuxuryUmrahPackageMvMap.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        fragmentLuxuryUmrahPackageMvMap.getMapAsync(new OnMapReadyCallback() {
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

    private void initHozental(GetTopUmarAndTophajjPackage getHomeDisscoverGetItemsListData, RecyclerView fragmentLuxuryUmrahPackageGeneralRvItemHzRv, int itemNum) {
        linearLayoutHorizental = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        fragmentLuxuryUmrahPackageGeneralRvItemHzRv.setLayoutManager(linearLayoutHorizental);
        fragmentLuxuryUmrahPackageGeneralRvItemHzRv.setHasFixedSize(true);
//        clientGetRestaurantsFiltterList(0);

        if (itemNum == 1) {
            hajjPhotoGallaryHzRvAdapter = new HajjPhotoGallaryHzRvAdapter(getContext(), getActivity(), getHomeDisscoverGetItemsListData);
            fragmentLuxuryUmrahPackageGeneralRvItemHzRv.setAdapter(hajjPhotoGallaryHzRvAdapter);
        }

        if (itemNum == 2) {
            hajjPhotoGallaryHzRvAdapter = new HajjPhotoGallaryHzRvAdapter(getContext(), getActivity(), getHomeDisscoverGetItemsListData);
            fragmentLuxuryUmrahPackageGeneralRvItemHzRv.setAdapter(hajjPhotoGallaryHzRvAdapter);        }

    }

    @Override
    public void onBack() {
//        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment,new DiscoverFragment());
        navController.navigate(R.id.action_luxuryUmrahPackageFragment_to_navigation_discover);
        homeCycleActivity.setNavigation("v");
//        homeCycleActivity.bottomNavView.getMenu().getItem(0).setChecked(true);
    }

    @OnClick({R.id.fragment_luxury_umrah_package_back_btn, R.id.fragment_luxury_umrah_package_makka_details_btn, R.id.fragment_luxury_umrah_package_madina_details_btn, R.id.fragment_luxury_umrah_package_manasik_details_btn, R.id.fragment_luxury_umrah_package_air_details_btn, R.id.fragment_luxury_umrah_package_day_by_day_btn, R.id.fragment_luxury_umrah_package_included_btn, R.id.fragment_luxury_umrah_package_not_included_btn, R.id.fragment_luxury_umrah_package_important_nots_btn, R.id.fragment_luxury_umrah_package_how_to_book_btn, R.id.fragment_luxury_umrah_package_write_your_rating_here_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_luxury_umrah_package_back_btn:
                navController.navigate(R.id.action_luxuryUmrahPackageFragment_to_navigation_discover);
                homeCycleActivity.setNavigation("v");
                break;
            case R.id.fragment_luxury_umrah_package_makka_details_btn:
                new GeneralHajjDescriptionDetailsDialog().showDialog(getActivity(), getTopUmarAndTophajjPackage, "makka");
                break;
            case R.id.fragment_luxury_umrah_package_madina_details_btn:
                new GeneralHajjDescriptionDetailsDialog().showDialog(getActivity(), getTopUmarAndTophajjPackage, "madina");
                break;
            case R.id.fragment_luxury_umrah_package_manasik_details_btn:
                new GeneralHajjDescriptionDetailsDialog().showDialog(getActivity(), getTopUmarAndTophajjPackage, "manasik");
                break;
            case R.id.fragment_luxury_umrah_package_air_details_btn:
                new GeneralHajjDescriptionDetailsDialog().showDialog(getActivity(), getTopUmarAndTophajjPackage, "air");
                break;
            case R.id.fragment_luxury_umrah_package_day_by_day_btn:
                break;
            case R.id.fragment_luxury_umrah_package_included_btn:
                break;
            case R.id.fragment_luxury_umrah_package_not_included_btn:
                break;
            case R.id.fragment_luxury_umrah_package_important_nots_btn:
                break;
            case R.id.fragment_luxury_umrah_package_how_to_book_btn:
                break;
            case R.id.fragment_luxury_umrah_package_write_your_rating_here_btn:
                break;
        }
    }

//    @OnClick(R.id.fragment_luxury_umrah_package_book_btn)
//    public void onViewClicked() {
////        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment,new ConfirmBookingFragment());
//        navController.navigate(R.id.action_luxuryUmrahPackageFragment_to_confirmBookingFragment);
//
//    }
}