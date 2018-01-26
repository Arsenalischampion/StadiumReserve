package com.example.po.stadiummanagement3.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.po.stadiummanagement3.Fragment.MainFragment;
import com.example.po.stadiummanagement3.Fragment.ScheduleFragment;

public class MainActivity extends SingleFragmentActivity{                                       //Navigation Drawer是导航抽屉 设计用于应用导航
    private String phoneNum;
    @Override
    protected Fragment createFragment() {
        Bundle bundle = getIntent().getExtras();
        Bundle bundle1 = new Bundle();
        //  bundle1.putString("phoneNum",bundle.getString("phoneNum"));
        MainFragment fragment = new MainFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

}
