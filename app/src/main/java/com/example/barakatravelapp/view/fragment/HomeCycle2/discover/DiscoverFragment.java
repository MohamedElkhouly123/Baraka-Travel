package com.example.barakatravelapp.view.fragment.HomeCycle2.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.utils.ChoosePersonsRoomsDialog;
import com.example.barakatravelapp.utils.DialogAdapterCallback;
import com.example.barakatravelapp.view.fragment.BaSeFragment;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class DiscoverFragment extends BaSeFragment implements DialogAdapterCallback {

    @BindView(R.id.top_part_in_nav_genral_part_search_til)
    TextInputLayout topPartInNavGenralPartSearchTil;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home_discover, container, false);

        ButterKnife.bind(this, root);

        topPartInNavGenralPartSearchTil.setVisibility(View.VISIBLE);
        return root;
    }

    @Override
    public void onBack() { getActivity().finish();    }

    @OnClick(R.id.cardview_hz_discover_item_img)
    public void onViewClicked() {
        new ChoosePersonsRoomsDialog().showDialog(getActivity(), this);

    }

    @Override
    public void onMethodCallback() {
        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram, new LuxuryUmrahPackageFragment());
        homeCycleActivity.setNavigation("g");

    }
}