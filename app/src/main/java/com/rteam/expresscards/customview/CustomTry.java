package com.rteam.expresscards.customview;


import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.rteam.expresscards.R;

/**
 * created by Karim Mammadzada 01.05.22
 * Casino Wheel V1.
 */
public class CustomTry extends View implements View.OnTouchListener {

    //private float mBearing;
    private Paint mCirclePaint;
    private Paint mSectorPaint;
    private Paint mTextPaint;
    protected int mCenterX, mCenterY;
    private  int mRadius;
    private RectF mRectF;
     private int [] mColorArr;
  //  private LinearGradient[] mShaderArr;
    private int mViewWidth, mViewHeight;
    private final int TEXT_SIZE = 30;



    public CustomTry(Context context) {
        super(context);
        initLuckyWheel();
    }

    public CustomTry(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLuckyWheel();
    }

    public CustomTry(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLuckyWheel();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // take the smallest size
        int size = Math.min(measure(widthMeasureSpec), measure(heightMeasureSpec));
        setMeasuredDimension(size, size);
    }

    private int measure(int measureSpec) {
        int result;
        // decoding measureSpec
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.UNSPECIFIED) {
            result = 200;
        } else {
            result = specSize;
        }

        return result;
    }

    private void initLuckyWheel() {
        setFocusable(true);
        setOnTouchListener(this);
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(ContextCompat.getColor(getContext(), android.R.color.white));
        mCirclePaint.setStrokeWidth(9);
        mCirclePaint.setStyle(Paint.Style.STROKE);

        mSectorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSectorPaint.setStyle(Paint.Style.STROKE);
        mSectorPaint.setStrokeWidth(100);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(TEXT_SIZE);
        mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);

            mColorArr  = new int[] {R.color.bluesection, R.color.greensection,R.color.lightbluesection, R.color.orangesection,R.color.pinksection, R.color.yellowsection};

    }

    private void calculateCircleParams() {
        mViewWidth = getMeasuredWidth();
        mViewHeight = getMeasuredHeight();
        mCenterX = mViewWidth / 2;
        mCenterY = mViewHeight / 2;
        mRadius = (int)(0.8 * Math.min(mCenterX, mCenterY));
        mRectF = new RectF(mCenterX - mRadius, mCenterY - mRadius,
                mCenterX + mRadius, mCenterY +mRadius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("AAAAAAAAAAAAAAAAAA", "from onDraw");
        if (mRadius == 0) {
            calculateCircleParams();
        }
        canvas.drawCircle(mCenterX, mCenterY, mRadius, mCirclePaint);

        int angleStep = 360 / mColorArr.length;
        int initialAngle = 180 - angleStep/2;
        int sectionGap = 1;
        for (int i = 0; i < mColorArr.length; i++) {
                mSectorPaint.setColor(ContextCompat.getColor(getContext(),mColorArr[i]));
            //mSectorPaint.setShader(mShaderArr[i]);
            canvas.drawArc(mRectF, initialAngle,angleStep-sectionGap, false, mSectorPaint) ;


          //  canvas.drawText("OPTION " + i, mViewWidth / 2f - mRadius * 0.9f, mViewHeight / 2f + TEXT_SIZE / 2, mTextPaint);

            canvas.rotate(-angleStep, mCenterX, mCenterY);
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onTouch(View v,MotionEvent event){
       float viewX= v.getX();
        float viewY=v.getY();
        float eventX=event.getX();
        float eventY=event.getY();
        Log.e("test viewx",Float.toString(viewX));
        Log.e("test viewy",Float.toString(viewY));
        Log.e("test eventx",Float.toString(eventX));
        Log.e("test eventy",Float.toString(eventY));



        return false;
    }


}

