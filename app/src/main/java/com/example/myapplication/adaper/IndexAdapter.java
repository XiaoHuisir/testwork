package com.example.myapplication.adaper;
import android.support.constraint.ConstraintLayout;
import android.support.design.shape.RoundedCornerTreatment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseAdapter;
import com.example.myapplication.bean.IndexBean;

import java.util.List;

public class IndexAdapter extends BaseAdapter {

    public IndexItemClick itemClick;

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
        String progress = ((int)(Float.valueOf(bean.getJd())*100))+"%";
        txt_study_state.setText(progress);

        ConstraintLayout layout = (ConstraintLayout) holder.getView(R.id.layout_item);
        layout.setTag(String.valueOf(bean.getId()));
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = (String) v.getTag();
                if(itemClick != null){
                    itemClick.click(id);
                }
            }
        });
    }


    public interface IndexItemClick{
        void click(String id);
    }

}
