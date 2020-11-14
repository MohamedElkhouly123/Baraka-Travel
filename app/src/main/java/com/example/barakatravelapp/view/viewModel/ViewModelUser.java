package com.example.barakatravelapp.view.viewModel;


import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.data.model.userLoginResponce.UserLoginGeneralResponce;
import com.example.barakatravelapp.utils.HelperMethod;
import com.example.barakatravelapp.utils.ToastCreator;
import com.example.barakatravelapp.view.activity.HomeCycleActivity;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.barakatravelapp.data.api.ApiClient.getApiClient;
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


public class ViewModelUser extends ViewModel {

//    private UserRepository userRepository;
    private MutableLiveData<UserLoginGeneralResponce> generalLoginResponse = new MutableLiveData<>();
    private MutableLiveData<UserLoginGeneralResponce> generalRegisterationAndForgetPasswordResponse = new MutableLiveData<>();


    private String token;
    private String apiToken;

    public MutableLiveData<UserLoginGeneralResponce> setGeneralLogin() {
        return generalLoginResponse;
    }

    public void setGeneralLogin(final Activity activity, final Call<UserLoginGeneralResponce> method, final String password, final boolean remember, final boolean auth) {
        if (isConnected(activity)) {

            if (progressDialog == null) {
                HelperMethod.showProgressDialog(activity, activity.getString(R.string.wait));
            } else {
                if (!progressDialog.isShowing()) {
                    HelperMethod.showProgressDialog(activity, activity.getString(R.string.wait));
                }
            }
//            userRepository = new UserRepository();

//            UserRepository.getInstance().clientLogin(activity, email, password, remember, auth)

                method.enqueue(new Callback<UserLoginGeneralResponce>() {
                @Override
                public void onResponse(Call<UserLoginGeneralResponce> call, Response<UserLoginGeneralResponce> response) {

                    if (response.body() != null) {
                        try {

                            if (response.body().getStatus().equals("success")) {
//                                if (response.body().getMessage() != "the user is not vertified to login please visit your email") {

                                    SaveData(activity, USER_PASSWORD, password);
                                SaveData(activity, USER_DATA, response.body().getUser());
                                if (auth) {
                                    SaveData(activity, REMEMBER_ME, remember);
//                                    Call<UserLoginGeneralResponce> tokenCall = null;
//                                    token=new ClientFireBaseToken().getToken();
//                                    apiToken=response.body().getData().getApiToken();
//                                    showToast(activity, "token"+apiToken);
//                                    if (ISCLIENT.equals("true")) {
//
//                                        tokenCall = getApiClient().clientSignUpToken(token, "android",apiToken);
//                                    } else if(ISCLIENT=="false") {
//                                        tokenCall = getApiClient().restaurantSignUpToken(token, "android",apiToken);
//                                    }
//
//
//                                    getAndMakeRegisterToken(activity,tokenCall);
                                    Intent intent = new Intent(activity, HomeCycleActivity.class);
                                    activity.startActivity(intent);
//                                    showToast(activity, response.body().getStatus());
                                    activity.finish();
                                }
//                            }

                                dismissProgressDialog();
                                generalLoginResponse.postValue(response.body());
//                                if (response.body().getMessage()!=null) {
                                ToastCreator.onCreateSuccessToast(activity, response.body().getStatus());

//                                }

                            } else {
                                dismissProgressDialog();
                                showLongToast(activity, response.body().getMessage());
//                                onCreateErrorToast(activity, response.body().getMessage());
                            }
                        } catch (Exception e) {

                        }
                    }
                }

                @Override
                public void onFailure(Call<UserLoginGeneralResponce> call, Throwable t) {
                    dismissProgressDialog();
                    onCreateErrorToast(activity, activity.getString(R.string.error));
                    generalLoginResponse.postValue(null);
                }
            });
        } else {
            try {
                onCreateErrorToast(activity, activity.getString(R.string.error_inter_net));
            } catch (Exception e) {

            }

        }

    }

    public MutableLiveData<UserLoginGeneralResponce> makeResetAndNewPasswordResponseAndSignUp() {
        return generalRegisterationAndForgetPasswordResponse;
    }

    public void setAndMakeResetAndNewPasswordResponseAndSignUp(final Activity activity, final Call<UserLoginGeneralResponce> method, boolean dimiss) {
        if (isConnected(activity)) {

            if (progressDialog == null) {
                HelperMethod.showProgressDialog(activity, activity.getString(R.string.wait));
            } else {
                if (!progressDialog.isShowing()) {
                    HelperMethod.showProgressDialog(activity, activity.getString(R.string.wait));
                }
            }

            method.enqueue(new Callback<UserLoginGeneralResponce>() {
                @Override
                public void onResponse(Call<UserLoginGeneralResponce> call, Response<UserLoginGeneralResponce> response) {

                    if (response.body() != null) {
                        try {

                            if (response.body().getStatus().equals("success")) {
                                dismissProgressDialog();
                                generalRegisterationAndForgetPasswordResponse.postValue(response.body());
                                ToastCreator.onCreateSuccessToast(activity, "Success");
                        } else {
                                dismissProgressDialog();
                                onCreateErrorToast(activity, response.body().getMessage());

                            }
                        } catch (Exception e) {

                        }
                    }
                }

                @Override
                public void onFailure(Call<UserLoginGeneralResponce> call, Throwable t) {
                    dismissProgressDialog();
                    onCreateErrorToast(activity, activity.getString(R.string.error));
                    generalRegisterationAndForgetPasswordResponse.postValue(null);
                }
            });
        } else {
            try {
                onCreateErrorToast(activity, activity.getString(R.string.error_inter_net));
            } catch (Exception e) {

            }

        }

    }


}
