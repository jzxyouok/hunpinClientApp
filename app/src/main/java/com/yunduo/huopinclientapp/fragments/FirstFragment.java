package com.yunduo.huopinclientapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yunduo.huopinclientapp.R;
import com.yunduo.huopinclientapp.domain.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class FirstFragment extends Fragment {

    public FirstFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        return view;
    }


}
