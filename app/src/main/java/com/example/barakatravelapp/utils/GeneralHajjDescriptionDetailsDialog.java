package com.example.barakatravelapp.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.data.model.getUmrahAndHujjResponce.GetTopUmarAndTophajjPackage;


public class GeneralHajjDescriptionDetailsDialog {
    private static int adultNum;
    private DialogAdapterCallback dialogAdapterCallback;

    public void showDialog(final Activity activity, GetTopUmarAndTophajjPackage getTopUmarAndTophajjPackage, String btnName) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_general_hajj_details_description);
        dialog.setCanceledOnTouchOutside(true);

        adultNum=0;

        TextView descriptionTv = (TextView) dialog.findViewById(R.id.dialog_general_hajj_details_description_tv);
        ImageView detailsCloseBtn = (ImageView) dialog.findViewById(R.id.dialog_general_hajj_details_description_cancel_btn);
        if(btnName.equalsIgnoreCase("makka")){
        descriptionTv.setText(Html.fromHtml(Html.fromHtml(getTopUmarAndTophajjPackage.getUmar().getMakkahDesciption()).toString()));
        }
        if(btnName.equalsIgnoreCase("madina")){
            descriptionTv.setText(Html.fromHtml(Html.fromHtml(getTopUmarAndTophajjPackage.getUmar().getMadinaDesciption()).toString()));
        }
        if(btnName.equalsIgnoreCase("manasik")){
            descriptionTv.setText(Html.fromHtml(Html.fromHtml(getTopUmarAndTophajjPackage.getUmar().getRituals()).toString()));
        }
        if(btnName.equalsIgnoreCase("air")){
            descriptionTv.setText(Html.fromHtml(Html.fromHtml(getTopUmarAndTophajjPackage.getUmar().getFlighting()).toString()));
        }


        detailsCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dialogAdapterCallback.onMethodCallback(getHomeDisscoverGetItemsListData.get(position));
                dialog.cancel();
            }
        });




                dialog.show();

            }


        }
