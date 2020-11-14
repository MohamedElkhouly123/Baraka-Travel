package com.example.barakatravelapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barakatravelapp.R;
import com.example.barakatravelapp.data.model.ItemObjectModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubHomeDiscoverVrRvAdapter extends RecyclerView.Adapter<SubHomeDiscoverVrRvAdapter.ViewHolder> {



    private Context context;
    private Activity activity;
    private List<ItemObjectModel> itemList = new ArrayList<>();
    private LinearLayoutManager lLayout;
//    private ProfileItemAdapter homeSubHzItemAdapter;
//    private SubHomeCategoryHzRvItem2Adapter subHomeCategoryHzRvItem2Adapter;
//    List<ProductDataModel> rowListItem;
//    private ClientData clientData;
//    private ApiService apiService;

    public SubHomeDiscoverVrRvAdapter(Context context,
                                      Activity activity,
                                      List<ItemObjectModel> itemList
    ) {
        this.context = context;
        this.activity = activity;
//        this.clientRestaurantsDataList.clear();
        this.itemList = itemList;
//        clientData = LoadUserData(activity);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_sub_hz_rv_item,
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
            holder.homeDiscoverFragmentSubHomeRvItemTv.setText(itemList.get(position).getName());
            if (position == 2) {
                holder.homeDiscoverFragmentSubHomeRvItemVrRv.setVisibility(View.VISIBLE);

            } else {
                holder.homeDiscoverFragmentSubHomeRvItemHzSrVw.setVisibility(View.VISIBLE);

            }

//            rowListItem = getAllItemList();
//            if (itemType == 1) {
////            ((MyNormalViewHolder)holder).bindData((MyModel)myData[position]);
//
//                holder.subHomeCategoryHzRvItem2CategoryNameTv.setText(itemList.get(position).getName());
//                lLayout = new LinearLayoutManager(activity);
//                holder.subHomeCategory2HzRvRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
//
//                subHomeCategoryHzRvItem2Adapter = new SubHomeCategoryHzRvItem2Adapter(context, activity, rowListItem);
//                holder.subHomeCategory2HzRvRecyclerView.setAdapter(subHomeCategoryHzRvItem2Adapter);
//
//                // 5. set item animator to DefaultAnimator
//                holder.subHomeCategory2HzRvRecyclerView.setItemAnimator(new DefaultItemAnimator());
//
//                if( position == getItemCount() - 1 ){
//                    holder.subHomeCategoryHzRvItem2PaddingTv.setVisibility(View.VISIBLE);
//                }else {
//                    holder.subHomeCategoryHzRvItem2PaddingTv.setVisibility(View.GONE);
//
//                }
//            } else if (itemType == 0) {
////            ((MyHeaderViewHolder)holder).setHeaderText((String)myData[position]);
//                holder.subHomeCategoryHzRvItemCategoryNameTv.setText(itemList.get(position).getName());
//                lLayout = new LinearLayoutManager(activity);
//                holder.subHomeCategoryHzRvRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
//
//                homeSubHzItemAdapter = new ProfileItemAdapter(context, activity, rowListItem);
//                holder.subHomeCategoryHzRvRecyclerView.setAdapter(homeSubHzItemAdapter);
//
//                // 5. set item animator to DefaultAnimator
//                holder.subHomeCategoryHzRvRecyclerView.setItemAnimator(new DefaultItemAnimator());
//
//                if( position == getItemCount() - 1 ){
//                    holder.subHomeCategoryHzRvItemPaddingTv.setVisibility(View.VISIBLE);
//                }else {
//                    holder.subHomeCategoryHzRvItemPaddingTv.setVisibility(View.GONE);
//
//                }
//
//            }
//
//
//
//            if (position==0) {
//                holder.subHomeCategory2HzRvUltraViewpagerCardView.setVisibility(View.VISIBLE);
//                // init all widgets in this activity
////        UltraViewPager fragmentImportantAdsUltraViewpager = (UltraViewPager)findViewById(R.id.ultra_viewpager);
//                holder.subHomeCategory2HzRvUltraViewpager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
////initialize ProductDetailsUltraPagerAdapter，and add child view to UltraViewPager
//                PagerAdapter adapter = new ImportantAdsAndHomeAdsUltraPagerAdapter(false);
//                holder.subHomeCategory2HzRvUltraViewpager.setAdapter(adapter);
//
////initialize built-in indicator
//                holder.subHomeCategory2HzRvUltraViewpager.initIndicator();
////set style of indicators
//                holder.subHomeCategory2HzRvUltraViewpager.getIndicator()
//                        .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
//                        .setFocusColor(Color.parseColor("#FC3D04"))
//                        .setNormalColor(Color.WHITE)
//                        .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, activity.getResources().getDisplayMetrics()));
////set the alignment
//                holder.subHomeCategory2HzRvUltraViewpager.getIndicator().setGravity(Gravity.CENTER | Gravity.BOTTOM);
//                holder.subHomeCategory2HzRvUltraViewpager.getIndicator().setMargin(0, 0, 0, 35);
//
////construct built-in indicator, and add it to  UltraViewPager
//                holder.subHomeCategory2HzRvUltraViewpager.getIndicator().build();
//
////set an infinite loop
//                holder.subHomeCategory2HzRvUltraViewpager.setInfiniteLoop(true);
////enable auto-scroll mode
//                holder.subHomeCategory2HzRvUltraViewpager.setAutoScroll(4000);
//            }else {
//                holder.subHomeCategory2HzRvUltraViewpagerCardView.setVisibility(View.GONE);

//            }
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

//    private List<ProductDataModel> getAllItemList() {
//
//        rowListItem = new ArrayList<ProductDataModel>();
//        rowListItem.add(new ProductDataModel("سكر", "55 ج", R.drawable.flat));
//        rowListItem.add(new ProductDataModel("سكر", "55 ج", R.drawable.chale));
//        rowListItem.add(new ProductDataModel("سكر", "55 ج", R.drawable.chale));
//        rowListItem.add(new ProductDataModel("سكر", "55 ج", R.drawable.flat));
//        rowListItem.add(new ProductDataModel("سكر", "55 ج", R.drawable.flat));
//        rowListItem.add(new ProductDataModel("سكر", "55 ج", R.drawable.flat));
//        rowListItem.add(new ProductDataModel("سكر", "55 ج", R.drawable.chale));
//
//
//        return rowListItem;
//    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_discover_fragment_sub_home_rv_item_tv)
        TextView homeDiscoverFragmentSubHomeRvItemTv;
        @BindView(R.id.home_discover_fragment_sub_home_rv_item_hz_rv)
        RecyclerView homeDiscoverFragmentSubHomeRvItemHzRv;
        @BindView(R.id.home_discover_fragment_sub_home_rv_item_hz_sr_vw)
        ScrollView homeDiscoverFragmentSubHomeRvItemHzSrVw;
        @BindView(R.id.home_discover_fragment_sub_home_rv_item_vr_rv)
        RecyclerView homeDiscoverFragmentSubHomeRvItemVrRv;
        @BindView(R.id.sub_home_verv_item_padding_tv)
        TextView subHomeVervItemPaddingTv;
        private View view;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);

        }
    }
}
