package com.example.barakatravelapp.view.fragment.HomeCycle2.accounts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.adapter.AccountMyBookingsVrRvAdapter;
import com.example.barakatravelapp.data.model.ItemGeneralObjectModel;
import com.example.barakatravelapp.data.model.userLoginResponce.UserData;
import com.example.barakatravelapp.view.fragment.BaSeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.barakatravelapp.data.local.SharedPreferencesManger.LoadUserData;
import static com.example.barakatravelapp.utils.HelperMethod.onLoadCirImageFromUrl;


public class AccountFragment extends BaSeFragment {

    @BindView(R.id.fragment_home_account_profile_photo_circularImageView)
    CircleImageView fragmentHomeAccountProfilePhotoCircularImageView;
    @BindView(R.id.fragment_home_account_profile_country_img)
    ImageView fragmentHomeAccountProfileCountryImg;
    @BindView(R.id.fragment_home_account_profile_name_tv)
    TextView fragmentHomeAccountProfileNameTv;
    @BindView(R.id.fragment_home_account_profile_email_tv)
    TextView fragmentHomeAccountProfileEmailTv;
    @BindView(R.id.fragment_home_account_profile_phone_tv)
    TextView fragmentHomeAccountProfilePhoneTv;
    @BindView(R.id.fragment_home_account_profile_evisa_email_tv)
    TextView fragmentHomeAccountProfileEvisaEmailTv;
    @BindView(R.id.fragment_home_account_profile_recycler_view)
    RecyclerView fragmentHomeAccountProfileRecyclerView;
    private NavController navController;
    private LinearLayoutManager lLayout;
    private UserData userData;
    private List<ItemGeneralObjectModel> rowListItem;
    private AccountMyBookingsVrRvAdapter subHomeDiscoverVrRvAdapter;

    public AccountFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home_account_profile, container, false);

        ButterKnife.bind(this, root);
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment);
        setData();
        init();
        return root;
    }

    private void setData() {

        userData = LoadUserData(getActivity());
        fragmentHomeAccountProfileNameTv.setText(userData.getFirstName()+" "+userData.getLastName());
        fragmentHomeAccountProfileEmailTv.setText(userData.getEmail());
        fragmentHomeAccountProfileEvisaEmailTv.setText(userData.getEmail());
        fragmentHomeAccountProfilePhoneTv.setText(userData.getMobile());
        if(userData.getImage()!=null){
            String personalImage = "https://www.barakatravel.net/"+userData.getImage().trim();
            onLoadCirImageFromUrl(fragmentHomeAccountProfilePhotoCircularImageView,personalImage.trim(), getContext());}
    }

    private void init() {

        lLayout = new LinearLayoutManager(getActivity());

        fragmentHomeAccountProfileRecyclerView.setLayoutManager(lLayout);
//        if(getHomeDisscoverGetUmrahDataItemsListData.size()!=0 || getHomeDisscoverGetHajjDataItemsListData.size()!=0 || getHomeDisscoverGetHotelsDataItemsListData.size()!=0) {
        rowListItem = getAllItemList();
//        }
        subHomeDiscoverVrRvAdapter = new AccountMyBookingsVrRvAdapter(getContext(), getActivity(),navController,rowListItem);
        fragmentHomeAccountProfileRecyclerView.setAdapter(subHomeDiscoverVrRvAdapter);


    }

    private List<ItemGeneralObjectModel> getAllItemList() {

        List<ItemGeneralObjectModel> allItems = new ArrayList<ItemGeneralObjectModel>();
        allItems.add(new ItemGeneralObjectModel(getString(R.string.My_Umrah_Bookings),R.drawable.my_umrah_booking));
        allItems.add(new ItemGeneralObjectModel(getString(R.string.My_Hajj_Bookings),R.drawable.my_hajj_booking2));
        allItems.add(new ItemGeneralObjectModel(getString(R.string.My_Hotel_Bookings),R.drawable.inside_my_hotels_booking));
        allItems.add(new ItemGeneralObjectModel(getString(R.string.My_Flight_Bookings),R.drawable.my_flight_booking));


        return allItems;
    }


    @Override
    public void onBack() {
//        replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new DiscoverFragment());
        navController.navigate(R.id.action_navigation_account_to_navigation_discover);
//        homeCycleActivity.setNavigation("v");
//        homeCycleActivity.bottomNavView.getMenu().getItem(0).setChecked(true);
    }

    @OnClick({R.id.fragment_home_account_profile_edit_bttn, R.id.fragment_home_account_profile_e_visa_bttn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_account_profile_edit_bttn:
//                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new ChangeDetailsFragment());
                navController.navigate(R.id.action_navigation_account_to_changeDetailsFragment);
                homeCycleActivity.setNavigation("g");

                break;
            case R.id.fragment_home_account_profile_e_visa_bttn:
//                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new GetEVisaFragment());
                navController.navigate(R.id.action_navigation_account_to_fragment_choose_static_evisa);
                homeCycleActivity.setNavigation("g");


                break;
//            case R.id.fragment_home_account_profile_cardview_my_account_item_next_btn:
////                replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_fragment, new MyAllBookingFragment());
//                navController.navigate(R.id.action_navigation_account_to_myUmrahBookingFragment);
//                homeCycleActivity.setNavigation("g");
//
//                break;
        }
    }
}