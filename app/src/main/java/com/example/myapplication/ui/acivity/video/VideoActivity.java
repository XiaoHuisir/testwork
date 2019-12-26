package com.example.myapplication.ui.acivity.video;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adaper.PdfAdapter;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.bean.CurriculumBean;
import com.example.myapplication.interfaces.IBasePresenter;
import com.example.myapplication.interfaces.contract.CurriculumConstract;
import com.example.myapplication.presenter.curriculum.CurriculumPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoActivity extends BaseActivity implements CurriculumConstract.View {
    @BindView(R.id.videoplayer)
    JZVideoPlayerStandard videoplayer;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_work)
    TextView txtWork;
    @BindView(R.id.txt_detail)
    TextView txtDetail;
    @BindView(R.id.layout_info)
    ConstraintLayout layoutInfo;
    @BindView(R.id.txt_study_title)
    TextView txtStudyTitle;
    @BindView(R.id.pdf_recyclerview)
    RecyclerView pdfRecyclerview;

    String curriulumId;
    CurriculumBean curriculumBean;

    PdfAdapter pdfAdapter;
    List<CurriculumBean.DataBean.FileDataBean> pdfList;


    @Override
    protected IBasePresenter getPresenter() {
        return new CurriculumPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_info;
    }

    @Override
    protected void initView() {
        pdfList = new ArrayList<>();
        pdfAdapter = new PdfAdapter(pdfList);
        pdfRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        pdfRecyclerview.setAdapter(pdfAdapter);

    }

    @Override
    protected void initData() {
        curriulumId = getIntent().getStringExtra("curriulum_id");
        ((CurriculumPresenter)mPresenter).getCurriculum(curriulumId);
    }

    @Override
    public void getCurriculumReturn(CurriculumBean bean) {
        curriculumBean = bean;
        String video_url = curriculumBean.getData().getCurriculum_data().getVideo_url_code();
        if(!TextUtils.isEmpty(video_url)){
            videoplayer.setUp(video_url,JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,"");
        }
        txtTitle.setText(curriculumBean.getData().getCurriculum_data().getTitle());
        txtName.setText(curriculumBean.getData().getCurriculum_data().getTeacher());
        txtWork.setText(curriculumBean.getData().getCurriculum_data().getGs());

        pdfList.clear();
        pdfList.addAll(bean.getData().getFile_data());
        pdfAdapter.notifyDataSetChanged();


    }
}
