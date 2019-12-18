package com.as.demo_ok59_xuanzeti;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.shape.DevShape;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/12/17.
 * ---------------------------
 */
public class RvAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public RvAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item, item);
        DevShapeUtils.shape(DevShape.RECTANGLE)
                .radius(20)
                .line(1, "#000000")
                .solid("#B0A3A3")
                .into(helper.getView(R.id.bg_item));
    }
}
