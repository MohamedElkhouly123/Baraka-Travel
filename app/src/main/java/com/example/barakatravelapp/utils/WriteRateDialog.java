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


public class WriteRateDialog {
    private static int adultNum;
    private DialogAdapterCallback dialogAdapterCallback;

    public void showDialog(final Activity activity,DialogAdapterCallback dialogAdapterCallback) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_write_rate);
        dialog.setCanceledOnTouchOutside(true);

        adultNum=0;

        EditText rateNameTv = (EditText) dialog.findViewById(R.id.dialog_write_rate_name_et);
        EditText ratePhoneTv = (EditText) dialog.findViewById(R.id.dialog_write_rate_phone_et);
        EditText rateMessageTv = (EditText) dialog.findViewById(R.id.dialog_write_rate_message_et);

        ImageView rateCloseBtn = (ImageView) dialog.findViewById(R.id.dialog_write_rate_close_btn);
        RatingBar ratingBar = (RatingBar) dialog.findViewById(R.id.dialog_write_rate_simple_rating_bar);


//        Button saveBtn = (Button) dialog.findViewById(R.id.dialog_choose_persons_rooms_save_btn);



        rateCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dialogAdapterCallback.onMethodCallback(getHomeDisscoverGetItemsListData.get(position));
                dialog.cancel();
            }
        });

//        dialogImageOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                //Call
//                clientData = LoadUserData(activity);
//                clean(activity);
//                Call<RestaurantCategoryResponse> removetTokenCall = null;
//                String token=new ClientFireBaseToken().getToken();
//                String apiToken=clientData.getApiToken();
//                if (ISCLIENT.equals("true")) {
//
//                    removetTokenCall = getApiClient().clientRemoveToken(token,apiToken);
//                }  if(ISCLIENT=="false") {
//                    removetTokenCall = getApiClient().restaurantRemoveToken(token,apiToken);
//                }
//                deleteAndUpdateItemCallBack(activity,removetTokenCall);
                // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.

//                dialog.setCanceledOnTouchOutside(true);
//        ImageButton dialogImageNo = (ImageButton) dialog.findViewById(R.id.item_sign_out_dialog_btn_no);
//        dialogImageNo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.cancel();
//            }
//        });


                dialog.show();

            }


        }
