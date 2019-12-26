package com.example.myapplication.adaper;
import android.support.design.shape.RoundedCornerTreatment;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseAdapter;
import com.example.myapplication.bean.IndexBean;

import java.util.List;

public class IndexAdapter extends BaseAdapter {


    public IndexAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_item_index;
    }

    @Override
    protected void bindData(BaseAdapter.BaseViewHolder holder, int positon, Object o) {
        IndexBean.DataBean.CurriculumDataBean bean = (IndexBean.DataBean.CurriculumDataBean) mDatas.get(positon);
        TextView txt_title = (TextView) holder.getView(R.id.txt_title);
        txt_title.setText(bean.getTitle());
        ImageView img_icon = (ImageView)holder.getView(R.id.img_icon);
        Glide.with(mContext).load(bean.getLog())
                .transform(new RoundedCorners(5))
                .into(img_icon);

        TextView txt_name = (TextView) holder.getView(R.id.txt_name);
        txt_name.setText(bean.getTeacher());
        TextView txt_work = (TextView) holder.getView(R.id.txt_work);
        txt_work.setText(bean.getGs());

        TextView txt_study_state = (TextView)holder.getView(R.id.txt_study_state);
        txt_study_state.setText(bean.getJd());
    }

}
