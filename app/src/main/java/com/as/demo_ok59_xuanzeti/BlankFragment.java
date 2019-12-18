package com.as.demo_ok59_xuanzeti;


import android.animation.Animator;
import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.as.demo_ok59_xuanzeti.base_ui.fragment.BaseFragment;
import com.as.demo_ok59_xuanzeti.bean.DataBean;
import com.as.demo_ok59_xuanzeti.databinding.FragmentBlankBinding;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.shape.DevShape;

import java.io.Serializable;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment<FragmentBlankBinding> {



    boolean isRifht = false;

    private DataBean data;
    private CountDownTimer countDownTimer;
    private int i;
    private boolean canclick = false;

    public static BlankFragment getInstance(DataBean dataBean) {
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", dataBean);
        blankFragment.setArguments(bundle);
        return blankFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    public void initView(View rootView) {
        data = (DataBean) getArguments().getSerializable("data");
        mViewBinding.tvTitle.setText(data.getTitle());

        List<String> contents = data.getContents();
        final int rightChoose = data.getRightChoose();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        final RvAdapter rvAdapter = new RvAdapter(R.layout.item, contents);
        mViewBinding.rv.setLayoutManager(layoutManager);
        mViewBinding.rv.setAdapter(rvAdapter);
        mViewBinding.rv.setClickable(false);

        rvAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                // 点完之后不可点击
                if (!canclick) {
                    return;
                }
                final int usetime = BlankFragment.this.time;

                canclick = false;

                View bg_item = view.findViewById(R.id.bg_item);
                TextView tv_item = view.findViewById(R.id.tv_item);

                if (position == rightChoose) {
                    ToastUtils.showShort("对了");
                    DevShapeUtils.shape(DevShape.RECTANGLE)
                            .radius(20)
                            .line(1, "#000000")
                            .solid(R.color.green)
                            .into(bg_item);
                    isRifht = true;

                } else {
                    ToastUtils.showShort("错了");

                    DevShapeUtils.shape(DevShape.RECTANGLE)
                            .radius(20)
                            .line(1, "#000000")
                            .solid(R.color.red)
                            .into(bg_item);

                    View trueView = adapter.getViewByPosition(mViewBinding.rv, rightChoose, R.id.bg_item);

                    DevShapeUtils.shape(DevShape.RECTANGLE)
                            .radius(20)
                            .line(1, "#000000")
                            .solid(R.color.green)
                            .into(trueView);

                    isRifht = false;

                }

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);
                        if (ilistener != null) {
                            ilistener.listener(isRifht,usetime);
                        }
                    }
                }.execute();


            }
        });
        YoYo.with(Techniques.FadeOut)
                .duration(1200)
                .repeat(0)
                .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
                .interpolate(new AccelerateDecelerateInterpolator())
                .playOn(mViewBinding.tvTitle);


    }

    int time = 0;

    @Override
    protected void initData() {

        countDownTimer = new CountDownTimer(10 * 1000, 1000) {

            @Override
            public void onTick(long l) {
                if (mViewBinding.tvTime != null) {
                    mViewBinding.tvTime.setText(10 - time + "");
                    time++;
                }
            }

            @Override
            public void onFinish() {
                if (ilistener != null) {
                    ilistener.listener(false,10);
                }
            }
        };

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();


        YoYo.with(Techniques.SlideInLeft)
                .duration(1200)
                .repeat(0)
                .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
                .interpolate(new AccelerateDecelerateInterpolator())
                .playOn(mViewBinding.tvTitle);

        YoYo.with(Techniques.FadeInUp)
                .duration(1200)
                .repeat(0)
                .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
                .interpolate(new AccelerateDecelerateInterpolator())
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        if (countDownTimer != null) {
                            countDownTimer.start();
                            canclick = true;
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                .playOn(mViewBinding.rv);


    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();

        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }

    }

    public interface Ilistener {
        void listener(boolean isRight,int usetime);
    }

    private Ilistener ilistener;

    public void setIlistener(Ilistener ilistener) {
        this.ilistener = ilistener;
    }
}
