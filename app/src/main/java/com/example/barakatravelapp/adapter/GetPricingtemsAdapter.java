package com.example.barakatravelapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.data.model.getUmrahAndHujjResponce.Pricing;
import com.example.barakatravelapp.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GetPricingtemsAdapter extends RecyclerView.Adapter<GetPricingtemsAdapter.ViewHolder> {



    private BaseActivity activity;
    private Context context;
    private List<Pricing> getPricingItemsListData = new ArrayList<>();
    private List<String> hotelImages = new ArrayList<>();
    private NavController navController;
    private static boolean show = false;

    public GetPricingtemsAdapter(Context context, Activity activity, List<Pricing> getHomeDisscoverGetHotelsDataItemsListData) {
        getPricingItemsListData.clear();
        this.activity = (BaseActivity) activity;
        this.context = context;
        this.getPricingItemsListData = getHomeDisscoverGetHotelsDataItemsListData;
//                showToast(activity, String.valueOf(itemNum));
//        showToast(activity, String.valueOf(getDisscoverGetHotelsItemsListData.size()));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.cardview_hz_hajj_details_packages_pricing_item,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {

//        showToast(activity, String.valueOf(getDisscoverGetHotelsItemsListData.get(position).getRate()));
        Pricing pricingData = getPricingItemsListData.get(position);
        holder.cardviewHzHajjDetailsPackagesPricingItemNameTv.setText(pricingData.getName());
        holder.cardviewHzHajjDetailsPackagesPricingItemCostTv.setText("$ " + pricingData.getPrice());
        holder.cardviewHzHajjDetailsPackagesPricingItemNumBerRoomTv.setText(pricingData.getNumberPerRoom()+" People per room");

    }

    private void setAction(ViewHolder holder, int position) {

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                HomeCycleActivity navigationActivity = (HomeCycleActivity) activity;
//                navController.navigate(R.id.action_navigation_flight_to_flightDetailsFragment);
//                navigationActivity.setNavigation("g");
//                FoodMenueFragment foodMenueFragment=new FoodMenueFragment();
//                foodMenueFragment.restaurantsListData = clientRestaurantsDataList.get(position);
//                HelperMethod.replaceFragment(navigationActivity.getSupportFragmentManager(), R.id.home_activity_fram, new RestaurantCategoryTabsFragment());

            }
        });
    }

    @Override
    public int getItemCount() {
        return getPricingItemsListData.size();
    }

    @OnClick(R.id.cardview_hz_hajj_details_packages_pricing_item_send_inquiry_btn)
    public void onViewClicked() {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cardview_hz_hajj_details_packages_pricing_item_name_tv)
        TextView cardviewHzHajjDetailsPackagesPricingItemNameTv;
        @BindView(R.id.cardview_hz_hajj_details_packages_pricing_item_cost_tv)
        TextView cardviewHzHajjDetailsPackagesPricingItemCostTv;
        @BindView(R.id.cardview_hz_hajj_details_packages_pricing_item_num_ber_room_tv)
        TextView cardviewHzHajjDetailsPackagesPricingItemNumBerRoomTv;
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
//            navController = Navigation.findNavController(activity, R.id.home_activity_fragment);

        }
    }
}
