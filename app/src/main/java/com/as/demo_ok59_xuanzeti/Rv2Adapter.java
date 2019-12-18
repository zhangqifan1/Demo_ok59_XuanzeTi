package com.as.demo_ok59_xuanzeti;

import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

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
public class Rv2Adapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public Rv2Adapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item, item);

        TextView tv_item = helper.getView(R.id.tv_item);

        View bg_item = helper.getView(R.id.bg_item);
        DevShapeUtils.shape(DevShape.RECTANGLE)
                .radius(20)
//                .line(1, "#000000")
                .solid(R.color.hui)
                .into(bg_item);

        bg_item.setElevation(0);

        tv_item.setTextColor(mContext.getResources().getColor(R.color.black));

    }
}
