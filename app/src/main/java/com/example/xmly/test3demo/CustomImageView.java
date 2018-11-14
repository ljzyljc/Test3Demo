package com.example.xmly.test3demo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CustomImageView extends ImageView {
    private ObjectAnimator objectAnimator1;
    private ObjectAnimator objectAnimator2;
    private ObjectAnimator objectAnimator3;
    private ObjectAnimator objectAnimator4;
    private static final String TAG = "CustomImageView";
    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        objectAnimator1 = ObjectAnimator.ofFloat(this,"width",0F,120f);
        objectAnimator1.setDuration(1000);
        objectAnimator2 = ObjectAnimator.ofFloat(this,"width",120F,0f);
        objectAnimator2.setDuration(1000);
        objectAnimator3 = ObjectAnimator.ofFloat(this,"width",160,0f);
        objectAnimator3.setDuration(1000);
        objectAnimator4 = ObjectAnimator.ofFloat(this,"width",0F,160f);
        objectAnimator4.setDuration(1000);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setWidth(float width) {
        Log.i(TAG, "CustomImageView: --------"+width);
//        ViewGroup.LayoutParams layoutParams = getLayoutParams();
//        layoutParams.width = (int) width;
//        this.setLayoutParams(layoutParams);

        this.getLayoutParams().width = (int) width;
        this.requestLayout();
        if (this.getLayoutParams().width == 0){
            setVisibility(INVISIBLE);
        }else{
            setVisibility(VISIBLE);
        }
        Log.i(TAG, "setWidth: "+this.getLayoutParams().width);
//        this.invalidate();
    }

    public void startAnimator(){
        if (objectAnimator1 == null || objectAnimator1.isRunning()){
            return;
        }
        objectAnimator1.start();
        this.setVisibility(View.VISIBLE);
    }
    public void startAnimator2(){
        if (objectAnimator2 == null || objectAnimator2.isRunning()){
            return;
        }
        objectAnimator2.start();
        this.setVisibility(View.VISIBLE);
    }

    public void startAnimator3(){
        if (objectAnimator3 == null || objectAnimator3.isRunning()){
            return;
        }
        objectAnimator3.start();
        this.setVisibility(View.VISIBLE);
    }
    public void startAnimator4(){
        if (objectAnimator4 == null || objectAnimator4.isRunning()){
            return;
        }
        objectAnimator4.start();
        this.setVisibility(View.VISIBLE);
    }


}
