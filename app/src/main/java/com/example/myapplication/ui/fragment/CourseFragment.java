package com.example.myapplication.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adaper.IndexAdapter;
import com.example.myapplication.app.Constant;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.bean.IndexBean;
import com.example.myapplication.interfaces.IBasePresenter;
import com.example.myapplication.interfaces.contract.IndexConstract;
import com.example.myapplication.presenter.home.IndexPresenter;
import com.example.myapplication.widgets.DrawableCenterTextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class CourseFragment extends BaseFragment implements IndexConstract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    int curType = 1;
    @BindView(R.id.txt_type_1)
    DrawableCenterTextView txtType1;
    @BindView(R.id.txt_type_2)
    DrawableCenterTextView txtType2;
    @BindView(R.id.txt_type_3)
    DrawableCenterTextView txtType3;

    IndexAdapter indexAdapter;
    List<IndexBean.DataBean.CurriculumDataBean> list;
    @Override
    protected IBasePresenter getPresenter() {
        return new IndexPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_course;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        indexAdapter = new IndexAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(indexAdapter);

        curType = Constant.STUDY_TYPE_1;
        resetTypeTxt();
        txtType1.setTextColor(getResources().getColor(R.color.red));
        getIndex();
    }

    @OnClick({R.id.txt_type_1, R.id.txt_type_2, R.id.txt_type_3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_type_1:
                curType = Constant.STUDY_TYPE_1;
                resetTypeTxt();
                txtType1.setTextColor(getResources().getColor(R.color.red));
                getIndex();
                break;
            case R.id.txt_type_2:
                curType = Constant.STUDY_TYPE_2;
                resetTypeTxt();
                txtType2.setTextColor(getResources().getColor(R.color.red));
                getIndex();
                break;
            case R.id.txt_type_3:
                curType = Constant.STUDY_TYPE_3;
                resetTypeTxt();
                txtType3.setTextColor(getResources().getColor(R.color.red));
                getIndex();
                break;
        }

    }

    private void getIndex() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("curriculum", String.valueOf(2));
        map.put("type", String.valueOf(curType));
        map.put("page", "1");
        ((IndexPresenter) mPresenter).getIndex(map);
    }

    @Override
    public void getIndexReturn(IndexBean result) {
        list.clear();
        list.addAll(result.getData().getCurriculum_data());
        indexAdapter.notifyDataSetChanged();
    }


    private void resetTypeTxt() {
        txtType1.setTextColor(getResources().getColor(R.color.black));
        txtType2.setTextColor(getResources().getColor(R.color.black));
        txtType3.setTextColor(getResources().getColor(R.color.black));
    }
}
