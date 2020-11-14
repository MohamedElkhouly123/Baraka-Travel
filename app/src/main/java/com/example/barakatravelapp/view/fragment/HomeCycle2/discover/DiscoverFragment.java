package com.example.barakatravelapp.view.fragment.HomeCycle2.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.adapter.SubHomeDiscoverVrRvAdapter;
import com.example.barakatravelapp.data.model.ItemObjectModel;
import com.example.barakatravelapp.utils.ChoosePersonsRoomsDialog;
import com.example.barakatravelapp.utils.DialogAdapterCallback;
import com.example.barakatravelapp.view.fragment.BaSeFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DiscoverFragment extends BaSeFragment implements DialogAdapterCallback {

    @BindView(R.id.top_part_in_nav_genral_part_search_til)
    TextInputLayout topPartInNavGenralPartSearchTil;
    @BindView(R.id.home_discover_fragment_recycler_view)
    RecyclerView homeDiscoverFragmentRecyclerView;
    private NavController navController;
    private LinearLayoutManager lLayout;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home_discover, container, false);

        ButterKnife.bind(this, root);
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment);
        topPartInNavGenralPartSearchTil.setVisibility(View.VISIBLE);
        List<ItemObjectModel> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(getActivity());

        homeDiscoverFragmentRecyclerView.setLayoutManager(lLayout);

        SubHomeDiscoverVrRvAdapter rcAdapter = new SubHomeDiscoverVrRvAdapter(getContext(), getActivity(), rowListItem);
        homeDiscoverFragmentRecyclerView.setAdapter(rcAdapter);
        return root;
    }

    private List<ItemObjectModel> getAllItemList() {

        List<ItemObjectModel> allItems = new ArrayList<ItemObjectModel>();
        allItems.add(new ItemObjectModel(getString(R.string.top_umrah_packages)));
        allItems.add(new ItemObjectModel(getString(R.string.top_hajj_packages)));
        allItems.add(new ItemObjectModel(getString(R.string.top_hotels_packages)));


        return allItems;
    }
    @Override
    public void onBack() {
        getActivity().finish();
    }

    @OnClick(R.id.cardview_hz_discover_item_img)
    public void onViewClicked() {
        new ChoosePersonsRoomsDialog().showDialog(getActivity(), this);

    }

    @Override
    public void onMethodCallback() {
//        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new LuxuryUmrahPackageFragment());
        navController.navigate(R.id.action_navigation_discover_to_luxuryUmrahPackageFragment);
        homeCycleActivity.setNavigation("g");

    }
}