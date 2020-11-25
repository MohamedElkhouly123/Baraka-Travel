package com.example.barakatravelapp.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.data.model.getDiscoverHomeResponce.GetDiscoverHomeResponce;
import com.example.barakatravelapp.data.model.userLoginResponce.UserData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

import static com.example.barakatravelapp.data.api.ApiClient.getApiClient;
import static com.example.barakatravelapp.data.local.SharedPreferencesManger.LoadUserData;
import static com.example.barakatravelapp.utils.GeneralRequest.sentUserRateCallBack;
import static com.example.barakatravelapp.utils.validation.Validation.cleanError;
import static com.example.barakatravelapp.utils.validation.Validation.validationEditTextsEmpty;
import static com.example.barakatravelapp.utils.validation.Validation.validationLength;
import static com.example.barakatravelapp.utils.validation.Validation.validationPhone;
import static com.example.barakatravelapp.utils.validation.Validation.validationTextInputLayoutListEmpty;


public class WriteRateDialog {
    private static int adultNum;
    private DialogAdapterCallback dialogAdapterCallback;
    private EditText rateNameTv,ratePhoneTv,rateMessageTv;
    private RatingBar ratingBar;
    List<EditText> editTexts = new ArrayList<>();
    private UserData userData;
    private int idPackage;
    public void showDialog(final Activity activity, Integer id) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_write_rate);
        dialog.setCanceledOnTouchOutside(true);
        userData= LoadUserData(activity);
        idPackage=id;

         rateNameTv = (EditText) dialog.findViewById(R.id.dialog_write_rate_name_et);
         ratePhoneTv = (EditText) dialog.findViewById(R.id.dialog_write_rate_phone_et);
         rateMessageTv = (EditText) dialog.findViewById(R.id.dialog_write_rate_message_et);

        ImageView rateCloseBtn = (ImageView) dialog.findViewById(R.id.dialog_write_rate_close_btn);
         ratingBar = (RatingBar) dialog.findViewById(R.id.dialog_write_rate_simple_rating_bar);


//        Button saveBtn = (Button) dialog.findViewById(R.id.dialog_choose_persons_rooms_save_btn);



        rateCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dialogAdapterCallback.onMethodCallback(getHomeDisscoverGetItemsListData.get(position));
                onValidate(activity);
                dialog.cancel();
            }
        });



                dialog.show();

            }

    private void onValidate(Activity activity) {
//        cleanError(editTexts);
        editTexts.add(rateNameTv);
        editTexts.add(ratePhoneTv);
        editTexts.add(rateMessageTv);
        if (!validationEditTextsEmpty(editTexts, activity.getString(R.string.empty))) {
            return;
        }
        if (!validationLength(rateNameTv, activity.getString(R.string.invalid_user_name), 3)) {
            return;
        }
        if (!validationPhone(activity, ratePhoneTv)) {
//            ToastCreator.onCreateErrorToast(getActivity(), "Enter Phone");
            return;
        }
        if (!validationLength(rateMessageTv, activity.getString(R.string.invalid_user_name), 3)) {
            return;
        }
        onCall(activity);
    }

    private void onCall(Activity activity) {
        String name = rateNameTv.getText().toString();
        String message = rateMessageTv.getText().toString();
        String phone = ratePhoneTv.getText().toString();
        int userId = userData.getId();
        int rate = (int) ratingBar.getRating();
        int packageId = idPackage;
        Call<GetDiscoverHomeResponce> updateItemCal = getApiClient().sendHujjAndUmrahRate(userId,name,phone,message,rate,packageId);
        sentUserRateCallBack(activity,updateItemCal);

    }


}
