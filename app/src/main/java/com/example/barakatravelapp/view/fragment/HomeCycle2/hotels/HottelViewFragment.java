package com.example.barakatravelapp.view.fragment.HomeCycle2.hotels;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.view.fragment.BaSeFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.discover.ConfirmWithTheSupportFragment;
import com.example.barakatravelapp.view.fragment.HomeCycle2.discover.SuccessfulPaymentFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class HottelViewFragment extends BaSeFragment {

    public HottelViewFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home_hottel_view, container, false);

        ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onBack() {
        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram,new SuccessfulPaymentFragment());
    }

    @OnClick(R.id.fragment_home_hottel_view_book_btn)
    public void onViewClicked() {
       Bundle bundle=new Bundle();
        bundle.putString("ISDISCOVER","discover");
        ConfirmWithTheSupportFragment confirmWithTheSupportFragment=new ConfirmWithTheSupportFragment();
        confirmWithTheSupportFragment.setArguments(bundle);
        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fram,confirmWithTheSupportFragment);

    }
}