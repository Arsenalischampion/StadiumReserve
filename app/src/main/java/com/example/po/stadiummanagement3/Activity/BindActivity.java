package com.example.po.stadiummanagement3.Activity;

import android.support.v4.app.Fragment;

import com.example.po.stadiummanagement3.Fragment.BindFragment;

/**
 * Created by 13701 on 2018/1/11.
 */

public class BindActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new BindFragment();
    }
}
