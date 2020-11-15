package com.example.barakatravelapp.view.viewModel;


import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.data.model.getFlightResponce.GetFlightResponce;
import com.example.barakatravelapp.data.model.userLoginResponce.UserLoginGeneralResponce;
import com.example.barakatravelapp.utils.HelperMethod;
import com.example.barakatravelapp.utils.ToastCreator;
import com.example.barakatravelapp.view.activity.HomeCycleActivity;
import com.facebook.shimmer.ShimmerFrameLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.barakatravelapp.data.local.SharedPreferencesManger.REMEMBER_ME;
import static com.example.barakatravelapp.data.local.SharedPreferencesManger.SaveData;
import static com.example.barakatravelapp.data.local.SharedPreferencesManger.USER_DATA;
import static com.example.barakatravelapp.data.local.SharedPreferencesManger.USER_PASSWORD;
import static com.example.barakatravelapp.utils.HelperMethod.dismissProgressDialog;
import static com.example.barakatravelapp.utils.HelperMethod.progressDialog;
import static com.example.barakatravelapp.utils.HelperMethod.showLongToast;
import static com.example.barakatravelapp.utils.HelperMethod.showToast;
import static com.example.barakatravelapp.utils.ToastCreator.onCreateErrorToast;
import static com.example.barakatravelapp.utils.network.InternetState.isConnected;


public class ViewModelGetLists extends ViewModel {

//    private UserRepository userRepository;
    private MutableLiveData<GetFlightResponce> getFlightResponce = new MutableLiveData<>();



    public MutableLiveData<GetFlightResponce> makeGetFlightsDataList() {
        return getFlightResponce;
    }

    public void getFlightsDataList(final Activity activity, final LinearLayout errorSubView, final Call<GetFlightResponce> method, final SwipeRefreshLayout clientAndRestaurantHomeFragmentSrRefreshRv, final RelativeLayout loadMore) {
        if (isConnected(activity)) {



            method.enqueue(new Callback<GetFlightResponce>() {
                @Override
                public void onResponse(Call<GetFlightResponce> call, Response<GetFlightResponce> response) {

                    if (response.body() != null) {
                        try {
//                            clientAndRestaurantHomeFragmentSFlShimmer.stopShimmer();
//                            clientAndRestaurantHomeFragmentSFlShimmer.setVisibility(View.GONE);
                            loadMore.setVisibility(View.GONE);
                            clientAndRestaurantHomeFragmentSrRefreshRv.setRefreshing(false);
                            if (response.body().getStatus().equals("success")) {
//
                                getFlightResponce.postValue(response.body());

                                ToastCreator.onCreateSuccessToast(activity, response.body().getMessage());
                            } else {
                                onCreateErrorToast(activity, response.body().getMessage());
//                                new HomeFragment().setError(String.valueOf(R.string.error_list));

                            }

                        } catch(Exception e){

                        }
                    }

                }

                @Override
                public void onFailure(Call<GetFlightResponce> call, Throwable t) {
                    try {
//                        clientAndRestaurantHomeFragmentSFlShimmer.stopShimmer();
//                        clientAndRestaurantHomeFragmentSFlShimmer.setVisibility(View.GONE);
                        loadMore.setVisibility(View.GONE);
                        clientAndRestaurantHomeFragmentSrRefreshRv.setRefreshing(false);
//                        new HomeFragment().setError(String.valueOf(R.string.error_list));
                        getFlightResponce.postValue(null);
                    } catch (Exception e) {

                    }
                }
            });
        } else {
            try {
//                clientAndRestaurantHomeFragmentSFlShimmer.stopShimmer();
//                clientAndRestaurantHomeFragmentSFlShimmer.setVisibility(View.GONE);
                loadMore.setVisibility(View.GONE);
                clientAndRestaurantHomeFragmentSrRefreshRv.setRefreshing(false);
                errorSubView.setVisibility(View.VISIBLE);
//                new HomeFragment().setError(String.valueOf(R.string.error_inter_net));
                onCreateErrorToast(activity, activity.getString(R.string.error_inter_net));
            } catch (Exception e) {

            }

        }
    }

}
