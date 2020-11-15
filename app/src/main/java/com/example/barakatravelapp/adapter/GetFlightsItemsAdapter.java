package com.example.barakatravelapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.data.model.getFlightResponce.FlightData;
import com.example.barakatravelapp.view.activity.BaseActivity;
import com.example.barakatravelapp.view.activity.HomeCycleActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.barakatravelapp.utils.HelperMethod.onLoadImageFromUrl;
import static com.example.barakatravelapp.utils.HelperMethod.replaceFragment;


public class GetFlightsItemsAdapter extends RecyclerView.Adapter<GetFlightsItemsAdapter.ViewHolder> {



    private BaseActivity activity;
    private Context context;
    private List<FlightData> flightsListData;
    private NavController navController;

    public GetFlightsItemsAdapter(Activity activity, Context context, List<FlightData> flightsListData) {
        this.activity = (BaseActivity) activity;
        this.context = context;
        this.flightsListData = flightsListData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_flight_offers_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);

    }

    private void setData(ViewHolder holder, int position) {
        holder.position = position;
        FlightData flightList = flightsListData.get(position);
        if(position == 0){
            holder.cardviewFlightOffersItemTopFlightsTitleTv.setVisibility(View.VISIBLE);
        }
        holder.cardviewFlightOffersItemFromDateTv.setText(flightList.getReservationFrom());
        holder.cardviewFlightOffersItemToDateTv.setText(flightList.getReservationTo());
        holder.cardviewFlightOffersItemFromCountryTv.setText(flightList.getFrom());
        holder.cardviewFlightOffersItemToCountryTv.setText(flightList.getTo());
        holder.cardviewFlightOffersItemPriceTv.setText(flightList.getPriceAdult().toString());
//        Glide.with(context).load(foodList.getPhotoUrl()).asBitmap().override(1080, 600).into(holder.cardviewItemClientFoodOrderMenuImg);
        onLoadImageFromUrl(holder.cardviewFlightOffersItemFlightAirportLogoImg, flightList.getImage(), context);
    }



    private void setAction(ViewHolder holder, int position) {
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AddOrderFragment addOrderFragment = new AddOrderFragment();
//                addOrderFragment.item = foodListData.get(position);
//                replaceFragment(activity.getSupportFragmentManager(), R.id.home_activity_fram, new ContactWithUsFragment(),"t");
                navController.navigate(R.id.action_navigation_flight_to_flightDetailsFragment);
                HomeCycleActivity navigationActivity = (HomeCycleActivity) activity;
                navigationActivity.setNavigation("g");
            }
        });
    }

    @Override
    public int getItemCount() {
        return flightsListData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cardview_flight_offers_item_top_flights_title_tv)
        TextView cardviewFlightOffersItemTopFlightsTitleTv;
        @BindView(R.id.cardview_flight_offers_item_offer_shadow_img)
        ImageView cardviewFlightOffersItemOfferShadowImg;
        @BindView(R.id.cardview_flight_offers_item_offer_num_tv)
        TextView cardviewFlightOffersItemOfferNumTv;
        @BindView(R.id.cardview_flight_offers_item_flight_airport_logo_img)
        ImageView cardviewFlightOffersItemFlightAirportLogoImg;
        @BindView(R.id.cardview_flight_offers_item_economy_shape_hide_tv)
        TextView cardviewFlightOffersItemEconomyShapeHideTv;
        @BindView(R.id.cardview_flight_offers_item_efirst_class_shape_hide_tv)
        TextView cardviewFlightOffersItemEfirstClassShapeHideTv;
        @BindView(R.id.cardview_flight_offers_item_from_date_tv)
        TextView cardviewFlightOffersItemFromDateTv;
        @BindView(R.id.cardview_flight_offers_item_to_date_tv)
        TextView cardviewFlightOffersItemToDateTv;
        @BindView(R.id.cardview_flight_offers_item_from_country_tv)
        TextView cardviewFlightOffersItemFromCountryTv;
        @BindView(R.id.cardview_flight_offers_item_from_city_tv)
        TextView cardviewFlightOffersItemFromCityTv;
        @BindView(R.id.cardview_flight_offers_item_to_country_tv)
        TextView cardviewFlightOffersItemToCountryTv;
        @BindView(R.id.cardview_flight_offers_item_to_city_tv)
        TextView cardviewFlightOffersItemToCityTv;
        @BindView(R.id.cardview_flight_offers_item_from_country_img)
        ImageView cardviewFlightOffersItemFromCountryImg;
        @BindView(R.id.cardview_flight_offers_item_price_tv)
        TextView cardviewFlightOffersItemPriceTv;
        View view;
        private int position;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
            navController = Navigation.findNavController(activity, R.id.home_activity_fragment);

        }
    }
}
