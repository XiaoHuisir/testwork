package com.example.myapplication.ui.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.adaper.IndexAdapter;
import com.example.myapplication.app.Constant;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.bean.IndexBean;
import com.example.myapplication.interfaces.IBasePresenter;
import com.example.myapplication.interfaces.contract.IndexConstract;
import com.example.myapplication.presenter.home.IndexPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class Home_Fragment extends BaseFragment {

    @BindView(R.id.txt_course_1)
    TextView txt_course_1;
    @BindView(R.id.txt_course_2)
    TextView txt_course_2;

    int curCourse = 2;



    private CourseFragment courseFragment;
    private StudyFragment studyFragment;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_;

    }

    @Override
    protected void initView() {
        courseFragment = new CourseFragment();
        studyFragment = new StudyFragment();

        showCourse();
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.txt_course_1, R.id.txt_course_2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_course_1:
                Constant.CourseType = Constant.COURSE_TYPE_2;
                resetCourseTxt();
                txt_course_1.setTextColor(getResources().getColor(R.color.red));
                showCourse();
                break;
            case R.id.txt_course_2:
                Constant.CourseType = Constant.COURSE_TYPE_1;
                resetCourseTxt();
                txt_course_2.setTextColor(getResources().getColor(R.color.red));
                showStudy();
                break;

        }

    }

    private void showCourse(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentBox,courseFragment).commit();
    }

    private void showStudy(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentBox,studyFragment).commit();
    }



    private void resetCourseTxt() {
        txt_course_1.setTextColor(getResources().getColor(R.color.black));
        txt_course_2.setTextColor(getResources().getColor(R.color.black));
    }
}
