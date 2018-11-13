package com.example.a24048.travelsafely.driver;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.a24048.travelsafely.R;
import com.hankkin.library.RefreshSwipeMenuListView;
import com.hankkin.library.SwipeMenu;
import com.hankkin.library.SwipeMenuCreator;
import com.hankkin.library.SwipeMenuItem;

import java.util.ArrayList;
import java.util.List;

public class DriverHasActivity extends AppCompatActivity implements RefreshSwipeMenuListView.OnRefreshListener {

    private RefreshSwipeMenuListView rsmLv;
    private List<MsgBean> data;
    private MessageAdapter adapter;
    private int po;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_has);
        CharSequence titleLable = "已选择的乘客";
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back3);
        setTitle(titleLable);
        rsmLv = findViewById(R.id.swipe);
        data = new ArrayList<>();


        initData();

        adapter = new MessageAdapter(DriverHasActivity.this,data);

        rsmLv.setAdapter(adapter);
        rsmLv.setListViewMode(RefreshSwipeMenuListView.HEADER);
        rsmLv.setOnRefreshListener(this);

        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                // 创建滑动选项
//                SwipeMenuItem rejectItem = new SwipeMenuItem(
//                        getApplicationContext());
//                // 设置选项背景
//                rejectItem.setBackground(new ColorDrawable(getResources().getColor(R.color.red)));
//                // 设置选项宽度
//                rejectItem.setWidth(dp2px(80,getApplicationContext()));
//                // 设置选项标题
//                rejectItem.setTitle("添加");
//                // 设置选项标题
//                rejectItem.setTitleSize(16);
//                // 设置选项标题颜色
//                rejectItem.setTitleColor(Color.WHITE);
//                // 添加选项
//                menu.addMenuItem(rejectItem);

                // 创建删除选项
                SwipeMenuItem argeeItem = new SwipeMenuItem(getApplicationContext());
                argeeItem.setBackground(new ColorDrawable(getResources().getColor(R.color.green)));
                argeeItem.setWidth(dp2px(80, getApplicationContext()));
                argeeItem.setTitle("删除");
                argeeItem.setTitleSize(16);
                argeeItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(argeeItem);
            }
        };

        rsmLv.setMenuCreator(creator);

        rsmLv.setOnMenuItemClickListener(new RefreshSwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0: //第一个选项
                        Toast.makeText(DriverHasActivity.this,"您点击的是置顶",Toast.LENGTH_SHORT).show();
                        break;
                    case 1: //第二个选项
                        del(position,rsmLv.getChildAt(position+1-rsmLv.getFirstVisiblePosition()));
                        break;

                }
            }
        });

    }


    private void initData(){
        MsgBean msgBean = new MsgBean();
        msgBean.setName("王天锐");
        msgBean.setContent("中北大学→柳巷");
        msgBean.setTime("10 : 30-10 : 50");
        data.add(msgBean);
        MsgBean msgBean2 = new MsgBean();
        msgBean2.setName("郑豪");
        msgBean2.setContent("中北大学→太原南站");
        msgBean2.setTime("10 : 10-10 : 20");
        data.add(msgBean2);

    }

    /**
     * 删除item动画
     * @param index
     * @param v
     */
    private void del(final int index, View v){
        final Animation animation = (Animation) AnimationUtils.loadAnimation(v.getContext(), R.anim.list_anim);
        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                data.remove(index);
                po = index;
                adapter.notifyDataSetChanged();
                animation.cancel();
            }
        });

        v.startAnimation(animation);
    }


    @Override
    public void onRefresh() {
        rsmLv.postDelayed(new Runnable() {
            @Override
            public void run() {
                rsmLv.complete();
                Toast.makeText(DriverHasActivity.this,"已完成",Toast.LENGTH_SHORT).show();
            }
        },2000);
    }

    @Override
    public void onLoadMore() {
        rsmLv.postDelayed(new Runnable() {
            @Override
            public void run() {
                rsmLv.complete();
                Toast.makeText(DriverHasActivity.this,"已完成",Toast.LENGTH_SHORT).show();
            }
        },2000);

    }

    public  int dp2px(int dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
