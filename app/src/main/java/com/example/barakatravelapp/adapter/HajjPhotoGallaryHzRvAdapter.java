package com.example.barakatravelapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.data.model.getUmrahAndHujjResponce.GetTopUmarAndTophajjPackage;
import com.example.barakatravelapp.utils.PhotoGallaryAdapterCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.barakatravelapp.utils.HelperMethod.onLoadImageFromUrl;
import static com.example.barakatravelapp.utils.HelperMethod.showToast;

public class HajjPhotoGallaryHzRvAdapter extends RecyclerView.Adapter<HajjPhotoGallaryHzRvAdapter.ViewHolder> {


//    private final DialogAdapterCallback dialogAdapterCallback;

    private Context context;
    private Activity activity;
    private LinearLayoutManager lLayout;
    private int itemNum;
    private List<String> hajjAndUmrahImages= new ArrayList<>();
    private PhotoGallaryAdapterCallback photoGallaryAdapterCallback;

//    private ProfileItemAdapter homeSubHzItemAdapter;
//    private SubHomeCategoryHzRvItem2Adapter subHomeCategoryHzRvItem2Adapter;
//    List<ProductDataModel> rowListItem;
//    private ClientData clientData;
//    private ApiService apiService;

    public HajjPhotoGallaryHzRvAdapter(Context context, Activity activity,
                                       List<String> hajjAndUmrahImages,PhotoGallaryAdapterCallback photoGallaryAdapterCallback
                                       ) {
        this.context = context;
        this.activity = activity;
//        this.clientRestaurantsDataList.clear();
        this.hajjAndUmrahImages = hajjAndUmrahImages;
        this.photoGallaryAdapterCallback=photoGallaryAdapterCallback;
//        this.dialogAdapterCallback = dialogAdapterCallback;
//        showToast(activity, "list=" + getHomeDisscoverGetHotelsDataItemsListData.get(0).getCity());

//        showToast(activity, String.valueOf(itemNum));
//        clientData = LoadUserData(activity);

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_hz_hajj_details_photo_gallery_item,
                parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        setData(holder, position);
        setAction(holder, position);

    }

    private void setData(ViewHolder holder, int position) {
        try {
//            final int itemType = getItemViewType(position);
            holder.position = position;

//            GetTopUmarAndTophajjPackage getTopUmarAndTophajjPackageData = getTopUmarAndTophajjPackages;
//            showToast(activity, String.valueOf(position));
//            hajjAndUmrahImages = getTopUmarAndTophajjPackages.getUmarImages();
            onLoadImageFromUrl(holder.cardviewHzHajjDetailsPhotoGalleryItemImg, hajjAndUmrahImages.get(position).trim(), context);


        } catch (Exception e) {

        }

    }


    private void setAction(final ViewHolder holder, final int position) {

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showToast(activity, "here");
                String photoPath =hajjAndUmrahImages.get(position).trim();
                photoGallaryAdapterCallback.onMethodCallback(photoPath);
//                ZoomInImageViewAttacher mIvAttacter = new ZoomInImageViewAttacher();
//                mIvAttacter.attachImageView(holder.cardviewHzHajjDetailsPhotoGalleryItemImg);
//                ZoomInImageViewAttacher mIvAttacter = new ZoomInImageViewAttacher(holder.cardviewHzHajjDetailsPhotoGalleryItemImg);
//                dialogAdapterCallback.onMethodCallback(getTopUmarAndTophajjPackages.get(position));

//                HomeCycleActivity homeCycleActivity = (HomeCycleActivity) activity;
//                Toast.makeText(v.getContext(), "Clicked Country Position = " + position, Toast.LENGTH_SHORT).show();
//                if (position == 0) {
//                    replaceFragmentWithAnimation(homeCycleActivity.getSupportFragmentManager(), R.id.home_activity_fram, new SubCategoryFragment(), "t");
//                    homeCycleActivity.setNavigationAndToolBar(View.GONE, true);
//                }
            }
        });

    }


    @Override
    public int getItemCount() {

        return hajjAndUmrahImages.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cardview_hz_hajj_details_photo_gallery_item_img)
        ImageView cardviewHzHajjDetailsPhotoGalleryItemImg;
        private View view;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);

        }
    }
}
