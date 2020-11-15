package com.example.barakatravelapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.data.model.getHotelsResponce.GetRoom;
import com.example.barakatravelapp.data.model.getHotelsResponce.HotelData;
import com.example.barakatravelapp.view.activity.BaseActivity;
import com.example.barakatravelapp.view.activity.HomeCycleActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.barakatravelapp.utils.HelperMethod.onLoadImageFromUrl;


public class GetHotelsItemsAdapter extends RecyclerView.Adapter<GetHotelsItemsAdapter.ViewHolder> {



    private BaseActivity activity;
    private Context context;
    private List<HotelData> hotelDataList;
    private List<String> hotelImages;
    private NavController navController;

    public GetHotelsItemsAdapter(Activity activity, Context context, List<HotelData> hotelDataList) {
        this.activity = (BaseActivity) activity;
        this.context = context;
        this.hotelDataList = hotelDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_general_vert_hajj_and_hotels_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);

    }

    private void setData(ViewHolder holder, int position) {
//        holder.position = position;
        HotelData hotelList = hotelDataList.get(position);
        GetRoom getRoom = (GetRoom) hotelList.getGetRooms();
        if (position == 0) {
            holder.cardviewGeneralVertHajjAndHotelsItemTitleTv.setVisibility(View.VISIBLE);
        }
        holder.cardviewGeneralVertHajjAndHotelsItemNameTv.setText(hotelList.getName());
        holder.cardviewGeneralVertHajjAndHotelsItemPriceTv.setText(hotelList.getMinPrice());
        holder.cardviewGeneralVertHajjAndHotelsItemFromDateTv.setText(getRoom.getFromDate());
        holder.cardviewGeneralVertHajjAndHotelsItemToDateTv.setText(getRoom.getToDate());
        holder.cardviewGeneralVertHajjAndHotelsItemRateImg.setVisibility(View.VISIBLE);

////        if (flightList.getIsOffer()!=null)
        holder.cardviewGeneralVertHajjAndHotelsItemTvRateAndNightsNum.setText(hotelList.getRate());
////        Glide.with(context).load(foodList.getPhotoUrl()).asBitmap().override(1080, 600).into(holder.cardviewItemClientFoodOrderMenuImg);
        hotelImages = hotelList.getHotelImages();
        onLoadImageFromUrl(holder.cardviewGeneralVertHajjAndHotelsItemHotelImg, hotelImages.get(0), context);
    }



    private void setAction(final ViewHolder holder, final int position) {

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HomeCycleActivity navigationActivity = (HomeCycleActivity) activity;
                navController.navigate(R.id.action_navigation_flight_to_flightDetailsFragment);
                navigationActivity.setNavigation("g");
//                FoodMenueFragment foodMenueFragment=new FoodMenueFragment();
//                foodMenueFragment.restaurantsListData = clientRestaurantsDataList.get(position);
//                HelperMethod.replaceFragment(navigationActivity.getSupportFragmentManager(), R.id.home_activity_fram, new RestaurantCategoryTabsFragment());

            }
        });

    }

    @Override
    public int getItemCount() {
        return hotelDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_title_tv)
        TextView cardviewGeneralVertHajjAndHotelsItemTitleTv;
        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_hotel_img)
        ImageView cardviewGeneralVertHajjAndHotelsItemHotelImg;
        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_offer_shadow_img)
        ImageView cardviewGeneralVertHajjAndHotelsItemOfferShadowImg;
        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_tv_rate_and_nights_num)
        TextView cardviewGeneralVertHajjAndHotelsItemTvRateAndNightsNum;
        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_rate_img)
        ImageView cardviewGeneralVertHajjAndHotelsItemRateImg;
        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_price_tv)
        TextView cardviewGeneralVertHajjAndHotelsItemPriceTv;
        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_nights_tv)
        TextView cardviewGeneralVertHajjAndHotelsItemNightsTv;
        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_from_date_tv)
        TextView cardviewGeneralVertHajjAndHotelsItemFromDateTv;
        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_to_date_tv)
        TextView cardviewGeneralVertHajjAndHotelsItemToDateTv;
        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_additional_part)
        LinearLayout cardviewGeneralVertHajjAndHotelsItemAdditionalPart;
        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_name_tv)
        TextView cardviewGeneralVertHajjAndHotelsItemNameTv;
        View view;
//        private int position;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
            navController = Navigation.findNavController(activity, R.id.home_activity_fragment);

        }
    }
}
