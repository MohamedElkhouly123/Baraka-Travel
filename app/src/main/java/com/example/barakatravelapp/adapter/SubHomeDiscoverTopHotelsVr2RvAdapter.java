package com.example.barakatravelapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.data.model.ItemObjectModel;
import com.example.barakatravelapp.data.model.getHotelsResponce.HotelData;
import com.example.barakatravelapp.data.model.getUmrahAndHujjResponce.GetTopUmarAndTophajjPackage;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubHomeDiscoverTopHotelsVr2RvAdapter extends RecyclerView.Adapter<SubHomeDiscoverTopHotelsVr2RvAdapter.ViewHolder> {



    private Context context;
    private Activity activity;
    private List<ItemObjectModel> itemList = new ArrayList<>();
    private List<HotelData> getHomeDisscoverGetHotelsDataItemsListData = new ArrayList<HotelData>();
    private LinearLayoutManager linearLayoutHorizental;
    private SubHomeDiscoverTopHzRvAdapter SubHomeDiscoverTopHzRvAdapter;
    private SubHomeDiscoverTopHzRvAdapter SubHomeDiscoverTopHzRvAdapter2;
    private List<HotelData> getHomeDisscoverGetHotelsMakahDataItemsListData = new ArrayList<HotelData>();
    private List<HotelData> getHomeDisscoverGetHotelsMadinaDataItemsListData = new ArrayList<HotelData>();
//    private ProfileItemAdapter homeSubHzItemAdapter;
//    private SubHomeCategoryHzRvItem2Adapter subHomeCategoryHzRvItem2Adapter;
//    List<ProductDataModel> rowListItem;
//    private ClientData clientData;
//    private ApiService apiService;

    public SubHomeDiscoverTopHotelsVr2RvAdapter(Context context,
                                                Activity activity,
                                                List<ItemObjectModel> itemList,
                                                List<HotelData> getHomeDisscoverGetHotelsMadinaDataItemsListData, List<HotelData> getHomeDisscoverGetHotelsMakahDataItemsListData) {
        this.context = context;
        this.activity = activity;
//        this.clientRestaurantsDataList.clear();
        this.itemList = itemList;
        this.getHomeDisscoverGetHotelsMakahDataItemsListData = getHomeDisscoverGetHotelsMakahDataItemsListData;
        this.getHomeDisscoverGetHotelsMadinaDataItemsListData = getHomeDisscoverGetHotelsMadinaDataItemsListData;
//        clientData = LoadUserData(activity);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_sub_hz_rv_item2,
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
            final int itemType = getItemViewType(position);
            holder.position = position;
            holder.subHomeVervItem2CategoryNameTv.setText(itemList.get(position).getName());
            if (position == 0) {
                initHozental(holder,null,getHomeDisscoverGetHotelsMakahDataItemsListData,3);
            }
            if (position == 1) {
                initHozental(holder,null, getHomeDisscoverGetHotelsMadinaDataItemsListData, 4);

            }

        } catch (Exception e) {

        }

    }


    private void setAction(final ViewHolder holder, final int position) {

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                HomeCycleActivity homeCycleActivity = (HomeCycleActivity) activity;
//                Toast.makeText(v.getContext(), "Clicked Country Position = " + position, Toast.LENGTH_SHORT).show();
//                if (position == 0) {
//                    replaceFragmentWithAnimation(homeCycleActivity.getSupportFragmentManager(), R.id.home_activity_fram, new SubCategoryFragment(), "t");
//                    homeCycleActivity.setNavigationAndToolBar(View.GONE, true);
//                }
            }
        });

    }

    private void initHozental(ViewHolder holder, List<GetTopUmarAndTophajjPackage> getHomeDisscoverGetItemsListData, List<HotelData> getHomeDisscoverGetHotelsDataItemsListData, int itemNum) {
        linearLayoutHorizental = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
        holder.subHomeVervItem2HzRv.setLayoutManager(linearLayoutHorizental);
        holder.subHomeVervItem2HzRv.setHasFixedSize(true);
//        clientGetRestaurantsFiltterList(0);

        if (itemNum ==3){
            SubHomeDiscoverTopHzRvAdapter = new SubHomeDiscoverTopHzRvAdapter(context, activity, getHomeDisscoverGetItemsListData,getHomeDisscoverGetHotelsDataItemsListData,itemNum);
            holder.subHomeVervItem2HzRv.setAdapter(SubHomeDiscoverTopHzRvAdapter);}

        if (itemNum ==4){
            SubHomeDiscoverTopHzRvAdapter2 = new SubHomeDiscoverTopHzRvAdapter(context, activity, getHomeDisscoverGetItemsListData,getHomeDisscoverGetHotelsDataItemsListData,itemNum);
            holder.subHomeVervItem2HzRv.setAdapter(SubHomeDiscoverTopHzRvAdapter2);}

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sub_home_verv_item2_category_name_tv)
        TextView subHomeVervItem2CategoryNameTv;
        @BindView(R.id.sub_home_verv_item2_hz_rv)
        RecyclerView subHomeVervItem2HzRv;
        @BindView(R.id.sub_home_verv_item2_padding_tv)
        TextView subHomeVervItem2PaddingTv;
        private View view;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);

        }
    }
}
