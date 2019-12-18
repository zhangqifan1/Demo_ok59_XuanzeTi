package com.as.demo_ok59_xuanzeti;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class RightOrLeftView extends View {

    private Paint mPaint;
    private Path mPath;
    private ValueAnimator mAnimator;

    //可以主动传进来
    private int width;
    private int height;
    private Paint mCircleStrokePaint;
    private Paint mCirclePaint;
    private boolean mIsStart = false;

    private int mCircleRightColor=Color.GREEN;
    private int mPathRightColor=Color.WHITE;

    private int mCircleLeftColor=Color.WHITE;
    private int mPathLeftColor=Color.RED;

    private boolean mIsRight;

    public RightOrLeftView(Context context) {
        this(context, null);
    }

    public RightOrLeftView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public RightOrLeftView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        mPath = new Path();

        width = dip2px(context, 60);
        height = dip2px(context, 60);

        //对号
        initStrokePaint();
        initCirclePaint();
        initPath();


        PathMeasure mPathMeasure = new PathMeasure(mPath, false);
        final float length = mPathMeasure.getLength();


        mAnimator = ValueAnimator.ofFloat(1, 0);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.setDuration(1000);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = (float) animation.getAnimatedValue();
                DashPathEffect mEffect = new DashPathEffect(new float[]{length, length}, fraction * length);
                mPaint.setPathEffect(mEffect);
                invalidate();
            }
        });

    }

    private void initPath() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mIsRight?mPathRightColor:mPathLeftColor);

        if(mIsRight){
            mPath.reset();
            mPath.moveTo(width * 0.3f, height * 0.5f);
            mPath.quadTo(width / 2f, height + 10, width * 0.7f, height * 1 / 4);
        }else {
            mPath.reset();
            mPath.moveTo(width * 0.7f, height * 0.3f);
            mPath.lineTo(width * 0.3f, height * 0.7f);

            mPath.moveTo(width * 0.3f, height * 0.3f);
            mPath.lineTo(width * 0.7f, height * 0.7f);
        }

    }

    private void initStrokePaint() {
        mCircleStrokePaint = new Paint();
        mCircleStrokePaint.setDither(true);
        mCircleStrokePaint.setAntiAlias(true);
        mCircleStrokePaint.setColor(Color.BLACK);
        mCircleStrokePaint.setStyle(Paint.Style.STROKE);
        mCircleStrokePaint.setStrokeWidth(2);
    }

    private void initCirclePaint() {
        mCirclePaint = new Paint();
        mCirclePaint.setDither(true);
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(mIsRight?mCircleRightColor:mCircleLeftColor);
        mCirclePaint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画对号
        if (mIsStart) {
            //画空心圆
            canvas.drawCircle(width / 2, width / 2, width / 2 - 10, mCirclePaint);
            //画实心圆
            canvas.drawCircle(width / 2, width / 2, width / 2 - 10, mCircleStrokePaint);
            canvas.drawPath(mPath, mPaint);
        }

    }

    public void start() {
        mIsStart = true;
        mAnimator.start();
    }

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public void setmIsRight(boolean mIsRight) {
        this.mIsRight = mIsRight;
    }
}