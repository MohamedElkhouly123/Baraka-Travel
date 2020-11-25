package com.example.barakatravelapp.data.api;


import com.example.barakatravelapp.data.model.getDiscoverHomeResponce.GetDiscoverHomeResponce;
import com.example.barakatravelapp.data.model.getFlightResponce.GetFlightResponce;
import com.example.barakatravelapp.data.model.getHotelsResponce.GetHotelsResponce;
import com.example.barakatravelapp.data.model.getUmrahAndHujjResponce.GetUmrahAndHujjResponce;
import com.example.barakatravelapp.data.model.userLoginResponce.UserLoginGeneralResponce;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiServices {

    @POST("login")
    @FormUrlEncoded
    Call<UserLoginGeneralResponce> userLogin(@Field("email") String email,
                                             @Field("password") String password);

    @POST("register")
    @FormUrlEncoded
    Call<UserLoginGeneralResponce> onSignUp(@Field("first_name") String first_name,
                                            @Field("last_name") String last_name,
                                            @Field("mobile") String mobile,
                                            @Field("email") String email,
                                            @Field("password") String password);

    @POST("forgetPassword")
    @FormUrlEncoded
    Call<UserLoginGeneralResponce> userResetPassword(@Field("email") String email);

    @POST("getHotels")
    @FormUrlEncoded
    Call<GetHotelsResponce> getHotelsItemListByFilter(
            @Field("page") int page,
            @Field("search") String search
    );

    @POST("getHotels")
    @FormUrlEncoded
    Call<GetHotelsResponce> getHotelsItemList(
            @Field("page") int page
    );

    @POST("getFlights")
    @FormUrlEncoded
    Call<GetFlightResponce> getFlightItemListByFilter(
            @Field("search") String search,
            @Field("page") int page
    );

    @POST("getFlights")
    @FormUrlEncoded
    Call<GetFlightResponce> getFlightItemList(
            @Field("page") int page
    );

    @POST("getPackage")
    @FormUrlEncoded
    Call<GetUmrahAndHujjResponce> getHajjAndUmrahItemListByFilter(
            @Field("type") String type,
            @Field("page") int page,
            @Field("search") String search
            );

    @POST("getPackage")
    @FormUrlEncoded
    Call<GetUmrahAndHujjResponce> getHajjAndUmrahItemList(
            @Field("type") String type,
            @Field("page") int page    );

    @POST("home")
    Call<GetDiscoverHomeResponce> getHomeDiscoverItemList(
    );

    @POST("submitRate")
    @FormUrlEncoded
    Call<GetDiscoverHomeResponce> sendHujjAndUmrahRate(@Field("userId") int userId,
                                                        @Field("name") String name,
                                                        @Field("mobile") String mobile,
                                                        @Field("message") String message,
                                                        @Field("rate") int rate,
                                                        @Field("packageId") int packageId
    );

    @POST("submitRate")
    @FormUrlEncoded
    Call<GetDiscoverHomeResponce> sendHotelRate(@Field("userId") int userId,
                                                 @Field("name") String name,
                                                 @Field("mobile") String mobile,
                                                 @Field("message") String message,
                                                 @Field("rate") int rate,
                                                 @Field("hotel_id") int hotel_id
    );

}
