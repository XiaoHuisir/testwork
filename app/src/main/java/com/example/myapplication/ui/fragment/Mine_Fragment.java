package com.example.myapplication.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.interfaces.IBasePresenter;

public class Mine_Fragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_, container, false);
    }

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

}
