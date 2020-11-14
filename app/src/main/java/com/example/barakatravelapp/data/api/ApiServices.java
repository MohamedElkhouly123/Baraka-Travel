package com.example.barakatravelapp.data.api;


import com.example.barakatravelapp.data.model.userLoginResponce.UserLoginGeneralResponce;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

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


}
